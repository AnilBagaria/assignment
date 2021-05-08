package com.crypto.assignment.homepage;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

public class HomePageActions extends UIInteractionSteps {


    @Step
    public void login() {
    	    	
    	System.out.println("log in start");
        
        waitForCondition().until(
                ExpectedConditions.visibilityOfElementLocated(HomePage.login))
        .click();
        
        waitForCondition().until(
                ExpectedConditions.visibilityOfElementLocated(HomePage.email))
        .sendKeys("anilbagaria02@gmail.com");
        
        waitForCondition().until(
                ExpectedConditions.visibilityOfElementLocated(HomePage.password))
        .sendKeys("Anil@1234");
        
        waitForCondition().until(
                ExpectedConditions.visibilityOfElementLocated(HomePage.btnlogin))
        .click();
        
        System.out.println("login completed");
       
                         
    }


    @Step
    public void addToWatchList(String currency) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

 
        
        System.out.println("start of watchlist ");
        
        List<WebElement> rows = $(HomePage.CRYPTO_TABLE).findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
            	   
            	//System.out.println("table col data " +currency);
            	//System.out.println("Currency selected" +col.getText());
            	                      	
                if (col.getText().contains(currency)) {
                	
                	System.out.println("Currency selected" +col.getText());
                                        
                    WebElement element = $(HomePage.CRYPTO_TABLE).findElement(By.partialLinkText(currency));
    
                   js.executeScript("arguments[0].click();", element);
               
                    waitForCondition().until(
                            ExpectedConditions.visibilityOfElementLocated(HomePage.WATCH_BUTTON1))
                            .click();
                    
                    
                    if ( waitForCondition().until(
                            ExpectedConditions.visibilityOfElementLocated(HomePage.WatchCheckItOutBtn))
                            .isDisplayed()
                    )
                    {
                    	System.out.println("condition matched");
                    	waitForCondition().until(
                                ExpectedConditions.visibilityOfElementLocated(HomePage.WatchCheckItOutBtn))
                                .click();
                                                            
                              waitForCondition().until(
                                      ExpectedConditions.visibilityOfElementLocated(HomePage.WATCH_BUTTON1))
                                      .click();
                              
                                      }
                    else
                    {
                    	
                    	getDriver().navigate().back();
                    	
                    }
                    
                    
                    
               
                    return;
                }
            }
        }
    }

    @Step
    public void clickWatchListTab() {

        ((JavascriptExecutor) getDriver()).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
        getDriver().get(HomePage.WATCHLIST_URL);
        System.out.println("watch list page");
    }

    @Step
    public void clickCryptoDropDown() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        WebElement element = $(HomePage.CRYPTO_DROP_DOWN);
        js.executeScript("arguments[0].click();", element);
    }

    @Step
    public void clickFullListFromCrypto() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        WebElement element = $(HomePage.Main_FILTER_LINK);
        js.executeScript("arguments[0].click();", element);
    }

    @Step
    public void recordPriceDetails() {

    	boolean flag = true;    
    	
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	 List<WebElement> rows = $(HomePage.CRYPTO_TABLE).findElements(By.tagName("tr"));
         for (WebElement row : rows) {
             List<WebElement> cols = row.findElements(By.tagName("td"));
             for (WebElement col : cols) {
             	   
             	//System.out.println("table col data " +currency);
             	//System.out.println("Currency selected" +col.getText());
            	 
            	 String price = cols.get(3).getText();
            	 
            	 StringBuilder sb = new StringBuilder(price);
            	 
            	 sb.deleteCharAt(0);
            	 
            	 String newPrice = sb.toString();
            	 
       //     	 System.out.println("New Price = "+ newPrice);
            	 
            	 double _price = Double.parseDouble(newPrice);
            	 
            	      	 
            	 
            	 
            	 if((_price<100) && (_price>300))
            	 {
            		 System.out.println("Price is not between the filterred range");
            		 flag = false;
            	 }
            	 assertThat(true).isEqualTo(flag);
            	 
        }
             
         
         }
         if(flag==true)
     	{
     		System.out.println("Price is in the range of $100 to $300 ");
     	}
         
    }

    @Step
    public void clickFilterButton() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        WebElement element = $(HomePage.FILTER_LINK);
        js.executeScript("arguments[0].click();", element);
    }

    @Step
    public void enterPriceValues(String fromValue, String toValue) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        WebElement priceElement = $(HomePage.PRICE_BUTTON);
        js.executeScript("arguments[0].click();", priceElement);

        $(HomePage.PRICE_FROM).sendKeys(fromValue);
        $(HomePage.PRICE_TO).sendKeys(toValue);
    }

    @Step
    public void clickApplyButton() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        WebElement element = $(HomePage.PRICE_APPLY);
        js.executeScript("arguments[0].click();", element);
        
        WebElement element1 = $(HomePage.Show_results);
        js.executeScript("arguments[0].click();", element1);
    }

}
