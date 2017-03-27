package Admin.subsidies;

/**
 * Created by afashokova on 27.03.2017.
 */

import jxl.Sheet;
import jxl.Workbook;
import org.junit.Test;

import java.io.FileInputStream;

import static Elements.Buttons.*;
import static Elements.LogIn.*;
import static Elements.Pages.*;
import static Elements.SubsidyReference.*;

public class CreateSubsidy {
    Sheet s;

    @Test
    public void CreateSubsidyTest() throws Exception{
        FileInputStream fi = new FileInputStream("C:\\Users\\Afashokova\\IdeaProjects\\test1\\data\\subsidies2.xls");
        Workbook inputFile  = Workbook.getWorkbook(fi);
        s = inputFile.getSheet(0);
        String year, number, subprogramm, subsidyName, reason;
        Admin();
        openSubsidies();
        openSubsidyReference();
        for (int i = 1; i< s.getRows(); i++)
        {
            year = s.getCell(0, i).getContents();
            number = s.getCell(1, i).getContents();
            subprogramm = s.getCell(2, i).getContents();
            subsidyName = s.getCell(3, i).getContents();
            reason = s.getCell(4, i).getContents();
            AddButton();
            addSubsidy(year, number, subprogramm, subsidyName, reason);
            SaveObject();
        }
        Signout();
    }

}
