/**
 * Created by afashokova on 15.11.2016.
 */
import static com.codeborne.selenide.Selenide.*;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;



import java.io.File;


public class test {
    private WebDriver driver;
    @Before
    public void setUp() throws Exception{
        driver = new FirefoxDriver();
    }

    @Test
    public void Test() throws Exception{
        open("https://gisapklo-test2.lenoblgis.ru/login");
        $(By.name("logonName")).setValue("app_stolbov");
        System.out.println("ввод логина");
        $(By.name("password")).setValue("123");
        System.out.println("ввод пароля");
        $(By.name("login-submit")).click();
        System.out.println("вход в ЛК");
        $(By.xpath("/html/body/div[2]/a[3]")).click();
        System.out.println("Переход к подаче документов");
       /* $(By.xpath("/html/body/div[1]/div/div/h2/div/button")).click();
        System.out.println("Нажатие кнопки подать");
        $(By.xpath("/html/body/div[1]/div/div/h2/div/ul/li[1]/a")).click(); //"Документы на заключение Соглашения"
        System.out.println("Документы на заключение Соглашения");
        $(By.xpath("/html/body/div[1]/div/div[2]/form/div[2]/div[2]/div/button")).click(); // Открыть список "Выбор субсидий
        System.out.println("Открыть список Выбор субсидий");
        $(By.linkText("Субсидии на возмещение части затрат на приобретение элитных семян")).click(); //Выбор субсидий
        System.out.println("Выбор субсидии");
        $(By.xpath("/html/body/div[1]/div/div[2]/form/div[2]/div[3]/div/div/div[3]/button")).click(); //Кнопка "Выбрать"
        System.out.println("Подтверждение выбора субсидий");
        $(By.cssSelector("input.confirm-status-checkbox.confirm-status-checkbox-1")).click();
        $(By.cssSelector("input.confirm-status-checkbox.confirm-status-checkbox-2")).click();
        System.out.println("Отметить галки");
        //отметить галки
        $(By.name("register-statement")).click();//подать заявление
        System.out.println("Нажатие кнопки Подать заявления");
        $(By.xpath("/html/body/div[4]/div/div[3]/button[2]")).click();//подтверждение
        System.out.println("Подтерждение подачи");
        $(By.cssSelector("button.btn.btn-warning.btn-without-esign")).click();//подать без эп
        System.out.println("Нажатие кнопки Подать без ЭП");*/
        $(By.linkText("Документы на заключение Соглашения")).click();//открыть проект
        System.out.println("Открытие проекта документов на заключение Соглашения");
        $(By.linkText("Приложение 1")).click();//переход к приложению 1
        System.out.println("Переход к Приложению 1");
        $(By.xpath("/html/body/div[1]/div/div[2]/form/div[3]/div[2]/div/table/tbody/tr/td[2]/div/div/div/input[2]")).setValue("3600");
        System.out.println("Заполнение полей Приложения 1");
        $(By.linkText("Соглашение")).click();
        System.out.println("Переход к вкладке Соглашение");
        $(By.xpath("/html/body/div[1]/div/div[2]/form/div[4]/div[4]/div/button")).click();
        System.out.println("Предпросмотр Соглашения");
        screenshot("Предпросмотр Соглашения");
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen, new File ("C:\\Users\\Afashokova\\IdeaProjects\\test1\\build\\reports\\.Предпросмотр.png"));
        System.out.println("Делаем скриншот");




    }
}
