package com.xuegao.xianliu_demo.aspect;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.http.ResponseEntity;

import javax.xml.ws.Response;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/**
 * <br/> @PackageName：com.xuegao.xianliu_demo.aspect
 * <br/> @ClassName：
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/15 13:53
 */
public class OneDayLimit {

    private LoadingCache<Long, LongAdder> counter =
            CacheBuilder.newBuilder().expireAfterWrite(2, TimeUnit.SECONDS)
                    .build(new CacheLoader<Long, LongAdder>() {
                        @Override
                        public LongAdder load(Long aLong) {
                            return new LongAdder();
                        }
                    });
    private static long permit = 50;

    public ResponseEntity getData() throws ExecutionException {
        long currentTime = System.currentTimeMillis() / 1000;
        LongAdder longAdder = counter.get(currentTime);
        longAdder.increment();
        if (longAdder.sum() > permit) {
            return ResponseEntity.of(Optional.of("访问速度过快"));
        }
        // 业务处理
        return ResponseEntity.ok().build();
    }

}