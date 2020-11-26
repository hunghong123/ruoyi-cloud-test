import request from '@/utils/request'

// 查询每日上报列表
export function listDailyupdate(query) {
    return request({
        url: '/daily/dailyupdate/list',
        method: 'get',
        params: query
    })
}

// 查询每日上报详细
export function getDailyupdate(id) {
    return request({
        url: '/daily/dailyupdate/' + id,
        method: 'get'
    })
}

// 新增每日上报
export function addDailyupdate(data) {
    return request({
        url: '/daily/dailyupdate',
        method: 'post',
        data: data
    })
}

// 修改每日上报
export function updateDailyupdate(data) {
    return request({
        url: '/daily/dailyupdate',
        method: 'put',
        data: data
    })
}

// 删除每日上报
export function delDailyupdate(id) {
    return request({
        url: '/daily/dailyupdate/' + id,
        method: 'delete'
    })
}
