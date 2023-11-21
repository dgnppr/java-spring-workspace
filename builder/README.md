# 빌더 패턴

- 객체 생성 디자인 패턴
- 복잡한 객체를 단계적으로 구성하여 객체를 반환한다
- 많은 수의 매개변수를 갖는 객체를 생성할 때 유용하다
    - 생성자 파라미터가 많을 경우 가독성이 떨어지고,
    - 빌더를 사용하면 순서를 마음대로 할 수 있다.

### 장점

- 분리된 생성 과정: 객체의 생성과 표현을 분리하여, 동일한 생성 과정에서 다양한 표현 결과를 낼 수 있다.
- 유연성: 많은 매개변수를 필요로 할 때, 필요한 매개변수만을 설정하여 객체를 생성할 수 있기 때문에 생성자보다 좀 더 유연하다

### 단점

- 복잡도 증가: 단순한 경우 생성자나 팩토리 메서드가 더 적할할 수 있음
- 코드 양 증가
- 성능 오버헤드: 각각의 설정 단계에서 메서드 호출이 발생하고, 최정적으로 생성된 객체를 반환하기 전에 빌더 인스턴스를 생성하고 초기화해야 한다

<br>

# Lombok @Builder

![CleanShot 2023-11-21 at 13 01 27](https://github.com/dragonappear/java-101/assets/89398909/6ce27712-043e-44fd-83cd-b5e7a63b5f96)

`@Builder`를 넣으면 클래스 변수로 `*Builder` 네이밍으로 된 클래스를 생성해서 바이트 코드에 넣어준다.

### 클래스 위에 @Builder 붙이기

- 클래스 전체에 적용될 때, Lombok은 클래스의 모든 필드를 포함하는 빌더 클래스를 자동으로 생성
- 이는 클래스의 모든 필드를 빌더를 통해 설정할 수 있도록 해줌
- 기본적으로 클래스의 모든 필드가 빌더의 일부가 되며, 클래스의 모든 필드가 private이고 세터 메소드가 없는 경우에 적합

### 생성자 위에 @Builder 붙이기

- 특정 생성자에 @Builder를 적용할 때, Lombok은 해당 생성자의 매개변수만을 포함하는 빌더를 생성
- 이 방식을 사용하면 빌더를 통해 설정할 수 있는 필드를 더 세밀하게 제어할 수 있음
- 클래스 중 일부 필드만 초기화하거나, 여러 개의 생성자가 있고 각각 다른 방식으로 객체를 초기화할 필요가 있는 경우에 유용

<br>

# 기본 생성자 private + Builder + 팩토리 메서드 사용하기

- 기본 생성자를 `private`으로 설정하여 오직 정의된 방식(빌더 or 팩토리 메서드)으로만 생성하게 한다.
- 팩토리 메서드에서 빌더를 사용하여 객체 생성 과정을 명확하게 한다
- 팩토리 메서드를 사용하여 생성하려는 객체 의도를 명확하게 할 수 있다.
- 코드 증가, 성능 오버헤드, 불필요한 레이어가 생기는 단점이 있다.

```java
public class Person {
    private String name;
    private int age;

    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    public static Person createAdult(String name) {
        return Person.builder()
                .name(name)
                .age(18) // 가정: 성인의 최소 나이
                .build();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private int age;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
```

### Ref

- https://projectlombok.org/features/Builder
- https://pamyferret.tistory.com/67