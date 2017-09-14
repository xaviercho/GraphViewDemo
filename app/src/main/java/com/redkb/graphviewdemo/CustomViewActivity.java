package com.redkb.graphviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;

import java.util.Random;

public class CustomViewActivity extends AppCompatActivity {

    GraphView2 mGraphView2;
    GraphView3 mGraphView3;
    GraphView4 mGraphView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);

        final EditText numberEditText = findViewById(R.id.numberPicker);
        mGraphView2 = findViewById(R.id.graphView2);
        Button generateButton = findViewById(R.id.generateButton);
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGraphView2.setData(getRandomData(Integer.valueOf(numberEditText.getText().toString())));
            }
        });

        final EditText numberEditText3 = findViewById(R.id.numberPicker3);
        mGraphView3 = findViewById(R.id.graphView3);
        Button generateButton3 = findViewById(R.id.generateButton3);
        generateButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGraphView3.setData(getRandomData(Integer.valueOf(numberEditText3.getText().toString())));
            }
        });

        final EditText numberEditText4 = findViewById(R.id.numberPicker4);
        mGraphView4 = findViewById(R.id.graphView4);
        Button generateButton4 = findViewById(R.id.generateButton4);
        generateButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGraphView4.setData(getRandomData(Integer.valueOf(numberEditText4.getText().toString())));
            }
        });

        TabHost host = findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Graph 1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Graph 1");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Graph 2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Graph 2");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Graph 3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Graph 3");
        host.addTab(spec);

        //Tab 4
        spec = host.newTabSpec("Graph 4");
        spec.setContent(R.id.tab4);
        spec.setIndicator("Graph 4");
        host.addTab(spec);
    }

    private float[] getRandomData(int dataSize) {
        float[] randomData = new float[dataSize];
        Random random = new Random();
        randomData[0] = 5 + random.nextFloat();
        for (int i = 1; i < randomData.length; i++) {
            randomData[i] = randomData[i - 1] + random.nextFloat() - .47f;
        }
        return randomData;
    }

}
