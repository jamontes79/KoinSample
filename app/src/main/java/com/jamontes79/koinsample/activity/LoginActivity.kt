package com.jamontes79.koinsample.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jamontes79.koinsample.R
import com.jamontes79.koinsample.extensions.showSnackbar
import com.jamontes79.koinsample.presenter.impl.LoginPresenter
import com.jamontes79.koinsample.view.interf.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class LoginActivity : AppCompatActivity(), LoginView {


    val loginPresenter : LoginPresenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initializeViews()
    }




    private fun initializeViews() {

        btn_login.setOnClickListener {
            loginPresenter.checkUserPassword(txt_user_name.text.toString().trim(),
                    txt_password.text.toString().trim())
        }
    }

    override fun showErrorMessageForUserPassword() {
        showSnackbar(txt_password, R.string.error_user_password)
    }

    override fun showErrorMessageForMaxLoginAttempt() {
        showSnackbar(btn_login, R.string.error_max_login_attempt)
    }

    override fun showLoginSuccessMessage() {
        showSnackbar(btn_login, R.string.login_ok)
    }
}
