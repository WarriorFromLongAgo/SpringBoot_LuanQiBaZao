package com.xuegao.mysql.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Stopwatch;
import com.xuegao.mysql.dao.IBetchMysqlMapper;
import com.xuegao.mysql.domain.po.TUserInfo;
import com.xuegao.mysql.service.interfaces.IBetchMysqlService;
import com.xuegao.mysql.utils.IdUtil;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * <br/> @PackageName：com.xuegao.to_mysql.service.impl
 * <br/> @ClassName：BetchMysqlServiceImpl
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/23 14:51
 */
@Service
public class BetchMysqlServiceImpl extends ServiceImpl<IBetchMysqlMapper, TUserInfo> implements IBetchMysqlService {

    @Autowired
    private IBetchMysqlMapper betchMysqlMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer betchInsertUserInfoService() {
        String userName = "userName";
        String accountName = "accountName";
        String passWord = "passWord";
        Long idCard = 410291202006232020L;

        Stopwatch stopwatch = Stopwatch.createStarted();
        // 你配置的是true就自动，false的就不自动
        try (SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false)) {
            for (int i = 0; i < 10000000; i++) {
                long id = IdUtil.nextId();
                save(new TUserInfo(id, userName, accountName, passWord, idCard));
            }
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
        return 1000;
    }
}