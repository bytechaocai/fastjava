package com.bytechaocai.fastweb.data.dao.system;

import com.bytechaocai.fastweb.data.dao.BaseDAO;
import com.bytechaocai.fastweb.data.entity.system.SysConfigEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 配置表 数据操作对象。
 *
 * @author bytechaocai
 */
@Mapper
public interface SysConfigDAO extends BaseDAO<SysConfigEntity, String> {
}
