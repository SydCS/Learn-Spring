package org.example.entity.factory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.InputStream;
import java.util.Properties;

public class FruitFactoryBuilder {
    static String whichFactory;

    static {
        try (InputStream is = FruitFactoryBuilder.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties properties = new Properties();
            properties.load(is);
            whichFactory = properties.getProperty("fruitFactory");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static FruitFactory getFruitFactory(String whichFactory) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//        return (FruitFactory) Class.forName(whichFactory).newInstance();
//    }

    public static FruitFactory getFruitFactory() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        return (FruitFactory) Class.forName(whichFactory).newInstance();
    }
}

// Spring 注解写法
//@Configuration
//@PropertySource("classpath:app.properties")
//public class FruitFactoryBuilder {
//
//    @Value("${fruitFactory}")
//    String whichFactory;
//
//    public FruitFactory getFruitFactory() throws Exception {
//        return ((FruitFactory) Class.forName(whichFactory).newInstance());
//    }
//}