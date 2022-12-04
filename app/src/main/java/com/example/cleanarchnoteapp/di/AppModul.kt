package com.example.cleanarchnoteapp.di

import android.app.Application
import androidx.room.Room
import com.example.cleanarchnoteapp.feature_note.data.data_source.NoteDatabase
import com.example.cleanarchnoteapp.feature_note.data.repository.NoteRepositoryImpl
import com.example.cleanarchnoteapp.feature_note.domain.remository.NoteRepository
import com.example.cleanarchnoteapp.feature_note.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModul {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase{
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNOteRepository(db: NoteDatabase): NoteRepository{
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases{
        return NoteUseCases(
            getNotes = GetNotesUseCase(repository),
            deleteNote = DeleteNoteUseCase(repository),
            addNote = AddNote(repository),
            getNoteById = GetNote(repository)

        )
    }
}