package com.jamontes79.koinsample.login

import com.jamontes79.koinsample.presenter.impl.LoginPresenter
import com.jamontes79.koinsample.view.interf.LoginView
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock


class LoginPresenterTest {
    lateinit var loginView : LoginView

    @Before fun setUp(){
        loginView= mock(LoginView::class.java)
    }
    @Test
    fun checkIfLoginAttemptIsExceeded() {

        val loginPresenter = LoginPresenter(loginView)
        Assert.assertEquals(1, loginPresenter.newLoginAttempt())
        Assert.assertEquals(2, loginPresenter.newLoginAttempt())
        Assert.assertEquals(3, loginPresenter.newLoginAttempt())
        Assert.assertTrue(loginPresenter.isLoginAttemptExceeded())
    }
    @Test
    fun checkIfLoginAttemptIsNotExceeded(){
        val loginPresenter = LoginPresenter(loginView)
        Assert.assertFalse(loginPresenter.isLoginAttemptExceeded())
    }

    @Test
    fun checkUserAndPasswordIsCorrect(){
        val loginPresenter = LoginPresenter(loginView)
        Assert.assertTrue(loginPresenter.checkUserPassword("user", "password"))
    }
    @Test
    fun checkUserAndPasswordIsNotCorrect(){
        val loginPresenter = LoginPresenter(loginView)
        Assert.assertFalse(loginPresenter.checkUserPassword("user1", "password1"))
    }

    @Test
    fun checkIfLoginAttemptIsExceededWithMessage(){
        val loginPresenter = LoginPresenter(loginView)
        loginPresenter.checkUserPassword("user1", "password1")
        loginPresenter.checkUserPassword("user1", "password1")
        loginPresenter.checkUserPassword("user1", "password1")
        loginPresenter.checkUserPassword("user1", "password1")
        Assert.assertTrue(loginPresenter.isLoginAttemptExceeded())
    }
}