package Admin.users;

import org.junit.Test;
import jxl.*;

import java.io.FileInputStream;

import static Elements.AccountsReference.*;
import static Elements.Buttons.*;
import static Elements.Pages.usersReference;
import static Elements.LogIn.Admin;


/**
 * Created by afashokova on 17.02.2017.
 */
public class EditUser {
    @Test
    public void TestEditUser() throws Exception{

        Sheet accounts;
        FileInputStream fi = new FileInputStream("C:\\Users\\Afashokova\\IdeaProjects\\test1\\data\\login.xls");
        Workbook inputFile = Workbook.getWorkbook(fi);
        accounts = inputFile.getSheet(15);
        String userName, newLogin, newEmail, newEmployee, newPass;
        Admin();
        usersReference();
        openAccountsReference();
        for (int i = 1; i < accounts.getRows(); i++){
            userName = accounts.getCell(0,i).getContents();
            newLogin = accounts.getCell(1,i).getContents();
            newEmail = accounts.getCell(2,i).getContents();
            newEmployee = accounts.getCell(3,i).getContents();
            newPass = accounts.getCell(4,i).getContents();
            OpenUser(userName);
            EditUser(newLogin, newEmail, newEmployee, newPass);
            SaveObject();
        }
        Signout();

    }
    }
