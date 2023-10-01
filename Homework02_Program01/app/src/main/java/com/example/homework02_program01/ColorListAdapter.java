package com.example.homework02_program01;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ColorListAdapter extends BaseAdapter
{

    Context context;
    ArrayList<ColorInfo> listOfColors;


    public ColorListAdapter(Context c, ArrayList<ColorInfo> ls)
    {
        context = c;
        listOfColors = ls;

    }

    @Override
    public int getCount() {
        return listOfColors.size();
    }

    @Override
    public Object getItem(int i) {
        return listOfColors.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {

        if (view == null)
        {
            //  find the cell
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.custom_cell, null);
        }

        //  connect
        TextView red = view.findViewById(R.id.tv_v_c_red);
        TextView green = view.findViewById(R.id.tv_v_c_green);
        TextView blue = view.findViewById(R.id.tv_v_c_blue);
        TextView hex = view.findViewById(R.id.tv_v_c_hex);

        ColorInfo color = listOfColors.get(i);

        //  change text to their respecitve values
        red.setText("Red: " + color.getRed());
        green.setText("Green: " + color.getGreen());
        blue.setText("Blue: " + color.getBlue());
        hex.setText("Hex: " + color.getHex());

        //  change background with rgb values
        view.setBackgroundColor(Color.rgb(color.getRed(), color.getGreen(), color.getBlue()));
        if (color.getRed() + color.getGreen() + color.getBlue() <=225)
        {
            red.setTextColor(Color.rgb(255, 255, 255));
            green.setTextColor(Color.rgb(255, 255, 255));
            blue.setTextColor(Color.rgb(255, 255, 255));
            hex.setTextColor(Color.rgb(255, 255, 255));
        }
        else if (color.getRed() + color.getGreen() + color.getBlue() > 225)
        {
            red.setTextColor(Color.rgb(0,0,0));
            green.setTextColor(Color.rgb(0,0,0));
            blue.setTextColor(Color.rgb(0,0,0));
            hex.setTextColor(Color.rgb(0,0,0));
        }

        //  return
        return view;
    }
}
