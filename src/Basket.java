import java.awt.Color;
import java.awt.Graphics;

public class Basket extends GameObject
{
	
	public void draw(Graphics page)
	{
		page.setColor(Color.BLACK);
		/*
		page.fillRect(getX(), getY(), 50, 10);
		page.fillRect(getX(), getY()-20, 10, 20);
		page.fillRect(getX()+40, getY()-20, 10, 20);
		 */

		page.fillRect(getX(), getY(), getWidth(), getHeight());
		page.fillRect(getX(), getY()-20, getHeight(), getWidth()-30);
		page.fillRect(getX()+40, getY()-20, getHeight(), getWidth()-30);
	}

}
