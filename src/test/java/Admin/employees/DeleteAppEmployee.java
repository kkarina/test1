package Admin.employees;

import Elements.EmployeeReference;
import Elements.LogIn;
import Elements.LogOut;
import Elements.Pages;
import org.junit.Test;
import jxl.Sheet;
import jxl.Workbook;

import java.io.FileInputStream;

import static java.lang.Thread.sleep;

public class DeleteAppEmployee {
    private final LogIn login = new LogIn();
    private final LogOut logout = new LogOut();
    private final Pages reference = new Pages();
    private final EmployeeReference employeeReference = new EmployeeReference();
    private Sheet AppEmployeeForDelete;
    @Test
    public void TestDeleteAppEmployee() throws Exception {
        FileInputStream fi = new FileInputStream("C:\\Users\\Afashokova\\IdeaProjects\\test1\\data\\login.xls");
        Workbook inputFile = Workbook.getWorkbook(fi);
        AppEmployeeForDelete = inputFile.getSheet(7);
        int j = AppEmployeeForDelete.getRows();
        login.Admin();
     //   reference.References();
        employeeReference.employeeReference();
        employeeReference.AppEmployeeReference();
        String employee;
        for (int i = 1; i<j; i++) {
            employee = AppEmployeeForDelete.getCell(3,i).getContents();
            employeeReference.OpenEmployeeApp(employee);
            reference.DeleteObject();
            System.out.println(employee);
        }
        logout.Signout();

    }
}
