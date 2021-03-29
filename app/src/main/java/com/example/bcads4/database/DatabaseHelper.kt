package com.example.bcads4.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.bcads4.database.DatabaseContract.NoteColumns.Companion.DESC
import com.example.bcads4.database.DatabaseContract.NoteColumns.Companion.GENRE
import com.example.bcads4.database.DatabaseContract.NoteColumns.Companion.POSTER
import com.example.bcads4.database.DatabaseContract.NoteColumns.Companion.RATING
import com.example.bcads4.database.DatabaseContract.NoteColumns.Companion.TABLE_NAME
import com.example.bcads4.database.DatabaseContract.NoteColumns.Companion.TITLE
import com.example.bcads4.database.DatabaseContract.NoteColumns.Companion.TRAILER
import com.example.bcads4.database.DatabaseContract.NoteColumns.Companion._ID

internal class DatabaseHelper (context: Context)
    : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

        companion object {
            private const val DATABASE_NAME = "dbmovie_app"
            private const val DATABASE_VERSION = 1
            private val SQL_CREATE_TABLE_NOTE = "CREATE TABLE $TABLE_NAME"+
                    "(${_ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "${TITLE} TEXT NOT NULL" +
                    "${DESC} TEXT NOT NULL" +
                    "${POSTER} TEXT NOT NULL" +
                    "${GENRE} TEXT NOT NULL" +
                    "${TRAILER} TEXT NOT NULL" +
                    "${RATING} TEXT NOT NULL"
        }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_TABLE_NOTE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
}