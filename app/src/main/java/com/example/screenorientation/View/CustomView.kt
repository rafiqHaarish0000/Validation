package com.example.screenorientation.View

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi


@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class CustomView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) :
    View(context, attrs, defStyleAttr, defStyleRes) {
    private lateinit var mPaint: Paint
    private var radius:Int = 100
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mPaint.color = Color.BLUE
        canvas!!.drawCircle(x,y, radius.toFloat(),mPaint)
    }

}