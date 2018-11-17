package com.jamontes79.koinsample.extensions

import android.app.Activity
import android.support.design.widget.Snackbar
import android.view.View
import com.jamontes79.koinsample.R
import kotlinx.android.synthetic.main.activity_login.*

fun Activity.showSnackbar(view: View, message: Int, duration : Int = Snackbar.LENGTH_LONG){
    Snackbar.make(view,message, duration).show()
}