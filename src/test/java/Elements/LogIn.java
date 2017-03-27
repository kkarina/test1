package Elements;

import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.*;
import static com.codeborne.selenide.Condition.*;

import java.io.FileInputStream;
import jxl.Sheet;
import jxl.Workbook;


public class    LogIn {
    private static Sheet s;

    public static LogIn SignIn(int str, int sheet) throws Exception {


        FileInputStream fi = new FileInputStream("C:\\Users\\Afashokova\\IdeaProjects\\test1\\data\\login.xls");
        Workbook inputFile = Workbook.getWorkbook(fi);
        s = inputFile.getSheet(sheet);//АПП - 0; АПК - 1; ОМСУ - 2; АДМИН - 3
        String login = s.getCell(0, str).getContents();
        String password = s.getCell(1, str).getContents();
        open("https://agroview-test.lenoblgis.ru");
        $(By.id("loginName")).shouldBe(visible).setValue(login);
        $(By.id("password")).setValue(password);
        $(By.id("login-submit")).click();
        return page(LogIn.class);
    }

    public static LogIn Admin () throws Exception{
        open("https://agroview-test.lenoblgis.ru");
        $(By.id("loginName")).shouldBe(visible).setValue("admin");
        $(By.id("password")).setValue("123");
        $(By.id("login-submit")).click();
        return page(LogIn.class);
    }

}