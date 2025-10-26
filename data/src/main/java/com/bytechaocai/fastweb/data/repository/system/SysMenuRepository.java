
package com.bytechaocai.fastweb.data.dao.system;

import com.bytechaocai.fastweb.data.entity.system.SysMenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
* 菜单表 仓库。
*
* @author bytechaocai
*/
@Repository
public interface SysMenuRepository extends JpaRepository<SysMenuEntity, String>, JpaSpecificationExecutor<SysMenuEntity> {
}
