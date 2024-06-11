package com.example.skinwise.ui.Result

import android.content.Context
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.SystemClock
import android.provider.MediaStore
import android.util.Log
import com.example.skinwise.R
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.common.ops.CastOp
import org.tensorflow.lite.support.image.ImageProcessor
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.image.ops.ResizeOp
import org.tensorflow.lite.task.core.BaseOptions
import org.tensorflow.lite.task.vision.classifier.Classifications
import java.lang.IllegalStateException
import org.tensorflow.lite.task.vision.classifier.ImageClassifier

class ImageClassifierHelper(
    val tresholdValue: Float = 0.1f,
    var maxResultsValue: Int = 3,
    val modelNameValue: String = "cancer_classification.tflite",
    val contextValue: Context,
    val classifierListenerValue: ClassifierListener?
) {
    private var imageClassifier: ImageClassifier? = null

    private fun setupImageClassifier() {
        // TODO: Menyiapkan Image Classifier untuk memproses gambar.

        //Konofigurasi opsi klasifikasi gambar
        val optionsBuilder = ImageClassifier.ImageClassifierOptions.builder()
            .setScoreThreshold(tresholdValue)
            .setMaxResults(maxResultsValue)
        val baseOptionBuilder = BaseOptions.builder()
            .setNumThreads(4)
        //Tetapkan opsi dasar
        optionsBuilder.setBaseOptions(baseOptionBuilder.build())

        //Objek ImageClassifier dicoba
        try {
            imageClassifier = ImageClassifier.createFromFileAndOptions(
                contextValue,
                modelNameValue,
                optionsBuilder.build()
            )
        } catch (e: IllegalStateException) {
            classifierListenerValue?.onError(contextValue.getString(R.string.image_classifier_failed))
            Log.e(TAGIMAGE, e.message.toString())
        }
    }

    fun classifyStaticImage(imageUri: Uri) {
        // TODO: mengklasifikasikan imageUri dari gambar statis.

        //memeriksa inisialisasi objek
        if (imageClassifier == null) {
            setupImageClassifier()
        }
        val bitmap = getImageBitmap(imageUri) //muat gambar
        val tensorImage = preprocessImage(bitmap) //masukkan ke tensorflow
        val results = performInference(tensorImage) //hasil klasifikasi
        notifyResults(results) //kirim hasil
    }

    // Klasifikasi Gambar
    interface ClassifierListener {
        fun onError(errorMsg: String)
        fun onResults(
            results: List<Classifications>?,
            inferenceTime: Long
        )
    }

    //inisialisasi objek
    init {
        setupImageClassifier()
    }
    // lakukan inferensi klasifikasi gambar menggunakan model yang telah dilatih
    private fun performInference(tensorImage: TensorImage): List<Classifications>? {
        var inferenceTime = SystemClock.uptimeMillis()
        val results = imageClassifier?.classify(tensorImage)
        inferenceTime = SystemClock.uptimeMillis() - inferenceTime
        classifierListenerValue?.onResults(results, inferenceTime)
        return results
    }

    //persiapkan gambar yang dimuat sebagai objek Bitmap untuk dijadikan masukan (input) ke model klasifikasi
    private fun preprocessImage(bitmap: Bitmap): TensorImage {
        val imageProcessor = ImageProcessor.Builder()
            .add(ResizeOp(224, 224, ResizeOp.ResizeMethod.NEAREST_NEIGHBOR))
            .add(CastOp(DataType.UINT8))
            .build()

        return imageProcessor.process(TensorImage.fromBitmap(bitmap))
    }

    //ambil gambar dari URI yang diberikan dan mengonversinya menjadi objek Bitmap
    private fun getImageBitmap(imageUri: Uri): Bitmap {
        return if (checkVersion()) {
            val source = ImageDecoder.createSource(contextValue.contentResolver, imageUri)
            ImageDecoder.decodeBitmap(source)
        } else {
            MediaStore.Images.Media.getBitmap(contextValue.contentResolver, imageUri)
        }.copy(Bitmap.Config.ARGB_8888, true)
    }

    // cek versi
    private fun checkVersion(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.P
    }

    private fun notifyResults(results: List<Classifications>?) {
        classifierListenerValue?.onResults(results, 0)
    }

    //pesan log
    companion object {
        private const val TAGIMAGE = "ImageClassifierHelperModified"
    }
}