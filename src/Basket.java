import java.awt.Color;
import java.awt.Graphics;

public class Basket extends GameObject
{
	public void draw(Graphics page, GameObject basket)
	{
		page.setColor(Color.black);
		page.fillRect(basket.getX(), basket.getY(), 50, 10);
		page.fillRect(basket.getX(), basket.getY()-20, 10, 20);
		page.fillRect(basket.getX()+40, basket.getY()-20, 10, 20);
	}

}



