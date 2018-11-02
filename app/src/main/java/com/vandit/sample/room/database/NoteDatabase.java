package com.vandit.sample.room.database;

import android.content.Context;

import com.vandit.sample.room.database.dao.NotesDao;
import com.vandit.sample.room.database.entity.Notes;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Room database that contains notes table.
 */
@Database(entities = {Notes.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase INSTANCE;

    public abstract NotesDao notesDao();

    public static NoteDatabase getInstance(@NonNull Context context) {
        if(INSTANCE == null){
            synchronized (NoteDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), NoteDatabase.class, "Notes.db").build();
                }
            }
        }
        return INSTANCE;
    }
}
