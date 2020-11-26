package com.fdu.daily.service.impl;

import java.util.List;
                                                                                                                                                                                            import com.ruoyi.common.core.utils.DateUtils;
            import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fdu.daily.mapper.FduDailyUpdateMapper;
import com.fdu.daily.domain.FduDailyUpdate;
import com.fdu.daily.service.IFduDailyUpdateService;

/**
 * 每日上报Service业务层处理
 *
 * @author hf
 * @date 2020-11-19
 */
@Service
public class FduDailyUpdateServiceImpl implements IFduDailyUpdateService {
    @Autowired
    private FduDailyUpdateMapper fduDailyUpdateMapper;

    /**
     * 查询每日上报
     *
     * @param id 每日上报ID
     * @return 每日上报
     */
    @Override
    public FduDailyUpdate selectFduDailyUpdateById(Long id) {
        return fduDailyUpdateMapper.selectFduDailyUpdateById(id);
    }

    /**
     * 查询每日上报列表
     *
     * @param fduDailyUpdate 每日上报
     * @return 每日上报
     */
    @Override
    public List<FduDailyUpdate> selectFduDailyUpdateList(FduDailyUpdate fduDailyUpdate) {
        return fduDailyUpdateMapper.selectFduDailyUpdateList(fduDailyUpdate);
    }

    /**
     * 新增每日上报
     *
     * @param fduDailyUpdate 每日上报
     * @return 结果
     */
    @Override
    public int insertFduDailyUpdate(FduDailyUpdate fduDailyUpdate) {
                                                                                                                                                                                                                                                                                                                            fduDailyUpdate.setCreateTime(DateUtils.getNowDate());
                                                                    return fduDailyUpdateMapper.insertFduDailyUpdate(fduDailyUpdate);
    }

    /**
     * 修改每日上报
     *
     * @param fduDailyUpdate 每日上报
     * @return 结果
     */
    @Override
    public int updateFduDailyUpdate(FduDailyUpdate fduDailyUpdate) {
                                                                                                                                                                                                                                                                                                                                                                    fduDailyUpdate.setUpdateTime(DateUtils.getNowDate());
                            return fduDailyUpdateMapper.updateFduDailyUpdate(fduDailyUpdate);
    }

    /**
     * 批量删除每日上报
     *
     * @param ids 需要删除的每日上报ID
     * @return 结果
     */
    @Override
    public int deleteFduDailyUpdateByIds(Long[] ids) {
        return fduDailyUpdateMapper.deleteFduDailyUpdateByIds(ids);
    }

    /**
     * 删除每日上报信息
     *
     * @param id 每日上报ID
     * @return 结果
     */
    @Override
    public int deleteFduDailyUpdateById(Long id) {
        return fduDailyUpdateMapper.deleteFduDailyUpdateById(id);
    }

    @Override
    public List<FduDailyUpdate> selectFduDailyUpdateListByDateAndNo(FduDailyUpdate fduDailyUpdate) {
        return fduDailyUpdateMapper.selectFduDailyUpdateListByDateAndNo(fduDailyUpdate);
    }
}
