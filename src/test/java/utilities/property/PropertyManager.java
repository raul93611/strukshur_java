package utilities.property;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyManager {

    private static String url;
    private static String email;
    private static String email_password;
    private static String password;
    private static String email_SAML;
    private static String password_SAML;
    private static String reg_email;
    private static String reg_password;
    private static String chromeDriverPath;
    private static String ieDriverPath;
    private static String extentReportsPath;
    private static String testingFiles;
    private static String macChromeDriverPath;
    private static String testing_binder;
    private static String testing_team;
    private static String grid_url;

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
        email_SAML = prop.getProperty("login_email_SAML");
        password_SAML = prop.getProperty("login_password_SAML");
        chromeDriverPath = prop.getProperty("chromeDriverPath");
        ieDriverPath = prop.getProperty("ieDriverPath");
        reg_email = prop.getProperty("reg_email");
        reg_password = prop.getProperty("reg_password");
        extentReportsPath = prop.getProperty("extent_reports");
        testingFiles = prop.getProperty("testing_files");
        macChromeDriverPath = prop.getProperty("macChromeDriverPath");
        testing_binder = prop.getProperty("testing_binder");
        testing_team = prop.getProperty("testing_team");
        grid_url = prop.getProperty("grid_url");

        return instance;
    }

    public String getURL () {
        return url;
    }

    public String getChromeDriverPath () {
        return chromeDriverPath;
    }

    public String getIEDriverPath () {
        return ieDriverPath;
    }

    public String getEmail () {
        return email;
    }

    public String getPassword () {
        return password;
    }

    public String getEmailSAML () {
        return email_SAML;
    }

    public String getPasswordSAML () {
        return password_SAML;
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

    public String getMacChromeDriverPath () {
        return macChromeDriverPath;
    }

    public String getTestingBinder () {
        return testing_binder;
    }

    public String getTestingTeam () {
        return testing_team;
    }

    public String getGridURL () {
        return grid_url;
    }

    public String getEmail_password () {
        return email_password;
    }

}
