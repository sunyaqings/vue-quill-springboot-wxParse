<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="16"><h4 style="margin: 10px">文章标题</h4></el-col>
      <el-col :span="8">
      </el-col>
    </el-row>
    <el-input placeholder="请输入标题内容" style="width: 50%" v-model="title"></el-input>
    <el-button type="primary" @click="submit()">发布</el-button>
    <!-- 图片上传组件辅助-->
    <el-upload
      class="avatar-uploader"
      :action="serverUrl"
      name="file1"
      :headers="header"
      :show-file-list="false"
      :on-success="uploadSuccess"
      :on-error="uploadError"
      :before-upload="beforeUpload">
    </el-upload>
    <!--富文本编辑器组件-->
    <el-row v-loading="quillUpdateImg">
      <quill-editor
        v-model="detailContent"
        ref="myQuillEditor"
        :options="editorOption"
        @change="onEditorChange($event)"
        @ready="onEditorReady($event)"
      >
      </quill-editor>
    </el-row>
  </div>
</template>
<script>
  import * as Quill from 'quill'  //引入编辑器
  //quill图片可拖拽上传
  import {ImageDrop} from 'quill-image-drop-module';
  //quill图片可拖拽改变大小
  import ImageResize from 'quill-image-resize-module'

  Quill.register('modules/imageDrop', ImageDrop);
  Quill.register('modules/imageResize', ImageResize)
  import {save} from '@/api/markDown'

  // 工具栏配置
  const toolbarOptions = [
    ['bold', 'italic', 'underline', 'strike'],        // toggled buttons
    ['blockquote', 'code-block'],

    [{'header': 1}, {'header': 2}],               // custom button values
    [{'list': 'ordered'}, {'list': 'bullet'}],
    [{'script': 'sub'}, {'script': 'super'}],      // superscript/subscript
    [{'indent': '-1'}, {'indent': '+1'}],          // outdent/indent
    [{'direction': 'rtl'}],                         // text direction

    [{'size': ['small', false, 'large', 'huge']}],  // custom dropdown
    [{'header': [1, 2, 3, 4, 5, 6, false]}],

    [{'color': []}, {'background': []}],          // dropdown with defaults from theme
    [{'font': []}],
    [{'align': []}],
    ['link', 'image', 'video'],
    ['clean']                                         // remove formatting button
  ]

  export default {
    data() {
      return {
        title: '', // 文章标题
        serverUrl: 'http://localhost:8181/test/testUpload',  // 这里写你要上传的图片服务器地址
        header: {token: sessionStorage.token},  // 有的图片服务器要求请求头需要有token之类的参数，写在这里
        detailContent: '', // 富文本内容
        editorOption: {
          placeholder: '',
          theme: 'snow',  // or 'bubble'
          modules: {
            toolbar: {
              container: toolbarOptions,  // 工具栏
              handlers: {
                'image': function (value) {
                  if (value) {
                    // 触发input框选择图片文件
                    document.querySelector('.avatar-uploader input').click()
                  } else {
                    this.quill.format('image', false);
                  }
                }
              }
            }
          }
        },
        imageDrop: true,
        imageResize: {},
        quillUpdateImg: false
      }
    },
    methods: {
      beforeUpload() {
        // 显示loading动画
        this.quillUpdateImg = true
      },

      uploadSuccess(res, file) {
        // res为图片服务器返回的数据
        // 获取富文本组件实例
        let quill = this.$refs.myQuillEditor.quill
        // 如果上传成功
        if (res.url !== null) {
          // 获取光标所在位置
          let length = quill.getSelection().index;
          // 插入图片  res.info为服务器返回的图片地址
          quill.insertEmbed(length, 'image', res.url)
          // 调整光标到最后
          quill.setSelection(length + 1)
        } else {
          this.$message.error('图片插入失败')
        }
        // loading动画消失
        this.quillUpdateImg = false
      },

      // 富文本图片上传失败
      uploadError() {
        // loading动画消失
        this.quillUpdateImg = false
        this.$message.error('图片插入失败')
      },
      onEditorReady (editor) {
      },
      onEditorChange (editor) {
      },
      submit(){
        var parm =
          {
            title: this.title,
            content: this.detailContent
          }
        this.axios.post('http://localhost:8181/test/testSaveMarkDown',
          parm, {
            headers: {
              'Content-Type': 'application/json'
            }
          })
          .then(function (res) {
            alert("提交成功")
            this.title = '';
            this.detailContent = '';
          }.bind(this))
          .catch(function (err) {
            if (err.response) {
              console.log(err.response)
            }
          }.bind(this))

      }
    }
  }
</script>
