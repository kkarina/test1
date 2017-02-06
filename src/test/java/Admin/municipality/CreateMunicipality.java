package Admin.municipality;

/**
 * Created by afashokova on 06.02.2017.
 */
import Elements.*;
import jxl.Sheet;
import jxl.Workbook;
import org.junit.Test;

import java.io.FileInputStream;

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
        reference.References();
        MunicipalityReference municipalityReference = new MunicipalityReference();
        municipalityReference.openMunicipalityReference();
        String shortName, fullName;
        for (int i =1; i< municipalities.getRows();i++){
            shortName = municipalities.getCell(0,i).getContents();
            fullName = municipalities.getCell(1,i).getContents();
            municipalityReference.CreateMunicipality(shortName,fullName);
        }
        logOut.Signout();
    }
}
