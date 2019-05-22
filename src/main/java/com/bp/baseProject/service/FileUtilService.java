package com.bp.baseProject.service;


import com.bp.baseProject.entity.FileEntity;

import java.util.List;

public interface FileUtilService {
    List<FileEntity> findFileForDataId(String id);
}
