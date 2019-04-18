package com.nitrox.enderecoex.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.nitrox.enderecoex.model.Endereco

@Database(entities = arrayOf(Endereco::class), version = 1)
abstract class EnderecoDatabase : RoomDatabase(){
    companion object {
        private var instance: EnderecoDatabase? = null
        fun getInstance(context: Context): EnderecoDatabase {
            if(instance == null){
                instance = Room
                    .databaseBuilder(context, EnderecoDatabase::class.java, "endereco_database")
                    .build()
            }
            return instance!!
        }
    }
    abstract fun enderecoDao():EnderecoDAO
}