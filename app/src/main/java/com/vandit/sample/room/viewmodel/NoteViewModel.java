package com.vandit.sample.room.viewmodel;

import android.app.Application;

import com.vandit.sample.room.database.entity.Notes;
import com.vandit.sample.room.repository.NotesRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class NoteViewModel extends AndroidViewModel {

    private NotesRepository notesRepository;
    private LiveData<List<Notes>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        notesRepository = new NotesRepository(application);
        allNotes = notesRepository.getAllNotes();
    }

    private void deleteNote(Notes notes){
        notesRepository.delete(notes);
    }

    private void deleteAllNotes(){
        notesRepository.deleteAllNotes();
    }

    public LiveData<List<Notes>> getAllNotes() {
        return allNotes;
    }

    public void addNote(Notes notes){
        notesRepository.insertOrUpdate(notes);
    }

    public void onCreateNotesClick(){
        // Open intent for CreateNotesActivity

    }
}
