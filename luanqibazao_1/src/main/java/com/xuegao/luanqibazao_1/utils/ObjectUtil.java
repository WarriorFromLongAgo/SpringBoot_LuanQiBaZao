package com.xuegao.luanqibazao_1.utils;

import cn.hutool.core.bean.BeanUtil;
import com.xuegao.luanqibazao_1.domain.UserInfo;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ObjectUtil {

    private static String[] GOODS_STORAGE_FIELDS =
            {
                    "id",
                    "name",
                    "address"
            };

    @Builder
    @Getter
    public static class ModifyField {
        String fieldName;
        Object oldValue;
        Object newValue;

        public String getOldValue() {
            return ObjectUtil.toString(oldValue);
        }

        public String getNewValue() {
            return ObjectUtil.toString(newValue);
        }
    }

    public static <T> List<ModifyField> isModifyFieldsFilterNull(T newData, T oldData, String[] fields) {
        if (fields == null || fields.length == 0) {
            throw new RuntimeException("属性名集合不能为空");
        }
        List<ModifyField> isModifyFields = new ArrayList<>();
        for (String fieldName : fields) {
            Object newValue = BeanUtil.getFieldValue(newData, fieldName);
            Object oldValue = BeanUtil.getFieldValue(oldData, fieldName);
            if (Objects.isNull(newValue) || Objects.isNull(oldValue)){
                continue;
            }
            if (compareTwo(newValue, oldValue)) {
                isModifyFields.add(ModifyField.builder().fieldName(fieldName).newValue(newValue).oldValue(oldValue).build());
            }

        }
        return isModifyFields;
    }

    public static boolean compareTwo(Object newValue, Object oldValue) {
        // if (Objects.isNull(newValue) || Objects.isNull(oldValue)) {
        //     return false;
        // }
        if ((newValue instanceof String) && StringUtils.isBlank(newValue.toString())) {
            newValue = null;
        }
        if ((oldValue instanceof String) && StringUtils.isBlank(oldValue.toString())) {
            oldValue = null;
        }
        if (newValue == null && oldValue != null) {
            return true;
        }
        if (newValue != null && oldValue == null) {
            return true;
        }
        if (newValue == null) {
            return false;
        }
        if (newValue instanceof BigDecimal) {
            if (((BigDecimal) newValue).compareTo((BigDecimal) oldValue) != 0) {
                return true;
            }
        }
        return !newValue.equals(oldValue);
    }


    public static String toString(Object object) {
        if (object == null) {
            return "";
        }
        if (object instanceof String) {
            return (String) object;
        }
        if (object instanceof Integer) {
            return String.valueOf(object);
        }
        if (object instanceof Long) {
            return String.valueOf(object);
        }
        if (object instanceof Double) {
            return String.valueOf(object);
        }
        if (object instanceof BigDecimal) {
            return ((BigDecimal) object).toPlainString();
        }
        return object.toString();
    }

    public static void main(String[] args) {
        List<UserInfo> userInfoList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setName(String.valueOf(i));
            userInfo.setId(String.valueOf(i));
            userInfoList.add(userInfo);
        }
        UserInfo userInfo1 = userInfoList.get(0);
        UserInfo userInfo2 = userInfoList.get(1);

        userInfo1.setAddress(null);
        userInfo2.setAddress("setAddress2");

        List<ModifyField> modifyFieldsFilterNull = isModifyFieldsFilterNull(userInfo1, userInfo2, GOODS_STORAGE_FIELDS);
        System.out.println();
    }
}
