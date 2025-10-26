
package com.bytechaocai.fastweb.data.dao.system;

import com.bytechaocai.fastweb.data.entity.system.SysEnumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
* 枚举类型表 仓库。
*
* @author bytechaocai
*/
@Repository
public interface SysEnumRepository extends JpaRepository<SysEnumEntity, String>, JpaSpecificationExecutor<SysEnumEntity> {
}
