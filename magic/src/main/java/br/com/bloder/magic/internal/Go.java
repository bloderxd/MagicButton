package br.com.bloder.magic.internal;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by bloder on 28/07/16.
 */
public class Go extends Animation {

  private int toWidth;
  private int startWidth;
  private View view;

  public Go(View view) {
    this.view = view;
    this.startWidth = this.view.getWidth();
    this.toWidth = startWidth == view.getHeight() ? startWidth * 4 : view.getHeight();
  }

  @Override
  protected void applyTransformation(float interpolatedTime, Transformation t) {
    final int newWidth = startWidth + (int) ((toWidth - startWidth) * interpolatedTime);
    view.getLayoutParams().width = newWidth;
    view.requestLayout();
  }
}
