/**
 * 
 */
package FrameworkBase;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

/**
 * 
 * Project Name			:	Halo
 * Package Name			:	FrameworkBase
 * File Name			:	AppiumTestInit.java
 * Description			:	To Invoke and communicate with appium server. 
 * Inherited Classes	:	-
 * Created By			:	fqw4433
 * Created Date			:	Dec 22, 2017 at 12:52:52 PM
 * Reviewer				:
 * Comments 			:
 *
 *	 
 */
public class AppiumTestInit {
	
	public static String readProperty(String property) {
		Properties prop;
		String value = null;
		try {
			prop = new Properties();
			prop.load(new FileInputStream(new File("Config.properties")));
			
			value = prop.getProperty(property);
			
			if (value == null || value.isEmpty()) {
				throw new Exception("Value not set or empty");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}
	
	/*
	 * Return the proper driver based on platform parameter (android or ios)
	 * Also set the udid and platform version to be able to execute in a grid environment
	 */
	public static AppiumDriver<?> returnDriver(String platform, String udid, String platformVersion) throws Exception {
		AppiumDriver<?> driver;
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.UDID, udid);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);

		// create the complete URL based on config.properties information
		String completeURL = "http://" + AppiumTestInit.readProperty("run.ip") + ":" + AppiumTestInit.readProperty("run.port") + "/wd/hub";

        switch (platform.toLowerCase()) {
            case "ios":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
                capabilities.setCapability(MobileCapabilityType.PLATFORM, MobilePlatform.IOS);

                // if iOS 9+ use XCUITest
                if (Boolean.parseBoolean(AppiumTestInit.readProperty("platform.ios.xcode8"))) {
                    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                }

                if (Boolean.parseBoolean(AppiumTestInit.readProperty("install.app"))) {
                    capabilities.setCapability(MobileCapabilityType.APP, new File(AppiumTestInit.readProperty("app.ios.path")).getAbsolutePath());
                } else {
                    capabilities.setCapability(IOSMobileCapabilityType.APP_NAME, AppiumTestInit.readProperty("app.ios.appName"));
                }

                driver = new IOSDriver<>(new URL(completeURL), capabilities);
                break;

		case "android":
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            capabilities.setCapability(MobileCapabilityType.PLATFORM, MobilePlatform.ANDROID);

            if (Boolean.parseBoolean(AppiumTestInit.readProperty("install.app"))) {
                capabilities.setCapability(MobileCapabilityType.APP, new File(AppiumTestInit.readProperty("app.android.path")).getAbsolutePath());
            } else {
                capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, AppiumTestInit.readProperty("app.android.appPackage"));
                capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, AppiumTestInit.readProperty("app.android.appActivity"));
            }

            driver = new AndroidDriver<>(new URL(completeURL), capabilities);
            break;

         default:
             throw new Exception("Platform not supported! Check if you set ios or android on the parameter.");
        }

		return driver;
	}

}
