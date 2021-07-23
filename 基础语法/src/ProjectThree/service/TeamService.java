package ProjectThree.service;

import ProjectThree.domain.Architect;
import ProjectThree.domain.Designer;
import ProjectThree.domain.Employee;
import ProjectThree.domain.Programmer;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: 关于开发团队成员的管理，添加，删除等
 * @date 2021/3/20 18:43
 */
public class TeamService {
    private static int counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] programmers = new Programmer[MAX_MEMBER];
    private int total;

    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < total; i++) {
            team[i] = programmers[i];
        }
        return team;
    }

    //添加员工
    public void addMember(Employee e) throws TeamException {
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满,无法添加");
        }
        if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        if (isExist(e)) {
            throw new TeamException("该成员已经在本开发团队里，无法添加");
        }
        Programmer programmer = (Programmer) e;
        if (programmer.getStatus().getNAME().equals("BUSY")) {
            throw new TeamException("该成员已经在某开发团队里，无法添加");
        } else if (programmer.getStatus().getNAME().equals("VOCATION")) {
            throw new TeamException("该成员正在休假，无法添加");
        }
        int numOfArch = 0, numOfDes = 0, numOfPro = 0;
        for (int i = 0; i < total; i++) {
            if (programmers[i] instanceof Architect) {
                numOfArch++;
            } else if (programmers[i] instanceof Designer) {
                numOfDes++;
            } else if (programmers[i] instanceof Programmer) {
                numOfPro++;
            }
        }
        if (e instanceof Architect) {
            if (numOfArch >= 1) {
                throw new TeamException("团队中最多只能有一名架构师，无法添加");
            }
        } else if (e instanceof Designer) {
            if (numOfDes >= 2) {
                throw new TeamException("团队中最多只能有二名设计师，无法添加");
            }
        } else if (e instanceof Programmer) {
            if (numOfPro >= 3) {
                throw new TeamException("团队中最多只能有三名程序员，无法添加");
            }
        }
        programmers[total++] = programmer;
        programmer.setStatus(Status.BUSY);
        programmer.setMemberID(counter++);
    }

    private boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            if (e.getId() == programmers[i].getId()) {
                return true;
            }
        }
        return false;
    }

    //删除员工
    public void removeMember(int MemberID) throws TeamException {
        int i = 0;
        boolean flag = false;
        for (; i < total; i++) {
            if (programmers[i].getMemberID() == MemberID) {
                programmers[i].setStatus(Status.FREE);
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw new TeamException("找不到指定的员工，删除失败");
        }
        for (int j = i + 1; j < total; j++) {
            programmers[j - 1] = programmers[j];
        }
        programmers[--total] = null;
    }
}
