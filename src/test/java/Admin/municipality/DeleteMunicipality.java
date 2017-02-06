package Admin.municipality;

/**
 * Created by afashokova on 06.02.2017.
 */
import Elements.*;
import jxl.Sheet;
import jxl.Workbook;
import org.junit.Test;
import java.io.FileInputStream;

public class DeleteMunicipality {

    @Test
    public void TestDeleteMunicipality() throws Exception {
        LogIn logIn = new LogIn();
        Sheet municipalities;
        FileInputStream fi = new FileInputStream("C:\\Users\\Afashokova\\IdeaProjects\\test1\\data\\login.xls");
        Workbook inputFile = Workbook.getWorkbook(fi);
        municipalities = inputFile.getSheet(14);
        logIn.Admin();
        Pages referencies = new Pages();
        referencies.References();
        MunicipalityReference Municipalities = new MunicipalityReference();
        Municipalities.openMunicipalityReference();
        String shortName;
        for (int i=1; i<municipalities.getRows(); i++){
            shortName = municipalities.getCell(0,i).getContents();
            Municipalities.openMunicipality(shortName);
            referencies.DeleteObject();
        }
        LogOut logOut = new LogOut();
        logOut.Signout();
    }
}
