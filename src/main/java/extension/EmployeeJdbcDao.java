package extension;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeJdbcDao {
    private Connection con;

    public EmployeeJdbcDao(Connection con) {
        this.con = con;
    }

    public void save() throws SQLException {
        String sql = "INSERT INTO employee VALUES(10, 'name')";
        Statement stmt = con.createStatement();
        stmt.execute(sql);
    }
    public List<Employee> findAll() throws SQLException {
        String sql = "SELECT id, first_name FROM employee";
        Statement stmt = con.createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        List<Employee> employees = new ArrayList<>();
        while (resultSet.next()) {
            Employee employee = new Employee();
            employee.setId(resultSet.getLong("id"));
            employee.setFirstName(resultSet.getString("first_name"));
            employees.add(employee);
        }

        return employees;
    }
}
