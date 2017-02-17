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
    //Справочники
    public Pages References() {
        $(By.xpath("/html/body/header/div[2]/div[2]/a[3]/span[2]")).shouldBe(visible).click();
        return page(Pages.class);
    }

    //Реестр предприятий
    public Pages Companies() {
        $("div:nth-child(1) > a > span.text").shouldBe(visible).click();
        return page(Pages.class);
    }

    //Удаление объекта
    public Pages DeleteObject() {
        $(".delete-btn.pull-left").click();
        $(".buttonOk").click();
        return page(Pages.class);
    }

    //Сохранение объекта
    public Pages SaveObject() {
        $(".save-form-btn").shouldBe(visible).click();
        return page(Pages.class);
    }

    //Проверка сообщения об ошибке
    public Pages Mistake() {
        if ($("ul#noty_topRight_layout_container").has(text("Ошибка выполнения")) == true) {
            $(withText("Об ошибке")).click();
            System.out.println($("div > div.bodyWindow").getText());
        }
        return page(Pages.class);
    }
}