package com.bytechaocai.fastweb.service.impl.system;

import com.bytechaocai.fastweb.data.dao.system.SysConfigDAO;
import com.bytechaocai.fastweb.data.entity.system.SysConfigEntity;
import com.bytechaocai.fastweb.data.repository.system.SysConfigRepository;
import com.bytechaocai.fastweb.service.base.system.SysConfigService;
import com.bytechaocai.fastweb.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 配置表 服务实现。
 *
 * @author bytechaocai
 */
@Service
public class SysConfigServiceImpl extends BaseServiceImpl<SysConfigEntity, String, SysConfigDAO, SysConfigRepository>
        implements SysConfigService {
}
