package Admin.employees;

import Elements.EmployeeReference;
import Elements.LogOut;
import Elements.Pages;
import Elements.LogIn;
import org.junit.Test;
import java.io.FileInputStream;
import jxl.Sheet;
import jxl.Workbook;

import static com.codeborne.selenide.Selenide.$;

public class NewEmployeeAPP {
    private final LogIn login = new LogIn();
    private final LogOut logout = new LogOut();
    private final Pages reference = new Pages();
    private final EmployeeReference employeeReference = new EmployeeReference();
    private Sheet s;




    @Test
    public void TestNewEmployeeAPP() throws Exception
    {
        FileInputStream fi = new FileInputStream("C:\\Users\\Afashokova\\IdeaProjects\\test1\\data\\login.xls");
        Workbook inputFile = Workbook.getWorkbook(fi);
        s = inputFile.getSheet(4);// данные для заполнения формы создания сотрудника АПП
        int j = s.getRows();
        login.Admin();
        reference.References();
        employeeReference.employeeReference();
        employeeReference.AppEmployeeReference();

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
            employeeReference.CreateAppEmployee(secondName, firstName, middleName, FIO, company, phoneNumber, Role, Statement, state);
        }

        logout.Signout();
     }


}
