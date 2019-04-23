package com.nitrox.enderecoex.persistence

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.database.Cursor
import com.nitrox.enderecoex.model.Endereco

@Dao
abstract class EnderecoDAO {

    @Insert
    abstract fun save(endereco: Endereco)

    @Query("SELECT * from ${EnderecoTableInfo.TABLE_NAME}")
    abstract fun listAll(): List<Endereco>

    @Query("SELECT * from ${EnderecoTableInfo.TABLE_NAME}")
    abstract fun selectAll(): Cursor

    @Query("SELECT * from ${EnderecoTableInfo.TABLE_NAME} where ${EnderecoTableInfo.COLUMN_ID} = :id")
    abstract fun findById(id: String) : Endereco

    @Query("SELECT * from ${EnderecoTableInfo.TABLE_NAME} where ${EnderecoTableInfo.COLUMN_ID} = :id")
    abstract fun selectById(id: String) : Cursor

}