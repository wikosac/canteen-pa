package org.d3if2101.canteen.ui.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.d3if2101.canteen.databinding.ActivityDashboardBinding
import org.d3if2101.canteen.ui.menu.MenuActivity
import org.d3if2101.canteen.MainPenjualActivity

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnKantin1.setOnClickListener { navTo("kantin1") }
            btnKantin2.setOnClickListener { navTo("kantin2") }
            btnKantin3.setOnClickListener { navTo("kantin3") }
            btnKantin4.setOnClickListener {
                startActivity(Intent(this@DashboardActivity, MainPenjualActivity::class.java))
            }
        }
    }

    private fun navTo(idKantin: String) {
        val intent = Intent(this, MenuActivity::class.java)
        intent.putExtra("idKantin", idKantin)
        startActivity(intent)
    }
}