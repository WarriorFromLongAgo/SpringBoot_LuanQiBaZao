package com.xuegao.luanqibazao_1.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ObjectDiff {

    private String name;

    private Integer id;

    private UserInfo userInfo;

    private List<UserInfo> userInfoList;

}
