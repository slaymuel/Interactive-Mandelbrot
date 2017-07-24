import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Mandel{

	static double zoomLevel;
	static MandelPanel mandelPanel;
	static JFrame frame = new JFrame();
	static double[] position = {0,0};

	static int frameSizeX = 800;
	static int frameSizeY = 400;

	static int mandelSizeX = 400;
	static int mandelSizeY = 400;
	public static void main(String[] args){

		frame.setLayout(new GridLayout(1, 2, 1, 1));
		//(xstart, xfinish, ystart, yfinish, framesizex, framesizey)
		zoomLevel = 100;

		mandelPanel = new MandelPanel(-2, 2, -2, 2, mandelSizeX, mandelSizeY);

		frame.add(mandelPanel);
		frame.add(new GUIPanel());

		frame.setSize(frameSizeX, frameSizeY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void drawMandel(double xStart, double xFinish, double yStart, double yFinish, int frameSizeX, int frameSizeY){
		mandelPanel.update(xStart, xFinish, yStart, yFinish, mandelSizeX, mandelSizeY);
		mandelPanel.repaint();
	}

	public static void update(){

		double xStart = (position[0]-2.0) / (zoomLevel/100);
		double xFinish = (position[0]+2.0) / (zoomLevel/100);
		double yStart = (position[1]-2.0) / (zoomLevel/100);
		double yFinish = (position[1]+2.0) / (zoomLevel/100);

		drawMandel(xStart, xFinish, yStart, yFinish, mandelSizeX, mandelSizeY);
	}
}