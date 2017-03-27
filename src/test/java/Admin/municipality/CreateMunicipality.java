package Admin.municipality;

/**
 * Created by afashokova on 06.02.2017.
 */
import jxl.Sheet;
import jxl.Workbook;
import org.junit.Test;

import java.io.FileInputStream;

import static Elements.LogIn.*;
import static Elements.Buttons.*;
import static Elements.MunicipalityReference.*;
import static Elements.Pages.OtherReferences;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;

public class CreateMunicipality {
    private Sheet municipalities;

    @Test
    public void TestCreateMunicipality() throws Exception{
        FileInputStream fi = new FileInputStream("C:\\Users\\Afashokova\\IdeaProjects\\test1\\data\\login.xls");
        Workbook inputFile = Workbook.getWorkbook(fi);
        municipalities = inputFile.getSheet(13);
        Admin();
        OtherReferences();
        openMunicipalityReference();
        String shortName, fullName;
        for (int i =1; i< municipalities.getRows();i++){
            AddButton();
            shortName = municipalities.getCell(0,i).getContents();
            fullName = municipalities.getCell(1,i).getContents();
            CreateMunicipality(shortName,fullName);
            SaveObject();
            sleep(800);
            $$("td.col-md-3").findBy(text(shortName)).shouldBe(visible);

        }
        Signout();
    }
}
