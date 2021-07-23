package ProjectThree.domain;

import ProjectThree.domain.Employee;
import ProjectThree.service.Status;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: 程序员
 * @date 2021/3/20 14:15
 */
public class Programmer extends Employee {
    private int memberID;//开发团队中的ID
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer() {
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return super.toString() + "\t程序员\t" + status + "\t\t\t\t\t" + equipment.getDescription();
    }

    public String getDetailsForTeam() {
        return memberID + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\t程序员";
    }
}
