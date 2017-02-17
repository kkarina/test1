package Admin.users;

import org.junit.Test;
import Elements.*;
import jxl.*;

import java.io.FileInputStream;


/**
 * Created by afashokova on 17.02.2017.
 */
public class EditUser {
    @Test
    public void TestEditUser() throws Exception{
        LogIn logIn = new LogIn();
        logIn.Admin();
        Pages reference = new Pages();
        reference.References();
        AccountsReference accountsReference = new AccountsReference();
        Sheet accounts;
        FileInputStream fi = new FileInputStream("C:\\Users\\Afashokova\\IdeaProjects\\test1\\data\\login.xls");
        Workbook inputFile = Workbook.getWorkbook(fi);
        accounts = inputFile.getSheet(15);
        String userName, newLogin, newEmail, newEmployee, newPass;
        for (int i = 1; i < accounts.getRows(); i++){
            accountsReference.openAccountsReference();
            userName = accounts.getCell(0,i).getContents();
            accountsReference.OpenUser(userName);
            newLogin = accounts.getCell(1,i).getContents();
            newEmail = accounts.getCell(2,i).getContents();
            newEmployee = accounts.getCell(3,i).getContents();
            newPass = accounts.getCell(4,i).getContents();
            accountsReference.EditUser(newLogin, newEmail, newEmployee, newPass);
            reference.SaveObject();
        }



    }
    }
