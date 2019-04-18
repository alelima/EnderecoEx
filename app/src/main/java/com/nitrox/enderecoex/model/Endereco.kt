package com.nitrox.enderecoex.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Endereco(@PrimaryKey val id: String, val rua: String, val cidade: String, val cep: String)