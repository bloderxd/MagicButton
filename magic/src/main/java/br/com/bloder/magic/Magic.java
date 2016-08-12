package br.com.bloder.magic;

import android.view.View;

import br.com.bloder.magic.internal.MagicAnimation;

/**
 * Created by bloder on 28/07/16.
 */
public class Magic {

  public void doWith(View button) {
    MagicAnimation animator = new MagicAnimation(button);
    animator.setDuration(200);
    button.startAnimation(animator);
  }
}
