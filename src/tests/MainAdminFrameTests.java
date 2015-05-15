package tests;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MainAdminFrameTests {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void test() {
		Robot bot;
		try {
			bot = new Robot();
			Random r=new Random();
			int x=r.nextInt(1000);
			int y=r.nextInt(1000);
		for (int i = 0; i < 1000; i++) {
			/*bot.mouseMove(50,50);
			try{Thread.sleep(15);}catch(InterruptedException e){}
			bot.mouseMove(150,150);
			try{Thread.sleep(15);}catch(InterruptedException e){}
			bot.mouseMove(150,50);
			try{Thread.sleep(15);}catch(InterruptedException e){}
			bot.mouseMove(50,150);
			try{Thread.sleep(15);}catch(InterruptedException e){}*/
			bot.mouseMove(x,y);
			try{Thread.sleep(15);}catch(InterruptedException e){}
			x=r.nextInt(1000);
			y=r.nextInt(1000);
		}
		//bot.mouseMove(10,10);
		//bot.mousePress(InputEvent.BUTTON1_MASK);
		//add time between press and release or the input event system may 
		//not think it is a click
		//try{Thread.sleep(250);}catch(InterruptedException e){}
		//bot.mouseRelease(InputEvent.BUTTON1_MASK);
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		fail("Not yet implemented"); // TODO
	}

}
