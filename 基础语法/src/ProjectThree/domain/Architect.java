package ProjectThree.domain;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/3/20 14:39
 */
public class Architect extends Designer {
    private int stock;//股票

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetails() + "\t架构师\t" + getStatus() + "\t" + getBonus() + "\t" + stock + "\t" + getEquipment().getDescription();
    }

    public String getDetailsForTeam() {
        return getMemberID() + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\t架构师\t" + getBonus() + "\t" + stock;
    }
}
