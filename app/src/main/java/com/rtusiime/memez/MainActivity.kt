package com.rtusiime.memez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.rtusiime.memez.model.MemeCombinator
import kotlin.random.Random

const val   MEME_CODES= "ShowMemes"
const val   REQUEST_CODE_MEMES= 0
const val IMAGE = "image"
const val CAPTION = "caption"

class MainActivity : AppCompatActivity() {
    private lateinit var generateMemeButton: ImageButton
    private val combinator = MemeCombinator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        generateMemeButton = findViewById(R.id.generate_meme_button)
        generateMemeButton.setOnClickListener{
            onShowOtherView()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode != RESULT_OK){
            return
        }
        if(requestCode== REQUEST_CODE_MEMES){

//            val msg = when(data?.getIntExtra(VIEW_NUMBER,0) ?: 0){
//                1 -> getString(R.string.thanks_for_cookies)
//                2 -> getString(R.string.thanks_for_milk)
//                else -> getString(R.string.thanks_for_nothing)
//            }
           Toast.makeText(this,"request ok", Toast.LENGTH_LONG).show()
        }
    }

    private fun onShowOtherView() {
        val intent = Intent(this, DisplayActivity::class.java)
        startActivity(intent)
        intent.putExtra(CAPTION,combinator.getPair().first)
        intent.putExtra(IMAGE,combinator.getPair().second)
        startActivityForResult(intent, REQUEST_CODE_MEMES)
    }





}