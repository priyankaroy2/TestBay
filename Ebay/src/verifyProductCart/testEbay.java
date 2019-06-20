package verifyProductCart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testEbay {
	public static WebDriver A;

	@BeforeTest
	@Parameters("browser")
	public void setup(String browserName) throws Exception{
	    if (browserName.equalsIgnoreCase("Firefox")) {
	        A = new FirefoxDriver();
	    }
	    else if (browserName.equalsIgnoreCase("Chrome")) {
	    	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Priyanka\\Documents\\Selenium\\chromedriver.exe");
	        A = new ChromeDriver();
	    }
	    
	    else {
	        throw new Exception("Browser is not correct");
	    }
	    A.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	  @Test(priority = 0)
	  public void login() throws InterruptedException {
		  A.get("https://www.ebay.com.au");  
		Thread.sleep(2000);
		WebElement log = A.findElement(By.xpath("//a[contains(.,'Sign in')]")); 
		log.click();
	    WebElement uid = A.findElement(By.xpath("//input[contains(@name,'userid')]"));
	    uid.clear();
	    uid.sendKeys("roy.priya2286@gmail.com");
	    WebElement pssd = A.findElement(By.xpath("//input[contains(@name,'pass')]"));
	    pssd.clear();
	    pssd.sendKeys("Sydney@2");
		WebElement btn= A.findElement(By.xpath("//button[@type='submit']")); 
		btn.submit();  
		Thread.sleep(5000);
		  
	  }
	  
	  @Test(dependsOnMethods={"login"})
	    	public void browse() throws InterruptedException 
		{  
		  Thread.sleep(4000);
		  WebElement Cat = A.findElement(By.xpath("//button[contains(.,'Shop by category')]"));
		  Cat.click();
		  WebElement Cat1= A.findElement(By.xpath("//a[@class='scnd'][contains(.,'Computers & Tablets')]"));
		  Cat1.click();
		  WebElement Cat2 = A.findElement(By.xpath("//div[@class='b-visualnav__title'][contains(.,'PC Laptops & Notebooks')]"));
		  Cat2.click();
		  WebElement Cat3 = A.findElement(By.xpath("//h3[contains(.,'Dell Latitude E6430 Laptop Core i5 3340M 4/8Gb HDD/SSD HDMI WiFi 14\" WIN10P')]"));
		  Cat3.click();
		  WebElement btn2 = A.findElement(By.xpath("//a[@role='button'][contains(@id,'btn')][contains(.,'Add to cart -')]"));
		  btn2.click();
		  WebElement btn3 = A.findElement(By.xpath("//button[contains(.,'No thanks')]"));
		  btn3.click();
		  Thread.sleep(5000);
		}
	  
	  @Test(dependsOnMethods={"browse"})
	  public void item_2() throws InterruptedException 
		{  
		  WebElement Cat = A.findElement(By.xpath("//button[@aria-expanded='false'][contains(.,'Shop by category')]"));
		  Cat.click();
		  Thread.sleep(4000);
		  WebElement Cat1= A.findElement(By.xpath("//a[contains(.,'TV & Home Entertainment')]"));
		  Cat1.click();
		  WebElement cat2 = A.findElement(By.xpath("//h3[@class='s-item__title'][contains(.,'New listingSamsung 75\" Series 7 RU7100 4K UHD Smart TV UA75RU7100WXXY')]"));
		  cat2.click();
		  WebElement btn2 = A.findElement(By.xpath("//a[@role='button'][contains(@id,'btn')][contains(.,'Add to cart -')]"));
		  btn2.click();
		  WebElement btn3 = A.findElement(By.xpath("//button[contains(.,'No thanks')]"));
		  btn3.click();
		  Thread.sleep(5000);
		  	
		}
	  
	  @Test(dependsOnMethods= {"item_2"})
	  public void deleteItem()
	  {
		 // WebElement cart = A.findElement(By.xpath("//a[@href='https://cart.payments.ebay.com.au/sc/view'][contains(.,'2')]"));
		  //cart.click();
		  WebElement Cat1= A.findElement(By.xpath("//button[contains(.,'Remove  - Dell Latitude E6430 Laptop Core i5 3340M 4/8Gb HDD/SSD HDMI WiFi 14\" WIN10P')]"));
		  Cat1.click();
		  A.navigate().refresh();
		  WebElement Cat = A.findElement(By.xpath("//button[@type='button'][contains(.,'Remove  - Samsung 75\" Series 7 RU7100 4K UHD Smart TV UA75RU7100WXXY')]"));
		  Cat.click();
		  A.close(); 
	  }
	  


}
