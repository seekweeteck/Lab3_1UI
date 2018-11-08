package com.example.kweetecksee.lab3_1ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    public static final String ITEM_TAG = "com.example.kweetecksee.lab3_1ui.ITEM";
    private String[] stringsItems = {"First", "Second", "Third"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ListView listView = findViewById(R.id.listViewItem);



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                stringsItems
        );

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        listView.setOnItemSelectedListener(this);
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String stringItem;
        stringItem = parent.getItemAtPosition(position).toString();
        Intent intent = new Intent();
        intent.putExtra(ITEM_TAG, stringItem);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent,
                               View view,
                               int position,
                               long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
