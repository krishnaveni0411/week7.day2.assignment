package week7.day2.assignment3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeContact {
public static void main(String[] args) throws InterruptedException {
	ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://leaftaps.com/opentaps/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
	driver.findElement(By.className("decorativeSubmit")).click();
	driver.findElement(By.linkText("CRM/SFA")).click();
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
	driver.findElement(By.xpath("//span[text()='From Contact']/following::img[1]")).click();
	Set<String> openedWindow = driver.getWindowHandles();
	List<String> childWindow=new ArrayList<String>(openedWindow);
	int size = childWindow.size();
	System.out.println(size);
	driver.switchTo().window(childWindow.get(1));
	
	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("sripriya");
	driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("k");
	driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();
	driver.findElement(By.xpath("//a[text()='sripriya']")).click();
	Thread.sleep(2000);
	driver.switchTo().window(childWindow.get(0));
	driver.findElement(By.xpath("//span[text()='To Contact']/following::img[1]")).click();
	Set<String> openedWindow2 = driver.getWindowHandles();
	List<String> childWindow2=new ArrayList<String>(openedWindow2);
	int size2 = childWindow2.size();
	System.out.println(size2);
	driver.switchTo().window(childWindow2.get(1));

	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Akash");
	driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("K");
	driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();
	driver.findElement(By.xpath("//a[text()='Akash']")).click();
	driver.switchTo().window(childWindow2.get(0));
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[text()='Merge']")).click();
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
	System.out.println("The Contact is Merged");
	driver.close();
}
}
