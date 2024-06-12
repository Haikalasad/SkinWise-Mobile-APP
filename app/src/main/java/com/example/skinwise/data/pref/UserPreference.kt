package com.example.skinwise.data.pref

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.skinwise.data.model.UserModel
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.nio.charset.StandardCharsets

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "session")

class UserPreference(private val dataStore: DataStore<Preferences>) {

    fun getSession(): Flow<UserModel> {
        return dataStore.data.map { preferences ->
            UserModel(
                preferences[TOKEN_KEY] ?: "",
                preferences[IS_LOGIN_KEY] ?: false,
                preferences[NAME_KEY] ?: "",
                preferences[EMAIL_KEY] ?: "",
                preferences[PHOTO_KEY] ?: "",
                preferences[ROLE_KEY] ?: "",
                preferences[SUBSCRIBER_KEY] ?: false
            )
        }
    }

    suspend fun logout() {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    suspend fun saveUserInfo(token: String) {
        try {
            Log.d("UserPreferences", "Received token: $token")

            val secretKey = "Iy2OWmXmMgxvL3cfmb8tGcQfvZSQ2Hm6Yz-WCWTG69A".toByteArray(StandardCharsets.UTF_8)

            Log.d("UserPreferences", "Using secret key: ${String(secretKey, StandardCharsets.UTF_8)}")

            val claimsJws: Jws<Claims> = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)

            val claims: Claims = claimsJws.body

            val nama: String? = claims["nama", String::class.java]
            val email: String? = claims["email", String::class.java]
            val password: String? = claims["password", String::class.java]
            val role: String? = claims["role", String::class.java]
            val subscriber: Boolean? = claims["subscriber", Integer::class.java]?.toInt() == 1

            Log.d("UserPreferences", "Claims parsed: $claims")
            Log.d("UserPreferences", "Claim nama: $nama")
            Log.d("UserPreferences", "Claim email: $email")
            Log.d("UserPreferences", "Claim password: $password")
            Log.d("UserPreferences", "Claim role: $role")
            Log.d("UserPreferences", "Claim subscriber: $subscriber")

            if (nama == null || email == null  || role == null || subscriber == null) {
                Log.e("UserPreferences", "One or more claims are null")
                return
            }

            dataStore.edit { preferences ->
                preferences[TOKEN_KEY] = token
                preferences[IS_LOGIN_KEY] = true
                preferences[NAME_KEY] = nama
                preferences[EMAIL_KEY] = email
                preferences[ROLE_KEY] = role
                preferences[SUBSCRIBER_KEY] = subscriber
            }

            Log.d("UserPreferences", "User info saved successfully")

        } catch (e: io.jsonwebtoken.security.SignatureException) {
            Log.e("UserPreferences", "JWT signature tidak cocok dengan signature yang dihitung secara lokal.")
        } catch (e: Exception) {
            Log.e("UserPreferences", "Error parsing token: ${e.message}")
            e.printStackTrace()
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: UserPreference? = null

        private val TOKEN_KEY = stringPreferencesKey("token")
        private val IS_LOGIN_KEY = booleanPreferencesKey("isLogin")
        private val NAME_KEY = stringPreferencesKey("nama")
        private val EMAIL_KEY = stringPreferencesKey("email")
        private val PHOTO_KEY = stringPreferencesKey("photoUrl")
        private val ROLE_KEY = stringPreferencesKey("role")
        private val SUBSCRIBER_KEY = booleanPreferencesKey("subscriber")

        fun getInstance(dataStore: DataStore<Preferences>): UserPreference {
            return INSTANCE ?: synchronized(this) {
                val instance = UserPreference(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}
