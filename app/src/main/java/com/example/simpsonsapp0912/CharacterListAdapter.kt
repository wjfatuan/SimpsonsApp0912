package com.example.simpsonsapp0912

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CharacterListAdapter(val ctx: Context, val data: ArrayList<String>) :
    ArrayAdapter<String>(ctx, R.layout.list_characters, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater!!.inflate(R.layout.list_characters, null, false)
        val tv = view.findViewById<TextView>(R.id.characterName)
        tv.text = data[position]
        val iv = view.findViewById<ImageView>(R.id.characterIcon)
        val id = ctx.resources.getIdentifier(data[position].lowercase(), "drawable", ctx.packageName)
        iv.setImageResource(id)
        return view
    }
}