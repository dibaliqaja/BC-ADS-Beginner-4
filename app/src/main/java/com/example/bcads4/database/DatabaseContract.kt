package com.example.bcads4.database

import android.provider.BaseColumns

internal class DatabaseContract {
    internal class NoteColumns : BaseColumns {
        companion object {
            const val TABLE_NAME = "note"
            const val _ID = "id"
            const val TITLE = "title"
            const val DESC = "desc"
            const val POSTER = "poster"
            const val GENRE = "genre"
            const val TRAILER = "trailer"
            const val RATING = "rating"
        }
    }
}