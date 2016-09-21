package br.com.bloder.magic.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.bloder.magic.MagicKt;
import br.com.bloder.magic.R;

/**
 * Created by bloder on 28/07/16.
 */
public class MagicButton extends FrameLayout {


  private TextView text;
  private LinearLayout button;
  private LinearLayout buttonIcon;
  private ImageView icon;
  private Drawable drawable;
  private TypedArray typedArray;

  private String buttonText;
  private int expandableButtonColor;
  private int iconButtonColor;
  private int textColor;
  private OnClickListener onClickListener;

  public MagicButton(Context context) {
    super(context);
    initView(context);
  }

  public MagicButton(Context context, AttributeSet attrs) {
    super(context, attrs);
    typedArray = context.obtainStyledAttributes(attrs, R.styleable.MagicButton);
    if(typedArray != null) {
      buttonText = typedArray.getString(R.styleable.MagicButton_hide_text);
      expandableButtonColor = typedArray.getColor(R.styleable.MagicButton_expandable_area_color, Color.parseColor("#FFE6E4E4"));
      iconButtonColor = typedArray.getColor(R.styleable.MagicButton_icon_button_color, Color.parseColor("#FFE6E4E4"));
      textColor = typedArray.getColor(R.styleable.MagicButton_hide_text_color, Color.parseColor("#FFE6E4E4"));
      drawable = typedArray.getDrawable(R.styleable.MagicButton_button_icon);
    }
    initView(context);
  }

  public void setMagicButtonClickListener(OnClickListener onClickListener) {
    this.onClickListener = onClickListener;
  }

  private void initView(Context context) {
    LayoutInflater.from(context).inflate(R.layout.magic_button, this, true);
    button = (LinearLayout) findViewById(R.id.expandable_button);
    buttonIcon = (LinearLayout) findViewById(R.id.icon_button);
    text = (TextView) findViewById(R.id.btn_text);
    icon = (ImageView) findViewById(R.id.btn_icon);
    setButtonContent();
    baseAction();
  }

  private void setButtonContent() {
    if(drawable != null) {
      icon.setBackground(drawable);
    }
    ((GradientDrawable) button.getBackground()).setColor(expandableButtonColor);
    ((GradientDrawable) buttonIcon.getBackground()).setColor(iconButtonColor);
    text.setText(buttonText);
    text.setTextColor(textColor);
    setSizes();
  }

  private void setSizes() {
    button.getLayoutParams().width = (int) typedArray.getDimension(R.styleable.MagicButton_magic_button_size, 50);
    button.getLayoutParams().height = (int) typedArray.getDimension(R.styleable.MagicButton_magic_button_size, 50);
    buttonIcon.getLayoutParams().width = (int) typedArray.getDimension(R.styleable.MagicButton_magic_button_size, 50);
    buttonIcon.getLayoutParams().height = (int) typedArray.getDimension(R.styleable.MagicButton_magic_button_size, 50);
    icon.getLayoutParams().width = (int) typedArray.getDimension(R.styleable.MagicButton_button_icon_width, 25);
    icon.getLayoutParams().height = (int) typedArray.getDimension(R.styleable.MagicButton_button_icon_height, 25);
    text.setTextSize(typedArray.getDimension(R.styleable.MagicButton_hide_text_size , 15));
  }

  private void baseAction() {
    this.button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if(v.getWidth() == v.getHeight()) {
          text.setVisibility(VISIBLE);
        } else {
          text.setVisibility(GONE);
          if(onClickListener != null) onClickListener.onClick(button);
        }
        MagicKt.doWith(v);
      }
    });
  }
}
