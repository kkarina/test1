package Elements;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
/**
 * Created by afashokova on 01.02.2017.
 */
public class CompanyCard {

    //Добавление паспорта предприятия
    public CompanyCard AddCompany(String AppType, String companyFullName, String companyShortName, String AppKind, String AppClass, String municipality,
                                  String settlement, String phoneNumber, String faxNumber, String INN, String surname, String firstName, String middleName,
                                  String bank, String BankDetails, String status, String legalAddress, String actualAddress, String ogrnip, String okvad,
                                  String pursuantAuthority) {
        $("div#custom-toolbar div:nth-child(1) > button").click();
        System.out.println("Нажать кнопку Добавить");
        $(withText(AppType)).click();
        System.out.println("Выбрать тип АПП");
        $("textarea#fullName").setValue(companyFullName);
        System.out.println("Ввести Полное наименование компании");
        $("input#shortName").setValue(companyShortName);
        System.out.println("Ввести краткое наименование компании");
        $("form#formCompany div:nth-child(5) > div > div > button").selectOptionByValue(AppKind);//выбор вида АПП
        System.out.println("Выбрать вид АПП");
        $("form#formCompany div:nth-child(6) > div > div > button > span.bs-caret > span").selectOptionByValue(AppClass);
        System.out.println("Выбрать направление деятельности");
        $("css=form#formCompany div:nth-child(7) > div > div > button").selectOptionByValue(municipality);
        System.out.println("Выбрать район");
        $("form#formCompany div:nth-child(8) > div > div > button").selectOptionByValue(settlement);
        System.out.println("Выбрать поселение");
        $("input#mainPhone").setValue(phoneNumber);
        sleep(200);
        System.out.println("Ввести номер телефона");
        $("input#fax").setValue(faxNumber);
        sleep(200);
        System.out.println("Ввести номер факса");
        $("input#inn").setValue(INN);
        System.out.println("Ввести ИНН");
        $("input#firstname").setValue(surname);
        System.out.println("Ввести фамилию");
        $("input#secondName").setValue(firstName);
        System.out.println("Ввести имя");
        $("input#middleName").setValue(middleName);
        System.out.println("Ввести отчество");
        $("form#formCompany h4 > button").click();

        $("form#formCompany div.bank-form > div:nth-child(2) > div > div > button").selectOptionByValue(bank);
        $("form#formCompany div.bank-form > div:nth-child(3) > div > input").setValue(BankDetails);
        if (status == "Да")
            $("form#formCompany label.btn.btn-default.btn-sm.active.toggle-off").click();
        $("textarea#legalAddress").setValue(legalAddress);
        $("textarea#actualAddress").setValue(actualAddress);
        $("input#ogrnip").setValue(ogrnip);
        $("input#okvad").setValue(okvad);
        $("input#pursuantAuthority").setValue(pursuantAuthority);
        $("form#formCompany div:nth-child(28) > div > button").click();
        return page(CompanyCard.class);
    }
}
