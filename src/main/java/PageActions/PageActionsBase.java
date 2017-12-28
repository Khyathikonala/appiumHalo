/**
 * 
 */
package PageActions;

import io.appium.java_client.AppiumDriver;

/**
 * 
 * Project Name			:	Halo
 * Package Name			:	PageActions
 * File Name			:	PageActionsBase.java
 * Description			:	This class should be inherited in all the Page actions classes, As we are calling parameterized Constructors
 * 							for Screen capturing at failure location and initializing the driver object. 
 * Inherited Classes	:	-
 * Created By			:	fqw4433
 * Created Date			:	Dec 20, 2017 at 12:10:28 PM
 * Reviewer				:
 * Comments 			:
 *
 *	 
 */
public class PageActionsBase {
	

    protected AppiumDriver driver;

    protected PageActionsBase(AppiumDriver driver)
    {
    	
        this.driver = driver;
        
    }

}
