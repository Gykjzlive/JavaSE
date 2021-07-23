package ProjectThree.domain;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: 设计师
 * @date 2021/3/20 14:36
 */
public class Designer extends Programmer {
    private double bonus;//奖金

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails() + "\t设计师\t" + getStatus() + "\t" + bonus + "\t\t\t" + getEquipment().getDescription();
    }

    public String getDetailsForTeam() {
        return getMemberID() + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\t设计师\t" + bonus;
    }
}
