package extension;

import java.sql.Connection;
import java.sql.Savepoint;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class EmployeeDatabaseSetupExtension implements
    AfterAllCallback, BeforeEachCallback, AfterEachCallback {

    private Connection con = JdbcConnectionUtil.getConnection();
    private Savepoint savepoint;

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        con.setAutoCommit(false);
        savepoint = con.setSavepoint("before");
        System.out.println("call back in extension : beforeEach");
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        con.rollback(savepoint);
        System.out.println("call back in extension : afterEach");
    }
    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        if (con != null) {
            con.close();
        }
        System.out.println("call back in extension : afterAll");
    }
}
