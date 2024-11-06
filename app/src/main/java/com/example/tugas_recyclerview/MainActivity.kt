package com.example.tugas_recyclerview
import ImageAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        // Data contoh gambar (URL dari internet)
        val imageUrls = listOf(
            "https://i.pinimg.com/736x/52/f5/38/52f5382b6852c7fc52a7931c0a775366.jpg",
            "https://i.pinimg.com/736x/c7/f5/fb/c7f5fbdb9b45999a6ced425662544f72.jpg",
            "https://i.pinimg.com/736x/5d/95/e8/5d95e839390aaa7e68e419549400e7aa.jpg",
            "https://i.pinimg.com/736x/af/6d/1f/af6d1f5fa2d4e89aeae97b3cd98980c9.jpg",
            "https://i.pinimg.com/736x/55/5a/a0/555aa013d29bbf308f5f2aa90e7f0ea4.jpg",
            "https://i.pinimg.com/736x/4f/37/03/4f37036ce0b309e6d3a94f8956e5174c.jpg"
        )

        val images = imageUrls.map { Image(it) }
        recyclerView.adapter = ImageAdapter(images)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.toolbar)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}