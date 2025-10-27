package com.bytechaocai.fastweb.data.repository.system;

import com.bytechaocai.fastweb.data.entity.system.SysMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 提示消息表 仓库。
 *
 * @author bytechaocai
 */
@Repository
public interface SysMessageRepository
        extends JpaRepository<SysMessageEntity, String>, JpaSpecificationExecutor<SysMessageEntity> {
}
