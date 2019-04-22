package com.nitrox.enderecoex.provider

import android.annotation.SuppressLint
import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri
import com.nitrox.enderecoex.R
import org.jetbrains.annotations.Contract
import java.lang.Integer.parseInt

@SuppressLint("Registered")
class EnderecoContentProvider : ContentProvider() {
    var mData: Array<String>? = null

    private val sUriMatcher = UriMatcher(UriMatcher.NO_MATCH)

    override fun onCreate(): Boolean {
        initUriMatching()
        val context = context
        mData = context!!.resources.getStringArray(R.array.sentence)
        return true
    }

    private fun initUriMatching() {
        sUriMatcher.addURI(EnderecoContrato.AUTHORITY, EnderecoContrato.CONTENT_PATH + "/#", 1)
        sUriMatcher.addURI(EnderecoContrato.AUTHORITY, EnderecoContrato.CONTENT_PATH, 0)
    }

    override fun query(uri: Uri, projection: Array<String>?, selection: String?, selectionArgs: Array<String>?,
        sortOrder: String?): Cursor? {

        var id = -1
        when (sUriMatcher.match(uri)) {
            0 -> {
                id = EnderecoContrato.ALL_ITEMS
                if (selection != null) {
                    id = Integer.parseInt(selectionArgs!![0])
                }
            }
            1 -> id = parseInt(uri.getLastPathSegment())
            UriMatcher.NO_MATCH -> {
                id = -1
            }
            else -> {
                id = -1
            }
        }
        return populateCursor(id)
    }

    private fun populateCursor(id: Int): Cursor {
        val cursor = MatrixCursor(arrayOf(EnderecoContrato.CONTENT_PATH))
        if (id == EnderecoContrato.ALL_ITEMS) {
            for (i in 0 until mData!!.size) {
                val word = mData!![i]
                cursor.addRow(arrayOf<Any>(word))
            }
        } else if (id >= 0) {
            val word = mData!![id]
            cursor.addRow(arrayOf<Any>(word))
        }
        return cursor
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<String>?): Int {
        return 0
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        return 0
    }

    override fun getType(uri: Uri): String? {
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return null
    }

}