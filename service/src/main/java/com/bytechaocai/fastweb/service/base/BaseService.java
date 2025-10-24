package com.bytechaocai.fastweb.service.base;

import com.bytechaocai.fastweb.data.dao.BaseDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 基础服务接口，封装基础增删改查。
 *
 * <p>dao和jpa中的接口可以通过对应的get方法调用，对于公用的dao接口，可以不通过get方法调用。</p>
 *
 * @param <E> 实体类
 * @param <P> 主键类型
 * @param <D> DAO接口
 * @param <R> 仓库接口
 *
 * @author bytechaocai
 */
public interface BaseService<E, P, D extends BaseDAO<E, P>,
        R extends JpaRepository<E, P> & JpaSpecificationExecutor<E>> {
    /**
     * 返回书架访问对象。
     *
     * @return dao。
     */
    D getDAO();

    /**
     * 返回数据仓库。
     *
     * @return 数据仓库。
     */
    R getRepository();
}
