package com.bytechaocai.fastweb.service.impl.system;

import com.bytechaocai.fastweb.data.dao.system.SysMenuRoleDAO;
import com.bytechaocai.fastweb.data.entity.system.SysMenuRoleEntity;
import com.bytechaocai.fastweb.data.repository.system.SysMenuRoleRepository;
import com.bytechaocai.fastweb.service.base.system.SysMenuRoleService;
import com.bytechaocai.fastweb.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色-菜单关联表 服务实现。
 *
 * @author bytechaocai
 */
@Service
public class SysMenuRoleServiceImpl
        extends BaseServiceImpl<SysMenuRoleEntity, String, SysMenuRoleDAO, SysMenuRoleRepository>
        implements SysMenuRoleService {
}
