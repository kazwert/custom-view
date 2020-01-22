package com.stereorun.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.stereorun.customview.custom.State
import kotlinx.android.synthetic.main.activity_main.twsv

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        twsv.text.text = "Upload profile picture"

        twsv.setState(State.LOADING)
// We simulate a running task
        Handler().postDelayed({
            twsv.setState(State.DONE)
        }, 10000)
    }
}
