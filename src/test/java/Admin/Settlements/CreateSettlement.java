package Admin.Settlements;

/**
 * Created by afashokova on 30.01.2017.
 */
import Elements.SettlementsReference;
import Elements.LogOut;
import Elements.Pages;
import Elements.LogIn;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.SoftAsserts;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.AssertionMode.SOFT;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import org.junit.*;
import java.io.FileInputStream;
import jxl.Sheet;
import jxl.Workbook;



public class CreateSettlement {
    private final LogIn login = new LogIn();
    private final LogOut logout = new LogOut();
    private final Pages reference = new Pages();
    private final SettlementsReference settlementsReference = new SettlementsReference();
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
        login.Admin();
        reference.OtherReferences();
        settlementsReference.openSettlementsReference();
        String settlementName, municipality;
        for (int i = 1; i < j; i++) {
            reference.AddButton();
            settlementName = Settlement.getCell(1, i).getContents();
            municipality = Settlement.getCell(0,i).getContents();
            settlementsReference.newSettlement(municipality, settlementName);
            reference.SaveObject();
            $$("td.col-md-8").findBy(text(settlementName)).shouldBe(visible);
        }
        logout.Signout();

    }
}
