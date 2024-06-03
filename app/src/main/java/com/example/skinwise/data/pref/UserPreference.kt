package com.example.skinwise.data.pref

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.skinwise.data.model.loginModel
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "session")
class UserPreference private constructor(private val dataStore: DataStore<Preferences>){

    fun getSession(): Flow<loginModel> {
        return dataStore.data.map { preferences ->

            loginModel(
                 preferences[TOKEN_KEY] ?: "",
                preferences[IS_LOGIN_KEY]?: false,
                preferences[NAME_KEY] ?: "",
                preferences[EMAIL_KEY] ?: ""
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

            val claimsJws: Jws<Claims> = Jwts.parserBuilder()
                .setSigningKey("Iy2OWmXmMgxvL3cfmb8tGcQfvZSQ2Hm6Yz-WCWTG69A".toByteArray())
                .build()
                .parseClaimsJws(token)

            val claims: Claims = claimsJws.body

            val nama: String? = claims["nama", String::class.java]
            val email: String? = claims["email", String::class.java]

            Log.d("UserPreferences", "Claims parsed: $claims")
            Log.d("UserPreferences", "Claim nama: $nama")
            Log.d("UserPreferences", "Claim email: $email")

            if (nama == null || email == null) {
                Log.e("UserPreferences", "Claims 'nama' or 'email' are null")
                return
            }

            dataStore.edit { preferences ->
                preferences[TOKEN_KEY] = token
                preferences[IS_LOGIN_KEY] = true
                preferences[NAME_KEY] = nama
                preferences[EMAIL_KEY] = email
            }

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

        fun getInstance(dataStore: DataStore<Preferences>): UserPreference {
            return INSTANCE ?: synchronized(this) {
                val instance = UserPreference(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }

}