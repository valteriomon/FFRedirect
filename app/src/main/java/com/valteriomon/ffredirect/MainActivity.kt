package com.valteriomon.ffredirect

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Browser.EXTRA_CREATE_NEW_TAB
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (intent != null) {
            handleIntent(intent)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        if (intent != null) {
            handleIntent(intent)
        }
    }

    private fun handleIntent(intent: Intent) {
        val webUrl =
            (intent.dataString ?: intent.getStringExtra(Intent.EXTRA_TEXT))?.trim()

        if (!webUrl.isNullOrBlank()) {
            val ffIntent = Intent(Intent.ACTION_VIEW, Uri.parse(webUrl))
            ffIntent.putExtra(EXTRA_CREATE_NEW_TAB, true)
            ffIntent.setPackage("org.mozilla.firefox")
            startActivity(ffIntent)
        }
    }

    override fun onResume() {
        super.onResume()
        finish()
    }
}