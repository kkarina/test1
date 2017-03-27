package Admin.users;

import jxl.Sheet;
import jxl.Workbook;
import org.junit.Test;
import java.io.FileInputStream;

import static Elements.AccountsReference.*;
import static Elements.Buttons.*;
import static Elements.Pages.*;
import static Elements.LogIn.*;

public class CreateUser {
    private Sheet newLogin;
    private Sheet newEmployee;


    @Test
    public void TestNewUser() throws Exception {

        FileInputStream fi = new FileInputStream("C:\\Users\\Afashokova\\IdeaProjects\\test1\\data\\login.xls");
        Workbook inputFile = Workbook.getWorkbook(fi);
        newLogin = inputFile.getSheet(5);
        int j = newLogin.getRows();
        Admin();
        newEmployee = inputFile.getSheet(4);
        usersReference();
        openAccountsReference();

        String logon, email, employee, newPassword;
        for (int i = 1; i <= (j - 1); i++) {
            logon = newLogin.getCell(0, i).getContents();
            email = newLogin.getCell(1, i).getContents();
            employee = newEmployee.getCell(0, i).getContents().replace(" ", "") + ' '
                    + newEmployee.getCell(1, i).getContents().replace(" ", "")
                    + " " + newEmployee.getCell(2, i).getContents().replace(" ", "");
            newPassword = newLogin.getCell(2, i).getContents();
            AddButton();
            UserCreation(logon, email, employee, newPassword);
            SaveObject();
        }
        Signout();
    }

}
