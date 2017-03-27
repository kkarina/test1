package Admin.users;
/**
 * Created by afashokova on 10.01.2017.
 */

import org.junit.Test;
import jxl.Sheet;
import jxl.Workbook;

import java.io.FileInputStream;

import static Elements.AccountsReference.*;
import static Elements.Buttons.*;
import static Elements.LogIn.*;
import static Elements.Pages.usersReference;

public class DeleteUser {
    private Sheet userName;
    @Test
    public void TestLoginRemoval() throws Exception {
        FileInputStream fi = new FileInputStream("C:\\Users\\Afashokova\\IdeaProjects\\test1\\data\\login.xls");
        Workbook inputFile = Workbook.getWorkbook(fi);
        userName = inputFile.getSheet(6);

        Admin();
        usersReference();
        openAccountsReference();
        String login;
        for (int i = 1; i < userName.getRows(); i++)
        {
            login = userName.getCell(0,i).getContents();
            OpenUser(login);
            DeleteObject();
        }
        Signout();
    }
}
