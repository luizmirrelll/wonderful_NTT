package com.example.dicodingsubmission

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListWsataAdapter(val listWisata: ArrayList<wisata>) : RecyclerView.Adapter<ListWsataAdapter.ListViewHolder>() {
///////////////////////////////////////////////////////////////////////////////////////////
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_card_wisata, viewGroup,false )
        return ListViewHolder(view)
    }
/////////////////////////////////////////////////////////////////////////////////////////////
    override fun getItemCount(): Int {
        return listWisata.size
    }
/////////////////////////////////////////////////////////////////////////////////////////////
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (nama, rating, photowebsite, caption, deskripsi) = listWisata[position]

        Glide.with(holder.itemView.context)
            .load(photowebsite)
            .apply(RequestOptions())
            .into(holder.imgPhotowebsite)

        holder.tvNama.text = nama
        holder.tvrating.text = rating

        val mContext = holder.itemView.context
////////////////////////////////////////////////////////////////////////////////////////////
        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, detail_wisata::class.java)
            moveDetail.putExtra(detail_wisata.EXTRA_RATING, rating)
            moveDetail.putExtra(detail_wisata.EXTRA_NAMA, nama)
            moveDetail.putExtra(detail_wisata.EXTRA_PHOTOWEBSITE, photowebsite)
            moveDetail.putExtra(detail_wisata.EXTRA_DESKRIPSI, deskripsi)
            moveDetail.putExtra(detail_wisata.EXTRA_CAPTION, caption)
            mContext.startActivity(moveDetail)
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvNama: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvrating: TextView = itemView.findViewById(R.id.tv_item_rank)
        var imgPhotowebsite: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

}