package com.example.myapplication

import android.content.DialogInterface
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog

class menu : AppCompatActivity() {
    private lateinit var mp: MediaPlayer
    private lateinit var ivPlay: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        ivPlay = findViewById(R.id.ivPlay)

        playMusic()
    }

    fun StartGame1(view: View) {
        val Intent = Intent(this, MainActivity::class.java)
        startActivity(Intent)
        finish()
    }

    fun aboutProg(view: View){
        val Intent = Intent(this, about::class.java)
        startActivity(Intent)
    }

    private fun playMusic() {
        mp = MediaPlayer.create(this, R.raw.chopin_ballade_no1_in_g_minor)
        mp.start()
        mp.isLooping = true
        mp.setVolume(0.5f, 0.5f)

        ivPlay.setOnClickListener {
            if (mp.isPlaying) {
                mp.pause()
                ivPlay.setBackgroundResource(R.drawable.ic_action_stop)
            } else {
                mp.start()
                ivPlay.setBackgroundResource(R.drawable.ic_action_play)
            }
        }
    }

    // Обработка нажатия кнопки "Back"
    override fun onBackPressed() {
        super.onBackPressed()
        // Показываем диалоговое окно с подтверждением
        AlertDialog.Builder(this)
            .setMessage("Вы уверены, что хотите закрыть приложение?")
            .setPositiveButton("Да") { _, _ ->
                // Если пользователь выбрал "Да", закрываем приложение
                finishAffinity()
            }
            .setNegativeButton("Нет", null)
            .show()
    }


}