public class InputManager
{

	private boolean[] keyPressed = new boolean[256];
	
	public void setKeyPressed(int keyCode, boolean pressed)
	{
		keyPressed[keyCode] = pressed;
	}
	
	public boolean getKeyPressed(int keyCode)
	{
		return keyPressed[keyCode];
		
	}
	
	public void reset()
	{
		for(int i = 0; i < 256; i++)
		{
			keyPressed[i] = false;
		}
	}

}
	

