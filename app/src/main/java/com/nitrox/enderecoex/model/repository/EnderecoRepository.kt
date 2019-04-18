package com.nitrox.enderecoex.model.repository

import android.content.Context
import com.nitrox.enderecoex.model.Endereco
import com.nitrox.enderecoex.persistence.EnderecoDAO
import com.nitrox.enderecoex.persistence.EnderecoDatabase
import java.util.*

class EnderecoRepository {
    private val enderecoDAO: EnderecoDAO

    constructor(context: Context){
        val enderecoDatabase = EnderecoDatabase.getInstance(context)
        enderecoDAO = enderecoDatabase.enderecoDao()
    }

    fun save(rua: String, cidade: String, cep: String) {
        val endereco = Endereco(UUID.randomUUID().toString(), rua, cidade, cep)
    }

    fun listAll(): List<Endereco> {
        return enderecoDAO.listAll()
    }
}