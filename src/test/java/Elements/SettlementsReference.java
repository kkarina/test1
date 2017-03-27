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
    public static SettlementsReference openSettlementsReference() {
        $("div.block-slide.expanded > div > div:nth-child(2) > a").click();
        $("div.block-slide.expanded > div > a:nth-child(2)").click();
        return page(SettlementsReference.class);
    }

    //Создание нового поселения
    public static SettlementsReference newSettlement(String municipality, String settlement) {
        $("div#formChangeRow span.filter-option.pull-left").click();
        $(By.linkText(municipality)).click();
        sleep(500);
        $("div:nth-child(4) > div > input:nth-child(1)").setValue(settlement);
        return page(SettlementsReference.class);
    }

    //Просмотр поселения
    public static SettlementsReference openSettlement (String settlement){
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
    public static SettlementsReference editSettlement (String newMunicipality, String newSettlement){
        $("div#formChangeRow span.filter-option.pull-left").click();
        $(By.linkText(newMunicipality)).click();
        $("div:nth-child(4) > div > input:nth-child(1)").setValue(newSettlement);
        return page(SettlementsReference.class);
    }
}
