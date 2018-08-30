package com.ykj.java;

import com.ykj.java.modules.app.utils.JwtUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtTest {
    @Autowired
    private JwtUtils jwtUtils;

    @Test
    public void test() {
        String token = jwtUtils.generateToken(1);

        System.out.println(token);
    }

    @Test
    public void test1(){
        Random random = new Random(47);
        for (int i=0; i<3; i++)
            System.out.println(random.nextInt(20));
    }

}
