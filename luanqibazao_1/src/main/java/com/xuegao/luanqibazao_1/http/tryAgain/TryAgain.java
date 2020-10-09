package com.xuegao.luanqibazao_1.http.tryAgain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.http.tryAgain
 * <br/> @ClassName：TryAgain
 * <br/> @Description：模板设计模式的重试
 * <br/> @author：xuegao
 * <br/> @date：2020/10/09 16:43
 */
public class TryAgain {
    public static void main(String[] args) {
        new AbstractSpinBusiness() {
            @Override
            protected boolean handle() {
                // CompanyProfile updateProfile = getProfileForUpdateConf(staff, attrMap);
                // return companyProfileDao.updateCompanyProfileConf(updateProfile) > 0;
                return false;
            }
        }.spin(5);
    }
}

abstract class AbstractSpinBusiness {

    private Logger log = LoggerFactory.getLogger(AbstractSpinBusiness.class);

    public void spin(int times) {

        for (int i = 0; i < times; i++) {
            if (handle()) {
                return;
            }
            log.debug(String.format("spin重试%s", i));
        }
    }

    /**
     * 执行主体
     * @return true:执行成功,不需要重试  false:执行失败
     */
    protected abstract boolean handle();

}

// 作者：showyool
// 链接：https://juejin.im/post/6875124307605864461
// 来源：掘金
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。