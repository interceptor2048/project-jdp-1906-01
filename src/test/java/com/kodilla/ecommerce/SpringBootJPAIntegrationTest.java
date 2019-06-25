package com.kodilla.ecommerce;

import com.kodilla.ecommerce.domain.GenericEntity;
import com.kodilla.ecommerce.repository.GenericEntityRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class SpringBootJPAIntegrationTest {

    @Autowired
    private GenericEntityRepository genericEntityRepository;

    @Ignore
    @Test
    public void givenGenericEntityRepository_whenSaveAndRetrieveEntity_thenOK() {
        GenericEntity genericEntity = genericEntityRepository
                .save(new GenericEntity("test"));
        Optional<GenericEntity> foundEntity = genericEntityRepository
                .findById(genericEntity.getId());

        assertTrue(foundEntity.isPresent());
        assertEquals(genericEntity.getValue(), foundEntity.get().getValue());
    }
}
