package Elements; /**
 * Created by afashokova on 28.12.2016.
 */
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.*;

public class LogOut {

    public LogOut Signout() {

        $("div:nth-child(3) > i").shouldBe(Condition.visible).click();
        $("button.btn-exit").click();
    return page(LogOut.class);
    }

}
