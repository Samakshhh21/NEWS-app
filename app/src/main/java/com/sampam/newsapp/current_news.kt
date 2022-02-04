package com.sampam.newsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.sampam.newsapp.databinding.ActivityCurrentNewsBinding

lateinit var binding1:ActivityCurrentNewsBinding
class current_news : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding1=DataBindingUtil.setContentView(this,R.layout.activity_current_news)
        val title=intent.getStringExtra("title")
        val content=intent.getStringExtra("content")
        val photo=intent.getStringExtra("image")
        binding1.textView.text=title
        binding1.textView2.text=content
      Glide.with(this)
          .load(photo)
          .into(binding1.imageView2)
    }
}