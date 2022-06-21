import processing.core.PApplet;
import processing.core.PImage; // import the PImage library

  /** 
   * This program draws three moving objects
   * Author: Aurora Chen
   */

public class Sketch extends PApplet {
	// declare global image variable
  PImage imgBackground;
  PImage imgFrog;
  PImage imgLeaf;

  float fltBackgroundX = 0;
  float fltBackgroundY = 0;

  float fltFrogX = 200;
  float fltFrogY = 200;
  float fltFrogSpeedX = 1;
  float fltFrogSpeedY = 1;

  float fltLeafX = 50;
  float fltLeafY = 50;
  float fltLeafSpeedX = 1;
  float fltLeafSpeedY = 20;

  float fltCirX = 100;
  float fltCirY = width/10;
  float fltCirSpeedX = 2;
  float fltCirSpeedY = 1;
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
      background(128);
      // Load background
      imgBackground = loadImage("Forest.jpg");
      // Resize background
      imgBackground.resize(width, height);
      // Load image
      imgFrog = loadImage("Frog.png");
      // Resize frog
      imgFrog.resize(85, 118);
      // Load image
      imgLeaf = loadImage("leaf.png");
      // Resize leaf
      imgLeaf.resize(50, 50);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  
    image(imgBackground, fltBackgroundX, fltBackgroundY);

    // Draw frog and move
    image(imgFrog, fltFrogX, fltFrogY);
    fltFrogX += fltFrogSpeedX;

    // Bounce frog off edge of screen
    if(fltFrogX < 0 || fltFrogX > width - imgFrog.width)
    {
      fltFrogSpeedX *= -1;
    }

    // draw circle and move
    ellipse(fltCirX, fltCirY, 20, 20);
    fltCirX += fltCirSpeedX;
    fltCirY += fltCirSpeedY;

    if (fltCirX < 0+10 || fltCirX > width-10) {
      fltCirSpeedX *= -1;
    }

    if (fltCirY < 0+10  || fltCirY > height-10) {
      fltCirSpeedY *= -1;
    }

    image(imgLeaf, fltLeafX, fltLeafY);
    fltLeafX +=(fltLeafSpeedX);
    fltLeafY += (Math.sin(0.2 * fltLeafX) ) * 5; 

    if(fltLeafX < 0 || fltLeafX > width - imgLeaf.width)
    {
      fltLeafSpeedX *= -1;
    }
  }
  
  // define other methods down here.

  
}