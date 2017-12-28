/**\
 * 
 * 
 */
package FrameworkBase;

import java.io.File;


/**
 * 
 * Project Name			:	Halo
 * Package Name			:	FrameworkBase
 * File Name			:	Utility.java
 * Description			:	Core Generic Methods like Capturing Screenshot, Creating folder structure,
 * 							Pause the execution for specified amount of time, etc.,
 * Inherited Classes	:	-
 * Created By			:	fqw4433
 * Created Date			:	Dec 21, 2017 at 10:43:24 AM
 * Reviewer				:
 * Comments 			:
 *
 *	 
 */
public class Utility {
	
	public static File outputFile;
    public static String localeName;
    public static String platformName;
    public static String androidPlatform = "Android";
    
    
    public static void pauseSeconds(int n) {
    	
        try {
            Thread.sleep(1000 * n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    
    public static void createScreenshotFolder() {
    	
    	System.out.println(outputFile.canExecute());
    	
    }

}
