import request from '@/utils/request'

export function save(title, content) {
  return request({
    url: '/test/testSaveMarkDown',
    method: 'post',
    data: {
      title,
      content
    }
  })
}
