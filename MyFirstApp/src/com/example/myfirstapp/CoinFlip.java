package com.example.myfirstapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

/** coin flip activity class **/
public class CoinFlip extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_flip);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.coin_flip, menu);
        return true;
    }
    
    public void flip(View view) {
        TextView v = (TextView) findViewById(R.id.flipVal);
        String retVal = CoinFlip.rand().toString();
        v.setText(retVal);
    }
    
    private static Integer rand() {
        if (Math.random() > .5 ) {
            return 1;
        }
        else  {
            return 0;
        }
    }
   

}
