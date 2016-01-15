import com.karol.dao.EmployeeDao;
import com.karol.entity.Employee;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeDaoIT {

    public static final String JOHN = "John";
    public static final String MIKE = "Mike";

    EmployeeDao employeeDao = new EmployeeDao();

    @Test
    public void createEmployee() {
        Employee employee = employeeDao.create(Employee.builder().name(JOHN).build());

        assertThat(employee).isNotNull();
        assertThat(employee.getId()).isNotNull();
        assertThat(employeeDao.findById(employee.getId()).getName()).isEqualTo(JOHN);
    }

    @Test
    public void findAll() {
        employeeDao.create(Employee.builder().name(JOHN).build());
        employeeDao.create(Employee.builder().name(MIKE).build());

        assertThat(employeeDao.findAll()).hasSize(2);
    }

}