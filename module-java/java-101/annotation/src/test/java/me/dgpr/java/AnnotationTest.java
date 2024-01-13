package me.dgpr.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.junit.jupiter.api.Test;

@MyAnnotation
class AnnotationTest {

    @Test
    void 어노테이션의_조상은_Annotation이다() {
        //Arrange
        Class<MyClass> cls = MyClass.class;
        Annotation[] annotations = cls.getAnnotations();

        //Act //Assert
        for (Annotation anno : annotations) {
            System.out.println("toString() : " + anno.toString());
            System.out.println("hashCode() : " + anno.hashCode());
            System.out.println("equals() " + anno.equals(anno));
            System.out.println("annotationType() " + anno.annotationType());
        }
    }

    @Test
    void 익명_클래스로_어노테이션_생성하기() {
        //Arrange
        Annotation annotation = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return MyAnnotation.class;
            }
        };

        //Act
        Class<? extends Annotation> actual = annotation.annotationType();

        //Assert
        assertEquals(actual.getName(), MyAnnotation.class.getName());
    }
}

@MyAnnotation
class MyClass {

}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
}