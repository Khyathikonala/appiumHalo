/**
 * 
 */
package FrameworkBase;

import java.util.logging.Logger;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


/**
 * 
 * Project Name			:	Halo
 * Package Name			:	FrameworkBase
 * File Name			:	LoggingClass.java
 * Description			:	Stores all the tests that were run.
 * Inherited Classes	:	TestListenerAdapter
 * Created By			:	fqw4433
 * Created Date			:	Dec 20, 2017 at 10:46:43 AM
 * Reviewer				:
 * Comments 			:
 *
 *	 
 */
public class LoggingClass extends TestListenerAdapter{

	 private static final Logger LOGGER = Logger.getLogger(LoggingClass.class.getName());
	 

	    @Override
	    public void onTestSuccess(ITestResult tr) {
	    	
	    	log(getMessage(getTestFullyQualifiedName(tr), "completed"));
	        
	    }
	   
	    @Override
	    public void onTestFailure(ITestResult tr) {
	    	
	        log(getMessage(getTestFullyQualifiedName(tr), "failed"));

	    }

	    @Override
	    public void onTestSkipped(ITestResult tr) {
	    	
	        log(getMessage(getTestFullyQualifiedName(tr), "skipped"));
	        
	    }

	    @Override
	    public void onTestStart(ITestResult tr) {
	    	
	        log(getMessage(getTestFullyQualifiedName(tr), "starting"));
	        
	    }
	    
	    
		private String getMessage (String test, String result)
	    {
			
	        return test + " " + result;
	        
	    }
	    
	    private String getTestFullyQualifiedName (ITestResult tr)
	    {
	    	
	        String className = tr.getTestClass().getName();
	        String testName = tr.getName();
	        return className + "#" + testName; 
	        
	    }
	    
	    private void log (String msg)
	    {
	    	
	        LOGGER.info(msg);
	        
	    }
}
