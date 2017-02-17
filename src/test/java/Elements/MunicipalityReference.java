package Elements;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by afashokova on 01.02.2017.
 */
public class MunicipalityReference {
    //открытие справочника муниципальных районов
    public MunicipalityReference openMunicipalityReference() {
        $("div:nth-child(3) > div.title-reference").click();
        $("div.block-reference.active > div.listReferences.list-group > a:nth-child(1)").shouldBe(visible).click();
        return page(MunicipalityReference.class);
    }
    //Добавление нового района
    public MunicipalityReference CreateMunicipality(String shortName, String fullName) {
        $("div#custom-toolbar button").click();
        $("input#shortName").setValue(shortName);
        $("input#fullName").setValue(fullName);
        $("div#formChangeRow input.form-control.input-logo.with-set-input").uploadFile(new File("C:\\Users\\Afashokova\\Downloads\\artleo.com-97891.jpg"));
        return page(MunicipalityReference.class);
    }
    //просмотр района
    public MunicipalityReference openMunicipality(String shortName){
        $$("td.col-md-3").findBy(text(shortName)).click();
        return page(MunicipalityReference.class);
    }
}
