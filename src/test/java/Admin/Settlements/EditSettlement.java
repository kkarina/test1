package Admin.Settlements;
import org.junit.*;
import java.io.FileInputStream;
import jxl.Sheet;
import jxl.Workbook;

import static Elements.Buttons.*;
import static Elements.SettlementsReference.*;
import static Elements.Pages.*;
import static Elements.LogIn.*;

/**
 * Created by afashokova on 01.02.2017.
 */
public class EditSettlement {
    private Sheet Settlement;

    @Test
    public void TestEditSettlement() throws Exception {
        FileInputStream fi = new FileInputStream("C:\\Users\\Afashokova\\IdeaProjects\\test1\\data\\login.xls");
        Workbook inputFile = Workbook.getWorkbook(fi);
        Settlement = inputFile.getSheet(10);
        int j = Settlement.getRows();
        Admin();
        OtherReferences();
        openSettlementsReference();
        String settlementName, newMunicipality, newSettlementName;
        for (int i = 1; i < j; i++) {
            settlementName = Settlement.getCell(1, i).getContents();
            openSettlement(settlementName);
            newMunicipality = Settlement.getCell(2,i).getContents();
            newSettlementName = Settlement.getCell(3,i).getContents();
            editSettlement(newMunicipality,newSettlementName);
            SaveObject();
        }
        Signout();
    }
}
