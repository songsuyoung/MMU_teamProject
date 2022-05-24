package StageThree;
import java.awt.Graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

import StageOne.PlatformScene_One;

public class StageThree extends GameObject {
	int block_speed = 1;
	
	ImageIcon background = new ImageIcon("images/07.jpg");
	Image background_I = background.getImage();
	
	int diaCount=0;
	int diaCount1=0;
	int diaCount2=0;
	//
	int diaCount3=0;
	int diaCount4=0;
	int diaCount5=0;
	int diaCount6=0;
	
	ArrayList<BlockObject> block;
	ArrayList<BlockObject> obstacle;
	ArrayList<BlockObject> dia;
	ArrayList<BlockObject> appear_block;
	ArrayList<BlockObject> appear_block2;
	ArrayList<BlockObject> appear_block3;
	ArrayList<BlockObject> out_block1;
	ArrayList<BlockObject> out_block2;
	ArrayList<BlockObject> shoot_block;
	ArrayList<BlockObject> door_block;
	ArrayList<BlockObject> fire_block;
	
	ArrayList<BlockObject> monster;
	
	ArrayList<BlockObject> stopblock;
	
	ImageIcon wall_25_w = new ImageIcon("images/wall_25x20_w.png");
	Image wall_25_w_I = wall_25_w.getImage();
	
	ImageIcon wall_20_h = new ImageIcon("images/wall_bk_h.png");
	Image wall_20_h_I = wall_20_h.getImage();
	
	ImageIcon wall_4 = new ImageIcon("images/wall_4.png");
	Image wall_4_I = wall_4.getImage();
	
	ImageIcon wall_3 = new ImageIcon("images/wall_3.png");
	Image wall_3_I = wall_3.getImage();
	
	ImageIcon wall_9 = new ImageIcon("images/wall_9.png");
	Image wall_9_I = wall_9.getImage();
	
	ImageIcon wall_5_w = new ImageIcon("images/wall_5_w.png");
	Image wall_5_w_I = wall_5_w.getImage();
	
	ImageIcon wall_3h = new ImageIcon("images/wall_3h.png");
	Image wall_3h_I = wall_3h.getImage();
	
	ImageIcon three_bluewall = new ImageIcon("images/three_blueewall.png");
	Image three_bluewall_I = three_bluewall.getImage();
	
	ImageIcon three_firewall = new ImageIcon("images/three_redwall.png");
	Image three_firewall_I = three_firewall.getImage();
	
	ImageIcon one_wall = new ImageIcon("images/one_wall.png");
	Image one_wall_I = one_wall.getImage();
	
	ImageIcon one_firewall = new ImageIcon("images/one_firewall.png");
	Image one_firewall_I = one_firewall.getImage();
	
	ImageIcon one_bluewall = new ImageIcon("images/one_bluewall.png");
	Image one_bluewall_I = one_bluewall.getImage();
	
	ImageIcon hurdle = new ImageIcon("images/hurdle.png");
	Image hurdle_I = hurdle.getImage();
	
	ImageIcon hurdleB = new ImageIcon("images/hurdleB.png");
	Image hurdleB_I = hurdleB.getImage();
	
	ImageIcon wall_6w = new ImageIcon("images/wall_6w.png");
	Image wall_6w_I = wall_6w.getImage();
	
	ImageIcon wall_2 = new ImageIcon("images/wall_2.png");
	Image wall_2_I = wall_2.getImage();
	
	ImageIcon reddiamond = new ImageIcon("images/reddia.png.png");
	Image readia = reddiamond.getImage();
	
	ImageIcon bluediamond = new ImageIcon("images/bluedia.png.png");
	Image bluedia1 = bluediamond.getImage();
	
	ImageIcon wall_2_h = new ImageIcon("images/wall_2_h.png");
	Image wall_2_h_I = wall_2_h.getImage();
	
	ImageIcon reddoor = new ImageIcon("images/red_d.png");
	Image reddoor_I = reddoor.getImage();
	
	ImageIcon bluedoor = new ImageIcon("images/blue.png");
	Image bluedoor_I = bluedoor.getImage();
	
	ImageIcon move_block = new ImageIcon("images/move_block.png");
	Image move_block_I = move_block.getImage();
	
	ImageIcon fireblock1 = new ImageIcon("images/fire1.png");
	Image fire1_block = fireblock1.getImage();
	
	ImageIcon fireblock2 = new ImageIcon("images/fire.png");
	Image fire2_block = fireblock2.getImage();
	
	ImageIcon blueb = new ImageIcon("images/blueb.png");
	Image blueb_I = blueb.getImage();
	
	ImageIcon pupleblock = new ImageIcon("images/pupleblock.png");
	Image pupleblock_I = pupleblock.getImage();
	
	ImageIcon bluebutton = new ImageIcon("images/push_down_blueblock.png");
	Image bluebutton_I = bluebutton.getImage();
	
	ImageIcon L_R = new ImageIcon("images/left_rigth.png");
	Image left_right = L_R.getImage();
	
	ImageIcon R_L = new ImageIcon("images/right_left.png");
	Image right_left = R_L.getImage();
	
	ImageIcon U_D = new ImageIcon("images/up_down.png");
	Image up_down = U_D.getImage();
	
	ImageIcon D_U = new ImageIcon("images/down_up.png");
	Image down_up = U_D.getImage();
	
	ImageIcon monster12 = new ImageIcon("images/monster.png");
	Image monster_I = monster12.getImage();
	
	public static ImageIcon pushblock1_1 = new ImageIcon("images/push_down_blueblock.png");
	public static ImageIcon pushblock1_2 = new ImageIcon("images/push_on_blueblock.png");
	public static Image push_block1 = pushblock1_1.getImage();
	
	public static ImageIcon pushblock2_1 = new ImageIcon("images/push_down_redblock.png");
	public static ImageIcon pushblock2_2 = new ImageIcon("images/push_on_redblock.png");
	public static Image push_block2 = pushblock2_1.getImage();
	
	public static ImageIcon pushblock3_1 = new ImageIcon("images/push_down_blueblock.png");
	public static ImageIcon pushblock3_2 = new ImageIcon("images/push_on_blueblock.png");
	public static Image push_block3 = pushblock3_1.getImage();
	
	public static ImageIcon pushblock4_1 = new ImageIcon("images/push_down_redblock.png");
	public static ImageIcon pushblock4_2 = new ImageIcon("images/push_on_redblock.png");
	public static Image push_block4 = pushblock4_1.getImage();
	
	public static ImageIcon pushblock5_1 = new ImageIcon("images/push_down_blueblock.png");
	public static ImageIcon pushblock5_2 = new ImageIcon("images/push_on_blueblock.png");
	public static Image push_block5 = pushblock5_1.getImage();
		
	
	public StageThree() {
		Background.background_setN=3;
		
		block = new ArrayList<BlockObject>();
		//테두리
		block.add(new BlockObject(0, 0, 1000, 40)); // 맨위 가로
		block.add(new BlockObject(0, 0, 40, 760));   // 죄측 세로
		block.add(new BlockObject(0, 720, 1000, 40)); // 맨 아래 가로
		block.add(new BlockObject(960, 0, 40, 760));   // 우측 세로
		
		//첫 번째 줄
		block.add(new BlockObject(40, 570, 120, 40 )); //아래 왼쪽부터 
		block.add(new BlockObject(280, 570, 360, 40 ));  //?????????????????????
		block.add(new BlockObject(640, 570, 160, 40));
		block.add(new BlockObject(800, 570, 35, 110));
		
		//첫줄 장애물
		block.add(new BlockObject(160,700,120,20)); //움직임1
		block.add(new BlockObject(40,557,40,15)); //나타나기1
		
		//두 번째 줄
		block.add(new BlockObject(40,420,360,40)); 
		block.add(new BlockObject(520,420,240,40)); 
		block.add(new BlockObject(758,455,122,40));
		block.add(new BlockObject(880,420,80,40));
		
		// 두 번째 줄 장애물
		block.add(new BlockObject(400,540,120,20)); //움직임2
		block.add(new BlockObject(600,557,40,15)); // 나타나기2
		
		
		//세 번쨰 줄
		block.add(new BlockObject(120,260,360,40));
		block.add(new BlockObject(480,260,360,40));
		block.add(new BlockObject(840,260,120,40));
		
		// 세 번째 줄 장애물
		block.add(new BlockObject(360, 380, 40, 40)); //움직임 3-1
		block.add(new BlockObject(920, 407, 40, 15)); //나타나기3
		
		
		//네 번째 줄 장애물	
		monster = new ArrayList<BlockObject>();
		monster.add(new BlockObject(40, 190, 50, 10));  //몬스터 발판
		monster.add(new BlockObject(45, 150, 40, 40)); //몬스터
		
		block.add(new BlockObject(40, 405, 40,15)); // 나타나기4
		
		shoot_block = new ArrayList<BlockObject>();
		shoot_block.add(new BlockObject(1000, 405, 50, 10));
		shoot_block.add(new BlockObject(1000, 355, 50, 10));
		
		
		//마지막 줄
		block.add(new BlockObject(40, 130, 80, 10));
		block.add(new BlockObject(880, 130, 80, 10));
		block.add(new BlockObject(290, 220, 40, 40));
		block.add(new BlockObject(680, 140, 40, 120));
		
		//마지막 줄 장애물
		block.add(new BlockObject(370, 240, 60, 20)); //-----------------------------
		block.add(new BlockObject(580, 240, 60, 20));
		block.add(new BlockObject(920, 245, 40, 15)); //나타나기5
		block.add(new BlockObject(240, 0, 40, 40)); //블록 움직임        180
		block.add(new BlockObject(200, 0, 40, 40)); //블록 움직임        140
		block.add(new BlockObject(160, 0, 40, 40)); //블록 움직임        100
		block.add(new BlockObject(240, 0, 40, 40)); //블록 움직임        
		block.add(new BlockObject(200, 0, 40, 40)); //블록 움직임        
		block.add(new BlockObject(160, 0, 40, 40)); //블록 움직임        
		
		shoot_block.add(new BlockObject(1000, 250, 40, 15)); //총알2------------------
		shoot_block.add(new BlockObject(1000, 170, 40, 15)); //총알2------------------
		shoot_block.add(new BlockObject(1000, 82, 40, 15)); //총알2------------------
		
		shoot_block.add(new BlockObject(100, -100, 15, 40)); //총알3------------------
		shoot_block.add(new BlockObject(200, -100, 15, 40)); //총알3------------------
		shoot_block.add(new BlockObject(300, -100, 15, 40)); //총알3------------------
		shoot_block.add(new BlockObject(400, -100, 15, 40)); //총알3------------------
		shoot_block.add(new BlockObject(500, -100, 15, 40)); //총알3------------------
		shoot_block.add(new BlockObject(600, -100, 15, 40)); //총알3------------------
		shoot_block.add(new BlockObject(700, -100, 15, 40)); //총알3------------------
		shoot_block.add(new BlockObject(800, -100, 15, 40)); //총알3------------------
		shoot_block.add(new BlockObject(900, -100, 15, 40)); //총알3------------------
		
		shoot_block.add(new BlockObject(50, 850, 15, 40)); //총알4------------------
		shoot_block.add(new BlockObject(150, 850, 15, 40)); //총알4------------------
		shoot_block.add(new BlockObject(250, 850, 15, 40)); //총알4------------------
		shoot_block.add(new BlockObject(350, 850, 15, 40)); //총알4------------------
		shoot_block.add(new BlockObject(450, 850, 15, 40)); //총알4------------------
		shoot_block.add(new BlockObject(550, 850, 15, 40)); //총알4------------------
		shoot_block.add(new BlockObject(650, 850, 15, 40)); //총알4------------------
		shoot_block.add(new BlockObject(750, 850, 15, 40)); //총알4------------------
		shoot_block.add(new BlockObject(850, 850, 15, 40)); //총알4------------------
		shoot_block.add(new BlockObject(950, 850, 15, 40)); //총알4------------------
		
	
		//1층 뿅
		appear_block = new ArrayList<BlockObject>();
		appear_block.add(new BlockObject(915, 670, 45, 10)); 
		appear_block.add(new BlockObject(833, 620, 45, 10));
		appear_block.add(new BlockObject(915, 570, 45, 10));
		
		//2층 뿅
		out_block1 = new ArrayList<BlockObject>();
		out_block1.add(new BlockObject(360,460,40,110));
		
		//3층 뿅
		out_block2 = new ArrayList<BlockObject>();
		out_block2.add(new BlockObject(280, 300, 40, 120));
		
		//4층 뿅
		appear_block2 = new ArrayList<BlockObject>();
		appear_block2.add(new BlockObject(120, 300,40, 80));
		appear_block2.add(new BlockObject(95, 350, 25, 10));
		appear_block2.add(new BlockObject(38, 300, 25, 10));
		
		//마지막층 뿅
		appear_block3 = new ArrayList<BlockObject>();
		appear_block3.add(new BlockObject(720, 220, 30, 5));
		appear_block3.add(new BlockObject(770, 245, 30, 5));
		appear_block3.add(new BlockObject(820, 150, 30, 5));
		appear_block3.add(new BlockObject(820, 230, 30, 5));
		appear_block3.add(new BlockObject(760, 160, 30, 5));
		
		
		
		
		//입, 출 구
		door_block = new ArrayList<BlockObject>();
		door_block.add(new BlockObject(75,618, 50, 110)); // 레드블록1
		door_block.add(new BlockObject(35,618, 50, 110)); // 블루블록1
		door_block.add(new BlockObject(35,40, 60, 98)); // 레드블록2
		door_block.add(new BlockObject(895,40, 60, 98)); // 블루블록2
		
		
		//화염블록
		fire_block = new ArrayList<BlockObject>();
		fire_block.add(new BlockObject(760,425,40,33));	
		fire_block.add(new BlockObject(800,425,40,33));	
		fire_block.add(new BlockObject(840,425,40,33));	
		
		
		
		obstacle = new ArrayList<BlockObject>();
		obstacle.add(new BlockObject(400,660,40,85));
		obstacle.add(new BlockObject(480,660,40,85));
		obstacle.add(new BlockObject(560,660,40,85));
		obstacle.add(new BlockObject(80,525,40,65));
		obstacle.add(new BlockObject(600,580,40,100));
		obstacle.add(new BlockObject(690,512,40,85));
		obstacle.add(new BlockObject(560,500,40,100));
		obstacle.add(new BlockObject(160,251,40,160));
		obstacle.add(new BlockObject(200,251,40,160));
		obstacle.add(new BlockObject(490,-10,40,160));
		obstacle.add(new BlockObject(460,177,40,120));
		
		//2층 랜덤블록
		block.add(new BlockObject(160, 458, 40, 20));
		block.add(new BlockObject(240, 458, 40, 20));
		block.add(new BlockObject(320, 550, 40, 20));
		
		shoot_block.add(new BlockObject(1100, 550, 50,20)); // 함정총알1
		shoot_block.add(new BlockObject(120, -50, 20,50)); // 함정총알1
		shoot_block.add(new BlockObject(220, -50, 20,50)); // 함정총알1
		shoot_block.add(new BlockObject(320, -50, 20,50)); // 함정총알1
		shoot_block.add(new BlockObject(-100, 510, 50, 20)); // 함정총알1
		
		stopblock = new ArrayList<BlockObject>();
		stopblock.add(new BlockObject(560,300,40,120)); // 막는블록
		stopblock.add(new BlockObject(640,300,40,120)); // 막는블록
		stopblock.add(new BlockObject(720,300,40,120)); // 막는블록
		
		dia = new ArrayList<BlockObject>();
		
		dia.add(new BlockObject(880,460, 40,40 ));
		dia.add(new BlockObject(40,460, 40,40 ));
		dia.add(new BlockObject(450, 50, 40,40 ));
		dia.add(new BlockObject(640, 300, 40,40 ));
		dia.add(new BlockObject(560, 610, 40,40 ));
		dia.add(new BlockObject(720, 300, 40,40 ));
		dia.add(new BlockObject(720, 40, 40,40 ));
		
		

		
		
	}
	
	

	@Override
	public void updateLocation() {
		int block_speed = 1;
		
		if(PlatformScene_Three.moveBlock1) {
			if(block.get(8).y >= 570) 
				block.get(8).y -= block_speed;	
		}
		
		
		if(PlatformScene_Three.moveBlock3) {
			block.get(19).y = 415;
		}
		
	}
	
	public void updatemoveBlock2() {
		if(PlatformScene_Three.moveBlock2 && PlatformScene_Three.moveBlock2_2) {
			if(block.get(14).y >= 420) 
				block.get(14).y -= block_speed;
		}
	}
	
	public void updatemoveBlock4() {
		if(PlatformScene_Three.reddir2 == true && PlatformScene_Three.moveBlock4) {
			if(block.get(26).y >=150) 
				block.get(26).y -= block_speed;
			
		}
		else {
			if(block.get(26).y <= 240) 
				block.get(26).y += block_speed;
		}
		
		if(PlatformScene_Three.reddir2 == false)
			if(block.get(27).y >= 120)
				block.get(27).y -= block_speed;
			
		
	}
	
	public void updatemoveBlock5() {
		
		if(PlatformScene_Three.moveBlock5) {
			if(block.get(29).y <= 180 )
				block.get(29).y += block_speed;
			
			if(block.get(30).y <= 140)
				block.get(30).y += block_speed;
			
			if(block.get(31).y <= 100)
				block.get(31).y += block_speed;
			
			if(block.get(32).y <= 220 )
				block.get(32).y += block_speed;
			
			if(block.get(33).y <= 180)
				block.get(33).y += block_speed;
			
			if(block.get(34).y <= 140)
				block.get(34).y += block_speed;
		}
		
	}
	
	public void updatemonsterBlock() {
		if(PlatformScene_Three.monsterblock == false) {
			PlatformScene_Three.monsterdrop1 += 1;
			if(PlatformScene_Three.monsterdrop1 == 1)
				PlatformScene_Three.monsterdropSound();
			
			if(monster.get(1).getY() <= 380)
				monster.get(1).y += block_speed;
			
			if (monster.get(1).y >= 380 && monster.get(1).x <= 800) {
				monster.get(1).x += block_speed+1;
			}
			
			if(monster.get(1).x >= 800) {
				monster.get(1).y = 415;
			}
		}
		else
			PlatformScene_Three.monsterdrop1 = 0;
	}
	
	
	public void updateshoot_block() {
		if(PlatformScene_Three.onBlock2 == true) {
			if(shoot_block.get(0).x >= -100)
				shoot_block.get(0).x -= 2;
			
			if(shoot_block.get(0).x <= 800)
				if(shoot_block.get(1).x >= -100)
					shoot_block.get(1).x -= 2;
		}
	}
	
	public void updateshoot_block2() {	
		if(PlatformScene_Three.reddir2 == false) {
			
			{
				PlatformScene_Three.shoot_count4 += 1;
				if(PlatformScene_Three.shoot_count4  == 1)
					PlatformScene_Three.shootingSound();
			
				if(shoot_block.get(2).x >= -100)
				shoot_block.get(2).x -= 2;
			
				if(shoot_block.get(3).x >= -100)
				shoot_block.get(3).x -= 3;
			
				if(shoot_block.get(4).x >= -100)
				shoot_block.get(4).x -= 1;
			
				if(shoot_block.get(4).x <= -100)
				PlatformScene_Three.nextshoot = true;
			}
		}
		
		if(PlatformScene_Three.nextshoot) { //5~13  , 14~23
			
			PlatformScene_Three.shoot_count6 += 1;
			if(PlatformScene_Three.shoot_count6  == 1)
				PlatformScene_Three.shootingSound();
			
			if(shoot_block.get(5).y <= 800)
				shoot_block.get(5).y += 2;
			if(shoot_block.get(6).y <= 800)
				shoot_block.get(6).y += 2;
			if(shoot_block.get(7).y <= 800)
				shoot_block.get(7).y += 2;
			if(shoot_block.get(8).y <= 800)
				shoot_block.get(8).y += 2;
			if(shoot_block.get(9).y <= 800)
				shoot_block.get(9).y += 2;
			if(shoot_block.get(10).y <= 800)
				shoot_block.get(10).y += 2;
			if(shoot_block.get(11).y <= 800)
				shoot_block.get(11).y += 2;
			if(shoot_block.get(12).y <= 800)
				shoot_block.get(12).y += 2;
			if(shoot_block.get(13).y <= 800) {
				shoot_block.get(13).y += 2;
			}
			if(shoot_block.get(13).y >= 800)
				PlatformScene_Three.nextshoot2 = true; 
		}
		else
			PlatformScene_Three.shoot_count6 = 0;
			
		if(PlatformScene_Three.nextshoot2) {
			PlatformScene_Three.shoot_count7 += 1;
			if(PlatformScene_Three.shoot_count7  == 1)
				PlatformScene_Three.shootingSound();
			
			
			if(shoot_block.get(14).y >= -100)
				shoot_block.get(14).y -= 3;
			if(shoot_block.get(15).y >= -100)
				shoot_block.get(15).y -= 3;
			if(shoot_block.get(16).y >= -100)
				shoot_block.get(16).y -= 3;
			if(shoot_block.get(17).y >= -100)
				shoot_block.get(17).y -= 3;
			if(shoot_block.get(18).y >= -100)
				shoot_block.get(18).y -= 3;
			if(shoot_block.get(19).y >= -100)
				shoot_block.get(19).y -= 3;
			if(shoot_block.get(20).y >= -100)
				shoot_block.get(20).y -= 3;
			if(shoot_block.get(21).y >= -100)
				shoot_block.get(21).y -= 3;
			if(shoot_block.get(22).y >= -100)
				shoot_block.get(22).y -= 3;
			if(shoot_block.get(23).y >= -100)
				shoot_block.get(23).y -= 3;
		}
		else
			PlatformScene_Three.shoot_count7 = 0;
		
		
	}
	
	public void updateshooting() {
		if(PlatformScene_Three.shooting1)
			if(shoot_block.get(24).x >= -100)
				shoot_block.get(24).x -= 3;
			
	}
	public void updateshooting2() {

		if(PlatformScene_Three.shooting2) {
			if(shoot_block.get(25).y <= 1000) {
				shoot_block.get(25).y += 3;
			}
		
			if(shoot_block.get(26).y <= 1000)
				shoot_block.get(26).y += 3;
		
			if(shoot_block.get(27).y <= 1000)
				shoot_block.get(27).y += 3;
			
			}
		
	}
	
	public void updateshooting3() {
		if(PlatformScene_Three.shooting3) {
			if(shoot_block.get(28).x <= 1100)
				shoot_block.get(28).x += 3;
		}
		
	}
	
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(background_I,0,0,1000,800,null);//배경
		
		//1층
		g2d.drawImage(wall_25_w_I, block.get(0).getX(), block.get(0).getY(), block.get(0).getWidth(),  block.get(0).getHeight(), null); 
		g2d.drawImage(wall_20_h_I, block.get(1).getX(), block.get(1).getY(), block.get(1).getWidth(),  block.get(1).getHeight(), null);
		g2d.drawImage(wall_25_w_I, block.get(2).getX(), block.get(2).getY(), block.get(2).getWidth(),  block.get(2).getHeight(), null);
		g2d.drawImage(wall_20_h_I, block.get(3).getX(), block.get(3).getY(), block.get(3).getWidth(),  block.get(3).getHeight(), null);
		g2d.drawImage(wall_3_I, block.get(4).getX(), block.get(4).getY(), block.get(4).getWidth(),  block.get(4).getHeight(), null);
		g2d.drawImage(wall_9_I, block.get(5).getX(), block.get(5).getY(), block.get(5).getWidth(),  block.get(5).getHeight(), null);
		g2d.drawImage(wall_4_I, block.get(6).getX(), block.get(6).getY(), block.get(6).getWidth(),  block.get(6).getHeight(), null);
		g2d.drawImage(wall_3h_I, block.get(7).getX(), block.get(7).getY(), block.get(7).getWidth(),  block.get(7).getHeight(), null);
		
		g2d.drawImage(three_bluewall_I, block.get(8).getX(), block.get(8).getY(), block.get(8).getWidth(),  block.get(8).getHeight(), null); // 움직임1
		
		g2d.drawImage(push_block1, block.get(9).getX(), block.get(9).getY(), block.get(9).getWidth(),  block.get(9).getHeight(), null); //블록 나타내기1
		
		//2층
		g2d.drawImage(wall_9_I, block.get(10).getX(), block.get(10).getY(), block.get(10).getWidth(),  block.get(10).getHeight(), null);
		g2d.drawImage(wall_6w_I, block.get(11).getX(), block.get(11).getY(), block.get(11).getWidth(),  block.get(11).getHeight(), null);
	    g2d.drawImage(wall_3_I, block.get(12).getX(), block.get(12).getY(), block.get(12).getWidth(),  block.get(12).getHeight(), null);
	    g2d.drawImage(wall_2_I, block.get(13).getX(), block.get(13).getY(), block.get(13).getWidth(),  block.get(13).getHeight(), null);
	    
	    g2d.drawImage(pupleblock_I, block.get(14).getX(), block.get(14).getY(), block.get(14).getWidth(),  block.get(14).getHeight(), null); //움직임2
	    g2d.drawImage(push_block2, block.get(15).getX(), block.get(15).getY(), block.get(15).getWidth(),  block.get(15).getHeight(), null); //나타나기2
	    
	    //3층
	    g2d.drawImage(wall_9_I, block.get(16).getX(), block.get(16).getY(), block.get(16).getWidth(),  block.get(16).getHeight(), null); 
	    g2d.drawImage(wall_9_I, block.get(17).getX(), block.get(17).getY(), block.get(17).getWidth(),  block.get(17).getHeight(), null); 
	    g2d.drawImage(wall_3_I, block.get(18).getX(), block.get(18).getY(), block.get(18).getWidth(),  block.get(18).getHeight(), null); 
	    
	    g2d.drawImage(move_block_I, block.get(19).getX(), block.get(19).getY(), block.get(19).getWidth(),  block.get(19).getHeight(), null); //움직임3-1
	    g2d.drawImage(push_block3, block.get(20).getX(), block.get(20).getY(), block.get(20).getWidth(),  block.get(20).getHeight(), null); //나타나기 3
	    
	    
	    //4층
	    if(PlatformScene_Three.monsterblock == true)
	    	g2d.drawImage(pupleblock_I, monster.get(0).getX(), monster.get(0).getY(), monster.get(0).getWidth(),  monster.get(0).getHeight(), null);  // 몬스터 발판
	    if(PlatformScene_Three.onMonster == true)
	    	g2d.drawImage(monster_I, monster.get(1).getX(), monster.get(1).getY(), monster.get(1).getWidth(),  monster.get(1).getHeight(), null);  // 몬스터
	    
	    g2d.drawImage(push_block4, block.get(21).getX(), block.get(21).getY(), block.get(21).getWidth(),  block.get(21).getHeight(), null); //나타나기 4
	    g2d.drawImage(right_left, shoot_block.get(0).getX(), shoot_block.get(0).getY(), shoot_block.get(0).getWidth(),  shoot_block.get(0).getHeight(), null); //수직 미사일
	    g2d.drawImage(right_left, shoot_block.get(1).getX(), shoot_block.get(1).getY(), shoot_block.get(1).getWidth(),  shoot_block.get(1).getHeight(), null); //수직 미사일
	    
	    //마지막층
	    g2d.drawImage(one_wall_I, block.get(22).getX(), block.get(22).getY(), block.get(22).getWidth(),  block.get(22).getHeight(), null);
	    g2d.drawImage(one_wall_I, block.get(23).getX(), block.get(23).getY(), block.get(23).getWidth(),  block.get(23).getHeight(), null);
	    
	    g2d.drawImage(one_wall_I, block.get(24).getX(), block.get(24).getY(), block.get(24).getWidth(),  block.get(24).getHeight(), null); 
	    g2d.drawImage(wall_3h_I, block.get(25).getX(), block.get(25).getY(), block.get(25).getWidth(),  block.get(25).getHeight(), null);
	    
	    
	    g2d.drawImage(one_firewall_I, block.get(26).getX(), block.get(26).getY(), block.get(26).getWidth(),  block.get(26).getHeight(), null); //블록 움직임 4
	    g2d.drawImage(one_bluewall_I, block.get(27).getX(), block.get(27).getY(), block.get(27).getWidth(),  block.get(27).getHeight(), null);
	    
	    g2d.drawImage(push_block5, block.get(28).getX(), block.get(28).getY(), block.get(28).getWidth(),  block.get(28).getHeight(), null); //---나타나기 5---
	    
	    g2d.drawImage(right_left, shoot_block.get(2).getX(), shoot_block.get(2).getY(), shoot_block.get(2).getWidth(),  shoot_block.get(2).getHeight(), null); //수직 미사일2
	    g2d.drawImage(right_left, shoot_block.get(3).getX(), shoot_block.get(3).getY(), shoot_block.get(3).getWidth(),  shoot_block.get(3).getHeight(), null); //수직 미사일2
	    g2d.drawImage(right_left, shoot_block.get(4).getX(), shoot_block.get(4).getY(), shoot_block.get(4).getWidth(),  shoot_block.get(4).getHeight(), null); //수직 미사일2
	    
	    g2d.drawImage(up_down, shoot_block.get(5).getX(), shoot_block.get(5).getY(), shoot_block.get(5).getWidth(),  shoot_block.get(5).getHeight(), null); //수평 미사일3
	    g2d.drawImage(up_down, shoot_block.get(6).getX(), shoot_block.get(6).getY(), shoot_block.get(6).getWidth(),  shoot_block.get(6).getHeight(), null); //수평 미사일3
	    g2d.drawImage(up_down, shoot_block.get(7).getX(), shoot_block.get(7).getY(), shoot_block.get(7).getWidth(),  shoot_block.get(7).getHeight(), null); //수평 미사일3
	    g2d.drawImage(up_down, shoot_block.get(8).getX(), shoot_block.get(8).getY(), shoot_block.get(8).getWidth(),  shoot_block.get(8).getHeight(), null); //수평 미사일3
	    g2d.drawImage(up_down, shoot_block.get(9).getX(), shoot_block.get(9).getY(), shoot_block.get(9).getWidth(),  shoot_block.get(9).getHeight(), null); //수평 미사일3
	    g2d.drawImage(up_down, shoot_block.get(10).getX(), shoot_block.get(10).getY(), shoot_block.get(10).getWidth(),  shoot_block.get(10).getHeight(), null); //수평 미사일3
	    g2d.drawImage(up_down, shoot_block.get(11).getX(), shoot_block.get(11).getY(), shoot_block.get(11).getWidth(),  shoot_block.get(11).getHeight(), null); //수평 미사일3
	    g2d.drawImage(up_down, shoot_block.get(12).getX(), shoot_block.get(12).getY(), shoot_block.get(12).getWidth(),  shoot_block.get(12).getHeight(), null); //수평 미사일3
	    g2d.drawImage(up_down, shoot_block.get(13).getX(), shoot_block.get(13).getY(), shoot_block.get(13).getWidth(),  shoot_block.get(13).getHeight(), null); //수평 미사일3
	    
	    g2d.drawImage(down_up, shoot_block.get(14).getX(), shoot_block.get(14).getY(), shoot_block.get(14).getWidth(),  shoot_block.get(14).getHeight(), null); //수평 미사일4
	    g2d.drawImage(down_up, shoot_block.get(15).getX(), shoot_block.get(15).getY(), shoot_block.get(15).getWidth(),  shoot_block.get(15).getHeight(), null); //수평 미사일4
	    g2d.drawImage(down_up, shoot_block.get(16).getX(), shoot_block.get(16).getY(), shoot_block.get(16).getWidth(),  shoot_block.get(16).getHeight(), null); //수평 미사일4
	    g2d.drawImage(down_up, shoot_block.get(17).getX(), shoot_block.get(17).getY(), shoot_block.get(17).getWidth(),  shoot_block.get(17).getHeight(), null); //수평 미사일4
	    g2d.drawImage(down_up, shoot_block.get(18).getX(), shoot_block.get(18).getY(), shoot_block.get(18).getWidth(),  shoot_block.get(18).getHeight(), null); //수평 미사일4
	    g2d.drawImage(down_up, shoot_block.get(19).getX(), shoot_block.get(19).getY(), shoot_block.get(19).getWidth(),  shoot_block.get(19).getHeight(), null); //수평 미사일4
	    g2d.drawImage(down_up, shoot_block.get(20).getX(), shoot_block.get(20).getY(), shoot_block.get(20).getWidth(),  shoot_block.get(20).getHeight(), null); //수평 미사일4
	    g2d.drawImage(down_up, shoot_block.get(21).getX(), shoot_block.get(21).getY(), shoot_block.get(21).getWidth(),  shoot_block.get(21).getHeight(), null); //수평 미사일4
	    g2d.drawImage(down_up, shoot_block.get(22).getX(), shoot_block.get(22).getY(), shoot_block.get(22).getWidth(),  shoot_block.get(22).getHeight(), null); //수평 미사일4
	    g2d.drawImage(down_up, shoot_block.get(23).getX(), shoot_block.get(23).getY(), shoot_block.get(23).getWidth(),  shoot_block.get(23).getHeight(), null); //수평 미사일4
	    
	    if(PlatformScene_Three.onBlock3) {
	    	g2d.drawImage(one_wall_I, appear_block3.get(0).getX(), appear_block3.get(0).getY(), appear_block3.get(0).getWidth(),  appear_block3.get(0).getHeight(), null); //
	    	g2d.drawImage(one_wall_I, appear_block3.get(1).getX(), appear_block3.get(1).getY(), appear_block3.get(1).getWidth(),  appear_block3.get(1).getHeight(), null); //
	    	g2d.drawImage(one_wall_I, appear_block3.get(2).getX(), appear_block3.get(2).getY(), appear_block3.get(2).getWidth(),  appear_block3.get(2).getHeight(), null); //
	    	g2d.drawImage(one_wall_I, appear_block3.get(3).getX(), appear_block3.get(3).getY(), appear_block3.get(3).getWidth(),  appear_block3.get(3).getHeight(), null); //
	    	g2d.drawImage(one_wall_I, appear_block3.get(4).getX(), appear_block3.get(4).getY(), appear_block3.get(4).getWidth(),  appear_block3.get(4).getHeight(), null); //
	    }
	    
	    g2d.drawImage(one_wall_I, block.get(29).getX(), block.get(29).getY(), block.get(29).getWidth(),  block.get(29).getHeight(), null); //---나타나기 5---
	    g2d.drawImage(one_wall_I, block.get(30).getX(), block.get(30).getY(), block.get(30).getWidth(),  block.get(30).getHeight(), null); //---나타나기 5---
	    g2d.drawImage(one_wall_I, block.get(31).getX(), block.get(31).getY(), block.get(31).getWidth(),  block.get(31).getHeight(), null); //---나타나기 5---
	    g2d.drawImage(one_wall_I, block.get(32).getX(), block.get(32).getY(), block.get(32).getWidth(),  block.get(32).getHeight(), null); //---나타나기 5---
	    g2d.drawImage(one_wall_I, block.get(33).getX(), block.get(33).getY(), block.get(33).getWidth(),  block.get(33).getHeight(), null); //---나타나기 5---
	    g2d.drawImage(one_wall_I, block.get(34).getX(), block.get(34).getY(), block.get(34).getWidth(),  block.get(34).getHeight(), null); //---나타나기 5---
	    
		if(PlatformScene_Three.onBlock1) { // 블록나타남1
			g2d.drawImage(one_wall_I, appear_block.get(0).getX(), appear_block.get(0).getY(), appear_block.get(0).getWidth(),  appear_block.get(0).getHeight(), null);
			g2d.drawImage(one_wall_I, appear_block.get(1).getX(), appear_block.get(1).getY(), appear_block.get(1).getWidth(),  appear_block.get(1).getHeight(), null);
			g2d.drawImage(one_wall_I, appear_block.get(2).getX(), appear_block.get(2).getY(), appear_block.get(2).getWidth(),  appear_block.get(2).getHeight(), null);
		}
		
		if(PlatformScene_Three.onBlock2) {//블록나타남2
			g2d.drawImage(wall_2_h_I, appear_block2.get(0).getX(), appear_block2.get(0).getY(), appear_block2.get(0).getWidth(),  appear_block2.get(0).getHeight(), null);
			g2d.drawImage(one_wall_I, appear_block2.get(1).getX(), appear_block2.get(1).getY(), appear_block2.get(1).getWidth(),  appear_block2.get(1).getHeight(), null);
			g2d.drawImage(one_wall_I, appear_block2.get(2).getX(), appear_block2.get(2).getY(), appear_block2.get(1).getWidth(),  appear_block2.get(2).getHeight(), null);
		}
		
		if(PlatformScene_Three.outBlock1) // 블록 사라짐1
			g2d.drawImage(wall_3h_I, out_block1.get(0).getX(), out_block1.get(0).getY(), out_block1.get(0).getWidth(),  out_block1.get(0).getHeight(), null);
		
		if(PlatformScene_Three.outBlock2)
			g2d.drawImage(wall_3h_I, out_block2.get(0).getX(), out_block2.get(0).getY(), out_block2.get(0).getWidth(),  out_block2.get(0).getHeight(), null); 
		
		//입, 출 구
		g2d.drawImage(reddoor_I, door_block.get(0).getX(), door_block.get(0).getY(), door_block.get(0).getWidth(),  door_block.get(0).getHeight(), null); 
		g2d.drawImage(bluedoor_I, door_block.get(1).getX(), door_block.get(1).getY(), door_block.get(1).getWidth(),  door_block.get(1).getHeight(), null); 
		g2d.drawImage(reddoor_I, door_block.get(2).getX(), door_block.get(2).getY(), door_block.get(2).getWidth(),  door_block.get(2).getHeight(), null); 
		g2d.drawImage(bluedoor_I, door_block.get(3).getX(), door_block.get(3).getY(), door_block.get(3).getWidth(),  door_block.get(3).getHeight(), null); 
		
		
		
		//화염블록 
		if(PlatformScene_Three.onfire1)
			g2d.drawImage(fire1_block, fire_block.get(0).getX(), fire_block.get(0).getY(), fire_block.get(0).getWidth(),  fire_block.get(0).getHeight(), null); 
		
		g2d.drawImage(fire2_block, fire_block.get(1).getX(), fire_block.get(1).getY(), fire_block.get(1).getWidth(),  fire_block.get(1).getHeight(), null);
		g2d.drawImage(fire1_block, fire_block.get(2).getX(), fire_block.get(2).getY(), fire_block.get(2).getWidth(),  fire_block.get(2).getHeight(), null);
		
		//2층 랜덤 블록
	    g2d.drawImage(blueb_I, block.get(35).getX(), block.get(35).getY(), block.get(35).getWidth(),  block.get(35).getHeight(), null); 
	    g2d.drawImage(blueb_I, block.get(36).getX(), block.get(36).getY(), block.get(36).getWidth(),  block.get(36).getHeight(), null); 
	    g2d.drawImage(bluebutton_I, block.get(37).getX(), block.get(37).getY(), block.get(37).getWidth(),  block.get(37).getHeight(), null); 
	    g2d.drawImage(right_left, shoot_block.get(24).getX(), shoot_block.get(24).getY(), shoot_block.get(24).getWidth(),  shoot_block.get(24).getHeight(), null); //장애물 총알..?
	    g2d.drawImage(up_down, shoot_block.get(25).getX(), shoot_block.get(25).getY(), shoot_block.get(25).getWidth(),  shoot_block.get(25).getHeight(), null); //장애물 총알..?
	    g2d.drawImage(up_down, shoot_block.get(26).getX(), shoot_block.get(26).getY(), shoot_block.get(26).getWidth(),  shoot_block.get(26).getHeight(), null); //장애물 총알..?
	    g2d.drawImage(up_down, shoot_block.get(27).getX(), shoot_block.get(27).getY(), shoot_block.get(27).getWidth(),  shoot_block.get(27).getHeight(), null); //장애물 총알..?
	    g2d.drawImage(left_right, shoot_block.get(28).getX(), shoot_block.get(28).getY(), shoot_block.get(28).getWidth(),  shoot_block.get(28).getHeight(), null); //장애물 총알..?
	    
		//장애물
		g2d.drawImage(hurdle_I, obstacle.get(0).getX(), obstacle.get(0).getY(), obstacle.get(0).getWidth(),  obstacle.get(0).getHeight(), null);
		g2d.drawImage(hurdle_I, obstacle.get(1).getX(), obstacle.get(1).getY(), obstacle.get(1).getWidth(),  obstacle.get(1).getHeight(), null); 
		g2d.drawImage(hurdle_I, obstacle.get(2).getX(), obstacle.get(2).getY(), obstacle.get(2).getWidth(),  obstacle.get(2).getHeight(), null); 
		g2d.drawImage(hurdle_I, obstacle.get(3).getX(), obstacle.get(3).getY(), obstacle.get(3).getWidth(),  obstacle.get(3).getHeight(), null); 
		g2d.drawImage(hurdleB_I, obstacle.get(4).getX(), obstacle.get(4).getY(), obstacle.get(4).getWidth(),  obstacle.get(4).getHeight(), null); 
		g2d.drawImage(hurdle_I, obstacle.get(5).getX(), obstacle.get(5).getY(), obstacle.get(5).getWidth(),  obstacle.get(5).getHeight(), null); 
		g2d.drawImage(hurdle_I, obstacle.get(6).getX(), obstacle.get(6).getY(), obstacle.get(6).getWidth(),  obstacle.get(6).getHeight(), null); 
		g2d.drawImage(hurdleB_I, obstacle.get(7).getX(), obstacle.get(7).getY(), obstacle.get(7).getWidth(),  obstacle.get(7).getHeight(), null); 
		g2d.drawImage(hurdleB_I, obstacle.get(8).getX(), obstacle.get(8).getY(), obstacle.get(8).getWidth(),  obstacle.get(8).getHeight(), null); 
		g2d.drawImage(hurdleB_I, obstacle.get(9).getX(), obstacle.get(9).getY(), obstacle.get(9).getWidth(),  obstacle.get(9).getHeight(), null); 
		g2d.drawImage(hurdle_I, obstacle.get(10).getX(), obstacle.get(10).getY(), obstacle.get(10).getWidth(),  obstacle.get(10).getHeight(), null); 
		
		if(PlatformScene_Three.stopblock1)
			g2d.drawImage(wall_3h_I, stopblock.get(0).getX(), stopblock.get(0).getY(), stopblock.get(0).getWidth(), stopblock.get(0).getHeight(), null); //stopblock
		
		
		
		
		
		
		//레드 다이아
		if(PlatformScene_Three.reddir1)
			g2d.drawImage(readia, dia.get(0).getX(), dia.get(0).getY(), dia.get(0).getWidth(),  dia.get(0).getHeight(), null);
		else
			diaCount++;
		if(diaCount==1)
			PlatformScene_One.diaSound();
		if(PlatformScene_Three.bluedir1)
			g2d.drawImage(bluedia1, dia.get(1).getX(), dia.get(1).getY(), dia.get(1).getWidth(),  dia.get(1).getHeight(), null);
		else
			diaCount1++;
		if(diaCount1==1)
			PlatformScene_One.diaSound();
		if(PlatformScene_Three.reddir2)
			g2d.drawImage(readia, dia.get(2).getX(), dia.get(2).getY(), dia.get(2).getWidth(),  dia.get(2).getHeight(), null);
		else 
			diaCount2++;
		if(diaCount2==1)
			PlatformScene_One.diaSound();
		if(PlatformScene_Three.bluedir2)
			g2d.drawImage(bluedia1, dia.get(3).getX(), dia.get(3).getY(), dia.get(3).getWidth(),  dia.get(3).getHeight(), null);
		else
			diaCount3++;
		if(diaCount3==1)
			PlatformScene_One.diaSound();
		if(PlatformScene_Three.stopblock2)
			g2d.drawImage(wall_3h_I, stopblock.get(1).getX(), stopblock.get(1).getY(), stopblock.get(1).getWidth(), stopblock.get(1).getHeight(), null); //stopblock
		
		if(PlatformScene_Three.reddir3)
			g2d.drawImage(readia, dia.get(4).getX(), dia.get(4).getY(), dia.get(4).getWidth(),  dia.get(4).getHeight(), null);
		else	
			diaCount4++;
		if(diaCount4==1)
			PlatformScene_One.diaSound();
		if(PlatformScene_Three.reddir4)
			g2d.drawImage(readia, dia.get(5).getX(), dia.get(5).getY(), dia.get(5).getWidth(),  dia.get(5).getHeight(), null);
		else
			diaCount5++;
		if(diaCount5==1)
			PlatformScene_One.diaSound();
		if(PlatformScene_Three.stopblock3)
			g2d.drawImage(wall_3h_I, stopblock.get(2).getX(), stopblock.get(2).getY(), stopblock.get(2).getWidth(), stopblock.get(2).getHeight(), null); //stopblock
		
		if(PlatformScene_Three.bluedir3)
			g2d.drawImage(bluedia1, dia.get(6).getX(), dia.get(6).getY(), dia.get(6).getWidth(),  dia.get(6).getHeight(), null);
		else
			diaCount6++;
		if(diaCount6==1)
			PlatformScene_One.diaSound();	
		

	}
	public void sound(File file) {	 
	      try {

	         AudioInputStream stream = AudioSystem.getAudioInputStream(file);
	         Clip clip = AudioSystem.getClip();
	         clip.open(stream);
	         clip.start();
	         

	      } catch(Exception e1) {
	         e1.printStackTrace();
	      }  
	}
}
