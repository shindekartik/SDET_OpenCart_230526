package testBase;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger;     //log4j

public class BaseClass {

	
public static WebDriver driver;

public Logger logger;

public Properties p;
	
	@BeforeClass(groups = {"Sanity", "Master", "Regression"})
	@Parameters ({"os","browser"})
	public void setup(String os,String br) throws IOException  {
		
//		loading config.properties file
		FileReader fileReader=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(fileReader);
		
//		to load the logs
		logger=LogManager.getLogger(this.getClass()); //log4j2
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("No Matching OS");
			}
			
//			Browser
			switch (br.toLowerCase()) {
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;		
			case "firefox":capabilities.setBrowserName("firefox");break;
			default: System.out.println("No match found");
				return;
			}
			
			driver=new RemoteWebDriver(new URL("http://192.168.0.102:4444/wd/hub"),capabilities);
		}
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (br.toLowerCase()) {
			case "chrome": driver=new ChromeDriver(); break;
			case "edge": driver =new EdgeDriver(); break;
			case "firefox": driver=new FirefoxDriver(); break;
			default : System.out.println("Invalid browser");return;
			}
		}
		
		
		
//		driver=new ChromeDriver();   //this is commented as we are usig xml file to run the TC and for that we have parameters which use browser from xml file
//		driver.get("https://tutorialsninja.com/demo/"); load using properties file
		
		driver.get(p.getProperty("appURL"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@AfterClass(groups = {"Sanity", "Master", "Regression"})
	public void teardown() {
		driver.quit();
	}
	
	public String randomString() {
		
		String genString=	RandomStringUtils.randomAlphabetic(5);
			return genString;
		}
		
		public String randomNumber() {
			
			String genStringNum=	RandomStringUtils.randomNumeric(10);
				return genStringNum;
			}
		
		public String alphanumericStrig() {
			String passString1= RandomStringUtils.randomAlphabetic(3);
			String passString2= RandomStringUtils.randomNumeric(2);
			return (passString1+passString2+"#");		
		}
		
		public String captureScreen(String tname) throws IOException{
			String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
			TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
			File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
			
			String targetFilePath=System.getProperty("user.dir") + "\\screenshots\\" + tname + "_"+ timeStamp+".png";	
			File targetFile=new File(targetFilePath);
			
			sourceFile.renameTo(targetFile);
			return targetFilePath;
		}

}
