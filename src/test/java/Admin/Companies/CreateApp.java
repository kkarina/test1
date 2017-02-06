package Admin.Companies;

/**
 * Created by afashokova on 03.02.2017.
 */

import Elements.*;
import com.codeborne.selenide.Configuration;
import org.junit.*;
import java.io.FileInputStream;
import jxl.Sheet;
import jxl.Workbook;
import com.codeborne.selenide.junit.SoftAsserts;
import static com.codeborne.selenide.Configuration.AssertionMode.SOFT;


public class CreateApp {
    private final LogIn login = new LogIn();
    private final LogOut logout = new LogOut();
    private final Pages companies = new Pages();
    private final CompanyCard companyCard = new CompanyCard();
    private Sheet Companies;
    @Rule
    public SoftAsserts softAsserts = new SoftAsserts();

    @Before
    public void switchToSoftAssertionsMode() {

        Configuration.assertionMode = SOFT;
    }
    @Test
    public void TestCreateApp() throws Exception {
        FileInputStream fi = new FileInputStream("C:\\Users\\Afashokova\\IdeaProjects\\test1\\data\\login.xls");
        Workbook inputFile = Workbook.getWorkbook(fi);
        Companies = inputFile.getSheet(11);
        int j = Companies.getRows();
        int k = Companies.getColumns();
        login.SignIn(1, 1);
        companies.Companies();
        String AppType, companyFullName,  companyShortName,  AppKind,  AppClass,  municipality,
               settlement, phoneNumber, faxNumber, INN, surname, firstName, middleName,
               bank, BankDetails, status, legalAddress,  actualAddress, ogrnip, okvad,
               pfrNumber, fssNumber, oktmo, pursuantAuthority, snils, kpp,  employeePosition,
               documentNumber, documentDate, ogrn;
        for (int i= 1; i<j; i++){
            AppType = Companies.getCell(0,i).getContents();
            companyFullName =Companies.getCell(1,i).getContents();
            companyShortName=Companies.getCell(2,i).getContents();
            AppKind = Companies.getCell(3,i).getContents();
            AppClass = Companies.getCell(4,i).getContents();
            municipality = Companies.getCell(5,i).getContents();
            settlement = Companies.getCell(6,i).getContents();
            phoneNumber=Companies.getCell(7,i).getContents();
            faxNumber=Companies.getCell(8,i).getContents();
            INN = Companies.getCell(9,i).getContents();
            surname = Companies.getCell(10,i).getContents();
            firstName = Companies.getCell(11,i).getContents();
            middleName = Companies.getCell(12,i).getContents();
            bank = Companies.getCell(13,i).getContents();
            BankDetails = Companies.getCell(14,i).getContents();
            status = Companies.getCell(15,i).getContents();
            legalAddress = Companies.getCell(16,i).getContents();
            actualAddress = Companies.getCell(17,i).getContents();
            ogrnip = Companies.getCell(18,i).getContents();
            okvad = Companies.getCell(19,i).getContents();
            pfrNumber = Companies.getCell(20,i).getContents();
            fssNumber = Companies.getCell(21,i).getContents();
            oktmo = Companies.getCell(22,i).getContents();
            pursuantAuthority = Companies.getCell(23,i).getContents();
            snils = Companies.getCell(24,i).getContents();
            kpp = Companies.getCell(25, i).getContents();
            employeePosition = Companies.getCell(26, i).getContents();
            documentNumber = Companies.getCell(27, i).getContents();
            documentDate = Companies.getCell(28, i).getContents();
            ogrn = Companies.getCell(29,i).getContents();
            companyCard.AddCompany(AppType, companyFullName,  companyShortName,  AppKind,  AppClass,  municipality,
                    settlement, phoneNumber, faxNumber, INN, surname, firstName, middleName,
                    bank, BankDetails, status, legalAddress,  actualAddress, ogrnip, okvad,
                    pfrNumber, fssNumber, oktmo, pursuantAuthority,snils,kpp,employeePosition,
                    documentNumber, documentDate, ogrn);
            companies.Companies();
        }
        logout.Signout();

    }

}
