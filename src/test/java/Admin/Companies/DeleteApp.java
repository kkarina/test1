package Admin.Companies;

/**
 * Created by afashokova on 06.02.2017.
 */

import jxl.Sheet;
import jxl.Workbook;
import org.junit.Test;
import java.io.FileInputStream;

import static Elements.Buttons.*;
import static Elements.CompanyCard.OpenCompanyCard;
import static Elements.LogIn.SignIn;
import static Elements.Pages.Companies;

public class DeleteApp {
    Sheet APP;

    @Test
    public void TestDeleteAPP() throws Exception{
        FileInputStream fi = new FileInputStream("C:\\Users\\Afashokova\\IdeaProjects\\test1\\data\\login.xls");
        Workbook inputFile = Workbook.getWorkbook(fi);
        APP = inputFile.getSheet(12);
        SignIn(1,1);
        Companies();
        String INN;
        for (int i =1; i< APP.getRows(); i++){
            INN = APP.getCell(0,i).getContents();
            OpenCompanyCard(INN);
            DeleteObject();
        }
        Signout();
    }
}
