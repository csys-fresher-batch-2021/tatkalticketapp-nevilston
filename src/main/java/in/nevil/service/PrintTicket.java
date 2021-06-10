package in.nevil.service;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class PrintTicket {

	public static void printScreen() {
  try {
   Robot robot = new Robot();
   Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
   
   BufferedImage screesnShot = robot.createScreenCapture(rect);
   
   ImageIO.write(screesnShot, "JPG", 
     new File ("\\screenshot.jpg"));
  } catch (Exception e) {
   e.printStackTrace();
  }
 }

}