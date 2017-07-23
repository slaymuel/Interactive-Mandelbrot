import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIPanel extends JPanel implements KeyListener{	
	
	public GUIPanel(){
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
		this.add(redText);
		this.add(blueText);
		this.add(greenText);
		this.add(repaintBtn);
		// this.add(zoomInBtn);
		// this.add(zoomOutBtn);
		// this.add(leftBtn);
		// this.add(rigthBtn);
		// this.add(upBtn);
		// this.add(downBtn);
		//frame.pack();
		//button.addActionListener(new ActionListener(){
		//	@Override
		//	public void actionPerformed(ActionEvent e){
		//		Mandel.update();
		//	}
		//});
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

		// zoomInBtn.addActionListener(new ActionListener(){
		// 	@Override
		// 	public void actionPerformed(ActionEvent e){
		// 		Mandel.zoomLevel += 0.5;
		// 		Mandel.update();
		// 	}
		// });

		// zoomOutBtn.addActionListener(new ActionListener(){
		// 	@Override
		// 	public void actionPerformed(ActionEvent e){
		// 		Mandel.zoomLevel -= 0.5;
		// 		Mandel.update();
		// 	}
		// });

		// rigthBtn.addActionListener(new ActionListener(){
		// 	@Override
		// 	public void actionPerformed(ActionEvent e){
		// 		Mandel.position[0] += 0.2;
		// 		Mandel.update();
		// 	}
		// });

		// leftBtn.addActionListener(new ActionListener(){
		// 	@Override
		// 	public void actionPerformed(ActionEvent e){
		// 		Mandel.position[0] -= 0.2;
		// 		Mandel.update();
		// 	}
		// });

		// upBtn.addActionListener(new ActionListener(){
		// 	@Override
		// 	public void actionPerformed(ActionEvent e){
		// 		Mandel.position[1] -= 0.2;
		// 		Mandel.update();
		// 	}
		// });

		// downBtn.addActionListener(new ActionListener(){
		// 	@Override
		// 	public void actionPerformed(ActionEvent e){
		// 		Mandel.position[1] += 0.2;
		// 		Mandel.update();
		// 	}
		// });
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
		 	Mandel.zoomLevel -= 0.5;
		 	Mandel.update();
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
		 	Mandel.zoomLevel += 0.5;
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