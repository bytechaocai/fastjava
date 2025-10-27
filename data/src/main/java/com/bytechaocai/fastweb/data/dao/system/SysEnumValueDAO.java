package com.bytechaocai.fastweb.data.dao.system;

import com.bytechaocai.fastweb.data.dao.BaseDAO;
import com.bytechaocai.fastweb.data.entity.system.SysEnumValueEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 枚举值表 数据操作对象。
 *
 * @author bytechaocai
 */
@Mapper
public interface SysEnumValueDAO extends BaseDAO<SysEnumValueEntity, String> {
}
