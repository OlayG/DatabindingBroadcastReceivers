package com.example.databindingbroadcastreceivers.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.databindingbroadcastreceivers.toast

class MyReceiver : BroadcastReceiver() {
    companion object {
        const val BOOT_ACTION = "android.intent.action.BOOT_COMPLETED"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        when(intent?.action) {
            /**
             * This Boot action is the Intent-Filter Action defined in the Manifest
             */
            BOOT_ACTION -> context?.toast(BOOT_ACTION)
            else -> context?.toast("ELSE")
        }
    }
}