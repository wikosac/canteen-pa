package org.d3if2101.canteenpenjual.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import org.d3if2101.canteenpenjual.databinding.ActivityLoginBinding
import org.d3if2101.canteenpenjual.ui.ViewModelFactory
import org.d3if2101.canteenpenjual.ui.daftar.DaftarActivity
import org.d3if2101.canteenpenjual.ui.dashboard.DashboardPenjual

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var email: String
    private lateinit var password: String

    private val factory: ViewModelFactory by lazy {
        ViewModelFactory.getInstance(this.application)
    }
    private val viewModel: LoginViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.tvTidakAdaAkun.setOnClickListener {
            startActivity(
                Intent(
                    this@LoginActivity,
                    DaftarActivity::class.java
                )
            ) // Move to Daftar Activity
        }

        binding.tvButtonLogin.setOnClickListener {
            getTextInput()
            viewModel.loginUser(email, password).observe(this) {
                if (it.message.lowercase().equals("success")) {
                    Toast.makeText(this, "Selamat Datang ${email}", Toast.LENGTH_SHORT).show()
                    startActivity(
                        Intent(
                            this@LoginActivity,
                            DashboardPenjual::class.java
                        )
                    ) // Move to Dashboard Admin Activity
                } else {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }

            }

        }

    }

    private fun getTextInput() {
        email = binding.addEmail.text.toString()
        password = binding.addPassword.text.toString()
    }
}