package Admin.Companies;

/**
 * Created by afashokova on 06.02.2017.
 */
import Elements.*;
import jxl.Sheet;
import jxl.Workbook;
import org.junit.Test;
import java.io.FileInputStream;

public class DeleteApp {
    LogIn logIn = new LogIn();
    LogOut logOut = new LogOut();
    Sheet APP;
    CompanyCard companies = new CompanyCard();
    Pages Companies = new Pages();

    @Test
    public void TestDeleteAPP() throws Exception{
        FileInputStream fi = new FileInputStream("C:\\Users\\Afashokova\\IdeaProjects\\test1\\data\\login.xls");
        Workbook inputFile = Workbook.getWorkbook(fi);
        APP = inputFile.getSheet(12);
        logIn.SignIn(1,1);
        Companies.Companies();
        String APPName;
        for (int i =1; i< APP.getRows(); i++){
            APPName = APP.getCell(0,i).getContents();
            Companies.DeleteObject();
        }
        logOut.Signout();
    }
}
