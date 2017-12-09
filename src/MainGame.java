import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainGame extends JPanel implements KeyListener
{
	Sound sound;
	private int score = 0;
	private boolean end;

	private boolean itemAway = false;

	private boolean rightBounds = false;
	private boolean leftBounds = false;

	//	private JFrame restart;
	private JFrame start;

	private final int gameSize = 700;
	private final int scorex = 0;
	private final int scorey = gameSize;

	private int randomX = (int) (Math.random()*gameSize +1);


	private InputManager inputManager;

	private boolean gameOver = false;
	private int lives = 3;

	private Basket basket = new Basket();
	private int basketWidth = 50;
	private int basketHeight = 10;

	private Item item = new Item();
	private int itemWidth = 10;
	private int itemHeight = 10;
	private int movement = 5;
	private int basketSpeed = 5;

	private boolean caught = false;


	// Constructor
	public MainGame()
	{
		setFocusable(true);
		// Register for mouse events on the panel
		addKeyListener(this);
	}


	public void init(int level)
	{
		sound = new Sound();
		basket.setX(gameSize/2);
		basket.setY(gameSize - 100);
		basket.setWidth(basketWidth);
		basket.setHeight(basketHeight);
		basket.createBounds(getX(), getY(), getWidth(), getHeight());

		item.setX(randomX);
		item.setY(0);
		item.setWidth(itemWidth);
		item.setHeight(itemHeight);
		item.createBounds(getX(), getY(), getWidth(), getHeight());

		inputManager = new InputManager();

		setPreferredSize(new Dimension(gameSize, gameSize));

		// launch game
		JFrame frame = new JFrame("Sample Frame");
		frame.add(this);
		frame.setTitle("Game Title");

		JOptionPane.showMessageDialog(start, "Game Instructions");

		//Sets the speed of the game for each mode
		if (level == 1)		// easy
		{

		}

		if (level == 2)		// medium
		{

		}

		if (level == 3)		// hard
		{

		}

		playMusicMain();

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		centerWindow();
		frame.setLocationRelativeTo(TitleScreen.theApp);

		// runs the mainLoop
		ActionListener timerAction = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				MainLoop();

			}

		};

		// Frame rate, updates the frame every 15ms --- 60fps
		Timer timer = new Timer(15, timerAction);
		timer.setRepeats(true);
		timer.start();


	}

	public void MainLoop()
	{
		item.setY(item.getY()+movement);

		collide();

		if(itemAway || item.getY() > gameSize)
		{
			resetItem();
		}

		if (inputManager.getKeyPressed(KeyEvent.VK_RIGHT) == true && !rightBounds)
			basket.setX(basket.getX() + basketSpeed);

		if (inputManager.getKeyPressed(KeyEvent.VK_LEFT) == true && !leftBounds)
			basket.setX(basket.getX() - basketSpeed);

		//When S is pressed the music stops
		if (inputManager.getKeyPressed(KeyEvent.VK_S) == true) 
			sound.toggle();

		if(basket.getX() + basket.getWidth() >= gameSize)
			rightBounds = true;

		if (basket.getX() <= 0)
			leftBounds = true;

		// updateGame();
		repaint();

		if(lives <1)
		{
			gameOver = true;
			gameEnding();
		}
	}

	public void collide()
	{
		if (item.getBounds().intersects(basket.getBounds()))
		{
			itemAway = true;
			score++;
		}


	}

	public void resetItem()
	{
		itemAway = false;
		randomX = (int) (Math.random()*gameSize +1);
		item.setX(randomX);
		item.setY(0);
	}


	public void playMusicMain()
	{
		//sound.play("IngameMusic.wav");
	}

	public void playSoundEffect()
	{
		//sound.play("SMACK Sound Effect.wav");
	}

	// Centers the window
	public void centerWindow()
	{
		// gets top level window
		Window window;
		Container c = getParent();
		while (c.getParent() != null)
			c = c.getParent();

		// center window
		if (c instanceof Window)// if it is the top window...
		{
			// centers it
			window = (Window) c;
			window.pack();
			window.setLocationRelativeTo(null);
		}
	}

	//
	//When the game ends
	//
	public void gameEnding()
	{

		sound.stop();

		int result = JOptionPane.showConfirmDialog(this, 
				"Your Score: " + score + " - Play Again?", 
				"Game Over", JOptionPane.YES_NO_OPTION);

		if (result == JOptionPane.NO_OPTION)
		{
			// no
			System.exit(0);
		}
		else
		{
			// yes, play again
			resetGame();
		}
	}

	private void resetGame()
	{
		gameOver = false;
	}

	public void displayScore(Graphics page)
	{
		//Displays the Score
		page.setColor(Color.black);
		page.setFont(new Font("Comic Sans MS", Font.PLAIN, gameSize/20));
		page.drawString("SCORE: " + Integer.toString(score), scorex, scorey);
	}

	@Override
	protected void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		//draw bucket
		page.setColor(Color.black);

		if(!itemAway)
			item.draw(page);
		basket.draw(page);


		// drawGame(page);
		displayScore(page);
	}

	public int getScore()
	{
		return score;
	}


	public void keyPressed(KeyEvent arg0) 
	{
		int c = arg0.getKeyCode();
		inputManager.setKeyPressed(c, true);

	}



	public void keyReleased(KeyEvent arg0) 
	{
		int c = arg0.getKeyCode();
		inputManager.setKeyPressed(c, false);
	}


	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}

