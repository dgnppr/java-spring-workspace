package me.dgpr.java;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class RetentionAnnotationTest {
}


/**
 * 일반 주석처럼 사용된다. 소스 단에서만 사용하고 컴파일될 때는 어노테이션이 필요없다.
 */
@Retention(RetentionPolicy.SOURCE)
@interface SourceRetentionAnnotation {
}

/**
 * - 컴파일될 때까지 어노테이션을 유지한다. 컴파일하고 나면 어노테이션 정보가 사라진다.
 * <p>
 * - 바이트 코드에 들어있다가 런타임 때 클래스 로더가 메모리에 적재할 때 class 어노테이션은 누락시킨다.
 * <p>
 * - 즉, 리플렉션 사용 불가능
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
@interface ClassRetentionAnnotation {
}

class RetentionTestClass {
    @ClassRetentionAnnotation
    public void test() {
        System.out.println("test");
    }
}