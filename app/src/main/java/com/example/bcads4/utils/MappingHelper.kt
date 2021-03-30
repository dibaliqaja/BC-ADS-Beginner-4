package com.example.bcads4.utils

import android.database.Cursor
import com.example.bcads4.database.DatabaseContract.NoteColumns.Companion.DESC
import com.example.bcads4.database.DatabaseContract.NoteColumns.Companion.GENRE
import com.example.bcads4.database.DatabaseContract.NoteColumns.Companion.POSTER
import com.example.bcads4.database.DatabaseContract.NoteColumns.Companion.RATING
import com.example.bcads4.database.DatabaseContract.NoteColumns.Companion.TITLE
import com.example.bcads4.database.DatabaseContract.NoteColumns.Companion.TRAILER
import com.example.bcads4.database.DatabaseContract.NoteColumns.Companion._ID
import com.example.bcads4.model.FilmModel

object MappingHelper {
    fun mapCursorToArrayList(notesCursor: Cursor?): ArrayList<FilmModel> {
        val noteList = ArrayList<FilmModel>()
        notesCursor?.apply {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(_ID))
                val title = getString(getColumnIndexOrThrow(TITLE))
                val desc = getString(getColumnIndexOrThrow(DESC))
                val genre = getString(getColumnIndexOrThrow(GENRE))
                val poster = getInt(getColumnIndexOrThrow(POSTER))
                val trailer = getInt(getColumnIndexOrThrow(TRAILER))
                val rating = getFloat(getColumnIndexOrThrow(RATING))
                noteList.add(FilmModel(id, title, desc, genre, poster, trailer, rating))
            }
        }
        return noteList
    }
}