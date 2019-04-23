package com.nitrox.enderecoex.provider

import android.annotation.SuppressLint
import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri
import android.util.Log
import com.nitrox.enderecoex.R
import com.nitrox.enderecoex.model.repository.EnderecoRepository
import com.nitrox.enderecoex.persistence.EnderecoDatabase
import org.jetbrains.annotations.Contract
import java.lang.Integer.parseInt

@SuppressLint("Registered")
class EnderecoContentProvider : ContentProvider() {
    val TAG = "EnderecoContentProvider"

    var mData: Array<String>? = null

    private val sUriMatcher = UriMatcher(UriMatcher.NO_MATCH)
    private val ENDERECOS = 1
    private val ENDERECOS_ID = 2

    override fun onCreate(): Boolean {
        initUriMatching()
        val context = context
        mData = context!!.resources.getStringArray(R.array.sentence)
        return true
    }

    private fun initUriMatching() {
        sUriMatcher.addURI(EnderecoContrato.AUTHORITY, EnderecoContrato.CONTENT_PATH, ENDERECOS)
        sUriMatcher.addURI(EnderecoContrato.AUTHORITY, EnderecoContrato.CONTENT_PATH + "/#", ENDERECOS_ID)
    }

    override fun query(uri: Uri, projection: Array<String>?, selection: String?, selectionArgs: Array<String>?,
        sortOrder: String?): Cursor? {

        val enderecoDAO = EnderecoDatabase.getInstance(context).enderecoDao()
        var cursor : Cursor? = null
        when (sUriMatcher.match(uri)) {
            ENDERECOS_ID -> {
                selection?.let {
                    cursor = enderecoDAO.selectById(selectionArgs!![0])
                }
            }
            ENDERECOS ->  {
                Log.v(TAG, "Cursor da consulta: ${enderecoDAO.listAll().size}")
                cursor = enderecoDAO.selectAll()
            }
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