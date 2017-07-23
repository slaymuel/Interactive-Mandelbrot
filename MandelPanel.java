import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;

public class MandelPanel extends JPanel{
	final static int LIMIT = 60;

	double startValueX;
	double finishValueX;
	double startValueY;
	double finishValueY;
	double stepSizeX;
	double stepSizeY;
	double frameX;
	double frameY;
	int ratioAX;
	int ratioBX;
	int ratioAY;
	int ratioBY;

	static int red;
	static int blue;
	static int green;

	public MandelPanel(double startValueX, double finishValueX, double startValueY, double finishValueY, double frameX, double frameY){
		this.startValueX = startValueX;
		this.startValueY = startValueY;
		this.finishValueX = finishValueX;
		this.finishValueY = finishValueY;
		this.frameX = frameX;
		this.frameY = frameY;
		this.stepSizeX = (finishValueX - startValueX)/frameX;
		this.stepSizeY = (finishValueY - startValueY)/frameY;

		this.ratioAX = (int)(frameX/(finishValueX-startValueX));
		this.ratioBX = (int) (-1 * startValueX * frameX/(finishValueX-startValueX));

		this.ratioAY = (int)(frameY/(finishValueY-startValueY));
		this.ratioBY = (int) (-1 * startValueY * frameY/(finishValueY-startValueY));

		this.red = 77;
		this.blue = 58;
		this.green = 159;
	}

	public void update(double startValueX, double finishValueX, double startValueY, double finishValueY, double frameX, double frameY){
		this.startValueX = startValueX;
		this.startValueY = startValueY;
		this.finishValueX = finishValueX;
		this.finishValueY = finishValueY;
		this.frameX = frameX;
		this.frameY = frameY;
		this.stepSizeX = (finishValueX - startValueX)/frameX;
		this.stepSizeY = (finishValueY - startValueY)/frameY;

		this.ratioAX = (int)(frameX/(finishValueX-startValueX));
		this.ratioBX = (int) (-1 * startValueX * frameX/(finishValueX-startValueX));

		this.ratioAY = (int)(frameY/(finishValueY-startValueY));
		this.ratioBY = (int) (-1 * startValueY * frameY/(finishValueY-startValueY));
	}
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);

		for(double x = startValueX; x < finishValueX; x += stepSizeX){
			for(double y = startValueY; y < finishValueY; y += stepSizeY){
				int c = bounded(new Complex(x, y));
				if(c == LIMIT){
					g.setColor(Color.BLACK);
				}
				else{
					g.setColor(new Color(c * red % 256, c * green % 256, c * blue % 256));//c * 77 % 256, c * 58 % 256, c * 159 % 256));
				}
				g.drawRect((int)(x * ratioAX) + ratioBX, (int)(y * ratioAY) + ratioBY, 1, 1);
			}
		}
	}

	static int bounded(Complex c){
		Complex z = new Complex(0, 0);

		for(int i = 0; i < LIMIT; i++){
			//z2 = z1^2 + c
			z = z.multiply(z).add(c);
			
			if(z.abs() > 2){
				return i;
			}
		}
		return LIMIT;
	}
}