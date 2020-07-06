package com.xuegao.to_mysql.controller;

import com.alibaba.fastjson.JSONObject;
import com.xuegao.to_mysql.constant.comment.WrappedResponse;
import com.xuegao.to_mysql.domain.po.TUserInfo;
import com.xuegao.to_mysql.service.interfaces.IBetchMysqlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * <br/> @PackageName：com.xuegao.to_mysql.controller
 * <br/> @ClassName：BatchMysqlController
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/23 14:45
 */
@RestController
@CrossOrigin
public class BatchMysqlController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private IBetchMysqlService betchMysqlService;

    @RequestMapping(value = "/betch", method = RequestMethod.POST)
    public WrappedResponse<Integer> betchInsertUserInfoController() {

        Integer integer = betchMysqlService.betchInsertUserInfoService();

        return WrappedResponse.success(integer);
    }

    @RequestMapping(value = "/axios_get", method = RequestMethod.GET)
    public WrappedResponse<String> axiosGet() {

        return WrappedResponse.success("axios_get");
    }

    @RequestMapping(value = "/axios_get2", method = RequestMethod.GET)
    public WrappedResponse<String> axiosGet2(@RequestParam("id") Integer id) {

        log.error("id = " + id);

        return WrappedResponse.success("axios_get2");
    }

    @RequestMapping(value = "/axios_post", method = RequestMethod.POST)
    public WrappedResponse<String> axiosPost() {

        return WrappedResponse.success("axios_post");
    }

    @RequestMapping(value = "/axios_post2", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public WrappedResponse<String> axiosPost2(@RequestBody TUserInfo tUserInfo) {

        log.error(JSONObject.toJSONString(tUserInfo));

        return WrappedResponse.success("axios_post2");
    }

    @RequestMapping(value = "/axios_post3", method = RequestMethod.POST)
    public WrappedResponse<String> axiosPost3(@RequestParam("id") Integer id) {

        log.error("id = " + id);

        return WrappedResponse.success("axios_post3");
    }
}