package br.com.bloder.magic.internal

import android.view.View
import android.view.animation.Animation
import android.view.animation.Transformation

/**
 * Created by bloder on 20/09/16.
 */
class MagicAnimation(view : View) : Animation() {

    private var view : View? = view
    private val startWidth : Int = view.width
    private val toWidth : Int = if (startWidth == view.height) startWidth * 4 else view.height

    override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
        val newWidth : Int = startWidth + ((toWidth - startWidth) * interpolatedTime).toInt()
        view?.layoutParams?.width = newWidth
        view?.requestLayout()
    }
}