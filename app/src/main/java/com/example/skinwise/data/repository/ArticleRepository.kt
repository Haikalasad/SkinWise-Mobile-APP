package com.example.skinwise.data.repository

import com.example.skinwise.data.model.ArticleModel

class ArticleRepository {

    fun getAllArticle(): List<ArticleModel> {
        return articles
    }

    fun getArticleById(id: Int): ArticleModel? {
        return articles.find { it.id == id }
    }

    fun getArticleByCategory(category: String): ArticleModel? {
        return articles.firstOrNull { it.category.equals(category, ignoreCase = true) }
    }

    private val articles: List<ArticleModel> = listOf(
        ArticleModel(
            id = 1,
            category = "Ringworm",
            title = "Jenis-Jenis Infeksi Jamur Kulit Ringworm",
            content = "Halodoc, Jakarta - Ringworm adalah infeksi kulit umum yang disebabkan oleh jamur, dengan gejala khas berupa ruam melingkar (berbentuk seperti cincin) yang biasanya berwarna merah dan gatal. Jamur yang menyebabkan infeksi ini dapat hidup di kulit, permukaan, dan barang-barang rumah tangga seperti pakaian, handuk, dan tempat tidur.\n" +
                    "\n" +
                    "Ringworm memiliki banyak nama dan jenis. Istilah lain untuk infeksi kulit ini adalah \"tinea\" atau \"dermatofitosis\". Jenis-jenis infeksi jamur ringworm didasarkan pada lokasinya di tubuh. Untuk tahu lebih jelasnya, simak pembahasan berikut hingga tuntas, ya.\n" +
                    "\n" +
                    "Baca juga: 5 Faktor Risiko yang Dapat Sebabkan Infeksi Kulit\n" +
                    "\n" +
                    "Mengenal Jenis-Jenis Ringworm\n" +
                    "Ada tiga jenis jamur yang berbeda dapat menyebabkan ringworm, yaitu Trichophyton, Microsporum, dan Epidermophyton. Kemungkinan jamur tersebut dapat hidup dalam waktu lama sebagai spora di tanah, lalu manusia dan hewan dapat terjangkit ringworm setelah kontak langsung dengan tanah.\n" +
                    "\n" +
                    "Selain itu, infeksi juga dapat menyebar melalui kontak dengan hewan atau manusia yang terinfeksi. Infeksi ini bisa menyebar saat berbagai barang yang terkontaminasi jamur ini rentan terjadi pada anak-anak. \n" +
                    "\n" +
                    "Adapun ringworm terbagi menjadi beberapa jenis, atau lebih tepatnya disebut dengan nama berbeda, tergantung di mana infeksi ini memengaruhi tubuh, yaitu:\n" +
                    "\n" +
                    "Ringworm of the scalp (tinea capitis). Ditandai dengan munculnya sisik di kulit kepala yang berkembang menjadi bercak-bercak yang gatal dan bersisik. Paling umum terjadi pada anak - anak.\n" +
                    "Ringworm of the body (tinea corporis). Sering muncul sebagai bercak atau ruam dengan bentuk yang khas, yaitu seperti cincin bulat.\n" +
                    "Jock itch (tinea cruris). Mengacu pada infeksi ringworm pada kulit di sekitar selangkangan, paha bagian dalam, dan bokong. Kondisi ini sering terjadi pada pria dan remaja laki-laki.\n" +
                    "Athlete’s foot (tinea pedis). Nama lainnya adalah kutu air. Merupakan istilah untuk infeksi ringworm pada kaki. Sering dialami oleh orang yang sering bertelanjang kaki di tempat umum di mana infeksi dapat menyebar, seperti ruang ganti, kamar mandi, dan kolam renang.\n" +
                    "Baca juga: Kenali Scabies, Penyakit Kulit Akibat Kutu Hewan\n" +
                    "\n" +
                    "Diagnosis dan Pengobatan untuk Ringworm\n" +
                    "Dokter akan mendiagnosis ringworm dengan memeriksa kulit. Tergantung pada jenis jamurnya, jamur terkadang dapat berpendar (bersinar) di bawah cahaya hitam. Untuk memastikan diagnosis ringworm yang dicurigai, dokter mungkin akan melakukan beberapa tes seperti:\n" +
                    "\n" +
                    "Biopsi kulit atau kultur jamur. Dokter akan mengambil sampel kulit atau mengeluarkan cairan dari lepuh dan mengirimkannya ke laboratorium untuk mengujinya, sehingga dapat diketahui keberadaan jamur.\n" +
                    "Pemeriksaan kalium hidroksida (KOH). Dokter akan mengikis area kecil dari kulit yang terinfeksi, meletakkannya di tempat khusus, lalu meneteskan cairan yang disebut kalium hidroksida di atasnya. KOH memecah sel kulit normal, membuat elemen jamur lebih mudah dilihat di bawah mikroskop.\n" +
                    "Setelah diagnosis ditegakkan, dokter mungkin merekomendasikan obat dan penyesuaian gaya hidup untuk mengobati ringworm. Obat yang diresepkan dokter tergantung pada tingkat keparahan infeksi ringworm. Gatal di selangkangan, kutu air, dan ringworm of the body semuanya dapat diobati dengan obat topikal, seperti krim antijamur, salep, gel, atau semprotan.\n" +
                    "\n" +
                    "Baca juga: 4 Penyakit Kulit yang Biasa Muncul di Kaki\n" +
                    "\n" +
                    "Sementara itu, ringworm of the scalp mungkin memerlukan obat oral yang membutuhkan resep seperti griseofulvin (Gris-PEG) atau terbinafine. Obat kulit dan krim kulit antijamur yang dijual bebas di apotek mungkin direkomendasikan untuk digunakan juga. Produk ini umumnya mengandung klotrimazol, mikonazol, terbinafine, atau bahan terkait lainnya.\n" +
                    "\n" +
                    "Selain resep obat, dokter biasanya menyarankan agar kamu merawat infeksi di rumah dengan cara:\n" +
                    "\n" +
                    "Mencuci seprai dan pakaian setiap hari selama infeksi untuk membantu mendisinfeksi lingkungan.\n" +
                    "Mengeringkan tubuh secara menyeluruh setelah mandi.\n" +
                    "Mengenakan pakaian longgar.\n" +
                    "Mengobati semua area yang terinfeksi.\n" +
                    "Itulah sedikit penjelasan mengenai infeksi jamur kulit ringworm. Jika kamu mendapatkan resep obat atau krim antijamur dari dokter, kamu bisa beli obatnya lewat aplikasi Halodoc juga, lho.",
            author = "Halodoc",
            imageUrl = "https://d1bpj0tv6vfxyp.cloudfront.net/articles/386618_19-1-2021_16-53-27.webp",
            date = "20 Januari 2021"
        ),
        ArticleModel(
            id = 2,
            category = "Ringworm",
            title = "Ini Jenis-Jenis Infeksi Jamur Kulit Ringworm",
            content = "Halodoc, Jakarta - Kulit adalah bagian terluas dan terluar dari tubuh yang punya fungsi penting. Namun, kulit rentan terserang gangguan, seperti infeksi jamur kulit ringworm atau dermatofitosis. Infeksi kulit ini disebabkan oleh jamur, dan jenisnya juga beragam, tergantung area kulit yang terinfeksi. \n" +
                    "\n" +
                    "Mulai dari kulit kepala hingga kulit kaki, bisa terserang infeksi jamur kulit ringworm. Untuk mengetahui lebih jelas apa saja jenis infeksi jamur kulit ringworm yang bisa terjadi, simak pembahasan berikut, ya!\n" +
                    "\n" +
                    "Baca juga: 5 Faktor Risiko yang Dapat Sebabkan Infeksi Kulit\n" +
                    "\n" +
                    "Jenis-Jenis Infeksi Jamur Kulit Ringworm\n" +
                    "Infeksi jamur kulit ringworm bisa terjadi pada bagian tubuh mana pun. Jenis jamur yang bisa menyebabkan infeksi kulit ini pun banyak, termasuk Trichophyton, Microsporum, dan Epidermophyton. Penularan jamur terjadi dari kontak langsung saat bersentuhan dengan pengidapnya, benda pribadi yang dipakai bersama, dan tanah, \n" +
                    "\n" +
                    "Berikut ini jenis-jenis infeksi jamur kulit ringworm yang perlu diwaspadai:\n" +
                    "\n" +
                    "1.Tinea Corporis\n" +
                    "\n" +
                    "Tinea corporis dapat menyebabkan ruam yang melingkar seperti cincin dan terjadi di beberapa bagian tubuh. Selain itu, pengidapnya juga bisa merasakan gatal pada area ruam. Pada beberapa kasus yang parah, ruam tinea corporis bisa menjadi lepuh dan luka bernanah.\n" +
                    "\n" +
                    "Infeksi jamur kulit ini bisa menular melalui kulit ini melalui sentuhan fisik dengan pengidapnya, ditularkan dari hewan, dari benda yang sudah disentuh oleh pengidap, dan dari tanah.\n" +
                    "\n" +
                    "Baca juga: 4 Penyakit Kulit yang Biasa Muncul di Kaki\n" +
                    "\n" +
                    "2.Tinea Pedis\n" +
                    "\n" +
                    "Dikenal juga dengan sebutan kutu air, dan istilah bahasa Inggrisnya “athlete’s foot”, tinea pedis adalah infeksi jamur kulit pada kaki. Namun, gejala infeksi juga bisa menyebar ke bagian kuku dan tangan. Jamur penyebab tinea pedis dapat menempel di kaki jika kamu tertular dari penderitanya, atau karena kaki menyentuh permukaan bidang yang terkontaminasi oleh jamur. \n" +
                    "\n" +
                    "Jamur penyebab tinea pedis umumnya ditemukan di kamar mandi, ruang ganti, atau di area kolam renang. Risiko infeksi tinea pedis bisa meningkat pada orang yang menggunakan kaos kaki ketat dan kaki berkeringat yang menggunakan kaos kaki.\n" +
                    "\n" +
                    "Gejala yang bisa muncul karena tinea pedis adalah rasa gatal, sensasi menyengat dan terbakar, kulit terkelupas, hingga kulit kering. Tak hanya itu, tinea pedis juga dapat membuat kulit berubah warna, menebal, rapuh, dan tertarik keluar dari alas kuku.\n" +
                    "\n" +
                    "3.Tinea Capitis\n" +
                    "\n" +
                    "Terjadi pada kulit kepala, tinea capitis umumnya dialami oleh anak-anak. Infeksi kulit ini bisa terjadi pada siapa saja dari semua kalangan usia. Gejala yang ditimbulkan berupa munculnya bercak kecil melingkar yang gatal dan bersisik. \n" +
                    "\n" +
                    "Pengidap tinea capitis juga akan mengalami sakit pada kulit kepala, rambut rapuh, demam, dan pembengkakan kelenjar getah bening. Penularan tinea capitis terjadi saat menyentuh langsung kulit pengidapnya, melalui sisir atau sprei pengidap, dan dari hewan.\n" +
                    "\n" +
                    "Baca juga: Kenali Scabies, Penyakit Kulit Akibat Kutu Hewan\n" +
                    "\n" +
                    "4.Tinea Cruris\n" +
                    "\n" +
                    "Tinea cruris atau dikenal dengan jock itch adalah infeksi jamur kulit yang umumnya terjadi di kulit area kelamin, paha bagian dalam, dan bokong. Gejala yang muncul adalah kulit kemerahan, rasa gatal, sensasi terbakar, dan mengelupas. \n" +
                    "\n" +
                    "Seperti infeksi jamur kulit jenis lainnya, tinea cruris juga bisa menular, sehingga kamu berisiko tertular jika berkontak langsung dengan pengidap infeksi jamur kulit ini. Selain itu, kontak dengan pakaian yang tidak dicuci dari pengidap tinea cruris juga bisa terjadi.\n" +
                    "\n" +
                    "Itulah beberapa jenis infeksi jamur kulit ringworm yang perlu diwaspadai. Pastikan untuk selalu menjalani gaya hidup bersih dan sehat, serta hindari penggunaan barang pribadi seperti handuk dan pakaian, bersama orang lain. Jika kamu mengalami gejalanya, segera bicarakan dengan dokter di aplikasi Halodoc.",
            author = "Halodoc",
            imageUrl = "https://d1bpj0tv6vfxyp.cloudfront.net/articles/201934_29-12-2020_13-22-56.webp",
            date = "29 Desember 2020"
        ),

        ArticleModel(
            id = 3,
            category = "Ringworm",
            title = "Gatal dan Mengelupas, Ini Tanda Kulit Mengalami Infeksi Jamur",
            content = "Halodoc, Jakarta – Infeksi jamur atau mikosis merupakan penyakit umum yang terjadi di kulit. Jamur merupakan mikroorganisme yang bisa ditemukan di mana-mana, seperti di tanah, di tanaman, di permukaan rumah, dan juga di kulit.\n" +
                    "\n" +
                    "Organisme mikroskopis tersebut biasanya tidak menimbulkan masalah pada kulit, kecuali mereka berkembang biak lebih cepat dari biasanya atau menembus kulit melalui luka atau lesi.\n" +
                    "\n" +
                    "Infeksi jamur pada kulit biasanya menyebabkan ruam atau benjolan yang berwarna merah dan gatal. \n" +
                    "\n" +
                    "Pertanyaannya, seperti apa tanda-tanda infeksi jamur yang perlu diwaspadai? \n" +
                    "\n" +
                    "Tanda-Tanda Kulit Terkena Infeksi Jamur\n" +
                    "Gejala infeksi jamur kulit tergantung pada jenis jamur atau ragi yang menyebabkannya dan lokasinya.\n" +
                    "\n" +
                    "Namun, perubahan penampilan pada kulit dan gatal-gatal adalah gejala umum dari banyak infeksi jamur.\n" +
                    "\n" +
                    "Mikroorganisme ini juga bisa memengaruhi hanya satu area atau beberapa area pada tubuh kamu.\n" +
                    "\n" +
                    "Berikut beberapa tanda kulit yang terkena infeksi jamur:\n" +
                    "\n" +
                    "Menjadi merah, bersisik dan gatal.\n" +
                    "Menghasilkan sisik halus, mirip seperti kulit kering.\n" +
                    "Memerah dan sakit, dengan bintik-bintik berisi nanah.\n" +
                    "Ruam jamur terkadang bisa disalahartikan sebagai kondisi kulit lainnya, seperti psoriasis dan eksim.\n" +
                    "\n" +
                    "Namun, berbeda dengan kondisi tersebut, infeksi kulit jamur sering terlihat lebih meradang di sekitar perbatasan daripada di tengah bercak.\n" +
                    "\n" +
                    "Kamu juga perlu waspada dengan gigitan serangga seperti kutu kasur. Kamu perlu tahu: Kena Gigitan Kutu Kasur? Segera Hubungi Dokter Ini.\n" +
                    "\n" +
                    "Mengenal Tanda Infeksi Jamur Kulit Berdasarkan Tipenya\n" +
                    "Tanda infeksi kulit jamur juga bisa berbeda berdasarkan jenisnya.\n" +
                    "\n" +
                    "Berikut ini jenis infeksi kulit jamur yang paling umum terjadi, yaitu:\n" +
                    "\n" +
                    "1. Athlete’s foot\n" +
                    "Athlete’s foot atau tinea pedis adalah infeksi jamur umum yang memengaruhi kaki.\n" +
                    "\n" +
                    "Disebut athlete’s foot karena infeksi jamur ini biasanya berkaitan dengan olahraga dan para atlet, di mana memiliki lingkungan yang lembap dan hangat bagi jamur untuk bertumbuh dengan baik.\n" +
                    "\n" +
                    "Misalnya, kaus kaki dan sepatu, peralatan olahraga, dan ruang ganti. Namun, pada kenyataannya tinea pedis bisa terjadi pada siapa saja. Infeksi jamur ini paling sering muncul pada bulan-bulan musim panas. \n" +
                    "\n" +
                    "Berikut tanda-tandanya:\n" +
                    "\n" +
                    "Kulit terkelupas atau pecah-pecah.\n" +
                    "Kulit bersisik dan mengelupas.\n" +
                    "Gatal, peruh, atau sensasi terbakar di area yang terinfeksi.\n" +
                    "Perubahan warna dan lecet pada area kulit yang terkena.\n" +
                    "Mau tahu salep untuk menghilangkan gatal pada kulit? Baca di artikel ini:  “7 Rekomendasi Salep yang Ampuh Hilangkan Gatal di Kulit”.\n" +
                    "\n" +
                    "2. Infeksi jamur di selangkangan (jock itch)\n" +
                    "Jock itch atau tinea cruris adalah infeksi jamur kulit umum lainnya.\n" +
                    "\n" +
                    "Jamur ini menyukai lingkungan yang hangat dan lembap, serta tumbuh subur di area tubuh yang lembap, seperti selangkangan, bokong, dan paha bagian dalam.\n" +
                    "\n" +
                    "Jock itch biasanya muncul di tubuh sebagai ruam gatal yang berbentuk lingkaran. Gejalanya meliputi:\n" +
                    "\n" +
                    "Selangkangan, bokong, atau paha bisa menjadi merah dan bersisik. Pada kulit yang lebih gelap, ruam mungkin tampak abu-abu atau cokelat\n" +
                    "Lecet, iritasi, gatal, atau terbakar di area yang terinfeksi.\n" +
                    "Ruam dengan bentuk melingkar dan tepi terangkat\n" +
                    "Kulit pecah-pecah, mengelupas, atau kering di area yang terinfeksi.\n" +
                    "3. Kurap\n" +
                    "Kurap atau tinea corporis adalah infeksi kulit yang terjadi akibat jamur yang hidup pada jaringan mati, yaitu kulit, rambut, dan kuku.\n" +
                    "\n" +
                    "Ini sebenarnya adalah jamur yang menyebabkan gatal di selangkangan (jock itch) dan kaki atlet. Ketika muncul di tempat lain di tubuh, infeksi tersebut bernama kurap.\n" +
                    "\n" +
                    "Tanda-tanda kurap biasanya mudah kamu lihat dari bentuknya. Bercak yang mungkin gatal atau bersisik akan berubah menjadi bercak kulit yang menonjol dan berbentuk cincin seiring waktu. \n" +
                    "\n" +
                    "Bagian luar cincin ini mungkin tampak merah pada kulit yang terang, dan abu-abu atau coklat pada kulit berwarna, dan mungkin juga tampak menonjol atau bergelombang.\n" +
                    "\n" +
                    "Sedangkan bagian dalam cincin akan tampak jernih dan sehat dan tepi cincin dapat menyebar ke luar.\n" +
                    "\n" +
                    "4. Infeksi ragi\n" +
                    "Infeksi ragi pada kulit memiliki nama lain, yaitu kandidiasis kulit. Masalah kulit ini terjadi ketika jenis jamur candida tumbuh terlalu banyak. Infeksi ragi tidak menular.\n" +
                    "\n" +
                    "Infeksi ini paling sering terjadi di area tubuh yang hangat, lembab, dan berlipat, termasuk ketiak dan selangkangan.\n" +
                    "\n" +
                    "Pengidap obesitas, diabetes, dan orang yang mengonsumsi antibiotik juga berisiko lebih tinggi mengalami infeksi ragi. \n" +
                    "\n" +
                    "Candida juga bisa menyebabkan ruam popok pada bayi. Ini juga bisa menyebabkan infeksi pada kuku, vagina, atau mulut (oral thrush). Tanda-tanda infeksi ragi pada kulit meliputi:\n" +
                    "\n" +
                    "Ruam.\n" +
                    "Bercak yang mengeluarkan cairan bening.\n" +
                    "Benjolan seperti jerawat.\n" +
                    "Gatal.\n" +
                    "Sensasi seperti terbakar.\n" +
                    "Saat terkena infeksi jamur, kulit menjadi lebih sensitif sehingga kamu tidak boleh asal menggunakan sabun mandi.\n" +
                    "\n" +
                    "Nah, Lifebuoy Mild Care merupakan sabun yang tepat untuk kulit yang sensitif akibat infeksi jamur. \n" +
                    "\n" +
                    "Lifebuoy Mild Care selain lebih kuat lawan kuman juga lembut di kulit, kulit tetap lembap dengan kandungan 10X moisturizer.",
            author = "Halodoc",
            imageUrl = "https://d1vbn70lmn1nqe.cloudfront.net/prod/wp-content/uploads/2022/11/09035229/gatal-dan-mengelupas-ini-tanda-kulit-mengalami-infeksi-jamur-halodoc.jpg.webp",
            date = "22 Mei 2024"
        ),

        ArticleModel(
            id = 4,
            category = "Ringworm",
            title = "Kenali Infeksi Kulit yang Disebabkan Alergi Makanan",
            content = "Halodoc, Jakarta - Setiap hari semua orang makan untuk mendapatkan energi agar kuat melakukan aktivitas harian. Meski begitu, makanan yang dikonsumsi mungkin saja menimbulkan dampak buruk pada beberapa orang. Gangguan yang umum terjadi karena makanan adalah alergi. Kamu mungkin mengalami ruam atau gatal bahkan menimbulkan infeksi pada kulit. Berikut ulasan lebih lengkapnya terkait gangguan pada kulit ini!\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Alergi Makanan Dapat Sebabkan Infeksi Kulit\n" +
                    "Seseorang dapat mengalami alergi makanan karena sistem kekebalan tubuh merespons secara defensif terhadap protein makanan tertentu. Padahal, kandungan pada makanan tersebut tidak menimbulkan bahaya apa pun bagi tubuh. Hal tersebut membuat sistem imunitas tubuh memproduksi antibodi, karena menganggap kandungan yang masuk sebagai zat asing yang berbahaya atau disebut juga alergen.\n" +
                    "\n" +
                    "Baca juga: Jangan Percaya 4 Mitos Alergi Makanan Ini\n" +
                    "\n" +
                    "Saat pertama kali mengonsumsi makanan yang dapat menyebabkan alergi, sistem kekebalan tubuh memproduksi antibodi yang disebut imunoglobulin E (IgE). Ketika kamu mengonsumsi makanan yang sama untuk kedua kalinya, antibodi IgE akan bekerja sesuai perintah untuk melepaskan sebagian besar histamin agar dapat \"membunuh\" zat asing tersebut. Histamin sendiri adalah bahan kimia kuat yang dapat memengaruhi banyak bagian tubuh, terutama kulit.\n" +
                    "\n" +
                    "Namun, tahukah kamu jika seseorang yang mengalami alergi makanan jika dibiarkan dapat menyebabkan infeksi pada kulit?\n" +
                    "\n" +
                    "Seseorang yang sedang mengalami alergi, salah satu gejala yang dapat timbul adalah rasa gatal karena efek samping yang terjadi pada tubuh. Tentu kamu sulit untuk menahan diri untuk tidak menggaruk area kulit yang gatal. Jika kamu tetap menggaruk kulit yang terganggu, iritasi yang sedang terjadi dapat semakin parah bahkan infeksi pada kulit. Gangguan yang lebih parah dapat terjadi jika tidak segera diobati.\n" +
                    "\n" +
                    "Baca juga: Mengapa Alergi Makanan Bisa Terjadi?\n" +
                    "\n" +
                    "Jika kamu masih memiliki pertanyaan terkait alergi makanan yang dapat sebabkan terjadinya infeksi pada kulit, dokter dari Halodoc siap menjelaskannya dengan rinci kepadamu. Caranya mudah, cukup dengan download aplikasi Halodoc dan dapatkan kemudahan terkait akses kesehatan hanya dengan penggunaan gadget di tangan!\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Cara Mendiagnosis Alergi Makanan\n" +
                    "Cara yang paling umum untuk mendiagnosis alergi adalah dengan melakukan tes darah radioallergosorbent (RAST) untuk memeriksa jumlah antibodi yang diproduksi oleh sistem kekebalan tubuh. Adanya peningkatan kadar antibodi tertentu dapat membantu dokter untuk mengidentifikasi alergi makanan tertentu. Dokter juga dapat melakukan tes alergi pada kulit atau tes gores untuk mengidentifikasi zat yang menyebabkan gejala alergi.\n" +
                    "\n" +
                    "Selain itu, kamu juga perlu membuat buku harian makanan untuk menemukan secara pasti segala yang dikonsumsi yang dapat memicu alergi. Setelah memastikannya, cobalah untuk menghindari makanan yang dapat memicu alergi, kemudian menambahkannya kembali pada diet yang dilakukan satu per satu untuk melihat reaksi yang ditimbulkan. Metode ini disebut juga dengan diet eliminasi dan tantangan.\n" +
                    "\n" +
                    "Baca juga: Ini Dampak Alergi Makanan Paling Fatal\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Cara Mengatasi Alergi Makanan\n" +
                    "Cara terbaik untuk mengatasi alergi makanan adalah dengan menghindari segala hal yang dapat menimbulkan reaksi. Jika reaksi yang timbul ringan, biasanya dapat mereda tanpa dilakukan pengobatan. Untuk mengatasi ruam, antihistamin dapat membantu guna mengatasi rasa gatal dan juga meredakan hidung yang tersumbat, serta gejala lainnya yang terkait alergi.\n" +
                    "\n" +
                    "Jika gejala atau reaksi yang terjadi lebih serius, konsumsi kortikosteroid seperti prednison dapat membantu untuk mengurangi pembengkakan. Dalam situasi yang mengancam nyawa, suntikan epinefrin dapat segera membalikkan gejala dan merupakan satu-satunya pilihan pengobatan yang terbilang efektif. Jika dokter memberikan resep yang berisi auto-injector, pastikan untuk membawa dua setiap saat.\n" +
                    "\n" +
                    "Itulah pembahasan mengenai alergi makanan yang dapat menyebabkan terjadinya infeksi pada kulit. Maka dari itu, ada baiknya untuk mengendalikan diri jika merasakan gatal akibat gejala dari alergi. Selain itu, kamu dapat menggunakan pelembap kulit atau kompres dengan kain dingin untuk menekan iritasi yang disebabkan oleh reaksi alergi. Dengan begitu, dampak buruk yang mungkin terjadi dapat dihindari.",
            author = "Halodoc",
            imageUrl = "https://d1bpj0tv6vfxyp.cloudfront.net/articles/691656_2-12-2020_10-45-4.webp",
            date = "18 Maret 2024"
        ),

        ArticleModel(
            id = 5,
            category = "Ringworm",
            title = "Berbagai Cara Mengatasi Infeksi Kulit Jamur",
            content = "Halodoc, Jakarta - Infeksi kulit jamur umum terjadi pada tubuh manusia. Seperti kebanyakan mikroba, ada jamur yang bermanfaat dan berbahaya. Ketika jamur berbahaya menyerang tubuh, mereka mungkin sulit untuk disembuhkan. Karena jamur bisa bertahan hidup di lingkungan dan menginfeksi kembali orang yang berusaha untuk sembuh. \n" +
                    "\n" +
                    "Meskipun ada jutaan spesies jamur, hanya sekitar 300 jamur diantaranya yang benar-benar menyebabkan infeksi pada kulit manusia. Jamur bisa hidup di tanah, tanaman, permukaan rumah, dan di kulit manusia. Terkadang, jamur menyebabkan munculnya ruam atau benjolan. Bagaimana infeksi kulit jamur bisa diatasi?\n" +
                    "\n" +
                    "Baca juga: Perawatan Rumahan untuk Mengatasi Infeksi Kulit Ringan\n" +
                    "\n" +
                    "Mengatasi Infeksi Kulit Jamur\n" +
                    "Organisme mikroskopis atau jamur pada kulit ini biasanya tidak menimbulkan masalah, kecuali mereka berkembang biak lebih cepat dari biasanya. Jamur yang berkembang biak lebih cepat bisa menembus kulit melalui luka atau lesi. Karena jamur tumbuh subur di lingkungan yang hangat dan lembap serta tidak banyak aliran udara. Seperti kaki, selangkangan, dan lipatan kulit. \n" +
                    "\n" +
                    "Obat anti jamur bisa digunakan untuk mengobati infeksi jamur. Obat tersebut bisa membunuh jamur secara langsung atau mencegahnya tumbuh dan berkembang. Obat anti-jamur bisa kamu dapatkan di apotek dan bebas resep, tersedia dalam berbagai bentuk, termasuk:\n" +
                    "\n" +
                    "Krim atau salep;\n" +
                    "Pil;\n" +
                    "Bubuk;\n" +
                    "Semprotan;\n" +
                    "Sabun.\n" +
                    "Jika kamu mengalami infeksi kulit jamur, kamu bisa menggunakan produk yang dijual bebas untuk melihat apakah membantu mengatasi kondisi tersebut. Jika kondisinya lebih persisten atau parah, segera hubungi dokter melalui aplikasi Halodoc. Dokter mungkin perlu meresepkan obat antijamur yang lebih kuat untuk membantu mengatasi infeksi kulit jamur yang kamu alami. \n" +
                    "\n" +
                    "Selain mengonsumsi obat bebas atau obat antijamur resep dari dokter, ada beberapa hal yang perlu dilakukan untuk membantu menghilangkan infeksi kulit jamur, yaitu:\n" +
                    "\n" +
                    "Menjaga area yang terkena tetap bersih dan kering.\n" +
                    "Memakai pakaian atau sepatu longgar yang memungkinkan kulit untuk bernapas. \n" +
                    "Biasanya infeksi kulit jamur muncul dengan penampilan ruam bersisik atau perubahan warna di kulit disertai gatal. Beberapa infeksi kulit jamur umum terjadi. Meskipun infeksi terasa mengganggu dan tidak nyaman, tapi biasanya tidak serius. \n" +
                    "\n" +
                    "Baca juga: Ketahui 4 Jenis Infeksi Kulit yang Disebabkan Bakteri\n" +
                    "\n" +
                    "Kenali Jenis-jenis Infeksi Kulit Jamur\n" +
                    "Terdapat beberapa jenis infeksi kulit jamur yang umum terjadi, di antaranya:\n" +
                    "\n" +
                    "1.Tinea Pedis\n" +
                    "Tinea pedis atau athlete’s foot adalah infeksi jamur yang menyerang kaki. Kondisi ini berkaitan dengan olahraga dan atlet karena jamur tumbuh subur di lingkungan yang hangat dan lembap, seperti kaus kaki dan sepatu, peralatan olahraga, dan ruang loker. Namun pada kenyataanya siapapun bisa mengalami tinea pedis. \n" +
                    "\n" +
                    "2.Infeksi Jamur Vagina\n" +
                    "Ini adalah kondisi umum yang terjadi pada wanita, biasanya disebabkan oleh Candida albicans. Infeksi jamur vagina mengganggu keseimbangan normal bakteri dan jamur di vagina. Ketidakseimbangan bakteri ini dapat disebabkan oleh antibiotik, stres, dan ketidakseimbangan hormon, atau kebiasaan makan yang buruk. \n" +
                    "\n" +
                    "3.Tinea Cruris\n" +
                    "Infeksi jamur yang tumbuh di kulit selangkangan ini juga dikenal sebagai jock itch. Jamur menyukai area yang hangat dan lembap, seperti selangkangan, bokong, dan paha bagian dalam. Tinea cruris mungkin lebih umum terjadi di musim panas atau di daerah yang hangat dan lembap. \n" +
                    "\n" +
                    "Baca juga: Ini Cara Mengobati Infeksi Kulit Berdasarkan Penyebabnya\n" +
                    "\n" +
                    "4.Kurap\n" +
                    "Kurap atau tinea corporis adalah infeksi kulit yang disebabkan oleh jamur yang hidup di jaringan mati, seperti kulit, rambut, dan kuku. Kurap adalah jamur yang menyebabkan gatal di selangkangan dan kaki atlet. Ketika muncul di area tubuh lain, maka infeksi ini disebut kurap. \n" +
                    "\n" +
                    "Infeksi kulit jamur sering terjadi, hampir setiap orang pernah mengalaminya. Meskipun bukan kondisi yang serius, infeksi ini bisa menyebabkan ketidaknyamanan dan iritasi karena kulit yang gatal atau merah bersisik. Jika tidak segera diobati, ruam bisa menyebar atau menjadi iritasi. ",
            author = "Halodoc",
            imageUrl = "https://d1bpj0tv6vfxyp.cloudfront.net/articles/683061_23-12-2020_17-43-30.webp",
            date = "25 Desember 2020"
        ),


        ArticleModel(
            id = 6,
            category = "Atopic",
            title = "Ini 5 Tips Merawat Kulit Dermatitis Atopik",
            content = "Halodoc, Jakarta – Dermatitis atopik adalah penyakit eksim kulit kronis yang paling banyak terjadi. Gejalanya berupa kulit yang sangat kering, gatal, merah, dan bengkak.\n" +
                    "\n" +
                    "Penyebabnya berasal dari faktor genetik dan lingkungan yang menimbulkan kerusakan pada skin barrier pelindung kulit serta sistem kekebalan tubuh. Disrupsi pada skin barrier ini menjadi penyebab utama dermatitis atopik yang perlu kami waspadai.\n" +
                    "\n" +
                    "Maka dari itu, pengidap dermatitis atopik perlu merawat skin barrier kulit dengan baik agar gejala dapat berkurang dan menghindari komplikasi lebih parah. Sebab, dalam beberapa kasus dermatitis atopik bisa menimbulkan komplikasi. \n" +
                    "\n" +
                    "Contohnya, infeksi sekunder seperti infeksi bakteri streptococcus, atau infeksi virus herpes kulit pada bagian yang iritasi. Maka dari itu, perawatan kulit menjadi hal yang penting bagi pengidap penyakit ini.\n" +
                    "\n" +
                    "Tips Perawatan Kulit untuk Dermatitis Atopik\n" +
                    "Berikut ini tips yang bisa kamu lakukan untuk merawat kulit dermatitis atopik:\n" +
                    "\n" +
                    "1. Cermat memilih sabun\n" +
                    "Tips pertama yang bisa kamu lakukan adalah cermat dalam memilih sabun.\n" +
                    "\n" +
                    "Banyak sabun mandi dan pembersih pakaian yang mengandung deterjen untuk membantu menghasilkan busa sabun.\n" +
                    "\n" +
                    "Sayangnya, deterjen dan bahan sabun lainnya dapat mengeringkan kulit, terutama bagi kamu yang mengidap dermatitis atopik. Sabun batangan juga tidak ramah pada kulit karena sifat alkalinitasnya.\n" +
                    "\n" +
                    "Sebagai gantinya, kamu dapat menggunakan sabun yang lebih lembut dan melembabkan dengan kadar pH sekitar pH 5,5-6. Di samping itu, hindari juga menggunakan sabun dengan pelembut dan pewangi.\n" +
                    "\n" +
                    "2. Hindari mengenakan pakaian yang terlalu tebal\n" +
                    "Salah satu penyebab iritasi dari dermatitis atopik adalah penggunaan pakaian yang terlalu tebal atau bahan yang tidak ramah pada kulit. \n" +
                    "\n" +
                    "Bahan pakaian dari polyester, nilon, dan kain sintetis lainnya dapat mengiritasi kulit.\n" +
                    "\n" +
                    "Jahitan kasar, resleting, kain wol, dan pengencang lainnya juga dapat menyebabkan kulit gatal.\n" +
                    "\n" +
                    "Sebagai gantinya, kamu dapat memilih pakaian dari bahan 100 persen katun yang lebih tipis, ringan, dan lembut.\n" +
                    "\n" +
                    "Kamu bisa mempertimbangkan bahan bambu atau sutra yang lebih nyaman untuk kulitmu.\n" +
                    "\n" +
                    "Ketahui lebih jauh mengenai dermatitis atopik di artikel ini: “Mengenal Dermatitis Atopik, Penyebab, Gejala, dan Cara Mengobatinya”\n" +
                    "\n" +
                    "3. Menggunakan humidifier\n" +
                    "Humidifier atau pelembap udara juga dapat mengurangi gejala dermatitis atopik.\n" +
                    "\n" +
                    "Kelembapan yang pas untuk pengidap dermatitis atopik adalah sekitar 30 hingga 50 persen.\n" +
                    "\n" +
                    "Kamu dapat membiarkan humidifier menyala selama kamu berada di ruangan, atau di kamar tidur sebelum tidur.\n" +
                    "\n" +
                    "Pelembap ruangan dengan filter anti mikroba juga dapat kamu pertimbangkan karena dapat mencegah tumbuhnya jamur.\n" +
                    "\n" +
                    "4. Hindari menggaruk area kulit yang terdampak\n" +
                    "Meskipun dermatitis atopik sering kali menyebabkan rasa gatal, menggaruk area kulit yang terdampak perlu dihindari.\n" +
                    "\n" +
                    "Sebab, hal tersebut menyebabkan kerusakan dan penebalan pada kulit.\n" +
                    "\n" +
                    "Menggaruk kulit yang iritasi juga dapat menyebabkan luka berdarah yang bisa memicu infeksi.\n" +
                    "\n" +
                    "Kamu dapat menggunting kukumu lebih pendek, dan menutupi area iritasi dengan pakaian tipis untuk meminimalisir kerusakan kulit.\n" +
                    "\n" +
                    "5. Gunakan moisturizing cream\n" +
                    "Cara terakhir yang dapat kamu lakukan untuk membantu merawat kulit yang terkena dermatitis atopik adalah dengan krim pelembap.\n" +
                    "\n" +
                    "Krim pelembap bekerja efektif untuk menghidrasi kulit dan menjaga kelembutan kulit.  \n" +
                    "\n" +
                    "Bagi pengidap dermatitis atopik, krim pelembap berfungsi untuk mengurangi peradangan dan kulit kering serta menyembuhkan luka. Selain itu, krim pelembap dapat menembus dan membantu menata kembali struktur lapisan kulit.\n" +
                    "\n" +
                    "Maka dari itu, penggunaan krim pelembap seperti CeraVe Moisturizing Cream secara rutin pada kulit, menjadi hal penting dalam pengobatan dermatitis atopik. \n" +
                    "\n" +
                    "Mau tahu apa saja dampak dermatitis pada pengidapnya? Baca di artikel ini: “Tak Hanya Gatal, Dermatitis Atopik Berisiko Turunkan Kualitas Hidup Pengidapnya”.\n" +
                    "\n" +
                    "Pilih Pelembap yang Mampu Menghidrasi dan Memperkuat Skin Barrier\n" +
                    "Skin barrier adalah lapisan terluar dari kulit manusia yang berfungsi melindungi kulit dari berbagai penyakit kulit. Skin barrier yang rusak dapat menyebabkan kulit menjadi kering, tidak sehat, dan mudah terinfeksi. \n" +
                    "\n" +
                    "Bagi penderita dermatitis atopik, skin barrier sering kali mengalami disfungsi dan tidak dapat bekerja sebagaimana mestinya.\n" +
                    "\n" +
                    "Namun, kamu tidak perlu khawatir karena penggunaan krim pelembap yang tepat dapat membantu mengembalikan fungsi skin barrier. \n" +
                    "\n" +
                    "\n" +
                    "CeraVe Moisturizing Cream dengan kandungan skin-identical ceramide dapat menjadi pilihan tepat untuk kamu yang memiliki jenis kulit kering.\n" +
                    "\n" +
                    "Krim pelembap ini dapat digunakan untuk membantu mengatasi masalah kulit baik pada wajah maupun pada bagian tubuh lainnya.\n" +
                    "\n" +
                    "Selain itu, produk ini juga aman digunakan untuk bayi berusia 2+ bulan yang mengalami masalah dermatitis atopik.\n" +
                    "\n" +
                    "Menurut penelitian dari jurnal Clinical Medicine and Research, krim pelembap yang memiliki kandungan ceramide mampu mengembalikan fungsi skin barrier kulit bagi penderita dermatitis atopik. \n" +
                    "\n" +
                    "Sebab, skin barrier memiliki kandungan ceramide yang tinggi sebesar 50 persen dari total lipid. Nah, kandungan skin-identical ceramide yang ada pada CeraVe Moisturizing Cream menjadi sangat penting untuk kesehatan kulitmu.\n" +
                    "\n" +
                    "Berbeda dengan ceramide lainnya, skin-identical ceramide diformulasikan dengan struktur kandungan menyerupai ceramide alami pada kulit, sehingga dapat membantu memperbaiki skin barrier dengan lebih efektif.\n" +
                    "\n" +
                    "Selain itu, CeraVe Moisturizing Cream juga memanfaatkan teknologi MVE (MultiVesicular Emulsion), yang akan mengontrol pelepasan ceramide ke dalam kulit secara perlahan-lahank. Teknologi ini dapat membantumu menjaga dan mempertahankan kelembaban kulit dan skin barrier seharian. \n" +
                    "\n" +
                    "Studi juga menunjukkan bahwa pasien yang menggunakan MVE moisturizing cream memiliki tingkat pembersihan dermatitis atopik pada kulit lebih tinggi, dibandingkan yang tidak, perbandingannya sebesar 75 persen dengan 15 persen.\n" +
                    "\n" +
                    "Dilengkapi dengan Hyaluronic Acid dan bahan esensial lainnya, CeraVe Moisturizing Cream membantu mengatasi permasalahan kulitmu dan memberikan nutrisi untuk kesehatan kulit. Pelembap dari CeraVe ini memiliki tekstur yang tidak lengket, lembut, dan akan terasa nyaman di kulit.\n" +
                    "\n" +
                    "Kamu juga tidak perlu khawatir karena krim ini juga tidak akan menimbulkan komedo dan bebas dari minyak. Pembuatan krim CeraVe juga dikembangkan oleh dermatologis terpercaya.\n" +
                    "\n" +
                    "Nah, kamu dapat membeli CeraVe Moisturizing Cream di Toko Kesehatan Halodoc yang akan langsung diantar di rumah! Lebih mudah dan praktis, bukan? Selain itu, kamu juga bisa konsultasikan masalah kulit yang kamu alami dengan dokter spesialis kulit melalui Halodoc.",
            author = "Halodoc",
            imageUrl = "https://d1vbn70lmn1nqe.cloudfront.net/prod/wp-content/uploads/2024/04/01073326/Ini-5-Tips-Merawat-Kulit-Dermatitis-Atopik.jpg.webp",
            date = "01 April 2024"
        ),



        ArticleModel(
            id = 7,
            category = "Atopic",
            title = "Mengenal Dermatitis Atopik, Penyebab, Gejala, dan Cara Mengobatinya",
            content = "Halodoc, Jakarta – Dermatitis atopik atau eksim adalah masalah kulit yang menyebabkan gatal-gatal dan meradang. Biasanya, kondisi ini lebih rentan menimpa anak kecil ketimbang orang dewasa. \n" +
                    "\n" +
                    "Walaupun tidak menular, eksim bisa sangat mengganggu karena kulit menjadi kering dan gatal terus menerus. Walaupun kondisinya menghilang, eksim seringkali mudah kambuh kembali apabila bertemu pemicunya. Namun, kamu bisa mencegahnya dengan mengetahui berbagai penyebab dermatitis atopik berikut ini!\n" +
                    "\n" +
                    "Berbagai Penyebab Dermatitis Atopik\n" +
                    "Ada berbagai hal yang bisa memicu eksim. Beberapa diantaranya mungkin tidak bisa kamu hindari. Namun, sebagian besar faktor pemicunya bisa kamu cegah.\n" +
                    "\n" +
                    "Berikut berbagai penyebabnya:\n" +
                    "\n" +
                    "1. Faktor genetik\n" +
                    "Kondisi ini ternyata bisa berasal dari faktor genetik alias keturunan. Jadi, apabila ada salah satu atau kedua orang tua yang mengidap eksim, kemungkinan besar sang anak akan mengalaminya. \n" +
                    "\n" +
                    "Eksim bisa diatasi dengan menggunakan obat-obatan sejenis cream atau salep. Cek rekomendasinya di sini: “Ini 5 Pilihan Obat untuk Mengatasi Dermatitis pada Kulit”.\n" +
                    "\n" +
                    "2. Gangguan fungsi barier kulit\n" +
                    "Pengidap dermatitis atopik cenderung memiliki barier atau lapisan kulit yang lemah. Padahal, lapisan ini berperan besar untuk melindungi kulit dari pengaruh lingkungan. \n" +
                    "\n" +
                    "Lemahnya barier lantas membuat kulit mudah kehilangan kelembapannya. \n" +
                    "\n" +
                    "Akibatnya, berbagai alergi, iritan atau bakteri yang menempel pada kulit mudah memicu peradangan atau bahkan reaksi alergi.\n" +
                    "\n" +
                    "3. Reaksi alergi\n" +
                    "Dermatitis atopik juga berkaitan erat dengan reaksi alergi terhadap bahan-bahan tertentu. Misalnya, alergi makanan, alergi udara, atau kontak langsung dengan iritan seperti deterjen atau bahan kimia rumah tangga. Reaksi alergi ini kemudian memicu peradangan kulit dan gejala eksim.\n" +
                    "\n" +
                    "4. Faktor lingkungan bisa sebabkan dermatitis atopik\n" +
                    "Lingkungan juga menjadi faktor penyumbang dermatitis. Faktor ini bisa berupa debu, serbuk sari, polusi udara, cuaca dingin atau kering. Rendahnya kelembapan udara juga bisa memperburuk gejala dermatitis atopik.\n" +
                    "\n" +
                    "5. Gangguan sistem kekebalan tubuh\n" +
                    "Perubahan dalam respons sistem kekebalan tubuh juga bisa memicu peradangan kulit. Pengidap eksim umumnya memiliki respons imun yang berlebihan terhadap rangsangan tertentu. Akibatnya, muncul peradangan dan gejala dermatitis. \n" +
                    "\n" +
                    "Kenali Gejala Dermatitis Atopik\n" +
                    "Gejala utamanya adalah kulit yang meradang, kemerahan dan disertai gatal-gatal. Apabila kamu menggaruknya, bagian kulit rentan mengalami infeksi.\n" +
                    "\n" +
                    "Tanda-tanda kulit yang infeksi, yaitu: \n" +
                    "\n" +
                    "Kulit semakin kering atau basah, memerah dan terlihat meradang.\n" +
                    "Keluarnya cairan dari kulit\n" +
                    "Timbul kerak kuning di permukaan kulit atau bintik-bintik kecil berwarna putih kekuningan.\n" +
                    "Kulit menjadi bengkak dan sakit\n" +
                    "Tidak enak badan, tubuh terasa panas dan menggigil.\n" +
                    "Ketahui bahwa kulit yang infeksi bisa tampak basah atau kering. Untuk lebih jelasnya, baca lebih lanjut di sini: “Ketahui Perbedaan Eksim Basah Vs Eksim Kering”. \n" +
                    "\n" +
                    "Apa Pilihan Pengobatannya?\n" +
                    "Pilihan pengobatannya tentu dokter sesuaikan dengan pemicu dermatitis atopik. Berikut berbagai opsinya:\n" +
                    "\n" +
                    "1. Perawatan topikal\n" +
                    "Opsi berikut ini menggunakan obat yang berbentuk salep. Dokter bisa meresepkan jenis obat salep berikut ini:\n" +
                    "\n" +
                    "Krim atau salep kortikosteroid untuk mengurangi peradangan dan gatal pada kulit.\n" +
                    "Salep atau krim imunosupresa, seperti tacrolimus atau pimekrolimus. Fungsinya untuk mengendalikan peradangan dan mengurangi gatal pada kulit.\n" +
                    "Krim pelembap guna menjaga kelembapan kulit dan mengurangi gejala kering dan pecah-pecah.\n" +
                    "2. Perawatan sistemik\n" +
                    "Selain obat salep, dokter juga bisa meresepkan obat-obatan oral berikut ini:\n" +
                    "\n" +
                    "Antihistamin untuk mengurangi gatal pada kulit dan membantu meningkatkan kualitas tidur.\n" +
                    "Obat imunosupresan seperti siklosporin atau azatioprin untuk mengendalikan peradangan.\n" +
                    "3. Menghindari pemicu dermatitis atopik\n" +
                    "Dokter biasanya meminta kamu untuk mengidentifikasi faktor pemicu gatal. Tujuannya, agar kamu bisa menghindarinya sehingga dermatitis atopik tidak mudah kambuh. \n" +
                    "\n" +
                    "4. Perawatan kulit untuk dermatitis atopik\n" +
                    "Dokter juga menganjurkan perawatan kulit harian seperti berikut untuk mencegah kambuhnya dermatitis atopik:\n" +
                    "\n" +
                    "Gunakan krim pelembap bebas pewangi secara teratur untuk menjaga kelembapan kulit. Oleskan krim pelembap setelah mandi atau mencuci tangan.\n" +
                    "Hindari penggunaan sabun atau produk pembersih yang keras. Gunakan pembersih kulit yang lembut dan bebas pewangi.\n" +
                    "Usahakan untuk tidak menggaruk kulit, karena hal ini dapat memperburuk peradangan dan menyebabkan infeksi.\n" +
                    "Hindari penggunaan pakaian yang terlalu ketat atau berbahan kasar yang dapat mengiritasi kulit. Kenakan pakaian yang lembut dan longgar.\n" +
                    "Itulah informasi seputar eksim yang perlu kamu ketahui. Jika punya pertanyaan lain seputar masalah kulit yang satu ini, jangan ragu untuk menghubungi dokter terpercaya di Halodoc.✔\uFE0F",
            author = "Halodoc",
            imageUrl = "https://d1vbn70lmn1nqe.cloudfront.net/prod/wp-content/uploads/2023/07/05024538/mengenal-dermatitis-atopik-penyebab-gejala-dan-cara-mengobatinya-halodoc.jpg.webp",
            date = "04 Maret 2024"
        ),



        ArticleModel(
            id = 8,
            category = "Atopic",
            title = "Catat, Ini 5 Hal yang Bisa Memperparah Kondisi Dermatitis Atopik",
            content = "Halodoc, Jakarta – Dermatitis atopik, atau eksim atopik, adalah kondisi ketika kulit meradang disertai ruam-ruam merah yang gatal, kering, dan pecah-pecah. Penyakit kulit ini memiliki bersifat kronis yang biasanya menjadi reaksi terhadap alergi tertentu.\n" +
                    "\n" +
                    "Tua ataupun muda, penyakit ini tidak menyerang kalangan usia tertentu saja. Pengidap dari dermatitis atopik ini pun biasanya merasakan gatal-gatal dalam jangka waktu yang cukup lama. \n" +
                    "\n" +
                    "Nah, apa saja sih faktor-faktor yang dapat menyebabkan dermatitis atopik semakin parah?\n" +
                    "\n" +
                    "Penyebab Dermatitis Atopik\n" +
                    "Belum diketahui secara pasti apa saja penyebab dermatitis atopik. Meskipun begitu, umumnya ruam-ruam kemerahan muncul di area kulit tertentu seperti telinga, siku, dahi, belakang lutut, dan sekitar mata. \n" +
                    "\n" +
                    "Lantas, apa saja faktor-faktor penyebab peradangan kulit yang dapat memicu dermatitis atopik: \n" +
                    "\n" +
                    "1. Faktor genetik\n" +
                    "Keturunan memiliki andil yang besar dalam menyebabkan dermatitis atopik. Seseorang yang memiliki riwayat keluarga yang mengidap penyakit ini biasanya mudah untuk terpapar.\n" +
                    "\n" +
                    "Muncul gatal-gatal pada area yang disebutkan di atas? Baca artikel berikut untuk mengetahui rekomendasi obat untuk gatal-gatal: “Ini 5 Obat Dermatitis untuk Mengatasi Gatal dan Ruam Merah ”.\n" +
                    "\n" +
                    "2. Alergi tertentu\n" +
                    "Merupakan sebuah pantangan bagi pengidap dermatitis atopik untuk menjauhi alergen makanan. Contohnya seperti susu, telur, kacang-kacangan, ikan, dan sebagainya. Tidak hanya itu saja, alergen hirup seperti deterjen, sabun, dan parfum juga dapat memperburuk kondisi dermatitis atopik. \n" +
                    "\n" +
                    "3. Stres yang berlebih\n" +
                    "Stres dapat menjadi salah satu faktor yang menyebabkan dermatitis atopik dan memperburuk gejalanya. Tingkat stres yang tinggi cenderung meningkatkan pelepasan hormon stres, seperti hormon kortisol, yang dapat memicu peradangan kulit. Oleh sebab itu, manajemen stres sangat diperlukan agar ruam-ruam tidak terlalu menyebar.  \n" +
                    "\n" +
                    "4. Perubahan hormon\n" +
                    "Lonjakan hormonal yang terjadi pada masa remaja dan kehamilan dapat menyebabkan dermatitis atopik. Terlebih lagi pada produksi hormon seperti estrogen dan progesteron yang dapat meningkatkan kecenderungan terjadinya peradangan pada kulit.\n" +
                    "\n" +
                    "Ingin tau lebih lanjut tentang manfaat hormon estrogen? Simak selengkapnya di artikel berikut: “Kenali Fungsi Hormon Estrogen pada Wanita”.\n" +
                    "\n" +
                    "5. Lingkungan sekitar\n" +
                    "Lingkungan sekitar dapat berkontribusi dalam memicu dermatitis atopik. Orang-orang yang tinggal di daerah perkotaan lebih rentan terhadap polusi sehingga peradangan kulit pun dapat semakin parah. Tidak hanya polusi saja, paparan alergen lain seperti bulu hewan, serbuk sari, dan debu tungau juga berpengaruh.\n" +
                    "\n" +
                    "Perawatan Dermatitis Atopik \n" +
                    "Setelah mengetahui faktor-faktor yang dapat memicu dan memperparah kondisi dermatitis atopik, berikut adalah cara untuk merawat kulit ketika terjadi peradangan akibat dermatitis atopik:\n" +
                    "\n" +
                    "Mengoleskan obat oles seperti pimecrolimus untuk mengurangi rasa gatal dan memperbaiki kulit.\n" +
                    "Mandi dengan air hangat dan membalut area kulit yang sedang meradang untuk melindungi kulit.\n" +
                    "Memilih sabun yang non alkohol, dan tidak mengandung parfum maupun pewarna.\n" +
                    "Memakai pakaian dengan bahan lembut agar menghindari gesekan terhadap kulit yang sedang ruam.\n" +
                    "Menggunakan air humidifier atau pelembab udara.\n" +
                    "Itulah faktor yang menyebabkan dermatitis atopik menjadi lebih parah dan bagaimana cara meminimalisir peradangannya. Penting diingat bahwa apabila perawatan mandiri di rumah tidak lagi ampuh untuk mengurangi sensasi gatal-gatal, segeralah periksa ke dokter untuk mendapatkan penanganan lebih lanjut.",
            author = "Halodoc",
            imageUrl = "https://d1vbn70lmn1nqe.cloudfront.net/prod/wp-content/uploads/2024/02/28042947/Catat-Ini-5-Hal-yang-Bisa-Memperparah-Kondisi-Dermatitis-Atopik.jpg.webp",
            date = "28 Februari 2024"
        ),


        ArticleModel(
            id = 9,
            category = "Atopic",
            title = "Perawatan Rumahan untuk Mengobati Eksim Atopik",
            content = "Halodoc, Jakarta - Timbulnya rasa gatal di kulit adalah hal yang biasa terjadi. Namun, jika rasa gatal tersebut tidak tertahankan dan menimbulkan kemerahan pada kulit, mungkin saja kamu mengalami eksim atopik. Pada beberapa kasus, gangguan kulit ini dapat menimbulkan asma atau demam saat menyerang, terutama pada anak-anak.\n" +
                    "\n" +
                    "Maka dari itu, seseorang yang mengalami eksim atopik harus tahu beberapa cara yang efektif untuk mengatasinya. Dipercaya jika beberapa pengobatan ala rumahan juga dapat dilakukan agar kulit menjadi normal kembali. Berikut adalah beberapa pengobatan yang efektif untuk mengatasi eksim atopik!\n" +
                    "\n" +
                    "Baca juga: 6 Cara Merawat Eksim Atopik\n" +
                    "\n" +
                    "Atasi Eksim Atopik dengan Perawatan Rumahan\n" +
                    "Eksim atopik adalah suatu kondisi yang dapat membuat kulit menjadi merah dan gatal. Gangguan ini terbilang kronis karena dapat terjadi dalam waktu yang lama dan dapat menimbulkan kekambuhan secara berkala. Penyakit kulit ini dapat diatasi dengan beberapa produk, tetapi efek sampingnya dapat membuat kulit menjadi lebih kering dan terjadi iritasi.\n" +
                    "\n" +
                    "Sejauh ini belum ada obat yang dapat diaplikasikan untuk mengatasi gangguan eksim atopik ini. Meski begitu, beberapa penanganan dan tindakan perawatan diri dapat meredakan rasa gatal dan mencegah untuk kambuh. Berikut beberapa cara yang dapat kamu terapkan untuk mengatasi gangguan dermatitis atopik ini saat menyerang:\n" +
                    "\n" +
                    "1. Hindari Reaksi Alergi\n" +
                    "Salah satu cara yang dapat dilakukan sebagai penanganan dari eksim atopik adalah dengan menghindari reaksi alergi yang mungkin timbul. Beberapa cara yang dapat dilakukan sangat sederhana, yaitu mengganti deterjen cucian atau pelembut pakaian. Selain itu, faktor cuaca dapat menyebabkan kulit menjadi terganggu. Selalu menjaga kulit untuk terdampak langsung dari iklim tersebut dapat dilakukan. Pastikan untuk menghindari segala hal yang menyebabkan reaksi alergi timbul.\n" +
                    "\n" +
                    "2. Mencegah Kulit Kering\n" +
                    "Kamu juga dapat menangani eksim atopik dengan cara mencegah kulit agar tidak kering. Cara yang dapat dilakukan untuk mencegah kulit kering adalah dengan mandi atau berendam air hangat yang tidak lebih dari 10–15 menit. Selain itu, gunakan sabun yang lembut dan tidak menimbulkan reaksi alergi. Kamu juga dapat mengoleskan losion kulit ke seluruh tubuh untuk menjaga bagian terluar tubuh tersebut tetap lembap dan hindari losion dengan pewangi atau bahan iritasi lainnya.\n" +
                    "\n" +
                    "Baca juga: Alasan Pengidap Dermatitis Atopik Rentan Alami Alergi Telur\n" +
                    "\n" +
                    "3. Gunakan Pakaian yang Tepat\n" +
                    "Pemilihan pakaian sehari-hari juga dapat membuat kulit kamu menjadi kering, sehingga menyebabkan eksim atopik. Cobalah untuk selalu menghindari pakaian yang ketat dan berbahan kasar. Selain itu, kamu juga harus menghindari untuk menggaruk area yang gatal secara berlebihan agar tidak menimbulkan iritasi dan kemerahan. Kamu dapat menutup area tersebut dengan perban jika dirasa sulit untuk menahan diri dari menggaruk.\n" +
                    "\n" +
                    "4. Mengoleskan Gel Lidah Buaya\n" +
                    "Lidah buaya adalah tanaman yang mempunyai banyak manfaat bagi tubuh, terutama untuk kulit. Kandungan yang terkandung dalam tanaman tersebut dipercaya dapat ampuh untuk meredakan eksim atopik yang terjadi. Efek antibakteri dan antimikroba yang ada dapat mencegah terjadinya infeksi kulit yang dapat membuat kulit kering. Dengan mengoleskan lidah buaya, kulit yang rusak akan lebih cepat untuk sembuh.\n" +
                    "\n" +
                    "Itulah beberapa perawatan rumahan yang dapat efektif untuk mengatasi gangguan eksim atopik. Dengan menerapkan semua hal tersebut, diharapkan penyakit kulit tersebut tidak mengalami kekambuhan lagi. Penerapan hidup sehat sangat penting untuk menjaga tubuh secara keseluruhan, bukan hanya kulit.\n" +
                    "\n" +
                    "Baca juga: Eksim Atopik pada Anak, Bagaimana Mengatasinya?",
            author = "Halodoc",
            imageUrl = "https://d1bpj0tv6vfxyp.cloudfront.net/articles/15786a20-e103-443a-af55-170f82a71e45_article_image_url.webp",
            date = "14 Agustus 2020"
        ),




        ArticleModel(
            id = 10,
            category = "Atopic",
            title = "Perlu Waspadai Faktor yang Dapat Menyebabkan Dermatitis Atopik",
            content = "Halodoc, Jakarta – Dermatitis atopik biasanya dimulai pada masa bayi dengan kemunculan, seperti ruam merah yang diiringi sensasi gatal. Biasanya, dermatitis atopik ini muncul di lekukan kulit, seperti di dalam siku, di belakang lutut, depan leher, pokoknya di area kulit yang tertekuk. \n" +
                    "\n" +
                    "Dermatitis atopik atau biasa dikenal dengan eksim ini memiliki faktor pemicu, yaitu kulit kering, variasi gen, disfungsi sistem kekebalan tubuh, infeksi kulit, paparan makanan, udara, kontak dengan alergen, serta kombinasi dari semuanya. Untuk mengetahui lebih jelas mengenai dermatitis atopik, baca selengkapnya di sini!\n" +
                    "\n" +
                    "Baca juga: Begini Cara Atasi Dermatitis Atopik\n" +
                    "\n" +
                    "Faktor Risiko Umum\n" +
                    "Kondisi dermatitis atopik kerapnya dipengaruhi oleh pemicu umum berikut ini:\n" +
                    "\n" +
                    "Usia\n" +
                    "Dermatitis dapat terjadi pada segala usia, tetapi dermatitis atopik (eksim) biasanya dimulai pada masa bayi.\n" +
                    "\n" +
                    "Alergi dan Asma\n" +
                    "Orang yang memiliki riwayat eksim, alergi, demam, atau anggota keluarga yang mengidap asma lebih mungkin mengalami dermatitis atopik.\n" +
                    "\n" +
                    "Paparan Logam atau Bahan Kimia Tertentu \n" +
                    "Ternyata, pekerjaan yang membuat seseorang rutin terpapar logam tertentu, pelarut atau bahan pembersih tertentu dapat meningkatkan risiko dermatitis atopik. Seseorang yang kerap melakukan aktivitas kebersihan juga kerap tinggi risiko mengidap pelbagai bentuk eksim.\n" +
                    "\n" +
                    "Kondisi Kesehatan\n" +
                    "Beberapa kondisi kesehatan tertentu dapat menempatkan seseorang terhadap risiko penyakit dermatitis atopik, seperti, penyakit Parkinson dan HIV/AIDS. Selain itu, penemuan penelitian kesehatan juga menemukan bahwa dermatitis atopik juga cenderung dialami oleh pengidap depresi, penyakit jantung, ADHD, dan epilepsi. \n" +
                    "\n" +
                    "Baca juga: 6 Cara Merawat Eksim Atopik\n" +
                    "\n" +
                    "Pencegahan dan Perawatan \n" +
                    "Menggaruk ruam gatal yang berhubungan dengan dermatitis dapat menyebabkan luka terbuka, yang mungkin terinfeksi. Infeksi kulit ini dapat menyebar. Dengan menerapkan beberapa tindak pencegahan, ini bisa mengatasi penyebaran dan kekambuhan dermatitis atopik, yaitu:\n" +
                    "\n" +
                    "Mengenakan pakaian yang nyaman di kulit dan tidak melibatkan bahan iritan\n" +
                    "Banyak orang dengan eksim mengalami sensasi gatal lebih dahsyat ketika cuaca panas, sehingga muncul keringat. Ini bisa terjadi ketika seseorang berolahraga atau memakai terlalu banyak pakaian untuk tidur.  Sedangkan ketika udara dingin dan kulit menjadi kering, justru keberadaan eksim juga semakin parah karena iritasi yang mengembang. \n" +
                    "\n" +
                    "Hindari kulit kering dengan mengadopsi kebiasaan ini saat mandi:\n" +
                    "Mandilah secara rutin,  tetapi batasi durasinya. Cukup 5–10 menit saja dan gunakan air hangat bukan air panas. Meneteskan olive oil ke dalam air juga dapat membantu menjaga kelembapan dan kekenyalan kulit. \n" +
                    "\n" +
                    "Gunakan pembersih yang lembut dan tidak berbusa. Pilih sabun tanpa aroma. Hati-hati, karena beberapa sabun bisa mengeringkan kulit. Kalau kamu butuh rekomendasi jenis sabun yang baik digunakan untuk kondisi dermatitis atopik, bisa langsung tanyakan ke Halodoc. \n" +
                    "\n" +
                    "Dokter yang ahli di bidangnya akan berusaha memberikan solusi terbaik untukmu. Caranya, cukup download aplikasi Halodoc lewat Google Play atau App Store. Melalui fitur Contact Doctor kamu bisa memilih mengobrol lewat Video/Voice Call atau Chat. \n" +
                    "\n" +
                    "Keringkan dirimu dengan lembut. Setelah mandi, tepuk lembut kulit dengan handuk, jangan menggosoknya.\n" +
                    "\n" +
                    "Melembapkan kulit dengan baluran minyak, krim atau losion. Cobalah berbagai produk sebelum akhirnya menemukan produk yang cocok untukmu. Idealnya, yang terbaik adalah yang aman, efektif, terjangkau, dan tidak berbau. \n" +
                    "\n" +
                    "Konsumsi suplemen makanan, seperti vitamin D dan probiotik, untuk dermatitis atopik juga dapat membantu meringankan gejala. Namun, ada baiknya kamu membicarakan dengan dokter mengenai rekomendasi terbaik mengenai jenis suplemen dan makanan yang sebaiknya dimakan dan tidak dimakan.",
            author = "Halodoc",
            imageUrl = "https://d1bpj0tv6vfxyp.cloudfront.net/articles/c8e42b94-00f9-4533-b4e4-bda4c696e840_article_image_url.webp",
            date = "30 Agustus 2019"
        ),


        ArticleModel(
            id = 11,
            category = "MonkeyPox",
            title = "Terkonfirmasi di Indonesia, Waspadai Tempat Penularan Cacar Monyet",
            content = "Halodoc, Jakarta – Masyarakat Indonesia kini perlu lebih waspada akan penularan caca monyet atau monkeypox. Kasus cacar monyet meningkat menjadi 7 kasus sejak pertama dilaporkan pada 13 Oktober 2023. Apabila digabungkan dengan laporan pertama pada tahun 2022, total menjadi 8 kasus. Kasus terbaru ini juga ditemukan di wilayah DKI Jakarta.\n" +
                    "\n" +
                    "Melihat hal itu, akan lebih baik apabila tetap waspada dan mencegah diri dari penularan cacar monyet. Kamu bisa memulai dengan mengetahui tempat-tempat yang bisa meningkatkan risiko tertular cacar monyet. \n" +
                    "\n" +
                    "Tempat yang Meningkatkan Risiko Penularan Cacar Monyet\n" +
                    "Di bawah ini adalah beberapa tempat yang dapat meningkatkan risiko penularan cacar monyet.\n" +
                    "\n" +
                    "Transportasi umum\n" +
                    "Penularan di transportasi umum lewat kontak kulit maupun permukaan benda memang sangat rendah risikonya. Tertular virus dari udara juga tidak mungkin terjadi.\n" +
                    "\n" +
                    "Kalaupun kamu duduk bersebelahan dengan pengidap cacar monyet yang mengenakan pakaian minim, risiko untuk tertular masih tetap rendah. \n" +
                    "\n" +
                    "Profesor epidemiologi penyakit menular University of Nottingham, Inggris, Keith Neal, mengungkapkan bahwa pesawat adalah transportasi yang paling aman.\n" +
                    "\n" +
                    "Pasalnya, jenis transportasi tersebut dilengkapi dengan penyaringan udara yang mampu meminimalisir penyebaran virus.\n" +
                    "\n" +
                    "Pusat kebugaran\n" +
                    "Risiko penularan cacar monyet di tempat gym juga masih termasuk dalam kategori rendah. \n" +
                    "\n" +
                    "Direktur Laboratorium Komunikasi Risiko Universitas Temple, Sarah Bauerle Bass, menyarankan tips di bawah ini untuk mencegah penularan cacar monyet:\n" +
                    "\n" +
                    "Rutin mencuci tangan.\n" +
                    "Didisinfeksi peralatan gym secara rutin.\n" +
                    "Mengenakan pakaian lengan panjang.\n" +
                    "Menggunakan handuk yang bersih atau membawa handuk sendiri dari rumah.\n" +
                    "Konser musik\n" +
                    "Situasi konser musik cenderung ramai dan sesak. Namun, ahli menyatakan risiko penularan di konser musik masih tergolong rendah hingga sedang.\n" +
                    "\n" +
                    "Risiko meningkat ketika seseorang berkontak dari kulit ke kulit dalam waktu lama dengan pengidap cacar monyet.\n" +
                    "\n" +
                    "Karena alasan ini, para ahli menyarankan untuk mengenakan pakaian lengan panjang jika berencana mengunjungi konser musik.\n" +
                    "\n" +
                    "Hindari menggunakan obat-obatan terlarang, alkohol dan yang terpenting hindari melakukan hubungan seksual.\n" +
                    "\n" +
                    "Berhubungan intim\n" +
                    "Penelitian terkini menyatakan cacar monyet mudah menular melalui hubungan seks. Virus ini ditemukan dalam air mani, kotoran, urine, darah, dan air liur.\n" +
                    "\n" +
                    "Hal ini dibenarkan oleh Profesor kedokteran di Universitas Chicago yang berspesialisasi dalam kesehatan LGBTQ dan penyakit menular, Dr Aniruddha Hazra.\n" +
                    "\n" +
                    "Menurutnya, aktivitas seksual berisiko paling tinggi menularkan virus cacar monyet. Terutama antara laki-laki yang berhubungan seks dengan laki-laki.\n" +
                    "\n" +
                    "Pemakaian kondom memang bisa mencegah penularan virus melalui air mani. Tetapi, peluangnya masih ada ketika air mani tersebut terciprat ke seprai atau benda di sekitarnya.\n" +
                    "\n" +
                    "Waspadai Tanda dan Gejala Cacar Monyet\n" +
                    "Gejala cacar monyet serupa dengan cacar air, bedanya hanya lebih ringan. Setelah terpapar virus, tanda-tandanya akan muncul 5 hingga 21 hari kemudian.\n" +
                    "\n" +
                    "Gejala awal yang bisa diidentifikasi, antara lain:\n" +
                    "\n" +
                    "Demam.\n" +
                    "Sakit kepala.\n" +
                    "Nyeri otot.\n" +
                    "Nyeri punggung.\n" +
                    "Kelelahan.\n" +
                    "Menggigil.\n" +
                    "Pembengkakan kelenjar getah bening.\n" +
                    "Dalam 1 hingga 3 hari setelah gejala awalnya keluar, akan muncul ruam atau bentol cacar yang berisi cairan.\n" +
                    "\n" +
                    "Ruam ini biasanya muncul pada wajah, tangan, kaki, mulut, area genital, hingga pada area mata.\n" +
                    "\n" +
                    "Selain menghindari aktivitas dan tempat yang menjadi sarana penularan cacar monyet, kamu juga butuh vitamin agar daya tahan tubuh makin terjaga.",
            author = "Halodoc",
            imageUrl = "https://d1vbn70lmn1nqe.cloudfront.net/prod/wp-content/uploads/2022/08/24060552/terkonfirmasi-di-indonesia-waspadai-tempat-penularan-cacar-monyet-halodoc.jpg.webp",
            date = "25 Oktober 2023"
        ),



        ArticleModel(
            id = 11,
            category = "MonkeyPox",
            title = "Ini Mitos dan Fakta seputar Monkeypox yang Perlu Diketahui",
            content = "Halodoc, Jakarta – Per 23 Oktober, terdapat konfirmasi bahwa adanya peningkatan terhadap jumlah kasus Monkeypox di Indonesia. Kasus cacar monyet bertambah menjadi 7 kasus sejak pertama kali dilaporkan pada tanggal 13 Oktober 2023. Kasus ini ditemukan di wilayah DKI Jakarta, ujar Direktur Jenderal Pencegahan dan Pengendalian Penyakit Maxi Rein Rondonuwu (23/10/2023).\n" +
                    "\n" +
                    "Monkeypox merupakan penyakit yang disebabkan oleh virus mpox. Virus ini merupakan bagian dari keluarga virus yang sama dengan virus variola, yaitu virus penyebab penyakit cacar.\n" +
                    "\n" +
                    "Seiring dengan meningkatnya kasus monkeypox, muncul juga berbagai kesalahpahaman tentang penyakit ini. Seperti dari cara monkeypox menyebar, siapa yang menularkannya, dan seberapa mematikan penyakit ini.\n" +
                    "\n" +
                    "Yuk, simak ulasan di bawah ini untuk ketahui fakta seputar monkeypox!\n" +
                    "\n" +
                    "Mitos dan Fakta Seputar Monkeypox\n" +
                    "Di bawah ini adalah beberapa mitos yang muncul terkait dengan penyakit monkeypox yang perlu kamu ketahui:\n" +
                    "\n" +
                    "Mitos: Cacar monyet hanya bisa menular melalui hubungan seksual\n" +
                    "Meskipun cacar monyet tidak dianggap sebagai infeksi menular seksual, namun penyakit ini menyebar terutama melalui kontak dekat dan intim. Dengan begitu, virus ini tidak hanya bisa menular melalui hubungan seksual.\n" +
                    "\n" +
                    "Penularan cacar monyet memerlukan kontak kulit ke kulit dalam waktu yang lama. Ini bisa dilakukan dengan atau tanpa melakukan hubungan seks.\n" +
                    "\n" +
                    "Memeluk dan berpelukan, atau bahkan menyentuh tempat tidur dan barang-barang lain yang digunakan oleh pengidap cacar monyet bisa meningkatkan risiko kamu untuk terkena cacar monyet.\n" +
                    "\n" +
                    "Mitos: Cacar monyet seperti COVID-19\n" +
                    "Meskipun COVID-19 mudah tertular melalui aerosol di udara, namun penyakit cacar monyet lebih sulit tertular.\n" +
                    "\n" +
                    "Cacar monyet pun memerlukan kontak yang lama dan dekat dengan kulit orang yang terinfeksi, cipratan liur, atau benda yang terkontaminasi. \n" +
                    "\n" +
                    "Mengutip Huffington Post, Dr. Jorge Salinas, seorang ahli epidemiologi rumah sakit di Universitas Stanford juga mengatakan bahwa cacar monyet tidak mampu menyebabkan kerusakan seperti yang disebabkan oleh COVID-19.\n" +
                    "\n" +
                    "Virus pandemi cenderung merupakan virus pernapasan yang sangat mudah menular dan dapat menyebar pada fase pra-gejala, sehingga sulit untuk dikendalikan.\n" +
                    "\n" +
                    "Namun meskipun begitu, cacar monyet masih menjadi masalah kesehatan masyarakat yang akan lebih baik apabila kamu mengambil tindakan pencegahan. \n" +
                    "\n" +
                    "Lalu, langkah apa saja yang perlu dilakukan untuk mencegah penularan cacar monyet? Nah, ada beberapa cara yang bisa kamu lakukan.\n" +
                    "\n" +
                    "Untuk mengetahui caranya, kamu bisa baca di artikel ini: Ini Langkah Tepat Mencegah Penularan Cacar Monyet.\n" +
                    "\n" +
                    "Mitos: Cacar monyet hanya menjangkit kelompok tertentu\n" +
                    "Cacar monyet dapat menyebar terutama pada kalangan laki-laki yang berhubungan dengan sesama jenis, serta orang non-biner dan perempuan transgender yang berhubungan seks dengan laki-laki. \n" +
                    "\n" +
                    "Risiko terbesar dapat terjadi pada orang yang berganti-ganti pasangan untuk berhubungan seks, meski begitu, siapapun yang pernah terkena cacar monyet bisa tertular. \n" +
                    "\n" +
                    "Cacar monyet tampaknya mudah menular di kelompok ini karena memiliki lebih banyak peluang untuk menyebar melalui kontak dekat. Namun, bukan berarti virus tersebut tidak bisa masuk ke kelompok lainnya.\n" +
                    "\n" +
                    "Faktanya, kemungkinan besar virus tersebut sudah ada, namun kemudian sudah mati sebelum sempat menyebar lebih jauh.\n" +
                    "\n" +
                    "Jadi, siapa saja kelompok lain selain kalangan di atas yang rentan tertular cacar monyet? Ketahui selengkapnya di sini: Waspada, Ini Kelompok yang Rentan Tertular Cacar Monyet.\n" +
                    "\n" +
                    "Mitos: Cacar monyet adalah penyakit baru yang kita hadapi \n" +
                    "Cacar monyet pertama ditemukan pada akhir tahun 1950an dan masih lazim terjadi di negara-negara tertentu di Afrika Barat dan Tengah.\n" +
                    "\n" +
                    "Meskipun cacar monyet biasanya tidak menyebar di daerah seperti ini, namun terdapat kasus yang terjadi di luar wilayah tersebut. \n" +
                    "\n" +
                    "Di Amerika Serikat pernah ditemukan beberapa kasus akibat mengunjungi wilayah Afrika Barat dan Tengah atau terpapar dengan hewan impor yang terinfeksi.\n" +
                    "\n" +
                    "Mitos: Tingkat kematian yang rendah membuat cacar monyet tidak perlu dianggap serius\n" +
                    "Memang sangat sedikit orang yang meninggal karena cacar monyet. Sebagian besar orang yang tertular penyakit cacar monyet tidak perlu dirawat di rumah sakit dan dapat menangani gejala dengan sendirinya di rumah, seperti demam, nyeri tubuh, dan lesi kulit yang terasa sakit.\n" +
                    "\n" +
                    "Namun, meskipun penyakit ini tidak biasanya mengancam jiwa, penyakit ini tetap bisa berbahaya. Dalam kondisi kasus tertentu, lesi dapat menyebabkan gangguan penglihatan atau gangguan buang air kecil dan besar. \n" +
                    "\n" +
                    "Jadi, walaupun secara klinis ini merupakan hal yang ringan karena tidak menyebabkan kematian dan tidak perlu dirawat di rumah sakit, hal ini tetap bisa menjadi masalah yang serius.\n" +
                    "\n" +
                    "Itulah mitos-mitos terkait monkeypox atau cacar monyet yang perlu diluruskan agar masyarakat tidak meremehkan kondisi ini dan bisa melakukan langkah pencegahan untuk melindungi diri dari tertularnya cacar monyet. ",
            author = "Halodoc",
            imageUrl = "https://d1vbn70lmn1nqe.cloudfront.net/prod/wp-content/uploads/2023/10/25085220/Ini-Mitos-dan-Fakta-Seputar-Monkeypox.jpg.webp",
            date = "25 Oktober 2023"
        ),

        ArticleModel(
            id = 12,
            category = "MonkeyPox",
            title = "Muncul di Singapura, Kemenkes Himbau Warga waspadai Virus Monkeypox",
            content = "Halodoc, Jakarta - Beberapa waktu lalu, otoritas negara Singapura mengonfirmasi adanya kasus penyakit monkeypox atau cacar monyet pertama di negara tersebut. Penyakit langka itu diidap oleh seorang pria (38 tahun) warga Nigeria yang berkunjung ke negara tersebut pada 28 April lalu. Pria ini dipastikan positif terinfeksi monkeypox dan kini dalam kondisi stabil di bangsal isolasi di Pusat Nasional Penyakit Menular (NCID).\n" +
                    "\n" +
                    "Tak hanya itu saja, menurut Kementerian Kesehatan Singapura (MOH), pihaknya juga mengidentifikasi 23 orang yang terlibat kontak dekat dengan pria Nigeria tersebut. Mereka semua terdiri dari 18 orang peserta workshop yang sama dengan yang dihadiri oleh pria tersebut, dan empat karyawan hotel tempatnya menginap.\n" +
                    "\n" +
                    "Baca juga: 5 Penyakit yang Ditularkan dari Hewan\n" +
                    "Monkeypox atau cacar monyet ini merupakan penyakit Zoonosis, atau penularan penyakit dari hewan ke manusia yang disebabkan oleh virus monkeypox (MPXV). Virus ini mirip dengan cacar pada manusia, meski begitu monkeypox jauh lebih ringan daripada cacar. Namun, virus yang satu ini juga bisa berakibat fatal bagi pengidapnya.\n" +
                    "\n" +
                    "Awasi Gejalanya\n" +
                    "Ketika menyerang manusia, virus monkeypox ini akan menyebabkan kulit pengidapnya mengalami bintil-bintil menyerupai cacar air, tapi tak separah cacar yang umumnya terjadi. Dalam kebanyakan kasus, virus cacar monyet ini sering kali terjadi di negara-negara di benua Afrika bagian tengan dan barat.\n" +
                    "\n" +
                    "Penyakit yang terbilang jarang terjadi ini menular pada manusia lewat perantaraan tikus (hewan-hewan dari kelompok pengerat), primata (kera), dan tupai. Cara penularannya bisa melalui kontak langsung, digigit, ataupun terkena darah maupun cairan tubuh hewan tersebut.\n" +
                    "\n" +
                    "Yang perlu digarisbawahi, meski jarang terjadi manusia juga mungkin saja menulari manusia lainnya. Selain itu, konsumsi daging yang tak dimasak dengan baik dari hewan terinfeksi, juga bisa menularkan penyakit ini. Lalu, bagaimana dengan gejalanya?\n" +
                    "\n" +
                    "Baca juga: Sinar Matahari Cegah Penularan Cacar Air, Kok Bisa?\n" +
                    "\n" +
                    "Menurut World Health Organization (WHO), gejala monkeypox ini mulai timbul 14–21 hari sejak kali pertama terinfeksi virus. Gejalanya bisa berupa demam, sakit kepala hebat, limfadenopati (pembengkakan kelenjar getah bening), sakit punggung, mialgia (nyeri otot), dan asthenia (kekurangan energi).\n" +
                    "\n" +
                    "Selain itu, cacar monyet ini juga bisa menimbulkan ruam kulit mulai di wajah dan kemudian menyebar di tempat lain di tubuh. Dalam beberapa kasus, demam dan mual (gejala awal monkeypox), dan muncul bintil-bintil pada kulit bisa terjadi setelah 4–7 hari.\n" +
                    "\n" +
                    "Menurut para ahli, pengobatan untuk monkeypox ini sama dengan cacar, begitu juga dengan pencegahannya, yaitu dengan menggunakan vaksin cacar. Pasalnya, virus monkeypox ini berkerabat dekat dengan virus cacar air.\n" +
                    "\n" +
                    "Ketahui Cara Pencegahannya\n" +
                    "Monkeypox atau cacar monyet ini mirip sekali dengan penyakit ruam lain, seperti cacar, cacar air, campak, infeksi kulit akibat bakteri, kudis, sifilis, dan alergi terkait obat. Monkeypox hanya dapat didiagnosis secara pasti di laboratorium khusus dengan sejumlah tes yang berbeda. Nah, bagaimana dengan cara pencegahannya?\n" +
                    "\n" +
                    "Hindari kontak dengan tikus dan primata terinfeksi serta membatasi paparan langsung terhadap darah dan daging yang tidak dimasak dengan baik.\n" +
                    "Batasi kontak fisik dengan orang yang terinfeksi atau bahan yang terkontaminasi harus dihindari.\n" +
                    "Gunakan sarung tangan dan pakaian pelindung lainnya yang sesuai saat menangani hewan yang terinfeksi dan ketika merawat orang yang sakit.\n" +
                    "Petugas kesehatan dianjurkan melakukan vaksinasi.\n" +
                    "Selalu menerapkan perilaku hidup bersih dan sehat.\n" +
                    "Baca juga: Ibu, Lakukan 4 Hal Ini saat Anak Terkena Cacar Air\n" +
                    "Indonesia Bebas Monkeypox\n" +
                    "Berdasarkan keterangan dari Direktorat Jenderal (Dirjen) Pencegahan dan Pengendalian Penyakit (P2P) Kementerian Kesehatan (kemenkes), hingga kini penyakit monkeypox belum ditemukan di Indonesia. Dirjen P2P Kemenkes, Anung Sugihantono mengatakan (12/5), penularan pada manusia bisa terjadi karena kontak dengan monyet, tikus Gambia, dan tupai, ataupun mengonsumsi daging binatang yang sudah terkontaminasi.\n" +
                    "\n" +
                    "Di samping itu, Kemenkes juga menghimbau pada orang-orang yang baru kembali dari wilayah terjangkit monkeypox, agar segera memeriksakan dirinya bila mengalami gejala-gejala penyakit ini. Kemenkes juga meminta masyarakat untuk menginformasikan kepada petugas kesehatan, tentang riwayat perjalanannya dalam waktu kurang dari tiga pekan setelah kepulangan.\n" +
                    "\n" +
                    "Menurut data Kemenkes, wilayah yang terjangkit monkeypox secara global yaitu, Afrika Tengah dan Barat, seperti Republik Demokratik Kongo, Republik Kongo, Kamerun, Republik Afrika Tengah, Nigeria, Ivory Coast, Liberia, Sierra Leone, Gabon, dan Sudan selatan.",
            author = "Halodoc",
            imageUrl = "https://d1bpj0tv6vfxyp.cloudfront.net/articles/5323dccd-13fa-4c1f-97ee-3d2a8efa915d_article_image_url.webp",
            date = "13 Mei 2019"
        ),



        ArticleModel(
            id = 13,
            category = "Infeksi Kulit",
            title = "Bercak Hitam pada Kulit, Hati-Hati 4 Penyakit Ini",
            content = "Halodoc, Jakarta – Kulit adalah lapisan terluar tubuh yang rentan terserang berbagai macam penyakit. Penyakit kulit bisa disebabkan oleh berbagai macam hal, mulai dari kurangnya kebersihan, terpapar sinar matahari berlebihan sampai gaya hidup yang tidak sehat. Setiap penyakit kulit juga dapat menimbulkan gejala yang berbeda-beda, salah satunya dengan munculnya bercak hitam di kulit.\n" +
                    "\n" +
                    "Baca Juga: Jarang Keluar Rumah Tapi Muncul Flek Hitam, Ini Penyebabnya\n" +
                    "\n" +
                    "Bercak hitam ini juga punya karakteristik masing-masing, tergantung jenis penyakit kulit. Lantas, penyakit kulit yang umumnya ditandai dengan munculnya bercak hitam, yaitu:\n" +
                    "\n" +
                    "Lentigo\n" +
                    "Lentigo adalah penyakit kulit yang ditandai dengan bintik atau bercak hitam. Bintik-bintik ini umumnya muncul di area-area kulit yang sering terpapar sinar matahari, seperti wajah dan tangan. Bintik-bintik lentigo dapat tumbuh lambat selama bertahun-tahun atau muncul secara tiba-tiba. Tidak selalu berwarna hitam, bintik-bintik ini bisa berwarna kecoklatan. Karakteristik lentigo lainnya yakni memiliki tepi yang bulat atau tidak rata.\n" +
                    "\n" +
                    "Melansir dari Healthline, lentigo tidak termasuk penyakit kulit berbahaya. Sebab, bintik ini tidak menimbulkan rasa gatal atau menyebabkan gejala lain. Paparan radiasi UV adalah penyebab utama lentigo. Selain itu, orang yang berkulit putih, sering terpapar sinar matahari, sering melakukan tanning, fototerapi dan terapi radiasi lebih berisiko mendapatkan lentigo. \n" +
                    "\n" +
                    "Melasma\n" +
                    "Melasma atau chloasma adalah masalah kulit berikutnya yang ditandai dengan munculnya bercak gelap dan perubahan warna di kulit. Kondisi ini jarang terjadi pada pria dan umumnya dialami oleh wanita yang sedang hamil. Menurut American Academy of Dermatology, 90 persen orang yang mengembangkan melasma adalah wanita. Tidak diketahui dengan jelas penyebab dari melasma. \n" +
                    "\n" +
                    "Melansir dari Healthline, munculnya melasma dikaitkan dengan sensitivitas terhadap hormon estrogen dan progesteron. Artinya pil KB, kehamilan, dan terapi hormon memicu timbulnya melasma. Stres dan penyakit tiroid juga dianggap sebagai penyebab melasma. Selain itu, paparan sinar matahari dapat mengakibatkan melasma karena sinar ultraviolet memengaruhi sel-sel yang mengontrol pigmen (melanosit).\n" +
                    "\n" +
                    "Baca Juga: Hindari 4 Kebiasaan yang Dapat Memicu Munculnya Flek Hitam\n" +
                    "\n" +
                    "Acanthosis Nigricans\n" +
                    "Acanthosis nigricans adalah kelainan kulit yang ditandai dengan garis berwarna coklat muda sampai hitam. Kondisi ini sering ditemukan di lipatan kulit leher, ketiak, selangkangan, dan di bawah payudara. Melansir dari Cleveland Clinic, acanthosis nigricans biasanya dialami oleh pengidap diabetes dan obesitas. Namun, kondisi ini dapat dialami orang sehat. Terkadang acanthosis nigricans menjadi kondisi bawaan sejak lahir. Acanthosis nigricans cenderung lebih terlihat pada orang yang berkulit lebih gelap. \n" +
                    "\n" +
                    "Mengingat kondisi ini lebih berisiko dialami pengidap diabetes dan obesitas, mengelola kadar gula darah dan berat badan sehat adalah cara untuk mencegahnya. Kalau kamu ingin mengetahui kondisi ini maupun penyakit kulit lainnya, kamu bisa bertanya langsung ke dokter Halodoc. Lewat aplikasi, kamu bisa menghubungi dokter kapan saja dan di mana saja. Lebih praktis, bukan?\n" +
                    "\n" +
                    "Melanoma\n" +
                    "Di antara ketiga kondisi kulit di atas, melanoma adalah penyakit kulit yang harus diwaspadai. Melanoma adalah jenis kanker kulit yang paling serius yang ditandai dengan bercak hitam. Melanoma pada mulanya berkembang dalam sel (melanosit) yang menghasilkan melanin, yakni pigmen yang memberi warna pada kulit. Meski lebih sering berkembang di kulit, kanker ini juga dapat terbentuk di mata atau organ internal, seperti usus.\n" +
                    "\n" +
                    "Baca Juga: 4 Jenis Penyakit Kulit yang Perlu Diwaspadai\n" +
                    "\n" +
                    "Penyebab pasti dari semua melanoma tidak jelas. Melansir dari Mayo Clinic, sebagian besar kasus melanoma disebabkan oleh paparan radiasi ultraviolet (UV) dari sinar matahari atau lampu tanning. Oleh sebab itu, batasi paparan radiasi UV untuk mengurangi risiko melanoma. Mengetahui tanda-tanda peringatan kanker kulit dapat membantu pengobatan kanker dan mencegah penyebarannya. ",
            author = "Halodoc",
            imageUrl = "https://d1bpj0tv6vfxyp.cloudfront.net/articles/0a3a9be1-a88b-41f3-bc2a-bbd87295fdd1_article_image_url.webp",
            date = "22 Mei 2023"
        ),


        ArticleModel(
            id = 14,
            category = "Infeksi Kulit",
            title = "4 Jenis Penyakit Kulit yang Perlu Diwaspadai",
            content = "Halodoc, Jakarta – Kulit merupakan lapisan terluar dari tubuh yang bertugas untuk melapisi organ dalam tubuh manusia. Kulit memiliki fungsi untuk menjaga tubuh tetap stabil serta mengeluarkan segala macam kotoran dan zat sisa dalam tubuh. Zat sisa tersebut akan dikeluarkan melalui pori-pori kulit dalam bentuk keringat.\n" +
                    "\n" +
                    "Maka dari itu, sangat penting untuk selalu menjaga kesehatan kulit, salah satunya dengan menjaga kebersihan dan melakukan perawatan kulit secara teratur penting untuk dilakukan. Gunanya adalah agar kulit tampak sehat dan tidak terlihat kusam. Selain itu, menjaga kesehatan kulit juga dilakukan agar kulit tidak mudah terkena macam-macam penyakit kulit akibat paparan bakteri, kuman, virus, dan alergi.\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Jenis Penyakit Kulit yang Sering Menyerang\n" +
                    "Penyakit kulit bisa berbahaya, apalagi jika tidak ditangani dengan tepat. Pasalnya, penyakit yang biasanya menjangkiti kulit dapat menjalar dan menyebar di area sekitarnya, sehingga akan memperparah kondisi pengidap. Berikut beberapa penyakit kulit yang perlu kamu waspadai:\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "1.Hemangioma\n" +
                    "Penyakit yang satu ini akan terjadi saat ditemukan adanya jaringan darah yang abnormal dalam tubuh, sehingga menyebabkan pertumbuhan daging atau kulit yang bukan merupakan kanker. Pada umumnya, hemangioma muncul di lapisan organ dalam manusia, seperti hati.\n" +
                    "\n" +
                    "Hemangioma merupakan penyakit yang sejenis dengan tumor pembuluh darah. Pada beberapa pengidap, hemangioma akan membuat kulit terlihat biru atau ungu. Hal tersebut terjadi apabila hemangioma muncul di lapisan kulit yang dalam. Selain area tangan dan kaki, hemangioma dapat muncul di kulit kepala, punggung, dada, atau wajah. \n" +
                    "\n" +
                    "Hemangioma bisa saja terjadi pada anak sejak mereka lahir. Kondisi ini biasa disebut dengan tanda lahir, dengan gejalanya yang akan terlihat setelah anak-anak berusia beberapa bulan.\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "2.Bisul\n" +
                    "Seperti yang telah diketahui, bisul ditandai dengan benjolan yang muncul dari dalam kulit dan disertai rasa nyeri, berwarna kemerahan, dan berisi nanah. Bisul terjadi akibat adanya infeksi bakteri pada kulit, sehingga bakteri masuk ke pori-pori kulit dan menginfeksi akar rambut (folikel rambut).\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "3.Cold Sore (Herpes Simplex Virus)\n" +
                    "Herpes simplex merupakan penyakit yang ditandai dengan lepuhan atau luka yang terasa sakit pada bagian mulut atau bibir. Pada dasarnya, penyakit kulit ini lebih sering dialami oleh anak-anak ketimbang orang dewasa, dan dapat sembuh dengan sendirinya dalam waktu dua sampai tiga minggu. \n" +
                    "\n" +
                    "Selain lepuhan, penyakit herpes simplex ditandai dengan pusing, mual, dan gejala lain yang mirip dengan penyakit flu. Pada kasus yang parah, gejala dapat ditandai dengan kesulitan menelan, serta pembengkakan kelenjar getah bening pada beberapa area tubuh.\n" +
                    "\n" +
                    "Hal yang perlu diwaspadai adalah, penyakit herpes simplex ini merupakan salah satu penyakit kulit yang dapat menular. Penularannya sendiri dapat terjadi melalui air liur dan kontak fisik pada bagian kulit yang terbuka. Bahayanya, untuk menularkan kondisi ini seseorang tidak selalu memperlihatkan ciri-ciri adanya lepuhan pada bibir atau mulut.\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "4.Selulitis\n" +
                    "Selulitis merupakan infeksi bakteri yang menyebabkan kulit tampak membengkak, kemerahan, terasa lunak, dan sakit saat tersentuh. Biasanya, selulitis terjadi pada bagian kulit tungkai, tapi tidak menutup kemungkinan terjadi pada area tubuh lainnya. Parahnya, selulitis merupakan salah satu penyakit kulit yang dapat membahayakan nyawa pengidapnya jika tidak ditangani dengan tepat.\n" +
                    "\n" +
                    "Hal tersebut dapat terjadi karena infeksi dapat menyebar melalui kelenjar getah bening dan pembuluh darah dengan menyerang jaringan di bawah kulit. Meski berbahaya, selulitis bukanlah penyakit kulit yang menular, karena infeksi ini menyerang jaringan kulit dalam, bukan jaringan kulit luar.\n" +
                    "\n" +
                    "Untuk menghindari sejumlah penyakit kulit tersebut, jangan lupa untuk selalu menjaga kebersihan dan kesehatan kulit. Selain itu, jangan lupa untuk selalu memakai tabir surya sebelum bepergian keluar rumah, kelola stres dengan baik, konsumsi makanan sehat bergizi seimbang, serta cukupi kebutuhan air putih untuk tubuh. Kamu bisa membeli produk pelindung kulit di aplikasi Halodoc. Dengan layanan antar, pesanan akan dikirim ke rumah segera. Download Halodoc di sini!\n" +
                    "\n" +
                    "Baca Juga: 5 Manfaat Masker Kentang untuk Perawatan Kulit Wajah\n" +
                    "\n",
            author = "Halodoc",
            imageUrl = "https://d1bpj0tv6vfxyp.cloudfront.net/articles/b8134cb9-2111-4744-a99a-1931f86178c0_article_image_url.webp",
            date = "24 Juli 2023"
        ),

        ArticleModel(
            id = 15,
            category = "Infeksi Kulit",
            title = "4 Penyakit Kulit yang Rentan Dialami Pengidap Diabetes",
            content = "Halodoc, Jakarta - Diabetes disebut-sebut menjadi salah satu penyakit yang dapat terjadi seumur hidup. Seseorang yang mengidapnya mungkin perlu mengonsumsi obat secara rutin dan benar-benar menjaga pola hidup sehat. Jika tidak, beberapa dampak buruk dapat dirasakan, termasuk juga penyakit kulit. Namun, penyakit kulit apa saja yang rentan terjadi akibat diabetes? Baca selengkapnya di sini!\n" +
                    "\n" +
                    "Beberapa Penyakit Kulit yang Umum Terjadi pada Pengidap Diabetes\n" +
                    "Diabetes adalah penyakit yang dapat menyerang setiap bagian tubuh, termasuk juga kulit. Banyak orang yang mengidap gangguan ini mengalami masalah pada kulit jika tidak menjaga pola hidup sehat sehari-harinya. Bahkan, hal ini dapat menjadi gejala paling awal saat seseorang mengalami diabetes sebelum mendapatkan diagnosis pasti. Memang tidak mudah untuk mendeteksinya karena kondisi kulit ini dapat menyerang semua orang.\n" +
                    "\n" +
                    "Baca juga: Ketahui Perbedaan Gatal Biasa dengan Gatal Diabetes\n" +
                    "\n" +
                    "Maka dari itu, setiap orang harus tahu beberapa penyakit kulit yang rentan terjadi saat mengidap diabetes. Dengan begitu, penanganan dini dapat segera dilakukan setelah dipastikan jika benar masalah kulit tersebut, akibat gangguan yang berhubungan dengan kadar gula di dalam tubuh ini. Berikut ini beberapa penyakit kulit tersebut:\n" +
                    "\n" +
                    "1. Acanthosis Nigricans\n" +
                    "Acanthosis nigricans adalah salah satu penyakit kulit yang rentan terjadi akibat diabetes. Gangguan ini dapat menyebabkan penggelapan dan penebalan pada area kulit yang terserang. Terkadang, area kulit dapat berubah menjadi warna cokelat dan sedikit menonjol. Beberapa area yang rentan mengalami masalah ini, antara lain sisi leher, ketiak, selangkangan, tangan, siku, dan lutut. Tidak hanya diabetes, beberapa kondisi lainnya juga dapat menyebabkan penyakit kulit ini.\n" +
                    "\n" +
                    "2. Reaksi Alergi\n" +
                    "Seseorang dengan penyakit diabetes juga rentan mengalami penyakit kulit berupa reaksi alergi. Beberapa penyebabnya dapat disebabkan oleh makanan, serangga, dan obat-obatan. Hal ini mampu menimbulkan ruam dan/atau benjolan pada kulit. Jika kamu mengalami reaksi alergi, terutama akibat obat, ada baiknya memeriksakan diri meski berhubungan dengan diabetes atau tidak. Jika dibiarkan, hal ini mungkin saja menimbulkan bahaya.\n" +
                    "\n" +
                    "Baca juga: 3 Cara Mengatasi Gatal Kulit pada Pengidap Diabetes\n" +
                    "\n" +
                    "3. Dermopati Diabetes\n" +
                    "Penyakit kulit lainnya yang dapat disebabkan oleh diabetes adalah dermopati. Diabetes dapat memengaruhi pembuluh darah kecil pada tubuh yang memasok darah ke kulit. Gangguan ini dapat menimbulkan bercak bersisik dengan warna coklat muda atau merah dan kerap terjadi di bagian depan kaki. Saat terjadi, gangguan ini tidak menimbulkan rasa sakit, melepuh, hingga gatal, meski tidak pengobatan mungkin tidak diperlukan.\n" +
                    "\n" +
                    "4. Vitiligo\n" +
                    "Diabetes juga dapat menyebabkan vitiligo, yaitu gangguan yang memengaruhi pewarnaan kulit. Penyakit kulit ini terjadi akibat hancurnya sel-sel penghasil pigmen (pengontrol warna kulit), sehingga menimbulkan bercak-bercak kulit dan mengubah warnanya. Bagian tubuh yang rentan mengalami masalah ini adalah siku, lutut, tangan, dan di sekitar wajah. Maka dari itu, pengidap diabetes dianjurkan untuk menggunakan tabir surya untuk mencegah sengatan matahari pada kulit.\n" +
                    "\n" +
                    "Baca juga: Ketahui Penyebab Terjadinya Infeksi Kulit pada Pengidap Diabetes\n" +
                    "\n" +
                    "Itulah beberapa penyakit kulit akibat diabetes yang terbilang rentan untuk terjadi. Jika kamu mengalami salah satu dari gangguan yang disebutkan, ada baiknya untuk memeriksakan diri. Diabetes yang diatasi sejak dini dapat menurunkan risiko terjadinya komplikasi berbahaya dan juga gejala-gejalanya. Pengobatan dini juga sangat penting untuk menentukan seberapa parah diabetes dapat mengganggu kehidupan.",
            author = "Halodoc",
            imageUrl = "https://d1bpj0tv6vfxyp.cloudfront.net/articles/794162_25-5-2021_0-15-12.webp",
            date = "25 Mei 2021"
        ),

        ArticleModel(
            id = 16,
            category = "Infeksi Kulit",
            title = "Tiba-Tiba Kulit Memar, Waspadai 5 Penyakit Ini",
            content = "Halodoc, Jakarta – Tubuh tidak terjatuh atau terbentur tetapi tiba-tiba muncul ruam berwarna biru keunguan? Jangan khawatir, kondisi ini memang sering terjadi pada sebagian orang. Munculnya ruam atau memar ini terjadi akibat pecahnya pembuluh darah kecil pada salah satu bagian tubuh, misalnya paha, lengan, atau pantat. Dalam dunia medis, munculnya ruam ini disebut dengan purpura simplex.\n" +
                    "\n" +
                    "Meski begitu, mudah memar tanpa alasan yang jelas juga perlu diwaspadai. Pasalnya, ada beberapa penyakit kronis dengan gejala berupa memar. Terlebih apabila kamu mengalami memar ini disertai dengan berbagai keluhan lainnya. Nah, berikut ini adalah 5 penyakit yang disebabkan dari kulit memar yang tiba-tiba muncul:\n" +
                    "\n" +
                    "1. Hemofilia\n" +
                    "\n" +
                    "Penyakit yang disebabkan dari kulit memar yang terjadi secara mendadak pertama adalah hemofilia atau kurangnya protein tertentu pada tubuh sehingga menyebabkan darah sukar menggumpal. Tingkat keseriusan penyakit ini pada setiap pengidap tidak sama. Beberapa pengidap mengalami memar tanpa sebab, sementara lainnya akan memar jika tubuhnya membentur sesuatu. Di Indonesia, penyakit hemofilia termasuk ke dalam kategori penyakit langka yang bisa menyebabkan kematian.\n" +
                    "\n" +
                    "2. Purpura Dermatitis\n" +
                    "\n" +
                    "Merupakan gangguan yang terjadi pada pembuluh darah yang disebabkan karena darah yang merembes keluar dari pembuluh kapiler. Gangguan kesehatan ini sering menyerang orang-orang berusia lanjut. Gejala awal yang sering muncul yaitu memar dengan warna ungu kemerahan di permukaan kulit, tepatnya di bagian tulang kering. Pada beberapa kondisi, memar yang muncul juga diikuti dengan rasa gatal yang sedikit mengganggu.\n" +
                    "\n" +
                    "Baca juga: Arti Warna Memar yang Tiba-Tiba Muncul di Tubuh\n" +
                    "\n" +
                    "3. Diabetes Tipe 2\n" +
                    "\n" +
                    "Penyakit yang disebabkan dari kulit memar selanjutnya adalah diabetes tipe 2. Kencing manis, begitulah penyakit ini lebih dikenal. Kadar gula berlebih dalam darah menjadi pemicu utama seseorang terserang penyakit ini. Biasanya, dokter akan memberikan suntik insulin untuk mengontrol kadar gula darah dalam tubuh pengidap. Sayangnya, ini justru memunculkan risiko terjadinya resistensi insulin.\n" +
                    "\n" +
                    "Nah, salah satu gejala yang sering muncul saat pengidap mengalami resistensi insulin adalah munculnya memar-memar pada kulit yang disebabkan karena rusaknya pembuluh darah di beberapa bagian tubuh. Namun, memar yang dialami oleh pengidap diabetes cenderung lebih sulit sembuh, sehingga bukan hal yang aneh jika akan muncul banyak memar pada tubuh para pengidap penyakit ini.\n" +
                    "\n" +
                    "4. Leukimia\n" +
                    "\n" +
                    "Gejala yang paling sering muncul jika seseorang terkena leukimia adalah munculnya memar pada tubuh, seperti misalnya punggung. Hal ini disebabkan karena kurangnya keeping darah pada tubuh pengidap leukimia yang berfungsi mengubah darah cair menjadi gumpalan. Kondisi darah yang begitu encer inilah yang membuat pengidap leukimia rentan memar dan berdarah. Menjadi salah satu penyakit dengan harapan hidup yang rendah membuat pengidap leukimia harus segera mendapat penanganan.\n" +
                    "\n" +
                    "Baca juga: Kenali Hidradenitis Supurativa dari Gejala Ini\n" +
                    "\n" +
                    "5. Kekurangan Keping Darah\n" +
                    "\n" +
                    "Penyakit kurangnya keeping darah pada tubuh disebut juga dengan istilah trombositopenia. Dalam keadaan sehat, tubuh mampu menampung sebanyak 150 ribu hingga 450 ribu trombosit atau keping darah. Nah, trombositopenia muncul karena keping darah dalam tubuh berada di bawah angka kisaran tadi.\n" +
                    "\n" +
                    "Trombositopenia sendiri muncul karena berbagai hal, mulai dari leukimia, kehamilan, kemoterapi, konsumsi alkohol berlebihan, infeksi virus, hingga anemia. Gejala yang sering muncul adalah timbulnya memar akibat kondisi darah yang terlalu encer merembes dari pembuluh kapiler.",
            author = "Halodoc",
            imageUrl = "https://d1bpj0tv6vfxyp.cloudfront.net/articles/93ac092f-9894-47d1-acbd-b1f31022941b_article_image_url.webp",
            date = "22 Mei 2023"
        ),



        ArticleModel(
            id = 17,
            category = "Infeksi Kulit",
            title = "Tiba-Tiba Kulit Memar, Waspadai 5 Penyakit Ini",
            content = "Halodoc, Jakarta – Kaki adalah bagian tubuh yang berperan penting dalam menopang berat badan saat beraktivitas. Fungsi ini ditunjang oleh susunan 42 otot, 26 tulang, 50 ligamen, dan 250 ribu kelenjar keringat.\n" +
                    "\n" +
                    "Adanya masalah pada kaki tentu berdampak negatif pada aktivitas sehari-hari. Makanya sebisa mungkin, kamu perlu berhati-hati saat beraktivitas untuk mencegah risiko cedera atau masalah lain pada kaki.\n" +
                    "\n" +
                    "Baca Juga: Waspadai 6 Penyakit yang Ditandai dengan Kaki Kesemutan\n" +
                    "\n" +
                    "Mengenal Berbagai Penyakit Kulit pada Kaki\n" +
                    "1. Lecet\n" +
                    "Umumnya terjadi akibat penggunaan sepatu baru atau ukuran sepatu yang tidak pas. Jika kondisi ini terjadi, bersihkan area kaki yang terluka, oleskan salep antibiotik, lalu tutup dengan plester atau perban. Selama masa penyembuhan, kamu dianjurkan melakukan hal berikut:\n" +
                    "\n" +
                    "Jangan gunakan iodine atau hidrogen peroksida sebagai obat luka lecet untuk membersihkan kulit. Gunakan air untuk membersihkan luka pada kulit.\n" +
                    "\n" +
                    "Jangan mandi dengan air terlalu panas dan menggunakan sabun yang mengandung banyak bahan kimia. Hal ini dapat memperparah luka lecet di kaki.\n" +
                    "\n" +
                    "Jangan mengeringkan luka lecet di kaki menggunakan handuk, apalagi dengan menggesekkannya.\n" +
                    "\n" +
                    "Kompres kulit dengan air es untuk mengurangi rasa sakit.\n" +
                    "\n" +
                    "2. Cantengan\n" +
                    "Alias kondisi tumbuhnya kuku kaki ke dalam. Jika diambil dengan cara yang tidak tepat (seperti ditarik paksa), kamu rentan mengalami infeksi yang lebih parah. Biasanya, cantengan disebabkan karena tekanan sepatu, infeksi jamur, atau struktur kaki yang buruk. Lantas, apa yang harus dilakukan? Jawabannya adalah potong kuku kaki menggunakan gunting kuku, jangan ditarik paksa.\n" +
                    "\n" +
                    "3. Kapalan\n" +
                    "Rentan terjadi akibat tekanan atau gesekan berlebih, sehingga kulit kaki menebal, mengeras, dan berwarna kekuningan. Penebalan ini membuat kulit kaki menjadi kurang sensitif. Kapalan biasanya muncul di telapak kaki, tumit, atau jari kaki. Bila kamu mengalami kapalan, bisa diobati dengan cara berikut ini:\n" +
                    "\n" +
                    "Rendam kaki dengan air garam hangat selama 15 menit sebanyak 3-4 kali sehari. Sambil merendam kaki, gunakan cotton bud untuk membantu mendorong kulit agar menjauhi kuku. Air hangat bisa meringankan rasa sakit dan pembengkakan akibat cantengan dan setelahnya keringkan kaki.\n" +
                    "\n" +
                    "Jaga kaki agar tetap bersih dan kering selama beraktivitas, kecuali saat kamu merendamnya dengan air garam hangat.\n" +
                    "\n" +
                    "Minum obat penghilang nyeri, seperti paracetamol atau ibuprofen.\n" +
                    "\n" +
                    "Oleskan salep antibiotik untuk meminimalkan risiko infeksi.\n" +
                    "\n" +
                    "Balut jari yang cantengan menggunakan perban kasa. Lebih baik pakai sendal selama beraktivitas hingga cantengan sembuh. Jika ingin menggunakan sepatu, pastikan ukurannya tidak terlalu sempit.\n" +
                    "\n" +
                    "Baca Juga: Mata Ikan, Enggak Terlihat tapi Ganggu Kaki Melangkah\n" +
                    "\n" +
                    "4. Mata Ikan\n" +
                    "Dikenal dengan nama clavus, yaitu kondisi penebalan kulit akibat tekanan dan gesekan yang terjadi berulang kali. Mata ikan berbentuk bulat dan berukuran lebih kecil dibanding kapalan. Ciri mata ikan berupa penebalan, pengerasan, dan benjolan pada kulit kaki. Kulit menjadi bersisik, kering, atau berminyak.\n" +
                    "\n" +
                    "Pengidap mata ikan rentan mengalami rasa nyeri ketika kulit yang terinfeksi ditekan. Rasa nyeri ini menjadi pembeda antara kapalan dan mata ikan. Lantas, apa yang bisa dilakukan untuk mengatasi mata ikan?\n" +
                    "\n" +
                    "Gunakan obat khusus untuk mengobati mata ikan, baik dalam bentuk cair, gel, pad, atau plester.\n" +
                    "\n" +
                    "Menggunakan batu apung. Rendam kaki dalam air hangat selama 5 menit (atau sampai kulit kaki terasa lembut), basahi batu apung dan gosokkan ke bagian kulit yang mengeras selama 2-3 menit. Setelahnya, bilas kaki hingga bersih.\n" +
                    "\n" +
                    "Pada kasus parah, diperlukan operasi untuk memotong bagian kulit yang menebal dan mengeras menggunakan pisau bedah. Operasi ini bertujuan untuk mengurangi tekanan pada jaringan di bawah area yang terinfeksi. Prosedur lain untuk mengatasi mata ikan berupa cryotherapy dan pengobatan laser.\n" +
                    "\n" +
                    "Baca Juga: Ketahui Penyakit Kaki yang Umum Terjadi pada Lansia",
            author = "Halodoc",
            imageUrl = "https://d1bpj0tv6vfxyp.cloudfront.net/articles/3bafe6f3-0afd-466a-99ae-454ed24c542b_article_image_url.webp",
            date = "10 Juli 2019"
        ),


        ArticleModel(
            id = 17,
            category = "Infeksi Kulit",
            title = "Tiba-Tiba Kulit Memar, Waspadai 5 Penyakit Ini",
            content = "Halodoc, Jakarta – Kaki adalah bagian tubuh yang berperan penting dalam menopang berat badan saat beraktivitas. Fungsi ini ditunjang oleh susunan 42 otot, 26 tulang, 50 ligamen, dan 250 ribu kelenjar keringat.\n" +
                    "\n" +
                    "Adanya masalah pada kaki tentu berdampak negatif pada aktivitas sehari-hari. Makanya sebisa mungkin, kamu perlu berhati-hati saat beraktivitas untuk mencegah risiko cedera atau masalah lain pada kaki.\n" +
                    "\n" +
                    "Baca Juga: Waspadai 6 Penyakit yang Ditandai dengan Kaki Kesemutan\n" +
                    "\n" +
                    "Mengenal Berbagai Penyakit Kulit pada Kaki\n" +
                    "1. Lecet\n" +
                    "Umumnya terjadi akibat penggunaan sepatu baru atau ukuran sepatu yang tidak pas. Jika kondisi ini terjadi, bersihkan area kaki yang terluka, oleskan salep antibiotik, lalu tutup dengan plester atau perban. Selama masa penyembuhan, kamu dianjurkan melakukan hal berikut:\n" +
                    "\n" +
                    "Jangan gunakan iodine atau hidrogen peroksida sebagai obat luka lecet untuk membersihkan kulit. Gunakan air untuk membersihkan luka pada kulit.\n" +
                    "\n" +
                    "Jangan mandi dengan air terlalu panas dan menggunakan sabun yang mengandung banyak bahan kimia. Hal ini dapat memperparah luka lecet di kaki.\n" +
                    "\n" +
                    "Jangan mengeringkan luka lecet di kaki menggunakan handuk, apalagi dengan menggesekkannya.\n" +
                    "\n" +
                    "Kompres kulit dengan air es untuk mengurangi rasa sakit.\n" +
                    "\n" +
                    "2. Cantengan\n" +
                    "Alias kondisi tumbuhnya kuku kaki ke dalam. Jika diambil dengan cara yang tidak tepat (seperti ditarik paksa), kamu rentan mengalami infeksi yang lebih parah. Biasanya, cantengan disebabkan karena tekanan sepatu, infeksi jamur, atau struktur kaki yang buruk. Lantas, apa yang harus dilakukan? Jawabannya adalah potong kuku kaki menggunakan gunting kuku, jangan ditarik paksa.\n" +
                    "\n" +
                    "3. Kapalan\n" +
                    "Rentan terjadi akibat tekanan atau gesekan berlebih, sehingga kulit kaki menebal, mengeras, dan berwarna kekuningan. Penebalan ini membuat kulit kaki menjadi kurang sensitif. Kapalan biasanya muncul di telapak kaki, tumit, atau jari kaki. Bila kamu mengalami kapalan, bisa diobati dengan cara berikut ini:\n" +
                    "\n" +
                    "Rendam kaki dengan air garam hangat selama 15 menit sebanyak 3-4 kali sehari. Sambil merendam kaki, gunakan cotton bud untuk membantu mendorong kulit agar menjauhi kuku. Air hangat bisa meringankan rasa sakit dan pembengkakan akibat cantengan dan setelahnya keringkan kaki.\n" +
                    "\n" +
                    "Jaga kaki agar tetap bersih dan kering selama beraktivitas, kecuali saat kamu merendamnya dengan air garam hangat.\n" +
                    "\n" +
                    "Minum obat penghilang nyeri, seperti paracetamol atau ibuprofen.\n" +
                    "\n" +
                    "Oleskan salep antibiotik untuk meminimalkan risiko infeksi.\n" +
                    "\n" +
                    "Balut jari yang cantengan menggunakan perban kasa. Lebih baik pakai sendal selama beraktivitas hingga cantengan sembuh. Jika ingin menggunakan sepatu, pastikan ukurannya tidak terlalu sempit.\n" +
                    "\n" +
                    "Baca Juga: Mata Ikan, Enggak Terlihat tapi Ganggu Kaki Melangkah\n" +
                    "\n" +
                    "4. Mata Ikan\n" +
                    "Dikenal dengan nama clavus, yaitu kondisi penebalan kulit akibat tekanan dan gesekan yang terjadi berulang kali. Mata ikan berbentuk bulat dan berukuran lebih kecil dibanding kapalan. Ciri mata ikan berupa penebalan, pengerasan, dan benjolan pada kulit kaki. Kulit menjadi bersisik, kering, atau berminyak.\n" +
                    "\n" +
                    "Pengidap mata ikan rentan mengalami rasa nyeri ketika kulit yang terinfeksi ditekan. Rasa nyeri ini menjadi pembeda antara kapalan dan mata ikan. Lantas, apa yang bisa dilakukan untuk mengatasi mata ikan?\n" +
                    "\n" +
                    "Gunakan obat khusus untuk mengobati mata ikan, baik dalam bentuk cair, gel, pad, atau plester.\n" +
                    "\n" +
                    "Menggunakan batu apung. Rendam kaki dalam air hangat selama 5 menit (atau sampai kulit kaki terasa lembut), basahi batu apung dan gosokkan ke bagian kulit yang mengeras selama 2-3 menit. Setelahnya, bilas kaki hingga bersih.\n" +
                    "\n" +
                    "Pada kasus parah, diperlukan operasi untuk memotong bagian kulit yang menebal dan mengeras menggunakan pisau bedah. Operasi ini bertujuan untuk mengurangi tekanan pada jaringan di bawah area yang terinfeksi. Prosedur lain untuk mengatasi mata ikan berupa cryotherapy dan pengobatan laser.\n" +
                    "\n" +
                    "Baca Juga: Ketahui Penyakit Kaki yang Umum Terjadi pada Lansia",
            author = "Halodoc",
            imageUrl = "https://d1bpj0tv6vfxyp.cloudfront.net/articles/3bafe6f3-0afd-466a-99ae-454ed24c542b_article_image_url.webp",
            date = "10 Juli 2019"
        ),

        ArticleModel(
            id = 18,
            category = "Vitiligo",
            title = "Tiba-Tiba Kulit Memar, Waspadai 5 Penyakit Ini",
            content = "Halodoc, Jakarta – Vitiligo adalah kondisi kulit berupa kehilangan pigmen melanin di area tertentu, sehingga menyebabkan bercak putih pada kulit. Ini terjadi ketika sel-sel melanosit yang memproduksi melanin di kulit hancur atau tidak berfungsi dengan baik.\n" +
                    "\n" +
                    "Kondisi ini mempengaruhi sekitar 1% dari populasi dunia dan dapat terjadi pada orang dari segala usia, jenis kelamin, dan etnis. Lalu, apakah vitiligo bisa sembuh?\n" +
                    "\n" +
                    "Sampai saat ini, tidak ada obat yang dapat menyembuhkannya sepenuhnya. Namun, ada beberapa cara untuk mengatasi gejalanya dan mengembalikan warna kulit yang hilang.\n" +
                    "\n" +
                    "Vitiligo termasuk penyakit fotosensitif, artinya area yang terkena lebih sensitif terhadap sinar matahari.\n" +
                    "\n" +
                    "Apakah dan seberapa banyak tambalan akan menyebar sulit untuk diprediksi. Penyebaran dapat berlangsung selama berminggu-minggu atau tetap stabil selama berbulan-bulan atau bertahun-tahun. \n" +
                    "\n" +
                    "Dalam menangani kondisi tersebut, kamu dapat membaca artikel mengenai Penanganan yang Bisa Dilakukan Terhadap Pengidap Vitiligo.\n" +
                    "\n" +
                    "Fakta-fakta Vitiligo\n" +
                    "Vitiligo adalah kondisi kulit yang tidak umum, tetapi dapat terjadi pada siapa saja tanpa pandang usia, jenis kelamin, atau etnis. Berikut adalah beberapa fakta yang perlu kamu ketahui:\n" +
                    "\n" +
                    "Vitiligo adalah kondisi kulit karena kekurangan melanin, pigmen yang memberikan warna pada kulit. Ketika sel-sel melanosit di kulit tidak dapat memproduksi cukup melanin atau mati, bercak putih atau depigmentasi muncul pada kulit. Ini dapat terjadi pada area mana saja di tubuh dan dapat mempengaruhi rambut, bulu mata, dan alat kelamin juga.\n" +
                    "Vitiligo adalah kondisi autoimun, artinya sistem kekebalan tubuh seseorang menyerang dan menghancurkan sel-sel melanosit dalam tubuh mereka. Sejumlah faktor lain seperti keturunan, tekanan emosional, dan lingkungan juga dapat berperan dalam perkembangan kondisi ini.\n" +
                    "Vitiligo tidak menular dan tidak menimbulkan rasa sakit atau ketidaknyamanan fisik. Namun, kondisi ini dapat mempengaruhi kualitas hidup seseorang karena dapat mengganggu penampilan mereka dan menyebabkan perasaan cemas atau rendah diri.\n" +
                    "Vitiligo tidak dapat sembuh, tetapi beberapa terapi dapat membantu mengembalikan warna kulit dan mengontrol gejalanya. Fototerapi, obat-obatan, dan operasi transplantasi sel-sel melanosit dapat membantu meningkatkan produksi melanin dan memperbaiki pigmentasi kulit.\n" +
                    "Selain perawatan medis, perubahan gaya hidup juga dapat membantu mengelola vitiligo. Ini termasuk menghindari paparan sinar matahari yang berlebihan, mengonsumsi makanan sehat dan bergizi, dan menjaga tubuh agar tetap terhidrasi dengan baik.\n" +
                    "Vitiligo lebih sering terjadi pada orang dengan kulit gelap daripada kulit putih. Namun, kondisi ini dapat terjadi pada siapa saja tanpa pandang usia, jenis kelamin, atau etnis.\n" +
                    "Vitiligo dapat berdampak pada kesehatan mental seseorang. Orang dengan vitiligo mungkin mengalami perasaan cemas, depresi, atau rendah diri akibat perubahan kondisi kulit.\n" +
                    "Ada banyak selebriti terkenal dan atlet yang juga mengalami vitiligo. Ini termasuk Michael Jackson, Winnie Harlow, dan Jon Hamm.\n" +
                    "Vitiligo tidak dapat sembuh dengan obat-obatan topikal atau lotion kulit yang terjual bebas. Pengobatan harus di bawah pengawasan dokter kulit yang berkualifikasi.\n" +
                    "Pengobatan Vitiligo\n" +
                    "Cara untuk mengobati vitiligo tergantung pada usia, seberapa banyak kulit terlibat, seberapa cepat penyakitnya telah berkembang dan bagaimana pengaruhnya.\n" +
                    "\n" +
                    "Kamu bisa hubungi Daftar Dokter Kulit di Halodoc yang Bisa Bantu Pengobatan Vitiligo untuk meminta saran dan konsultasi mengenai vitiligo.\n" +
                    "\n" +
                    "Obat-obatan dan terapi berbasis cahaya tersedia untuk membantu mengembalikan warna kulit atau meratakan warna kulit, meskipun hasilnya bervariasi dan tidak dapat diprediksi.\n" +
                    "\n" +
                    "Beberapa perawatan memiliki efek samping yang serius. Berikut adalah beberapa pengobatan vitiligo yang bisa dilakukan:\n" +
                    "\n" +
                    "1. Obat-obatan\n" +
                    "Tidak ada obat yang dapat menghentikan proses vitiligo dengan menghilangkan sel pigmen (melanosit). Tetapi beberapa obat dengan terapi cahaya dapat membantu mengembalikan warna kulit.\n" +
                    "\n" +
                    "Mengoleskan krim kortikosteroid terhadap kulit yang terkena dapat mengembalikan warna. Pengobatan ini paling efektif ketika vitiligo masih dalam tahap awal.\n" +
                    "\n" +
                    "Jenis krimnya efektif dan mudah digunakan, tetapi tidak dapat melihat perubahan warna kulit selama beberapa bulan. Efek samping yang mungkin timbul antara lain penipisan kulit atau munculnya guratan atau garis pada kulit.\n" +
                    "\n" +
                    "Bentuk obat yang lebih ringan dapat diresepkan untuk anak-anak dan untuk orang yang memiliki area kulit yang berubah warna. Pil atau suntikan kortikosteroid mungkin menjadi pilihan bagi orang yang kondisinya berkembang pesat.\n" +
                    "\n" +
                    "Obat yang mempengaruhi sistem kekebalan tubuh. Salep penghambat calcineurin, seperti tacrolimus (Protopic) atau pimecrolimus (Elidel) secara efektif bagi orang dengan area depigmentasi kecil, terutama pada wajah dan leher.\n" +
                    "\n" +
                    "Namun, Food and Drug Administration (FDA) telah memperingatkan tentang hubungan antara obat-obatan ini dengan limfoma dan kanker kulit.\n" +
                    "\n" +
                    "2. Terapi\n" +
                    "Fototerapi dengan narrow band ultraviolet B (UVB) telah terbukti menghentikan atau memperlambat perkembangan vitiligo aktif.\n" +
                    "\n" +
                    "Terlebih jika digunakan bersamaan dengan kortikosteroid atau penghambat kalsineurin. Terapi ini membutuhkan persetujuan dokter terkait dengan manfaat dan risikonya.\n" +
                    "\n" +
                    "Perangkat portabel atau genggam yang lebih kecil untuk terapi ultraviolet B band sempit tersedia untuk digunakan di rumah. \n" +
                    "\n" +
                    "Efek samping yang mungkin timbul dari terapi ultraviolet B pita sempit meliputi kemerahan, gatal, dan rasa terbakar. Efek samping ini biasanya hilang dalam beberapa jam setelah perawatan.\n" +
                    "\n" +
                    "3. Operasi\n" +
                    "Jika terapi cahaya dan pengobatan tidak berhasil, beberapa orang dengan penyakit yang stabil mungkin akan melakukan operasi. Hal ini bermaksud untuk meratakan warna kulit dengan mengembalikan warna.\n" +
                    "\n" +
                    "Pencangkokan kulit dengan memindahkan sebagian kecil yang sehat dan berpigmen ke are yang telah hilang pigmennya. Prosedur ini terkadang digunakan jika terdapat bercak kecil.\n" +
                    "\n" +
                    "Risiko yang mungkin terjadi antara lain infeksi, jaringan parut, penampilan seperti batu bulat, warna jerawatan, dan kegagalan area untuk berubah warna.\n" +
                    "\n" +
                    "Dalam memperingati Hari Vitiligo dalam rangka sebagai upaya untuk menyadarkan terhadap dunia terkait dengan penyakit vitiligo, dan ada orang-orang yang berjuang dengan vitiligo. ",
            author = "Halodoc",
            imageUrl = "https://d1vbn70lmn1nqe.cloudfront.net/prod/wp-content/uploads/2023/04/18033343/Apakah-Vitiligo-Dapat-Disembuhkan_-Ini-Faktanya.jpg.webp",
            date = "25 Juni 2023"
        ),


        ArticleModel(
            id = 19,
            category = "Vitiligo",
            title = "Mengidap Vitiligo, Ini Penanganan yang Bisa Dilakukan",
            content = "Halodoc, Jakarta - Vitiligo adalah kondisi yang menyebabkan kulit pada bagian tubuh tertentu kehilangan warnanya. Kondisi ini bisa terjadi pada siapa saja, tanpa memandang ras. Namun, perubahan warna kulit paling terlihat di antara orang-orang dengan warna kulit yang cenderung gelap, karena kontras antara warna kulit normal dan bercak putih yang telah terindikasi vitiligo terlihat jelas.\n" +
                    "\n" +
                    "Orang dengan gangguan penyakit ini mengalami kehilangan warna di berbagai area kulit yang terpapar. Beberapa terjadi pada bagian mulut, rambut di kulit kepala, atau bulu mata maupun alis.\n" +
                    "\n" +
                    "Vitiligo adalah hasil dari melanosit kulit yang dihancurkan. Melanosit adalah sel di dalam kulit yang memproduksi melanin yang bertanggung jawab untuk memberikan warna pada kulit. Pada beberapa kondisi, gangguan kesehatan ini dianggap sebagai penyakit autoimun, ketika tubuh keliru dan menghancurkan melanositnya sendiri.\n" +
                    "\n" +
                    "Baca juga: Apakah Vitiligo Dapat Disembuhkan? Ini Faktanya?\n" +
                    "\n" +
                    "Pada dasarnya, ada dua jenis vitiligo, yaitu non-segmental yang lebih sering ditemui dan segmental yang hanya terjadi pada satu area. Pasien dengan kondisi kesehatan ini mengalami bercak putih pada kedua sisi bagian tubuh. Sementara untuk vitiligo segmental hanya terjadi pada satu area. Setidaknya, sekitar 10 persen kasus penyakit ini masuk ke dalam segmental. Penyakit kelainan kulit ini biasanya menyerang orang-orang muda, seringnya dimulai pada usia 20 tahun.\n" +
                    "\n" +
                    "Penanganan Vitiligo\n" +
                    "Perawatan vitiligo didasarkan pada perbaikan penampilan kulit dengan mengembalikan warnanya. Efek pengobatannya tidak permanen dan tidak selalu dapat mengendalikan penyebaran. Dokter dapat merekomendasikan pemberian obat-obatan dan perlindungan terhadap paparan sinar matahari.\n" +
                    "\n" +
                    "Baca juga: Ketahui Penyebab Seseorang Bisa Terkena Vitiligo\n" +
                    "\n" +
                    "Perlindungan dari Matahari\n" +
                    "Sinar matahari adalah risiko yang harus dihindari bagi pengidap vitiligo. Ketika kulit terpapar sinar matahari, akan terbentuk pigmen kulit melanin untuk melindungi dari sinar UV. Namun, pengidap vitiligo tidak memiliki cukup melanin, sehingga kulit tidak mampu terlindungi dari paparan sinar UV. Sebagai tindakan perlindungan, gunakan pelembap dengan tingkat SPF yang tinggi.\n" +
                    "\n" +
                    "Vitamin D\n" +
                    "Jika kulit tidak terpapar sinar matahari, ada peningkatan risiko kekurangan vitamin D. Pasalnya, vitamin D sangat penting untuk menjaga kesehatan tulang dan gigi. Sinar matahari adalah sumber vitamin D paling utama, meski bisa juga diperoleh dari minyak ikan. Meski begitu, mungkin juga diperlukan suplemen asupan vitamin D.\n" +
                    "\n" +
                    "Kortikosteroid Topikal\n" +
                    "Ini merupakan jenis obat yang mengandung steroid. Obat ini dioleskan ke kulit dalam bentuk krim atau salep. Biasanya, bercak putih berhenti menyebar dan warna kulit asli di beberapa bagian tubuh akan kembali.\n" +
                    "\n" +
                    "Baca juga: Memakai Skin Care yang Salah Bisa Memicu Terkena Vitiligo?\n" +
                    "\n" +
                    "Kortikosteroid topikal dapat diresepkan untuk orang dewasa, jika memiliki vitiligo nonsegmental kurang dari 10 persen, tidak sedang hamil untuk wanita, dan ingin melakukan perawatan lanjutan. Obat salep kortikosteroid topikal bisa diaplikasikan pada wajah, tetapi tetap harus cermat dalam memilih dan menggunakan obat jenis ini di wajah.\n" +
                    "\n" +
                    "Obat yang Memengaruhi Sistem Kekebalan Tubuh\n" +
                    "Selain kortikosteroid, salep inhibitor kalsineurin seperti tacrolimus atau pimecrolimus mungkin juga efektif untuk orang-orang yang mengalami depigmentasi kecil, terutama pada wajah dan leher. Namun, Badan Pengawas Obat dan Makanan Amerika Serikat (FDA) memperingatkan tentang adanya kemungkinan obat-obatan tersebut dapat meningkatkan risiko limfoma dan kanker kulit.",
            author = "Halodoc",
            imageUrl = "https://d1bpj0tv6vfxyp.cloudfront.net/articles/a431608f-cd5e-4e17-b8a2-2936558bcfbf_article_image_url.webp",
            date = "29 April 2020"
        ),


        ArticleModel(
            id = 20,
            category = "Vitiligo",
            title = "Ketahui Penyebab Seseorang Bisa Terkena Vitiligo",
            content = "Halodoc, Jakarta – Vitiligo adalah sebuah kondisi di mana sebagian kulit kehilangan warna alaminya. Hal ini membuat kulit, seperti mendapatkan tambalan dengan warna kulit yang lebih terang ketimbang warna kulit yang asli.\n" +
                    "\n" +
                    "Selain kulit, vitiligo juga dapat memengaruhi bagian lain dari tubuh. Misalnya, rambut bisa berubah menjadi putih, di mana beberapa orang kehilangan warna di dalam mulut, bahkan juga berpengaruh pada mata.\n" +
                    "\n" +
                    "Beberapa orang dengan vitiligo sering kehilangan mengembangkan harga diri yang rendah. Tidak ingin bergaul dengan lingkungan sosialnya, bahkan sampai mengalami depresi serius. Penyebab vitiligo terjadi ketika sel-sel penghasil pigmen (melanosit) mati atau berhenti memproduksi melanin. Pigmen yang memberi warna kulit, rambut, dan mata. Bagian-bagian kulit yang terkena menjadi lebih terang atau putih. Terkait mengapa sel-sel tersebut gagal atau mati bisa dikarenakan:\n" +
                    "\n" +
                    "Gangguan di mana sistem kekebalan tubuh menyerang dan menghancurkan melanosit di kulit\n" +
                    "Riwayat keluarga (keturunan)\n" +
                    "Kejadian pemicu, seperti terbakar sinar matahari, stres, ataupun paparan bahan kimia industri.\n" +
                    "Orang dengan vitiligo sangat tinggi risiko mengalami stres lewat pergaulan sosial atau kondisi psikologis lebih rentan mengalami sunburn dan kanker kulit, masalah mata, seperti radang iris (iritis) dan kehilangan pendengaran.\n" +
                    "\n" +
                    "Pahami Tanda dan Gejalanya\n" +
                    "Tanda utama vitiligo adalah hilangnya warna kulit secara merata. Biasanya, perubahan warna pertama kali terlihat di area yang terkena sinar matahari, seperti tangan, kaki, lengan, wajah dan bibir. Tanda-tanda Vitiligo yang lain termasuk:\n" +
                    "\n" +
                    "Kerontokan warna kulit\n" +
                    "Rambut memutih secara prematur pemutih mulai dari rambut di kulit kepala, bulu mata, alis atau janggut\n" +
                    "Hilangnya warna di jaringan yang melapisi bagian dalam mulut dan hidung (selaput lendir)\n" +
                    "Hilang atau berubahnya warna lapisan bagian dalam bola mata (retina)\n" +
                    "Vitiligo dapat mulai pada usia berapa pun, tetapi sering muncul sebelum usia 20. Tergantung dari jenis vitiligo yang dimiliki. Misalnya, kalau di mana bercak yang berubah warna dapat meliputi hampir keseluruhan kulit tubuh disebut vitiligo umum. Ketika bercak yang berubah warna sering berkembang sama pada bagian tubuh yang bersesuaian (secara simetris) atau hanya satu sisi atau bagian dari tubuh maka jenis ini disebut vitiligo segmental. Tipe ini cenderung terjadi pada usia yang lebih muda, berlangsung selama satu atau dua tahun, lalu berhenti. Kalau hanya satu atau hanya beberapa area tubuh saja maka tipe ini disebut vitiligo lokal (fokal).\n" +
                    "\n" +
                    "Sulit untuk memprediksi bagaimana penyakit vitiligo ini akan akan berkembang. Terkadang perubahan warna bisa saja tiba-tiba berhenti terbentuk tanpa perawatan. Dalam banyak kasus, kehilangan pigmen menyebar dan akhirnya melibatkan sebagian besar kulitmu, sehingga jarang kulit mendapatkan warnanya kembali.\n" +
                    "\n" +
                    "Penting buat kamu untuk menemui dokter dan berkonsultasi mengenai penanganannya. Vitiligo tidak memiliki obat. Namun, perawatan dapat membantu menghentikan atau memperlambat proses perubahan warna dan mengembalikan warna kulit.",
            author = "Halodoc",
            imageUrl = "https://d1bpj0tv6vfxyp.cloudfront.net/articles/e43327df-05e9-47f0-a13f-9336bffbb8e1_article_image_url.webp",
            date = "18 Desember 2018"
        ),


        ArticleModel(
            id = 21,
            category = "Vitiligo",
            title = "Ketahui Fakta Fototerapi untuk Menangani Vitiligo",
            content = "Halodoc, Jakarta – Salah satu kelainan yang bisa menyerang kulit adalah vitiligo. Penyakit ini menyebabkan warna kulit memudar dan bisa terjadi pada wajah, bibir, tangan, kaki, lalu menyebar ke bagian tubuh lain. Vitiligo bisa terjadi pada siapa saja, tapi lebih rentan terjadi pada remaja berusia 20 tahun. Perubahan warna kulit pada pengidap vitiligo disebabkan karena tubuh berhenti memproduksi pigmen.\n" +
                    "\n" +
                    "Ada beberapa jenis pengobatan yang bisa dilakukan untuk mengatasi vitiligo, salah satunya terapi sinar UV alias fototerapi. Terapi ini dilakukan jika vitiligo telah menyebar luas dan tidak bisa ditangani dengan obat oles. Sinar UV dipaparkan ke area kulit yang terinfeksi vitiligo. Sebelum prosedur ini dilakukan, pengidap diberi psoralen agar kulitnya lebih sensitif pada sinar UV.\n" +
                    "\n" +
                    "Baca Juga: Memakai Skincare yang Salah, Bisa Memicu Terkena Vitiligo?\n" +
                    "\n" +
                    "Cara Mengobati Vitiligo\n" +
                    "Perubahan warna kulit pada pengidap vitiligo disebabkan karena tubuh berhenti memproduksi pigmen. Akibatnya, muncul bercak putih yang kontras dengan warna kulit asli. Berhentinya produksi pigmen tubuh disebabkan oleh kelainan genetik, penyakit autoimun, stres, kulit terbakar akibat paparan sinar UV matahari, serta paparan bahan kimia.\n" +
                    "\n" +
                    "Segera bicara pada dokter jika warna rambut, kulit, dan mata memudar. Sebab bisa jadi, perubahan warna ini menjadi tanda vitiligo. Biasanya dokter melakukan diagnosis vitiligo lewat pemeriksaan kulit menggunakan lampu ultraviolet. Setelah diagnosis ditetapkan, pengidap vitiligo diobati dengan konsumsi obat, fototerapi, hingga pembedahan. Atau kamu bisa menggunakan aplikasi Halodoc untuk berbicara pada dokter.\n" +
                    "\n" +
                    "Sampaikan gejala yang dialami melalui Video/Voice Call dan Chat. Kamu juga bisa menyampaikan keluhan atau gejala penyakit lain. Dapatkan informasi seputar kesehatan dan tips hidup sehat dari dokter terpercaya. Kamu bisa download aplikasi Halodoc di App Store dan Google Play!\n" +
                    "\n" +
                    "Baca Juga: Serba-Serbi Bayi Kuning, Ini yang Perlu Diketahui\n" +
                    "\n" +
                    "Fototerapi untuk mengatasi vitiligo umumnya dilakukan sebanyak tiga kali tiap minggu selama 6–12 bulan. Prosedur ini dikombinasikan dengan terapi laser, obat prednisolon, vitamin D, dan obat azathioprine yang berpengaruh pada daya tahan tubuh. Sama seperti terapi lainnya, fototerapi memiliki efek samping yang perlu diwaspadai. Paparan sinar UV yang dipaparkan tidak sesuai standar bisa merusak kulit, memicu penuaan dini, hingga meningkatkan risiko kanker kulit.\n" +
                    "\n" +
                    "Fototerapi yang dilakukan terlalu sering bisa menekan sistem kekebalan tubuh (imunosupresan), membuat tubuh rentan terhadap infeksi penyakit. Efek samping lain yang perlu diwaspadai adalah mata lebih sensitif terhadap cahaya dan risiko katarak meningkat. Fototerapi tidak dianjurkan pada ibu hamil, ibu menyusui, orang yang memiliki riwayat keluarga dengan kanker kulit, serta pengidap penyakit hati dan lupus.\n" +
                    "\n" +
                    "Selain fototerapi, ada beberapa cara pengobatan lain yang juga bisa diterapkan untuk mengatasi vitiligo, seperti penggunaan obat oles dan konsumsi obat-obatan tertentu hingga prosedur bedah. Pada pengidap vitiligo, prosedur bedah akan dilakukan jika fototerapi tidak memberi efek yang baik. Prosedur bedah yang bisa dilakukan adalah cangkok kulit, blister grafting, serta mikropigmentasi.\n" +
                    "\n" +
                    "Baca Juga: Apakah Vitiligo Dapat Disembuhkan? Ini Faktanya",
            author = "Halodoc",
            imageUrl = "https://d1bpj0tv6vfxyp.cloudfront.net/articles/f5c2e834-b919-4c5e-9610-aea98a737241_article_image_url.webp",
            date = "07 April 2020"
        ),


        ArticleModel(
            id = 22,
            category = "Vitiligo",
            title = "Vitiligo pada Anak dan Dewasa, Apa Bedanya?",
            content = "Halodoc, Jakarta – Vitiligo adalah masalah jangka panjang di mana bercak kulit yang tumbuh kehilangan warna. Ini dapat memengaruhi orang-orang dari segala usia, jenis kelamin, atau kelompok etnis.\n" +
                    "\n" +
                    "Bercak muncul ketika melanosit di dalam kulit mati. Melanosit adalah sel yang bertanggung jawab untuk memproduksi pigmen kulit, melanin, memberi warna kulit, dan melindunginya dari sinar UV matahari.\n" +
                    "\n" +
                    "Tingkat dan distribusi vitiligo sering berubah selama masa hidup seseorang dan perkembangannya tidak dapat diprediksi. Program terbatas kortikosteroid topikal yang manjur pada orang dewasa dan anak-anak adalah terapi yang aman dan efektif untuk vitiligo yang dilokalisasi dan seringkali merupakan pengobatan pilihan pertama untuk ini.\n" +
                    "\n" +
                    "Kortikosteroid topikal adalah jenis obat yang mengandung steroid. Kamu bisa mengoleskannya ke kulit sebagai krim atau salep. Kadang-kadang mengaplikasikan pengobatan ini dapat menghentikan penyebaran bercak putih dan dapat mengembalikan beberapa warna kulit aslimu.\n" +
                    "\n" +
                    "Baca juga: Ketahui Seseorang Bisa Terkena Vitiligo\n" +
                    "\n" +
                    "Vitiligo pada Anak\n" +
                    "Anak-anak dari semua ras bisa dipengaruhi oleh vitiligo di mana bintik-bintik cenderung lebih terlihat pada mereka yang memiliki kulit lebih gelap. Kadang-kadang anak-anak dengan vitiligo memiliki gejala-gejala lain, seperti rambut beruban prematur atau hilangnya pigmen pada bibir, karena sel-sel pigmen juga ditemukan di tempat-tempat ini.\n" +
                    "\n" +
                    "Teori bervariasi tentang apa yang menyebabkan vitiligo. Beberapa ahli berpikir itu adalah gangguan autoimun di mana sistem kekebalan tubuh secara keliru menyerang melanosit yang sehat. Yang lain berpikir itu adalah kondisi genetik, karena lebih dari 30 persen anak-anak yang terkena dampak memiliki anggota keluarga yang juga memilikinya.\n" +
                    "\n" +
                    "Perlu untuk diketahui adalah bahwa risiko pengembangan vitiligo meningkat pada anak-anak dengan keluarga atau riwayat pribadi penyakit tiroid, diabetes, dan kondisi tertentu seperti alopecia (penyakit autoimun yang menyebabkan kerontokan rambut). Dan vitiligo tidak pernah menular. Ini artinya anak-anak tidak bisa mendapatkannya dari orang lain.\n" +
                    "\n" +
                    "Dalam pemeriksaan, dokter juga akan mengajukan banyak pertanyaan tentang riwayat kesehatan anak, termasuk apakah ada anggota keluarga yang memiliki masalah kulit atau masalah autoimun di masa lalu. Apakah anak baru-baru ini mengalami ruam atau terbakar sinar matahari atau mengidap penyakit lain atau sedang stres. Tes darah dapat dilakukan untuk memeriksa masalah tiroid dan diabetes, karena ini dapat meningkatkan risiko vitiligo.\n" +
                    "\n" +
                    "Sangat jarang, dokter dapat melakukan biopsi (di mana sepotong kecil dari kulit yang terkena dihilangkan untuk dianalisis di laboratorium). Biopsi memungkinkan dokter memeriksa sel-sel pigmen di kulit. Jika biopsi menunjukkan tidak ada sel pigmen, ini dapat mengkonfirmasi kasus vitiligo.\n" +
                    "\n" +
                    "Baca juga: Apakah Vitiligo Dapat Disembuhkan? Ini Faktanya\n" +
                    "\n" +
                    "Vitiligo pada Orang Dewasa\n" +
                    "Vitiligo dapat terjadi pada semua usia, namun biasanya dimulai antara usia 2 dan 40 tahun. Semua ras mungkin terpengaruh. Meskipun kepercayaan umum, vitiligo tidak terlihat lebih sering pada individu keturunan Afrika; ini mungkin tampak benar hanya karena kondisi tersebut menyebabkan masalah kosmetik yang lebih jelas bagi orang yang berkulit gelap.\n" +
                    "\n" +
                    "Perlindungan dan perawatan pada orang dewasa disarankan untuk hindari paparan sinar matahari tengah hari (10 pagi hingga 3 sore), kenakan tabir surya SPF 45, kenakan pakaian pelindung dan topi, serta menggunakan makeup kosmetik untuk melindungi bercak-bercak putih.\n" +
                    "\n" +
                    "Dampak emosional pada anak pengidap vitiligo lebih besar ketimbang pada orang dewasa. Jika anak mengidap vitiligo, orangtua wajib tahu meskipun itu tidak berbahaya bagi kesehatan fisiknya, itu masih bisa menjadi masalah besar untuk kondisi emosionalnya.\n" +
                    "\n" +
                    "Baca juga: Ketahui Fakta Fototerapi untuk Menangani Vitiligo\n" +
                    "\n" +
                    "Setiap kondisi yang membuat anak-anak terlihat berbeda dari teman sebayanya dapat menjadi sangat sulit secara emosional, terutama selama masa praremaja dan remaja ketika semua orang berusaha keras untuk menyesuaikan diri.\n" +
                    "\n" +
                    "Beberapa anak secara alami lebih tangguh dan baik-baik saja terhadap tantangan ini. Tapi, yang lain membutuhkan sedikit bantuan. Orangtua dapat melakukan banyak hal untuk membangun rasa percaya diri dan harga diri.",
            author = "Halodoc",
            imageUrl = "https://d1bpj0tv6vfxyp.cloudfront.net/articles/02109ed0-b930-42ab-b1bf-6260f9ec4ced_article_image_url.webp",
            date = "26 Maret 2019"
        ),


        ArticleModel(
            id = 23,
            category = "Vitiligo",
            title = "Catat, Ini Perbedaan Penyakit Vitiligo dan Albinisme",
            content = "Halodoc, Jakarta – Penyakit vitiligo dan albinisme adalah dua kondisi yang kerap dianggap serupa bagi orang awam. Padahal keduanya adalah gangguan yang berbeda dari segala aspek. \n" +
                    "\n" +
                    "Perbedaan Antara Penyakit Vitiligo dan Albinisme\n" +
                    "1. Apa Itu Penyakit Vitiligo dan Albinisme?\n" +
                    "Vitiligo adalah penyakit autoimun dan kondisi kulit yang berkembang saat tubuh kehilangan melanosit, yaitu sel yang menghasilkan pigmen pemberi warna pada kulit (melanin). Hal ini menyebabkan adanya bercak kulit putih di beberapa bagian tubuh.\n" +
                    "\n" +
                    "Sementara albinisme adalah kelainan genetik yang berkembang ketika tubuh produksi melanin tidak tercukupi. Hal ini memberi kulit penampilan yang terang atau benar-benar putih, bahkan jika tidak memiliki keturunan kulit putih.\n" +
                    "\n" +
                    "2. Perbedaan Gejala dari Penyakit Vitiligo dan Albinisme\n" +
                    "Gejala utama dari vitiligo adalah bercak putih pada kulit. Ada beberapa area tertentu yang paling sering mengalaminya, yaitu tubuh, tangan, kaki, serta wajah. Meski begitu, semua bagian tubuh memiliki risiko untuk mengalaminya, termasuk kulit kepala dan rambut.\n" +
                    "\n" +
                    "Untuk albinisme, gejala utama yang umum dirasakan, yaitu kulit, rambut, dan mata yang sangat pucat. Berbeda dengan vitiligo yang tidak memengaruhi mata sama sekali. Selain itu, gejala lainnya yang bisa dirasakan adalah:\n" +
                    "\n" +
                    "Mata juling.\n" +
                    "Mengalami fotophobia, yaitu terlalu peka terhadap cahaya.\n" +
                    "Mengidap gerakan mata cepat yang tidak disengaja (nistagmus).\n" +
                    "Mengalami kebutaan atau gangguan penglihatan.\n" +
                    "Mengalami astigmatisme, yaitu kelengkungan mata yang tidak normal.\n" +
                    "3. Perbedaan Penyebab dari Penyakit Vitiligo dan Albinisme\n" +
                    "Untuk penyakit vitiligo, penyebabnya belum diketahui secara pasti. Namun, ada beberapa faktor risiko yang berhubungan dengan perkembangan penyakit ini, seperti autoimunitas, mutasi genetik, mengidap jenis kanker tertentu (kanker kulit), hingga paparan berlebihan oleh neurochemical.\n" +
                    "\n" +
                    "Pada albinisme, kondisi ini bisa terjadi turun-temurun dan bahkan diturunkan oleh orangtua yang mengidap kelainan yang sama. Hal ini juga dapat dipengaruhi oleh gen yang berkembang dari kombinasi orangtuanya. Sehingga, hal ini dapat memengaruhi tubuh dalam memproduksi melanin.\n" +
                    "\n" +
                    "4. Cara Mengobati Penyakit Vitiligo dan Albinisme\n" +
                    "Sejauh ini, belum ada pengobatan yang dapat dilakukan untuk mengatasi vitiligo. Untuk perawatan sendiri hanya dilakukan untuk mengatasi perasaan rendah diri atau gejala depresi.\n" +
                    "\n" +
                    "Selain itu, penanganan tambahan dibutuhkan untuk menghentikan kehilangan melanosit lebih lanjut, serta memperlambat respons kekebalan agar kerusakan lebih parah tidak terjadi pada sel.\n" +
                    "\n" +
                    "Beberapa pengobatan yang bisa dilakukan, antara lain:\n" +
                    "\n" +
                    "Fototerapi\n" +
                    "Pembedahan\n" +
                    "Kortikosteroid topikal\n" +
                    "Pada kondisi albinisme, pengobatan yang dilakukan sejauh ini fokus pada masalah mata yang berkembang. Beberapa perawatan yang bisa dilakukan, yaitu:\n" +
                    "\n" +
                    "Penggunaan kacamata atau lensa kontak.\n" +
                    "Penggunaan alat bantu penglihatan lainnya, seperti kaca pembesar.\n" +
                    "Penggunaan kacamata hitam untuk melindungi mata dari sinar matahari.\n" +
                    "Melakukan senam mata agar masalah mata bisa jadi lebih baik.\n" +
                    "Itulah berbagai perbedaan antara penyakit vitiligo dengan albinisme. Meski mirip, keduanya jauh berbeda dari penyebab, gejala, serta cara pengobatannya. Jika masih ragu kamu mengalami kondisi yang mana, sebaiknya segera melakukan pemeriksaan sedini mungkin.",
            author = "Halodoc",
            imageUrl = "https://d1vbn70lmn1nqe.cloudfront.net/prod/wp-content/uploads/2022/11/28104828/catat-ini-perbedaan-penyakit-vitiligo-dan-albinisme-halodoc.jpg.webp",
            date = "28 November 2022"
        ),


        ArticleModel(
            id = 24,
            category = "Perawatan Kulit",
            title = "6 Masker Alami untuk Perawatan Kulit Kering",
            content = "Halodoc, Jakarta - Kulit kamu secara alami menghasilkan minyak yang disebut dengan sebum, yang membantu melindungi kulit kering. Namun, ada beberapa kebiasaan, seperti lupa menggunakan pelembap, yang dapat menghilangkan minyak alami dari kulit. Jika kamu kehilangan minyak alami kulit, menggunakan minyak dapat membantu mengembalikan kilau dan pelindung kulit. \n" +
                    "\n" +
                    "Ada banyak manfaat pelembap yang berasal dari minyak alami yang dapat dibuat masker sebagai perawatan natural. Selain minyak, ada juga bahan alami yang bisa kamu dapatkan dari buah ataupun tumbuh-tumbuhan seperti lidah buaya. Untuk lebih jelasnya, catat rekomendasi bahan masker natural di bawah ini:\n" +
                    "\n" +
                    "1. Minyak Kelapa\n" +
                    "Ini adalah minyak yang kemungkinan besar ada di lemari dapur dan juga menjadi pilihan yang baik bagi kamu yang rentan terhadap kekeringan kulit dan jerawat. Orang dengan dermatitis atopik, sejenis eksim dan kondisi kulit alergi yang ditandai oleh kekeringan dan gatal, biasanya mendapatkan hasil yang sangat baik saat mereka menggunakan minyak kelapa murni pada kulit mereka. \n" +
                    "\n" +
                    "Baca juga: 5 Perawatan Kulit Kering yang Patut Dicoba\n" +
                    "\n" +
                    "2. Lidah Buaya dan Mentimun\n" +
                    "Lidah buaya merupakan tanaman yang memiliki sifat penyembuhan secara alami. Tanaman ini dapat diresapi dalam minyak dan digunakan sebagai pelembap alami. Kamu juga dapat menggunakan lidah buaya untuk menenangkan kulit yang terbakar sinar matahari. Lidah buaya dapat melembabkan, menyembuhkan, dan membantu menunda proses penuaan.\n" +
                    "\n" +
                    "Kamu tetap dapat menggunakan lidah buaya meski memiliki kulit yang sehat. Sebagai manfaat tambahan, gunakan juga mentimun dalam resep masker alami kamu. Timun menyumbang sifat pendingin dan pembersih yang baik. Sederhana kan?\n" +
                    "\n" +
                    "3. Minyak Zaitun \n" +
                    "Minyak alami ini bagus untuk digunakan, fungsinya sebagai pembersih dan pelembap alami. Cukup oleskan minyak zaitun ke kulit kamu dan usapkan kain hangat yang basah di wajah kamu hingga dingin, lalu bersihkan sisa minyak. Minyak zaitun merupakan pilihan yang baik sebagai pembersih karena tidak akan menghilangkan minyak alami kulit kamu, tapi justru membersihkan kulit kamu. \n" +
                    "\n" +
                    "Baca juga: Kulit Kering dan Gatal Jangan Digaruk, Atasi Dengan Ini\n" +
                    "\n" +
                    "4. Masker Buah Alpukat\n" +
                    "Membuat masker dari buah alpukat adalah cara natural untuk menenangkan kulit kering. Coba buat masker alpukat dengan memotongnya, lalu campurkan dengan satu sendok teh minyak zaitun. Kamu juga dapat menambahkan satu sendok makan madu untuk kulit yang sangat kering. Oleskan masker ke wajah kamu, biarkan selama 15 hingga 20 menit dan kemudian cuci. \n" +
                    "\n" +
                    "5. Masker Oatmeal\n" +
                    "Tuang secangkir oatmeal ke dalam bak mandi air hangat secara alami dapat menghidrasi kulit kering kamu. Bahan oat memiliki sifat yang menenangkan dan dapat membantu kulit kamu mempertahankan kelembaban. Oatmeal juga merupakan exfoliator yang bagus. \n" +
                    "\n" +
                    "Kamu juga dapat mencampurkan 2 sendok makan gandum dengan satu sendok makan madu dan sedikit air. Hangatkan campuran tersebut, lalu gosokkan ke kulit kamu. Kamu dapat menggunakannya hanya untuk pengelupasan kulit dan mencucinya segera, atau biarkan selama 15 hingga 20 menit sebagai masker yang menenangkan dan melembapkan. \n" +
                    "\n" +
                    "Baca juga: Coba 5 Masker Alami untuk Mencerahkan Wajah\n" +
                    "\n" +
                    "6. Kompres Susu\n" +
                    "Susu memiliki sifat anti-inflamasi alami. Ia juga mengandung asam laktat, exfoliant ringan dan alami. Penggunaan kompres susu ini dapat dilakukan selama 5 hingga 10 menit setiap kalinya. Susu sangat bermanfaat untuk kulit teriritasi yang juga gatal. Asam laktat dapat menyengat kulit yang retak, meskipun digunakan secara hati-hati. ",
            author = "Halodoc",
            imageUrl = "https://d1bpj0tv6vfxyp.cloudfront.net/articles/e0bc1407-2d28-4a95-b4f3-242fd9c311dd_article_image_url.webp",
            date = "05 November 2019"
        ),


        ArticleModel(
            id = 25,
            category = "Perawatan Kulit",
            title = "Kulit Kering dan Berjerawat, Ini 5 Perawatan yang Tepat",
            content = "Halodoc, Jakarta - Jerawat sering dikaitkan dengan kulit berminyak. Namun, bukan tidak mungkin juga terjadi pada kulit kering. Karena pada dasarnya apapun yang menyumbat pori-pori dapat menyebabkan jerawat. Inilah yang perlu kamu ketahui mengenai kulit kering dan berjerawat dan apa yang dapat kamu lakukan untuk merawatnya. \n" +
                    "\n" +
                    "Merawat jerawat di kulit kering bisa jadi hal yang sulit. Banyak produk perawatan kulit berjerawat yang kamu temukan di pasaran biasanya dibuat untuk orang-orang berkulit berminyak dan bisa terlalu mengeringkan untuk jenis kulit kering. Untungnya sekarang ada lebih banyak produk kulit khusus mengobati jerawat pada kulit kering. Langkah-langkah berikut akan membantu kamu dalam merawat kulit kering sambil mengendalikan jerawat.\n" +
                    "\n" +
                    "Baca juga: Cara Memilih Skincare Sesuai Jenis Kulit\n" +
                    "\n" +
                    "1. Pilih Produk yang Tepat\n" +
                    "Perlu kamu ketahui bahwa perawatan jerawat akan menyebabkan kekeringan pada kulit wajah. Obat jerawat yang dijual bebas yang mengandung pembau atau pledgets, larutan astringen, dan gel berbasis air cenderung lebih kering daripada bentuk lainnya. Kamu mungkin akan lebih menyukai perawatan berbentuk losion, krim, atau salep. Hanya saja produk seperti ini lebih emolien dan kurang kering sehingga tidak ampuh untuk jerawat. \n" +
                    "\n" +
                    "Jika kamu menggunakan obat jerawat yang diresepkan dokter kulit pada aplikasi Halodoc, beri tahu dokter bahwa kulit kamu cenderung kering sehingga ia dapat memilihkan resep yang paling tepat untuk kamu. \n" +
                    "\n" +
                    "2. Beri Kulit Waktu untuk Menyesuaikan\n" +
                    "Kekeringan, pengelupasan, dan iritasi biasanya penyesuaian yang paling tidak nyaman selama beberapa minggu pertama setelah memulai perawatan jerawat. Untuk mengatasi ini, sikap yang paling baik adalah memulai dengan perlahan dan sabar. \n" +
                    "\n" +
                    "Cobalah gunakan perawatan setiap hari atau hanya tiga hari seminggu pada awalnya sembari menunggu penyesuaian pada kulit. Jika perawatan jerawat topikal menghasilkan kemajuan yang lambat dan stabil, beri tahu dokter kulit.\n" +
                    "\n" +
                    "Dokter mungkin merekomendasikan untuk membiarkan resep obat menempel pada jerawat selama 20 atau 30 menit dan kemudian membasuhnya. Ini akan membuat kulit menyesuaikan tanpa menjadi terlalu iritasi. \n" +
                    "\n" +
                    "Baca juga: 3 Perawatan Kulit untuk Wajah Berminyak dan Berjerawat\n" +
                    "\n" +
                    "Kamu juga dapat membiarkan perawatan diatur untuk periode yang lebih lama selama beberapa minggu sampai kamu dapat membiarkannya sepanjang hari (atau malam hari) agar kulit menjadi terlalu kering. Jika kulit kering teriritasi, sebaiknya hentikan penggunaan perawatan jerawat selama beberapa hari. Beri napas pada kulit. Setelah kulit terasa lebih baik, kamu bisa memulai lagi secara perlahan untuk menggunakan obat perawatan. \n" +
                    "\n" +
                    "3. Aplikasikan Pelembab Harian\n" +
                    "\n" +
                    "Penggunaan pelembap secara teratur adalah salah satu hal terbaik yang perlu dilakukan untuk mengatasi kekeringan pada kulit. Pelembap membantu menjaga kelembaban kulit dan bertindak sebagai penghalang oklusif untuk melindungi kulit. Bubuhkan pelembap yang baik sesering yang diperlukan untuk menjaga kulit kering, tetapi setidaknya dua kali sehari. \n" +
                    "\n" +
                    "Dengan berhati-hati memilih pelembab dengan hati-hati, kamu tidak perlu khawatir pelembabnya rusak. Cari merek yang bebas minyak, noncomedogenic, atau nonacnegenic. \n" +
                    "\n" +
                    "4. Gunakan Sabun Pembersih Tanpa Busa\n" +
                    "\n" +
                    "Sabun pembersih tanpa busa, biasanya lebih kering daripada sabun yang berbusa. Coba rasakan bagaimana rasanya kulit kamu, kulit yang sangat kencang, kering, atau gatal setelah dibersihkan adalah pertanda bahwa produk tersebut bukanlah produk yang tepat. Alih-alih sabun, produk tersebut dibuat dengan deterjen sintetis yang lebih lembut. \n" +
                    "\n" +
                    "Baca juga: Alasan Kulit Berminyak Lebih Mudah Berjerawat\n" +
                    "\n" +
                    "5. Hindari Overwashing\n" +
                    "\n" +
                    "Jangan terlalu sering mencuci kulit wajah. Mencuci atau membersihkan kulit wajah dua kali sehari sudah cukup dilakukan. Jika kamu tidak berkeringat atau kotor, kamu cukup hanya mencuci muka setiap malam saja. Mencuci wajah dengan air biasa sebenarnya sudah cukup. Jika kamu perlu menghapus sisa makeup, coba gunakan pembersih makeup berbahan dasar minyak dan bebas pewangi. ",
            author = "Halodoc",
            imageUrl = "https://d1bpj0tv6vfxyp.cloudfront.net/articles/9a407713-d1c4-4c5f-900c-2064a09c0fa9_article_image_url.webp",
            date = "15 April 2020"
        ),



        ArticleModel(
            id = 26,
            category = "Perawatan Kulit",
            title = "Memahami Jenis-Jenis Kulit sebelum Menentukan Perawatan",
            content = "Halodoc, Jakarta – Faktanya, kunci dalam perawatan kulit wajah bukan terletak pada mahal atau tidaknya produk perawatan yang kamu gunakan. Salah satu kuncinya adalah memahami kebutuhan kulit wajah, dan cara untuk mengetahui kebutuhan kulit wajah adalah dengan mengetahui jenis-jenis kulit wajah yang kamu miliki.\n" +
                    "\n" +
                    "Kamu pasti pernah mendengar tentang jenis-jenis kulit, seperti normal, berminyak, kering, kombinasi, atau sensitif. Nah, penting untuk mengetahui jenis kulit yang kamu miliki. Namun, jenis kulit juga bisa berubah seiring waktu. Misalnya, orang yang lebih muda lebih cenderung memiliki jenis kulit normal, daripada orang yang lebih tua.\n" +
                    "\n" +
                    "Selain itu, jenis-jenis kulit juga bergantung pada beberapa hal. Seperti seberapa banyak air di kulit karena ia memengaruhi kenyamanan dan elastisitasnya. Kemudian seberapa berminyaknya, karena ia yang memengaruhi kelembutannya dan seberapa sensitifnya kulit. \n" +
                    "\n" +
                    "Baca juga: Cara Memilih Skincare Sesuai Jenis Kulit\n" +
                    "\n" +
                    "Ini Jenis-Jenis Kulit Wajah\n" +
                    "Berikut ini jenis-jenis kulit wajah yang perlu kamu pahami sebelum memulai perawatan kulit tertentu:\n" +
                    "\n" +
                    "Jenis Kulit Normal\n" +
                    "Memahami Jenis-jenis Kulit sebelum Menentukan Perawatan\n" +
                    "Ini adalah sebutan untuk kulit yang tidak terlalu kering dan tidak terlalu berminyak. Kulit normal memiliki beberapa ciri, seperti:\n" +
                    "\n" +
                    "Tidak ada atau sedikit ketidaksempurnaan.\n" +
                    "Tidak ada sensitivitas yang parah.\n" +
                    "Pori-pori yang hampir tidak terlihat.\n" +
                    "Wajah berseri.\n" +
                    "Jenis Kulit Kombinasi\n" +
                    "Memahami Jenis-jenis Kulit sebelum Menentukan Perawatan\n" +
                    "Jenis-jenis kulit selanjutnya adalah kulit kombinasi, yakni sebutan untuk kulit yang bisa kering atau normal di beberapa area dan berminyak di area lain, seperti zona-T (hidung, dahi, dan dagu). Banyak orang yang memiliki tipe ini. Kondisi kulit ini mungkin membutuhkan perawatan yang sedikit berbeda di area yang berbeda.\n" +
                    "\n" +
                    "Kulit kombinasi dapat memiliki:\n" +
                    "\n" +
                    "Pori-pori yang terlihat lebih besar dari biasanya, karena lebih terbuka.\n" +
                    "Komedo.\n" +
                    "Kulit mengkilap.\n" +
                    "Baca juga: Mau Kulit Semulus Artis Korea? Konsumsi 5 Superfood Ini\n" +
                    "\n" +
                    "Kulit Kering\n" +
                    "Memahami Jenis-jenis Kulit sebelum Menentukan Perawatan\n" +
                    "Mereka yang memiliki jenis kulit kering biasanya memiliki:\n" +
                    "\n" +
                    "Pori-pori yang hampir tidak terlihat.\n" +
                    "Terlihat agak kusam dan kulit kasar.\n" +
                    "Bercak merah\n" +
                    "Kurang elastis\n" +
                    "Garis halus yang lebih terlihat\n" +
                    "Kulit kering bisa mengalami kondisi seperti pecah-pecah, mengelupas, atau menjadi gatal, teriritasi, atau meradang. Jika sangat kering, bisa menjadi kasar dan bersisik, terutama di area lain di luar wajah, seperti punggung tangan, lengan, dan kaki.\n" +
                    "\n" +
                    "Kulit kering dapat disebabkan atau diperburuk oleh:\n" +
                    "\n" +
                    "Gen.\n" +
                    "Penuaan atau perubahan hormonal.\n" +
                    "Cuaca seperti angin, matahari, atau dingin.\n" +
                    "Radiasi ultraviolet (UV) dari tanning bed.\n" +
                    "Pemanas ruangan.\n" +
                    "Mandi dan pancuran air panas yang panjang.\n" +
                    "Bahan dalam sabun, kosmetik, atau pembersih.\n" +
                    " Obat-obatan.\n" +
                    "4. Jenis Kulit Berminyak\n" +
                    "\n" +
                    "Memahami Jenis-jenis Kulit sebelum Menentukan Perawatan\n" +
                    "Mereka yang memiliki kulit berminyak biasanya memiliki kondisi seperti:\n" +
                    "\n" +
                    "Pori-pori membesar;\n" +
                    "Kusam atau mengkilap, kulit tebal;\n" +
                    "Komedo, jerawat, atau noda lainnya.\n" +
                    "Sifat berminyak dapat berubah tergantung pada usia, kondisi kesehatan, dan cuaca. Hal-hal yang dapat menyebabkan atau memperburuknya meliputi:\n" +
                    "\n" +
                    "Pubertas atau ketidakseimbangan hormon lainnya;\n" +
                    "Sedang stres;\n" +
                    "Panas atau berada di area yang terlalu lembap. \n" +
                    "Baca juga: Alasan Kulit Berminyak Lebih Mudah Berjerawat\n" +
                    "\n" +
                    "5. Kulit Sensitif\n" +
                    "\n" +
                    "Memahami Jenis-jenis Kulit sebelum Menentukan Perawatan\n" +
                    "Kulit sensitif adalah yang paling cukup sulit untuk dirawat. Sebab jika asal menggunakan produk wajah, mereka bisa mengalami beberapa hal, seperti: \n" +
                    "\n" +
                    "Kemerahan;\n" +
                    "Gatal;\n" +
                    "Terbakar;\n" +
                    "Kekeringan.\n" +
                    "Jika kamu pemilik kulit sensitif, coba cari tahu apa pemicunya agar kamu bisa menghindarinya. Ada banyak kemungkinan alasan, tetapi seringkali itu sebagai respons terhadap produk perawatan kulit tertentu. ",
            author = "Halodoc",
            imageUrl = "https://d1vbn70lmn1nqe.cloudfront.net/prod/wp-content/uploads/2021/09/29043056/Memahami-Jenis-jenis-Kulit-sebelum-Menentukan-Perawatan.jpg.webp",
            date = "29 September 2021"
        ),

        ArticleModel(
            id = 27,
            category = "Perawatan Kulit",
            title = "Minyak Kelapa Bisa Atasi Kurap, Ini Penjelasannya",
            content = "Halodoc, Jakarta - Minyak kelapa adalah salah satu bahan alami yang dikenal memiliki banyak manfaat untuk kesehatan. Minyak alami satu ini bisa menjadi pilihan pengobatan alternatif untuk berbagai macam penyakit, mulai dari infeksi hingga cedera. \n" +
                    "\n" +
                    "Salah satu penyakit yang diyakini bisa diatasi dengan penggunaan minyak kelapa adalah kurap, yakni infeksi jamur menular yang mempengaruhi kulit. Secara medis kondisi ini dikenal sebagai tinea, dan akan memengaruhi lapisan atas kulit. Infeksi kurap mungkin gatal dan sering kali dimulai sebagai area datar bersisik pada kulit. Setelah ruam melingkar, bagian dalamnya mungkin berisi kulit bening atau benjolan merah.\n" +
                    "\n" +
                    "Baca juga: Jangan Tertukar, Ini Bedanya Kurap dengan Kudis pada Kulit\n" +
                    "\n" +
                    "Minyak Kelapa untuk Atasi Kurap\n" +
                    "Secara umum, pengobatan kurap adalah pemberian obat perawatan antijamur yang dijual bebas. Obat-obatan oles ini akan menghilangkan sebagian besar kasus kurap ringan dengan cepat. Jika perawatan obat bebas tidak berhasil, dokter mungkin akan meresepkan obat antijamur resep. Ini termasuk krim dan lotion dengan persentase bahan antijamur yang lebih tinggi. Jika masih belum ada perubahan gejala, dokter akan meresepkan pil antijamur oral. \n" +
                    "\n" +
                    "Jika kamu ingin mencoba minyak kelapa di samping perawatan yang diberikan oleh dokter, ini sebetulnya diperbolehkan. Namun, kamu juga perlu mendiskusikan dengan dokter di Halodoc mengenai keamanannya. Namun, secara keseluruhan minyak kelapa telah lama digunakan sebagai pengobatan kurap karena beberapa alasan. \n" +
                    "\n" +
                    "Pertama, minyak kelapa adalah agen antijamur yang kuat yang dapat membasmi infeksi jamur ringan atau superfisial bila dioleskan secara topikal. Manfaat ini berasal dari asam laurat dan lipid antimikroba yang ditemukan dalam asam lemak rantai menengah dalam minyak kelapa.\n" +
                    "\n" +
                    "Kedua, minyak kelapa juga digunakan untuk membantu menyembuhkan luka lebih cepat. Manfaat antiinflamasi, antioksidan, dan pelembabnya dapat meredakan iritasi dan kulit mengelupas dengan melumasi kulit dan mempercepat waktu penyembuhan. Ia juga dapat membantu mengurangi kemerahan dan gejala infeksi yang terlihat lainnya.\n" +
                    "\n" +
                    "Baca juga: Hati-Hati, 6 Kondisi Sebabkan Kurap di Selangkangan\n" +
                    "\n" +
                    "Cara Menggunakan Minyak Kelapa untuk Atasi Kurap\n" +
                    "Menggunakan minyak kelapa untuk mengobati kurap sangatlah mudah. Jaga agar area bersih dan kering sebelum mengoleskan minyak kelapa leleh ke area yang terkena dengan bola kapas atau kapas. \n" +
                    "\n" +
                    "Sebelum melakukannya, pastikan kamu mencuci tangan meskipun menurut kamu sudah terlihat bersih. Ingat, jamur ini sangat mudah menular sehingga kamu benar-benar harus menjaga kebersihan tangan. \n" +
                    "\n" +
                    "Oleskan minyak kelapa ke area yang terkena antara empat dan enam kali sehari. Dengan menggabungkan minyak kelapa dengan bahan antijamur dan antimikroba lainnya dapat membantu meningkatkan efektivitasnya. Seperti misalnya minyak pohon teh atau tea tree oil. Campurkan dua tetes minyak pohon teh dengan satu sendok makan minyak kelapa leleh dan oleskan ke area yang terkena.\n" +
                    "\n" +
                    "Meski gejala sudah hilang, sebaiknya terus gunakan minyak kelapa di area yang terkena setidaknya selama satu minggu. Ini akan memastikan infeksi hilang dan mengurangi risiko kambuh.\n" +
                    "\n" +
                    "Baca juga: Jarang Mandi Bisa Buat Kulit Kena Kadas dan Kurap \n" +
                    "\n" +
                    "Hal yang Perlu Diperhatikan\n" +
                    "Penelitian memang menunjukkan bahwa sifat antijamur dan pelembap minyak kelapa efektif dalam mengobati kasus kurap ringan. Lebih baik lagi, minyak kelapa umumnya memiliki risiko efek samping yang lebih kecil seperti iritasi daripada perawatan dengan obat jamur oles. Namun, alangkah lebih baik untuk mendiskusikannya dengan dokter supaya terhindar dari efek samping yang tidak diinginkan saat hendak menggunakan minyak kelapa. \n" +
                    "\n" +
                    "Ingatlah untuk menggunakan perawatan setidaknya satu minggu setelah gejala hilang untuk memastikan bahwa infeksinya juga hilang. Ini juga mengurangi risiko kekambuhan, baik di tempat awal kurap muncul atau di area tubuh lainnya,",
            author = "Halodoc",
            imageUrl = "https://d1bpj0tv6vfxyp.cloudfront.net/articles/181399_2-11-2020_9-51-58.webp",
            date = "02 November 2020"
        ),


        ArticleModel(
            id = 28,
            category = "Perawatan Kulit",
            title = "Kulit Kering Mengelupas? Ini 5 Pengobatan yang Bisa Dilakukan",
            content = "Halodoc, Jakarta – Selain memberikan perlindungan bagi organ dalam tubuh, kulit juga berperan sebagai indra peraba dan pengatur suhu tubuh. Supaya bisa tetap melakukan tugasnya, kulit akan melakukan regenerasi sel. Sayangnya, terkadang proses ini terjadi bahkan sebelum waktunya, dan membuat kulit kering mengelupas karena penumpukan sel kulit. \n" +
                    "\n" +
                    "Kulit bersisik mengelupas umumnya menunjukkan gejala seperti kulit terasa begitu kering dan berubah warna menjadi kemerahan. Ini kerap terjadi saat kulit sedang berada dalam fase penyembuhan. Namun, ada pula kondisi lain yang dapat menjadi penyebabnya. \n" +
                    "\n" +
                    "Misalnya, reaksi alergi, pemakaian obat atau produk tertentu, kondisi medis tertentu, terbakar matahari, bahkan terlalu sering mencuci tangan. \n" +
                    "\n" +
                    "Bagaimana Mengatasi Kulit Kering Mengelupas?\n" +
                    "Sebenarnya, mengatasi kulit kering mengelupas tidak menjadi hal yang sulit kamu lakukan. Bahkan, kamu bisa menggunakan cara sederhana untuk mengembalikan kelembapan kulit dan mencegahnya kembali mengelupas. Berikut beberapa caranya:\n" +
                    "\n" +
                    "1. Menggunakan pelembap\n" +
                    "Cara pertama tentu saja dengan menggunakan produk pelembap untuk membantu mengembalikan kelembapan kulit wajah. Gunakan produk pelembap wajah yang sesuai dengan kondisi dan jenis kulit wajahmu, pastikan saja produk tersebut tidak memiliki kandungan parfum. Gunakan produk pelembap setelah kamu selesai mencuci muka.\n" +
                    "\n" +
                    "2. Menggunakan tabir surya\n" +
                    "Selain itu, gunakan tabir surya untuk mengatasi kulit kering mengelupas atau kamu ingin melakukan aktivitas luar ruangan. Produk ini sangat penting untuk membantu mencegah kulit mengalami kerusakan karena sinar matahari, dan mengurangi efek kerusakan kulit menjadi lebih parah. \n" +
                    "\n" +
                    "Pastikan kamu memilih produk tabir surya yang memiliki bahan dasar air dan spektrum yang luas. Selain itu, pilih juha produk dengan kandungan SPF minimal sebesar 30.\n" +
                    "\n" +
                    "Baca lebih lanjut: 13 Manfaat Hydrating Toner bagi Pemilik Kulit Kering\n" +
                    "\n" +
                    "3. Menggunakan lidah buaya untuk mengatasi kulit kering mengelupas\n" +
                    "Jika kamu mencari bahan alami terbaik untuk mengatasi kulit kering mengelupas, pilih lidah buaya. Oleskan gel yang terdapat pada bagian dalam tanaman lidah buaya pada bagian kulit yang mengalami kering dan mengelupas, lalu biarkan hingga semalaman. Namun, hentikan pemakaian apabila kamu mengalami gejala yang menunjukkan reaksi alergi. \n" +
                    "\n" +
                    "4. Penuhi asupan cairan tubuh\n" +
                    "Kurangnya kelembapan pada kulit juga bisa terjadi karena asupan cairan harian yang tidak terpenuhi. Ini berarti, mencukupi kebutuhan cairan tubuh bisa menjadi solusi tepat untuk mengurangi kulit kering mengelupas. Tak hanya itu, mendapatkan asupan cairan yang sesuai juga menjaga tubuh dari kondisi dehidrasi dan sembelit. \n" +
                    "\n" +
                    "5. Hindari memakai produk perawatan atau kecantikan tertentu\n" +
                    "Ketika kulit wajah terasa kering bahkan mengelupas setelah kamu menggunakan suatu produk perawatan wajah atau kecantikan, sebaiknya segera hentikan penggunaannya. Sebab, memang ada beberapa produk yang bisa memicu munculnya kondisi tersebut. Misalnya, berbagai produk dengan kandungan alpha hydroxy acid (AHA), benzoyl peroxide, dan retinoid. ",
            author = "Halodoc",
            imageUrl = "https://d1vbn70lmn1nqe.cloudfront.net/prod/wp-content/uploads/2022/12/26081841/Kulit-Kering-Mengelupas_-Ini-X-Pengobatan-yang-Bisa-Dilakukan.jpg.webp",
            date = "26 Februari 2024"
        ),



        ArticleModel(
            id = 29,
            category = "Perawatan Kulit",
            title = "Langkah Pengobatan Herpes yang Bisa Dilakukan",
            content = "Halodoc, Jakarta – Penyebab penyakit herpes yang paling umum yaitu menyebar melalui kontak kulit ke kulit. Kemunculan herpes umumnya ditandai dengan luka berbentuk gelembung pada kulit atau selaput lendir. \n" +
                    "\n" +
                    "Walaupun tidak bisa sembuh sepenuhnya, ada langkah-langkah pengobatan yang bisa kamu lakukan untuk mengurangi gejala kondisi ini. Berikut informasi selengkapnya!\n" +
                    "\n" +
                    "Pengobatan Penyakit Herpes\n" +
                    "Mendapat pengobatan yang tepat bisa membantu mengurangi gejala, mempercepat penyembuhan, dan mengurangi risiko penularan herpes kepada orang lain.\n" +
                    "\n" +
                    "Berikut opsi pengobatannya:\n" +
                    "\n" +
                    "1. Obat antivirus\n" +
                    "Terapi antivirus adalah salah satu langkah utama dalam pengobatan herpes.\n" +
                    "\n" +
                    "Obat antivirus seperti asiklovir, valasiklovir, dan famsiklovir biasanya dokter resepkan untuk menghentikan atau memperlambat perkembangan virus herpes. \n" +
                    "\n" +
                    "Umumnya, jenis obat-obatan tersebut berbentuk pil atau salep.\n" +
                    "\n" +
                    "Penggunaan obat antivirus akan membantu mengurangi rasa sakit dan panas yang terjadi pada luka, serta dapat mempercepat proses penyembuhan.\n" +
                    "\n" +
                    "2. Pereda nyeri\n" +
                    "Saat luka herpes muncul, pengidap biasanya merasakan rasa sakit dan ketidaknyamanan yang mengganggu aktivitas sehari-hari.\n" +
                    "\n" +
                    "Untuk mengatasi gejala ini, dokter juga bisa meresepkan obat pereda nyeri seperti parasetamol atau ibuprofen untuk meringankan gejala tersebut.\n" +
                    "\n" +
                    "3. Penggunaan krim atau salep\n" +
                    "Mengoleskan krim atau salep yang mengandung zat antiviral  juga dapat membantu mengurangi gejala dan mempercepat penyembuhan infeksi herpes.\n" +
                    "\n" +
                    "Umumnya, dokter meresepkan krim antivirus seperti penciclovir dan docosanol.\n" +
                    "\n" +
                    "Salap tersebut bisa langsung kamu oleskan pada luka untuk menghambat perkembangan virus.\n" +
                    "\n" +
                    "4. Kompres dengan air hangat\n" +
                    "Mengompres luka herpes dengan air hangat dapat membantu mengurangi nyeri, mengurangi pembengkakan, dan mempercepat penyembuhan.\n" +
                    "\n" +
                    "Jika kamu ingin mencobanya, celupkan kain bersih ke dalam air hangat.\n" +
                    "\n" +
                    "Kemudian usapkan di sekitar luka herpes. Ganti kompres setiap beberapa menit. \n" +
                    "\n" +
                    "Nah, pastikan handuk atau kain yang kamu gunakan bukan milik orang lain. Tujuannya untuk mencegah penularan virus ke orang lain. \n" +
                    "\n" +
                    "5. Jaga kebersihan\n" +
                    "Penting untuk menjaga area yang terinfeksi tetap bersih dan kering. Bersihkan luka herpes dengan air hangat dan sabun ringan untuk mencegah infeksi sekunder. \n" +
                    "\n" +
                    "Selain itu, jangan menggaruk atau memecahkan luka agar virus atau infeksi tidak menjalar ke area lainnya.\n" +
                    "\n" +
                    "Ketahui pula 9 Hal yang Harus dan Jangan Dilakukan pada Pengidap Herpes.\n" +
                    "\n" +
                    "6. Menjaga daya tahan tubuh\n" +
                    "Daya tahan tubuh yang baik dapat membantu melawan infeksi virus herpes. Konsumsi makanan bergizi, tidur cukup, olahraga rutin, dan kelola stres dengan baik.\n" +
                    "\n" +
                    "Hal ini bisa membantu meningkatkan daya tahan tubuh. Selain itu, hindari faktor pemicu yang dapat melemahkan sistem kekebalan tubuh, seperti stres, merokok, minum alkohol atau kelelahan.\n" +
                    "\n" +
                    "7. Konsultasikan dengan dokter\n" +
                    "Jika gejala herpes menjadi parah atau sering kambuh, diskusikan dengan dokter untuk mendapatkan perawatan yang lebih lanjut.\n" +
                    "\n" +
                    "Dokter dapat merekomendasikan terapi antivirus yang lebih kuat atau melibatkan spesialis kulit dalam penanganan kasus herpes yang lebih kompleks.",
            author = "Halodoc",
            imageUrl = "https://d1vbn70lmn1nqe.cloudfront.net/prod/wp-content/uploads/2023/10/16042237/langkah-pengobatan-herpes-yang-bisa-dilakukan-halodoc.jpg.webp",
            date = "16 Oktober 2023"
        ),




        ArticleModel(
            id = 30,
            category = "Perawatan Kulit",
            title = "Kenali 7 Jenis Penyakit Kulit dan Cara Mengatasinya",
            content = "\n" +
                    "Halodoc, Jakarta – Kulit rentan mengalami masalah kesehatan karena mudah terpapar kotoran, bakteri, hingga virus. Misalnya, eksim, jerawat, biduran, jamur kulit, hingga cacar air. \n" +
                    "\n" +
                    "Beberapa kondisi kulit mungkin dapat membaik dengan sendirinya. Namun, agar proses penyembuhan berlangsung dengan cepat, gunakanlah produk kebersihan tubuh seperti sabun yang tepat.\n" +
                    "\n" +
                    "Berbagai Penyakit Kulit yang perlu Diwaspadai \n" +
                    "Ada beberapa jenis penyakit kulit yang umum terjadi, di antaranya:\n" +
                    "\n" +
                    "1. Eksim\n" +
                    "Eksim menyebabkan kulit gatal, merah, kering, dan teriritasi. Kondisi ini juga bernama dermatitis atopik yang biasanya terjadi saat bayi atau usia dini dan dapat bertahan hingga dewasa.\n" +
                    "\n" +
                    "Gejalanya dapat teratasi dengan produk perawatan kulit, khususnya sabun. Namun, pilih yang tidak mengandung bahan kimia dan pewangi. Sebab, ini bisa membuat kulit jadi lebih kering.\n" +
                    "\n" +
                    "2. Herpes\n" +
                    "Herpes atau cold sore terjadi karena infeksi herpes simplex virus. Tandanya berupa lepuhan atau luka di bagian mulut atau bibir. Gejala umumnya dapat sembuh tanpa pengobatan dalam 2 hingga 4 minggu. \n" +
                    "\n" +
                    "Penyebabnya adalah bakteri Staphylococcus dan bakteri gram positif lainnya. Untuk membunuhnya, kamu bisa menggunakan sabun untuk menjaga kebersihan tubuh.\n" +
                    "\n" +
                    "Selain dengan sabun, ini Daftar Obat Herpes yang Sering Diresepkan Dokter.\n" +
                    "\n" +
                    "3. Psoriasis\n" +
                    "Psoriasis adalah penyakit kulit yang akibat kelainan autoimun. Gejalanya berupa sensasi panas di kulit dan bercak gatal dalam ukuran dan tingkat keparahan yang bervariasi.\n" +
                    "\n" +
                    "Bagi pengidap psoriasis, penggunaan sabun yang tepat dapat mencegah iritasi lebih lanjut. Cara ini juga dapat mempercepat proses penyembuhan, bahkan mengobatinya.\n" +
                    "\n" +
                    "4. Jerawat\n" +
                    "Jerawat adalah salah satu penyakit kulit yang paling umum. Gejalanya bisa meliputi:\n" +
                    "\n" +
                    "Pustula, yaitu jerawat dengan nanah di ujungnya.\n" +
                    "Papula, yaitu benjolan yang muncul akibat infeksi pada folikel rambut.\n" +
                    "Nodul, yaitu benjolan yang menyakitkan di bawah permukaan kulit.\n" +
                    "Kista, benjolan yang lebih besar, nyeri, berisi nanah di bawah permukaan kulit.\n" +
                    "Pilihlah produk perawatan wajah yang tidak menyumbat pori-pori, non-comedogenic, non-acnegenic, dan bebas minyak.\n" +
                    "\n" +
                    "5. Biduran\n" +
                    "Biduran atau urtikaria adalah penyakit kulit dengan gejala bercak merah atau bengkak pada kulit. Tanda tersebut biasanya muncul karena reaksi alergi terhadap makanan, obat-obatan, gigitan serangga, atau suhu.\n" +
                    "\n" +
                    "Biduran dapat muncul dalam berbagai ukuran dan bentuk. Gejalanya dapat berlangsung beberapa jam hingga beberapa hari sebelum hilang dengan sendirinya. Ketahui beberapa jenisnya di sini: Ini Jenis-Jenis Biduran yang Perlu Diketahui.\n" +
                    "\n" +
                    "6. Jamur kulit\n" +
                    "Jamur kulit adalah infeksi yang terjadi akibat pertumbuhan jamur berlebihan di permukaan kulit. Gejalanya berupa kemerahan, gatal-gatal, dan ruam kulit di area selangkangan, ketiak, kuku, kulit kepala, atau kaki.\n" +
                    "\n" +
                    "Untuk meminimalisir rasa gatalnya, kamu bisa membersihkan area yang terkena dengan sabun dan air mengalami sebanyak dua kali sehari. Langkah ini efektif mengendalikan penyebaran infeksi. \n" +
                    "\n" +
                    "7. Cacar air\n" +
                    "Cacar air, juga dikenal sebagai varisela, adalah penyakit infeksi virus yang disebabkan oleh virus varisela-zoster (VZV). Tandanya ruam kulit yang gatal dan berisi cairan, serta demam ringan. \n" +
                    "\n" +
                    "Penyakit kulit ini menular melalui kontak langsung dengan pengidap atau melalui udara ketika mereka bersin atau batuk. Gangguan lebih umum terjadi pada anak-anak ketimbang orang dewasa.\n" +
                    "\n" +
                    "Dengan mandi secara teratur menggunakan sabun yang cocok, kamu dapat menurunkan risiko keparahan gejala. Menjaga kulit tetap bersih juga menjadi langkah pencegahan infeksi sekunder.",
            author = "Halodoc",
            imageUrl = "https://d1vbn70lmn1nqe.cloudfront.net/prod/wp-content/uploads/2023/02/06043928/4-Jenis-Penyakit-Kulit-yang-Perlu-Diwaspadai.jpg.webp",
            date = "23 Februari 2024"
        ),



        )
}
