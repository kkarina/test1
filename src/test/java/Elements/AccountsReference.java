package Elements;

/**
 * Created by afashokova on 11.01.2017.
 */
import org.openqa.selenium.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@SuppressWarnings("UnusedReturnValue")
public class AccountsReference {
    String logon = "logonName",
            Email = "email",
            employeeList = "(//button[@type='button'])[6]",
            employeeName = "employee.id",
            newPass = "newPassword",
            newPass2 = "newPassword2";

    //Открытие справочника учетных записей
    public AccountsReference openAccountsReference() {
        $(By.xpath("//div[2]/div/div/div[2]/div")).click(); // открыть "Справочники профилей"
        $(By.linkText("Учётные записи")).click();
        return page(AccountsReference.class);
    }

    //Создание новой учетной записи
    public AccountsReference UserCreation(String login, String email, String employee, String Password) {
        $(By.xpath("(//button[@type='button'])[2]")).click();// "добавить"
        $(By.id(logon)).setValue(login);
        $(By.id(Email)).setValue(email);
        $(By.xpath(employeeList)).click(); //открыть выпадающий список сотрудников
        $(By.id(employeeName)).selectOption(employee);
        $(By.id(newPass)).setValue(Password);
        $(By.id(newPass2)).setValue(Password);
        return page(AccountsReference.class);
    }

    //Открыть запись справочника
    public AccountsReference OpenUser(String username) {
        $(withText(username)).click();
        return page(AccountsReference.class);
    }

    //Редактирование учетной записи
    public AccountsReference EditUser(String newLogin, String newEmail, String newEmployee, String newPassword) {

        $(By.id(logon)).setValue(newLogin);
        $(By.id(Email)).setValue(newEmail);
        $(By.xpath(employeeList)).click(); //открыть выпадающий список сотрудников
        $(By.id(employeeName)).selectOption(newEmployee);
        $(By.id(newPass)).setValue(newPassword);
        $(By.id(newPass2)).setValue(newPassword);
        return page(AccountsReference.class);

    }
}

