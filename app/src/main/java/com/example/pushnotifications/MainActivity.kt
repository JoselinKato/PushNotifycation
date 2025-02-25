package com.example.pushnotifications

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        FirebaseMessaging.getInstance().token
            .addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w("FCM", "Error obteniendo token", task.exception)
                    return@addOnCompleteListener
                }
                val token = task.result
                Log.d("FCM", "Token: $token")
            }
    }
}