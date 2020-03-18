package com.example.slots;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button Start;
    private Button Options;
    private Button Stop;
    private GridLayout grid;
    private Drawable wolf;
    private Drawable bunny;
    private Drawable goat;
    private Drawable fox;
    private Drawable nightsky;
    private Drawable eveningsky;
    private Drawable morningsky;
    private ImageView[] imageViews;
    private Random rand;
    private Handler handler;
    public Boolean on;
    public int count;
    public int slot1;
    public int slot2;
    public int slot3;
    public TextView Score;
    public SeekBar difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Start=findViewById(R.id.Start);
        Options=findViewById(R.id.Options);
        Stop=findViewById(R.id.Start);
        grid=findViewById(R.id.slots);
        Score=findViewById(R.id.Score);
        wolf=getDrawable(R.drawable.wolf100x100);


    }
}
