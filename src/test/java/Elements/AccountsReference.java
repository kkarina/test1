package Elements;

/**
 * Created by afashokova on 11.01.2017.
 */
import org.openqa.selenium.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@SuppressWarnings("UnusedReturnValue")
public class AccountsReference {
    //Открытие справочника учетных записей
    public AccountsReference openAccountsReference() {
        $(By.xpath("//div[2]/div/div/div[2]/div")).click(); // открыть "Справочники профилей"
        $(By.linkText("Учётные записи")).click();
        return page(AccountsReference.class);
    }

    //Создание новой учетной записи
    public AccountsReference UserCreation(String login, String email, String employee, String Password) {
        $(By.xpath("(//button[@type='button'])[2]")).click();// "добавить"
        $(By.id("logonName")).setValue(login);
        $(By.id("email")).setValue(email);
        $(By.xpath("(//button[@type='button'])[6]")).click(); //открыть выпадающий список сотрудников
        $(By.id("employee.id")).selectOption(employee);
        $(By.id("newPassword")).setValue(Password);
        $(By.id("newPassword2")).setValue(Password);
        sleep(500);
        $("button.btn.btn-primary.save-form-btn").click(); //сохранить учетную запись
        return page(AccountsReference.class);
    }

    //Открыть запись справочника
    public AccountsReference OpenUser(String username){
        $(withText(username)).click();
        return page(AccountsReference.class);
    }

    //Удаление пользователя
    public AccountsReference DeleteUser() {
        $(".delete-btn.pull-left").click();
        $(".buttonOk").click();
        return page(AccountsReference.class);
    }


}
