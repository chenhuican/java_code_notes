package com.imooc.repository;

import com.imooc.domain.MetaDatabase;
import org.springframework.data.repository.CrudRepository;

/**
 * 继承curd操作接口
 */
public interface MetaDatabaseRepository extends CrudRepository<MetaDatabase,Integer>{


}
