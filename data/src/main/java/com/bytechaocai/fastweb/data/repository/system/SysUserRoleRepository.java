
package com.bytechaocai.fastweb.data.dao.system;

import com.bytechaocai.fastweb.data.entity.system.SysUserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
* 用户-角色关联表 仓库。
*
* @author bytechaocai
*/
@Repository
public interface SysUserRoleRepository extends JpaRepository<SysUserRoleEntity, String>, JpaSpecificationExecutor<SysUserRoleEntity> {
}
