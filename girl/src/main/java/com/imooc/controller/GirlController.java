package com.imooc.controller;

import com.imooc.domain.Girl;
import com.imooc.domain.Result;
import com.imooc.repository.GirlRepository;
import com.imooc.service.GirlService;
import com.imooc.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    // 定义日志
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @RequestMapping(value = "/girls", method = RequestMethod.GET)
    public List<Girl> girlsList(){
        return girlRepository.findAll();
    }

    /**
     * 添加女生
     *
     */
    @RequestMapping(value = "/girls", method = RequestMethod.POST)
    public Object girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        //使用@Valid注解验证，提交的信息，当发生错误时,返回结果给 BindingResult。
        if(bindingResult.hasErrors()) {
//            Result result = new Result();
//            result.setCode(1);
//            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
//            return result;
            //将注释的代码改为如下，通过封装的ResultUtil返回信息
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

//        Result result = new Result();
//        result.setCode(0);
//        result.setMsg("成功");
//        result.setData(girlRepository.save(girl));
//        return result;
        // 通过封装的ResultUtil统一返回
        return ResultUtil.success(girlRepository.save(girl));
    }

    //按id查询
    @RequestMapping(value = "/girls/{id}", method = RequestMethod.GET)
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findById(id).orElse(null);

    }

    //更新
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }

    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
    }

    //按年龄查询,得到列表
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "girls/two")
    public void girlTwo() {
        girlService.insertTwo();

    }

    /**
     * 统一异常处理示例
     * @param id
     * @throws Exception
     */
    @GetMapping(value = "girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);

    }

}
