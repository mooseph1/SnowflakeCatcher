import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SnowflakeCatcher extends PApplet {

SnowFlake [] snowflake;
public void setup()
{
  size(400, 400);
  background(0);
  snowflake = new SnowFlake[150];
  for(int a = 0; a < snowflake.length; a++)
  {
    snowflake[a] = new SnowFlake();
  }
}
public void draw()
{
for(int b = 0; b < snowflake.length; b++)
  {
    snowflake[b].lookDown();
    snowflake[b].erase();
    snowflake[b].move();
    snowflake[b].wrap();
    snowflake[b].show();
  }
}
public void mouseDragged()
{
  if(mouseButton == LEFT)
  {
    fill(255,0,255);
    ellipse(mouseX, mouseY, 7, 7);
  }
  if(mouseButton == RIGHT)
  {
    fill(0);
    ellipse(mouseX, mouseY, 15, 15);
  }
}
class SnowFlake
{
  int snowX, snowY;
  boolean isMoving;
  SnowFlake()
  {
    snowX = (int)(Math.random()*400);
    snowY = (int)(Math.random()*400);
    isMoving = true;
  }
  public void lookDown()
  {
    if(snowY >= 0 && snowY <= 396)
    {
      if(get(snowX,snowY+3) != color(0))
      {
        isMoving = false;
      }
      else
      {
        isMoving = true; 
      }
    }
    else
    {
      isMoving = true;
    }
  }
  public void erase()
  {
    fill(0);
    ellipse(snowX, snowY, 7, 7);
  }
  public void move()
  {
    if(isMoving == true)
    {
      snowY = snowY + 1;
    }
  }
  public void show()
  {
    noStroke();
    fill(255);
    ellipse(snowX, snowY, 4, 4);
  }
  public void wrap()
  {
    if(snowY == 406)
    {
      snowY = -3;
      snowX = (int)(Math.random()*400);
    }
  }
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SnowflakeCatcher" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
