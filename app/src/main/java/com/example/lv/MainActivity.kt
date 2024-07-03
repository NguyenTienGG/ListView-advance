package com.example.lv

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lv.databinding.ActivityMainBinding


private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    lateinit var customAdaoter: CustomAdaoter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var list = mutableListOf<OurData>()
        list.add(OurData(R.drawable.luffy, "Luffy ", "Thuyền trưởng băng hải tặc mũ rơm"))
        list.add(OurData(R.drawable.zoro, "Zoro ", "Kiếm sĩ đứng đầu băng hải tặc mũ rơm"))
        list.add(OurData(R.drawable.sanji, "Sanji ", "Đầu bếp của băng mũ rơm"))
        list.add(OurData(R.drawable.nami, "Nami ", "Thủy thủ đầu tiên của băng mũ rơm"))
        list.add(OurData(R.drawable.robin, "Robin ", "Nhà khảo cổ của băng mũ rơm"))
        list.add(OurData(R.drawable.jinbei, "Jinbe ", "Nguoi cá đầu tiên của băng mũ rơm"))
        list.add(OurData(R.drawable.brook, "Brook ", "Nhạc công của băng mũ rơm"))
        list.add(OurData(R.drawable.chooper, "Chooper ", "Bác sĩ của băng mũ rơm"))


        customAdaoter = CustomAdaoter(this, list)

        val  listView = findViewById<ListView>(R.id.LVPhim)

        listView.adapter = customAdaoter

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Bạn chọn: ${list[position].odtitle}", Toast.LENGTH_SHORT).show()
        }



    }
}