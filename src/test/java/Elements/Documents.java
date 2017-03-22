package Elements;

/**
 * Created by afashokova on 22.02.2017.
 */
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

import java.io.FileInputStream;
import jxl.Sheet;
import jxl.Workbook;

public class Documents {
    //отркыть документы по субсидированию
    public Documents openDocuments() {
        $("a.clear-filter > span.text").click();
        return page(Documents.class);
    }

    //подать документы на заключение соглашения
    public Documents agreement()  throws Exception {
        $("div#custom-toolbar div.btn-group.btn-group-sm.btn-group-links-create > button").click();
        $("div#custom-toolbar li.link-create-agreement > a").click();
        $("form#form-create-agreement div:nth-child(2) > div > button").click();
        Sheet s;
        FileInputStream fi = new FileInputStream("C:\\Users\\Afashokova\\IdeaProjects\\test1\\data\\subsidies.xls");
        Workbook inputFile = Workbook.getWorkbook(fi);
        s = inputFile.getSheet(0);
        String subsidy;
        for(int i = 1; i<s.getRows(); i++){
            subsidy = s.getCell(0,i).getContents();
            $(withText(subsidy)).click();
        }
        $("div:nth-child(1) > label > input").click();
        $("div:nth-child(2) > label > input").click();
        $(".btn-create-statement").click();
        return page(Documents.class);
    }
}

