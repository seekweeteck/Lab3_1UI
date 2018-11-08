package com.example.kweetecksee.lab3_1ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_ITEM = 1;
    TextView textViewMessage;
    private float size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewMessage = findViewById(R.id.textViewMessage);
        size = textViewMessage.getTextSize()/ getResources().getDisplayMetrics().scaledDensity;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivityForResult(intent, REQUEST_ITEM);
                //startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_ITEM){
            if(resultCode == RESULT_OK){
                String stringItem;

                stringItem = data.getStringExtra(SecondActivity.ITEM_TAG);
                textViewMessage.setText(stringItem);
            }
        }else if(requestCode == 2){
            if(resultCode == RESULT_CANCELED){

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if(id == R.id.action_increase){
            increaseFontSize();
        }else if(id == R.id.action_decrease){
            decreaseFontSize();
        }

        return super.onOptionsItemSelected(item);
    }

    private void decreaseFontSize() {
        size--;
        textViewMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP,size);
    }

    private void increaseFontSize() {
        size++;
        textViewMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP,size);
    }
}
