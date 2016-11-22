package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by z013th3 on 11/21/16.
 */
public class MavenPage {
    public WebDriver driver;

    By user99GuruName = By.name("uid");
    By password99Guru = By.name("password");
    By titleText = By.className("barone");
    By login = By.name("btnLogin");

    public MavenPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String strUserName){
        driver.findElement(user99GuruName);
    }

    //Set password in password textbox

    public void setPassword(String strPassword){
        driver.findElement(password99Guru).sendKeys(strPassword);
    }

    //Click on login button

    public void clickLogin(){
        driver.findElement(login).click();
    }

    //Get the title of Login Page

    public String getLoginTitle(){
        return    driver.findElement(titleText).getText();
    }

    /**
     * This POM method will be exposed in test case to login in the application
     * @param strUserName
     * @param strPasword
     * @return
     */

    public void loginToGuru99(String strUserName,String strPasword){

        //Fill user name
        this.setUserName(strUserName);
        //Fill password
        this.setPassword(strPasword);
        //Click Login button
        this.clickLogin();
    }

}
