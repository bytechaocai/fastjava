
package com.bytechaocai.fastweb.data.dao.system;

import com.bytechaocai.fastweb.data.entity.system.SysUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
* 用户信息表 仓库。
*
* @author bytechaocai
*/
@Repository
public interface SysUserRepository extends JpaRepository<SysUserEntity, String>, JpaSpecificationExecutor<SysUserEntity> {
}
