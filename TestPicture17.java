
/**
 * Kevin Hayes
 * Test Picture Classes
 *
 * @author (Kevin Hayes)
 * @version (10-19-2016)
 */
import java.awt.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
public class TestPicture17
{

    /**
     * main method, to test the picture
     *
     */
  public static void main(String[] args)
  {
      /*
      Color sample = new Color(255,51,0);
      Color sample2 = Color.orange;
      
      System.out.println(sample2);
      
      //opens picture using a dialog box
      /*
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();

     //opens a pictue using a path
     //Picture apic = new Picture("C:\\Users\\khayes\\Favorites\\Documents\APCS- Java\chap03\Curriclum 2013\Picture Color labs\images\\beach.jpg");
     /**/
     //relative path
     Picture apic = new Picture("images\\beach.jpg");
     Picture image1 = new Picture("images/dk_khaled2.jpg");
     Picture image2 = new Picture("images/dk_khaled2.jpg");
     Picture image3 = new Picture("images/dk_khaled2.jpg");
     Picture image4 = new Picture("images/dk_khaled2.jpg");
     Picture image5 = new Picture("images/dk_khaled2.jpg");
     Picture image6 = new Picture("images/dk_khaled2.jpg");
     Picture canvas = new Picture("images\\mycanvas.jpg");
     Picture apyr = new Picture("images/apyr.jpg");

     
     //image1.greyscale();
     //canvas.copy();
     //image1.mirrorVertical();
     //image1.mirrorHorizontal();
     //canvas.copySmaller(image1,3);
     
     canvas.copy(image1,0,0);
     
     image2.edge(100);
     canvas.copy(image2,1309,0);
     
     image3.mirrorVerticalcol();
     image3.mirrorHorizontalneg();
     canvas.copy(image3,2617,0);
     
     image4.background(apyr);
     canvas.copy(image4,0,997);
     
     canvas.recursive(image5,1);
     canvas.copy(image5,1309,997);
     
     image6.Intense();
     canvas.copy(image6,2617,997);
     
     canvas.explore();
     
     
     /*
     Pixel[] pixel_arr3;
     pixel_arr3 = image4.getPixels();
     */
     /*
     for (Pixel pixel_arr3 : pixels)
     {
         pixel_arr3.setWhite(Color.black);
         
     }*/
     
     
     //apic.explore();
     //ferris1.explore();
     /*
     //makes an array of pixels
     Pixel[] pixels;
     //gets pixels from picture and assigns to pixels array
     pixels = ferris1.getPixels();
    
     //how many pixels or how large array
    System.out.println("This is a large array"+pixels.length  );


    /*
        //access each index
    System.out.println(pixels[17]);
    //access each pixel
    Pixel spot = ferris1.getPixel(100,100);
    Pixel lampspot = ferris1.getPixel(255,394);
    
    System.out.println(pixels[17].getColor());
    System.out.println(spot);
    System.out.println(lampspot);
/*
    pixels[17].setColor(Color.blue);
    spot.setColor(new Color(252,252,252));
    pixels[500034].setColor(Color.blue);
    lampspot.setColor(Color.black);

    //ferris1.explore();
/*
   // loop to access indexes of array or collection

    Pixel[] pixels_arr;
    pixels_arr = ferris1.getPixels();
    int i = 0;
    //for each loop spot  is a ?
    for (Pixel spot1 : pixels)
        {
            //System.out.println( spot1 );
        if ((spot1.getX()+spot1.getY())%20==0)
        {
            spot1.setColor(Color.red);
        }
        i++;
        }
    //ferris1.explore();
    

   


 /**
  * Method to clear red from picture
  * @param none
  * @return none
  */
 /*
 Pixel[] pixel_arr2;
 pixel_arr2 = ferris2.getPixels();
    for (Pixel pixel_arr : pixels)
        {
            //pixel_arr2.setRed(Color.green);
        }
    ferris2.explore();
    
/*
 /**
  * Method to reduce red from picture by a factor of n
  * @param none
  * @return none
  */

/*
int value;
final double  FACTOR = .5;
    for (Pixel pixelObj : pixels)
    {

        //get the redvalue
        value = pixelObj.getRed();
        //System.out.println(value);

        //decrease the red value by 50%
        
        //set the red value of the current pixel to the new value
        

    }
    // use new picture when changing or it will make changes to 
    // pic you already changed
    ferris1.explore();
    ferris2.explore();
 
    //write/save a picture as a file
    ferris1.write("images/ferris11.jpg"); //change name to save as a new file

    /**/
  }//main
}//class
