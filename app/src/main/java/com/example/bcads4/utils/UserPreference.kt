package com.example.bcads4.utils

import android.content.Context
import com.example.bcads4.utils.Const.PREF_NAME
import com.example.bcads4.utils.Const.USER_NAME
import com.example.bcads4.utils.Const.USER_STATUS

class UserPreference(context: Context) {
    private val preference = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun setUserStatus(value: Boolean) {
        val editor = preference.edit()
        editor.putBoolean(USER_STATUS, value)
        editor.apply()
    }

    fun getUserStatus() : Boolean {
        return preference.getBoolean(USER_STATUS, false)
    }

    fun setUserName(value: String) {
        val editor = preference.edit()
        editor.putString(USER_NAME, value)
        editor.apply()
    }

    fun getUserName() : String? {
        return preference.getString(USER_NAME, "")
    }
}