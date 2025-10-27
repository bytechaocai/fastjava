package com.bytechaocai.fastweb.data.dao.system;

import com.bytechaocai.fastweb.data.dao.BaseDAO;
import com.bytechaocai.fastweb.data.entity.system.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息表 数据操作对象。
 *
 * @author bytechaocai
 */
@Mapper
public interface SysUserDAO extends BaseDAO<SysUserEntity, String> {
}
