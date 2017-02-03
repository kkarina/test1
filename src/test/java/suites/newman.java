package suites;

import Admin.employees.NewEmployeeAPP;
import Admin.users.CreateUser;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



@RunWith(Suite.class)
@SuiteClasses({NewEmployeeAPP.class, CreateUser.class })
public class newman {

}