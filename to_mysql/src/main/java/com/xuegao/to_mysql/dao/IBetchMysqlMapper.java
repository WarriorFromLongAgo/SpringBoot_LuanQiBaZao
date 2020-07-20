package com.xuegao.to_mysql.dao;

import org.apache.ibatis.annotations.Mapper;
import com.xuegao.to_mysql.domain.po.TUserInfo;

/**
 * <br/> @PackageName：com.xuegao.to_mysql.dao
 * <br/> @ClassName：IBetchMysqlMapper
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/23 14:47
 */
@Mapper
// @Repository
public interface IBetchMysqlMapper extends BaseMapper<TUserInfo> {
}