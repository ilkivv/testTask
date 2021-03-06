package com.test;

import com.test.controllers.HomeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SmokeTest {

    @Autowired
    private HomeController homeController;

    @Test
    public void contextLoads() throws Exception{
        assertThat(homeController).isNotNull();
    }
}
