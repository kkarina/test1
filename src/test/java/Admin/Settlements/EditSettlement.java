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
public class EditSettlement {
    private final LogIn login = new LogIn();
    private final LogOut logout = new LogOut();
    private final Pages reference = new Pages();
    private final SettlementsReference settlementsReference = new SettlementsReference();
    private Sheet Settlement;

    @Test
    public void TestEditSettlement() throws Exception {
        FileInputStream fi = new FileInputStream("C:\\Users\\Afashokova\\IdeaProjects\\test1\\data\\login.xls");
        Workbook inputFile = Workbook.getWorkbook(fi);
        Settlement = inputFile.getSheet(10);
        int j = Settlement.getRows();
        login.Admin();
        reference.References();
        settlementsReference.openSettlementsReference();
        String settlementName, newMunicipality, newSettlmentName;
        for (int i = 1; i < j; i++) {
            settlementName = Settlement.getCell(1, i).getContents();
            settlementsReference.openSettlement(settlementName);
            newMunicipality = Settlement.getCell(2,i).getContents();
            newSettlmentName = Settlement.getCell(3,i).getContents();
            settlementsReference.editSettlement(newMunicipality,newSettlmentName);
        }
        logout.Signout();
    }
}
