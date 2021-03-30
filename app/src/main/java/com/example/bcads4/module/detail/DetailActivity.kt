package com.example.bcads4.module.detail

import android.content.ContentValues
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import com.example.bcads4.R
import com.example.bcads4.database.DatabaseContract
import com.example.bcads4.database.DatabaseContract.NoteColumns.Companion.DESC
import com.example.bcads4.database.DatabaseContract.NoteColumns.Companion.GENRE
import com.example.bcads4.database.DatabaseContract.NoteColumns.Companion.POSTER
import com.example.bcads4.database.DatabaseContract.NoteColumns.Companion.RATING
import com.example.bcads4.database.DatabaseContract.NoteColumns.Companion.TITLE
import com.example.bcads4.database.DatabaseContract.NoteColumns.Companion.TRAILER
import com.example.bcads4.database.DatabaseContract.NoteColumns.Companion._ID
import com.example.bcads4.database.MovieHelper
import com.example.bcads4.model.FilmModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    lateinit var data : FilmModel
    lateinit var noteHelper : MovieHelper

    private var values = ContentValues()
    private var statusFavorite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        data = intent.getParcelableExtra<FilmModel>("data")!!

        noteHelper = MovieHelper.getInstance(this)
        noteHelper.open()

        initView()
        initListener()
    }

    private fun initView() {
        tv_title.text = data!!.title
        tv_genre.text = data.genre
        tv_desc.text = data.desc

        statusFavorite()
    }

    private fun initListener() {
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        videoView.setVideoURI(Uri.parse("android.resource://"+packageName+"/"+data.trailer))
        videoView.start()

        iv_favorite.setOnClickListener {

            if (statusFavorite) {
                noteHelper.deleteById(data.id.toString())
                iconFavorite(false)

                Toast.makeText(this, "Favorite movie remove!", Toast.LENGTH_SHORT).show()
            } else {
                values.put(_ID, data.id)
                values.put(TITLE, data.title)
                values.put(DESC, data.desc)
                values.put(POSTER, data.poster)
                values.put(GENRE, data.genre)
                values.put(TRAILER, data.trailer)
                values.put(RATING, data.rating)

                noteHelper.insert(values)
                iconFavorite(true)

                Toast.makeText(this, "Favorite movie added!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun iconFavorite(boolean: Boolean) {
        if (boolean) {
            statusFavorite = true
            iv_favorite.setImageResource(R.drawable.ic_baseline_favorite_24)
        } else {
            statusFavorite = false
            iv_favorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }
    }

    private fun statusFavorite() {
        val cursor = noteHelper.queryById(data.id.toString())
        if (cursor.moveToNext()) {
            iconFavorite(true)
        } else {
            iconFavorite(false)
        }
    }
}