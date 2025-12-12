package es.mobiledev.commonandroid.util

import android.content.Context
import android.content.Intent
import es.mobiledev.commonandroid.R

fun Context.shareUrl(
    url: String,
) {
    if (url.isNotBlank()) {
        val intent =
            Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(
                    Intent.EXTRA_TEXT,
                    getString(R.string.take_a_look_at_this_article, url)
                )
            }

        startActivity(
            Intent.createChooser(
                intent,
                getString(R.string.share_via)
            )
        )
    }
}
