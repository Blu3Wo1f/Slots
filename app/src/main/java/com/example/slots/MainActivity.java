package com.example.slots;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button Start;
    private Button Options;
    private Button Stop;
    private GridLayout grid;
    private Drawable wolf,bunny,goat,fox;
    private ConstraintLayout bg;
    private Drawable night,evening,morning;
    private ImageView[] imageViews;
    private Random rand;
    private Handler handler;
    public Boolean on;
    public int count,slot1,slot2,slot3;
    private Spin1 spin1;
    private Spin2 spin2;
    private Spin3 spin3;
    public TextView Score;
    public SeekBar difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Start=findViewById(R.id.Start);
        night=getDrawable(R.drawable.night);
        morning=getDrawable(R.drawable.morning);
        evening=getDrawable(R.drawable.evening);
        Options=findViewById(R.id.Options);
        Stop=findViewById(R.id.Goal);
        grid=findViewById(R.id.slots);
        Score=findViewById(R.id.Score);
        wolf=getDrawable(R.drawable.wolf100x100);
        fox=getDrawable(R.drawable.fox);
        goat=getDrawable(R.drawable.goat);
        bunny=getDrawable(R.drawable.bunny);
        difficulty=findViewById(R.id.difficulty);
        imageViews=new ImageView[3];
        handler =new Handler();
        on= false;
        rand=new Random();
        count=0;
        slot1 = rand.nextInt(4);
        slot2 =rand.nextInt(4);
        slot3=rand.nextInt(4);
        spin1=new Spin1();
        spin2=new Spin2();
        spin3= new Spin3();

        for(int i=0 ;i<3;i++){
            imageViews[i]= (ImageView) getLayoutInflater().inflate(R.layout.slot_view, null);
            imageViews[i].setMinimumWidth(270);
            imageViews[i].setMinimumHeight(270);
            grid.addView(imageViews[i]);
        }

    }
    public void ChangeBg(View v){
        Intent i=new Intent(this,help.class);
        startActivityForResult(i,1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        int image = data.getIntExtra("IMAGE",1);
        if(image == 1){
            bg.setBackground(morning);
        }
        else if(image== 2){
            bg.setBackground(evening);
        }
        else if(image==3){
            bg.setBackground(night);
        }
        else{
            bg.setBackground(null);
        }
    }
    public void GoalPress(){
        Intent i= new Intent(this,HelpActivity.class);
        startActivity(i);
    }
    public void StartPressed(View v){
        if(on){
            on=false;
            Start.setText("Start");
            handler.removeCallbacks(spin1);
            handler.removeCallbacks(spin2);
            handler.removeCallbacks(spin3);
        }else{
            on=true;
            Stop.setText("Stop");
            handler.postDelayed(spin1, 6000+difficulty.getProgress()*1000);
            handler.postDelayed(spin2,9000+difficulty.getProgress()*1000);
            handler.postDelayed(spin3,3000+difficulty.getProgress()*1000);
        }
    }
    private class Spin1 implements Runnable{
        @Override
        public void run(){
            if(slot1==0)imageViews[0].setImageDrawable(wolf);
            else if(slot1==1)imageViews[0].setImageDrawable(goat);
            else if(slot1==2)imageViews[0].setImageDrawable(bunny);
            else imageViews[0].setImageDrawable(fox);
            slot1=rand.nextInt(4);
            handler.postDelayed(spin1, 2000+difficulty.getProgress()*1000);
        }
    }

    private class Spin2 implements Runnable{
        @Override
        public void run(){
            if(slot2==0)imageViews[1].setImageDrawable(wolf);
            else if(slot2==1)imageViews[1].setImageDrawable(goat);
            else if(slot2==2)imageViews[1].setImageDrawable(bunny);
            else imageViews[1].setImageDrawable(fox);
            slot2=rand.nextInt(4);
            handler.postDelayed(spin2, 2000+difficulty.getProgress()*1000);
        }
    }
    private class Spin3 implements Runnable{
        @Override
        public void run(){
            if(slot3==0){
                imageViews[2].setImageDrawable(wolf);
                slot3=rand.nextInt(4);
                handler.postDelayed(spin3, 2000+difficulty.getProgress()*1000);
            }
            else if(slot3==1){
                imageViews[2].setImageDrawable(goat);
                slot3=rand.nextInt(4);
                handler.postDelayed(spin3, 2000+difficulty.getProgress()*1000);
            }
            else if(slot3==2){
                imageViews[2].setImageDrawable(bunny);
                slot3=rand.nextInt(4);
                handler.postDelayed(spin3, 2000+difficulty.getProgress()*1000);
            }
            else {
                imageViews[2].setImageDrawable(fox);
                slot3 = rand.nextInt(4);
                handler.postDelayed(spin3, 2000+difficulty.getProgress()*1000);
            }

        }
    }
}
