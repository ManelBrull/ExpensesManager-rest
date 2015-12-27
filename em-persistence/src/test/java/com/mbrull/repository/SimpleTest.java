package com.mbrull.repository;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.mbrull.commons.test.UnitTest;
import com.mbrull.persistence.EmPersistenceMain;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("/test.properties")
@SpringApplicationConfiguration(classes = EmPersistenceMain.class)
@Category(UnitTest.class)
public class SimpleTest {

    @Test
    public void IsTrue() {
        Assert.isTrue(true);
    }

}