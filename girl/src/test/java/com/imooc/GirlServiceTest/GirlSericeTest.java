package com.imooc.GirlServiceTest;

import com.imooc.domain.Girl;
import com.imooc.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlSericeTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest() {
        Girl girl = girlService.findOne(3);
        Assert.assertEquals(new Integer(22), girl.getAge());

    }
}
