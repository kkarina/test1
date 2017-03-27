package Elements;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by afashokova on 27.03.2017.
 */
public class SubsidyReference {
    //Открытие справочника субсидий
    public static SubsidyReference openSubsidyReference() {
        $(withText("Справочник субсидий")).click();
        return page(SubsidyReference.class);
    }

    //Добавление новой субсидии
    public static SubsidyReference addSubsidy(String year, String number, String subprogamm, String subsidyName, String reason) {
        $("input#year").setValue(year);
        $("input#number").setValue(number);
        $("select#subprogrammId").selectOption(subprogamm);
        $("textarea#name").setValue(subsidyName);
        $("textarea#reason").setValue(reason);
        return page(SubsidyReference.class);
    }
}
