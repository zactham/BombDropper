
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Item extends GameObject
{
	public void draw(Graphics page, int spot)
	{
		int [] xPoints = new int[3];
		int [] yPoints = new int[3];
		xPoints[0] = spot;
		xPoints[1] = spot + 20;
		xPoints[2] = spot + 10;

		yPoints[0] = getY();
		yPoints[1] = getY();
		yPoints[2] = getY()+10;

		int nPoints = 3;
		//draw bomb
		page.setColor(Color.gray);
		page.fillPolygon(xPoints, yPoints, nPoints);
		page.fillOval(getX(), getY(), getWidth(), getHeight());
	}
}




