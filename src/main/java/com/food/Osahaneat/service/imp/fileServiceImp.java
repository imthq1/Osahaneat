package com.food.Osahaneat.service.imp;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface fileServiceImp {
    //luu file
    boolean saveFile(MultipartFile file);
    //tai file
    Resource loadFile(String filename);

}
