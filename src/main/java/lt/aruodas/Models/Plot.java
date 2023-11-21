package lt.aruodas.Models;

import org.openqa.selenium.By;

public class Plot extends RealEstate{


public String addressNo;
public String rcNo;
public String purposes;

    public Plot(String municipality, String village, String microdistrict, String street, String description, String imageUrl, String youtubeUrl, String virtualTour, String price, String phone, String email, String addressNo, String rcNo, String purposes) {
        super(municipality, village, microdistrict, street, description, imageUrl, youtubeUrl, virtualTour, price, phone, email);
        this.addressNo = addressNo;
        this.rcNo = rcNo;
        this.purposes = purposes.trim().toLowerCase().replace(", ",",");
    }

    @Override
    public void fillAd() {
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=11");
        super.fillAd();
        setAddressNo();
        setRcNo();
        setPurposes();
        //driver.findElement(By.xpath("//*[@id=\"submitFormButton\"]")).click();
    }
    public void setPurposes(){
        String[] purposes = this.purposes.split(",");
        for (int i = 0; i < purposes.length; i++) {

            switch (purposes[i]) {
                case "namų valda":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[1]/label")).click();
                    break;
                case "Daugiabučių statyba":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[2]/label")).click();
                    break;
                case "Žemės ūkio":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[3]/label")).click();
                    break;
                case "sklypas soduose":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[4]/label")).click();
                    break;
                case "miškų ūkio":
                    driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div/div[5]/label")).click();
                    break;
            }
        }
    }
    public void setAddressNo(){
            driver.findElement(By.name("FHouseNum")).sendKeys(this.addressNo);
    }
    public void setRcNo(){
        driver.findElement(By.name("RCNumber")).sendKeys(this.rcNo);

    }



}

