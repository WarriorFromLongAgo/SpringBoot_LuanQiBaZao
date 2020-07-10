package com.xuegao.luanqibazao_1.serialization;

import com.xuegao.luanqibazao_1.domain.UserInfo;
import com.xuegao.luanqibazao_1.domain.UserVo;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.serialization
 * <br/> @ClassName：UserTransfer
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/7/10 14:27
 */
@Mapper
public interface UserTransfer {

    // entity转vo
    List<UserVo> entityToVo(List<UserInfo> user);
}