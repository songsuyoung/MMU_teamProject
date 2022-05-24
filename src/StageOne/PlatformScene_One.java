package StageOne;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

import StageThree.Character;
import StageThree.GameMain;
import StageThree.GameObject;
import StageThree.PlatformScene_Three;
import StageTwo.PlatformScene_Two;

public class PlatformScene_One extends JPanel implements Runnable{ //flatform게임의 바탕이 될 class

	MoveCharacterKey move = null;
	
	static CharacterObject hero; 
	static CharacterObject hero2;
	
	JButton next;
	Thread th;
	//StageThree stage2;
	//StageOne stage1;
	StageOne stageone;
	
	ImageIcon img = new ImageIcon("images/next_stage.png");
	public static boolean checkleft = true;
	public static boolean checkright = true;
	
	public static boolean jumping = false;
	public static boolean falling = false;
	public static boolean isJumping = false;
	public static boolean leftMove = false;
	
	public static boolean rightMove = false;
	public static boolean upMove = false;
	public static boolean onTop = false;
	public static int deltaY = 0;
	public static boolean blockrightMoving = true;    // 블록 움직임
	public static boolean onBottom = false;
	public static int width = 0;
	public static int height = 0;
	
	public static boolean Cloud_rightmoving = false;
	public static boolean Cloud2_rightmoving = false;
	
	public static boolean swingblock_Moving = false;
	public static boolean swingblock_Moving2p = false;
	public static boolean checkswingblockTop = false;
	public static boolean checkswingblockTop2p = false;
	
	//----------------------------------------------------------
	public static boolean swingblock_collins1p = false;
	public static boolean swingblock_collins2p = false;
	public static boolean end_1p =false;
	public static boolean end_2p =false;
	//-----------------------------------------------------
	public static boolean is_clocking1 = false;
	public static boolean is_clocking2 = false;
	public static boolean is_clocking3 = false;
	//--------------------------------------------
	
	public static boolean bluebutton_collins = false;
	public static boolean redbutton_collins = false;
	

	
	//----------------------------------------------
	//public static boolean up = false;
	
	public static boolean jumping_2p = false;
	public static boolean falling_2p = false;
	public static boolean isJumping_2p = false;
	public static boolean leftMove_2p = false;
	public static boolean rightMove_2p = false;
	public static boolean upMove_2p = false;
	public static boolean onTop_2p = false;
	public static boolean checkleft_2p = true; //----------------------------
	public static boolean checkright_2p = true; //----------------------------
	
	public static boolean reddir1 = true; //----------------------------
	public static boolean reddir2 = true; //----------------------------
	public static boolean bluedir1 = true; //----------------------------
	public static boolean bluedir2 = true; //----------------------------
	public static int check_sound=0;
	public static int check_sound1=0;
	int button_count1=0;
	int button_count2=0;
	
	Clip background_sound;
	
	GameMain gameMain;
	public PlatformScene_One(JFrame gameMain) { //생성자 생성
		this.gameMain = (GameMain)gameMain;
		initboolean();
		initBoard();
		//stage1 = new StageOne();
		stageone = new StageOne();
		move =new MoveCharacterKey();
		
		hero = new Character_1p(280, 680, 40, 40);
		hero2 = new Character_2p(720, 680, 40, 40);
		
		File file = new File("music/opening.wav");
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
	//교수님의 MoveScene()을 이용해서 만듬.
	private void initBoard() {
		move = new MoveCharacterKey();
		addKeyListener(move);
		setFocusable(true); // 스윙프레임을 만들때 컴포넌트에게 포커스를 줌, 컴포넌트(c)가 포커스를 받을 수 있도록 설정
		requestFocusInWindow(); // 컴포넌트(c)에 포커스 강제 지정
	}
	
	public void initboolean() {
		checkleft = true;
		checkright = true;
		button_count1=0;
		jumping = false;
		falling = false;
		isJumping = false;
		leftMove = false;
		button_count2=0;
		rightMove = false;
		upMove = false;
		onTop = false;
		deltaY = 0;
		blockrightMoving = true;    // 블록 움직임
		onBottom = false;
		width = 0;
		height = 0;
		check_sound1=0;
		check_sound=0;
		Cloud_rightmoving = false;
		Cloud2_rightmoving = false;
		
		swingblock_Moving = false;
		swingblock_Moving2p = false;
		checkswingblockTop = false;
		checkswingblockTop2p = false;
		
		//----------------------------------------------------------
		swingblock_collins1p = false;
		swingblock_collins2p = false;
		end_1p =false;
		end_2p =false;
		//-----------------------------------------------------
		is_clocking1 = false;
		is_clocking2 = false;
		is_clocking3 = false;
		//--------------------------------------------
		
		bluebutton_collins = false;
		redbutton_collins = false;
		
		reddir1 = true; //----------------------------
		reddir2 = true; //----------------------------
		bluedir1 = true; //----------------------------
		bluedir2 = true; //----------------------------
		

		
		//----------------------------------------------
		//public static boolean up = false;
		
		jumping_2p = false;
		falling_2p = false;
		isJumping_2p = false;
		leftMove_2p = false;
		rightMove_2p = false;
		upMove_2p = false;
		onTop_2p = false;
		checkleft_2p = true; //----------------------------
		checkright_2p = true; //----------------------------
	}

	public void start() {
		//System.out.println("asdqwe");
		while (true) {
			//System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
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
	@Override // paintComponent 는 모든 JComonent에 있다
	public void paintComponent(Graphics g) { // 가로길이, 세로길이 받아서, 각각의 객체 호출
		super.paintComponent(g); // JPanel에 구현된 paintComponent() 호출 -> 자기 자신을 그린다...
		width = this.getWidth(); // JPanel의 width, height값?
		height = this.getHeight();
		stageone.draw(g);
		
		hero.draw(g); // 그려주기.
		hero2.draw(g);
	}

	public void updateLocation() { // 화면에 있는 객체들의...
		hero.updateLocation(); //
		hero2.updateLocation();
	}

	public boolean checkCollision() { // 충돌 체크
		boolean collision = false;
		
		checkOnTop();
		checkOnBotton();
		checkOnLeft();
		checkOnRight();
		checkswingblockTop();
		checkobstacle();
		
		checkOnTop_2p();
		checkOnBotton_2p();
		checkOnLeft_2p();
		checkOnRight_2p();
		checkswingblockTop_2p();
		checkOnAll();
		nextstage();
		
		stageone.updatecloudblock();
		stageone.updatecloudblock2();
		stageone.updatecloudblock3();
		stageone.updatecloudblock4();
		stageone.updatecloudblock5();
		//stage2.updatecloudblock4();
		
		/*if (!checkOnTop()) {
			for (GameObject r : stage.block) {
				if (hero.getBound().intersects(r.getBound())) {
					collision = true;
				}
			}
		}*/
		
		return collision;
	}
	
	public void nextstage() {  // 다음 스테이지로 넘어갈 조건... 이게 맞나?
		next = new JButton(img);
		next.setLocation(270,560);
		next.setSize(500,200);
		next.setBorderPainted(false);	
		next.setContentAreaFilled(false);
		next.setFocusPainted(false);
		next.requestFocusInWindow();
		next.addActionListener(new MyActionLister(gameMain));
		
		if(hero.getBound().intersects(stageone.door.get(0).getobstacle()) && hero2.getBound().intersects(stageone.door.get(1).getobstacle())) {
				if(reddir1 == false && reddir2 == false && bluedir1 == false && bluedir2 == false) {
					try {
						background_sound.stop();
					}catch(Exception a) {}
					
					GameMain.Isgameover = true;
					add(next);
				}
		}
	
	}
	
	class MyActionLister implements ActionListener {  // 다음 스테이지로 가기 위함
		JFrame frame;
		
		public MyActionLister(JFrame frame) {
			this.frame = frame;
		}
		
		public void actionPerformed(ActionEvent e) {	
			GameMain.Isgameover = false;
			PlatformScene_Two p2 = new PlatformScene_Two(frame);
			th = new Thread(p2);
			gameMain.contentPane.add(p2, "p2");
			gameMain.card.show(gameMain.contentPane, "p2");
			p2.requestFocusInWindow();				
			th.start();				
		}
	}
	
	public void checkOnAll() {
		for(GameObject_One r : stageone.item) {
			if(hero.getBound().intersects(r.getBound())) {
				if(r == stageone.item.get(0)) {
					reddir1 = false;
				}
				
				if(r == stageone.item.get(2)) {
					reddir2 = false;
				}
				
			}
			
			if(hero2.getBound().intersects(r.getBound())) {
				if(r == stageone.item.get(1)) {
					bluedir1 = false;
				}
				
				if(r == stageone.item.get(3)) {
					bluedir2 = false;
				}
			}
			
			
		}
	}
	
	public void checkobstacle(){  // 장애물 충돌 췌크
		for(GameObject_One r : stageone.hurdleblock) {
			if(hero.getBound().intersects(r.getobstacle())) {
				try {
					background_sound.stop();
				}catch(Exception a) {}
				gameMain.showGameOver1Panel();
				gameOverSound();

			}
		}
		
		for(GameObject_One r : stageone.cloud_block) {
			if(hero.getBound().intersects(r.getobstacle())) {
				try {
					background_sound.stop();
				}catch(Exception a) {}
				gameMain.showGameOver1Panel();
				gameOverSound();

			}
		}
		
		for(GameObject_One r : stageone.firewater) {
			if(hero.getBound().intersects(r.getobstacle())) {
				if(r ==stageone.firewater.get(4) || r ==stageone.firewater.get(5) || r ==stageone.firewater.get(6) || r ==stageone.firewater.get(7)) {
					try {
						background_sound.stop();
					}catch(Exception a) {}
					gameMain.showGameOver1Panel();
					gameOverSound();
				}
			}
		}
		/*---------------------------------------------------------------------*/
		
		for(GameObject_One r : stageone.hurdleblock) {
			if(hero2.getBound().intersects(r.getobstacle())) {
				try {
					background_sound.stop();
				}catch(Exception a) {}
				gameMain.showGameOver1Panel();
				gameOverSound();
			}
		}
		
		for(GameObject_One r : stageone.cloud_block) {
			if(hero2.getBound().intersects(r.getobstacle())) {
				try {
					background_sound.stop();
				}catch(Exception a) {}
				gameMain.showGameOver1Panel();
				gameOverSound();
			}
		}
		
		for(GameObject_One r : stageone.firewater) {
			if(hero2.getBound().intersects(r.getobstacle())) {
				if(r == stageone.firewater.get(0) || r ==stageone.firewater.get(1) || r ==stageone.firewater.get(2) || r ==stageone.firewater.get(3)) {
					try {
						background_sound.stop();
					}catch(Exception a) {}
					gameMain.showGameOver1Panel();
					gameOverSound();
				}
			}
		}
	}


	public void checkOnTop() {
		//onTop = false;
		for (GameObject_One r : stageone.block) {
			if (hero.getBottomBound().intersects(r.getTopBound())) {
				//hero.setY((int) (r.getY() - hero.getHeight() + 1)); // + 1 을 해야만 캐릭터가 고정...?
				falling = false;
				isJumping = false; // 추가한 코드
				button_count1=0;
				//onTop = true;
				break;
			}
		}
		
		for (GameObject_One r : stageone.clockingblock) {
			if (hero.getBottomBound().intersects(r.getTopBound())) {
					
				falling = false;
				isJumping = false; // 추가한 코드
				//onTop = true;
				break;
			}
		}
		
		
		/*
		for (GameObject r : stage2.button) {
			if (hero.getBottomBound().intersects(r.getTopBound())) {
				
				
			
				falling = false;
				isJumping = false; // 추가한 코드
				//onTop = true;
				break;
			}
		}*/
		
		
		for (GameObject_One r : stageone.button) {
			if (hero.getBottomBound().intersects(r.getTopBound())) {
				//hero.setY((int) (r.getY() - hero.getHeight() + 1)); // + 1 을 해야만 캐릭터가 고정...?
				falling = false;
				isJumping = false; // 추가한 코드
				check_sound++;
				button_count1++;
				if(button_count1==1) {
					buttonSound();
				}
				if(r == stageone.button.get(0)) {
					 redbutton_collins = true;
				}
				//onTop = true;
				break;
			}
		}
	}
	
	
	
	public void checkOnBotton() {
		for (GameObject_One r : stageone.block) {
			if (hero.getTopBound().intersects(r.getBottomBound())) { 
				jumping = false;	
				Character_1p.dy = 0;
				//falling = true;
				break;
			}
		}	
		
		for (GameObject_One r : stageone.swingblock) {
			if (hero.getTopBound().intersects(r.getBottomBound())) { 
				jumping = false;	
				Character_1p.dy = 0; 
				//falling = true;
				break;
			}
		}	
		
		
		for (GameObject_One r : stageone.clockingblock) {
			if (hero.getTopBound().intersects(r.getBottomBound())) {
				//hero.setY((int) (r.getY() - hero.getHeight() + 1)); // + 1 을 해야만 캐릭터가 고정...?
				//falling = false;
				jumping = false; // 추가한 코드
				//onTop = true;
				Character_1p.dy = 0;
				break;
			}

		}
		
		for (GameObject_One r : stageone.button) {
			if (hero.getTopBound().intersects(r.getBottomBound())) {
				//hero.setY((int) (r.getY() - hero.getHeight() + 1)); // + 1 을 해야만 캐릭터가 고정...?
				//falling = false;
				jumping = false; // 추가한 코드
				//onTop = true;
				Character_1p.dy = 0;
				break;
			}

		}
			
	}
	
	
	public void checkOnLeft() {
		for (GameObject_One r : stageone.block) {
			if (!(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getRightBound().intersects(r.getLeftBound())) { 
				//좌, 우 체크 범위를 크게 해놨기 때문에 onTop, onBottom일떄를 조건문에 추가
				//rightMove = false;
				checkright = false;
				break;
			}
			else
				checkright = true;

		}	
		
		
		for (GameObject_One r : stageone.swingblock) {
			if (!(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getRightBound().intersects(r.getLeftBound())) { 
				//좌, 우 체크 범위를 크게 해놨기 때문에 onTop, onBottom일떄를 조건문에 추가
				//rightMove = false;
				checkright = false;
				break;
			}
		}	
		
		for (GameObject_One r : stageone.clockingblock) {
			if (!(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getRightBound().intersects(r.getLeftBound())) { 
				//좌, 우 체크 범위를 크게 해놨기 때문에 onTop, onBottom일떄를 조건문에 추가
				//rightMove = false;
				checkright = false;
				break;
			}
		}
		
		
		for (GameObject_One r : stageone.button) {
			if (!(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getRightBound().intersects(r.getLeftBound())) { 
				//좌, 우 체크 범위를 크게 해놨기 때문에 onTop, onBottom일떄를 조건문에 추가
				//rightMove = false;
				checkright = false;
				break;
			}
		}
		
	}
	
	
	public void checkOnRight() {
		for (GameObject_One r : stageone.block) {
			if (!(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getLeftBound().intersects(r.getRightBound())) {
				//좌, 우 체크 범위를 크게 해놨기 때문에 onTop, onBottom일떄를 조건문에 추가
				//leftMove = false;
				checkleft = false;
				break;
			}
			else
				checkleft = true;
		}	
		
		
		for (GameObject_One r : stageone.swingblock) {
			if (!(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getLeftBound().intersects(r.getRightBound())) {
				//좌, 우 체크 범위를 크게 해놨기 때문에 onTop, onBottom일떄를 조건문에 추가
				//leftMove = false;
				checkleft = false;
				break;
			}
		}	
		
		
		for (GameObject_One r : stageone.clockingblock) {
			if (!(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getLeftBound().intersects(r.getRightBound())) {
				//좌, 우 체크 범위를 크게 해놨기 때문에 onTop, onBottom일떄를 조건문에 추가
				//leftMove = false;
				checkleft = false;
				break;
			}
		}	
		
		for (GameObject_One r : stageone.button) {
			if (!(hero.getBottomBound().intersects(r.getTopBound())) && !(hero.getTopBound().intersects(r.getBottomBound())) && hero.getLeftBound().intersects(r.getRightBound())) {
				//좌, 우 체크 범위를 크게 해놨기 때문에 onTop, onBottom일떄를 조건문에 추가
				//leftMove = false;
				checkleft = false;
				break;
			}
		}
	}
	
	
	public void checkswingblockTop() {
		for (GameObject_One r : stageone.swingblock) {
			if (hero.getBottomBound().intersects(r.getTopBound())) {
				if(r == stageone.swingblock.get(0)) {
				//좌, 우 체크 범위를 크게 해놨기 때문에 onTop, onBottom일떄를 조건문에 추가
				//leftMove = false;
				//isJumping = false;
				falling = false;
				isJumping= false;
				//(r == stage2.swingblock.get(0)) {
				//checkswingblockTop = true;
				swingblock_collins1p = true;
					//if((stage2.swingblock.get(0).y >= 800))
						//hero.setY(stage2.swingblock.get(0).y-39);
					//if(stage2.swingblock.get(0).y >=)
				}
				else if( r== stageone.swingblock.get(1)) {
					falling = false;
					isJumping= false;
				}
				
				break;
			}
			else {
				if(r == stageone.swingblock.get(0)) {
				swingblock_collins1p = false;
				end_2p = true;
				}
				//checkswingblockTop = false;
			}
		}	
	}
	
	//---------------------------
	 
	 public void checkOnTop_2p() {
		onTop = false;
		for (GameObject_One r : stageone.block) {
			if (hero2.getBottomBound().intersects(r.getTopBound())) {
				//hero.setY((int) (r.getY() - hero.getHeight() + 1)); // + 1 을 해야만 캐릭터가 고정...?
				falling_2p = false;
				isJumping_2p = false; // 추가한 코드
				button_count2=0;
				//onTop = true;
				break;
			}
		}
		
		
		for (GameObject_One r : stageone.clockingblock) {
			if (hero2.getBottomBound().intersects(r.getTopBound())) {
				//hero.setY((int) (r.getY() - hero.getHeight() + 1)); // + 1 을 해야만 캐릭터가 고정...?
				falling_2p = false;
				isJumping_2p = false; // 추가한 코드
				//onTop = true;
				break;
			}
		}

		for (GameObject_One r : stageone.button) {
			if (hero2.getBottomBound().intersects(r.getTopBound())) {
				//hero.setY((int) (r.getY() - hero.getHeight() + 1)); // + 1 을 해야만 캐릭터가 고정...?
				falling_2p = false;
				isJumping_2p = false; // 추가한 코드
			
				button_count2++;
				if(button_count2==1) {
					buttonSound();
				}
				if( r == stageone.button.get(1)) {
				
					bluebutton_collins = true;
					
				}
				//onTop = true;
				break;
			}
		}
		
		
	}
	
	 
	public void checkOnBotton_2p() {
		for (GameObject_One r : stageone.block) {
			if (hero2.getTopBound().intersects(r.getBottomBound())) { 
				jumping_2p = false;	
				Character_2p.dy_2p = 0;
				//falling = true;
				break;
			}
		}	
		
		for (GameObject_One r : stageone.swingblock) {
			if (hero2.getTopBound().intersects(r.getBottomBound())) { 
				jumping_2p = false;	
				Character_2p.dy_2p = 0;
				//falling = true;
				break;
			}
		}	
		
		for (GameObject_One r : stageone.clockingblock) {
			if (hero2.getTopBound().intersects(r.getBottomBound())) { 
				jumping_2p = false;	
				Character_2p.dy_2p = 0;
				//falling = true;
				break;
			}
		}
		
		for (GameObject_One r : stageone.button) {
			if (hero2.getTopBound().intersects(r.getBottomBound())) { 
				jumping_2p = false;	
				Character_2p.dy_2p = 0;
				//falling = true;
				break;
			}
		}
			
	}
	
	public void checkOnLeft_2p() {
		for (GameObject_One r : stageone.block) {
			if (!(hero2.getBottomBound().intersects(r.getTopBound())) && !(hero2.getTopBound().intersects(r.getBottomBound())) && hero2.getRightBound().intersects(r.getLeftBound())) { 
				//좌, 우 체크 범위를 크게 해놨기 때문에 onTop, onBottom일떄를 조건문에 추가
				//rightMove = false;
				checkright_2p = false;
				break;
			}
			else
				checkright_2p = true;

		}	
		
		
		for (GameObject_One r : stageone.swingblock) {
			if (!(hero2.getBottomBound().intersects(r.getTopBound())) && !(hero2.getTopBound().intersects(r.getBottomBound())) && hero2.getRightBound().intersects(r.getLeftBound())) { 
				//좌, 우 체크 범위를 크게 해놨기 때문에 onTop, onBottom일떄를 조건문에 추가
				//rightMove = false;
				checkright_2p = false;
				break;
			}
		}	
		
		
		
		for (GameObject_One r : stageone.clockingblock) {
			if (!(hero2.getBottomBound().intersects(r.getTopBound())) && !(hero2.getTopBound().intersects(r.getBottomBound())) && hero2.getRightBound().intersects(r.getLeftBound())) { 
				//좌, 우 체크 범위를 크게 해놨기 때문에 onTop, onBottom일떄를 조건문에 추가
				//rightMove = false;
				checkright_2p = false;
				break;
			}
		}	

		
		for (GameObject_One r : stageone.button) {
			if (!(hero2.getBottomBound().intersects(r.getTopBound())) && !(hero2.getTopBound().intersects(r.getBottomBound())) && hero2.getRightBound().intersects(r.getLeftBound())) { 
				//좌, 우 체크 범위를 크게 해놨기 때문에 onTop, onBottom일떄를 조건문에 추가
				//rightMove = false;
				checkright_2p = false;
				break;
			}
		}	
		
	}
	
	
	public void checkOnRight_2p() {
		for (GameObject_One r : stageone.block) {
			if (!(hero2.getBottomBound().intersects(r.getTopBound())) && !(hero2.getTopBound().intersects(r.getBottomBound())) && hero2.getLeftBound().intersects(r.getRightBound())) {
				//좌, 우 체크 범위를 크게 해놨기 때문에 onTop, onBottom일떄를 조건문에 추가
				//leftMove = false;
				checkleft_2p = false;
				break;
			}
			else
				checkleft_2p = true;
		}	
		
		
		for (GameObject_One r : stageone.swingblock) {
			if (!(hero2.getBottomBound().intersects(r.getTopBound())) && !(hero2.getTopBound().intersects(r.getBottomBound())) && hero2.getLeftBound().intersects(r.getRightBound())) {
				//좌, 우 체크 범위를 크게 해놨기 때문에 onTop, onBottom일떄를 조건문에 추가
				//leftMove = false;
				checkleft_2p = false;
				break;
			}
		}	
		
		for (GameObject_One r : stageone.clockingblock) {
			if (!(hero2.getBottomBound().intersects(r.getTopBound())) && !(hero2.getTopBound().intersects(r.getBottomBound())) && hero2.getLeftBound().intersects(r.getRightBound())) {
				//좌, 우 체크 범위를 크게 해놨기 때문에 onTop, onBottom일떄를 조건문에 추가
				//leftMove = false;
				checkleft_2p = false;
				break;
			}
		}	
		
		for (GameObject_One r : stageone.button) {
			if (!(hero2.getBottomBound().intersects(r.getTopBound())) && !(hero2.getTopBound().intersects(r.getBottomBound())) && hero2.getLeftBound().intersects(r.getRightBound())) {
				//좌, 우 체크 범위를 크게 해놨기 때문에 onTop, onBottom일떄를 조건문에 추가
				//leftMove = false;
				checkleft_2p = false;
				break;
			}
		}
	}
	
	public void checkswingblockTop_2p() {
		for (GameObject_One r : stageone.swingblock) {
			if (hero2.getBottomBound().intersects(r.getTopBound())) {
				if(r == stageone.swingblock.get(1)) {
				//좌, 우 체크 범위를 크게 해놨기 때문에 onTop, onBottom일떄를 조건문에 추가
				//leftMove = false;
				//isJumping = false;
				falling_2p = false;
				isJumping_2p= false;
				swingblock_collins2p = true;
				
				break;
				}
				else if(r== stageone.swingblock.get(0)) {
					falling_2p = false;
					isJumping_2p = false;
				}
			}
			else {
				if(r == stageone.swingblock.get(0)) {
					swingblock_collins2p = false;
					end_1p = true;
					}
			}
		}	
		
		
		
	}
	
	static public void jumpSound() {
		File file = new File("music/Jump_5.wav");
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
	
	static public void moveSound() {
		File file = new File("music/move_block.wav");
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
	/*
	 
	public void checkswingblockTop() {
		for (GameObject r : stage2.swingblock) {
			if (hero.getBottomBound().intersects(r.getTopBound())) {
				if(r == stage2.swingblock.get(0)) {
				//좌, 우 체크 범위를 크게 해놨기 때문에 onTop, onBottom일떄를 조건문에 추가
				//leftMove = false;
				//isJumping = false;
				falling = false;
				isJumping= false;
				//(r == stage2.swingblock.get(0)) {
				//checkswingblockTop = true;
				swingblock_collins1p = true;
					//if((stage2.swingblock.get(0).y >= 800))
						//hero.setY(stage2.swingblock.get(0).y-39);
					//if(stage2.swingblock.get(0).y >=)
				}
				else if( r== stage2.swingblock.get(1)) {
					falling = false;
					isJumping= false;
				}
				
				break;
			}
			else {
				if(r == stage2.swingblock.get(0)) {
				swingblock_collins1p = false;
				end_2p = true;
				}
				//checkswingblockTop = false;
			}
		}	
	}
	
	*/
	
	
	
	public void roadBlocked() { // 충돌 체크 -> collision이 true 이면 setX(0)
		if (checkCollision()) {
			//
			// 충돌 오디오 재생 코드
			//
			//hero.setX(0);
		}


	}
	public void run() {
		// TODO Auto-generated method stub		
		start();
	}

	
}