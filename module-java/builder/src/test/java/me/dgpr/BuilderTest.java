package me.dgpr;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BuilderTest {

    @Test
    void 직접_빌더_패턴으로_객체_생성하기() {
        //Act
        CustomBuilder cls = CustomBuilder.build()
                .age(10)
                .name("cls")
                .build();

        //Assert
        assertThat(cls.getName()).isEqualTo("cls");
        assertThat(cls.getAge()).isEqualTo(10);
    }

    @Test
    void 클래스_위에_롬복_빌더_사용하기() {
        //Act
        ClassBuilder cls = ClassBuilder.builder()
                .age(10)
                .name("cls")
                .build();

        //Assert
        assertThat(cls.getName()).isEqualTo("cls");
        assertThat(cls.getAge()).isEqualTo(10);
    }

    @Test
    void 생성자_위에_롬복_빌더_사용하기() {
        //Act
        ConstructorBuilder cls = ConstructorBuilder.builder()
                .name("cls")
                .build();

        //Assert
        assertThat(cls.getName()).isEqualTo("cls");
        assertThat(cls.getAge()).isEqualTo(0);
    }
}
