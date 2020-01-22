package com.stereorun.customview.custom

import android.content.Context
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.stereorun.customview.R

class TextWithStateView : LinearLayout {

    lateinit var text: TextView
    lateinit var progress: ProgressBar
    lateinit var image: ImageView

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
        val view = LayoutInflater.from(context).inflate(R.layout.layout_text_view_with_loading, this, true)
        text = view.findViewById(R.id.tvTextLoading)
        progress = view.findViewById(R.id.pbTextLoading)
        image = view.findViewById(R.id.imgTextLoading)
    }

    fun setText(text: String) {
        this.text.text = text
    }

    fun setState(state: State) {
        when (state) {
            State.DISABLED -> {
                image.setImageDrawable(resources.getDrawable(R.drawable.ic_cloud_upload_black_24dp))
                image.visibility = View.VISIBLE
                progress.visibility = View.GONE
                text.setTextColor(resources.getColor(R.color.colorPrimary))
            }
            State.LOADING -> {
                image.visibility = View.GONE
                progress.visibility = View.VISIBLE
                this.progress.indeterminateDrawable.setColorFilter(resources.getColor(R.color.colorPrimaryDark), PorterDuff.Mode.MULTIPLY)
                text.setTextColor(resources.getColor(R.color.colorPrimary))
            }
            State.DONE -> {
                image.setImageDrawable(resources.getDrawable(R.drawable.ic_check_black_24dp))
                image.visibility = View.VISIBLE
                progress.visibility = View.GONE
                text.setTextColor(resources.getColor(R.color.colorPrimary))
            }
            State.FAILED -> {
                image.setImageDrawable(resources.getDrawable(R.drawable.ic_clear_black_24dp))
                image.visibility = View.VISIBLE
                progress.visibility = View.GONE
                text.setTextColor(resources.getColor(R.color.colorAccent))
            }
        }
    }
}