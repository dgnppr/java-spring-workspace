package me.dgpr;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ContainerServiceTest {

    @Test
    void test1() throws Exception {
        //Arrange
        MyRepository repository = ContainerService.getObject(MyRepository.class);

        //Act //Assert
        Assertions.assertThat(repository).isNotNull();
    }

    @Test
    void test2() throws Exception {
        //Arrange
        MyService service = ContainerService.getObject(MyService.class);

        //Act //Assert
        Assertions.assertThat(service).isNotNull();
        Assertions.assertThat(service.myRepository).isNotNull();
    }
}