package Framework;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import resources.Framework.LoggerHelper;
import com.rational.test.ft.*;
import com.rational.test.ft.object.interfaces.*;
import com.rational.test.ft.object.interfaces.SAP.*;
import com.rational.test.ft.object.interfaces.WPF.*;
import com.rational.test.ft.object.interfaces.dojo.*;
import com.rational.test.ft.object.interfaces.siebel.*;
import com.rational.test.ft.object.interfaces.flex.*;
import com.rational.test.ft.object.interfaces.generichtmlsubdomain.*;
import com.rational.test.ft.script.*;
import com.rational.test.ft.value.*;
import com.rational.test.ft.vp.*;
import com.ibm.rational.test.ft.object.interfaces.sapwebportal.*;

/**
 * Description : Functional Test Script
 * 
 * @author admin
 */
public class Logger extends LoggerHelper {
	/**
	 * Script Name : <b>Logger</b> Generated : <b>Apr 15, 2013 4:34:29 PM</b>
	 * Description : Functional Test Script Original Host : WinNT Version 6.1
	 * Build 7600 ()
	 * 
	 * @since 2013/04/15
	 * @author admin
	 */
	public void infoMessage(String message) {

		logInfo(message);

	}

	public void errorMessage(String message, boolean takeSnapshot) {

		BufferedImage bi = null;

		try {

			Toolkit toolkit = Toolkit.getDefaultToolkit();

			Dimension screenSize = toolkit.getScreenSize();

			Rectangle screenRect = new Rectangle(screenSize);

			Robot robot = new Robot();

			// Capture the screen shot of the area of the screen defined by the
			// rectangle
			// BufferedImage bi=bc.getScreenSnapshot(new Rectangle(100,100));

			bi = robot.createScreenCapture(screenRect);

			// ImageIO.write(bi, "jpg",
			// new File("C:/SRM5510/" + System.currentTimeMillis()
			// + ".jpg"));

		} catch (AWTException e) {

			e.printStackTrace();

			// } catch (IOException e) {
			//
			// e.printStackTrace();
			//
			// }

			if (takeSnapshot) {

				logError(message, bi);

			} else {

				logError(message);

			}

		}
	}
}
