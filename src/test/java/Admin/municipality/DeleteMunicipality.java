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

public class DeleteMunicipality {

    @Test
    public void TestDeleteMunicipality() throws Exception {
        Sheet municipalities;
        FileInputStream fi = new FileInputStream("C:\\Users\\Afashokova\\IdeaProjects\\test1\\data\\login.xls");
        Workbook inputFile = Workbook.getWorkbook(fi);
        municipalities = inputFile.getSheet(14);
        Admin();
        OtherReferences();
        openMunicipalityReference();
        String shortName;
        for (int i=1; i<municipalities.getRows(); i++){
            shortName = municipalities.getCell(0,i).getContents();
            openMunicipality(shortName);
            DeleteObject();
        }
        Signout();
    }
}
