package com.example.tourism

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_visite_options.*

class VisiteOptionsActivity : AppCompatActivity() , RecyclerItemClickListener{

    private lateinit var linearLayoutManager: LinearLayoutManager
    val lists = ArrayList<DetailList>()

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visite_options)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this , LinearLayout.VERTICAL , false)

//        val lists = ArrayList<DetailList>()

        lists.add(DetailList("Emam Bara", "Bara Imambara, also known as Asfi Mosque is an imambara complex in Lucknow, India built by Asaf-ud-Daula, Nawab of Awadh in 1784. Bara means big.", R.drawable.emam_bara))
        lists.add(DetailList("Rumi Darwaza", "The Rumi Darwaza, in Lucknow, Uttar Pradesh, India, is an imposing gateway which was built under the patronage of Nawab Asaf-Ud-daula in 1784. It is an example of Awadhi architecture. The Rumi Darwaza, which stands sixty feet tall, was modeled after the Sublime Porte in Istanbul.", R.drawable.rumi_darwaza))
        lists.add(DetailList("Qaisar Bagh", "Qaisarbagh, also spelled Qaiserbagh, Kaisarbagh or Kaiserbagh, is a complex in the city of Lucknow, located in the Awadh region of India. It was built by Wajid Ali Shah, the last Nawab of Awadh.", R.drawable.qaisar_bagh))
        lists.add(DetailList("Chattar Manzil", "The Chattar Manzil, or Umbrella Palace is a building in Lucknow in Uttar Pradesh which served as a palace for the rulers of Awadh and their wives. Coordinates:26°85′N 80°93′E", R.drawable.chattar_manzil))
        lists.add(DetailList("Gomti Riverfront Park", "Gomti Riverfront is a newly constructed park with some excellent asthetic attraction positioned in Lucknow, Uttar Pradesh.", R.drawable.gomti_riverfront_park))
        lists.add(DetailList("NBRI", "The National Botanical Research Institute is a research institute of CSIR in Lucknow. It is engaged in the field of taxonomy and modern biology.", R.drawable.nbri))

        val adapter = CustomAdapter(lists, this)

        recyclerView.adapter = adapter

    }

    override fun OnItemClick(position: Int) {
        Log.e("ON ITEM CLICK POSITION", "${position}")
        val intent = Intent(this, PlaceDetailActivity::class.java)
        val r = lists[position]
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