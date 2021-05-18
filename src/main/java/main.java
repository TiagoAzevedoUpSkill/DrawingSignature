import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Execution after setting ChromeDriver path in System setProperty method");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // buscar o site e aumentar a janela
        driver.get("https://onlinesignature.com/draw-a-signature-online");
        driver.manage().window().maximize();

        // localizar o elemento e verificar se existe

        String canvas = "/html/body/section/div/div/div/div[1]/div/div[1]/canvas";

        draw(driver, canvas);

        Thread.sleep(3000);

        driver.close();

        System.out.println("Execution complete");
    }

    static void draw(WebDriver driver, String element) throws InterruptedException {
        Actions builder = new Actions(driver);
        Action drawAction = builder.moveToElement(driver.findElement(By.xpath(element))) //start points x axis and y axis.
                .clickAndHold()
                .moveByOffset(-30, 60) // 2nd points (x1,y1)
                .moveByOffset(-60, -70)// 3rd points (x2,y2)
                .moveByOffset(150, 60) // 2nd points (x1,y1)
                .moveByOffset(-60, -70)// 3rd points (x2,y2)
//                .doubleClick()
                .build();
        drawAction.perform();
        Thread.sleep(6000);
    }

}
