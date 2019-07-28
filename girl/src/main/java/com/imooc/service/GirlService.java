package com.imooc.service;

import com.imooc.domain.Girl;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.GirlException;
import com.imooc.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("B");
        girlA.setAge(16);

        girlRepository.save(girlA);


        Girl girlB = new Girl();
        girlB.setCupSize("F");
        girlA.setAge(30);
        girlRepository.save(girlB);
    }

    /**
     * 通过统一异常处理
     * @param id
     * @throws Exception
     */
    public void getAge(Integer id) throws Exception{
        // spring boot 2.0之前可以这么写，spring boot2.0之后会报错
        // Girl girl = girlRepository.findOne(id);
        Girl girl = girlRepository.getOne(id);
        Integer age = girl.getAge();
        if(age < 10){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age >10 && age <16) {
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }

    }

    /**
     * 通过Id查询一个女生的信息
     * @param id
     * @return
     */
    public  Girl findOne(Integer id) {
        return girlRepository.findById(id).orElse(null);
    }
}
