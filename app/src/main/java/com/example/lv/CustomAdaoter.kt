package com.example.lv

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdaoter(
    val activity: MainActivity,// khởi tạo activity
    val list: List<OurData>// khởi tạo list
):ArrayAdapter<OurData>(activity, R.layout.list_item, list){// khởi tạo adapter


    override fun getCount(): Int {
        return list.size// số phần tử trong list
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return super.getView(position, convertView, parent)// liên kết và hiển thị layout

        val context= activity.layoutInflater// khởi tạo layoutinflater
        val rowView= context.inflate(R.layout.list_item, parent, false)
        val img = rowView.findViewById<ImageView>(R.id.imgHA)
        val title = rowView.findViewById<TextView>(R.id.txtTitle)
        val desc = rowView.findViewById<TextView>(R.id.txtDesc)

        title.text=list[position].odtitle // liên kết từ custom adapter vơi OurData và lấy dữ liệu từ từ listitem
        desc.text=list[position].oddesc
        img.setImageResource(list[position].haimg)


        return rowView
    }
}