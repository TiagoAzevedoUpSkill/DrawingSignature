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

    int[] arrayX = {374,378,380,386,397,401,408,422,438,448,462,466,469,476,489,494,502,507,513,517};

    int[] arrayY = {127,120,110,87,62,56,51,49,60,70,88,94,96,95,94,96,100,97,92,90};

    static void draw(WebDriver driver, String element) throws InterruptedException {
        Actions builder = new Actions(driver);
        Action drawAction = builder.moveToElement(driver.findElement(By.xpath(element))) //start points x axis and y axis.
                .clickAndHold()
                .moveByOffset(4, -7) // 2nd points (x1,y1)
                .moveByOffset(2, -10)// 3rd points (x2,y2)
                .moveByOffset(6, -30) // 2nd points (x1,y1)
                .moveByOffset(11, -15)// 3rd points (x2,y2)
                .moveByOffset(4, -8) // 2nd points (x1,y1)
                .moveByOffset(7, -2)// 3rd points (x2,y2)
                .moveByOffset(14, 11) // 2nd points (x1,y1)
                .moveByOffset(16, 10)// 3rd points (x2,y2)

//                .doubleClick()
                .build();
        drawAction.perform();
        Thread.sleep(6000);
    }

}
