package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbsaWebPage {
    private WebDriver driver;
    private WebDriverWait w;

    private By AddUser = By.xpath("/html/body/table/thead/tr[2]/td/button");
    private By FirstName = By.name("FirstName");
    private By LastName = By.name("LastName");
    private By UserName = By.name("UserName");
    private By Password = By.name("Password");
    private By CompanyA = By.xpath("//tbody/tr[5]/td[2]/label[1]/input[1]");
    private By CompanyB = By.xpath("//tbody/tr[5]/td[2]/label[2]/input[1]");
    private By RoleDropDown = By.xpath("//tbody/tr[6]/td[2]/select[1]");
    private By Email = By.name("Email");
    private By CellPhone = By.name("Mobilephone");
    private By Save = By.xpath("//button[contains(text(),'Save')]");
    private By User_1 = By.xpath("//td[contains(text(),'FName1')]");
    private By User_2 = By.xpath("//td[contains(text(),'FName2')]");

    public AbsaWebPage(WebDriver driver) {this.driver = driver;}

    public String validateYouAreOnUserListTable() {
        return driver.getTitle();
    }
    public void clickTheAddUser() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(AddUser).click();
        Thread.sleep(2000);
    }
    public void addUser(String name, String lastName, String userName, String password, String customer, String role, String email, String cell) {
        driver.findElement(FirstName).clear();
        driver.findElement(FirstName).sendKeys(name);
        driver.findElement(LastName).clear();
        driver.findElement(LastName).sendKeys(lastName);
        driver.findElement(UserName).clear();
        driver.findElement(UserName).sendKeys(userName);
        driver.findElement(Password).clear();
        driver.findElement(Password).sendKeys(password);
        if (customer.equalsIgnoreCase("CompanyAAA")) {
            driver.findElement(CompanyA).click();
        } else {
            driver.findElement(CompanyB).click();
        }
        Select dropdown = new Select(driver.findElement(RoleDropDown));
        if (role.equalsIgnoreCase("Admin")) {
            dropdown.selectByVisibleText(role);
        } else if (role.equalsIgnoreCase("Customer")) {
            dropdown.selectByVisibleText(role);
        }
        driver.findElement(Email).clear();
        driver.findElement(Email).sendKeys(email);
        driver.findElement(CellPhone).clear();
        driver.findElement(CellPhone).sendKeys(cell);
    }
    public void clickSave() {
        driver.findElement(Save).click();
    }
    public String validateThatUserAdded(String Name){
        if (Name.equalsIgnoreCase("FName1")) {
            return driver.findElement(User_1).getText();
        } else {
            return driver.findElement(User_2).getText();
        }
    }
    public String validateThatUser1Added() {
        return driver.findElement(User_1).getText();
    }
    public String validateThatUser2Added() {
        return driver.findElement(User_2).getText();
    }
}
