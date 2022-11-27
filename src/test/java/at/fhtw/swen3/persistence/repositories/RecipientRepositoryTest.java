package at.fhtw.swen3.persistence.repositories;

import at.fhtw.swen3.persistence.entities.RecipientEntity;
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
class RecipientRepositoryTest {

    private RecipientEntity recipient;
    @Autowired
    private RecipientRepository recipientRepository;
    @BeforeEach
    void setUp() {
        try{
            recipientRepository.save(recipient);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @AfterEach
    void tearDown() {
        try{
            recipientRepository.delete(recipient);
        }catch (Exception e){}
    }

    @Test
    void findById(){
        try {
            Optional<RecipientEntity> recipientOptional = recipientRepository.findById(recipient.getId());
            assertEquals(recipient.getId(), recipientOptional.get().getId());
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}