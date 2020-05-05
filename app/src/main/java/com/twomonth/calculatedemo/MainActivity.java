package com.twomonth.calculatedemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    NavController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = Navigation.findNavController(this,R.id.fragment_man);
        NavigationUI.setupActionBarWithNavController(this,controller);
    }

    @Override
    public boolean onSupportNavigateUp () {
        if (Objects.requireNonNull(controller.getCurrentDestination()).getId() == R.id.questionFragment){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("决定放弃吗？");
            builder.setCancelable(true);
            builder.setPositiveButton("放弃", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    controller.navigateUp();
                }
            });
            builder.setNegativeButton("继续", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }else {
            controller.navigate(R.id.titleFragment);
        }
        return super.onNavigateUp();
    }

    @Override
    public void onBackPressed() {
        if (controller.getCurrentDestination().getId() == R.id.titleFragment){
            ImageView imageView = findViewById(R.id.imageView_bye);
            imageView.setVisibility(View.VISIBLE);
            final AnimationDrawable animation = (AnimationDrawable) imageView.getBackground();
            animation.start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        animation.stop();
                        System.exit(-1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }else {
            onSupportNavigateUp();
        }
    }
}
