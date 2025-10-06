package com.example.splitsmart_poe.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.splitsmart_poe.R
import com.example.splitsmart_poe.model.Expense

class RecentActivityAdapter(private var items: List<Expense>) :
    RecyclerView.Adapter<RecentActivityAdapter.VH>() {

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar: ImageView = itemView.findViewById(R.id.img_activity_avatar)
        val title: TextView = itemView.findViewById(R.id.tv_activity_title)
        val sub: TextView = itemView.findViewById(R.id.tv_activity_sub)
        val amount: TextView = itemView.findViewById(R.id.tv_amount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recent_activity, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val e = items[position]
        holder.title.text = e.title
        holder.sub.text = e.subtitle
        holder.amount.text = e.formattedAmount()
        holder.avatar.setImageResource(R.drawable.ic_group_avatar)
    }

    override fun getItemCount(): Int = items.size

    fun updateData(newItems: List<Expense>) {
        this.items = newItems
        notifyDataSetChanged()
    }
}
