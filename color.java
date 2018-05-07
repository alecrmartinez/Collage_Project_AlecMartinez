// Alec Martinez
// 11/1/17
// Picture program

import java.awt.*;
import java.util.*;
import java.util.List;

public class color
{
    public static void main(String[] args)
    {
        Picture p1 = new Picture("images\\snowman.jpg"); //Original
        Picture p2 = new Picture("images\\snowman.jpg"); //maxRed()
        Picture p3 = new Picture("images\\snowman.jpg"); //negate()
        Picture p4 = new Picture("images\\snowman.jpg"); //adjustBlue()
        Picture p5 = new Picture("images\\snowman.jpg"); //greyscale()
        Picture p6 = new Picture("images\\snowman.jpg"); //darken()
        Picture p7 = new Picture("images\\snowman.jpg"); //colorify()
        Picture p8 = new Picture("images\\snowman.jpg"); //swap2()
        Picture p9 = new Picture("images\\snowman.jpg"); //swap3()
        p1.explore();
        
        //Max Red
        Pixel[] pixel_arr;
        pixel_arr = p2.getPixels();
        for(Pixel spot : pixel_arr)
        {
            //Maxing out the red value for each pixel
            spot.setRed(255);
        }
        p2.explore();
        
        //Negative
        int red,green,blue;
        pixel_arr = p3.getPixels();
        for(Pixel spot : pixel_arr)
        {
            //Finding the opposite of each color
            red = 255-spot.getRed();
            blue = 255-spot.getBlue();
            green = 255-spot.getGreen();
            //Replacing the colors with the negative values
            spot.setRed(red);
            spot.setBlue(blue);
            spot.setGreen(green);
        }
        p3.explore();
        
        //Adjust Blue
        pixel_arr = p4.getPixels();
        for(Pixel spot : pixel_arr)
        {
            //Decreases blue value by 75%
            double blue2 = spot.getBlue() * 0.25;
            spot.setBlue((int)blue2);
        }
        p4.explore();
        
        //Greyscale
        red=0;
        blue=0;
        green=0;
        double grey;
        pixel_arr = p5.getPixels();
        for(Pixel spot : pixel_arr)
        {
            //Getting the 3 values of color
            red = spot.getRed();
            blue = spot.getBlue();
            green = spot.getGreen();
            grey = (red+blue+green)/3;
            //Replacing the colors with the grey values
            spot.setRed((int)grey);
            spot.setBlue((int)grey);
            spot.setGreen((int)grey);
        }
        p5.explore();
        
        //Darken
        red=0;
        blue=0;
        green=0;
        pixel_arr = p6.getPixels();
        for(Pixel spot : pixel_arr)
        {
            //Getting the 3 values of color
            red = spot.getRed()-50;
            blue = spot.getBlue()-50;
            green = spot.getGreen()-50;
            if (red<0)
            {
                red = 0;
            }
            if (blue<0)
            {
                blue = 0;
            }
            if (green<0)
            {
                green = 0;
            }
            //Replacing the colors with the darker values
            spot.setRed(red);
            spot.setBlue(blue);
            spot.setGreen(green);
        }
        p6.explore();        
        
        //Colorify
        red=0;
        blue=0;
        green=0;
        pixel_arr = p7.getPixels();
        for(Pixel spot : pixel_arr)
        {
            //Getting the 3 values of color
            red = spot.getRed();
            blue = spot.getBlue();
            green = spot.getGreen();
            if(red<=20&&blue<=20&&green<=20)
            {
                red=255;
                blue=255;
                green=255;
            }
            spot.setRed(red);
            spot.setBlue(blue);
            spot.setGreen(green);
        }
        p7.explore();
        
        //Swap2
        red=0;
        blue=0;
        green=0;
        pixel_arr = p8.getPixels();
        for(Pixel spot : pixel_arr)
        {
            //Getting the 3 values of color
            red = spot.getRed();
            blue = spot.getBlue();
            green = spot.getGreen();
            
            spot.setRed(green);
            spot.setBlue(blue);
            spot.setGreen(red);
        }
        p8.explore();
        
        //Swap3
        red=0;
        blue=0;
        green=0;
        pixel_arr = p8.getPixels();
        for(Pixel spot : pixel_arr)
        {
            //Getting the 3 values of color
            red = spot.getRed();
            blue = spot.getBlue();
            green = spot.getGreen();
            
            spot.setRed(green);
            spot.setBlue(red);
            spot.setGreen(blue);
        }
        p8.explore();
    }
}