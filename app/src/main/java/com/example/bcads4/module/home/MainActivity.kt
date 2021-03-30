package com.example.bcads4.module.home

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bcads4.LoginActivity
import com.example.bcads4.module.list.AllMovieActivity
import com.example.bcads4.R
import com.example.bcads4.adapter.MovieAdapter
import com.example.bcads4.api.DummyData
import com.example.bcads4.model.FilmModel
import com.example.bcads4.module.detail.DetailActivity
import com.example.bcads4.utils.Const.LOGIN_CODE
import com.example.bcads4.utils.UserPreference
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val dataList = ArrayList<FilmModel>()
    lateinit var userPreference: UserPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userPreference = UserPreference(this)

        sf_movie.startShimmer()
        val handler = Handler()
        handler.postDelayed({
            sf_movie.stopShimmer()
            sf_movie.visibility = View.GONE
            rv_movie.visibility = View.VISIBLE

            initListener()
            getData()
        }, 5000)
    }

    private fun initListener() {
        tv_user.setOnClickListener {
            if (userPreference.getUserStatus()) {
                // Data List
            } else {
                val intent = Intent(this, LoginActivity::class.java)
                startActivityForResult(intent, LOGIN_CODE)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initView() {
        rv_movie.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
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

        if (userPreference.getUserStatus()) {
            tv_user.text = userPreference.getUserName()
            tv_desc_user.text = "Thanks for join, do you want to exit?"
            btn_logout.visibility = View.VISIBLE
        } else {
            tv_user.text = "Login"
            tv_desc_user.text = "Save your favorite movie"
            btn_logout.visibility = View.INVISIBLE
        }
    }

    private fun getData() {
        for (i in DummyData.titleMovie.indices) {
            dataList.add(
                FilmModel(
                    i+1,
                    DummyData.titleMovie[i],
                    DummyData.descMovie[i],
                    DummyData.genreMovie[i],
                    DummyData.posterMovie[i],
                    DummyData.trailerMovie[i],
                    DummyData.ratingMovie[i],
                )
            )
        }

        initView()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == LOGIN_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                initView()
            }
        }
    }

    override fun onResume() {
        super.onResume()

        initView()
    }
}