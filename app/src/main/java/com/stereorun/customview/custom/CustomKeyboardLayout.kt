package com.stereorun.customview.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.widget.EditText
import android.widget.FrameLayout
import com.stereorun.customview.R
import kotlinx.android.synthetic.main.custom_keyboard_layout.view.tvKey0
import kotlinx.android.synthetic.main.custom_keyboard_layout.view.tvKey1
import kotlinx.android.synthetic.main.custom_keyboard_layout.view.tvKey2
import kotlinx.android.synthetic.main.custom_keyboard_layout.view.tvKey3
import kotlinx.android.synthetic.main.custom_keyboard_layout.view.tvKey4
import kotlinx.android.synthetic.main.custom_keyboard_layout.view.tvKey5
import kotlinx.android.synthetic.main.custom_keyboard_layout.view.tvKey6
import kotlinx.android.synthetic.main.custom_keyboard_layout.view.tvKey7
import kotlinx.android.synthetic.main.custom_keyboard_layout.view.tvKey8
import kotlinx.android.synthetic.main.custom_keyboard_layout.view.tvKey9
import kotlinx.android.synthetic.main.custom_keyboard_layout.view.tvKeyBackspace

class CustomKeyboardLayout : FrameLayout, OnClickListener {

    var editText: EditText? = null

    fun setWatcherEditText(editText: EditText) {
        this.editText = editText
    }

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    private fun init(context: Context) {
        val view = LayoutInflater.from(context).inflate(R.layout.custom_keyboard_layout, this, true)
        bindView(view)
    }

    private fun bindView(view: View) {
        view.tvKey1.setOnClickListener(this)
        view.tvKey2.setOnClickListener(this)
        view.tvKey3.setOnClickListener(this)
        view.tvKey4.setOnClickListener(this)
        view.tvKey5.setOnClickListener(this)
        view.tvKey6.setOnClickListener(this)
        view.tvKey7.setOnClickListener(this)
        view.tvKey8.setOnClickListener(this)
        view.tvKey9.setOnClickListener(this)
        view.tvKey0.setOnClickListener(this)
        view.tvKeyBackspace.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        editText?.let {
            when (view?.id) {
                R.id.tvKey1 -> it.append("1")
                R.id.tvKey2 -> it.append("2")
                R.id.tvKey3 -> it.append("3")
                R.id.tvKey4 -> it.append("4")
                R.id.tvKey5 -> it.append("5")
                R.id.tvKey6 -> it.append("6")
                R.id.tvKey7 -> it.append("7")
                R.id.tvKey8 -> it.append("8")
                R.id.tvKey9 -> it.append("9")
                R.id.tvKey0 -> it.append("0")
                R.id.tvKeyBackspace -> {
                    val pinString = it.text.toString()
                    if (pinString.isNotEmpty()) {
                        val newPinString = StringBuilder(pinString)
                            .deleteCharAt(pinString.length - 1).toString()
                        it.setText(newPinString)
                    }
                }
                else -> {
                }
            }
        }
    }
}