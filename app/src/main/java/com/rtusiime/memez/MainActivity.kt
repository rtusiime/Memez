package com.rtusiime.memez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.util.Pair
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.rtusiime.memez.model.MemeCombinator
import com.rtusiime.memez.model.ViewCounter
import kotlin.random.Random

const val   REQUEST_CODE_MEMES= 0
const val IMAGE = "image"
const val CAPTION = "caption"
const val VIEW_NUMBER = "TimesViewed"
private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var generateMemeButton: ImageButton
    private val combinator = MemeCombinator()
    var image =1
    var caption =1
    val viewCount = ViewCounter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        generateMemeButton = findViewById(R.id.generate_meme_button)
        generateMemeButton.setOnClickListener{
            initializePairs()
            onShowOtherView()

            //updateUI

        }
    }

    private fun initializePairs(){
        val pair = combinator.getPair()
        caption = pair.first
        image = pair.second
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt( VIEW_NUMBER, viewCount.views)
        super.onSaveInstanceState(outState)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        viewCount.views= savedInstanceState.getInt(VIEW_NUMBER)

    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode != RESULT_OK){
            return
        }
        if(requestCode== REQUEST_CODE_MEMES){

val msg =
    Toast.makeText(this,"Display Activity viewed ${viewCount.views} times",Toast.LENGTH_LONG).show()
        }
    }

    private fun onShowOtherView() {
        viewCount.views++
        val intent = Intent(this, DisplayActivity::class.java)
        intent.putExtra(CAPTION,caption)
        intent.putExtra(IMAGE,image)
        startActivityForResult(intent, REQUEST_CODE_MEMES)
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "so I'm calling ressummmmeeeeee ${viewCount.views} times now")


    }




}