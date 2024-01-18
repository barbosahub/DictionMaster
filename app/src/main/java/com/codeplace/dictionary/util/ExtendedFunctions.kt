package com.codeplace.dictionary.util

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri

fun Context.playAudio(url: String?) {
    if (url != null){
        val mediaPlayer = MediaPlayer()
        mediaPlayer.setAudioAttributes(
            AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build()
        )

        mediaPlayer.setDataSource(this, Uri.parse(url))
        mediaPlayer.prepareAsync()
        mediaPlayer.setOnPreparedListener { mp ->
            mp.start()
        }
    }
}

