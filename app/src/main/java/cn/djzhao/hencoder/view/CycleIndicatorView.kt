package cn.djzhao.hencoder.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import cn.djzhao.hencoder.utils.ScreenUtils.Companion.dpToPixel

class CycleIndicatorView : View {

    val radius = dpToPixel(80f)
    val arcRectF = RectF()
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var progress: Float = 0.0f

    fun setProgress(progress: Float) {
        this.progress = progress
        invalidate()
    }

    fun getProgress() : Float {
        return progress
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        context, attributeSet, defStyleAttr
    )

    init {
        paint.textSize = dpToPixel(40f)
        paint.textAlign = Paint.Align.CENTER
    }

    override fun onDraw(canvas: Canvas?) {
        val centX = width / 2f
        val centY = height / 2f
        paint.color = Color.parseColor("#E91E63")
        paint.style = Paint.Style.STROKE
        paint.strokeCap = Paint.Cap.ROUND
        paint.strokeWidth = dpToPixel(15f)
        arcRectF.set(centX - radius, centY - radius, centX + radius, centY + radius)
        if (progress > 100) {
            canvas?.drawArc(arcRectF, 135f, 270f, false, paint)
            paint.color = Color.RED
            canvas?.drawArc(arcRectF, 45f, (progress - 100f) * 2.7f, false, paint)
        } else {
            canvas?.drawArc(arcRectF, 135f, progress * 2.7f, false, paint)
        }

        paint.setColor(Color.BLUE)
        paint.style=Paint.Style.FILL
        canvas?.drawText(
            "${progress.toInt()}%",
            centX,
            centY - (paint.ascent() + paint.descent()) / 2,
            paint
        )
    }
}