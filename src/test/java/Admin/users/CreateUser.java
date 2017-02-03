package Admin.users;

import Elements.AccountsReference;
import Elements.Pages;
import Elements.LogIn;
import Elements.LogOut;
import jxl.Sheet;
import jxl.Workbook;
import org.junit.Test;
import java.io.FileInputStream;



public class CreateUser {
    private final LogIn login = new LogIn();
    private final LogOut logout = new LogOut();
    private final AccountsReference accountsReference = new AccountsReference();
    private final Pages reference = new Pages();
    private Sheet newLogin;
    private Sheet newEmployee;


    @Test
    public void TestNewUser() throws Exception {

        FileInputStream fi = new FileInputStream("C:\\Users\\Afashokova\\IdeaProjects\\test1\\data\\login.xls");
        Workbook inputFile = Workbook.getWorkbook(fi);
        newLogin = inputFile.getSheet(5);
        int j = newLogin.getRows();
        login.SignIn(0, 3);
        newEmployee = inputFile.getSheet(4);
        reference.References();
        accountsReference.openAccountsReference();

        String logon, email, employee, newPassword;
        for (int i = 1; i <= (j - 1); i++) {
            logon = newLogin.getCell(0, i).getContents();
            email = newLogin.getCell(1, i).getContents();
            employee = newEmployee.getCell(0, i).getContents().replace(" ", "") + ' '
                    + newEmployee.getCell(1, i).getContents().replace(" ", "")
                    + " " + newEmployee.getCell(2, i).getContents().replace(" ", "");
            newPassword = newLogin.getCell(2, i).getContents();
            accountsReference.UserCreation(logon, email, employee, newPassword);
        }
        logout.Signout();
    }

}
