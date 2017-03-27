package Admin.employees;

import org.junit.Test;
import java.io.FileInputStream;
import jxl.Sheet;
import jxl.Workbook;
import static Elements.LogIn.*;
import static Elements.Buttons.*;
import static Elements.EmployeeReference.*;
import static Elements.Pages.usersReference;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class NewEmployeeAPP {
    private Sheet s;

    @Test
    public void TestNewEmployeeAPP() throws Exception
    {
        FileInputStream fi = new FileInputStream("C:\\Users\\Afashokova\\IdeaProjects\\test1\\data\\login.xls");
        Workbook inputFile = Workbook.getWorkbook(fi);
        s = inputFile.getSheet(4);// данные для заполнения формы создания сотрудника АПП
        int j = s.getRows();
        Admin();
        usersReference();
        AppEmployeeReference();

        String secondName, firstName, middleName, FIO, company, phoneNumber, Role, Statement, state;

        for (int i = 1; i <j ; i++) {
            secondName = s.getCell(0,i).getContents();
            firstName = s.getCell(1, i).getContents();
            middleName = s.getCell(2, i).getContents();
            FIO = s.getCell(3, i).getContents();
            company = s.getCell(4, i).getContents();
            phoneNumber = s.getCell(5, i).getContents();
            Role = s.getCell(6, i).getContents();
            Statement= s.getCell(7,i).getContents();
            state =  s.getCell(8,i).getContents();
            AddButton();
            CreateAppEmployee(secondName, firstName, middleName, FIO, company, phoneNumber, Role, Statement, state);
            SaveObject();
            $(".table-hover tbody").shouldHave(text(secondName));
        }

        Signout();
     }


}
