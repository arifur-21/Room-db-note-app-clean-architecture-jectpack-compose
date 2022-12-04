package com.example.cleanarchnoteapp.feature_note.domain.model

import android.util.Log
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cleanarchnoteapp.ui.theme.*


@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
){
    companion object{
      val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message: String): Exception(message)
