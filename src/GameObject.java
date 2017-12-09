import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject 
{

	protected int x = 0;
	protected int y = 0;


	private static final int standardSize = 75;
	private Rectangle bounds = null;


	private static int objWidth = 0;
	private static int objHeight = 0;

	private static int gameWidth = 700;
	private static int gameHeight = 700;



	public int getX()
	{
		return x;
	}

	public void setX(int xPos)
	{
		x = xPos;
	}

	public void setWidth(int w)
	{
		objWidth = w;
	}

	public void setHeight(int h)
	{
		objHeight = h;
	}

	public int getWidth()
	{
		return objWidth;
	}

	public int getHeight()
	{
		return objHeight;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int yPos)
	{
		y = yPos;
	}



	public static int getStandardSize()
	{
		return standardSize;
	}

	public static int getGameWidth()
	{
		return gameWidth;
	}

	public static void setGameWidth(int gw)
	{
		gameWidth = gw;
	}

	public static int getGameHeight()
	{
		return gameHeight;
	}

	public static void setGameHeight(int gh)
	{
		gameHeight = gh;
	}




	public Rectangle getBounds()
	{
		return bounds;
	}

	public void createBounds(int x, int y, int width, int height)
	{
		if(getBounds() == null)
		{
			bounds = new Rectangle(x, y, width, height);

		}
	}

	protected void drawBounds(Graphics page)
	{
		//page.setColor(Color.white);
		//page.drawRect((int)bounds.getX(), (int)bounds.getY(), (int)bounds.getWidth(), (int) bounds.getHeight());

	}

	public void updateBounds()
	{
		if (getBounds() != null)
			bounds.setLocation(x, y);


		//updateBounds();
	}

	

	public void update()
	{

	}

	public enum GameObjectType
	{
		NONE, 
		Block1, 
		Block2, 
		Block3, 
		Block4,
		Block5,
		Block6,
		Block7

	}
}