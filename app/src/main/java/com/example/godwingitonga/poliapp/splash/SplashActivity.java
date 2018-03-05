package com.example.godwingitonga.poliapp.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.example.godwingitonga.poliapp.R;
import com.example.godwingitonga.poliapp.home.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by godwingitonga on 04/03/2018.
 */

public class SplashActivity extends AppCompatActivity {
    @BindView(R.id.imageView) ImageView logo;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.splash_main);
            ButterKnife.bind(this);

            Animation fadeIn = new AlphaAnimation(0, 1);
            fadeIn.setInterpolator(new DecelerateInterpolator());
            fadeIn.setDuration(2000);

            Animation fadeOut = new AlphaAnimation(1, 0);
            fadeOut.setInterpolator(new AccelerateInterpolator());
            fadeOut.setStartOffset(2000);
            fadeOut.setDuration(2000);

            AnimationSet animation = new AnimationSet(false);
            animation.addAnimation(fadeIn);
            animation.addAnimation(fadeOut);

            logo.startAnimation(animation);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    Intent newActivity = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(newActivity);
                    finish();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }
}
