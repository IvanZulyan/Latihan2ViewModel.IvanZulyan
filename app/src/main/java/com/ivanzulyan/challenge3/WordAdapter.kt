package com.ivanzulyan.challenge3

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class WordAdapter(private val listWords: ArrayList<Word>) : RecyclerView.Adapter<WordAdapter.ViewHolder>() {


    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val btnWord = view.findViewById<Button>(R.id.btn_word)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.cv_word,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listWords.get(position).word
        holder.btnWord.text = item

        holder.btnWord.setOnClickListener {
            var activity : AppCompatActivity = holder.view.context as AppCompatActivity
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.google.com/search?q=${item}"))
            activity.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listWords.size
    }
}