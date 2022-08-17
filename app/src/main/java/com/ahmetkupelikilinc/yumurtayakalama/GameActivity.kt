package com.ahmetkupelikilinc.yumurtayakalama

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*
import kotlin.collections.ArrayList

class GameActivity : AppCompatActivity() {
    var score = 0
    var imageArray = ArrayList<ImageView>()
    var handler = Handler()
    var runnable = Runnable {}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)



        imageView10.visibility = View.INVISIBLE

        imageArray.add(imageView)
        imageArray.add(imageView1)
        imageArray.add(imageView2)
        imageArray.add(imageView3)
        imageArray.add(imageView4)
        imageArray.add(imageView5)
        imageArray.add(imageView6)
        imageArray.add(imageView7)
        imageArray.add(imageView8)
        imageArray.add(imageView9)
        imageArray.add(imageView10)
        imageArray.add(imageView11)
        imageArray.add(imageView12)
        imageArray.add(imageView13)
        imageArray.add(imageView14)
        imageArray.add(imageView15)
        imageArray.add(imageView16)
        imageArray.add(imageView17)
        imageArray.add(imageView18)
        imageArray.add(imageView19)
        imageArray.add(imageView20)
        imageArray.add(imageView21)
        imageArray.add(imageView22)
        imageArray.add(imageView23)
        imageArray.add(imageView24)
        imageArray.add(imageView25)
        imageArray.add(imageView26)
        imageArray.add(imageView27)
        imageArray.add(imageView28)

        hideImage()


        object : CountDownTimer(20000, 1000) {
            override fun onFinish() {

                handler.removeCallbacks(runnable)

                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }

                timerText.text = "Oyun Bitti"
                scoreText.text = "Score: $score"

                val alert = AlertDialog.Builder(this@GameActivity)
                alert.setTitle("Oyun Bitti")
                alert.setMessage("Tekrar Oynamak İster misiniz?")
                alert.setPositiveButton("Tekrar Oyna") { dialog, which ->
                    score = 0
                    scoreText.text = "Score: $score"
                    start()
                }
                alert.setNegativeButton("Hayır") { dialog, which ->
                    val intent = Intent(this@GameActivity, MainActivity::class.java)
                    startActivity(intent)

                }
                alert.show()
            }

            override fun onTick(millisUntilFinished: Long) {
                timerText.text = "Kalan Süre: " + millisUntilFinished / 1000
            }
        }.start()
    }

    fun hideImage() {
        runnable = object : Runnable {
            override fun run() {

        for (image in imageArray) {
            image.visibility = View.INVISIBLE
        }
        val random = Random()
        val randomIndex = random.nextInt(29)
        imageArray[randomIndex].visibility = View.VISIBLE

                handler.postDelayed(runnable, 500)
            }
        }
        handler.post(runnable)
    }


    fun scoreUp(view: View){
        score = score + 1
        scoreText.text = "Skore : $score"
//        var scoreSaved = this.getSharedPreferences("com.ahmetkupelikilinc.yumurtayakalama", MODE_PRIVATE)
//        scoreSaved.edit().putInt("score", score).apply()


//        val scoreIntent = Intent(application, MainActivity::class.java)
//        scoreIntent.putExtra("score", score)
//        startActivity(scoreIntent)
    }
}