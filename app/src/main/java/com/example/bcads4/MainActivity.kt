package com.example.bcads4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val dataList = ArrayList<FilmModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_movie.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        dataList.add(
            FilmModel(
                "1",
                "A Rainy Day in New York",
                "Kami belum memiliki kilasan singkat dalam bahasa Indonesia. Bantu kami menambahkannya.",
                "Action",
                R.drawable.ic_ad_astra,
                R.raw.video_a_rainy_day,
                0.0F
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
                0.0F
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
                0.0F
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
                0.0F
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
                0.0F
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
                0.0F
            )
        )

        rv_movie.adapter = MovieAdapter(dataList) {
            val intent = Intent(this, DetailActivity::class.java)
                .putExtra("data", it)
            startActivity(intent)
        }
    }
}