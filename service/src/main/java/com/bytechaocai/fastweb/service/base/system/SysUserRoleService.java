package com.bytechaocai.fastweb.service.base.system;

import com.bytechaocai.fastweb.data.dao.system.SysUserRoleDAO;
import com.bytechaocai.fastweb.data.entity.system.SysUserRoleEntity;
import com.bytechaocai.fastweb.data.repository.system.SysUserRoleRepository;
import com.bytechaocai.fastweb.service.base.BaseService;

/**
 * 用户-角色关联表 服务实现。
 *
 * @author bytechaocai
 */
public interface SysUserRoleService
        extends BaseService<SysUserRoleEntity, String, SysUserRoleDAO, SysUserRoleRepository> {
}
