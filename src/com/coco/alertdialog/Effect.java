package com.coco.alertdialog;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

public class Effect {
    public enum EffectType {
        FadeIn, Fall, FlipH, FlipV, NewsPaper, RotateBottom, RotateLeft, Shake, SlideFall, SlideBottom, SlideLeft, SlideRight, SlideTop, Slit
    };

    private static final int DURATION = 1 * 700;

    protected long mDuration = DURATION;

    private AnimatorSet mAnimatorSet;

    {
        mAnimatorSet = new AnimatorSet();
    }

    public void setDuration(long duration) {
        this.mDuration = duration;
    }

    protected void setupAnimation(View view, EffectType type) {
        switch (type) {
        case FadeIn:
            mAnimatorSet.playTogether(ObjectAnimator.ofFloat(view, "alpha", 0, 1).setDuration(mDuration));
            break;
        case Fall:
            mAnimatorSet.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 2, 1.5f, 1).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view, "scaleY", 2, 1.5f, 1).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view, "alpha", 0, 1).setDuration(mDuration * 3 / 2)

            );
            break;
        case FlipH:
            mAnimatorSet.playTogether(ObjectAnimator.ofFloat(view, "rotationY", -90, 0).setDuration(mDuration));
            break;
        case FlipV:
            mAnimatorSet.playTogether(ObjectAnimator.ofFloat(view, "rotationX", -90, 0).setDuration(mDuration));
            break;
        case NewsPaper:
            mAnimatorSet.playTogether(ObjectAnimator.ofFloat(view, "rotation", 1080, 720, 360, 0)
                    .setDuration(mDuration),
                    ObjectAnimator.ofFloat(view, "alpha", 0, 1).setDuration(mDuration * 3 / 2),
                    ObjectAnimator.ofFloat(view, "scaleX", 0.1f, 0.5f, 1).setDuration(mDuration), ObjectAnimator
                            .ofFloat(view, "scaleY", 0.1f, 0.5f, 1).setDuration(mDuration));
            break;
        case RotateBottom:
            mAnimatorSet.playTogether(ObjectAnimator.ofFloat(view, "rotationX", 90, 0).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view, "translationY", 300, 0).setDuration(mDuration), ObjectAnimator
                            .ofFloat(view, "alpha", 0, 1).setDuration(mDuration * 3 / 2));
            break;
        case RotateLeft:
            mAnimatorSet.playTogether(ObjectAnimator.ofFloat(view, "rotationY", 90, 0).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view, "translationX", -300, 0).setDuration(mDuration), ObjectAnimator
                            .ofFloat(view, "alpha", 0, 1).setDuration(mDuration * 3 / 2));
            break;
        case Shake:
            mAnimatorSet.playTogether(ObjectAnimator.ofFloat(view, "translationX", 0, .10f, -25, .26f, 25, .42f, -25,
                    .58f, 25, .74f, -25, .90f, 1, 0).setDuration(mDuration));
            break;
        case SlideFall:
            mAnimatorSet.playTogether(ObjectAnimator.ofFloat(view, "scaleX", 2, 1.5f, 1).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view, "scaleY", 2, 1.5f, 1).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view, "rotation", 25, 0).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view, "translationX", 80, 0).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view, "alpha", 0, 1).setDuration(mDuration * 3 / 2));
            break;
        case SlideBottom:
            mAnimatorSet.playTogether(ObjectAnimator.ofFloat(view, "translationY", 300, 0).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view, "alpha", 0, 1).setDuration(mDuration * 3 / 2));
            break;
        case SlideLeft:
            mAnimatorSet.playTogether(ObjectAnimator.ofFloat(view, "translationX", -300, 0).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view, "alpha", 0, 1).setDuration(mDuration * 3 / 2));
            break;
        case SlideRight:
            mAnimatorSet.playTogether(ObjectAnimator.ofFloat(view, "translationX", 300, 0).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view, "alpha", 0, 1).setDuration(mDuration * 3 / 2));
            break;
        case SlideTop:
            mAnimatorSet.playTogether(ObjectAnimator.ofFloat(view, "translationY", -300, 0).setDuration(mDuration),
                    ObjectAnimator.ofFloat(view, "alpha", 0, 1).setDuration(mDuration * 3 / 2));
            break;
        case Slit:
            mAnimatorSet.playTogether(
                    ObjectAnimator.ofFloat(view, "rotationY", 90, 88, 88, 45, 0).setDuration(mDuration), ObjectAnimator
                            .ofFloat(view, "alpha", 0, 0.4f, 0.8f, 1).setDuration(mDuration * 3 / 2), ObjectAnimator
                            .ofFloat(view, "scaleX", 0, 0.5f, 0.9f, 0.9f, 1).setDuration(mDuration), ObjectAnimator
                            .ofFloat(view, "scaleY", 0, 0.5f, 0.9f, 0.9f, 1).setDuration(mDuration));
            break;
        }
        mAnimatorSet.start();
    };

}
