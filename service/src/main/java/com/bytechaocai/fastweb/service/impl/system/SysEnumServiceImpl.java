package com.bytechaocai.fastweb.service.impl.system;

import com.bytechaocai.fastweb.data.dao.system.SysEnumDAO;
import com.bytechaocai.fastweb.data.entity.system.SysEnumEntity;
import com.bytechaocai.fastweb.data.repository.system.SysEnumRepository;
import com.bytechaocai.fastweb.service.base.system.SysEnumService;
import com.bytechaocai.fastweb.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 枚举类型表 服务实现。
 *
 * @author bytechaocai
 */
@Service
public class SysEnumServiceImpl extends BaseServiceImpl<SysEnumEntity, String, SysEnumDAO, SysEnumRepository>
        implements SysEnumService {
}
