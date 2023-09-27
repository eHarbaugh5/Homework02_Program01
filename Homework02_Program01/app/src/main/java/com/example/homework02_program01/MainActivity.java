package com.example.homework02_program01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tv_j_red;
    TextView tv_j_green;
    TextView tv_j_blue;
    SeekBar sb_j_redBar;
    SeekBar sb_j_greenBar;
    SeekBar sb_j_blueBar;
    Button btn_j_saveColor;
    ListView lv_j_listOfColors;
    ArrayList<ColorInfo> listOfColors;
    ColorListAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_j_red = findViewById(R.id.tv_v_red);
        tv_j_green = findViewById(R.id.tv_v_green);
        tv_j_blue = findViewById(R.id.tv_v_blue);

        sb_j_redBar = findViewById(R.id.sb_v_redBar);
        sb_j_greenBar = findViewById(R.id.sb_v_greenBar);
        sb_j_blueBar = findViewById(R.id.sb_v_blueBar);

        btn_j_saveColor = findViewById(R.id.btn_v_saveColor);
        lv_j_listOfColors = findViewById(R.id.lv_v_listOfColors);

        listOfColors = new ArrayList<ColorInfo>();

        updateSeekBarHandler();
        buttonClickEventHandler();
        fillListView();

    }

    public void addColor()
    {
        ColorInfo newColor = new ColorInfo(sb_j_redBar.getProgress(), sb_j_greenBar.getProgress(), sb_j_blueBar.getProgress());
        listOfColors.add(newColor);

    }

    public void buttonClickEventHandler()
    {

        btn_j_saveColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                addColor();
                adapter.notifyDataSetChanged();

            }
        });

    }

    public void updateSeekBarHandler()
    {

        sb_j_redBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {

                //Log.d("SeekBar Changed", sb_j_redBar.getProgress() + "");
                //  update background color


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void fillListView()
    {

        adapter = new ColorListAdapter(this, listOfColors);
        lv_j_listOfColors.setAdapter(adapter);



    }

    //  Bottom

}

