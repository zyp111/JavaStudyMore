package reflection;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionTest {
    public static void main(String[] args) throws Exception{
        Person person = new Person(1,"张三");
        Class cls1 = person.getClass();
//        Field[] fields = cls1.getDeclaredFields();
//        for(Field field : fields) {
//            System.out.println(field);
//        }
//        Field field1 = cls1.getDeclaredField("id");
//        Field field2 = cls1.getField("name");
//        field2.set(person, "李四");
//        field1.setAccessible(true);
//        Object i = field1.get(person);
//        System.out.println(i);
//        System.out.println(person.getName());
//        Constructor constructor = cls1.getConstructor(int.class, String.class);
//        System.out.println(constructor);
        //创建对象
//        Person person1 = (Person) constructor.newInstance(3,"王五");
//        System.out.println(person1.getId());
        //获取指定名称方法
        Properties properties = new Properties();
        ClassLoader classLoader = Person.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("reflection.properties");
        properties.load(inputStream);

        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        Class cls = Class.forName(className);
//        Constructor constructor = cls.getConstructor(int.class, String.class);
//        Object object = constructor.newInstance(1,"张三");
        Object object = cls.newInstance();
        Method method = cls.getMethod(methodName);
        method.invoke(object);
    }
}
