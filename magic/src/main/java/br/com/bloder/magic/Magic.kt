package br.com.bloder.magic

import android.view.View
import br.com.bloder.magic.internal.MagicAnimation

/**
 * Created by bloder on 20/09/16.
 */
fun doWith(view : View) {
    var animation : MagicAnimation
    animation = MagicAnimation(view)
    animation.duration = 200
    view.startAnimation(animation)
}