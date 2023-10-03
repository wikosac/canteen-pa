package org.d3if2101.canteenpenjual



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.d3if2101.canteenpenjual.ui.daftar.DaftarActivity
import org.d3if2101.canteenpenjual.ui.homeadminproduk.edititem.EditItemActivity
import org.d3if2101.canteenpenjual.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this@MainActivity, LoginActivity::class.java))
    }
}