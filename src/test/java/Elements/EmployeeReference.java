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




    //Открыть справочник сотрудников АПП
    public static EmployeeReference AppEmployeeReference() {
        $(By.linkText("Сотрудники АПП")).click();
        return page(EmployeeReference.class);
    }

    //Создание нового сотрудника АПП
    public static EmployeeReference CreateAppEmployee(String secondName, String firstName, String middleName, String FIO, String company,
                                               String phoneNumber, String Role, String Statement, String state) {
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
        Pages mistake = new Pages();
        mistake.Mistake();
        return page (EmployeeReference.class);
    }
    //Открыть запись справочника Сотрудники АПП
    public static EmployeeReference OpenEmployeeApp(String employeeName) {
        $(withText(employeeName)).click();
        return page(EmployeeReference.class);
    }

}
