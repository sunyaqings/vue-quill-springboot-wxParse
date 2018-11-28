package com.envest.markdown.util;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class DataUtil {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyyMM");

    private static final Logger logger = Logger.getLogger(DataUtil.class);


    public static Map<String, String> storeFile(MultipartFile file, String serverPort, String fileUploadPath) throws IOException {

        String yearMonth = SDF.format(new Date());//当前年月
        String random = "" + (int) (Math.random()*1000);//随机4位数,没补0
        String fileName = file.getOriginalFilename();//文件全名
        String suffix = suffix(fileName);//文件后缀
        String localIP = InetAddress.getLocalHost().getHostAddress();//当前IP

        String relPath = "upload/"  + "/" + yearMonth + "/"  + "-" + random + suffix;

        String backPath = "http://" + localIP + ":" + serverPort +"/"+ relPath;
        String toPath = fileUploadPath + relPath;
        FileOutputStream out = null;

        File toFile = new File(toPath).getParentFile();
        if (!toFile.exists()) {
            toFile.mkdirs(); //自动创建目录
        }
        try {
            out = new FileOutputStream(toPath);
            out.write(file.getBytes());
            out.flush();

            Map<String, String> map = new HashMap();
            map.put("url", backPath);
            map.put("oldname", fileName);
            map.put("path", toPath);
            logger.info(backPath);
            return map;
        } catch (FileNotFoundException fnfe) {
            throw fnfe;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 后缀名或empty："a.png" => ".png"
     */
    private static String suffix(String fileName) {
        int i = fileName.lastIndexOf('.');
        return i == -1 ? "" : fileName.substring(i);
    }
}
