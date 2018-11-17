package com.jamontes79.koinsample.activity

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.jamontes79.koinsample.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class LoginActivityTest {
    @get:Rule
    var activityTestRule = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun checkUserNameEditTextIsDisplayed() {
        activityTestRule.launchActivity(Intent())
        Espresso.onView(ViewMatchers.withId(R.id.txt_user_name)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun checkPasswordEditTextIsDisplayed() {
        activityTestRule.launchActivity(Intent())
        Espresso.onView(ViewMatchers.withId(R.id.txt_password)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun checkErrorMessageIsDisplayedForEmptyData() {
        activityTestRule.launchActivity(Intent())
        Espresso.onView(ViewMatchers.withId(R.id.btn_login)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText(R.string.error_user_password)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun checkLoginSuccess() {
        activityTestRule.launchActivity(Intent())
        Espresso.onView(ViewMatchers.withId(R.id.txt_user_name)).perform(ViewActions.typeText("user"), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.txt_password)).perform(ViewActions.typeText("password"), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.btn_login)).check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText(R.string.login_ok)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }
}