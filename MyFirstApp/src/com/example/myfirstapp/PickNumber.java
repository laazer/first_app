package com.example.myfirstapp;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class PickNumber extends Activity {

    private int range;
    private int prev;

    static private String warm ="Warm";
    static private String warmer ="Warmer";
    static private String burn ="Burning Up";
    static private String room = "Room Temp";
    static private String cold = "Cold";
    static private String colder ="Colder";
    static private String ice = "Ice Age";
    static private String correct = "Correct";

    private String temp;

    PickNumber() {
        range = 10;
        prev = range/2;
        temp = room;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_number);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pick_number, menu);
        return true;
    }

    /** choose a range **/
    public void chooseRange(View view) {
        this.range = R.id.range_select;
    }

    public void guess(View view) {
        int guess = R.id.num_pick;
        this.setTemp(guess);
        TextView heat = (TextView) findViewById(R.id.heat);
        heat.setText(temp);
        this.setColor();
        prev = guess;
    }

    /** sets the this temp **/
    private void setTemp(int guess) {
        if(guess == range) {
            temp = correct;
        }
        if(guess > range && guess > prev) {
            temp = colder;
        }
        if(guess > range && guess < prev) {
            temp = warm;
        }
        if(guess < range && guess < prev) {
            temp = colder;
        }
        if(guess < range && guess > prev) {
            temp = warmer;
        }
    }

    /** sets text color to match  temp **/
    private void setColor() {
        TextView heat = (TextView) findViewById(R.id.heat);
        if(this.temp.equals(correct)) {
            heat.setTextColor(Color.GREEN);
        }
        if(this.temp.equals(colder)) {
            heat.setTextColor(Color.BLUE);
        }
        if(this.temp.equals(warm)) {
            heat.setTextColor(Color.rgb(100, 50, 0));
        }
        if(this.temp.equals(warmer)) {
            heat.setTextColor(Color.RED);
        }
    }

}
