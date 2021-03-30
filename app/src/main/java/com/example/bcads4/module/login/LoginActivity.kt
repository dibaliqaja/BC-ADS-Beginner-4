package com.example.bcads4.module.login

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bcads4.R
import com.example.bcads4.utils.UserPreference
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var userPreference: UserPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userPreference = UserPreference(this)

        btn_login.setOnClickListener {
            if (edt_username.text.isNullOrEmpty()) {
                edt_username.error = "Please input username!"
            } else {
                userPreference.setUserName(edt_username.text.toString())
                userPreference.setUserStatus(true)

                val resultIntent = Intent()
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}