package com.vandit.sample.room.repository;

import android.app.Application;

import com.vandit.sample.room.database.NoteDatabase;
import com.vandit.sample.room.database.dao.NotesDao;
import com.vandit.sample.room.database.entity.Notes;

import java.util.List;

import androidx.lifecycle.LiveData;

public class NotesRepository implements NotesDataSource{
    private NotesDao notesDao;

    public NotesRepository(Application application) {
        NoteDatabase noteDatabase = NoteDatabase.getInstance(application);
        notesDao = noteDatabase.notesDao();
    }

    public LiveData<List<Notes>> getAllNotes() {
        return notesDao.getNotes();
    }

    @Override
    public void insertOrUpdate(Notes notes) {
        notesDao.insertOrUpdateNote(notes);
    }

    @Override
    public void delete(Notes notes) {
        notesDao.deleteNote(notes);
    }

    @Override
    public void deleteAllNotes() {
        notesDao.deleteAllNotes();
    }
}
