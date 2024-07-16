package baseTest;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//Log4j
import org.apache.logging.log4j.Logger;//Log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {// This is the parent class of all the TestCase Classes
	public WebDriver driver;
	Properties prop;
	
	
	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String br) throws IOException {
		
		//loading config.properties file
		FileReader fr = new FileReader("./src//test//resources//config.properties");
		prop = new Properties();
		prop.load(fr);
			
		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid Browser Name");
			return;//excute from the entire testcase
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("appURL"));//reading value url from properties file.
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public String randomString() {// generate strings dynamically
		String generatedString = RandomStringUtils.randomAlphabetic(6);
		return generatedString;
	}

	public String randomNumber() {// generate numbers dynamically
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}

	public String randomAlphNumeric() {// generate alphanumeric dynamically
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		String generatedNumber = RandomStringUtils.randomNumeric(3);
		return generatedString + "@" + generatedNumber;
	}
	public void Screenshots() {
		TakesScreenshot sc = (TakesScreenshot)driver;
		File src =sc.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot//ss.jpg");
		src.renameTo(dest);
	}

}

