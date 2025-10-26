
package com.bytechaocai.fastweb.service.base.system;

import com.bytechaocai.fastweb.data.dao.system.SysMenuRoleDAO;
import com.bytechaocai.fastweb.data.dao.system.SysMenuRoleRepository;
import com.bytechaocai.fastweb.data.entity.system.SysMenuRoleEntity;
import com.bytechaocai.fastweb.service.base.BaseService;

/**
* 角色-菜单关联表 服务实现。
*
* @author bytechaocai
*/
public interface SysMenuRoleService extends BaseService<SysMenuRoleEntity, String, SysMenuRoleDAO, SysMenuRoleRepository> {
}
