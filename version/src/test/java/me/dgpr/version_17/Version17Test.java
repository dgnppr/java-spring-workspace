package me.dgpr.version_17;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @Link:
 * https://medium.com/javarevisited/java-17-vs-java-11-exploring-the-latest-features-and-improvements-6d13290e4e1a
 */
class Version17Test {

    /**
     * 쌍따옴표 3개로 텍스트 블록 생성
     * <br>
     * """는 들여쓰기 역할도 함
     * <br>
     * 새로운 이스케이프 문자 도입
     * <br>
     * - '\s' = 공백 추가
     * <br>
     * - '\' = 개행 제거
     */
    @Test
    @DisplayName("쌍따옴표 3개로 이스케이프 문자없이 텍스트 블록을 만들수 있다.")
    void testBlocks() {
        //Arrange
        String jsonText = """
                {
                    "name": "John Doe",
                    "age" : 45,
                    "address": "Doe Street, 23, Java Town"
                } 
                """;

        String sql = """
                SELECT id, firstName, lastName\s\
                FROM Employee
                WHERE departmentId = "IT" \
                ORDER BY lastName, firstName""";

        //Act
        System.out.println(jsonText);
        System.out.println(sql);
    }

    /**
     * 콜론(:) 대신에 arrow(->) 사용
     * <br>
     * arrow로 값 리턴 시 break 필요없음
     * <br>
     * default 케이스는 필수로 넣어줘야함
     */
    @Test
    @DisplayName("향상된 스위치문")
    void improvedSwitch() throws Exception {
        //Arrange
        int num = 1;
        String ret = switch (num) {
            case 1, 2 -> {
                yield "One or two";
            }
            case 3, 4 -> "Three or four";
            default -> "Undefined";
        };

        //Act
        System.out.println(ret);
    }

    /**
     * 레코드 내부에 클래스, 인터페이스, static으로 선언된 레코드를 선언할 수 있다.
     * <br>
     * 레코드는 인터페이스를 implements 할 수 있다.
     * <br>
     * generic record를 생성할 수 있다.
     * <br>
     * record는 serializable 하다.
     */
    @Test
    @DisplayName("향상된 레코드")
    void recordType() {
        //Arrange
        record Fruit(String name, int price) {
        }
        ;

        Fruit apple = new Fruit("Apple", 1000);

        //Act
        System.out.println(apple.name());
    }

    /**
     * @Link: https://www.baeldung.com/java-sealed-classes-interfaces
     */
    @Test
    @DisplayName("sealed class 도입")
    void sealedClass() throws Exception {
        //Arrange

        //Act

        //Assert
    }

    /**
     * @Link: https://www.baeldung.com/java-pattern-matching-instanceof
     */
    @Test
    @DisplayName("Pattern Matching with ‘instance of’")
    void instanceOfTest() throws Exception {
        //Arrange
        int age = 5;
        Object obj = new Cat(age);

        //Act
        if (obj instanceof Cat cat) {
            System.out.println(cat.getAge());
        }

    }
}
