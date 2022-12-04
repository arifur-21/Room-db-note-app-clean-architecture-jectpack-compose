package com.example.cleanarchnoteapp.feature_note.presentation.notes

import com.example.cleanarchnoteapp.feature_note.domain.model.Note
import com.example.cleanarchnoteapp.feature_note.domain.util.NoteOrder
import com.example.cleanarchnoteapp.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Data(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
