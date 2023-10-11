package org.d3if2101.canteen.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if2101.canteen.ui.daftar.DaftarViewModel
import org.d3if2101.canteen.ui.login.LoginViewModel
import org.d3if2101.canteen.data.di.Injection
import org.d3if2101.canteen.data.di.Injection.providePreferences
import org.d3if2101.canteen.data.di.Injection.provideRepository
import org.d3if2101.canteen.data.repository.CanteenRepository

class ViewModelFactory private constructor(
    private val canteenRepository: CanteenRepository,
    private val pref: SettingPreferences
) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DaftarViewModel::class.java)) {
            return DaftarViewModel(canteenRepository) as T
        }
        else if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(canteenRepository, pref) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null
        fun getInstance(context: Context): ViewModelFactory = instance ?: synchronized(this) {
            instance ?: ViewModelFactory(provideRepository(context), providePreferences(context))
        }.also { instance = it }
    }
}