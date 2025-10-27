package com.bytechaocai.fastweb.data.dao.system;

import com.bytechaocai.fastweb.data.dao.BaseDAO;
import com.bytechaocai.fastweb.data.entity.system.SysUserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户-角色关联表 数据操作对象。
 *
 * @author bytechaocai
 */
@Mapper
public interface SysUserRoleDAO extends BaseDAO<SysUserRoleEntity, String> {
}
