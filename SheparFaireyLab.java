// Alec Martinez
// 11/3/17
// Shepard Fairey program

import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class SheparFaireyLab
{
    /**
     * main method, to test the picture
     *  
     */
    public static void main(String[] args)
    {
         //relative path
         Picture apic = new Picture("images\\tidepod.jpeg");
         //change with selfie picture
         Picture me = new Picture("images/tidepod.jpeg");
         Picture me1 = new Picture("images/tidepod.jpeg");
         Picture me2 = new Picture("images/tidepod.jpeg");
         
         me.explore();
         
         int red=0,blue=0,green=0;
         //me.explore();
         /**
          * Greyscale
          * 
          */
         Pixel[] pixel_arr;
         pixel_arr = me.getPixels();
         for(Pixel spot : pixel_arr)
         {
             //Getting colors
             red=spot.getRed();
             blue=spot.getBlue();
             green=spot.getGreen();
             //Making the colors grey
             double grey = (red+blue+green)/3;
             spot.setRed((int)grey);
             spot.setBlue((int)grey);
             spot.setGreen((int)grey);
         }
         me1=me;
         me2=me;
         me.explore();
         
         /**
          * method 1 change
          * Turns the picture grey and then changes the
          * colors to dark blue, red, light blue, and 
          * off white
          */
         
         Pixel[] pixel_arr2;
         pixel_arr2 = me.getPixels();
         for(Pixel spot : pixel_arr2)
         {
             //Making the picture grey
             red=spot.getRed();
             blue=spot.getBlue();
             green=spot.getGreen();
             double grey = (red+blue+green)/3;
             //Testing the brightness and darkness of
             //the grey to change the color
             if (grey>=191)
             //Off White
             {
             spot.setRed(255);
             spot.setBlue(170);
             spot.setGreen(229);
             }
             else if (grey>=127 && grey<191)
             //Light Blue
             {
             spot.setRed(105);
             spot.setBlue(162);
             spot.setGreen(152);
             }
             else if (grey>=63 && grey<127)
             //Red
             {
             spot.setRed(216);
             spot.setBlue(33);
             spot.setGreen(25);
             }
             else
             //Dark Blue
             {
             spot.setRed(0);
             spot.setBlue(49);
             spot.setGreen(0);
             }
         }
         me.explore();
         
         /**
          * method 2
          * Get the highest and lowest grey value
          * and divide
          */
         
         Pixel[] pixel_arr3;
         pixel_arr3 = me1.getPixels();
         int b=0,s=255;
         for(Pixel spot : pixel_arr3)
         {
             //Making the picture grey
             red=spot.getRed();
             blue=spot.getBlue();
             green=spot.getGreen();
             double grey = (red+blue+green)/3;
             if (grey<s)
             {
                 s=(int)grey;
             }
             else if (grey>b)
             {
                 b=(int)grey;
             }
         }
         //Finding the range and dividing into 4 sections
         double middle=(b-s)/4;
         int sec1=(int)middle,sec2=(int)middle*2,sec3=(int)middle*3,sec4=(int)middle*4;
         for(Pixel spot:pixel_arr3)
         {
             red=spot.getRed();
             blue=spot.getBlue();
             green=spot.getGreen();
             double grey = (red+blue+green)/3;
             if (grey<=sec4 && grey > sec3)
             //Off White
             {
             spot.setRed(255);
             spot.setBlue(170);
             spot.setGreen(229);
             }
             else if (grey<=sec3 && grey > sec2)
             //Light Blue
             {
             spot.setRed(105);
             spot.setBlue(162);
             spot.setGreen(152);
             }
             else if (grey<=sec2 && grey > sec1)
             //Red
             {
             spot.setRed(216);
             spot.setBlue(33);
             spot.setGreen(25);
             }
             else if (grey<=sec1)
             //Dark Blue
             {
             spot.setRed(0);
             spot.setBlue(49);
             spot.setGreen(0);
             }
         }
         me1.explore();
         /**
          * custom color palette
          */
         Pixel[] pixel_arr4;
         pixel_arr4 = me2.getPixels();
         for(Pixel spot : pixel_arr4)
         {
             //Making the picture grey
             red=spot.getRed();
             blue=spot.getBlue();
             green=spot.getGreen();
             double grey = (red+blue+green)/3;
             //Testing the brightness and darkness of
             //the grey to change the color
             if (grey>=191)
             //Off White
             {
             spot.setRed(245);
             spot.setBlue(200);
             spot.setGreen(230);
             }
             else if (grey>=127 && grey<191)
             //Tealish
             {
             spot.setRed(29);
             spot.setBlue(117);
             spot.setGreen(224);
             }
             else if (grey>=63 && grey<127)
             //RCandy Red
             {
             spot.setRed(255);
             spot.setBlue(73);
             spot.setGreen(28);
             }
             else
             //Grey
             {
             spot.setRed(50);
             spot.setBlue(50);
             spot.setGreen(50);
             }
         }
         me2.explore();
         
    }
}      

