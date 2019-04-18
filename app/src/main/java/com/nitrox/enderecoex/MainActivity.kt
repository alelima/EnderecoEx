package com.nitrox.enderecoex

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

import com.nitrox.enderecoex.model.repository.EnderecoRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textRua = findViewById<TextView>(R.id.editTextRua)
        val textCidade = findViewById<TextView>(R.id.editTextCidade)
        val textCEP = findViewById<TextView>(R.id.editTextCEP)

        val botaoGravar = findViewById<Button>(R.id.salvar)
        botaoGravar.setOnClickListener {
            val cidade = textCidade.text
            val rua = textRua.text
            val cep = textCEP.text

            object: AsyncTask<Void, Void, Unit>() {
                override fun doInBackground(vararg params: Void?) {
                    val repository = EnderecoRepository(this@MainActivity.applicationContext)
                    repository.save(rua.toString(), cidade.toString(), cep.toString())
                }
            }.execute()
        }
    }
}
