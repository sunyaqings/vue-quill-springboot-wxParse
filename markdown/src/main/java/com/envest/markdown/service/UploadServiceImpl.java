package com.envest.markdown.service;

import com.envest.markdown.business.constant.Code;
import com.envest.markdown.business.response.BaseResult;
import com.envest.markdown.util.DataUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * Created by 41408 on 2018/11/21.
 */
@Service
public class UploadServiceImpl  implements UploadService{

    @Value("${server.port}")
    private String serverPort;

    @Value("${file-upload-path}")
    private String fileUploadPath;

    @Override
    public Map uploadFile(MultipartFile file1, HttpServletRequest req) throws IOException {
        Map<String, String> map = DataUtil.storeFile(file1, serverPort, fileUploadPath);

        return map;
    }
}
