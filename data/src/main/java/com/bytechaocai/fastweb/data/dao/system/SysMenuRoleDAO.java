
package com.bytechaocai.fastweb.data.dao.system;

import com.bytechaocai.fastweb.data.dao.BaseDAO;
import com.bytechaocai.fastweb.data.entity.system.SysMenuRoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
* 角色-菜单关联表 数据操作对象。
*
* @author bytechaocai
*/
@Mapper
public interface SysMenuRoleDAO extends BaseDAO<SysMenuRoleEntity, String> {
}
