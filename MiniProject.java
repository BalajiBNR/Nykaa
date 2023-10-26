
package Selenium;


import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class MiniProject {
	
	static WebDriver driver;
	
	
	private static void browser_Launch() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hemavathi\\eclipse-workspace\\Com.Selenium\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.nykaa.com/");

	}
	
	private static void loginPage() throws InterruptedException {
		
		WebElement SigninPage = driver.findElement(By.xpath("//button[text()='Sign in with Mobile / Email']"));
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.click(SigninPage).build().perform();
		WebElement mob = driver.findElement(By.name("emailMobile"));
		mob.sendKeys("9786671202");
		WebElement sendotp = driver.findElement(By.xpath("//button[@type='submit']"));
		sendotp.click();
		Thread.sleep(25000);
		WebElement verify = driver.findElement(By.xpath("//button[text()='verify']"));
		verify.click();
		
	}
	
	private static void product_Select() throws InterruptedException {
		Thread.sleep(2000);
		WebElement momBaby = driver.findElement(By.xpath("//a[text()='mom & baby']"));
		Actions act = new Actions(driver);
		Thread.sleep(3000);
		act.moveToElement(momBaby).build().perform();
		WebElement babyPowder = driver.findElement(By.xpath("//a[text()='Baby Powder']"));
		Thread.sleep(3000);
		babyPowder.click();
		Thread.sleep(3000);
		Set<String> allwindow = driver.getWindowHandles();
		for (String onebyone : allwindow) {
			String currentUrl = driver.switchTo().window(onebyone).getTitle();
			System.out.println(currentUrl);
		}
		JavascriptExecutor scroll = (JavascriptExecutor)driver;
        scroll.executeScript("window,scrollBy(0,450)");
        
		WebElement Himalaya_Babypowder = driver.findElement(By.xpath("(//div[@class='css-d5z3ro'])[1]"));
		act.moveToElement(Himalaya_Babypowder).build().perform();
		Thread.sleep(3000);
		Himalaya_Babypowder.click();

	}
	
	private static void add_To_Cart() throws InterruptedException {
		Thread.sleep(3000);
		Set<String> allwindow = driver.getWindowHandles();
		for (String onebyone : allwindow) {
			String currentUrl = driver.switchTo().window(onebyone).getTitle();
			System.out.println(currentUrl);
		}
		WebElement size = driver.findElement(By.xpath("(//span[@class=' css-d3w64v'])[3]"));
		Actions act = new Actions(driver);
		act.click(size).build().perform();
		WebElement addtobag = driver.findElement(By.xpath("//span[text()='Add to Bag']"));
		addtobag.click();
		WebElement cart = driver.findElement(By.xpath("//span[@class='cart-count']"));
		Thread.sleep(2000);
		act.click(cart).build().perform();
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
		driver.switchTo().frame(iframe);
		WebElement sel_Qnantity = driver.findElement(By.xpath("(//img[@class='css-g7xef ek8d9s80'])[2]"));
		sel_Qnantity.click();
		WebElement quantity = driver.findElement(By.xpath("(//div[@value='4'])[1]"));
		quantity.click();
		Thread.sleep(2000);
		WebElement proceed = driver.findElement(By.xpath("//span[text()='Proceed']"));
		proceed.click();
		Thread.sleep(3000);
		WebElement deliver_address = driver.findElement(By.xpath("//button[text()='Deliver here']"));
		deliver_address.click();
	}

	private static void purchase_Product() throws InterruptedException, IOException {
		
//		driver.findElement(By.xpath("//input[@placeholder='Pincode']")).sendKeys("631004");
//		driver.findElement(By.xpath("//input[@placeholder='House/ Flat/ Office No.']")).sendKeys("150");
//		driver.findElement(By.xpath("//textarea[@placeholder='Road Name/ Area /Colony']")).sendKeys("bajanai koil st, arakkonam");
//		driver.findElement(By.xpath("//button[text()='SHIP TO THIS ADDRESS']")).click();
		
		WebElement cardno = driver.findElement(By.xpath("//input[@placeholder='Card Number']"));
		Thread.sleep(3000);
		cardno.click();
		Thread.sleep(3000);
		cardno.sendKeys("5105105105105100");
		WebElement expired = driver.findElement(By.xpath("//input[@placeholder='Expiry (MM/YY)']"));
		expired.click();
		Thread.sleep(3000);
		expired.sendKeys("1124");
		WebElement cvv = driver.findElement(By.xpath("//input[@placeholder='CVV']"));
		cvv.click();
		cvv.sendKeys("996");
		WebElement condition = driver.findElement(By.xpath("(//span[@class='css-1aowomc ehes2bo0'])[7]"));
		condition.click();
		Thread.sleep(2000);
		WebElement pay = driver.findElement(By.xpath("//button[@class='css-v61n2j e8tshxd0']"));
		pay.click();
		Thread.sleep(10000);
		TakesScreenshot pic=(TakesScreenshot)driver;
		File source=pic.getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\hemavathi\\eclipse-workspace\\Com.Selenium\\Screenshot\\Nykaa.png");
		FileHandler.copy(source,destination);
		Thread.sleep(5000);
		WebElement close = driver.findElement(By.xpath("//button[text()='Close']"));
		close.click();
		driver.get("https://www.nykaa.com/");
	}
	public static void main(String[] args) throws InterruptedException, IOException {
		
		browser_Launch();
		loginPage();
		product_Select();
		add_To_Cart();
		purchase_Product();
	}

}
