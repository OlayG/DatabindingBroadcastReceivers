package com.example.databindingbroadcastreceivers.receivers

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.databindingbroadcastreceivers.R
import com.example.databindingbroadcastreceivers.toast

class MyReceiver : BroadcastReceiver() {
    companion object {
        const val BOOT_ACTION = "android.intent.action.BOOT_COMPLETED"
    }

    private fun createNotificationChannel(context: Context) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Channel Name"
            val descriptionText = "Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("MyReceiverChannelId", name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            /**
             * This Boot action is the Intent-Filter Action defined in the Manifest
             */
            BOOT_ACTION -> {
                context?.run {
                    createNotificationChannel(context)
                    val notification = NotificationCompat.Builder(this, "MyReceiverChannelId")
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentTitle("My notification")
                        .setContentText("Much longer text that cannot fit one line...")
                        .setStyle(
                            NotificationCompat.BigTextStyle()
                                .bigText("Much longer text that cannot fit one line...")
                        )
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .build()

                    with(NotificationManagerCompat.from(this)) {
                        // notificationId is a unique int for each notification that you must define
                        notify(10, notification)
                    }
                    toast(BOOT_ACTION)
                }
            }
            else -> context?.toast("ELSE")
        }
    }
}