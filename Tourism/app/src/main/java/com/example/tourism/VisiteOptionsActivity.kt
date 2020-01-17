package com.example.tourism

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.tourism.adapter.CustomAdapterGrid
import com.example.tourism.adapter.CustomAdapterList
import com.example.tourism.adapter.CustomAdapterStaggered
import kotlinx.android.synthetic.main.activity_visite_options.*


class VisiteOptionsActivity : AppCompatActivity() , RecyclerItemClickListener{

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var staggeredManager : StaggeredGridLayoutManager
    val lists = ArrayList<DetailList>()
    var view_grid = false
    var view_list = false
    var view_staggered = false

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visite_options)

        button.setOnClickListener {
            if (view_grid == false) {
                button.setImageResource(R.drawable.ic_stagger)
                tvRecyclerViewStyle.text = "Grid View"
                //            gridLayoutManager.setSpanCount(if (gridLayoutManager.spanCount == 2) 1 else 2)
                gridLayoutManager = GridLayoutManager (this, 2)
                recyclerView.layoutManager = gridLayoutManager
                val adapter =
                    CustomAdapterGrid(lists, this)

                recyclerView.adapter = adapter
                view_grid = true
            }
            else if (view_list == false) {
                button.setImageResource(R.drawable.ic_list)
                tvRecyclerViewStyle.text = "Staggered View"

                val staggeredGridLayoutManager =
                    StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
                recyclerView.layoutManager = staggeredGridLayoutManager

                val adapter = CustomAdapterStaggered(
                    lists,
                    this
                )

                recyclerView.adapter = adapter
                view_list = true

            }
            else {
                button.setImageResource(R.drawable.ic_grid)
                tvRecyclerViewStyle.text = "List View"
                linearLayoutManager = LinearLayoutManager(this)
                recyclerView.layoutManager = linearLayoutManager
                recyclerView.layoutManager = LinearLayoutManager(this , LinearLayout.VERTICAL , false)

                val adapter =
                    CustomAdapterList(lists, this)

                recyclerView.adapter = adapter
                view_grid = false
                view_list = false
            }

        }
        button.setImageResource(R.drawable.ic_grid)
        tvRecyclerViewStyle.text = "List View"
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.layoutManager = LinearLayoutManager(this , LinearLayout.VERTICAL , false)

        val adapter = CustomAdapterList(lists, this)

        recyclerView.adapter = adapter

        lists.add(DetailList("Emam Bara", "Bara Imambara, also known as Asfi Mosque is an imambara complex in Lucknow, India built by Asaf-ud-Daula, Nawab of Awadh in 1784. Bara means big.", R.drawable.emam_bara))
        lists.add(DetailList("Rumi Darwaza", "The Rumi Darwaza, in Lucknow, Uttar Pradesh, India, is an imposing gateway which was built under the patronage of Nawab Asaf-Ud-daula in 1784. It is an example of Awadhi architecture. The Rumi Darwaza, which stands sixty feet tall, was modeled after the Sublime Porte in Istanbul.", R.drawable.rumi_darwaza))
        lists.add(DetailList("Qaisar Bagh", "Qaisarbagh, also spelled Qaiserbagh, Kaisarbagh or Kaiserbagh, is a complex in the city of Lucknow, located in the Awadh region of India. It was built by Wajid Ali Shah, the last Nawab of Awadh.", R.drawable.qaisar_bagh))
        lists.add(DetailList("Chattar Manzil", "The Chattar Manzil, or Umbrella Palace is a building in Lucknow in Uttar Pradesh which served as a palace for the rulers of Awadh and their wives. Coordinates:26°85′N 80°93′E", R.drawable.chattar_manzil))
        lists.add(DetailList("Gomti Riverfront Park", "Gomti Riverfront is a newly constructed park with some excellent asthetic attraction positioned in Lucknow, Uttar Pradesh.", R.drawable.gomti_riverfront_park))
        lists.add(DetailList("NBRI", "The National Botanical Research Institute is a research institute of CSIR in Lucknow. It is engaged in the field of taxonomy and modern biology.", R.drawable.nbri))

    }

    override fun OnItemClick(position: Int) {
        Log.e("ON ITEM CLICK POSITION", "${position}")
        val intent = Intent(this, PlaceDetailActivity::class.java)
        var detail = lists[position]

        var placename =  detail.subPlaceName
        var placeDetail =  detail.subPlaceDetail
        var image = detail.subPlaceImage

        intent.putExtra("placename", placename)
        intent.putExtra("placeDetail", placeDetail)
        intent.putExtra("image", image)
        startActivity(intent)
    }
}