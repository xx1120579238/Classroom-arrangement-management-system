import request from '@/utils/request'

// 查询安排列表
export function listArrange(query) {
  return request({
    url: '/system/arrange/list',
    method: 'get',
    params: query
  })
}

// 查询安排详细
export function getArrange(aId) {
  return request({
    url: '/system/arrange/' + aId,
    method: 'get'
  })
}

// 新增安排
export function addArrange(data) {
  return request({
    url: '/system/arrange',
    method: 'post',
    data: data
  })
}

// 修改安排
export function updateArrange(data) {
  return request({
    url: '/system/arrange',
    method: 'put',
    data: data
  })
}

// 删除安排
export function delArrange(aId) {
  return request({
    url: '/system/arrange/' + aId,
    method: 'delete'
  })
}
