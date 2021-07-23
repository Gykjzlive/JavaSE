package ProjectThree.view;

import ProjectThree.domain.Employee;
import ProjectThree.domain.Programmer;
import ProjectThree.service.NameListService;
import ProjectThree.service.TeamException;
import ProjectThree.service.TeamService;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: 操作视图
 * @date 2021/3/21 13:12
 */
public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public void enterMainMenu() {
        boolean flag = true;
        char menu = 0;
        while (flag) {
            if (menu != '1') {
                listAllEmployees();
            }
            System.out.print("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4): ");
            menu = TSUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("确认是否退出(Y/N):");
                    char isExit = TSUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        flag = false;
                    }
                    break;
            }
        }
    }

    //显示公司所有成员
    private void listAllEmployees() {
        System.out.println("----------------------------------开发团队调度软件----------------------------------\n");
        Employee[] employees = listSvc.getAllEmployees();
        if (employees.length == 0 || employees == null) {
            System.out.println("公司中没有任何员工信息");
        } else {
            System.out.println("ID\t姓名\t\t年龄\t工资\t\t职位\t\t状态\t\t奖金\t\t股票\t\t领用设备");
            for (int i = 0; i < employees.length; i++) {
                System.out.println(employees[i]);
            }
        }
        System.out.println("--------------------------------------------------------------------------------\n");
    }

    //获取开发团队
    private void getTeam() {
        System.out.println("\n---------------------团队成员列表------------------\n");
        Programmer[] programmers = teamSvc.getTeam();
        if (programmers == null || programmers.length == 0) {
            System.out.print("目前没有成员!\n");
        } else {
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票\n");
            for (int i = 0; i < programmers.length; i++) {
                System.out.println(programmers[i].getDetailsForTeam());
            }
        }
        System.out.println("-------------------------------------------------\n");
    }

    //添加成员到开发团队里
    private void addMember() {
        System.out.println("\n---------------------添加开发团队成员------------------\n");
        System.out.print("请输入要添加的员工ID:");
        int id = TSUtility.readInt();
        try {
            Employee employee = listSvc.getEmployee(id);
            teamSvc.addMember(employee);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println("添加失败，原因：" + e.getMessage());
        }
        TSUtility.readReturn();
    }

    //删除开发团队成员
    private void deleteMember() {
        System.out.println("\n---------------------删除开发团队成员------------------\n");
        System.out.print("请输入要删除的员工ID:");
        int id = TSUtility.readInt();
        System.out.println("是否确认删除(Y/N):");
        char flag = TSUtility.readConfirmSelection();
        if (flag == 'Y') {
            try {
                teamSvc.removeMember(id);
                System.out.println("删除成功");
            } catch (TeamException e) {
                System.out.println("删除失败的原因:" + e.getMessage());
            }
        } else if (flag == 'N') {
            return;
        }
        TSUtility.readReturn();
    }

    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();
    }
}
