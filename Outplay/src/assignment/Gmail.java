package assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Gmail {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//https://github.com/shivrajroy/Outplay_Test.git
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shivr\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");

		// Send email address
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("outplaytestuser@gmail.com");
		driver.findElement(By.xpath("//div[@id='identifierNext']")).click();

		// send password
		WebElement passwordButton = driver.findElement(By.xpath("//input[@name='password']"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(passwordButton));
		passwordButton.sendKeys("Password1@");
		driver.findElement(By.xpath("//div[@id='passwordNext']")).click();

		// Click on compose button
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='Compose']")).click();

		// Enter the sender mail id
		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("shivrajroy1@gmail.com");

		// Enter subject and content to the mail
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Selenium script");
		driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']")).sendKeys("Selenium script");
		Thread.sleep(5000);

		// Click on send button
		driver.findElement(By.xpath("//div[text()='Send']")).click();

		// Check if email is sent using pop-up
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		WebElement element = wait1.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Message sent')]")));

		// Display appropriate message
		if (element.isDisplayed()) {
			System.out.println("Message Successfully Sent");
		} else {
			System.out.println("Message was not sent to the given ID");
		}

	}

}
