package com.jasmeet.thelazystore.fragments.loginregister

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.jasmeet.thelazystore.data.User
import com.jasmeet.thelazystore.databinding.FragmentRegisterBinding
import com.jasmeet.thelazystore.util.Resource
import com.jasmeet.thelazystore.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegisterFragment:Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private val viewModel by viewModels<RegisterViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnRegisterRegister.setOnClickListener {
                val user = User(
                        edtFirstName.text.toString().trim(),
                    edtLastName.text.toString().trim(),
                    edtEmail.text.toString().trim()
                )
                val password = edtPassword.text.toString()
                viewModel.createAccountWithEmailAndPassword(user,password)
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.register.collect{
                when(it){
                    is Resource.Loading -> {
                        binding.btnRegisterRegister.startAnimation()
                    }
                    is Resource.Success -> {
                        Log.d("test",it.data.toString())
                        binding.btnRegisterRegister.revertAnimation()
                    }

                    is Resource.Error -> {
                        Log.e("noob", it.message.toString())
                        binding.btnRegisterRegister.revertAnimation()

                    }
                    else -> Unit
                }

            }
        }
    }
}