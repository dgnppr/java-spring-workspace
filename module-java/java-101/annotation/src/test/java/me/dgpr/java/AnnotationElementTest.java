package me.dgpr.java;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.annotation.Annotation;
import org.junit.jupiter.api.Test;

class AnnotationElementTest {

    @Test
    void 어노테이션_요소를_선언한다() {
        //Arrange
        AnnotationElement element = new AnnotationElement() {

            @Override
            public int count() {
                return 1;
            }

            @Override
            public String testBy() {
                return "dgpr";
            }

            @Override
            public String[] testTools() {
                return new String[]{"Junit5"};
            }

            @Override
            public EnumType enumType() {
                return EnumType.FIRST;
            }

            @Override
            public DateTime testDate() {
                return new DateTime() {
                    @Override
                    public String yymmdd() {
                        return "231120";
                    }

                    @Override
                    public String hhmmss() {
                        return "110000";
                    }

                    @Override
                    public Class<? extends Annotation> annotationType() {
                        return null;
                    }
                };
            }

            @Override
            public Class<? extends Annotation> annotationType() {
                return AnnotationElement.class;
            }
        };

        //Act //Assert
        assertThat(element.count()).isOne();
    }
}

@interface AnnotationElement {
    int count() default 1; // 기본값 1로 설정

    String testBy();

    String[] testTools() default {"aaa", "bbb", "ccc"};

    EnumType enumType();

    DateTime testDate();
}

enum EnumType {
    FIRST, SECOND
}

@interface DateTime {
    String yymmdd();

    String hhmmss();
}
