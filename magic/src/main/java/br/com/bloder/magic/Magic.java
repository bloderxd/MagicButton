package br.com.bloder.magic;

import android.view.View;

import br.com.bloder.magic.internal.Back;
import br.com.bloder.magic.internal.Go;

/**
 * Created by bloder on 28/07/16.
 */
public class Magic {

  public void doWith(View button) {
    if(button.getWidth() == button.getHeight()) {
      Go animator = new Go(button);
      animator.setDuration(200);
      button.startAnimation(animator);
    } else {
      Back animator = new Back(button);
      animator.setDuration(200);
      button.startAnimation(animator);
    }
  }
}
