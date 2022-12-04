package com.example.cleanarchnoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.cleanarchnoteapp.feature_note.presentation.add_edit_note.AddEditNoteScreen
import com.example.cleanarchnoteapp.feature_note.presentation.notes.NotesScreen
import com.example.cleanarchnoteapp.feature_note.presentation.util.Screen
import com.example.cleanarchnoteapp.ui.theme.CleanArchNoteAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchNoteAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   val navController = rememberNavController()
                    NavHost(navController = navController,
                    startDestination = Screen.NoteScreen.route){

                        composable(route = Screen.NoteScreen.route){
                     NotesScreen(navController = navController)

                        }

                        composable(route = Screen.AddEditNOteScreen.route +
                                "?noteId={noteId}&noteColor={noteColor}",
                            arguments = listOf(
                                navArgument(
                                    name = "noteId"
                                ){
                                    type = NavType.IntType
                                    defaultValue = -1
                                },

                                navArgument(
                                    name = "noteColor"
                                ){
                                    type = NavType.IntType
                                    defaultValue = -1
                                },

                            )
                        ){
                            val color = it.arguments?.getInt("noteColor") ?: -1
                           AddEditNoteScreen(navController = navController, noteColor = color )
                        }
                    }
                }
            }
        }
    }
}
