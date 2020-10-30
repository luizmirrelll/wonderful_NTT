package com.example.dicodingsubmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var rvwisata: RecyclerView
    private var list: ArrayList<wisata> = arrayListOf()
//////////////////////////////////////////////////////////////////////////////////////////////////
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title= "Home"

        rvwisata = findViewById(R.id.rv_wisata)
        rvwisata.setHasFixedSize(true)

        list.addAll(WisataData.listData)
        showRecyclerList()
    }
/////////////////////////////////////////////////////////////////////////////////////////////
    private fun showRecyclerList() {
        rvwisata.layoutManager = LinearLayoutManager(this)
        val listWsataAdapter = ListWsataAdapter(list)
        rvwisata.adapter = listWsataAdapter
    }
/////////////////////////////////////////////////////////////////////////////////////////////
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optionmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }
//////////////////////////////////////////////////////////////////////////////////////////////
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
//////////////////////////////////////////////////////////////////////////////////////////////////
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.miCompose -> {
                val iAbout = Intent(this@MainActivity, about::class.java)
                startActivity(iAbout)
            }
        }
    }
}
