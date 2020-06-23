package com.xuegao.to_mysql.controller;

import com.xuegao.to_mysql.constant.comment.Result;
import com.xuegao.to_mysql.service.interfaces.IBetchMysqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br/> @PackageName：com.xuegao.to_mysql.controller
 * <br/> @ClassName：BatchMysqlController
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/23 14:45
 */
@RestController
public class BatchMysqlController {

    @Autowired
    private IBetchMysqlService betchMysqlService;

    @RequestMapping(value = "/betch", method = RequestMethod.POST)
    public Result<Integer> betchInsertUserInfoController() {

        Integer integer = betchMysqlService.betchInsertUserInfoService();

        return Result.succsess(integer);
    }
}