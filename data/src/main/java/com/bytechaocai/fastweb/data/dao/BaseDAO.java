package com.bytechaocai.fastweb.data.dao;

/**
 * 基础数据访问对象。
 *
 * <p>增删改查在jpa中，不需要重复编写代码。</p>
 *
 * @param <E> 实体类型
 * @param <P> 主键类型
 *
 * @author bytechaocai
 */
public interface BaseDAO<E, P> {
    /**
     * 批量插入。
     *
     * @param entities 实体类
     *
     * @return 插入数量。
     */
    int batchInsert(Iterable<E> entities);
}
