package com.example.facebook_login


import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.facebook_login.R
import kotlinx.android.synthetic.main.fragment_fragment_food.*

/**
 * A simple [Fragment] subclass.
 */
class Fragment_Food : Fragment() {
    private var _title_:String?=null
    private var _detail_:String?=null
    private var image :String?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fragment_food, container, false)
        val layout_title =view?.findViewById<TextView>(R.id.tv_name)
        val layout_detail =view?.findViewById<TextView>(R.id.tv_description)
        val layout_image =view.findViewById<ImageView>(R.id.imgV)
        layout_title?.text = this._title_
        layout_detail?.text = this._detail_

        Glide
            .with(this)
            .load(image)
            .into(layout_image);

        

        val button: Button = view.findViewById(R.id.buy_now);
        // Inflate the layout for this fragment
        button.setOnClickListener {

            Toast.makeText(context, "Add to cart Success!!", Toast.LENGTH_LONG).show()


        }
        return view
    }
    fun newInstance(_title_: String,_detail_: String,image:String): Fragment_Food {
        val fragment = Fragment_Food()
        val bundle = Bundle()
        bundle.putString("_title", _title_)
        bundle.putString("_detail", _detail_)
        bundle.putString("image", image)
        fragment.setArguments(bundle)
        return fragment
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            _title_ = bundle.getString("_title").toString()
            _detail_ = bundle.getString("_detail").toString()
            image = bundle.getString("image").toString()
        }
    }

}

