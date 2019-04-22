package com.nitrox.enderecoex.provider

import android.net.Uri

class EnderecoContrato  {
    companion object {
        val AUTHORITY  = "com.nitrox.enderecoex.provider"
        val CONTENT_PATH = "endereco"
        val CONTENT_URI = Uri.parse("content://$AUTHORITY/$CONTENT_PATH")
        val ALL_ITEMS = -2
        val WORD_ID = "id"
    }
}