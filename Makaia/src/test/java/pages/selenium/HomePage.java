package pages.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.api.java.en.Then;
import lib.selenium.PreAndPost;

public class HomePage extends PreAndPost{

	public HomePage(EventFiringWebDriver driver, ExtentTest test) {	
		this.driver = driver;
		this.test = test;	
		driver.switchTo().defaultContent();
		PageFactory.initElements(driver, this);
	}		

	@FindBy(id="filter")
	WebElement eleFilter;	
	public HomePage searchUsingFilter(String value) {		
		type(eleFilter,value);
		return this; 
	}	
	
	
	@FindBy(linkText="Create New")
	WebElement eleCreateNew;	
	public CreateNewIncident clickCreateNew() {		
		click(eleCreateNew);
		return new CreateNewIncident(driver, test); 
	}	
	

	@FindBy(linkText="Open")
	WebElement eleOpen;	
	public ListIncidents clickOpen() {		
		click(eleOpen);
		return new ListIncidents(driver, test); 
	}	
	
	@FindBy(id="sysparm_search")
	WebElement search;	
	@FindBy(className="input-group-addon-transparent icon-search sysparm-search-icon")
	WebElement searchf;	
	public HomePage searchUsingSeacrh(String value) throws InterruptedException {
		Thread.sleep(8000);
		searchf.click();
		type(search,value);
		search.sendKeys(Keys.ENTER);
		return this; 
	}	
	

}










