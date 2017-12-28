/**
 * 
 */
package PageObjects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

/**
 * 
 * Project Name			:	Halo
 * Package Name			:	PageObjects
 * File Name			:	PageElements1.java
 * Description			:	To hold the page Objects of ${PageElements} screen. 
 * Inherited Classes	:	-
 * Created By			:	fqw4433
 * Created Date			:	Dec 20, 2017 at 12:14:01 PM
 * Reviewer				:
 * Comments 			:
 *
 *	 
 */
public interface PageElements1 {

	@iOSFindBy(xpath		=	"//Xpath of IOS Locator")
    @AndroidFindBy(xpath	=	"//Xpath of Android Locator")
    public static final WebElement ElementName = null;
	
}
