package extension;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(EmployeeDatabaseSetupExtension.class)
public class EmployeeJdbcDaoTest {

    private EmployeeJdbcDao employeeJdbcDao = new EmployeeJdbcDao(JdbcConnectionUtil.getConnection());

    @BeforeEach
    void setUp() {
        System.out.println("before each in Single Class");
    }

    @Test
    void findAll_test() throws SQLException {
        List<Employee> list = employeeJdbcDao.findAll();

        for (Employee employee : list) {
            System.out.println("employee.getFirstName() = " + employee.getFirstName());
        }
        
        System.out.println("it is test");
    }

    @Test
    void save_test() throws SQLException {

        List<Employee> all = employeeJdbcDao.findAll();

        employeeJdbcDao.save();

        List<Employee> all2 = employeeJdbcDao.findAll();
        System.out.println("after save " + all2.size());
        Assertions.assertEquals(all2.size(), 3);
    }
}
