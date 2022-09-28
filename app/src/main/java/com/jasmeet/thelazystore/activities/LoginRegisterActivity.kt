package com.jasmeet.thelazystore.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jasmeet.thelazystore.R
import com.jasmeet.thelazystore.databinding.ActivityLoginRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginRegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}