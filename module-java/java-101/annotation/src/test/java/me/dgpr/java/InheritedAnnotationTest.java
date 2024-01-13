package me.dgpr.java;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InheritedAnnotationTest {

    @Test
    void 자식_클래스에_어노테이션을_상속한다() {
        //Arrange
        Child child = new Child();
        Annotation[] annotations = child.getClass().getAnnotations();

        //Act //Assert
        Assertions.assertThat(Arrays.stream(annotations)
                        .filter(anno -> anno.annotationType().getName().contains("InheritedAnnotation"))
                        .findAny())
                .isPresent();
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface InheritedAnnotation {
}

@InheritedAnnotation
class Parent {

}

class Child extends Parent {

}
