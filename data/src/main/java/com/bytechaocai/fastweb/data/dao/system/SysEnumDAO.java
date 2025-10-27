package com.bytechaocai.fastweb.data.dao.system;

import com.bytechaocai.fastweb.data.dao.BaseDAO;
import com.bytechaocai.fastweb.data.entity.system.SysEnumEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 枚举类型表 数据操作对象。
 *
 * @author bytechaocai
 */
@Mapper
public interface SysEnumDAO extends BaseDAO<SysEnumEntity, String> {
}
