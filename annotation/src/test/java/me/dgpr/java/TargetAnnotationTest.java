package me.dgpr.java;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@TargetAnnotation
public class TargetAnnotationTest {

    @TargetAnnotation
    int i;

    @TargetAnnotation
    TargetAnnotationTest test;
}

@Target({
        ElementType.TYPE, // 클래스, 인터페이스, 레코드
        ElementType.TYPE_USE, // 타입의 변수
        ElementType.METHOD, // 메서드
        ElementType.FIELD, // 필드
        ElementType.PARAMETER, // 파라미터
})
@interface TargetAnnotation {
}
