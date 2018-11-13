package com.vandit.sample.room.view.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.vandit.sample.room.R;
import com.vandit.sample.room.database.entity.Notes;
import com.vandit.sample.room.databinding.ActivityNotesBinding;
import com.vandit.sample.room.view.adapter.NotesAdapter;
import com.vandit.sample.room.viewmodel.NoteViewModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

public class NotesActivity extends AppCompatActivity {

    private NoteViewModel mNoteViewModel;
    private NotesAdapter mNotesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityNotesBinding activityNotesBinding = DataBindingUtil.setContentView(this, R.layout.activity_notes);
        // We are not creating instance of ViewModel class here.
        this.mNoteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        // Bind ViewModel class
        activityNotesBinding.setNotesViewModel(this.mNoteViewModel);
        setSupportActionBar(activityNotesBinding.toolbar);
        activityNotesBinding.activityNotesRvNotes.setHasFixedSize(true);
        activityNotesBinding.activityNotesRvNotes.setLayoutManager(new LinearLayoutManager(this));
        mNoteViewModel.getAllNotes().observe(this, new Observer<List<Notes>>() {
            @Override
            public void onChanged(@NonNull List<Notes> notes) {
                setNotesData(notes, activityNotesBinding);
            }
        });
    }

    private void setNotesData(@NonNull List<Notes> notes, @NonNull ActivityNotesBinding activityNotesBinding) {
        if (notes.isEmpty()) {
            return;
        }
        if (this.mNotesAdapter == null) {
            this.mNotesAdapter = new NotesAdapter(notes);
            activityNotesBinding.activityNotesRvNotes.setAdapter(this.mNotesAdapter);
            return;
        }

        this.mNotesAdapter.notifyDataSetChanged();

        Toast.makeText(NotesActivity.this, "Data Changed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
