package com.example.splitsmart_poe.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.splitsmart_poe.R
import com.example.splitsmart_poe.model.Group

class GroupAdapter(private var items: List<Group>) :
    RecyclerView.Adapter<GroupAdapter.VH>() {

    class VH(v: View) : RecyclerView.ViewHolder(v) {
        val avatar: ImageView = v.findViewById(R.id.img_group_avatar_small)
        val name: TextView = v.findViewById(R.id.tv_group_name_small)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_group, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val g = items[position]
        holder.name.text = g.name
        holder.avatar.setImageResource(R.drawable.ic_group_avatar)
    }

    override fun getItemCount(): Int = items.size

    fun updateData(newItems: List<Group>) {
        this.items = newItems
        notifyDataSetChanged()
    }
}
