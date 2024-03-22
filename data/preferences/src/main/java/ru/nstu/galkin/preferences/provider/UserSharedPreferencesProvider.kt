package ru.nstu.galkin.preferences.provider

import android.content.Context

class UserSharedPreferencesProvider(context: Context) {
    companion object {
        private lateinit var INSTANCE: UserSharedPreferencesProvider

        @JvmStatic
        fun getInstance(context: Context): UserSharedPreferencesProvider {
            if (!Companion::INSTANCE.isInitialized) {
                INSTANCE = UserSharedPreferencesProvider(context)
            }
            return INSTANCE
        }
        private const val USER_PREFERENCES = "user_preferences"

        private const val SEED = "seed"
        private const val DEFAULT_VALUE = 1

    }

    private val sharedPreferences =
        context.getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE)

    fun putSeed(seed: Int) {
        sharedPreferences.edit()
            .putInt(SEED, seed)
            .apply()
    }

    fun getSeed(): Int =
            sharedPreferences.getInt(SEED, DEFAULT_VALUE)
}