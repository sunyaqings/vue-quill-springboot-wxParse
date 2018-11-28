#######技术栈
前端：vue+element-ui+vuex+axios+webpack+vue-quill-editor
后端：springboot+jpa+mysql+swagger-ui
小程序:wsparse



#######实现功能
#前端
在vue-admin-template模板工程基础上，添加富文本编辑功能，两种方式实现图片上传自定义
一、加载模块vue-quill-editor，结合element-ui上传组件
二、使用扩展组件quill-image-extend-module，该方式可实现扩展其他模块，比如编辑和拖拽

#服务器
实现图片上传至固定目录，通过swagger-ui查看api

#小程序
仿womaifang的程序基础上smzdmWxApp-master添加tab ，实现html逆解析



###详情文档请查看博客（vue-quill-editor 使用+小程序解析html富文本插件wxParse）https://mp.csdn.net/mdeditor/84565945#
