package com.example.homework02_program01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

import android.graphics.Color;
import android.os.Bundle;
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
    TextView tv_j_hex;
    SeekBar sb_j_redBar;
    SeekBar sb_j_greenBar;
    SeekBar sb_j_blueBar;
    Button btn_j_saveColor;
    ListView lv_j_listOfColors;
    ArrayList<ColorInfo> listOfColors;
    ColorListAdapter adapter;

    View v_v_view;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_j_red = findViewById(R.id.tv_v_red);
        tv_j_green = findViewById(R.id.tv_v_green);
        tv_j_blue = findViewById(R.id.tv_v_blue);
        tv_j_hex = findViewById(R.id.tv_v_hexRepresentation);

        sb_j_redBar = findViewById(R.id.sb_v_redBar);
        sb_j_greenBar = findViewById(R.id.sb_v_greenBar);
        sb_j_blueBar = findViewById(R.id.sb_v_blueBar);

        btn_j_saveColor = findViewById(R.id.btn_v_saveColor);
        lv_j_listOfColors = findViewById(R.id.lv_v_listOfColors);

        v_v_view = findViewById(R.id.v_v_view);

        listOfColors = new ArrayList<ColorInfo>();


        updateSeekBarHandler();
        buttonClickEventHandler();
        fillListView();




    }

    public void addColor()
    {
        String newHex = convertToHex(sb_j_redBar.getProgress(), sb_j_greenBar.getProgress(), sb_j_blueBar.getProgress());
        ColorInfo newColor = new ColorInfo(sb_j_redBar.getProgress(), sb_j_greenBar.getProgress(), sb_j_blueBar.getProgress(), newHex);
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
        //  update when red seek bar moves
        sb_j_redBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                //  changes background and the hex representation
                updateBackgroundAndHex();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb_j_greenBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
               updateBackgroundAndHex();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sb_j_blueBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                updateBackgroundAndHex();
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

    public String convertToHex(int r, int g, int b)
    {

        double rgbToHex;
        char hexDigit;
        String hex = "";

        rgbToHex = r;

        hexDigit = (char)((int) rgbToHex / 16);
        if (hexDigit > 9)
        {
            hexDigit += 7;
        }
        hexDigit += 48;
        hex = hex + hexDigit;

        rgbToHex = ((rgbToHex / 16) - (int) rgbToHex / 16) * 16;
        hexDigit = (char)rgbToHex;
        if (hexDigit > 9)
        {
            hexDigit += 7;
        }
        hexDigit += 48;
        hex = hex + hexDigit;

        rgbToHex = g;

        hexDigit = (char)((int) rgbToHex / 16);
        if (hexDigit > 9)
        {
            hexDigit += 7;
        }
        hexDigit += 48;
        hex = hex + hexDigit;

        rgbToHex = ((rgbToHex / 16) - (int) rgbToHex / 16) * 16;
        hexDigit = (char)rgbToHex;
        if (hexDigit > 9)
        {
            hexDigit += 7;
        }
        hexDigit += 48;
        hex = hex + hexDigit;

        rgbToHex = b;

        hexDigit = (char)((int) rgbToHex / 16);
        if (hexDigit > 9)
        {
            hexDigit += 7;
        }
        hexDigit += 48;
        hex = hex + hexDigit;

        rgbToHex = ((rgbToHex / 16) - (int) rgbToHex / 16) * 16;
        hexDigit = (char)rgbToHex;
        if (hexDigit > 9)
        {
            hexDigit += 7;
        }
        hexDigit += 48;
        hex = hex + hexDigit;
        return hex;

    }

    public void updateBackgroundAndHex()
    {

        v_v_view.setBackgroundColor(Color.rgb(sb_j_redBar.getProgress(), sb_j_greenBar.getProgress(), sb_j_blueBar.getProgress()));
        tv_j_hex.setText("Hex Representation: " + convertToHex(sb_j_redBar.getProgress(), sb_j_greenBar.getProgress(), sb_j_blueBar.getProgress()));

    }
    //  Bottom

}

