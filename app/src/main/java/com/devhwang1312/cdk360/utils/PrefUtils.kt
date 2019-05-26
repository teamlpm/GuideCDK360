package com.ambe.filerecovery.utils

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.preference.PreferenceManager
import android.view.View
import android.view.WindowManager

/**
 *  Created by AMBE on 10/4/2019 at 9:15 AM.
 */

class PrefUtils {

    private var pref: SharedPreferences? = null

    private constructor(context: Context) {
        pref = PreferenceManager.getDefaultSharedPreferences(context.applicationContext)
    }

    companion object {

        private var instance: PrefUtils? = null

        fun newInstance(context: Context): PrefUtils {
            if (instance == null) {
                instance = PrefUtils(context.applicationContext)
            }

            return instance!!
        }
    }

    fun putBoolean(key: String, value: Boolean) {
        pref?.apply {
            val editor = this.edit()
            editor.putBoolean(key, value)
            editor.apply()
        }
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean? {
        return pref?.getBoolean(key, defaultValue)
    }

    fun putString(key: String, value: String) {
        pref?.apply {
            val editor = this.edit()
            editor.putString(key, value)
            editor.apply()
        }
    }

    fun getString(key: String, defaultValue: String): String? {
        return pref?.getString(key, defaultValue)
    }

    fun putInt(key: String, value: Int) {
        pref?.apply {
            val editor = this.edit()
            editor.putInt(key, value)
            editor.apply()
        }
    }

    fun getInt(key: String, defaultValue: Int): Int? {
        return pref?.getInt(key, defaultValue)
    }


}