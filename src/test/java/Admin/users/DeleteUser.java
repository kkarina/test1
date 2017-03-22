package Admin.users;
/**
 * Created by afashokova on 10.01.2017.
 */

import Elements.AccountsReference;
import Elements.Pages;
import Elements.LogIn;
import Elements.LogOut;
import org.junit.Test;
import jxl.Sheet;
import jxl.Workbook;

import java.io.FileInputStream;

public class DeleteUser {
    private final LogIn logIn = new LogIn();
    private final LogOut logout = new LogOut();
    private final Pages reference = new Pages();
    private final AccountsReference accountsReference = new AccountsReference();
    private Sheet userName;
    @Test
    public void TestLoginRemoval() throws Exception {
        FileInputStream fi = new FileInputStream("C:\\Users\\Afashokova\\IdeaProjects\\test1\\data\\login.xls");
        Workbook inputFile = Workbook.getWorkbook(fi);
        userName = inputFile.getSheet(6);

        logIn.Admin();
     //   reference.References();
        accountsReference.openAccountsReference();
        String login;
        for (int i = 1; i < userName.getRows(); i++)
        {
            login = userName.getCell(0,i).getContents();
            accountsReference.OpenUser(login);
            reference.DeleteObject();
        }
        logout.Signout();
    }
}
