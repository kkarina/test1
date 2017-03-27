package Admin.Settlements;
import org.junit.*;
import java.io.FileInputStream;
import jxl.Sheet;
import jxl.Workbook;

import static Elements.SettlementsReference.*;
import static Elements.LogIn.*;
import static Elements.Pages.*;
import static Elements.Buttons.*;

/**
 * Created by afashokova on 01.02.2017.
 */
public class DeleteSettlement {

    private Sheet Settlement;
    @Test
    public void TestDeleteSettlement() throws Exception {
        FileInputStream fi = new FileInputStream("C:\\Users\\Afashokova\\IdeaProjects\\test1\\data\\login.xls");
        Workbook inputFile = Workbook.getWorkbook(fi);
        Settlement = inputFile.getSheet(9);
        int j = Settlement.getRows();
        Admin();
        OtherReferences();
        openSettlementsReference();
        String settlementName;
        for (int i = 1; i < j; i++) {
            settlementName = Settlement.getCell(1, i).getContents();
            openSettlement(settlementName);
            DeleteObject();
        }
        Signout();

    }
}
