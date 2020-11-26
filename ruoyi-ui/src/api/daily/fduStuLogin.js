import request from '@/utils/request'

// 校验学生是否存在
export function checkStudent(name, student_no) {
  return request({
    url: '/daily/student/checkStudent',
    method: 'post',
    data: { name, student_no }
  })
}

