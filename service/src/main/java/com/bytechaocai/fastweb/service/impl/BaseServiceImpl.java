package com.bytechaocai.fastweb.service.impl;

import com.bytechaocai.fastweb.data.dao.BaseDAO;
import com.bytechaocai.fastweb.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 基础服务接口的实现。
 *
 * @param <E> 实体类
 * @param <P> 主键类型
 * @param <D> DAO接口
 * @param <R> 仓库接口
 *
 * @author bytechaocai
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class BaseServiceImpl<E, P, D extends BaseDAO<E, P>, R extends JpaRepository<E, P> & JpaSpecificationExecutor<E>>
        implements BaseService<E, P, D, R> {
    /**
     * 数据访问对象。
     */
    @Autowired
    private D d;
    /**
     * 数据仓库。
     */
    @Autowired
    private R r;

    @Override
    public D getDAO() {
        return d;
    }

    @Override
    public R getRepository() {
        return r;
    }
}
