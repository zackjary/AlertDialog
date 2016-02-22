package com.coco.alertdialog;

import com.coco.alertdialog.Effect.EffectType;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EffectType effect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dialogShow(View v) {
        switch (v.getId()) {
        case R.id.fadein:
            effect = EffectType.FadeIn;
            break;
        case R.id.slideright:
            effect = EffectType.SlideRight;
            break;
        case R.id.slideleft:
            effect = EffectType.SlideLeft;
            break;
        case R.id.slidetop:
            effect = EffectType.SlideTop;
            break;
        case R.id.slideBottom:
            effect = EffectType.SlideBottom;
            break;
        case R.id.newspager:
            effect = EffectType.NewsPaper;
            break;
        case R.id.fall:
            effect = EffectType.Fall;
            break;
        case R.id.slidefall:
            effect = EffectType.SlideFall;
            break;
        case R.id.fliph:
            effect = EffectType.FlipH;
            break;
        case R.id.flipv:
            effect = EffectType.FlipV;
            break;
        case R.id.rotatebottom:
            effect = EffectType.RotateBottom;
            break;
        case R.id.rotateleft:
            effect = EffectType.RotateLeft;
            break;
        case R.id.slit:
            effect = EffectType.Slit;
            break;
        case R.id.shake:
            effect = EffectType.Shake;
            break;
        }

        new AlertDialog(this).setITitle("标题").setIButton1Text("确定").setIButton2Text("取消").setIMessage("内容...")
                .setIEffectAnimation(effect).setIIcon(R.drawable.ic_launcher).show();
    }
}
