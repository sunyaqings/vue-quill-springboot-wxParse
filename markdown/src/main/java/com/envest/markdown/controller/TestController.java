package com.envest.markdown.controller;

import com.envest.markdown.business.constant.Code;
import com.envest.markdown.business.response.BaseResult;
import com.envest.markdown.dal.entity.MarkDownEntity;
import com.envest.markdown.service.MarkDownService;
import com.envest.markdown.service.UploadService;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 41408 on 2018/11/21.
 */
@RestController
@RequestMapping("/test")
public class TestController {
    private static final Logger logger = Logger.getLogger(TestController.class);

    @Value("${file-upload-path}")
    private String fileUploadPath;

    @Autowired
    UploadService uploadService;
    @Autowired
    MarkDownService markDownService;

    @ApiOperation(value = "测试查询结果", notes = "测试查询")
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String testquery(@RequestParam String para) {
        return "你输入的信息为  " + para;

    }

    @ApiOperation(value = "文件上传", notes = "文件上传")
    @RequestMapping(value = "/testUpload", method = RequestMethod.POST)
    public Map testUpload(MultipartFile file1, HttpServletRequest request) throws IOException {
        Map<String, String> map = new HashMap();
        if (StringUtils.isEmpty(file1)) {
            map.put("message", "文件为空请重新上传");
            return map;
        }
        map = uploadService.uploadFile(file1, request);
        return map;
    }

    @ApiOperation(value = "存储富文本", notes = "存储富文本")
    @RequestMapping(value = "/testSaveMarkDown", method = RequestMethod.POST)
    public BaseResult testSaveMarkDown(@RequestBody MarkDownEntity markDownEntity) {

        BaseResult baseResult = markDownService.save(markDownEntity);
        return baseResult;
    }

    @ApiOperation(value = "查询所有列表信息", notes = "文章列表")
    @RequestMapping(value = "/testQueryMarkDownList", method = RequestMethod.GET)
    public BaseResult testQueryMarkDownList() {
        BaseResult result = markDownService.queryList();
        return result;
    }

    @ApiOperation(value = "查询富文本详情", notes = "根据id查询")
    @RequestMapping(value = "/testQueryMarkDownById", method = RequestMethod.GET)
    public BaseResult testQueryMarkDownById(@RequestParam String id) {
        BaseResult result = markDownService.queryById(id);
        return result;
    }

}
