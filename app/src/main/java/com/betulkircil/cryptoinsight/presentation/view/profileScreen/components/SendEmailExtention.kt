package com.betulkircil.cryptoinsight.presentation.view.profileScreen.components

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.util.Log

fun Context.sendMail(to: String, subject: String) {
    try {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "vnd.android.cursor.item/email" // or "message/rfc822"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        Log.d("Error",e.message.toString())
    } catch (t: Throwable) {
        Log.d("Error",t.message.toString())
    }
}