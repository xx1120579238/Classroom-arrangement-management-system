import request from '@/utils/request'

// 查询课程列表
export function listCourse(query) {
  return request({
    url: '/system/course/list',
    method: 'get',
    params: query
  })
}

// 查询课程详细
export function getCourse(crNo) {
  return request({
    url: '/system/course/' + crNo,
    method: 'get'
  })
}

// 新增课程
export function addCourse(data) {
  return request({
    url: '/system/course',
    method: 'post',
    data: data
  })
}

// 修改课程
export function updateCourse(data) {
  return request({
    url: '/system/course',
    method: 'put',
    data: data
  })
}

// 删除课程
export function delCourse(crNo) {
  return request({
    url: '/system/course/' + crNo,
    method: 'delete'
  })
}
