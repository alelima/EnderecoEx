package com.nitrox.enderecoex.persistence

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.nitrox.enderecoex.model.Endereco

@Dao
abstract class EnderecoDAO {

    @Insert
    abstract fun save(endereco: Endereco)

    @Query("SELECT * from ${EnderecoTableInfo.TABLE_NAME}")
    abstract fun listAll(): List<Endereco>

}