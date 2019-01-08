package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by lrtwjhs on 2018/6/11.
 */

public interface IFileService {

    String upload(MultipartFile file, String path);
}
