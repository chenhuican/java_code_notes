package com.imooc.crontroller;

import com.imooc.domain.MetaDatabase;
import com.imooc.service.MetaDatabaseService;
import com.imooc.utils.ResultVO;
import com.imooc.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2019/07/14
 * Controller获取参数
 * @PathVariable  获取Url中的数据
 * @RequestParam 获取请求参数的值 获取 如：http://localhost/hi?id=12
 * @GetMapping 组合注解
 */
@RestController
@RequestMapping("/meta/database")
public class MetaDataBaseController {
    @Autowired
    public MetaDatabaseService metaDatabaseService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResultVO sava(@ModelAttribute MetaDatabase metaDatabase) {
        metaDatabaseService.save(metaDatabase);
        return ResultVOUtil.success();

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResultVO query(){
        return ResultVOUtil.success(metaDatabaseService.query());
    }


}
