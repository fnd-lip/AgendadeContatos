package com.felipe.agendadecontatos.dao

import androidx.room3.Dao
import androidx.room3.Insert
import com.felipe.agendadecontatos.model.Contato

@Dao
interface ContatoDao {
    @Insert
    fun gravar(contato: Contato)

}