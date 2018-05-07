import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 *
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor
     */
    super();
  }

  /**
   * Constructor that takes a file name and creates the picture
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }

  /**
   * Constructor that takes a picture and creates a
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }

  ////////////////////// methods ///////////////////////////////////////

  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */

   int red=0,blue=0,green=0;

  public String toString()
  {
    String output = "Picture, filename " + getFileName() +
      " height " + getHeight()
      + " width " + getWidth();
    return output;

  }

  public static void main(String[] args)
  {
     String fileName = FileChooser.pickAFile();
     Picture pictObj = new Picture(fileName);
     pictObj.explore();
  }
  public void greyscale()
  {
      Pixel[] pixel_arr;
      pixel_arr = this.getPixels();
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
    }//end of greyscale

    public void copy(Picture file, int x, int y)
    {
        Picture sourceFile = file;
        Picture sourcePicture = new Picture(sourceFile);

        Pixel sourcePixel = null;
        Pixel targetPixel = null;

        //width of source must be = or < the canvas I am copy to
        //loop through the columns
        for(int sourceX = 0, targetX=x;
            sourceX<sourcePicture.getWidth();
            sourceX++,targetX++)
            {
                for(int sourceY = 0, targetY = y;
                    sourceY < sourcePicture.getHeight();
                    sourceY++, targetY++)
                    {
                        sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
                        targetPixel = this.getPixel(targetX,targetY);
                        targetPixel.setColor(sourcePixel.getColor());
                    }
                //loop through rows
                //set the target pixel color to the source pixel color
            }
    }

    /**
     * Method to mirror around a vertical line in the middle of the
     * picture based on the width
     */
    public void mirrorVertical()
    {
        int width = this.getWidth();
        int mirrorPoint = width/2;

        Pixel leftPixel = null;
        Pixel rightPixel = null;

        //loop through all rows
        for(int y=0; y<getHeight(); y++)
        {
            //loop from 0 to the middle(mirror point)
            for(int x = 0; x<mirrorPoint; x++)
            {
                leftPixel = getPixel(x,y);
                rightPixel = getPixel(width -1 -x,y);
                rightPixel.setColor(leftPixel.getColor());
               }
           }
       }

    public void mirrorHorizontal()
    {
        int height = this.getHeight();
        int mirrorPoint = height/2;
        Pixel topPixel = null;
        Pixel bottomPixel = null;

        for(int x = 0; x<getWidth(); x++)
        {
            for(int y=0; y<mirrorPoint; y++)
            {
                topPixel = getPixel(x,y);
                bottomPixel = getPixel(x,height-1-y);
                bottomPixel.setColor(topPixel.getColor());
               }
           }
        }

    public void copySmaller(Picture file, int amt)
    {
        Picture pic = file;
        Pixel sourcePixel = null;
        Pixel targetPixel = null;
        for(int sourceX = 0, targetX=0;
            sourceX<pic.getWidth();
            sourceX+=amt,targetX++)
        {
            for(int sourceY = 0, targetY = 0;
                    sourceY < pic.getHeight();
                    sourceY+=amt, targetY++)
            {
                sourcePixel = pic.getPixel(sourceX,sourceY);
                targetPixel = this.getPixel(targetX,targetY);
                targetPixel.setColor(sourcePixel.getColor());
               }
           }
       }



    // NEW METHODS



    Random rand = new Random();

    /**
	 * Intensify
	 * Makes highest RGB value 255
     */

    public void Intense()
    {
        for(int x=0;x<this.getWidth();x++)
        {
            for(int y=0;y<this.getHeight();y++)
            {
                Pixel place = this.getPixel(x,y);
                int red = place.getRed();
                int blue = place.getBlue();
                int green = place.getGreen();
                if(red>=blue&&red>=green)
                {
                    place.setRed(255);
                    place.setBlue(0);
                    place.setGreen(0);
                }
                if(blue>=red&&blue>=green)
                {
                    place.setBlue(255);
                    place.setRed(0);
                    place.setGreen(0);
                }
                if(green>=red&&green>=blue)
                {
                    place.setGreen(255);
                    place.setRed(0);
                    place.setBlue(0);
                }
            }
        }
    }

    /**
	 * Edge
	 * Makes edges yellow and background violet
     */

    public void edge(int num)
    {
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        this.greyscale();
        for(int x = 0; x<getWidth(); x++)
        {
            for(int y=0; y<getHeight(); y++)
            {
                topPixel = getPixel(x,y);
                bottomPixel = getPixel(x,getHeight()-1);
                if(Math.abs(topPixel.getRed()-bottomPixel.getRed())>num)
                topPixel.setColor(Color.yellow);
                else
                {
                    topPixel.setRed(158);
                    topPixel.setBlue(220);
                    topPixel.setGreen(33);
                }
               }
           }
    }

    /**
	 * Horizontal Negative Mirror
	 * Makes mirror of image negative
     */

    public void mirrorHorizontalneg()
    {
        int height = this.getHeight();
        int mirrorPoint = height/2;
        Pixel topPixel = null;
        Pixel bottomPixel = null;

        for(int x = 0; x<getWidth(); x++)
        {
            for(int y=0; y<mirrorPoint; y++)
            {
                topPixel = getPixel(x,y);
                bottomPixel = getPixel(x,height-1-y);

                bottomPixel.setRed(Math.abs(255-topPixel.getRed()));
                bottomPixel.setBlue(Math.abs(255-topPixel.getBlue()));
                bottomPixel.setGreen(Math.abs(255-topPixel.getGreen()));

               }
           }
        }

    /**
	 * Vertical Negative Mirror
	 * Makes mirror of image negative
     */

    public void mirrorVerticalcol()
    {
        int width = this.getWidth();
        int mirrorPoint = width/2;

        Pixel leftPixel = null;
        Pixel rightPixel = null;

        //loop through all rows
        for(int y=0; y<getHeight(); y++)
        {
            //loop from 0 to the middle(mirror point)
            for(int x = 0; x<mirrorPoint; x++)
            {
                leftPixel = getPixel(x,y);
                rightPixel = getPixel(width -1 -x,y);

                rightPixel.setRed(Math.abs(255-leftPixel.getRed()));
                rightPixel.setBlue(Math.abs(255-leftPixel.getBlue()));
                rightPixel.setGreen(Math.abs(255-leftPixel.getGreen()));

                //rightPixel.setRed(leftPixel.getBlue());
                //rightPixel.setBlue(leftPixel.getGreen());
                //rightPixel.setGreen(leftPixel.getRed());
               }
           }
       }

    /**
	 * Background Changer
	 * Takes an image and replaces a white background with the new image
     */

    public void background(Picture file)
    {
        Pixel sourcePixel = null;
        Pixel targetPixel = null;
        for(int x=0;x<this.getWidth();x++)
        {
            for(int y=0;y<this.getHeight();y++)
            {
                Pixel place = this.getPixel(x,y);
                Pixel place2 = file.getPixel(x,y);
                int red = place.getRed();
                int blue = place.getBlue();
                int green = place.getGreen();
                int red2 = place2.getRed();
                int blue2 = place2.getBlue();
                int green2 = place2.getGreen();
                if(place.getRed()>=245&&place.getBlue()>=245&&place.getGreen()>=245)
                {
                    place.setRed(red2);
                    place.setBlue(blue2);
                    place.setGreen(green2);
                }
            }
        }
    }

    /**
	 * Recursive Copy Smaller
	 * Takes a number and makes a picture smaller and smaller until it is 6 times smaller
     */

    public void recursive(Picture pic, int amt)
    {
        Pixel sourcePixel = null;
        Pixel targetPixel = null;

        if(amt == 6)
        {}

        else{
            for(int sourceX = 0, targetX=0;
                sourceX<pic.getWidth();
                sourceX+=amt,targetX++)
                {
                    for(int sourceY = 0, targetY = 0;
                        sourceY < pic.getHeight();
                        sourceY+=amt, targetY++)
                        {
                            sourcePixel = pic.getPixel(sourceX,sourceY);
                            targetPixel = this.getPixel(targetX,targetY);
                            if(sourcePixel.getRed()>=245&&sourcePixel.getBlue()>=245&&sourcePixel.getGreen()>=245)
                            {
                                targetPixel.setGreen(sourcePixel.getGreen()-15);
                                targetPixel.setRed(sourcePixel.getRed()-15);
                            }
                            else{
                            targetPixel.setColor(sourcePixel.getColor());}
                        }
                }
            pic.recursive(pic,amt+1);
        }
    }

    /**
	 * Mirror Color
	 * Mirror image and changes RGB colors around
     */

    public void mirrorColor()
    {
        int height = this.getHeight();
        int mirrorPoint = height/2;
        Pixel topPixel = null;
        Pixel bottomPixel = null;

        for(int x = 0; x<getWidth(); x++)
        {
            for(int y=0; y<mirrorPoint; y++)
            {
                topPixel = getPixel(x,y);
                bottomPixel = getPixel(x,height-1-y);
                bottomPixel.setRed(topPixel.getGreen());
                bottomPixel.setBlue(topPixel.getRed());
                bottomPixel.setGreen(topPixel.getBlue());
               }
           }
    }

} // this } is the end of class Picture, put all new methods before this
