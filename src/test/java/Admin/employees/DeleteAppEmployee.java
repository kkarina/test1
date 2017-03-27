package Admin.employees;


import org.junit.Test;
import jxl.Sheet;
import jxl.Workbook;

import java.io.FileInputStream;
import static Elements.LogIn.*;
import static Elements.Buttons.*;
import static Elements.EmployeeReference.*;
import static Elements.Pages.usersReference;

public class DeleteAppEmployee {
    private Sheet AppEmployeeForDelete;

    @Test
    public void TestDeleteAppEmployee() throws Exception {
        FileInputStream fi = new FileInputStream("C:\\Users\\Afashokova\\IdeaProjects\\test1\\data\\login.xls");
        Workbook inputFile = Workbook.getWorkbook(fi);
        AppEmployeeForDelete = inputFile.getSheet(7);
        int j = AppEmployeeForDelete.getRows();
        Admin();
        usersReference();
        AppEmployeeReference();
        String employee;
        for (int i = 1; i<j; i++) {
            employee = AppEmployeeForDelete.getCell(3,i).getContents();
            OpenEmployeeApp(employee);
            DeleteObject();
        }
        Signout();

    }
}
