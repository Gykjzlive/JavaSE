package ProjectThree.service;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: 自定义状态
 * @date 2021/3/20 14:22
 */
public class Status {
    private final String NAME;

    private Status(String name) {
        NAME = name;
    }

    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
