package alias;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@AnnotationA
public @interface AnnotationB {
    int value() default 1;

    // 注解AnnotationB内部显式别名
    @AliasFor("aliasForName")
    String name() default "";

    // 注解AnnotationB内部显式别名
    @AliasFor(annotation = AnnotationB.class, attribute = "name")
    String aliasForName() default "";

    // 元注解AnnotationA属性name显式别名
    @AliasFor(annotation = AnnotationA.class, value = "name")
    String aliasForAnnotationAName() default "";

    // 元注解AnnotationA属性name显式别名2
    @AliasFor(annotation = AnnotationA.class, value = "name")
    String aliasForAnnotationAName2() default "";

    // 元注解AnnotationA属性value显式别名
    @AliasFor(annotation = AnnotationA.class, value = "value")
    int aliasForAnnotationAValue() default -1;
}
