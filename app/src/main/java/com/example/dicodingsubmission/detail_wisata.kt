package com.example.dicodingsubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class detail_wisata : AppCompatActivity() {
////////////////////////////////////////////////////////////////////////
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_wisata_ntt)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail Wisata di NTT"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val tvSetNama: TextView = findViewById(R.id.tv_set_name)
        val imgSetPhotowebsite: ImageView = findViewById(R.id.img_item_photo)
        val tvcaption: TextView = findViewById(R.id.tv_set_overview)
        val tvrating: TextView = findViewById(R.id.tv_item_rank)

        val tNama  = intent.getStringExtra(EXTRA_NAMA)
        val tImg = intent.getStringExtra(EXTRA_PHOTOWEBSITE)
        val tcaption = intent.getStringExtra(EXTRA_CAPTION)
        val trating = intent.getStringExtra(EXTRA_RATING)


//////////////////////////////////////////////////////////////////////////
        tvSetNama.text = tNama
        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgSetPhotowebsite)
        tvcaption.text = tcaption
        tvrating.text = trating
    }
///////////////////////////////////////////////////////////////////////////
    companion object {
        const val EXTRA_NAMA = "extra_nama"
        const val EXTRA_PHOTOWEBSITE = "extra_photowebsite"
        const val EXTRA_DESKRIPSI = "extra_deskripsi"
        const val EXTRA_CAPTION = "extra_caption"
        const val EXTRA_RATING = "extra_rating"
    }
////////////////////////////////////////////////////////////////////////////
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
