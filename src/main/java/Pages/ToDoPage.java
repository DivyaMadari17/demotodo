package Pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToDoPage {
	static String itemName;
	static WebDriver driver;

	public void launchUI() throws InterruptedException {
		String url = "https://todomvc.com/examples/vue/";
		WebDriverManager.chromedriver().setup();
		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 10");
		browserOptions.setBrowserVersion("86");
		driver = new ChromeDriver(browserOptions);
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	public void clickOnActiveTab() {
		WebElement activeTab = driver.findElement(By.xpath("//a[@href='#/active']"));
		activeTab.click();
	}

	public void clickOnAllTab() {
		WebElement allTab = driver.findElement(By.xpath("//a[@href='#/all']"));
		allTab.click();
	}

	public void clickOnCompletedTab() {
		WebElement completedTab = driver.findElement(By.xpath("//a[@href='#/completed']"));
		completedTab.click();
	}

	public void enterItem() throws InterruptedException {
		WebElement item = driver.findElement(By.className("new-todo"));
		for (int i = 0; i < 5; i++) {
			item.sendKeys("todo" + i);
			item.sendKeys(Keys.ENTER);
		}
		Thread.sleep(3000);
		
	}

	public void verifyCount() throws Exception {
		List<WebElement> items = driver.findElements(By.xpath("//ul/li[@class = 'todo']"));
		int size = Integer.parseInt(driver.findElement(By.xpath("//span/strong")).getText());
		if (items.size() == size) {
			System.out.println("entered items show up");
		} else {
			throw new Exception();
		}
	}

	public void markComplete() throws InterruptedException {
		WebElement item = driver.findElement(By.xpath("(//input[@type='checkbox' and @class='toggle'])[1]"));
		item.click();
	}

	public void verifyCompletedItem() throws Exception {
		clickOnCompletedTab();
		Thread.sleep(3000);
		itemName = driver.findElement(By.xpath("(//ul/li[@class='todo completed']/div/label)[1]")).getText();
		System.out.println("completed item is " + itemName);
		List<WebElement> completedItems = driver.findElements(By.xpath("//ul/li[@class='todo completed']/div/label"));
		if (completedItems.size() >= 1)
			System.out.println("Element is marked as completed");
		else
			throw new Exception();
		WebElement clearCompleted = driver.findElement(By.xpath("//button[@class='clear-completed']"));
		if (clearCompleted.isEnabled())
			System.out.println("Clear completed is displayed and enabled");
		else
			throw new Exception();
	}

	public void verifyCompletedItemUnderAll() throws Exception {
		clickOnAllTab();
		Thread.sleep(3000);
		List<WebElement> completedItems = driver.findElements(By.xpath("//ul/li[@class='todo completed']/div/label"));
		for (WebElement ele : completedItems) {
			if (ele.getText().equals(itemName))
				System.out.println("Element completed is present under All");
			else
				throw new Exception();
		}

	}

	public void deselectItem() throws Exception {
		List<WebElement> completedItems = driver.findElements(By.xpath("//ul/li[@class='todo completed']/div/label"));
		for (WebElement ele : completedItems) {
			if (ele.getText().equals(itemName))
				ele.click();
			else
				throw new Exception();
		}
	}

	public void verifyItemUnderActive() throws Exception {
		clickOnActiveTab();
		List<WebElement> completedItems = driver.findElements(By.xpath("//ul/li[@class='todo']/div/label"));
		for (WebElement ele : completedItems) {
			if (ele.getText().equals(itemName))
				System.out.println("Element completed is present under Active");
			else
				throw new Exception();
		}
	}

	public void clickClearCompleted() throws InterruptedException {
		WebElement clearCompleted = driver.findElement(By.xpath("//button[@class='clear-completed']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(clearCompleted));
		clearCompleted.click();
		Thread.sleep(3000);
	}

	public void verifyClearedItems() throws Exception {
		clickOnCompletedTab();
		try {
			WebElement clearedItemUnderCompleted = driver
					.findElement(By.xpath("//ul/li[@class='todo completed']/div/label"));
		} catch (NoSuchElementException e) {
			System.out.println("element cleared successfully");
		}
		clickOnAllTab();
		try {
			WebElement clearedItemUnderAll = driver.findElement(By.xpath("//ul/li[@class='todo']/div/label"));
		} catch (NoSuchElementException e) {
			System.out.println("element cleared successfully");
		}
	}

	public void removeFromAll() {
		clickOnAllTab();
		WebElement item = driver.findElement(By.xpath("(//ul/li[@class='todo']/div/label)[1]"));
		WebElement remove = driver.findElement(By.xpath("//ul/li[@class='todo']/div/button"));
		item.click();
		remove.click();
	}

	public void removeFromActive() {
		clickOnActiveTab();
		WebElement item = driver.findElement(By.xpath("(//ul/li[@class='todo']/div/label)[1]"));
		WebElement remove = driver.findElement(By.xpath("//ul/li[@class='todo']/div/button"));
		item.click();
		remove.click();
	}

	public void removeFromCompleted() {
		clickOnCompletedTab();
		WebElement item = driver.findElement(By.xpath("(//ul/li[@class='todo completed']/div/label)[1]"));
		WebElement remove = driver.findElement(By.xpath("//ul/li[@class='todo completed']/div/button"));
		item.click();
		remove.click();
	}

	public void clickDownArrow() throws InterruptedException {
		WebElement downArrow = driver.findElement(By.xpath("//label[@for='toggle-all']"));
		downArrow.click();
		Thread.sleep(3000);
	}

	public void verifyItemsCollapse() {
		try {
			WebElement clearedItemUnderCompleted = driver.findElement(By.xpath("//ul/li[@class='todo']/div/label"));
		} catch (NoSuchElementException e) {
			System.out.println("element cleared successfully");
		}
	}

	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
