package com.bp.baseProject.controller;


import com.bp.baseProject.annotation.UserTypeAnnotation;
import com.bp.baseProject.entity.FileEntity;
import com.bp.baseProject.entity.vo.AdminUserVO;
import com.bp.baseProject.entity.vo.ResultVO;
import com.bp.baseProject.service.FileUtilService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(description = "测试")
@Controller
@RequestMapping(value = "/test", produces = "application/json")
public class TestController {


    @Autowired
    private FileUtilService fileUtilService;

    @ApiOperation(value = "测试", notes = "测试")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public ResultVO<FileEntity> selectAdminPermissions(@RequestBody(required = false) FileEntity fileEntity) {
        ResultVO<FileEntity> resultVO = new ResultVO<FileEntity>();
        resultVO.getData().put("list", fileUtilService.findFileForDataId(fileEntity.getId()));
        return resultVO;
    }


    @UserTypeAnnotation(value = "admin")
    @ApiOperation(value = "测试列表", notes = "测试列表")
    @RequestMapping(value = "/testList", method = RequestMethod.GET)
    @ResponseBody
    public ResultVO<AdminUserVO> testList() {
        PageHelper.startPage(0, 10);
        ResultVO<AdminUserVO> resultVO = new ResultVO<AdminUserVO>();
        PageInfo<FileEntity> appsPageInfo = new PageInfo<>(fileUtilService.findFileForDataId("3123"));
        resultVO.getData().put("list", appsPageInfo);
        return resultVO;
    }


}
