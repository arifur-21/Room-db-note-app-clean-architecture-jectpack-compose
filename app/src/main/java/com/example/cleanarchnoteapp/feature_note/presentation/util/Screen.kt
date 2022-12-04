package com.example.cleanarchnoteapp.feature_note.presentation.util

sealed class Screen(val route: String){
    object NoteScreen: Screen("notes_screen")
    object AddEditNOteScreen: Screen("add_edit_note_screen")
}
