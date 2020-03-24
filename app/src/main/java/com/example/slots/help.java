package com.example.slots;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class help extends AppCompatActivity {
    private RadioButton morning;
    private RadioButton evening;
    private RadioButton night;
    private Button Goal;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_view);

        Goal=findViewById(R.id.help);
        morning=findViewById(R.id.morning);
        evening=findViewById(R.id.evening);
        night=findViewById(R.id.night);
    }

    public void GoalPress(){
        Intent i= new Intent(this,goal.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed(){
        int image;
        if(morning.isChecked())
            image=1;
        else if(evening.isChecked())
            image=2;
        else if(night.isChecked())
            image=3;
        else
            image=0;
        Intent i = new Intent();
        i.putExtra("IMAGE",image);
        setResult(RESULT_OK,i);
        finish();

    }
}
