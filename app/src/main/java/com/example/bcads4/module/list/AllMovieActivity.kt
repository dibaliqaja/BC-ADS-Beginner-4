package com.example.bcads4.module.list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bcads4.R
import com.example.bcads4.adapter.AllMovieAdapter
import com.example.bcads4.model.FilmModel
import com.example.bcads4.module.detail.DetailActivity
import kotlinx.android.synthetic.main.content_all_movie.*

class AllMovieActivity : AppCompatActivity() {

    private var dataList = ArrayList<FilmModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_movie)
        setSupportActionBar(findViewById(R.id.toolbar))

        dataList = intent.getParcelableArrayListExtra("data")!!

        rv_all_movie.layoutManager = LinearLayoutManager(this)

        rv_all_movie.adapter = AllMovieAdapter(dataList) {
            val intent = Intent(this, DetailActivity::class.java)
                .putExtra("data", it)
            startActivity(intent)
        }
    }
}