package Elements;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class CompanyCard {
    String  fullName = "textarea#fullName",
            shortName = "input#shortName",
            Kind = "//div[3]/div/div/button",
            companyClass = "form#formCompany div:nth-child(6) > div > div > button > span.bs-caret > span",
            Settlement = "form#formCompany div:nth-child(7) > div > div > button",
            Phone = "input#mainPhone",
            Fax = "input#fax",
            inn = "input#inn",
            SecondName = "input#firstName",
            Name = "input#lastName",
            MiddleName = "input#middleName",
            AddBank = "form#formCompany h4 > button",
            BankName = "form#formCompany div.bank-form > div:nth-child(2) > div > div > button",
            account = "form#formCompany div.bank-form > div:nth-child(3) > div > input",
            STATUS = "form#formCompany label.btn.btn-default.btn-sm.active.toggle-off",
            LegAddress = "textarea#legalAddress",
            factAddress = "textarea#actualAddress",
            ogrnIP = "input#ogrnip",
            OKVAD= "input#okvad",
            PFR = "input#pfrNumber",
            FSS = "input#fssNumber",
            OKTMO = "input#oktmo",
            Authority = "input#pursuantAuthority";

    //Добавление паспорта предприятия
    public CompanyCard AddCompany(String AppType, String companyFullName, String companyShortName, String AppKind, String AppClass,
                                  String settlement, String phoneNumber, String faxNumber, String INN, String surname, String firstName, String middleName,
                                  String bank, String BankDetails, String status, String legalAddress, String actualAddress, String ogrnip, String okvad,
                                  String pfrNumber, String fssNumber, String oktmo, String pursuantAuthority, String snils, String kpp, String employeePosition,
                                  String documentNumber, String documentDate, String ogrn) {
        $("div#custom-toolbar div:nth-child(1) > button").click();
        $(withText(AppType)).click();
        $(fullName).setValue(companyFullName);
        $(shortName).setValue(companyShortName);
        $(By.xpath(Kind)).click();
        $(withText(AppKind)).click();//выбор вида АПП
        $(companyClass).click();
        $(withText(AppClass)).click();
        $(Settlement).click();
        $(withText(settlement)).click();
        $(Phone).setValue(phoneNumber);
        sleep(200);
        $(Fax).setValue(faxNumber);
        sleep(200);
        $(inn).setValue(INN);
        sleep(200);
        $(SecondName).shouldBe(Condition.visible).setValue(surname);
        $(Name).setValue(firstName);
        $(MiddleName).setValue(middleName);
        $(AddBank).click();
        $(BankName).click();
        $(withText(bank));
        $(account).setValue(BankDetails);
        if (status == "Да")
            $(STATUS).click();
        $(LegAddress).setValue(legalAddress);
        $(factAddress).setValue(actualAddress);
        if (AppType.equals("Физическое лицо")){
            $("input#snils").setValue(snils);
            sleep(500);
        }
        else {
            $(OKVAD).setValue(okvad);
            $(PFR).setValue(pfrNumber);
            $(FSS).setValue(fssNumber);
            $(OKTMO).setValue(oktmo);
            $(Authority).setValue(pursuantAuthority);
            if (AppType.equals("Индивидуальный предприниматель"))
                $(ogrnIP).setValue(ogrnip);
            else {
                $("input#ogrn").setValue(ogrn);
                $("input#kpp").setValue(kpp);
                $("input#employeePosition").setValue(employeePosition);
                $("input#documentNumber").setValue(documentNumber);
                $("form#formCompany div:nth-child(30) > div > input").pressEnter();
                sleep(500);
            }

        }

        $(withText("Сохранить")).click();
        $("div:nth-child(8) > div > p").shouldHave(text(INN));
        screenshot("C:\\Users\\Afashokova\\IdeaProjects\\test1\\build\\reports\\tests\\1.png");

        return page(CompanyCard.class);
    }
   }
