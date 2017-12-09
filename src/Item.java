import java.awt.Color;
import java.awt.Graphics;

public class Item extends GameObject
{
	
	public void draw(Graphics page)
	{
		page.setColor(Color.blue);
		page.fillOval(getX(), getY(), getWidth(), getHeight());
		
	}
}
