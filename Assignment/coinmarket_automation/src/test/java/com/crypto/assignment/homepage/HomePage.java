package com.crypto.assignment.homepage;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("page:home.page")
public class HomePage extends PageObject {
  static private EnvironmentVariables env = SystemEnvironmentVariables.createEnvironmentVariables();
  static final String VIEWALL_URL = EnvironmentSpecificConfiguration.from(env)
          .getProperty("viewall.page");

  static final By login = By.xpath("//button[contains(text(),'Log In')]");
  static final By email = By.xpath("//input[@type='email']");
  static final By password = By.xpath("//input[@type='password']");
  static final By btnlogin = By.xpath("(//button[contains(text(),'Log In')])[3]");

  
  
  static final By totalRecords = By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div/div[1]/div[2]/div[3]/div[1]/div");
		
  
  static final String CRYPTO_TABLE = "//div[@class='tableWrapper___3utdq cmc-table-homepage-wrapper___22rL4']";

  static final By WATCH_BUTTON = By.xpath("(//span[contains(text(), 'Watch')])[3]");
  
  static final By WATCH_BUTTON1 = By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/div[1]/span");
  
  static final By WatchCheckItOutBtn = By.xpath("//button[contains(text(),'Check It Out')]");
  
  static final String WATCHLIST_URL = "https://coinmarketcap.com/watchlist/";

  static final By CRYPTO_DROP_DOWN = By.xpath("(//span[contains(text(),'Cryptocurrencies')])[1]");
  

  static final By Main_FILTER_LINK = By.xpath("(//button[contains(text(),'Filters')])[2]");
  static final By FILTER_LINK = By.xpath("//button[@class='sc-1ejyco6-0 fUnrJj sc-1mxz8p6-2 i20hns-0 bnOMFk' and contains(text(), '+')]");
  
  static final By PRICE_BUTTON = By.xpath("//button[contains(text(),'Price')]");
  static final By PRICE_FROM = By.xpath("//input[@placeholder='$0']");
  static final By PRICE_TO = By.xpath("//input[@placeholder='$99,999']");

  static final By PRICE_APPLY = By.xpath("//button[contains(text(),'Apply Filter')]");
  
  static final By Show_results = By.xpath("//button[contains(text(),'Show results')]");
  
}
