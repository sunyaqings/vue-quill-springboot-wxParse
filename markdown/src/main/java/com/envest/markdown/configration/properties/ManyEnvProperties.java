package com.envest.markdown.configration.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by 41408 on 2018/11/21.
 */


public class ManyEnvProperties {

    @Value("${file-upload-path}")
    private String fileUploadPath;

    public String getFileUploadPath() {
        return fileUploadPath;
    }

    public void setFileUploadPath(String fileUploadPath) {
        this.fileUploadPath = fileUploadPath;
    }
}
