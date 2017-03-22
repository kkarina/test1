package Admin.municipality;

/**
 * Created by afashokova on 06.02.2017.
 */
import Elements.*;
import jxl.Sheet;
import jxl.Workbook;
import org.junit.Test;

import java.io.FileInputStream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;

public class CreateMunicipality {

    @Test
    public void TestCreateMunicipality() throws Exception{
        LogIn logIn = new LogIn();
        LogOut logOut = new LogOut();
        Pages reference = new Pages();
        Sheet municipalities;
        FileInputStream fi = new FileInputStream("C:\\Users\\Afashokova\\IdeaProjects\\test1\\data\\login.xls");
        Workbook inputFile = Workbook.getWorkbook(fi);
        municipalities = inputFile.getSheet(13);
        logIn.Admin();
        MunicipalityReference municipalityReference = new MunicipalityReference();
        reference.OtherReferences();
        municipalityReference.openMunicipalityReference();
        String shortName, fullName;
        for (int i =1; i< municipalities.getRows();i++){
            reference.AddButton();
            shortName = municipalities.getCell(0,i).getContents();
            fullName = municipalities.getCell(1,i).getContents();
            municipalityReference.CreateMunicipality(shortName,fullName);
            reference.SaveObject();
            sleep(800);
            $$("td.col-md-3").findBy(text(shortName)).shouldBe(visible);

        }
        logOut.Signout();
    }
}
