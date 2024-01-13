package me.dgpr.java;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class BasicAnnotationTest {

    @Test
    void 함수형_인터페이스_어노테이션_선언하기() {
        //Arrange
        MyFunctionalInterface myFunctionalInterface = () -> System.out.println("hello");

        //Act //Assert
        myFunctionalInterface.hello();
    }

    @Test
    void 컴파일러_보여주는_경고_메시지가_보이지_않게_억제하기() {
        new SuppressWarningsClass().run();
    }
}

@FunctionalInterface
interface MyFunctionalInterface {
    void hello();
    // void hello2(); // 선언 불가능. 인터페이스에는 단 하나의 메서드만 존재해야함.
}

@SuppressWarnings({"unchecked"})
class SuppressWarningsClass {
    void run() {
        ArrayList list = new ArrayList();
        list.add("string");
        list.add(2);
    }
}
