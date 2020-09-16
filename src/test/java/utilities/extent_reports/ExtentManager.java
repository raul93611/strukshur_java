package utilities.extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.Platform;
import utilities.property.PropertyManager;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;
    private static Platform platform;
    private static String reportFileName = "SmokeTestReport.html";
    private static String windowsPath = PropertyManager.getInstance().getExtentReportsPath();
    private static String winReportFileLoc = windowsPath + "\\" + reportFileName;
    private static String linReportFileLoc = windowsPath + "/" + reportFileName;

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    public static ExtentReports createInstance() {
        platform = getCurrentPlatform();
        String fileName = getReportFileLocation(platform);
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        return extent;
    }

    private static String getReportFileLocation (Platform platform) {
        String reportFileLocation = null;
        if (platform == Platform.WINDOWS) {
            reportFileLocation = winReportFileLoc;
            createReportPath(windowsPath);
            System.out.println("ExtentReport Path for WINDOWS: " + windowsPath + "\n");
        } else if (platform == Platform.LINUX){
            reportFileLocation = linReportFileLoc;
            createReportPath(windowsPath);
            System.out.println("ExtentReport Path for LINUX: " + windowsPath + "\n");
        } else {
            System.out.println("ExtentReport path has not been set! There is a problem!\n");
        }
        return reportFileLocation;
    }

    private static void createReportPath (String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!" );
            } else {
                System.out.println("Failed to create directory: " + path);
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
    }

    private static Platform getCurrentPlatform () {
        if (platform == null) {
            String operSys = System.getProperty("os.name").toLowerCase();
            if (operSys.contains("win")) {
                platform = Platform.WINDOWS;
            } else if (operSys.contains("nix") || operSys.contains("nux")
                    || operSys.contains("aix")) {
                platform = Platform.LINUX;
            }
        }
        return platform;
    }
}