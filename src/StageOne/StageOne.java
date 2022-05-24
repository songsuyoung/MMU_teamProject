package StageOne;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Image;
import java.awt.Graphics2D;

public class StageOne extends GameObject_One {
	
	ImageIcon background1 = new ImageIcon("images/07.jpg");
	Image background_I = background1.getImage();
	
	ArrayList<BlockObject> block;
	ArrayList<BlockObject> cloud_block;
	ArrayList<BlockObject> item;
	ArrayList<BlockObject> door;
	ArrayList<BlockObject> swingblock;
	ArrayList<BlockObject> hurdleblock;
	ArrayList<BlockObject> firewater;
	ArrayList<BlockObject> clockingblock;
	ArrayList<BlockObject> button;
	ArrayList<BlockObject> onbutton;
	
	//

	int diaCount=0;
	int diaCount1=0;
	int diaCount2=0;
	//
	int diaCount3=0;
	
	ImageIcon five = new ImageIcon("images/wall_5.png");
	Image five_img = five.getImage();
	ImageIcon four = new ImageIcon("images/wall_4.png");
	Image four_img = four.getImage();

	ImageIcon three = new ImageIcon("images/wall_3.png");
	Image three_img = three.getImage();

	ImageIcon eight = new ImageIcon("images/wall_8.png");
	Image eight_img = eight.getImage();

	ImageIcon one = new ImageIcon("images/one_wall.png");
	Image one_img = one.getImage();

	ImageIcon nine = new ImageIcon("images/wall_9.png");
	Image nine_img = nine.getImage();

	ImageIcon height_three = new ImageIcon("images/wall_3h.png");
	Image three_himg = height_three.getImage();

	ImageIcon two = new ImageIcon("images/wall_2.png");
	Image two_img = two.getImage();

	ImageIcon six = new ImageIcon("images/wall_6.png");
	Image six_img = six.getImage();

	ImageIcon sixw = new ImageIcon("images/wall_6w.png");
	Image sixw_img = sixw.getImage();

	ImageIcon wall_25_w = new ImageIcon("images/wall_25x20_w.png");
	Image wall_25_w_I = wall_25_w.getImage();

	ImageIcon wall_20_h = new ImageIcon("images/wall_bk_h.png");
	Image wall_20_h_I = wall_20_h.getImage();

	ImageIcon cloud = new ImageIcon("images/cloud.png");
	Image cloud_img = cloud.getImage();

	ImageIcon blackcloud = new ImageIcon("images/blackclou"
			+ "d.png");
	Image blackcloud_img = blackcloud.getImage();

	ImageIcon background = new ImageIcon("images/background.png");
	Image background_img = background1.getImage();

	ImageIcon bluediamond = new ImageIcon("images/bluedia.png.png");
	Image bludia_img = bluediamond.getImage();

	ImageIcon reddiamond = new ImageIcon("images/reddia.png.png");
	Image reddia_img = reddiamond.getImage();

	ImageIcon reddoor = new ImageIcon("images/red_d.png");
	Image redd_image = reddoor.getImage();

	ImageIcon bluedoor = new ImageIcon("images/blue.png");
	Image blued_image = bluedoor.getImage();

	ImageIcon blueBlock = new ImageIcon("images/blue_one.png");
	Image blueBlock_image = blueBlock.getImage();

	ImageIcon redBlock = new ImageIcon("images/red_one.png");
	Image redBlock_image = redBlock.getImage();

	ImageIcon hurdle = new ImageIcon("images/hurdle.png.png");
	Image hurdle_image = hurdle.getImage();

	ImageIcon fire = new ImageIcon("images/fire2.png");
	Image fire_image = fire.getImage();

	ImageIcon water = new ImageIcon("images/water.png");
	Image water_image = water.getImage();
	
	ImageIcon bluebutton = new ImageIcon("images/bluebutton.png");
	Image bluebutton_image = bluebutton.getImage();
	
	ImageIcon redbutton = new ImageIcon("images/redbutton.png");
	Image redbutton_image = redbutton.getImage();
	
	
	ImageIcon onbluebutton = new ImageIcon("images/blueOnbutton.png");
	Image onbluebutton_image = onbluebutton.getImage();
	
	ImageIcon onredbutton = new ImageIcon("images/redOnbutton.png");
	Image onredbutton_image = onredbutton.getImage();

	public StageOne() {
		
		block = new ArrayList<BlockObject>();
		cloud_block = new ArrayList<BlockObject>();
		item = new ArrayList<BlockObject>();
		swingblock = new ArrayList<BlockObject>();
		hurdleblock = new ArrayList<BlockObject>();
		firewater = new ArrayList<BlockObject>();
		clockingblock = new ArrayList<BlockObject>();
		button = new ArrayList<BlockObject>();
		onbutton = new ArrayList<BlockObject>();

		block.add(new BlockObject(0, 0, 1000, 40));
		block.add(new BlockObject(0, 0, 40, 760));
		block.add(new BlockObject(0, 720, 40 * 25, 40));
		block.add(new BlockObject(960, 0, 40, 760));

		block.add(new BlockObject(160, 120, 40 * 5, 40)); // 1번블록

		block.add(new BlockObject(240, 160, 40, 40 * 15)); // 1번기둥
		block.add(new BlockObject(280, 240, 40 * 3, 40)); // 280, 240 블럭3개(우측)
		block.add(new BlockObject(160, 320, 40 * 2, 40)); // 1번기둥 160,320좌표에 해당하는 블럭 2개(좌측)
		block.add(new BlockObject(280, 400, 40 * 3, 40)); //// 1번기둥 280,400좌표에 해당하는 블럭3개(우측)
		block.add(new BlockObject(160, 480, 40 * 2, 40)); // //1번기둥 160,480좌표에 해당하는 블럭2개(좌측)
		block.add(new BlockObject(280, 560, 40 * 3, 40)); // 1번기둥 280,560좌표에 해당하는 블럭3개(우측)
		block.add(new BlockObject(400, 160, 40 * 6, 40));
		block.add(new BlockObject(480, 200, 40 * 2, 40 * 3));
		block.add(new BlockObject(480, 360, 40 * 2, 40 * 3));
		block.add(new BlockObject(480, 520, 40 * 2, 40 * 3));
		block.add(new BlockObject(480, 680, 40 * 2, 40 * 3));

		/* -------------------------------------------- */
		block.add(new BlockObject(680, 120, 40 * 5, 40));
		block.add(new BlockObject(760, 160, 40, 40 * 15));
		block.add(new BlockObject(640, 240, 40 * 3, 40));
		block.add(new BlockObject(640, 400, 40 * 3, 40));
		block.add(new BlockObject(800, 480, 40 * 2, 40)); // block.add(new BlockObject(800, 480, 40 * 2, 40));
		block.add(new BlockObject(800, 320, 40 * 2, 40));
		block.add(new BlockObject(640, 560, 40 * 3, 40));

		cloud_block.add(new BlockObject(600, 110, 70, 60));
		cloud_block.add(new BlockObject(600, 320, 70, 60));

		item.add(new BlockObject(280, 520, 40, 40)); 	//item.add(new BlockObject(280, 360, 40, 40));
		item.add(new BlockObject(720, 360, 40, 40));   //item.add(new BlockObject(720, 360, 40, 40));
		item.add(new BlockObject(200, 280, 40, 40));	//
		item.add(new BlockObject(800, 280, 40, 40));

		// ---------------------------------------------------

		swingblock.add(new BlockObject(80, 180, 40, 40));
		swingblock.add(new BlockObject(920, 180, 40, 40));

		// ----------------------------------------------------
		// g.drawImage(hurdle_image, 250, 505, 100, 80, null);
		// g.drawImage(hurdle_image, 690, 505, 100, 80, null);
		hurdleblock.add(new BlockObject(650, 345, 100, 80)); //505 - 200
		hurdleblock.add(new BlockObject(290, 505, 100, 80));
		
		
		/*
		hurdleblock.add(new BlockObject(290, 505, 100, 80));
		hurdleblock.add(new BlockObject(650, 505, 100, 80));
		
		 */


		firewater.add(new BlockObject(800, 680, 40, 40));
		firewater.add(new BlockObject(840, 680, 40, 40));
		firewater.add(new BlockObject(880, 680, 40, 40));
		firewater.add(new BlockObject(920, 680, 40, 40));

		firewater.add(new BlockObject(30, 670, 80, 80));
		firewater.add(new BlockObject(80, 670, 80, 80));
		firewater.add(new BlockObject(130, 670, 80, 80));
		firewater.add(new BlockObject(180, 670, 80, 80));

		
		
		/*
		g.drawImage(four_img, 440, 320, 160 , 40 ,null);
		g.drawImage(four_img, 440, 480, 160 , 40 ,null);
		g.drawImage(four_img, 440, 640, 160 , 40 ,null);
		*/
		
		clockingblock.add(new BlockObject(400, 330, 160, 20));
		clockingblock.add(new BlockObject(440, 490, 160, 20));
		clockingblock.add(new BlockObject(480, 650, 160, 20));
		
		//g.drawImage(bluebutton_image,720, 540 , 40, 20, null);
		//g.drawImage(redbutton_image,280, 385 , 40, 20, null);
		
		button.add(new BlockObject(280, 225, 40, 20));
		button.add(new BlockObject(720, 540, 40, 20));
		
		onbutton.add(new BlockObject(280, 225, 40, 20));
		onbutton.add(new BlockObject(720, 540, 40, 20));
		//button.add(new BlockObject(280, 385, 40, 20));
		/*
		 * g.drawImage(one_img, 320, 120, null); g.drawImage(eight_img, 240, 160, null);
		 * g.drawImage(six_img, 240, 480, null); g.drawImage(one_img, 240, 720, null);
		 * g.drawImage(three_img, 280, 240, null); g.drawImage(two_img, 160, 320, null);
		 * g.drawImage(three_img, 280, 400, null); g.drawImage(two_img, 160, 480, null);
		 * g.drawImage(three_img, 280, 560, null);
		 */

		// g.drawImage(reddia_img, 200, 280, 40, 40 ,null );
		// g.drawImage(bludia_img, 800, 280, 40, 40 ,null );
		// g.drawImage(reddia_img , 280, 360, 40, 40, null);
		// g.drawImage(bludia_img , 720, 360, 40, 40, null);
		door = new ArrayList<BlockObject>();
		door.add(new BlockObject(170, 405, 80, 80));
		door.add(new BlockObject(780, 405, 80, 80));

	}

	@Override
	public void updateLocation() {

	}

	public void updatecloudblock() {

		if (PlatformScene_One.Cloud_rightmoving == false) {
			cloud_block.get(0).x += 1;
			if (cloud_block.get(0).x >= 800) {
				PlatformScene_One.Cloud_rightmoving = true;
			}
		} else if (PlatformScene_One.Cloud_rightmoving) {
			cloud_block.get(0).x -= 1;
			if (cloud_block.get(0).x <= 600) {
				PlatformScene_One.Cloud_rightmoving = false;
			}
		}
	}

	public void updatecloudblock2() {

		if (PlatformScene_One.Cloud2_rightmoving == false) {
			cloud_block.get(1).x -= 1;
			if (cloud_block.get(1).x <= 300) {
				PlatformScene_One.Cloud2_rightmoving = true;
			}
		} else if (PlatformScene_One.Cloud2_rightmoving) {
			cloud_block.get(1).x += 1;
			if (cloud_block.get(1).x >= 600) {
				PlatformScene_One.Cloud2_rightmoving = false;
			}
		}
	}
	
	public void updatecloudblock3() {
		if(PlatformScene_One.swingblock_collins1p  ) {
			swingblock.get(1).y +=1;
			PlatformScene_One.hero.setY(swingblock.get(0).y - 39);			
			if(swingblock.get(1).y >=600) {
				swingblock.get(1).y=600;
				PlatformScene_One.end_2p = true;
			}
		}
		else if(PlatformScene_One.end_2p) {
			if(PlatformScene_One.swingblock_collins1p ==false) {
				swingblock.get(1).y -= 1;
				if(swingblock.get(1).y <=200) {
					swingblock.get(1).y=200;
					PlatformScene_One.end_2p = false;
				}
					
			}	
			else if(PlatformScene_One.swingblock_collins2p ==true) {
				swingblock.get(1).y -= 1;
				PlatformScene_One.hero2.setY(swingblock.get(1).y - 39);	
				if(swingblock.get(1).y <=200) {
					swingblock.get(1).y=200;
					PlatformScene_One.end_2p = false;
				}
				
			}
	
		}
	}
	
	
	public void updatecloudblock4() {
		if(PlatformScene_One.swingblock_collins2p  ) {
			swingblock.get(0).y +=1;
			PlatformScene_One.hero2.setY(swingblock.get(1).y - 39);			
			if(swingblock.get(0).y >=600) {
				swingblock.get(0).y=600;
				PlatformScene_One.end_1p = true;
			}
		}
		else if(PlatformScene_One.end_1p) {
			if(PlatformScene_One.swingblock_collins2p ==false) {
				swingblock.get(0).y -= 1;
				if(swingblock.get(0).y <=200) {
					swingblock.get(0).y=200;
					PlatformScene_One.end_1p = false;
				}
					
			}	
			else if(PlatformScene_One.swingblock_collins1p ==true) {
				swingblock.get(0).y -= 1;
				PlatformScene_One.hero.setY(swingblock.get(0).y - 39);	
				if(swingblock.get(0).y <=200) {
					swingblock.get(0).y=200;
					PlatformScene_One.end_1p = false;
				}
				
			}
	
		}
	}
	
	public void updatecloudblock5() {
		if(PlatformScene_One.redbutton_collins) {
			clockingblock.get(0).x +=1;
			if(PlatformScene_One.check_sound1==1) {
				PlatformScene_One.moveSound();
				PlatformScene_One.check_sound1++;
			}
			else
				PlatformScene_One.check_sound1++;
			if(clockingblock.get(0).x >= 480) {
				clockingblock.get(0).x = 480;
				
				//button.remove(0);
			}
		}
		
		if(PlatformScene_One.bluebutton_collins) {
			clockingblock.get(2).x -= 1;
			if(PlatformScene_One.check_sound==1) {
				PlatformScene_One.moveSound();
				PlatformScene_One.check_sound++;
			}
			else
				PlatformScene_One.check_sound++;
			
			if(clockingblock.get(2).x <440) {
				
				clockingblock.get(2).x = 440;
			}
		}
	}
	
	
	
	/*
	public void updatecloudblock3() {

		if (FlatformScene.checkswingblockTop) {
			if (FlatformScene.swingblock_Moving == false) {
				// swingblock.get(0).y += 1;
				swingblock.get(1).y += 1;
				FlatformScene.hero.setY(swingblock.get(0).y - 39);
				if (swingblock.get(0).y >= 700 && swingblock.get(1).y >= 700) {
					//swingblock.get(0).y >= 700 &&
					FlatformScene.swingblock_Moving = true;
					//FlatformScene.checkswingblockTop =false;
				}
			} else if (FlatformScene.checkswingblockTop == false) {
				// swingblock.get(0).y -= 1;
				swingblock.get(1).y -= 1;
				FlatformScene.hero.setY(swingblock.get(0).y - 39);
				if (swingblock.get(1).y <= 120) {
					swingblock.get(1).y = 179;
					FlatformScene.swingblock_Moving = false;
					FlatformScene.checkswingblockTop = true;
					// FlatformScene.swingblock_Moving2p = false;
				}
			}
		} 

	}
	*/

	/*
	public void updatecloudblock4() {
		if (FlatformScene.checkswingblockTop2p) {
			if (FlatformScene.swingblock_Moving2p == false) {
				swingblock.get(0).y += 1;
				// swingblock.get(1).y += 1;
				FlatformScene.hero2.setY(swingblock.get(0).y - 39);
				if (swingblock.get(0).y >= 700 && swingblock.get(1).y >= 700) {
					FlatformScene.swingblock_Moving2p = true;
				}
			} else if (FlatformScene.swingblock_Moving2p) {
				swingblock.get(0).y -= 1;
				// swingblock.get(1).y -= 1;
				FlatformScene.hero2.setY(swingblock.get(0).y - 39);
				if (swingblock.get(0).y <= 120) {
					FlatformScene.swingblock_Moving2p = false;
					// FlatformScene.swingblock_Moving = false;
				}
			}
		}

	}
	*/
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(background_I,0,0,1000,800,null);//배경

		g.drawImage(background_img, 0, 0, 1000, 800, null);// 배경
		g.drawImage(wall_25_w_I, block.get(0).x, block.get(0).y, null);
		g.drawImage(wall_20_h_I, block.get(1).x, block.get(1).y, null);
		g.drawImage(wall_25_w_I, block.get(2).x, block.get(2).y, null);
		g.drawImage(wall_20_h_I, block.get(3).x, block.get(3).y, null);
		g.drawImage(four_img, block.get(4).x, block.get(4).y, null);

		g.drawImage(one_img, 320, 120, null);
		g.drawImage(eight_img, 240, 160, null);
		g.drawImage(six_img, 240, 480, null);
		g.drawImage(one_img, 240, 720, null);
		g.drawImage(three_img, 280, 240, null);
		g.drawImage(two_img, 160, 320, null);
		g.drawImage(three_img, 280, 400, null);
		g.drawImage(two_img, 160, 480, null);
		g.drawImage(three_img, 280, 560, null);

		/* ---------------------------------------------- */

		g.drawImage(sixw_img, 400, 160, null);
		g.drawImage(three_himg, 480, 200, null);
		g.drawImage(three_himg, 520, 200, null);
		g.drawImage(three_himg, 480, 360, null);
		g.drawImage(three_himg, 520, 360, null);
		g.drawImage(three_himg, 480, 520, null);
		g.drawImage(three_himg, 520, 520, null);
		g.drawImage(one_img, 480, 680, null);
		g.drawImage(one_img, 520, 680, null);
		g.drawImage(one_img, 480, 720, null);
		g.drawImage(one_img, 520, 720, null);
		g.drawImage(four_img, 680, 120, null);
		g.drawImage(one_img, 840, 120, null);
		g.drawImage(eight_img, 760, 160, null);
		g.drawImage(six_img, 760, 480, null);
		g.drawImage(one_img, 760, 720, null);
		g.drawImage(three_img, 640, 240, null);
		g.drawImage(two_img, 800, 320, null);
		g.drawImage(three_img, 640, 400, null);
		g.drawImage(two_img, 800, 480, null);
		g.drawImage(three_img, 640, 560, null);

		// g.drawImage(blackcloud_img, 480, 100, null);

		/*
		g.drawImage(cloud_img, cloud_block.get(0).getX(), cloud_block.get(0).getY(), cloud_block.get(0).getWidth(),
				cloud_block.get(0).getHeight(), null);
		g.drawImage(cloud_img, cloud_block.get(1).getX(), cloud_block.get(1).getY(), cloud_block.get(1).getWidth(),
				cloud_block.get(1).getHeight(), null);
				
		*/		
		// g.drwaImage()

		// --------------------------------------------------------------

		// g.drawImage(reddia_img, item.get(0).getX(), item.get(0).getY(), 60, 60,
		// null);
		// g.drawImage(cloud_img, 400, 320, 70, 60, null);
		
		if(PlatformScene_One.reddir1) {
			g.drawImage(reddia_img, item.get(0).getX(), item.get(0).getY(), item.get(0).getWidth(), item.get(0).getHeight(), null);
		}else {
			diaCount++;
		}
		if(diaCount==1)
			PlatformScene_One.diaSound();
		if(PlatformScene_One.bluedir1)
			g.drawImage(bludia_img, item.get(1).getX(), item.get(1).getY(), item.get(1).getWidth(), item.get(1).getHeight(), null);
		else
			diaCount1++;
		if(diaCount1==1)
			PlatformScene_One.diaSound();
		if(PlatformScene_One.reddir2)
			g.drawImage(reddia_img, item.get(2).getX(), item.get(2).getY(), item.get(2).getWidth(), item.get(2).getHeight(), null);
		else
			diaCount2++;
		if(diaCount2==1)
			PlatformScene_One.diaSound();
		if(PlatformScene_One.bluedir2)
			g.drawImage(bludia_img, item.get(3).getX(), item.get(3).getY(), item.get(3).getWidth(), item.get(3).getHeight(), null);
		else
			diaCount3++;
		if(diaCount3==1)
			PlatformScene_One.diaSound();
		// --------------------------------------------------------------------------------------

		g.drawImage(redd_image, door.get(0).getX(), door.get(0).getY(), door.get(0).getWidth(), door.get(0).getHeight(), null);
		g.drawImage(blued_image, door.get(1).getX(), door.get(1).getY(), door.get(1).getWidth(), door.get(1).getHeight(), null);
	

		// -----------------------------------------------------------
		g.drawImage(redBlock_image, swingblock.get(0).getX(), swingblock.get(0).getY(), swingblock.get(0).getWidth(),
				swingblock.get(0).getHeight(), null);
		g.drawImage(blueBlock_image, swingblock.get(1).getX(), swingblock.get(1).getY(), swingblock.get(1).getWidth(),
				swingblock.get(1).getHeight(), null);

		// --------------------------------------------------------------

		g.drawImage(hurdle_image, hurdleblock.get(0).getX(), hurdleblock.get(0).getY(), hurdleblock.get(0).getWidth(),
				hurdleblock.get(0).getHeight(), null);
		g.drawImage(hurdle_image, hurdleblock.get(1).getX(), hurdleblock.get(1).getY(), hurdleblock.get(1).getWidth(),
				hurdleblock.get(1).getHeight(), null);

		g.drawImage(fire_image, firewater.get(0).getX(), firewater.get(0).getY(), firewater.get(0).getWidth(),
				firewater.get(0).getHeight(), null);
		g.drawImage(fire_image, firewater.get(1).getX(), firewater.get(1).getY(), firewater.get(1).getWidth(),
				firewater.get(1).getHeight(), null);
		g.drawImage(fire_image, firewater.get(2).getX(), firewater.get(2).getY(), firewater.get(2).getWidth(),
				firewater.get(2).getHeight(), null);
		g.drawImage(fire_image, firewater.get(3).getX(), firewater.get(3).getY(), firewater.get(3).getWidth(),
				firewater.get(3).getHeight(), null);

		g.drawImage(water_image, firewater.get(4).getX(), firewater.get(4).getY(), firewater.get(4).getWidth(),
				firewater.get(4).getHeight(), null);
		g.drawImage(water_image, firewater.get(5).getX(), firewater.get(5).getY(), firewater.get(5).getWidth(),
				firewater.get(5).getHeight(), null);
		g.drawImage(water_image, firewater.get(6).getX(), firewater.get(6).getY(), firewater.get(6).getWidth(),
				firewater.get(6).getHeight(), null);
		g.drawImage(water_image, firewater.get(7).getX(), firewater.get(7).getY(), firewater.get(7).getWidth(),
				firewater.get(7).getHeight(), null);
		// g.drawImage(water_image, 400, 500, 40, 40, null);
		
		//ArrayList<BlockObject> clockingblock;
		g.drawImage(four_img , clockingblock.get(0).getX(), clockingblock.get(0).getY(), clockingblock.get(0).getWidth(), clockingblock.get(0).getHeight(), null);
		g.drawImage(four_img , clockingblock.get(1).getX(), clockingblock.get(1).getY(), clockingblock.get(1).getWidth(), clockingblock.get(1).getHeight(), null);
		g.drawImage(four_img , clockingblock.get(2).getX(), clockingblock.get(2).getY(), clockingblock.get(2).getWidth(), clockingblock.get(2).getHeight(), null);
		
		
		//-------------------------------------------------------------
		g.drawImage(cloud_img, cloud_block.get(0).getX(), cloud_block.get(0).getY(), cloud_block.get(0).getWidth(),
				cloud_block.get(0).getHeight(), null);
		g.drawImage(cloud_img, cloud_block.get(1).getX(), cloud_block.get(1).getY(), cloud_block.get(1).getWidth(),
				cloud_block.get(1).getHeight(), null);
		
		
		
		
		g.drawImage(redbutton_image, button.get(0).getX(),button.get(0).getY(),button.get(0).getWidth(),button.get(0).getHeight(),null);
		g.drawImage(bluebutton_image, button.get(1).getX(),button.get(1).getY(),button.get(1).getWidth(),button.get(1).getHeight(),null);
		/*
		hurdleblock.add(new BlockObject(290, 505, 100, 80));
		hurdleblock.add(new BlockObject(650, 505, 100, 80));
		*/
	}
}
