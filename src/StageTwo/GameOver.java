package StageTwo;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

public class GameOver extends JPanel{
	ImageIcon game_over = new ImageIcon("images/gameover.png");
	Image game=game_over.getImage();
	public void paintComponent(Graphics g) { // 가로길이, 세로길이 받아서, 각각의 객체 호출
		super.paintComponent(g); // JPanel에 구현된 paintComponent() 호출 -> 자기 자신을 그린다...
		
		g.drawImage(game,0,0,1015,800,this);
	}
}
