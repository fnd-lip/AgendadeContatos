package com.felipe.agendadecontatos.dao

import androidx.room3.Dao
import androidx.room3.Insert
import androidx.room3.Query
import com.felipe.agendadecontatos.model.Contato

@Dao
interface ContatoDao {
    @Insert
    fun gravar(contato: Contato)

    @Query(value = "SELECT * FROM tabela_contatos ORDER BY nome ASC")
    fun getContatos(): MutableList<Contato>

}