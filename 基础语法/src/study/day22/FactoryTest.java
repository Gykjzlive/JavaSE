package study.day22;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/5/27 10:42
 */
interface Human{
    String getBelief();
    void eat(String food);
}
//代理类
class  HumanFactory{
    public static Object getProxyInstance(Object object){
        MyHandler myHandler = new MyHandler();
        myHandler.bind(object);
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),myHandler);
    }
}
class MyHandler implements InvocationHandler {
    private Object object;
    public void bind(Object object){
        this.object=object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil humanUtil = new HumanUtil();
        humanUtil.method1();
        Object returnValue=method.invoke(object,args);
        humanUtil.method2();
        return returnValue;
    }
}
class SuperMan implements Human{
    @Override
    public String getBelief() {
        return "I believe i can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("今天中午吃"+food);
    }
}
class Kjys implements Human{
    @Override
    public String getBelief() {
        return "我想变成帝皇侠";
    }

    @Override
    public void eat(String food) {
        System.out.println("我想打"+food);
    }
}
class HumanUtil{
    public void method1(){
        System.out.println("..........方法一..............");
    }
    public void method2(){
        System.out.println("..........方法二..............");
    }
}
public class FactoryTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human proxyInstance = (Human) HumanFactory.getProxyInstance(superMan);
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("红烧肉");
        System.out.println("..........................................");
        Kjys kjys = new Kjys();
        Human proxyInstance1 = (Human) HumanFactory.getProxyInstance(kjys);
        System.out.println(proxyInstance1.getBelief());
        proxyInstance1.eat("异能兽");
        System.out.println("...........................................");
        NikeColthFactory nikeColthFactory = new NikeColthFactory();
        clothFactory proxyInstance2 =(clothFactory) HumanFactory.getProxyInstance(nikeColthFactory);
        proxyInstance2.produceCloth();
    }
}
