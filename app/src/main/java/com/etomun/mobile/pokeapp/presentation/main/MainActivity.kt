package com.etomun.mobile.pokeapp.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.etomun.mobile.pokeapp.R
import com.etomun.mobile.pokeapp.databinding.ActivityMainBinding
import com.etomun.mobile.pokeapp.presentation.base.BaseActivity
import timber.log.Timber
import javax.inject.Inject


class MainActivity : BaseActivity<ActivityMainBinding>(), Main.View {
    @Inject
    lateinit var presenter: Main.Presenter<Main.View>

    private lateinit var navController: NavController

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme_NoActionBar_FullScreen)
        super.onCreate(savedInstanceState)
    }

    override fun setupPresenter() {
        presenter.attachView(this, this.lifecycle)
    }

    override fun onPresenterAttached() {
        navController = Navigation.findNavController(this, R.id.fragment)
    }

    override fun showMainProgressBar(show: Boolean) {
    }

    override fun showError(message: String?) {
        Timber.e(message)
    }

    override fun onConnectivityChanged(isOnline: Boolean) {

    }

}
