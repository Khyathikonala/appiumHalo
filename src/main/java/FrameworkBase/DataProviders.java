/**
 * 
 */
package FrameworkBase;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;


/**
 * 
 * Project Name			:	Halo
 * Package Name			:	FrameworkBase
 * File Name			:	DataProviders.java
 * Description			:	Reads TestData from Data source (.csv file). 
 * Inherited Classes	:	-
 * Created By			:	fqw4433
 * Created Date			:	Dec 20, 2017 at 10:48:58 AM
 * Reviewer				:
 * Comments 			:
 *
 *	 
 */
public class DataProviders {
	
public static Properties properties;
	

	//Read .csv file data. 
    private static Iterator <Object [] > loadDataFromFileToIterator(final String fileName) {

        String path_Android = "Android";
        String path_iOS = "iOS";
        String csvFile;

        if (Utility.platformName.equals(path_Android)){

             csvFile = DataProviders.class.getClassLoader().getResource("dataFeed/" + path_Android + "/" + fileName).getFile();

        }else {

            csvFile = DataProviders.class.getClassLoader().getResource("dataFeed/" + path_iOS + "/" + fileName).getFile();

        }

        BufferedReader br;
        String line;
        String csvSplitBy = ",";

        Collection<Object[]> dp = new ArrayList<Object[]>();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            line = br.readLine();
            String[] col_names = line.split(csvSplitBy);

            do {
                line = br.readLine();
                if (line == null)
                    break;
                HashMap <String, String>user_data = new HashMap<String, String>();
                String[] values = line.split(csvSplitBy);
                for ( int iterator = 0; iterator < col_names.length; iterator ++) {
                    user_data.put(col_names[iterator], values[iterator]);
                }
                dp.add(new Object[] {user_data});
            } while (true);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dp.iterator();
        
    }

    public static void assertData(){

        String filename = "en_US_Data.properties";
        String path = "/src/test/resource/dataFeed/Locale_Data/";
        String workingDirectory = System.getProperty("user.dir");
        String relativePath = workingDirectory + path + filename;

        FileInputStream fileInput = null;
        try {

            fileInput = new FileInputStream(relativePath);

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        }

        properties = new Properties();

        //load properties file
        try {

            properties.load(fileInput);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public static Properties getProperties(){

        return properties;

    }

}
