package Admin.Settlements;

/**
 * Created by afashokova on 30.01.2017.
 */
import Elements.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.SoftAsserts;

import static Elements.LogIn.*;
import static Elements.Buttons.*;
import static Elements.Pages.*;
import static Elements.SettlementsReference.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.AssertionMode.SOFT;
import static com.codeborne.selenide.Selenide.$$;

import org.junit.*;
import java.io.FileInputStream;
import jxl.Sheet;
import jxl.Workbook;





public class CreateSettlement {
     private Sheet Settlement;

    @Rule
    public SoftAsserts softAsserts = new SoftAsserts();

    @Before
    public void switchToSoftAssertionsMode() {
        Configuration.assertionMode = SOFT;
    }
    @Test
    public void TestCreateSettlement() throws Exception {
        FileInputStream fi = new FileInputStream("C:\\Users\\Afashokova\\IdeaProjects\\test1\\data\\login.xls");
        Workbook inputFile = Workbook.getWorkbook(fi);
        Settlement = inputFile.getSheet(8);
        int j = Settlement.getRows();
        Admin();
        OtherReferences();
        openSettlementsReference();
        String settlementName, municipality;
        for (int i = 1; i < j; i++) {
            AddButton();
            settlementName = Settlement.getCell(1, i).getContents();
            municipality = Settlement.getCell(0,i).getContents();
            newSettlement(municipality, settlementName);
            SaveObject();
            $$("td.col-md-8").findBy(text(settlementName)).shouldBe(visible);
        }
        Signout();

    }
}
