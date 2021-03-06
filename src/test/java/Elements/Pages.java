package Elements;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by afashokova on 11.01.2017.
 */
@SuppressWarnings("UnusedReturnValue")
public class Pages {

    //Прочие справочники
    public static Pages OtherReferences() {
        $("div:nth-child(7) > a > span.text").shouldBe(visible).click();
        return page(Pages.class);
    }

      //Реестр предприятий
    public static Pages Companies() {
        $("menu > a:nth-child(1) > span.text").shouldBe(visible).click();
        return page(Pages.class);
    }

    //Проверка сообщения об ошибке
    public static Pages Mistake() {
        if ($("ul#noty_topRight_layout_container").has(text("Ошибка выполнения")) == true) {
            $(withText("Об ошибке")).click();
            System.out.println($("div > div.bodyWindow").getText());
        }
        return page(Pages.class);
    }

    //Открыть справочники пользователей
    public static Pages usersReference() {
        $("div:nth-child(3) > a > span.text").click();
        return  page(Pages.class);
    }

    //Открыть "Документы по субсидированию"
    public static Pages openSubsidyDocuments() {
        $("a.clear-filter > span.text").click();
        return page(Pages.class);
    }

    //Открыть справочник "Субсидии"
    public static Pages openSubsidies() {
        $("div:nth-child(5) > a > span.text").click();
        return page(Pages.class);
    }
}