import request from '@/utils/request'

// 取得学生信息
export function getStuInfo(student_no) {
  return request({
    url: '/daily/student/getStuInfo',
    method: 'get',
    params: {student_no}
  })
}

// 更新上报信息
export function saveDailyUpdate(data) {
  return request({
    url: '/daily/student/saveDailyUpdate',
    method: 'post',
    data: data
  })
}

