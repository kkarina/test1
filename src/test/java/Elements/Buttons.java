package Elements;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;



import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by afashokova on 27.03.2017.
 */
public class Buttons {
    //Удаление объекта
    public static Buttons DeleteObject() {
        $(withText("Удалить")).shouldBe(visible).click();
        $(".buttonOk").click();
        return page(Buttons.class);
    }

    //Сохранение объекта
    public static Buttons SaveObject() {
        $(".save-form-btn").shouldBe(visible).click();
        return page(Buttons.class);
    }

    //Добавление объекта
    public static Buttons AddButton() {
        $(withText("Добавить")).click();
        return page(Buttons.class);
    }

    //Выход из личного кабинета
    public static Buttons Signout() {
        $(By.xpath("/html/body/header/nav/div[2]/i")).shouldBe(Condition.visible).click();
        $("button.btn-exit").click();
        return page(Buttons.class);
    }

}
