package com.vandit.sample.room.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Notes {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "note_details")
    private String noteDetails;

    @ColumnInfo(name = "color")
    private String color;

    public Notes(String title, String noteDetails, String color) {
        this.title = title;
        this.noteDetails = noteDetails;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getNoteDetails() {
        return noteDetails;
    }

    public String getColor() {
        return color;
    }
}
