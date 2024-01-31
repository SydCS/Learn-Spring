package alias;

import org.springframework.core.annotation.AnnotatedElementUtils;

@AnnotationB(value = 100,
        name = "xx",
        aliasForAnnotationAName = "a1",
        aliasForAnnotationAValue = -100
)
public class ClassC {
    public static void main(String[] args) {
        // Spring 提供一个查找注解的工具类 AnnotatedElementUtils
        System.out.println(AnnotatedElementUtils.getMergedAnnotation(ClassC.class, AnnotationB.class));
        System.out.println(AnnotatedElementUtils.getMergedAnnotation(ClassC.class, AnnotationA.class));
    }
}
