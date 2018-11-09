package com.vandit.sample.room.repository;

import com.vandit.sample.room.database.entity.Notes;

import java.util.List;

import androidx.lifecycle.LiveData;

public interface NotesDataSource {

    void insertOrUpdate(Notes notes);

    void delete(Notes notes);

    void deleteAllNotes();

    LiveData<List<Notes>> getAllNotes();
}
