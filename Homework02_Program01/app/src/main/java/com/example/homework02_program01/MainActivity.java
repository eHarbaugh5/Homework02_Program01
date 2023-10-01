package com.example.homework02_program01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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

        //  make connections
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

        //  dynamic color storage
        listOfColors = new ArrayList<ColorInfo>();

        //  call all functions as necessary

        //  giving this 255x3 starts the program on the color white
        updateBackgroundAndHex(255, 255, 255);
        updateSeekBarHandler();
        buttonClickEventHandler();
        listViewClickEventHandler();
        fillListView();

    }

    //  creates a new Color and adds it to the listOfColors
    public void addColor()
    {
        String newHex = convertToHex(sb_j_redBar.getProgress(), sb_j_greenBar.getProgress(), sb_j_blueBar.getProgress());
        ColorInfo newColor = new ColorInfo(sb_j_redBar.getProgress(), sb_j_greenBar.getProgress(), sb_j_blueBar.getProgress(), newHex);
        listOfColors.add(newColor);

    }

    //  calls addColor, notifies the adapter of changes, and resets to white
    public void buttonClickEventHandler()
    {

        btn_j_saveColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                addColor();
                adapter.notifyDataSetChanged();
                updateBackgroundAndHex(255,255,255);

            }
        });

    }

    //  get the values from listOfColors at the list views i, and updates to that color
    public void listViewClickEventHandler()
    {

        lv_j_listOfColors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                updateBackgroundAndHex(listOfColors.get(i).getRed(), listOfColors.get(i).getGreen(), listOfColors.get(i).getBlue());
            }
        });


    }

    //  for all 3 seekbars, just updates based on each seekbars progress
    public void updateSeekBarHandler()
    {
        //  update when red seek bar moves
        sb_j_redBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                //  changes background and the hex representation
                updateBackgroundAndHex(sb_j_redBar.getProgress(), sb_j_greenBar.getProgress(), sb_j_blueBar.getProgress());
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
               updateBackgroundAndHex(sb_j_redBar.getProgress(), sb_j_greenBar.getProgress(), sb_j_blueBar.getProgress());
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
                updateBackgroundAndHex(sb_j_redBar.getProgress(), sb_j_greenBar.getProgress(), sb_j_blueBar.getProgress());
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

    //  converts rgb to hex and returns the hex in a string
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

    //  this takes rgb and updates: seekbar progress, background color, text values, and black or white text
    public void updateBackgroundAndHex(int r, int g, int b)
    {

        tv_j_red.setText("Red: " + r);
        tv_j_green.setText("Green: " + g);
        tv_j_blue.setText("Blue: " + b);
        sb_j_redBar.setProgress(r);
        sb_j_greenBar.setProgress(g);
        sb_j_blueBar.setProgress(b);

        v_v_view.setBackgroundColor(Color.rgb(r, g, b));
        tv_j_hex.setText("Hex Representation: " + convertToHex(r, g, b));

        if (r + g + b <=225)
        {
            tv_j_red.setTextColor(Color.rgb(255, 255, 255));
            tv_j_green.setTextColor(Color.rgb(255, 255, 255));
            tv_j_blue.setTextColor(Color.rgb(255, 255, 255));
            tv_j_hex.setTextColor(Color.rgb(255, 255, 255));
        }
        else if (r + g + b > 225)
        {
            tv_j_red.setTextColor(Color.rgb(0,0,0));
            tv_j_green.setTextColor(Color.rgb(0,0,0));
            tv_j_blue.setTextColor(Color.rgb(0,0,0));
            tv_j_hex.setTextColor(Color.rgb(0,0,0));

        }

    }
    //  Bottom

}

