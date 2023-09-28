package com.example.homework02_program01;

import android.util.Log;

public class ColorInfo
{

    private int red;
    private int green;
    private int blue;
    private String hex = "";
    private double rgbToHex;
    private char hexDigit;

    public ColorInfo()
    {

    }

    public ColorInfo(int r, int g, int b, String h)
    {
        red = r;
        green = g;
        blue = b;
        hex = h;
    }


    public int getRed() {
        return red;
    }

    public void setRed(int r) {
        red = r;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int g) {
        green = g;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int b) {
        blue = b;
    }

    public String getHex()
    {
        return hex;
    }


}
