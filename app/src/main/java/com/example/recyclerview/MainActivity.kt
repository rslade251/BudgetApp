package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<News>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadData()

    }

    private fun loadData() {
        setContentView(R.layout.activity_main)

        imageId = arrayOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5
        )

        heading = arrayOf(
            "Image 1",
            "Image 2",
            "Image 3",
            "Image 4",
            "Image 5"
        )

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<News>()
        getUserData()

    }

    private fun getUserData() {
        for(i in imageId.indices){
            val news = News(imageId[i],heading[i])
            newArrayList.add(news)
        }

        newRecyclerView.adapter = MyAdapter(newArrayList)

    }

    fun openDetails(view: android.view.View) {
        setContentView(R.layout.test)
    }

    fun closeDetails(view: android.view.View) {
        loadData()
    }


}