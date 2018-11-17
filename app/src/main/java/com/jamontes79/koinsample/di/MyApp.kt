package com.jamontes79.koinsample.di

import android.app.Application
import com.jamontes79.koinsample.presenter.impl.LoginPresenter
import com.jamontes79.koinsample.view.interf.LoginView
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module

class MyApp : Application() {

    val myModule = module {
        single{ (view : LoginView) -> LoginPresenter(view) }
    }

    override fun onCreate(){
        super.onCreate()
        // start Koin!
        startKoin(this, listOf(myModule))
    }
}