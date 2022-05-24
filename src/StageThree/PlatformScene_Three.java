package StageThree;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class PlatformScene_Three extends JPanel implements Runnable{ //flatform������ ������ �� class

	MoveCharacterKey move = null;
	Background background;
	CharacterObject hero; 
	CharacterObject hero_2p;
	StageThree stage;
	
	public static boolean jumping = false;
	public static boolean falling = false;
	public static boolean isJumping = false;
	public static boolean leftMove = false;
	public static boolean rightMove = false;
	public static boolean upMove = false;
	public static boolean onTop = false;
	public static boolean checkleft = true; //----------------------------
	public static boolean checkright = true; //----------------------------
	
	public static boolean jumping_2p = false;
	public static boolean falling_2p = false;
	public static boolean isJumping_2p = false;
	public static boolean leftMove_2p = false;
	public static boolean rightMove_2p = false;
	public static boolean upMove_2p = false;
	public static boolean onTop_2p = false;
	public static boolean checkleft_2p = true; //----------------------------
	public static boolean checkright_2p = true; //----------------------------
	
	public static int deltaY = 0;
	public static boolean blockrightMoving = true;    // ��� ������
	public static boolean onBottom = false;

	public static int width = 0;
	public static int height = 0;
	
	public static boolean pushblock1 = false;

	public static boolean onBlock1 = false;
	public static boolean onBlock2 = false;
	public static boolean onBlock3 = false;
	public static boolean onBlock4 = false;
	public static boolean outBlock1 = true;
	public static boolean outBlock2 = true;
	public static boolean moveBlock1 = false;
	public static boolean moveBlock2 = false;
	public static boolean moveBlock2_2 = false;
	public static boolean moveBlock3 = false;
	public static boolean moveBlock4 = false;
	public static boolean moveBlock4_2 = false;
	public static boolean moveBlock5 = false;
	
	public static boolean monsterblock = true;
	public static boolean monstermove = true;
	
	int point;
	public static boolean reddir1 = true;
	public static boolean reddir2 = true;
	public static boolean reddir3 = true;
	public static boolean reddir4 = true;
	public static boolean bluedir1 = true;
	public static boolean bluedir2 = true;
	public static boolean bluedir3 = true;
	
	public static boolean nextshoot = false;
	public static boolean nextshoot2 = false;
	
	public static boolean onfire1 = true;
	public static boolean onMonster = true;
	
	public static boolean shooting1 = false;
	public static boolean shooting2 = false;
	public static boolean shooting3 = false;
	
	public static boolean stopblock1 = true;
	public static boolean stopblock1_1 = true;
	public static boolean stopblock2 = true;
	public static boolean stopblock3 = true;
	
	GameMain gameMain;
	Clip background_sound;
	JButton End;
	
	int button_count=0;
	int button_count1=0;
	int button_count2=0;
	int button_count3=0;
	int button_count4=0;
	int button_count5=0;
	int button_count6=0;
	int button_count7=0;
	
	int shoot_count1 = 0;
	int shoot_count2 = 0;
	int shoot_count3 = 0;
	static int shoot_count4 = 0;
	int shoot_count5 = 0;
	static int shoot_count6 = 0;
	static int shoot_count7 = 0;
	
	int breakblock1 = 0;
	int breakblock2 = 0;
	int breakblock3 = 0;
	ImageIcon img_main = new ImageIcon("images/main_menu.png");
	static int monsterdrop1 = 0;
	
	public PlatformScene_Three(JFrame gameMain) { //������ ����
		//FlatformGameBoard.Isregame = false;
		initboolean();
		this.gameMain = (GameMain)gameMain;
		initBoard();
		stage = new StageThree();
		//move =new MoveCharacterKey();
		background = new Background();
		
		hero = new Character(75, 630, 40, 40);
		//hero = new Character(400, 500, 40, 40); // 100, 500
		
		hero_2p = new Character_2p(35, 630, 40, 40);
		//hero_2p = new Character_2p(400, 500, 40, 40); //100, 500
		
		//start();
		
		File file = new File("music/�������.wav"); // �������
		System.out.println(file.exists()); //true
		

		try {

			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			background_sound = AudioSystem.getClip();
			background_sound.open(stream);
			background_sound.start();
			
		} catch(Exception e) {

			//	e.printStackTrace();
		}       
		
	}
	//�������� MoveScene()�� �̿��ؼ� ����.
	private void initBoard() {
		move = new MoveCharacterKey();
		//musicSound();
		addKeyListener(move);
		setFocusable(true); // ������������ ���鶧 ������Ʈ���� ��Ŀ���� ��, ������Ʈ(c)�� ��Ŀ���� ���� �� �ֵ��� ����
		requestFocusInWindow(); // ������Ʈ(c)�� ��Ŀ�� ���� ����
		
	}
	
	public void initboolean() {
		jumping = false;
		falling = false;
		isJumping = false;
		leftMove = false;
		rightMove = false;
		upMove = false;
		onTop = false;
		checkleft = true; //----------------------------
		checkright = true; //----------------------------
		
		jumping_2p = false;
		falling_2p = false;
		isJumping_2p = false;
		leftMove_2p = false;
		rightMove_2p = false;
		upMove_2p = false;
		onTop_2p = false;
		checkleft_2p = true; //----------------------------
		checkright_2p = true; //----------------------------
		
		deltaY = 0;
		blockrightMoving = true;    // ��� ������
		onBottom = false;

		width = 0;
		height = 0;
		
		pushblock1 = false;

		onBlock1 = false;
		onBlock2 = false;
		onBlock3 = false;
		onBlock4 = false;
		outBlock1 = true;
		outBlock2 = true;
		moveBlock1 = false;
		moveBlock2 = false;
		moveBlock2_2 = false;
		moveBlock3 = false;
		moveBlock4 = false;
		moveBlock4_2 = false;
		moveBlock5 = false;
		
		monsterblock = true;
		monstermove = true;
		
		reddir1 = true;
		reddir2 = true;
		reddir3 = true;
		reddir4 = true;
		bluedir1 = true;
		bluedir2 = true;
		bluedir3 = true;
		
		nextshoot = false;
		nextshoot2 = false;
		
		onfire1 = true;
		onMonster = true;
		
		shooting1 = false;
		shooting2 = false;
		shooting3 = false;
		
		stopblock1 = true;
		stopblock1_1 = true;
		stopblock2 = true;
		stopblock3 = true;
		
		button_count=0;
		button_count1=0;
		button_count2=0;
		button_count3=0;
		button_count4=0;
		button_count5=0;
		button_count6=0;
		button_count7=0;
		
		shoot_count1 = 0;
		shoot_count2 = 0;
		shoot_count3 = 0;
		shoot_count4 = 0;
		shoot_count5 = 0;
		shoot_count6 = 0;
		shoot_count7 = 0;
		
		breakblock1 = 0;
	    breakblock2 = 0;
		breakblock3 = 0;
		
		monsterdrop1 = 0;
	}
	
	public void start() {
		//System.out.println("asdqwe");
		while (true) {
			//System.out.println("����������������������������");
				updateLocation();
				try {
					Thread.sleep(11); // 10
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				repaint();

				checkCollision();
				roadBlocked();
				
				if(GameMain.Isgameover)
					break;
			
		}
	}

	@Override // paintComponent �� ��� JComonent�� �ִ�
	public void paintComponent(Graphics g) { // ���α���, ���α��� �޾Ƽ�, ������ ��ü ȣ��
		super.paintComponent(g); // JPanel�� ������ paintComponent() ȣ�� -> �ڱ� �ڽ��� �׸���...
		width = this.getWidth(); // JPanel�� width, height��?
		height = this.getHeight();

		background.draw(g);
		stage.draw(g);
		
		hero.draw(g); // �׷��ֱ�.
		hero_2p.draw(g);
	}
	

	public void updateLocation() { // ȭ�鿡 �ִ� ��ü����...
		hero.updateLocation(); //
		hero_2p.updateLocation();
	}

	public boolean checkCollision() { // �浹 üũ
		boolean collision = false;
		
		checkOnTop();
		checkOnBotton();
		checkOnLeft();
		checkOnRight();
		checkOnAll();
		
		dropmonster();
		shoot_attack();
		shoot_attack2();
		shoot_attack3();
		fire_check();
		checkobstacle();
		breakblock();
		diebyshooting();
		nextstage();
		
		checkOnTop_2p();
		checkOnBotton_2p();
		checkOnLeft_2p();
		checkOnRight_2p();
		checkOnAll_2p();
		
		/*if (!checkOnTop()) {
			for (GameObject r : stage.block) {
				if (hero.getBound().intersects(r.getBound())) {
					collision = true;
				}
			}
		}*/
		
		return collision;
	}
	
	public void nextstage() {  // ���� ���������� �Ѿ ����... �̰� �³�?
		End = new JButton(img_main);
		End.setLocation(360,600);
		End.setSize(300,100);
		
		End.setBorderPainted(false);	
		End.setContentAreaFilled(false);
		End.setFocusPainted(false);
		End.addActionListener(new MyActionLister(gameMain));

		if(hero.getBound().intersects(stage.door_block.get(2).getobstacle()) && hero_2p.getBound().intersects(stage.door_block.get(3).getobstacle())) {
			if(reddir1 == false && reddir2 == false && reddir3 == false && reddir4 == false && bluedir1 == false && bluedir2 == false && bluedir3 == false) {
			try {
				background_sound.stop();
			}catch(Exception a) {}
				GameMain.Isgameover = true;
				add(End);

			}

		}


	}

	class MyActionLister implements ActionListener {  // ���� ���������� ���� ����
		JFrame frame;

		public MyActionLister(JFrame frame) {
			this.frame = frame;
		}

		public void actionPerformed(ActionEvent e) {	
			gameMain.showInitialPanel();
		}
	}
	public void checkOnAll() {
		for(GameObject r : stage.dia) {
			if(hero.getBound().intersects(r.getBound())) {
				if(r == stage.dia.get(0)) {
					reddir1 = false;
				}
				
				if(r == stage.dia.get(2)) {
					reddir2 = false;
				}
				
				if(r == stage.dia.get(4)) {
					reddir3 = false;
				}
				
				if(r == stage.dia.get(5)) {
					reddir4 = false;
				}
				
			}
			
			
		}
	}
	
	public void breakblock() {
		for(GameObject r : stage.stopblock) {
			if(stage.block.get(19).getBound().intersects(r.getLeftBound())) {
				if(r == stage.stopblock.get(0)) { 
					stopblock1 = false;
					
					breakblock1 += 1;
					if(breakblock1 == 1)
						break_blockSound();
				}
				else
					breakblock1 = 0;
					
				if(r == stage.stopblock.get(1)) {
					stopblock2 = false;
					
					breakblock2 += 1;
					if(breakblock2 == 1)
						break_blockSound();
				}
				else
					breakblock2 = 0;

				if(r == stage.stopblock.get(2)) {
					stopblock3 = false;
					
					breakblock3 += 1;
					if(breakblock3 == 1)
						break_blockSound();
				}
				else
					breakblock3 = 0;

			}
		}
		
		for(GameObject r : stage.stopblock) {
			if(stopblock1 == true && hero.getRightBound().intersects(stage.stopblock.get(0).getLeftBound()))
				rightMove = false;
			
			if(stopblock2 == true && hero.getRightBound().intersects(stage.stopblock.get(1).getLeftBound()))
				rightMove = false;
			
			if(stopblock3 == true && hero.getRightBound().intersects(stage.stopblock.get(2).getLeftBound()))
				rightMove = false;
		/*-----------------------------------------------------------------------------------------------------*/ //??????????????????????????????????????????????
			if(stopblock1 == true && hero_2p.getRightBound().intersects(stage.stopblock.get(0).getLeftBound()))
				rightMove_2p = false;
			
			if(stopblock2 == true && hero_2p.getRightBound().intersects(stage.stopblock.get(1).getLeftBound()))
				rightMove_2p = false;
			
			if(stopblock3 == true && hero_2p.getRightBound().intersects(stage.stopblock.get(2).getLeftBound()))
				rightMove_2p = false;
		}		
		
	}
	
	public void checkobstacle(){
		for(GameObject r : stage.obstacle) {
			if(hero.getBound().intersects(r.getobstacle())) {
				try {
					background_sound.stop();
				}catch(Exception a) {}
				gameMain.showGameOver3Panel();
				gameOverSound();
			}
		}
		/*---------------------------------------------------------------------*/
		
		for(GameObject r : stage.obstacle) {
			if(hero_2p.getBound().intersects(r.getobstacle())) {
				try {
					background_sound.stop();
				}catch(Exception a) {}
				gameMain.showGameOver3Panel();
				gameOverSound();
			}
		}
	}
	
	public void dropmonster() { // x:280 , y:380 ���� 
		if(hero.getX() <= 280 && hero.getY() >= 370 && hero.getY() <=390 || hero_2p.getX() <= 280 && hero_2p.getY() >= 370 && hero_2p.getY() <=390) {
			monsterblock = false;
		}
		stage.updatemonsterBlock();

		
		
		for(GameObject r : stage.monster) {
			if(r == stage.monster.get(1)) {
				if(hero.getBound().intersects(r.getobstacle())) {
					try {
						background_sound.stop();
					}catch(Exception a) {}
					gameMain.showGameOver3Panel();
					gameOverSound();
					
				}
			
				if(hero_2p.getBound().intersects(r.getobstacle())) {
					try {
						background_sound.stop();
					}catch(Exception a) {}
					gameMain.showGameOver3Panel();
					gameOverSound();
				}
			}
		}
		
	}
	
	public void diebyshooting() {
		for(GameObject r : stage.shoot_block) {
			if(hero.getBound().intersects(r.getobstacle())) {
				try {
					background_sound.stop();
				}catch(Exception a) {}
				gameMain.showGameOver3Panel();
				gameOverSound();
				
			}
			if(hero_2p.getBound().intersects(r.getobstacle())) {
				try {
					background_sound.stop();
				}catch(Exception a) {}
				gameMain.showGameOver3Panel();
				gameOverSound();
			}
		}
	}
	
	public void shoot_attack() { // �̻���
		if(onBlock2 == true) { 
			stage.updateshoot_block();
			shoot_count5 += 1;
			if(shoot_count5 == 1)
				shootingSound();
		}
		else
			shoot_count5 = 0;
		
	}
	
	public void shoot_attack2() { // �̻���2
		if(reddir2 == false) {
			stage.updateshoot_block2();
		}
		
	}
	
	public void shoot_attack3() {
		if(shooting1 == true) {
			stage.updateshooting();
			shoot_count1 += 1;
			if(shoot_count1 == 1)
				shootingSound();
		}
		else
			shoot_count1 = 0;
		
		if(shooting2 == true) {
			stage.updateshooting2();
			shoot_count2 += 1;
			if(shoot_count2 == 1)
				shootingSound();
			
		}
		else
			shoot_count2 = 0;
		
		if(shooting3 == true) {
			stage.updateshooting3();
			shoot_count3 += 1;
			if(shoot_count3 == 1)
				shootingSound();
		}
		else
			shoot_count3 = 0;
	}
	
	public void fire_check(){ // ȭ��
		for(GameObject r : stage.fire_block) {
			if(hero.getBound().intersects(r.getBound())) {
				try {
					background_sound.stop();
				}catch(Exception a) {}
				gameMain.showGameOver3Panel();
				gameOverSound();
			}
			
			if(hero_2p.getBound().intersects(r.getBound())) {
				try {
					background_sound.stop();
				}catch(Exception a) {}
				gameMain.showGameOver3Panel();
				gameOverSound();
			}
		}
		
		if(stage.block.get(19).getBound().intersects(stage.fire_block.get(0).getBound())) {
			onfire1 = false;
		}
		
		if(stage.monster.get(1).getBottomBound().intersects(stage.fire_block.get(1).getTopBound())) {
			onMonster = false;
		}
	}
	
	public void checkOnTop() {
		//onTop = false;
		for (GameObject r : stage.block) {
			if (hero.getBottomBound().intersects(r.getTopBound())) {
				falling = false;
				isJumping = false; 
				
				if(r == stage.block.get(8)) { // ��� ����1
					stage.updateLocation();
					if((stage.block.get(8).y >= 570))
						hero.setY(stage.block.get(8).y - 39);
				}
				
				if(r == stage.block.get(14)) { // ��� ����2
					moveBlock2 = true;
					if((stage.block.get(14).y >= 420))
						hero.setY(stage.block.get(14).y - 39);
				}
				else
					moveBlock2 = false;
				
				
				if(r == stage.block.get(15)) { //��Ÿ����2(������)
					StageThree.push_block2 = StageThree.pushblock2_2.getImage();
					outBlock1 = false;
					button_count1 +=1;
					if(button_count1==1) {
						buttonSound();
					}
					
				}
				else {
					button_count1 = 0;
					StageThree.push_block2 = StageThree.pushblock2_1.getImage();
				}
				
				
				if(r == stage.block.get(21)) { // ��Ÿ����4
					StageThree.push_block4 = StageThree.pushblock4_2.getImage();
					onBlock2 = true;
					button_count3 +=1;
					if(button_count3==1) {
						buttonSound();
					}
					
				}
				else {
					button_count3 = 0;
					StageThree.push_block4 = StageThree.pushblock4_1.getImage();
				}
				
				if(r == stage.block.get(26))
					if(moveBlock4_2) {
						hero.y = stage.block.get(26).y - 39;
					}
				
				if(r == stage.block.get(22)) { //������5
					onBlock3 = true;
				}
				else {
					StageThree.push_block5 = StageThree.pushblock5_1.getImage();
				}
				
				
				break;
			}
		}
		
		for (GameObject r : stage.appear_block) {
			if (onBlock1 == true && hero.getBottomBound().intersects(r.getTopBound())) {			
				falling = false;
				isJumping = false; // �߰��� �ڵ�
				break;
			}
		}
		
		for (GameObject r : stage.appear_block2) {
			if (onBlock2 == true && hero.getBottomBound().intersects(r.getTopBound())) {			
				falling = false;
				isJumping = false; // �߰��� �ڵ�
				break;
			}
		}
		
		
		
		
	}
	
	public void checkOnBotton() {
		for (GameObject r : stage.block) {
			if (hero.getTopBound().intersects(r.getBottomBound())) { 
				jumping = false;	
				Character.dy = 0;
				break;
			}
		}	
		
		for (GameObject r : stage.appear_block2) {
			if (onBlock2 == true && hero.getTopBound().intersects(r.getBottomBound())) { 
				jumping = false;	
				Character.dy = 0;
				break;
			}
		}	
		
	}
	
	public void checkOnLeft() {
		for (GameObject r : stage.block) {
			if (!(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getRightBound().intersects(r.getLeftBound())) { 
				//��, �� üũ ������ ũ�� �س��� ������ onTop, onBottom�ϋ��� ���ǹ��� �߰�
				//rightMove = false;		
				checkright = false;
				
				if(r == stage.block.get(19)) {
					if(stage.block.get(19).getX() <= 760) {
						stage.block.get(19).setX(stage.block.get(19).getX()+5);
						if(stage.block.get(19).getX() == 760) {
							moveBlock3 = true;
							stage.updateLocation();
							}
					}
				}

				break;
			}
			else
				checkright = true;
		}	
		
		for (GameObject r : stage.appear_block) {
			if (onBlock1 == true && !(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getRightBound().intersects(r.getLeftBound())) { 
				//��, �� üũ ������ ũ�� �س��� ������ onTop, onBottom�ϋ��� ���ǹ��� �߰�
				//rightMove = false;	
				checkright = false;
				break;
			}

		}	
		
		for (GameObject r : stage.appear_block2) {
			if (onBlock2 == true && !(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getRightBound().intersects(r.getLeftBound())) { 
				//��, �� üũ ������ ũ�� �س��� ������ onTop, onBottom�ϋ��� ���ǹ��� �߰�
				//rightMove = false;		
				checkright = false;
				break;
			}

		}	
		
		
		// 2���� ��ϰ� 3���� ��� arraylist ����... �ϳ��� �ϸ� �̻��ϰ� �ȵ�
		for (GameObject r : stage.out_block1) { // �������� �����̱� ����
			if (outBlock1 == true && !(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getRightBound().intersects(r.getLeftBound())) { 
				//��, �� üũ ������ ũ�� �س��� ������ onTop, onBottom�ϋ��� ���ǹ��� �߰�
				//rightMove = false;	
				checkright = false;
				break;
			}

		}		
		
		// 2���� ��ϰ� 3���� ��� arraylist ����... �ϳ��� �ϸ� �̻��ϰ� �ȵ�
		for (GameObject r : stage.out_block2) { // �������� �����̱� ����
			if (outBlock2 == true && !(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getRightBound().intersects(r.getLeftBound())) { 
				//��, �� üũ ������ ũ�� �س��� ������ onTop, onBottom�ϋ��� ���ǹ��� �߰�
				//rightMove = false;
				checkright = false;
				break;
			}

		}	
		

	}
	
	public void checkOnRight() {
		for (GameObject r : stage.block) {
			if (!(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getLeftBound().intersects(r.getRightBound())) {
				//��, �� üũ ������ ũ�� �س��� ������ onTop, onBottom�ϋ��� ���ǹ��� �߰�
				//leftMove = false;
				checkleft = false;

				break;
			}
			else
				checkleft = true;
		}	
		
		for (GameObject r : stage.appear_block) {
			if (onBlock1 == true &&!(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getLeftBound().intersects(r.getRightBound())) {
				//��, �� üũ ������ ũ�� �س��� ������ onTop, onBottom�ϋ��� ���ǹ��� �߰�
				//leftMove = false;
				checkleft = false;
				break;
			}
		}	
		
		for (GameObject r : stage.appear_block2) {
			if (onBlock2 == true &&!(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getLeftBound().intersects(r.getRightBound())) {
				//��, �� üũ ������ ũ�� �س��� ������ onTop, onBottom�ϋ��� ���ǹ��� �߰�
				//leftMove = false;
				checkleft = false;
				break;
			}
		}	
		
		for (GameObject r : stage.out_block1) { // ��� �������� �����̱� ����
			if (outBlock1 == true && !(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getLeftBound().intersects(r.getRightBound())) {
				//��, �� üũ ������ ũ�� �س��� ������ onTop, onBottom�ϋ��� ���ǹ��� �߰�				
				//leftMove = false;
				checkleft = false;
				break;
			}
		}	
		
		// 2���� ��ϰ� 3���� ��� arraylist ����... �ϳ��� �ϸ� �̻��ϰ� �ȵ�
		for (GameObject r : stage.out_block2) { // ��� �������� �����̱� ����
			if (outBlock2 == true && !(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getLeftBound().intersects(r.getRightBound())) {
				//��, �� üũ ������ ũ�� �س��� ������ onTop, onBottom�ϋ��� ���ǹ��� �߰�				
				//leftMove = false;
				checkleft = false;
				break;
			}
		}	
	}

	public void roadBlocked() { // �浹 üũ -> collision�� true �̸� setX(0)
		if (checkCollision()) {
			//
			// �浹 ����� ��� �ڵ�
			//
			//hero.setX(0);
		}


	}
	
	/*-------------------------------------------------------------------------------�Ʒ� ���� 2p ����ڿ� ���� �浹 �ɼ�-----------------------------------------------------------------------------------*/
	
	
	public void checkOnAll_2p() {
		for(GameObject r : stage.dia) {
			if(hero_2p.getBound().intersects(r.getBound())) {
				if (r == stage.dia.get(1)) {
					bluedir1 = false;
					point ++;
				}
				
				if (r == stage.dia.get(3)) {
					bluedir2 = false;
					point ++;
				}
				
				if (r == stage.dia.get(6)) {
					bluedir3 = false;
					point ++;
				}
				
			}
		}
	}

	public void checkOnTop_2p() {
		//onTop = false;
		for (GameObject r : stage.block) {
			if (hero_2p.getBottomBound().intersects(r.getTopBound())) {
				falling_2p = false;
				isJumping_2p = false; 
				
				if(r == stage.block.get(8)) { // ��� ����1
					moveBlock1 = true;
					stage.updateLocation();
					if(stage.block.get(8).y >= 570) 
						hero_2p.setY(stage.block.get(8).y - 39);
				}
				moveBlock1 = false;
				
				if(r == stage.block.get(14)) { // ��� ����2
					moveBlock2_2 = true;
					stage.updatemoveBlock2();
					if((stage.block.get(14).y >= 420))
						hero_2p.setY(stage.block.get(14).y - 39);
				}
				else
					moveBlock2_2 = false;
				
				
				if(r == stage.block.get(9)) { //��� ��Ÿ����1
					StageThree.push_block1 = StageThree.pushblock1_2.getImage();
					onBlock1 = true;
					
					button_count +=1;
					if(button_count==1) {
						buttonSound();
					}
					
					
				}
				else {
					button_count = 0;
					StageThree.push_block1 = StageThree.pushblock1_1.getImage();
				}
				
				
				if(r == stage.block.get(20)) { //��Ÿ����3(������)
					StageThree.push_block3 = StageThree.pushblock3_2.getImage();
					outBlock2 = false;
					button_count2 +=1;
					if(button_count2==1) {
						buttonSound();
					}
					
				}
				else {
					button_count2 = 0;
					StageThree.push_block3 = StageThree.pushblock3_1.getImage();
				}
				
				if(r == stage.block.get(27)) { // ��� ����4
					moveBlock4 = true;
					stage.updatemoveBlock4();
					hero_2p.y = stage.block.get(27).y - 39;
				}
				else {
					moveBlock4 = false;
					moveBlock4_2 = true; //ĳ���͵� ���� �����̱� ����
					stage.updatemoveBlock4();
				}
				
				if(r == stage.block.get(28)) { //��Ÿ����5(������)
					StageThree.push_block5 = StageThree.pushblock5_2.getImage();
					moveBlock5 = true;
					stage.updatemoveBlock5();
					button_count4 +=1;
					if(button_count4==1) {
						buttonSound();
					}
					
				}
				else {
					button_count4 = 0;
					StageThree.push_block5 = StageThree.pushblock5_1.getImage();
				}
				
				if(r == stage.block.get(37)) {
					shooting3 = true;
					
					button_count7 +=1;
					if(button_count7==1) {
						buttonSound();
					}
				}
				else
					button_count7 = 0;
				
				
				break;
			}
			
			
		}
		
		for (GameObject r : stage.appear_block) {
			if (onBlock1 == true && hero_2p.getBottomBound().intersects(r.getTopBound())) {			
				falling_2p = false;
				isJumping_2p = false; // �߰��� �ڵ�
				break;
			}
		}
		
		for (GameObject r : stage.appear_block2) {
			if (onBlock2 == true && hero_2p.getBottomBound().intersects(r.getTopBound())) {			
				falling_2p = false;
				isJumping_2p = false; // �߰��� �ڵ�
				break;
			}
		}
		
		for (GameObject r : stage.appear_block3) {
			if (onBlock3 == true && hero_2p.getBottomBound().intersects(r.getTopBound())) {			
				falling_2p = false;
				isJumping_2p = false; // �߰��� �ڵ�
				break;
			}
		}
		
		
		
	}
	
	public void checkOnBotton_2p() {
		for (GameObject r : stage.block) {
			if (hero_2p.getTopBound().intersects(r.getBottomBound())) { 
				jumping_2p = false;	
				Character_2p.dy_2p = 0;
				
				if(r == stage.block.get(35)) { 
					shooting1 = true;
					
					button_count5 +=1;
					if(button_count5==1) {
						buttonSound();
					}
				}
				else
					button_count5 = 0;
				
				if(r == stage.block.get(36)) {
					shooting2 = true;
					
					button_count6 +=1;
					if(button_count6==1) {
						buttonSound();
					}
				}
				else
					button_count6 = 0;
				
				
				break;
			}
		}	
		
		for (GameObject r : stage.appear_block3) {
			if (onBlock3 == true && hero_2p.getTopBound().intersects(r.getBottomBound())) { 
				jumping_2p = false;	
				Character_2p.dy_2p = 0;
				//falling = true;
				break;
			}
		}	
		
		for (GameObject r : stage.appear_block2) {
			if (onBlock2 == true && hero_2p.getTopBound().intersects(r.getBottomBound())) { 
				jumping_2p = false;	
				Character_2p.dy_2p = 0;
				//falling = true;
				break;
			}
		}	
		
		
	}
	
	public void checkOnLeft_2p() {
		for (GameObject r : stage.block) {
			if (!(hero_2p.getBottomBound().intersects(r.getTopBound())) && !(hero_2p.getTopBound().intersects(r.getBottomBound())) && hero_2p.getRightBound().intersects(r.getLeftBound())) { 
				//��, �� üũ ������ ũ�� �س��� ������ onTop, onBottom�ϋ��� ���ǹ��� �߰�
				//rightMove_2p = false;
				checkright_2p = false;
				
				if(r == stage.block.get(19)) {
					if(stage.block.get(19).getX() <= 760) {
						stage.block.get(19).setX(stage.block.get(19).getX()+5);
						if(stage.block.get(19).getX() == 760) {
							moveBlock3 = true;
							stage.updateLocation();
							}
					}
				}

				break;
			}
			else
				checkright_2p = true;
		}	
		
		
		for (GameObject r : stage.appear_block) {
			if (onBlock1 == true && !(hero_2p.getBottomBound().intersects(r.getTopBound())) && !(hero_2p.getTopBound().intersects(r.getBottomBound())) && hero_2p.getRightBound().intersects(r.getLeftBound())) { 
				//��, �� üũ ������ ũ�� �س��� ������ onTop, onBottom�ϋ��� ���ǹ��� �߰�
				//rightMove_2p = false;		
				checkright_2p = false;
				break;
			}

		}	
		
		for (GameObject r : stage.appear_block2) {
			if (onBlock2 == true && !(hero_2p.getBottomBound().intersects(r.getTopBound())) && !(hero_2p.getTopBound().intersects(r.getBottomBound())) && hero_2p.getRightBound().intersects(r.getLeftBound())) { 
				//��, �� üũ ������ ũ�� �س��� ������ onTop, onBottom�ϋ��� ���ǹ��� �߰�
				//rightMove_2p = false;	
				checkright_2p = false;
				break;
			}

		}	
		
		
		
		
		// 2���� ��ϰ� 3���� ��� arraylist ����... �ϳ��� �ϸ� �̻��ϰ� �ȵ�
		for (GameObject r : stage.out_block1) { // �������� �����̱� ����
			if (outBlock1 == true && !(hero_2p.getBottomBound().intersects(r.getTopBound())) && !(hero_2p.getTopBound().intersects(r.getBottomBound())) && hero_2p.getRightBound().intersects(r.getLeftBound())) { 
				//��, �� üũ ������ ũ�� �س��� ������ onTop, onBottom�ϋ��� ���ǹ��� �߰�
				//rightMove_2p = false;		
				checkright_2p = false;
				break;
			}

		}		
		
		// 2���� ��ϰ� 3���� ��� arraylist ����... �ϳ��� �ϸ� �̻��ϰ� �ȵ�
		for (GameObject r : stage.out_block2) { // �������� �����̱� ����
			if (outBlock2 == true && !(hero_2p.getBottomBound().intersects(r.getTopBound())) && !(hero_2p.getTopBound().intersects(r.getBottomBound())) && hero_2p.getRightBound().intersects(r.getLeftBound())) { 
				//��, �� üũ ������ ũ�� �س��� ������ onTop, onBottom�ϋ��� ���ǹ��� �߰�
				//rightMove_2p = false;	
				checkright_2p = false;
				break;
			}

		}	
		
		for (GameObject r : stage.appear_block3) { // �������� �����̱� ����
			if (onBlock3 == true && !(hero_2p.getBottomBound().intersects(r.getTopBound())) && !(hero_2p.getTopBound().intersects(r.getBottomBound())) && hero_2p.getRightBound().intersects(r.getLeftBound())) { 
				//��, �� üũ ������ ũ�� �س��� ������ onTop, onBottom�ϋ��� ���ǹ��� �߰�
				//rightMove_2p = false;		
				checkright_2p = false;
				break;
			}

		}	

	}
	
	public void checkOnRight_2p() {
		for (GameObject r : stage.block) {
			if (!(hero_2p.getBottomBound().intersects(r.getTopBound())) && !(hero_2p.getTopBound().intersects(r.getBottomBound())) && hero_2p.getLeftBound().intersects(r.getRightBound())) {
				//��, �� üũ ������ ũ�� �س��� ������ onTop, onBottom�ϋ��� ���ǹ��� �߰�
				//leftMove_2p = false;
				checkleft_2p = false;
				
				break;
			}
			else
				checkleft_2p = true;
		}	
		
		
		for (GameObject r : stage.appear_block) {
			if (onBlock1 == true &&!(hero_2p.getBottomBound().intersects(r.getTopBound())) && !(hero_2p.getTopBound().intersects(r.getBottomBound())) && hero_2p.getLeftBound().intersects(r.getRightBound())) {
				//��, �� üũ ������ ũ�� �س��� ������ onTop, onBottom�ϋ��� ���ǹ��� �߰�
				//leftMove_2p = false;
				checkleft_2p = false;
				break;
			}
		}	
		
		for (GameObject r : stage.appear_block2) {
			if (onBlock2 == true &&!(hero_2p.getBottomBound().intersects(r.getTopBound())) && !(hero_2p.getTopBound().intersects(r.getBottomBound())) && hero_2p.getLeftBound().intersects(r.getRightBound())) {
				//��, �� üũ ������ ũ�� �س��� ������ onTop, onBottom�ϋ��� ���ǹ��� �߰�
				//leftMove_2p = false;
				checkleft_2p = false;
				break;
			}
		}	
		
		for (GameObject r : stage.out_block1) { // ��� �������� �����̱� ����
			if (outBlock1 == true && !(hero_2p.getBottomBound().intersects(r.getTopBound())) && !(hero_2p.getTopBound().intersects(r.getBottomBound())) && hero_2p.getLeftBound().intersects(r.getRightBound())) {
				//��, �� üũ ������ ũ�� �س��� ������ onTop, onBottom�ϋ��� ���ǹ��� �߰�				
				//leftMove_2p = false;
				checkleft_2p = false;
				break;
			}
		}	
		
		// 2���� ��ϰ� 3���� ��� arraylist ����... �ϳ��� �ϸ� �̻��ϰ� �ȵ�
		for (GameObject r : stage.out_block2) { // ��� �������� �����̱� ����
			if (outBlock2 == true && !(hero_2p.getBottomBound().intersects(r.getTopBound())) && !(hero_2p.getTopBound().intersects(r.getBottomBound())) && hero_2p.getLeftBound().intersects(r.getRightBound())) {
				//��, �� üũ ������ ũ�� �س��� ������ onTop, onBottom�ϋ��� ���ǹ��� �߰�				
				//leftMove_2p = false;
				checkleft_2p = false;
				break;
			}
		}	
		
		for (GameObject r : stage.appear_block3) { // ��� �������� �����̱� ����
			if (onBlock3 == true && !(hero_2p.getBottomBound().intersects(r.getTopBound())) && !(hero_2p.getTopBound().intersects(r.getBottomBound())) && hero_2p.getLeftBound().intersects(r.getRightBound())) {
				//��, �� üũ ������ ũ�� �س��� ������ onTop, onBottom�ϋ��� ���ǹ��� �߰�				
				//leftMove_2p = false;
				checkleft_2p = false;
				break;
			}
		}	
	}

	public void roadBlocked_2p() { // �浹 üũ -> collision�� true �̸� setX(0)
		if (checkCollision()) {
			//
			// �浹 ����� ��� �ڵ�
			//
			//hero.setX(0);
		}


	}
	
	public void musicSound() {

	      File file = new File("music/map_start.wav");
	      try {

	         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
	         Clip clip = AudioSystem.getClip();
	         clip.open(stream);
	         clip.start();

	      } catch(Exception e) {

	       //  e.printStackTrace();
	      }       
	   }
	
	public void sound(File file) {
	      try {
	    	  
	         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
	         Clip clip = AudioSystem.getClip();
	         clip.open(stream);
	        	 clip.start();

	      } catch(Exception e1) {
	      //   e1.printStackTrace();
	      }  
	}
	
	static public void diaSound() {
		File file = new File("music/dia.wav");
		System.out.println(file.exists()); //true
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();

		} catch(Exception e) {

			//	e.printStackTrace();
		}
	}
	static public void gameOverSound() {
		File file = new File("music/gameover.wav");
		System.out.println(file.exists()); //true
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();


		} catch(Exception e) {

			//e.printStackTrace();
		}

	}
	
	static public void buttonSound() {
		File file = new File("music/button.wav");
		System.out.println(file.exists()); //true
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();

		} catch(Exception e) {

			//e.printStackTrace();
		}
	}
	
	static public void shootingSound() {
		File file = new File("music/��ֹ�-������.wav");
		System.out.println(file.exists()); //true
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();

		} catch(Exception e) {

			//e.printStackTrace();
		}
	}
	
	static public void break_blockSound() {
		File file = new File("music/move_block.wav");
		System.out.println(file.exists()); //true
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();

		} catch(Exception e) {

			//e.printStackTrace();
		}
	}
	
	static public void monsterdropSound() {
		File file = new File("music/��ֹ�-����.wav");
		System.out.println(file.exists()); //true
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();

		} catch(Exception e) {

			//e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub		
		start();
	}
	/*File file = new File("music/��ư�����¼Ҹ�.wav");	 
	sound(file);*/
	
}