package com.jamontes79.koinsample.view.interf

interface LoginView {
    fun showErrorMessageForUserPassword()

    fun showErrorMessageForMaxLoginAttempt()

    fun showLoginSuccessMessage()
}