package com.rtusiime.memez

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

const val VIEW_NUMBER = "TimesViewed"

class DisplayActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    var caption = 1
    var image = 1
    var captionMap : MutableMap<Int, String> = mutableMapOf<Int,String>()
    var imageMap : MutableMap<Int, Drawable?> = mutableMapOf<Int, Drawable?>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        captionMap  = mutableMapOf<Int,String>(1 to getString(R.string.meme_message_1),
            2 to getString(R.string.meme_message_2),3 to getString(R.string.meme_message_3),4 to getString(
                R.string.meme_message_4),
            5 to getString(R.string.meme_message_5), 6 to getString(R.string.meme_message_6), 7 to getString(
                R.string.meme_message_7),
            8 to getString(R.string.meme_message_1))

        imageMap  = mutableMapOf<Int, Drawable?>(
            1 to getDrawable(R.drawable.blinkingguymeme),
            2 to getDrawable(R.drawable.cryingjordanmeme),
            3 to getDrawable(R.drawable.bernie),
            4 to getDrawable(R.drawable.guiltycatmeme),
            5 to getDrawable(R.drawable.kermit),
            6 to getDrawable(R.drawable.mathladymeme),
            7 to getDrawable(R.drawable.spidermanmeme),
            8 to getDrawable(R.drawable.cryingkidmeme))



        imageView = findViewById(R.id.imageView)
//        image.visibility = View.VISIBLE

         textView= findViewById(R.id.textView)

        val bundle = intent.extras
        if (bundle!=null) {
            caption = bundle.getInt(CAPTION)
            image = bundle.getInt(IMAGE)
//            Toast.makeText(this,msg, Toast.LENGTH_LONG).show()
        }
        imageView.setImageDrawable(imageMap.getValue(image))
        textView.text = captionMap.getValue(caption)
    }





}