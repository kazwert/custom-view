package com.stereorun.customview.custom

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.stereorun.customview.R

class EllipseView : AppCompatTextView {

    private var strokeColor: Int = 0

    private var strokeWidth: Int = 0

    private var backgroundColor: Int = 0

    private var cornerRadius: Int = 0

    private var isDisable: Boolean = false

    private var drawable: GradientDrawable? = null

    private var isEnable = true

    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(attrs)
    }

    fun init(attrs: AttributeSet?) {
        parseAttrs(attrs)
        drawable = GradientDrawable()
        drawable!!.shape = GradientDrawable.RECTANGLE
        drawable!!.setStroke(strokeWidth, strokeColor)
        drawable!!.cornerRadius = cornerRadius.toFloat()
        drawable!!.setColor(if (isEnable) backgroundColor else resources.getColor(android.R.color.darker_gray))
        background = drawable
        setDisableEllipseView(isDisable)
    }

    private fun parseAttrs(attrs: AttributeSet?) {
        if (attrs != null) {
            val typedArray = context
                .obtainStyledAttributes(attrs, R.styleable.EllipseView)
            try {
                strokeColor = typedArray.getColor(
                    R.styleable.EllipseView_ellipse_stroke_color,
                    resources.getColor(R.color.colorWhite)
                )
                strokeWidth = typedArray.getDimensionPixelSize(R.styleable.EllipseView_ellipse_stroke_width, 0)
                backgroundColor = typedArray
                    .getColor(
                        R.styleable.EllipseView_ellipse_background_color,
                        resources.getColor(R.color.colorWhite)
                    )
                cornerRadius = typedArray.getDimensionPixelSize(R.styleable.EllipseView_ellipse_corner_radius, 0)
                isDisable = typedArray.getBoolean(R.styleable.EllipseView_ellipse_disable, false)
            } finally {
                typedArray.recycle()
            }
        }
    }

    override fun setBackgroundColor(color: Int) {
        drawable!!.setColor(color)
    }

    fun setDisableEllipseView(isDisable: Boolean) {
        this.isDisable = isDisable
        setBackgroundColor(if (isDisable) resources.getColor(android.R.color.darker_gray) else backgroundColor)
        isEnabled = !isDisable
    }

    fun setEnabledEllipseView(isEnable: Boolean) {
        isEnabled = isEnable
        setBackgroundColor(if (isEnable) backgroundColor else resources.getColor(android.R.color.darker_gray))
        this.isEnable = isEnable
    }
}
