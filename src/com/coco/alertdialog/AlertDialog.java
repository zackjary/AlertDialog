package com.coco.alertdialog;

import com.coco.alertdialog.Effect.EffectType;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AlertDialog extends Dialog implements DialogInterface {
    private static final int DURATION = 1 * 700;
    private int mDuration = DURATION;

    private LinearLayout mLinearLayoutView;

    private RelativeLayout mRelativeLayoutView;

    private LinearLayout mLinearLayoutMsgView;

    private LinearLayout mLinearLayoutTopView;

    private FrameLayout mFrameLayoutCustomView;

    private View mDialogView;

    private View mDivider;

    private TextView mTitle;

    private TextView mMessage;

    private ImageView mIcon;

    private Button mButton1;

    private Button mButton2;

    private Effect mEffectAnim = new Effect();
    private EffectType mEffectType = EffectType.FadeIn;

    private boolean isCancelable = true;

    public AlertDialog(Context context) {
        this(context, R.style.dialog_untran);
    }

    public AlertDialog(Context context, int theme) {
        super(context, theme);
        init(context);
    }

    private void init(Context context) {
        mDialogView = View.inflate(context, R.layout.dialog_layout, null);
        mLinearLayoutView = (LinearLayout) mDialogView.findViewById(R.id.parentPanel);
        mRelativeLayoutView = (RelativeLayout) mDialogView.findViewById(R.id.main);
        mLinearLayoutTopView = (LinearLayout) mDialogView.findViewById(R.id.topPanel);
        mLinearLayoutMsgView = (LinearLayout) mDialogView.findViewById(R.id.contentPanel);
        mFrameLayoutCustomView = (FrameLayout) mDialogView.findViewById(R.id.customPanel);

        mTitle = (TextView) mDialogView.findViewById(R.id.alertTitle);
        mMessage = (TextView) mDialogView.findViewById(R.id.message);
        mIcon = (ImageView) mDialogView.findViewById(R.id.icon);
        mDivider = mDialogView.findViewById(R.id.titleDivider);
        mButton1 = (Button) mDialogView.findViewById(R.id.button1);
        mButton2 = (Button) mDialogView.findViewById(R.id.button2);

        setContentView(mDialogView);

        this.setOnShowListener(new DialogInterface.OnShowListener() {

            @Override
            public void onShow(DialogInterface dialog) {
                mEffectAnim.setupAnimation(mRelativeLayoutView, mEffectType);
            }
        });

        mRelativeLayoutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isCancelable)
                    dismiss();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
    }

    public AlertDialog setIDividerColor(String colorString) {
        mDivider.setBackgroundColor(Color.parseColor(colorString));
        return this;
    }

    public AlertDialog setITitle(String title) {
        toggleView(mLinearLayoutTopView, title);
        mTitle.setText(title);
        return this;
    }

    public AlertDialog setITitle(int resid, int x) {
        toggleView(mLinearLayoutTopView, resid);
        mTitle.setText(resid);
        return this;
    }

    public AlertDialog setITitleColor(int color) {
        mTitle.setTextColor(color);
        return this;
    }

    public AlertDialog setIMessage(String msg) {
        toggleView(mLinearLayoutMsgView, msg);
        mMessage.setText(msg);
        return this;
    }

    public AlertDialog setIMessage(int resid) {
        toggleView(mLinearLayoutMsgView, resid);
        mMessage.setText(resid);
        return this;
    }

    public AlertDialog setIMessageColor(int color) {
        mMessage.setTextColor(color);
        return this;
    }

    public AlertDialog setIIcon(int resid) {
        mIcon.setImageResource(resid);
        return this;
    }

    public AlertDialog setIIcon(Drawable drawable) {
        mIcon.setImageDrawable(drawable);
        return this;
    }

    public AlertDialog setIDuration(int duration) {
        mDuration = duration;
        return this;
    }

    public AlertDialog setIButtonDrawable(int resid) {
        mButton1.setBackgroundResource(resid);
        mButton2.setBackgroundResource(resid);
        return this;
    }

    public AlertDialog setIButton1Text(CharSequence text) {
        mButton1.setVisibility(View.VISIBLE);
        mButton1.setText(text);
        return this;
    }

    public AlertDialog setIButton2Text(CharSequence text) {
        mButton2.setVisibility(View.VISIBLE);
        mButton2.setText(text);
        return this;
    }

    public AlertDialog setButton1Click(View.OnClickListener listener) {
        mButton1.setOnClickListener(listener);
        return this;
    }

    public AlertDialog setButton2Click(View.OnClickListener listener) {
        mButton2.setOnClickListener(listener);
        return this;
    }

    public AlertDialog setICustomView(View view) {
        if (mFrameLayoutCustomView.getChildCount() > 0) {
            mFrameLayoutCustomView.removeAllViews();
        }
        mFrameLayoutCustomView.addView(view);
        return this;
    }

    public AlertDialog setICustomView(int resid, Context context) {
        View view = View.inflate(context, resid, null);
        setICustomView(view);
        return this;
    }

    public AlertDialog isCancelableOnTouchOutside(boolean cancelable) {
        this.isCancelable = cancelable;
        this.isCancelableOnTouchOutside(cancelable);
        return this;
    }

    public AlertDialog isCancelable(boolean cancelable) {
        this.isCancelable = cancelable;
        this.isCancelable(cancelable);
        return this;
    }

    public AlertDialog setIEffectAnimation(EffectType type) {
        this.mEffectType = type;
        return this;
    }

    private void toggleView(View view, Object obj) {
        if (obj == null) {
            view.setVisibility(View.GONE);
        } else {
            view.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void dismiss() {
        mButton1.setVisibility(View.GONE);
        mButton2.setVisibility(View.GONE);
        super.dismiss();
    }
}
