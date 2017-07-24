import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIPanel extends JPanel implements KeyListener{	

	JLabel zoomPercentage = new JLabel("");

	public GUIPanel(){
		GridLayout gridLayout = new GridLayout(0,2);
		this.setLayout(gridLayout);

		JButton zoomInBtn = new JButton("Zoom in");
		JButton zoomOutBtn = new JButton("Zoom out");
		JButton leftBtn = new JButton("Left");
		JButton rigthBtn = new JButton("Right");
		JButton upBtn = new JButton("Up");
		JButton downBtn = new JButton("Down");
		JButton repaintBtn = new JButton("Repaint");
		JTextField redText = new JTextField(10);
		JTextField blueText = new JTextField(10);
		JTextField greenText = new JTextField(10);
		JLabel redLabel = new JLabel("Red: ");
		JLabel blueLabel = new JLabel("Blue: ");
		JLabel greenLabel = new JLabel("Green: ");
		JLabel zoomLabel = new JLabel("Zoom: ");

		this.add(redLabel);
		this.add(redText);

		this.add(blueLabel);
		this.add(blueText);

		this.add(greenLabel);
		this.add(greenText);

		this.add(zoomLabel);
		this.add(zoomPercentage);

		this.add(repaintBtn);

		addKeyListener(this);  

		repaintBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(redText.getText().length() != 0){
					MandelPanel.red = Integer.parseInt(redText.getText());
				}
				if(blueText.getText().length() != 0){
					MandelPanel.blue = Integer.parseInt(blueText.getText());
				}
				if(greenText.getText().length() != 0){
					MandelPanel.green = Integer.parseInt(greenText.getText());
				}
				addNotify();
				Mandel.update();
			}
		});


	}

    public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    public void keyPressed(KeyEvent e) {  
    	if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            Mandel.position[0] += 0.2;
			Mandel.update();
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            Mandel.position[0] -= 0.2;
			Mandel.update();
        }
        if(e.getKeyCode() == KeyEvent.VK_UP){
			Mandel.position[1] -= 0.2;
			Mandel.update();
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            Mandel.position[1] += 0.2;
			Mandel.update();
        }
        if(e.getKeyCode() == KeyEvent.VK_CONTROL){
		 	Mandel.zoomLevel -= 20;
		 	this.zoomPercentage.setText(Double.toString(Mandel.zoomLevel) + "%");
		 	Mandel.update();
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
		 	Mandel.zoomLevel += 20;
		 	this.zoomPercentage.setText(Double.toString(Mandel.zoomLevel) + "%");
		 	Mandel.update();
        }
    }  
    public void keyReleased(KeyEvent e) {  
 		//System.out.println("pressed");
    }  
    public void keyTyped(KeyEvent e) {  
 		//System.out.println("pressed");
    }  
}