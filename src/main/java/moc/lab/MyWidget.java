package moc.lab;

import java.io.IOException;
import java.util.Random;

import ej.bon.Timer;
import ej.bon.TimerTask;
import ej.microui.display.Colors;
import ej.microui.display.GraphicsContext;
import ej.microui.display.Image;
import ej.microui.event.Event;
import ej.microui.event.generator.Pointer;
import ej.mwt.Widget;
import ej.style.Element;
import ej.style.State;

public class MyWidget extends Widget implements Element{
	private static final int MINIMUM_SIZE = 20;
	Random random ;
	private int ElH;
	private boolean hide = false;
	private int ElV;
	private int dimH;
	private int dimV;
	private int lastSH = 0;
	private int lastSV = 0;
	private final int margin;
	private final int Col;
	int pX = 0;
	int pY = 0;
	boolean move = true;
	int dX = 0;
	int dY = 0;
	String[] colors = new String[]{"ROUGE","BLEU","JAUNE", "VERT"};
	int[] theColors = new int[]{Colors.CYAN, Colors.GREEN, Colors.YELLOW, Colors.RED};
	public int score = 0;
	int actualColor = 0;
	String actualColorStrig = "";
	
	private Image basketball_image;
	private Image basketball_ballon;
	

	public MyWidget(int dimH, int dimV, int col) {
		super();
		this.dimH = dimH; 
		this.dimV = dimV;
		this.margin = 5;
		hide = true;
		move = false;
		random = new Random();
		this.Col = col;
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//System.out.println("PX : " + pX + "/" +getWidth() );
				if((pX + (dimV / 2)) == getWidth() || (pX + (dimV / 2)) > getWidth()){
					dX *= -1;
					hide = true;
					move = false;
				}else if((pX - (dimV / 2)) == 0|| (pX - (dimV / 2)) < 0){
					dX *= -1;
					hide = true;
					move = false;
				}
				if(pY == getHeight() || pY + (dimH / 2) > getHeight()){
					dY *= -1;
					hide = true;
					move = false;
				}else if((pY - (dimV / 2)) == 0|| (pY - (dimV / 2)) < 0){
					dY *= -1;
					hide = true;
					move = false;
				}
				
				pX += dX;
				pY += dY;
				repaint();
			}
		}, 0, 20);
	}

	

	@Override
	public void render(GraphicsContext g) {
		
		
		// Set white background
		
		g.setColor(Colors.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		// Draw the basket ball ballon
		g.setColor(this.Col);
		g.fillEllipse(this.pX - (dimH / 2), this.pY- (dimV / 2) ,dimH ,dimV);
		
		// Draw basketball circle
		try {
			basketball_image = Image.createImage("/images/panier02.png");
			
	
		} catch (IOException e){
			throw new AssertionError(e);
		}
		
		g.drawImage(basketball_image, getWidth()/2, 0, GraphicsContext.HCENTER);
		
	}

	@Override
	public void validate(int widthHint, int heightHint) {
		System.out.println("validate Hhint = " + widthHint + " Vhint = " + heightHint);

		setPreferredSize(widthHint, heightHint);
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		//this.ElH = width - 2 * this.margin;
		//this.ElV = height - 2 * this.margin;
	}

	@Override
	public boolean handleEvent(int event) {
		//System.out.println("SIMPLE Event = " + event);
		// Analyze event
		if (Event.getType(event) == Event.POINTER) {
			if (Pointer.isPressed(event)){
				move = false;
				Pointer ptr = (Pointer) Event.getGenerator(event);
				this.pX = getRelativeX(ptr.getX());
				this.pY = getRelativeY(ptr.getY());
				this.lastSH = ptr.getX();
				this.lastSV = ptr.getY();
				
				repaint();
				return true;
			}
			if (Pointer.isDragged(event)) {
				move = false;
				Pointer ptr = (Pointer)Event.getGenerator(event);
				dX = getRelativeX(ptr.getX()) - pX;
				dY = getRelativeY(ptr.getY()) - pY;
				this.pX = getRelativeX(ptr.getX());
				this.pY = getRelativeY(ptr.getY());
				repaint();
			}
			if (Pointer.isReleased(event)) {
				move = true;
			}
		}
		return false;
	}



	@Override
	public boolean hasClassSelector(String classSelector) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean isInState(State state) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public String getAttribute(String attribute) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Element getParentElement() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Element[] getChildrenElements() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Element getChild(int index) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int getChildrenCount() {
		// TODO Auto-generated method stub
		return 0;
	}
}
