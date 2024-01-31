import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        Class<Person> personClass = Person.class;
//
//        for (Field field : personClass.getDeclaredFields()) {
//            System.out.println(field.getName());
//        }
//
//        for (Method method : personClass.getDeclaredMethods()) {
//            System.out.println(method.getName());
//        }
//
//        Person person = personClass.newInstance();
//
//        personClass.getDeclaredConstructor(String.class, int.class).newInstance("y", 12);


        Arrays.stream(Person.class.getDeclaredFields()).filter(field -> field.getAnnotation(MyAnnotation.class) != null)
                .forEach(field -> {
                    System.out.println(field.getAnnotation(MyAnnotation.class).attr1());
                });

    }
}