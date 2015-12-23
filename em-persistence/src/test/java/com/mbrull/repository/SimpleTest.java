package com.mbrull.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.mbrull.configuration.EmPersistenceConfiguration;
import com.mbrull.configuration.PersistenceContext;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("/test.properties")
@ContextConfiguration(classes = { PersistenceContext.class, EmPersistenceConfiguration.class })
public class SimpleTest {

    @Test
    public void IsTrue() {
        Assert.isTrue(true);
    }

}