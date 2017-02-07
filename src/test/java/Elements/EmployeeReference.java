package Elements;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import Elements.*;

/**
 * Created by afashokova on 11.01.2017.
 */
@SuppressWarnings("UnusedReturnValue")
public class EmployeeReference {

    ///Открыть справочники сотрудников
    public EmployeeReference employeeReference() {
        $(By.xpath("//div[2]/div/div/div[4]/div")).click();
        return  page(EmployeeReference.class);
    }


    //Открыть справочник сотрудников АПП
    public EmployeeReference AppEmployeeReference() {
        $(By.linkText("Сотрудники АПП")).click();
        return page(EmployeeReference.class);
    }

    //Создание нового сотрудника АПП
    public EmployeeReference CreateAppEmployee(String secondName, String firstName, String middleName, String FIO, String company,
                                               String phoneNumber, String Role, String Statement, String state) {
        $(By.xpath("(//button[@type='button'])[2]")).click();
        $(By.id("personName.lastName")).setValue(secondName);
        $(By.id("personName.firstName")).setValue(firstName);
        $(By.id("personName.middleName")).setValue(middleName);
        $(By.id("fioGenitive")).setValue(FIO);
        $(".form-control.finder-input").setValue(company);
        $(".no-result div.result").click();
        //sleep(1000);
        //$("h4.modal-title").click();
        $(By.id("phoneNumber")).hover().setValue(phoneNumber);
        $("#appEmployeeRole").selectOptionByValue(Role); //открытие списка "Сотрудник"
        $(By.id("position")).setValue(Statement);
        $(By.id("positionGenitive")).setValue(state);
        $(".save-form-btn").click();
        Pages mistake = new Pages();
        mistake.Mistake();
        $(".table-hover tbody").shouldHave(text(secondName));
        return page (EmployeeReference.class);
    }
    //Открыть запись справочника Сотрудники АПП
    public EmployeeReference OpenEmployeeApp(String employeeName) {
        $(withText(employeeName)).click();
        return page(EmployeeReference.class);
    }

}
