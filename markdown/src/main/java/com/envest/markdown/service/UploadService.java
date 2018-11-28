package com.envest.markdown.service;

import com.envest.markdown.business.response.BaseResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * Created by 41408 on 2018/11/21.
 */

public interface UploadService {
    Map uploadFile(MultipartFile file1, HttpServletRequest req) throws IOException;

}
