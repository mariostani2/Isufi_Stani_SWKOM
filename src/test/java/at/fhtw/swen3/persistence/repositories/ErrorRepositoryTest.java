package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.ErrorEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource("/application-test.properties")
class ErrorRepositoryTest {
    private ErrorEntity errorEntity = new ErrorEntity();

    @Autowired
    private ErrorRepository errorRepository;
    @BeforeEach
    void setUp() {
        try{
            errorRepository.save(errorEntity);
        }catch (Exception e){}
    }

    @AfterEach
    void tearDown() {
        try{
            errorRepository.delete(errorEntity);
        }catch (Exception e){}
    }

    @Test
    void findById(){
        Optional<ErrorEntity> error=errorRepository.findById(errorEntity.getId());
        assertEquals(errorEntity.getId(),error.get().getId());
    }
}