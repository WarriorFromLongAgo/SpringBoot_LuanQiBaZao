package com.xuegao.to_mysql.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xuegao.to_mysql.domain.po.TUserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <br/> @PackageName：com.xuegao.to_mysql.dao
 * <br/> @ClassName：IBetchMysqlMapper
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/23 14:47
 */
@Mapper
public interface IBetchMysqlMapper extends BaseMapper<TUserInfo> {
}