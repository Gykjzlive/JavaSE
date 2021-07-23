package ProjectThree.domain;

import ProjectThree.domain.Equipment;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/3/20 13:51
 */
public class PC implements Equipment {
    private String model;//机器型号
    private String dsiplay;//显示器名称

    public PC() {
    }

    public PC(String model, String dsiplay) {
        this.model = model;
        this.dsiplay = dsiplay;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDsiplay() {
        return dsiplay;
    }

    public void setDsiplay(String dsiplay) {
        this.dsiplay = dsiplay;
    }

    @Override
    public String getDescription() {
        return model + "(" + dsiplay + ")";
    }
}
