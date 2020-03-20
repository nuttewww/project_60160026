package com.example.facebook_login


import android.app.AlertDialog
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
import android.content.DialogInterface
import com.facebook.FacebookSdk.getApplicationContext
import com.google.firebase.database.FirebaseDatabase


/**
 * A simple [Fragment] subclass.
 */
class Detail_Food : Fragment() {

    private var title:String?=null
    private var detail:String?=null
    private var image:String?=null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(com.example.facebook_login.R.layout.fragment_detail__food, container, false)
        val layout_title =view?.findViewById<TextView>(com.example.facebook_login.R.id._title)
        val layout_detail =view?.findViewById<TextView>(com.example.facebook_login.R.id._det)
        val layout_image =view.findViewById<ImageView>(com.example.facebook_login.R.id.imageView)

        layout_title?.text = this.title
        layout_detail?.text = this.detail


        Glide.with(this)
            .load(image)
            .into(layout_image)


        val button: Button = view.findViewById(R.id.buy_now);
        // Inflate the layout for this fragment
        button.setOnClickListener {

           // Toast.makeText(context, "Add to cart Success!!", Toast.LENGTH_LONG).show()

            val builder = AlertDialog.Builder(context)
            builder.setMessage("ยืนยันการสั่งซื้อหรือไม่?")
            builder.setPositiveButton("ตกลง", DialogInterface.OnClickListener { dialog, id ->
                Toast.makeText(
                    getApplicationContext(),
                    "ทำการสั่งซื้อเรียบร้อย", Toast.LENGTH_SHORT
                ).show()
            })
            builder.setNegativeButton("ยกเลิก", DialogInterface.OnClickListener { dialog, which ->
                //dialog.dismiss();
            })
            builder.show()
        }



        val btn1 = view.findViewById<Button>(R.id.btn1)

        val mRootRef = FirebaseDatabase.getInstance().getReference()

        //อ้างอิงไปที่ path ที่เราต้องการจะจัดการข้อมูล ตัวอย่างคือ users และ messages
        val mUsersRef = mRootRef.child("Rating")

        btn1.setOnClickListener {
            //setValue() เป็นการ write หรือ update ข้อมูล ไปยัง path ที่เราอ้างถึงได้ เช่น users/<user-id>/<username>
            mUsersRef.child("id-01").setValue("Recommended !!")
        }


        return view
    }




    fun newInstance(title: String,detail: String,image:String): Detail_Food {
        val fragment = Detail_Food()
        val bundle = Bundle()
        bundle.putString("title", title)
        bundle.putString("detail", detail)
        bundle.putString("image", image)

        fragment.setArguments(bundle)
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var bundle = arguments
        if (bundle != null) {
            title = bundle.getString("title").toString()
            detail = bundle.getString("detail").toString()
            image = bundle.getString("image").toString()

        }
    }

}
