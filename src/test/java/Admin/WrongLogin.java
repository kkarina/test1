package Admin; /**
 * Created by afashokova on 28.12.2016.
 */

import static com.codeborne.selenide.Selenide.*;
import org.junit.Test;
import org.openqa.selenium.*;
import static com.codeborne.selenide.Condition.*;


public class WrongLogin {
    @Test
    public void TestWrongLogin()  throws Exception
    {
        open("https://agroview-test.lenoblgis.ru/");
        $(By.id("loginName")).setValue("login");
        $(By.id("password")).setValue("123");
        $(By.id("login-submit")).click();
        $("div.alert-message.text-danger").shouldHave(text("Сервис аутентификации недоступен. Неправильное имя пользователя или пароль."));
    }

    @Test
    public void TestWrongPass() throws Exception
    {
        open("https://agroview-test.lenoblgis.ru/");
        $(By.id("loginName")).setValue("app1");
        $(By.id("password")).setValue("1233");
        $(By.id("login-submit")).click();
        $("div.alert-message.text-danger").shouldHave(text("Сервис аутентификации недоступен. Неправильное имя пользователя или пароль."));
    }
}
