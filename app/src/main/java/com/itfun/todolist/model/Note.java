package com.itfun.todolist.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity
public class Note implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "text")
    public String text;

    @ColumnInfo(name = "time")
    public long time;

    @ColumnInfo(name = "done")
    public boolean done;

    public Note(){}

    protected Note(Parcel in) {
        uid = in.readInt();
        title = in.readString();
        text = in.readString();
        time = in.readLong();
        done = in.readByte() != 0;
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return uid == note.uid && time == note.time && done == note.done && Objects.equals(title, note.title) && Objects.equals(text, note.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, title, text, time, done);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(uid);
        parcel.writeString(title);
        parcel.writeString(text);
        parcel.writeLong(time);
        parcel.writeByte((byte) (done ? 1 : 0));
    }
}
