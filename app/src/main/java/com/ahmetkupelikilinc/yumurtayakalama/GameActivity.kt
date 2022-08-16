package com.ahmetkupelikilinc.yumurtayakalama

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AlertDialog
import android.view.View
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {
    var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        object : CountDownTimer(20000, 1000) {
            override fun onFinish() {
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
                timerText.text = "Time: " + millisUntilFinished / 1000
            }
        }.start()
    }

    fun scoreUp(view: View){
        score = score + 1
        scoreText.text = "Skore : $score"
    }
}