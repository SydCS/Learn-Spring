import entity.*;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
//        System.out.println(new Car(new Engine(),new Brake()));

        // 不 new 对象 --> 反射
        // Class.forName()  xxx.class   obj.getClass()
        Class<?> carClass = Class.forName("entity.Car");
        Class<?> engineClass = Class.forName("entity.Engine");
        Class<?> brakeClass = Class.forName("entity.Brake");

        Car car = (Car) carClass.getDeclaredConstructor(IEngine.class, IBrake.class).newInstance(engineClass.newInstance(), brakeClass.newInstance());
        System.out.println(car);
    }
}
