package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startAnimation = findViewById(R.id.start_animation);

        startAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = new TranslateAnimation(-1400f, 200f, 0, 0);
                animation.setFillAfter(true);
                animation.setRepeatMode(2);
                animation.setDuration(1000);

                Animation animation2 = new TranslateAnimation(200f, -200f, 0, 0);
                animation2.setFillAfter(true);
                animation2.setStartOffset(1000);
                animation2.setDuration(500);

                Animation animation3 = new RotateAnimation(0, -1.5f, Animation.RELATIVE_TO_SELF, -1.2f, Animation.RELATIVE_TO_SELF, 0.1f);
                animation3.setFillAfter(true);
                animation3.setDuration(500);
                animation3.setStartOffset(300);

                AnimationSet logoAnimationSet = new AnimationSet(true);
                logoAnimationSet.addAnimation(animation);
                logoAnimationSet.addAnimation(animation2);
                logoAnimationSet.addAnimation(animation3);

                TextView logo = findViewById(R.id.logo);

                logo.startAnimation(logoAnimationSet);

                logoAnimationSet.setAnimationListener(new Animation.AnimationListener() {
                    TextView bLetter = findViewById(R.id.b_letter);

                    @Override
                    public void onAnimationStart(Animation animation) {
                      bLetter.setAlpha(0f);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Animation alpha = new AlphaAnimation(0, 1);
                        alpha.setFillAfter(true);
                        alpha.setDuration(1000);

                        Animation scale = new ScaleAnimation(1, 1.05f, 1, 1.05f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, .5f);
                        scale.setFillAfter(true);
                        scale.setDuration(500);
                        scale.setStartOffset(900);
                        scale.setRepeatCount(Animation.INFINITE);

                        AnimationSet bLetterSet = new AnimationSet(true);
                        bLetterSet.addAnimation(alpha);
                        bLetterSet.addAnimation(scale);

                        bLetter.startAnimation(bLetterSet);
                        bLetter.setAlpha(1f);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });



            }
        });
    }
}
