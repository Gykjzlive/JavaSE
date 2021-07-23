package ProjectThree.junit;

import ProjectThree.domain.Employee;
import ProjectThree.service.NameListService;
import ProjectThree.service.TeamException;
import org.junit.Test;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: 测试
 * @date 2021/3/20 16:28
 */
public class NameListServiceTest {
    @Test
    public void testGetAllEmployees() {
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testGetEmployee() {
        NameListService service = new NameListService();
        int id = 13;
        try {
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }
}
