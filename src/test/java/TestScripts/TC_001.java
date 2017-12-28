/**
 * 
 */
package TestScripts;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import FrameworkBase.AppiumTestInit;
import PageActions.Page1;
import io.appium.java_client.AppiumDriver;

/**
 * 
 * Project Name			:	Halo
 * Package Name			:	TestScripts
 * File Name			:	TC_001.java
 * Description			:	Test Case 001. 
 * Inherited Classes	:	
 * Created By			:	fqw4433
 * Created Date			:	Dec 20, 2017 at 2:28:23 PM
 * Reviewer				:
 * Comments 			:
 *
 *	 
 */
public class TC_001 {
	
	private AppiumDriver<?> driver;
	
	@Test
    @Parameters( { "platform", "udid", "platformVersion"})
	public void testCalculateDefaultTip(String platform, String udid, String platformVersion) throws Exception {
		driver = AppiumTestInit.returnDriver(platform, udid, platformVersion);

		Page1 page_obj = new Page1(driver);
		
		page_obj.testMethod();
	
	

}
}
