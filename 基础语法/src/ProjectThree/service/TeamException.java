package ProjectThree.service;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: 自定义异常类
 * @date 2021/3/20 16:18
 */
public class TeamException extends Exception {
    static final long serialVersionUID = -3387516993124229948L;

    public TeamException() {
    }

    public TeamException(String message) {
        super(message);
    }
}
