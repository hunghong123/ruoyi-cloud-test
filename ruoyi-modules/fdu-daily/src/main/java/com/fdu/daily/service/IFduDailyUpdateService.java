package com.fdu.daily.service;

import java.util.List;

import com.fdu.daily.domain.FduDailyUpdate;

/**
 * 每日上报Service接口
 *
 * @author hf
 * @date 2020-11-19
 */
public interface IFduDailyUpdateService {
    /**
     * 查询每日上报
     *
     * @param id 每日上报ID
     * @return 每日上报
     */
    public FduDailyUpdate selectFduDailyUpdateById(Long id);

    /**
     * 查询每日上报列表
     *
     * @param fduDailyUpdate 每日上报
     * @return 每日上报集合
     */
    public List<FduDailyUpdate> selectFduDailyUpdateList(FduDailyUpdate fduDailyUpdate);

    /**
     * 新增每日上报
     *
     * @param fduDailyUpdate 每日上报
     * @return 结果
     */
    public int insertFduDailyUpdate(FduDailyUpdate fduDailyUpdate);

    /**
     * 修改每日上报
     *
     * @param fduDailyUpdate 每日上报
     * @return 结果
     */
    public int updateFduDailyUpdate(FduDailyUpdate fduDailyUpdate);

    /**
     * 批量删除每日上报
     *
     * @param ids 需要删除的每日上报ID
     * @return 结果
     */
    public int deleteFduDailyUpdateByIds(Long[] ids);

    /**
     * 删除每日上报信息
     *
     * @param id 每日上报ID
     * @return 结果
     */
    public int deleteFduDailyUpdateById(Long id);

    List<FduDailyUpdate> selectFduDailyUpdateListByDateAndNo(FduDailyUpdate fduDailyUpdate);
}
