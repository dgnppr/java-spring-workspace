package me.dgpr.java;

class AnnotationElementValueTest {

    public static final String hello1 = "hello";
    public static String hello2 = "hello";
}

//@MyAnnotationValue1(value = "val", count = 3)
@MyAnnotationValue1("val") // count 엘리먼트에 default 값이 없으면 value = 를 생략할 수 없고, 위에처럼 명시해줘야함
class MyValueClass1 {

}

@MyAnnotationValue2("val")
class MyValueClass2 {

}

@MyAnnotationValue2(AnnotationElementValueTest.hello1) // 정적인 값, 컴파일러 수준에서 해석되는 값만 어노테이션에 전달될 수 있다.
// @MyAnnotationValue2(AnnotationElementValueTest.hello2) // 불가능
class MyValueClass3 {

}

@interface MyAnnotationValue1 {
    String value();

    int count() default 1;
}

@interface MyAnnotationValue2 {
    String value();
}