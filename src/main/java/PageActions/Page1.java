/**
 * 
 */
package PageActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import PageObjects.PageElements1;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * 
 * Project Name			:	Halo
 * Package Name			:	PageActions
 * File Name			:	Page1.java
 * Description			:	Holds Page actions for ${Page1}
 * Inherited Classes	:	PageActionsBase
 * Created By			:	fqw4433
 * Created Date			:	Dec 20, 2017 at 12:12:05 PM
 * Reviewer				:
 * Comments 			:
 *
 *	 
 */
public class Page1 extends PageActionsBase{
	
	
	
	public Page1(AppiumDriver driver) {
		
		super(driver);
		// TODO Auto-generated constructor stub
		
	}
	
	 	public static String platformData = "Android";
	    public  PageElements1 PageElements_obj;

	    public void pageFactory_Invoke(){
	    	
	    	PageElements_obj.ElementName.click();
	        PageFactory.initElements(new AppiumFieldDecorator(driver,20, TimeUnit.SECONDS), PageElements_obj);
	        	        
	    }
	    
	    public void testMethod() {}
	   
}