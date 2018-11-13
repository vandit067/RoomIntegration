package com.vandit.sample.room.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.vandit.sample.room.BR;
import com.vandit.sample.room.R;
import com.vandit.sample.room.database.entity.Notes;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {

    private List<Notes> notesList;

    public NotesAdapter(@NonNull List<Notes> notesList) {
        this.notesList = notesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_note, parent, false);
        return new MyViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Notes notes = notesList.get(position);
        holder.bind(notes);

    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final ViewDataBinding viewDataBinding;

        private MyViewHolder(@NonNull ViewDataBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            this.viewDataBinding = viewDataBinding;
        }

        private void bind(Object obj) {
            viewDataBinding.setVariable(BR.obj, obj);
            viewDataBinding.executePendingBindings();
        }
    }
}
