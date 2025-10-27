package com.bytechaocai.fastweb.data.repository.system;

import com.bytechaocai.fastweb.data.entity.system.SysMenuRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 角色-菜单关联表 仓库。
 *
 * @author bytechaocai
 */
@Repository
public interface SysMenuRoleRepository
        extends JpaRepository<SysMenuRoleEntity, String>, JpaSpecificationExecutor<SysMenuRoleEntity> {
}
