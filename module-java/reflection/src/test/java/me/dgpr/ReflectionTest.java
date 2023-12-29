package me.dgpr;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReflectionTest {

    @Test
    @DisplayName("Class 인스턴스 가져오기")
    void getClassInstance() throws Exception {
        Class<Book> bookClass = Book.class; // 힙에 있는 클래스 가져오기

        Book book = new Book(); // 인스턴스를 통해서 힙에 있는 클래스 가져오기
        Class<? extends Book> aClass = book.getClass();

        Class<?> aClass1 = Class.forName("me.dgpr.Book"); // FQCN 으로 클래스 가져오기
    }

    @Test
    @DisplayName("퍼블릭 클래스 필드명 가져오기")
    void getPublicFields() throws Exception {
        //Arrange
        Class<Book> bookClass = Book.class;

        //Act
        Arrays.stream(bookClass.getFields())
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("퍼블릭 클래스 메서드명 가져오기")
    void getPublicMethods() throws Exception {
        //Arrange
        Class<Book> bookClass = Book.class;

        //Act
        Arrays.stream(bookClass.getMethods())
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("선언된 모든 클래스 필드명 가져오기")
    void getDeclaredFields() throws Exception {
        //Arrange
        Class<Book> bookClass = Book.class;

        //Act
        Arrays.stream(bookClass.getDeclaredFields())
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("선언된 모든 클래스 필드 값 가져오기")
    void getDeclaredFieldValues() throws Exception {
        //Arrange
        Class<Book> bookClass = Book.class;
        Book book = new Book();

        //Act
        Arrays.stream(bookClass.getDeclaredFields())
                .forEach(f -> {
                    int modifiers = f.getModifiers();
                    System.out.println(Modifier.isPrivate(modifiers));
                    System.out.println(Modifier.isPublic(modifiers));
                    System.out.println(Modifier.isAbstract(modifiers));

                    f.setAccessible(true);
                    try {
                        System.out.printf("[%s] %s\n", f, f.get(book));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }

    @Test
    @DisplayName("클래스로 인스턴스 생성하기")
    void createInstance() throws Exception {
        //Arrange
        Book book = Book.class
                .getConstructor(String.class, String.class, String.class)
                .newInstance("A", "B", "C");

        //Act //Assert
        Assertions.assertThat(book).isNotNull();
    }

    @Test
    @DisplayName("특정 필드 접근하기")
    void getSpecificField() throws Exception {
        //Arrange
        Book book = Book.class.getConstructor().newInstance();

        //Act
        Field nameB = Book.class.getDeclaredField("nameB");
        nameB.setAccessible(true);
        System.out.println(nameB.get(book));
    }

    @Test
    @DisplayName("특정 필드 변경하기")
    void setSpecificField() throws Exception {
        //Arrange
        Book book = Book.class.getConstructor().newInstance();

        //Act
        Field nameB = Book.class.getDeclaredField("nameB");
        nameB.setAccessible(true);
        nameB.set(book, "nameC");
        System.out.println(nameB.get(book));
    }

    @Test
    @DisplayName("메서드 실행하기")
    void invokeMethod() throws Exception {
        //Arrange
        Book book = Book.class.getConstructor().newInstance();

        //Act
        Method methodF = Book.class.getDeclaredMethod("methodF");
        methodF.setAccessible(true);
        methodF.invoke(book);

        Method sum = Book.class.getDeclaredMethod("sum", int.class, int.class);
        System.out.println(sum.invoke(book, 100, 200));
    }
}
