package com.bp.baseProject.service.impl;

import com.bp.baseProject.entity.FileEntity;
import com.bp.baseProject.mapper.FileUtilMapper;
import com.bp.baseProject.service.FileUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileUtilServiceImpl implements FileUtilService {
    @Autowired
    FileUtilMapper fileUtilMapper;

    @Override
    public List<FileEntity> findFileForDataId(String id) {
        return fileUtilMapper.findFileForDataId(id);
    }
}
