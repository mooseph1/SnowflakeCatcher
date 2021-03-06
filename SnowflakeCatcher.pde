SnowFlake [] snowflake;
void setup()
{
  size(400, 400);
  background(0);
  snowflake = new SnowFlake[150];
  for(int a = 0; a < snowflake.length; a++)
  {
    snowflake[a] = new SnowFlake();
  }
}
void draw()
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
void mouseDragged()
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
  void lookDown()
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
  void erase()
  {
    fill(0);
    ellipse(snowX, snowY, 7, 7);
  }
  void move()
  {
    if(isMoving == true)
    {
      snowY = snowY + 1;
    }
  }
  void show()
  {
    noStroke();
    fill(255);
    ellipse(snowX, snowY, 4, 4);
  }
  void wrap()
  {
    if(snowY == 406)
    {
      snowY = -3;
      snowX = (int)(Math.random()*400);
    }
  }
}


