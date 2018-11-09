package com.vandit.sample.room.view.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.vandit.sample.room.R;
import com.vandit.sample.room.viewmodel.NoteViewModel;
import com.vandit.sample.room.database.entity.Notes;
import com.vandit.sample.room.databinding.ActivityNotesBinding;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class NotesActivity extends AppCompatActivity {

    private NoteViewModel mNoteViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityNotesBinding activityNotesBinding = DataBindingUtil.setContentView(this, R.layout.activity_notes);
        // We are not creating instance of ViewModel class here.
        this.mNoteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        // Bind ViewModel class
        activityNotesBinding.setNotesViewModel(this.mNoteViewModel);
        setSupportActionBar(activityNotesBinding.toolbar);

        mNoteViewModel.getAllNotes().observe(this, new Observer<List<Notes>>() {
            @Override
            public void onChanged(List<Notes> notes) {
                Toast.makeText(NotesActivity.this, "Data Changed", Toast.LENGTH_SHORT).show();
            }
        });
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
