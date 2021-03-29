package com.example.bcads4.module.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bcads4.module.list.AllMovieActivity
import com.example.bcads4.R
import com.example.bcads4.adapter.MovieAdapter
import com.example.bcads4.model.FilmModel
import com.example.bcads4.module.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val dataList = ArrayList<FilmModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_movie.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        loadDataSample()

        rv_movie.adapter = MovieAdapter(dataList) {
            val intent = Intent(this, DetailActivity::class.java)
                .putExtra("data", it)
            startActivity(intent)
        }

        tv_view_all.setOnClickListener {
            val intent = Intent(this, AllMovieActivity::class.java)
                .putExtra("data", dataList)
            startActivity(intent)
        }
    }

    private fun loadDataSample() {
        dataList.add(
            FilmModel(
                "1",
                "A Rainy Day in New York",
                "Kami belum memiliki kilasan singkat dalam bahasa Indonesia. Bantu kami menambahkannya.",
                "Action",
                    R.drawable.ic_ad_astra,
                    R.raw.video_a_rainy_day,
                3.0F
            )
        )

        dataList.add(
            FilmModel(
                "2",
                "A Rainy Day in New York",
                "Kami belum memiliki kilasan singkat dalam bahasa Indonesia. Bantu kami menambahkannya.",
                "Action",
                    R.drawable.ic_avengers,
                    R.raw.video_sample,
                5.0F
            )
        )

        dataList.add(
            FilmModel(
                "3",
                "A Rainy Day in New York",
                "Kami belum memiliki kilasan singkat dalam bahasa Indonesia. Bantu kami menambahkannya.",
                "Action",
                    R.drawable.ic_poster_a_rainy_day_in_new_york,
                    R.raw.video_sample,
                4.0F
            )
        )

        dataList.add(
            FilmModel(
                "4",
                "A Rainy Day in New York",
                "Kami belum memiliki kilasan singkat dalam bahasa Indonesia. Bantu kami menambahkannya.",
                "Action",
                    R.drawable.ic_poster_sonic,
                    R.raw.video_sonic,
                2.0F
            )
        )

        dataList.add(
            FilmModel(
                "5",
                "A Rainy Day in New York",
                "Kami belum memiliki kilasan singkat dalam bahasa Indonesia. Bantu kami menambahkannya.",
                "Action",
                    R.drawable.ic_ad_astra,
                    R.raw.video_sample,
                1.0F
            )
        )

        dataList.add(
            FilmModel(
                "6",
                "A Rainy Day in New York",
                "Kami belum memiliki kilasan singkat dalam bahasa Indonesia. Bantu kami menambahkannya.",
                "Action",
                    R.drawable.ic_poster_sonic,
                    R.raw.video_sonic,
                3.0F
            )
        )
    }
}