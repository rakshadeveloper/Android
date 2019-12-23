package com.example.coachapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_option.*

class OptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option)

        ibtnCancelOptions.setOnClickListener {
            finish()
        }
        tvLogout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        tvDeviceInformation.setOnClickListener {
            val intent = Intent (this, DeviceInformationActivity::class.java)
            startActivity(intent)
        }
        tvSendAppFeedback.setOnClickListener {
            val intent = Intent (this, FeedbackFragment::class.java)
            startActivity(intent)
        }
    }
}