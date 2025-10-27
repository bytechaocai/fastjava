package com.bytechaocai.fastweb.data.repository.system;

import com.bytechaocai.fastweb.data.entity.system.SysConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 配置表 仓库。
 *
 * @author bytechaocai
 */
@Repository
public interface SysConfigRepository
        extends JpaRepository<SysConfigEntity, String>, JpaSpecificationExecutor<SysConfigEntity> {
}
