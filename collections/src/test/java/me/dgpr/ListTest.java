package me.dgpr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ListTest {

    @Test
    @DisplayName("Arrays.asList()")
    void test1() throws Exception {
        /**
         * Arrays.asList() 로 생성된 리스트는 원 리스트에 변경이 생기면 변경에 영향을 받는다. 반대도 동일하다.
         * Arrays.asList() 로 생성된 리스트의 각 원소의 값을 변경할 수는 있지만, 리스트는 고정된 크기이다.
         * 따라서 새로운 원소를 추가하거나 원소를 리스트에서 제거할 수 없다. 추가/삭제 실행 시 UnsupportedOperationException 발생
         */
        List<Employee> asList = Arrays.asList(new Employee(1),
                new Employee(2),
                new Employee(3)); // supported

        asList.get(0).setId(20);
        System.out.println(asList);

        asList.add(new Employee(4)); // .UnsupportedOperationException
    }

    @Test
    @DisplayName("List.of()")
    void test2() throws Exception {
        /**
         * 고정된 크기의 Immutable 리스트를 생성한다.
         * 새로운 원소를 추가허나 원소에서 리스트를 제거할 수 없다. 추가/삭제 실행 시 UnsupportedOperationException 발생
         */
        List<Employee> listOf = List.of(new Employee(1),
                new Employee(2),
                new Employee(3)); // supported

        listOf.get(0).setId(20);
        System.out.println(listOf);

        listOf.add(new Employee(4)); // UnsupportedOperationException
    }

    @Test
    @DisplayName("List.of()와 Arrays.asList()의 차이는 set() 지원 여부이다.")
    void test3() throws Exception {
        /**
         * 두 개 모두 한 번 리스트가 생성되면 고정된 크기를 가지게 하여 리스트가 grow/shrink 하지 못하게 한다.
         * 또한 또한 기존에 존재하는 원소의 값을 수정할 수 있다.
         * 주요 차이점은 Arrays.asList()는 set() 지원하지만 List.of()는 지원하지 않는다
         */

        List<Employee> asList = Arrays.asList(new Employee(1),
                new Employee(2),
                new Employee(3));

        asList.set(0, new Employee(4));
        System.out.println(asList);

        List<Employee> listOf = List.of(new Employee(1),
                new Employee(2),
                new Employee(3));

        listOf.set(0, new Employee(4)); // UnsupportedOperationException
        System.out.println(listOf);
    }

    @Test
    @DisplayName("Collections.unmodifiableList()")
    void test4() throws Exception {
        List<Employee> mutable = new ArrayList<>();
        mutable.add(new Employee(1));
        mutable.add(new Employee(2));

        List<Employee> immutable = Collections.unmodifiableList(mutable);

        mutable.add(new Employee(3));
        mutable.get(0).setId(10);

        System.out.println(mutable);
        System.out.println(immutable);

        immutable.get(0).setId(20);

        System.out.println(mutable);
        System.out.println(immutable);

        immutable.add(new Employee(4)); // UnsupportedOperationException
    }

    static class Employee {

        private int id;

        public Employee(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    '}';
        }
    }
}
