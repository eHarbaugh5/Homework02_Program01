package com.example.homework02_program01;

import android.app.Activity;
import android.content.Context;
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
    ArrayList<Color> listOfColors;


    public ColorListAdapter(Context c, ArrayList<Color> ls)
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

        Color color = listOfColors.get(i);


        red.setText("Red: " + color.getRed());
        green.setText("Green: " + color.getGreen());
        blue.setText("Blue: " + color.getBlue());



        //  return
        return view;
    }
}
