import lt.aruodas.Helper;
import lt.aruodas.Models.Plot;
import lt.aruodas.Models.RealEstate;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PlotTests {

    public static WebDriver driver;

    @Test
    public void aruodasLtPositiveTest() {
        Plot plot = new Plot("Kaunas", "", "Šilainiai", "9-ojo",  "Pigiai nebrangiai nupirksiu jūsų namą", "nameliumbas.jpg", "https://www.youtube.com/watch?v=9xkxT2hY634&pp=ygUTbHV4dXJ5IGhvdXNlIHJldmlldw%3D%3D", "", "2200000", "65214726", "sacebi1448@marksia.com","12","5555-5555-5555","Namų valda, miškų ūkio");
        plot.fillAd();

        Assert.assertEquals("", "");
    }

    @BeforeClass
    public void beforeClass() {
        Helper.driverInit();
        driver = RealEstate.driver;
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }



}

