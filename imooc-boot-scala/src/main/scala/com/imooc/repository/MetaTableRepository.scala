package com.imooc.repository

import com.imooc.domain.MetaTable
import org.springframework.data.repository.CrudRepository

/**
  * 数据库表操作接口
  */
trait MetaTableRepository extends CrudRepository[MetaTable, Integer]{


}
