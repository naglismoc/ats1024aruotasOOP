package lt.aruodas.Models;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

public class RealEstate {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public String municipality;
    public String village;
    public String microdistrict;
    public String street;
    public String description;
    public String imageUrl;
    public String youtubeUrl;
    public String virtualTour;
    public String price;
    public String phone;
    public String email;

    public RealEstate(String municipality, String village, String microdistrict, String street, String description, String imageUrl, String youtubeUrl, String virtualTour, String price, String phone, String email) {
        this.municipality = municipality.toLowerCase();
        this.village = village.toLowerCase();
        this.microdistrict = microdistrict.toLowerCase();
        this.street = street.toLowerCase();
        this.description = description;
        this.imageUrl = imageUrl;
        this.youtubeUrl = youtubeUrl;
        this.virtualTour = virtualTour;
        this.price = price;
        this.phone = phone;
        this.email = email;
    }

    public void fillAd() {
        setLocation();

        setDescription();
        uploadImage();
        setYoutubeUrl();
        setPrice();
        setPhone();
        setEmail();
        clickCheckboxes();
    }

    public void clickCheckboxes(){
        List<WebElement> rows = driver.findElement(By.id("newObjectForm")).findElements(By.tagName("li"));
        rows.get(rows.size() - 3 ).findElements(By.tagName("span")).get(1).click();
        rows.get(rows.size() - 4 ).findElement(By.tagName("span")).click();
        rows.get(rows.size() - 5 ).findElement(By.tagName("span")).click();
    }
    public void setRegion(){
                                                  ////*[@id="newObjectForm"]/ul/li[3]/span[1]/span
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[3]/span[1]/span")).click();
        List<WebElement> regions = driver.findElement(By.className("dropdown-input-values-address")).findElements(By.tagName("li"));
        for (WebElement reg: regions  ) {
            if (reg.getText().toLowerCase().contains(this.municipality)){
                reg.click();
                break;
            }
        }
    }
    public void setDistrict(){

        driver.findElement(By.xpath("//*[@id=\"district\"]/span")).click();
        List<WebElement> regions = driver.findElements(By.className("dropdown-input-values-address")).get(1).findElements(By.tagName("li"));
        for (WebElement reg: regions  ) {
            if (reg.getText().toLowerCase().contains(this.village)){
                reg.click();
                break;
            }
        }
    }
    public void setMicroDistrict(){
        if (driver.findElement(By.id("quartalField")).getAttribute("class").contains("field-disabled")){
            return;
        }

        driver.findElement(By.xpath("//*[@id=\"quartalField\"]/span[1]/span[2]")).click();
        List<WebElement> regions = driver.findElements(By.className("dropdown-input-values-address")).get(2).findElements(By.tagName("li"));
        for (WebElement reg: regions  ) {
            if (reg.getText().toLowerCase().contains(this.microdistrict)){
                reg.click();
                break;
            }
        }
    }
    public void setStreet(){

        if (driver.findElement(By.id("streetField")).getAttribute("class").equals("field-disabled")){
            return;
        }
        driver.findElement(By.xpath("//*[@id=\"streetField\"]/span[1]/span[2]")).click();
        int drpCount = driver.findElements(By.className("dropdown-input-values-address")).size();
        List<WebElement> regions = driver.findElements(By.className("dropdown-input-values-address")).get(drpCount - 1).findElements(By.tagName("li"));
        for (WebElement reg: regions  ) {
            if (reg.getText().toLowerCase().contains(this.street)){
                reg.click();
                break;
            }
        }
    }
    public void setLocation(){
        setRegion();
        try {Thread.sleep(1000);} catch (InterruptedException e) {}
        setDistrict();
        try {Thread.sleep(1000);} catch (InterruptedException e) {}

        setMicroDistrict();
        try {Thread.sleep(1000);} catch (InterruptedException e) {}

        setStreet();
    }
    public void setDescription(){
        driver.findElement(By.name("notes_lt")).sendKeys(this.description);
    }
    public void uploadImage(){
        File resourceFile = new File("images/" + this.imageUrl);
        driver.findElement(By.xpath("//*[@id=\"uploadPhotoBtn\"]/input")).sendKeys(resourceFile.getAbsolutePath());
    }

    public void setYoutubeUrl(){
        driver.findElement(By.name("Video")).sendKeys(this.youtubeUrl);
    }
    public void setPrice(){
        driver.findElement(By.id("priceField")).sendKeys(this.price);
    }
    public void setPhone(){
        driver.findElement(By.name("phone")).sendKeys(this.phone);
    }
    public void setEmail(){
        driver.findElement(By.name("email")).sendKeys(this.email);
    }
}
