import lt.aruodas.Models.BuyRE;
import lt.aruodas.Helper;
import lt.aruodas.Models.RealEstate;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class buyReTests {

    public static WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        Helper.driverInit();
        driver = RealEstate.driver;
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }


    @Test
    public void aruodasLtPositiveTest() {
        BuyRE re = new BuyRE("Kaunas", "kaun", "Šilainiai", "9-ojo",  "Pigiai nebrangiai nupirksiu jūsų namą", "nameliumbas.jpg", "https://www.youtube.com/watch?v=9xkxT2hY634&pp=ygUTbHV4dXJ5IGhvdXNlIHJldmlldw%3D%3D", "", "2200000", "65214726", "sacebi1448@marksia.com","SKLYPAI MIE");
        re.fillAd();
        Assert.assertEquals("", "");
    }

}

