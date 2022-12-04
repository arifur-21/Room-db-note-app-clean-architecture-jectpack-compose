package com.example.cleanarchnoteapp.feature_note.domain.use_case

import com.example.cleanarchnoteapp.feature_note.domain.model.Note
import com.example.cleanarchnoteapp.feature_note.domain.remository.NoteRepository

class DeleteNoteUseCase(
    private val repository: NoteRepository
) {
   
    suspend operator fun  invoke(note: Note){
        repository.deleteNote(note)
    }

}