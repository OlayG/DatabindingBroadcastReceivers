package com.example.databindingbroadcastreceivers.view

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.databindingbroadcastreceivers.databinding.ActivityMainBinding
import com.example.databindingbroadcastreceivers.toast
import com.example.databindingbroadcastreceivers.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            vm = mainViewModel
            lifecycleOwner = this@MainActivity
        }
        setContentView(binding.root)
        toast("Hello World")
    }

}