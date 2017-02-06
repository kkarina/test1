package Elements;


import static com.codeborne.selenide.Condition.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by afashokova on 27.01.2017.
 */
public class SettlementsReference {

    //Открытие справочника "Поселения"
    public SettlementsReference openSettlementsReference() {
        $(By.xpath("//div[2]/div/div/div[3]/div[1]")).click();
        $(By.xpath("//div[3]/div[2]/a[2]")).click();
        return page(SettlementsReference.class);
    }

    //Создание нового поселения
    public SettlementsReference newSettlement(String municipality, String settlement) {
        $(".add-value-btn").click();
        $("div#formChangeRow span.filter-option.pull-left").click();
        $(By.linkText(municipality)).click();
        sleep(500);
        $("div:nth-child(4) > div > input:nth-child(1)").setValue(settlement);
        $(".save-form-btn").click();
        $("div:nth-child(2) > div.col-table.col-md-9").shouldHave(text(settlement));
        return page(SettlementsReference.class);
    }

    //Просмотр поселения
    public SettlementsReference openSettlement (String settlement){
        if ($("div#reference span > button").is(visible) ==true) {
            $("div#reference span > button").click();
            $("div#reference span > ul > li:nth-child(2) > a").click();
        }
        if ($(withText(settlement)).is(exist)==true)
            $(withText(settlement)).click();
        else System.out.println(settlement);
        return page(SettlementsReference.class);
        }


    //Редактирование поселения
    public SettlementsReference editSettlement (String newMunicipality, String newSettlement){
        $("div#formChangeRow span.filter-option.pull-left").click();
        $(By.linkText(newMunicipality)).click();
        $("div:nth-child(4) > div > input:nth-child(1)").setValue(newSettlement);
        sleep (500);
        $(".save-form-btn").click();
        return page(SettlementsReference.class);
    }
}
