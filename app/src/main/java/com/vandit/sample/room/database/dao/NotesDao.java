package com.vandit.sample.room.database.dao;

import com.vandit.sample.room.database.entity.Notes;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface NotesDao {

    @Query("SELECT * FROM notes")
    LiveData<List<Notes>> getNotes();

    @Query("SELECT * FROM notes WHERE id = :noteId")
    Notes getNoteBasedOnNoteId(int noteId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrUpdateNote(Notes notes);

    @Delete
    void deleteNote(Notes notes);

    @Query("Delete From notes")
    void deleteAllNotes();
}
