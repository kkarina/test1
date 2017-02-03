package Admin.Settlements;
import Elements.SettlementsReference;
import Elements.LogOut;
import Elements.Pages;
import Elements.LogIn;
import org.junit.*;
import java.io.FileInputStream;
import jxl.Sheet;
import jxl.Workbook;



/**
 * Created by afashokova on 01.02.2017.
 */
public class DeleteSettlement {
    private final LogIn login = new LogIn();
    private final LogOut logout = new LogOut();
    private final Pages reference = new Pages();
    private final SettlementsReference settlementsReference = new SettlementsReference();
    private Sheet Settlement;
    @Test
    public void TestDeleteSettlement() throws Exception {
        FileInputStream fi = new FileInputStream("C:\\Users\\Afashokova\\IdeaProjects\\test1\\data\\login.xls");
        Workbook inputFile = Workbook.getWorkbook(fi);
        Settlement = inputFile.getSheet(9);
        int j = Settlement.getRows();
        login.SignIn(0, 3);
        reference.References();
        settlementsReference.openSettlementsReference();
        String settlementName;
        for (int i = 1; i < j; i++) {
            settlementName = Settlement.getCell(1, i).getContents();
            settlementsReference.openSettlement(settlementName);
            settlementsReference.deleteSettlement();
        }
        logout.Signout();

    }
}
