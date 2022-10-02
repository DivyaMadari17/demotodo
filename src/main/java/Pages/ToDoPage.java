package Pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ToDoPage {
	private static WebDriver driver;
	
	public void launchUI() throws MalformedURLException {
		String url = "https://todomvc.com/examples/vue/";
		WebDriverManager.chromedriver().setup();
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("106");
		driver = new ChromeDriver(browserOptions);
		driver.get(url);
	}
	
	public void enterItem() {
		WebElement item = driver.findElement(By.className("new-todo"));
		for(int i=0;i<5;i++) {
			item.sendKeys("todo"+i);
			item.sendKeys(Keys.ENTER);	
		}
	}
	
	public void closeBrowser() {
		driver.close();
	}
}
