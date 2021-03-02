package com.example.databindingbroadcastreceivers

import android.content.Context
import android.os.Build
import android.text.Html
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.google.android.material.textview.MaterialTextView

/*@BindingAdapter("app:loadHtml")
fun loadHtml(textView: MaterialTextView, htmlText: String) {
    textView.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
        Html.fromHtml(htmlText, Html.FROM_HTML_MODE_COMPACT)
    else
        Html.fromHtml(htmlText)
}*/

@BindingAdapter("app:loadHtml")
fun MaterialTextView.loadHtml(htmlText: String) {
    text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
        Html.fromHtml(htmlText, Html.FROM_HTML_MODE_COMPACT)
    else
        Html.fromHtml(htmlText)
}

fun Context.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}
