package study.day22;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/5/27 9:30
 */
interface clothFactory{
    void produceCloth();
}
class  dlColthFactory implements clothFactory{
    clothFactory factory;

    public dlColthFactory(clothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂准备做一些事情");
        factory.produceCloth();
        System.out.println("衣服生产完成");

    }
}
class NikeColthFactory implements clothFactory{

    @Override
    public void produceCloth() {
        System.out.println("nike衣服生产");
    }
}
public class Test {
    public static void main(String[] args) {
        NikeColthFactory nikeColthFactory = new NikeColthFactory();
        dlColthFactory dlColthFactory = new dlColthFactory(nikeColthFactory);
        dlColthFactory.produceCloth();
    }
}
