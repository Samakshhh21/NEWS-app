package com.sampam.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sampam.newsapp.databinding.ActivityMainBinding
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

lateinit var binding:ActivityMainBinding
class MainActivity : AppCompatActivity() {
    lateinit var recycle:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
         recycle= binding.rv
       doAsync {
       getnews()
       }

    }

    private fun getnews():news{
            val news = newsService.newsinterface.getheadlines("in", constants.API_KEY)

            var newsresponse: news = news(
                3, listOf(
                    article(
                        "default", "default",
                        "default", "default"
                    )
                )
            )
            news.enqueue(object : Callback<news> {
                override fun onResponse(call: Call<news>, response: Response<news>) {
                    newsresponse = response.body()!!
                    recycle.adapter = newsadapter(this@MainActivity, newsresponse.articles)
                    recycle.layoutManager = LinearLayoutManager(this@MainActivity)
                }

                override fun onFailure(call: Call<news>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()

                }
            })

            return newsresponse
    }
}