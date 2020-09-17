package utilities.property;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyManager {

    private static String url;
    private static String email;
    private static String email_password;
    private static String password;
    private static String reg_email;
    private static String reg_password;
    private static String chromeDriverPath;
    private static String extentReportsPath;
    private static String testingFiles;
    private static String testing_fullname;

    public static PropertyManager getInstance() {

        Properties prop = new Properties();
        PropertyManager instance = new PropertyManager();

        try {
            FileInputStream fi = new FileInputStream("src/test/resources/configuration.properties");
            prop.load(fi);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        url = prop.getProperty("url");
        email = prop.getProperty("login_email");
        email_password = prop.getProperty("email_password");
        password = prop.getProperty("login_password");
        chromeDriverPath = prop.getProperty("chromeDriverPath");
        reg_email = prop.getProperty("reg_email");
        reg_password = prop.getProperty("reg_password");
        extentReportsPath = prop.getProperty("extent_reports");
        testingFiles = prop.getProperty("testing_files");
        testing_fullname = prop.getProperty("testing_fullname");

        return instance;
    }

    public String getURL () {
        return url;
    }

    public String getChromeDriverPath () {
        return chromeDriverPath;
    }

    public String getEmail () {
        return email;
    }

    public String getPassword () {
        return password;
    }

    public String getRegEmail () {
        return reg_email;
    }

    public String getRegPassword () {
        return reg_password;
    }

    public String getExtentReportsPath () {
        return extentReportsPath;
    }

    public String getTestingFiles () {
        return testingFiles;
    }

    public String getEmail_password () {
        return email_password;
    }

    public String getTesting_fullname(){
        return testing_fullname;
    }

}
