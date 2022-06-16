package com.example.testpersonalproject.UI.service

import android.app.Service
import android.content.Intent
import android.os.CountDownTimer
import android.os.IBinder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class TimerTest : Service() {

    private lateinit var countDownTimer: CountDownTimer
    private lateinit var coroutine : CoroutineScope

    companion object{

        const val GET_INTENT_SERVICE = "service"
        const val TAG_RECEIVER = "receiver"
    }

    private val receiverIntent = Intent()

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val minute = intent!!.getLongExtra(GET_INTENT_SERVICE, 0)
        myTimer(minute)
        return START_NOT_STICKY
    }

    private fun myTimer(minute: Long){
        coroutine.launch {
            countDownTimer = object : CountDownTimer(minute, 1000){
                override fun onTick(milisecond: Long) {
                    receiverIntent.putExtra(TAG_RECEIVER, milisecond)
                    sendBroadcast(receiverIntent)
                }

                override fun onFinish() {

                }
            }.start()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        countDownTimer.cancel()
    }

    override fun onBind(p0: Intent?): IBinder? = null
}