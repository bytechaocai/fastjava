package com.bytechaocai.fastweb.data.repository.system;

import com.bytechaocai.fastweb.data.entity.system.SysEnumValueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 枚举值表 仓库。
 *
 * @author bytechaocai
 */
@Repository
public interface SysEnumValueRepository
        extends JpaRepository<SysEnumValueEntity, String>, JpaSpecificationExecutor<SysEnumValueEntity> {
}
