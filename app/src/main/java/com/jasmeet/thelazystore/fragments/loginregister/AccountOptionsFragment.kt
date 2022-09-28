package com.jasmeet.thelazystore.fragments.loginregister

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jasmeet.thelazystore.databinding.FragmentAccountOptionsBinding

class AccountOptionsFragment:Fragment() {

    private lateinit var binding: FragmentAccountOptionsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAccountOptionsBinding.inflate(layoutInflater)
        return binding.root
    }
}