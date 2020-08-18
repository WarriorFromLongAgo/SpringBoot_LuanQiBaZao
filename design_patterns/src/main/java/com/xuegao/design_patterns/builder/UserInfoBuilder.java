package com.xuegao.design_patterns.builder;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.builder
 * <br/> @ClassName：UserInfoBuilder
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/17 9:33
 */
public class UserInfoBuilder {
    private String userName;
    private int age;
    //可选参数
    private String address;
    private String phoneNumber;

    public static class Builder {
        private String userName;
        private int age;
        //可选参数的默认值
        private String address = "";
        private String phoneNumber = "";

        public Builder() {
        }

        public Builder(String userName, int age) {
            this.userName = userName;
            this.age = age;
        }

        public Builder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public UserInfoBuilder build() {
            return new UserInfoBuilder(this);
        }
    }

    private UserInfoBuilder(Builder builder) {
        this.userName = builder.userName;
        this.age = builder.age;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
    }

    // 作者：你听___
    // 链接：https://juejin.im/post/6854573215545557000
    // 来源：掘金
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}

class mainmain {

    public static void main(String[] args) {

        UserInfoBuilder userInfo = new UserInfoBuilder.Builder()
                .setAge(10).setAddress("湖北省").setPhoneNumber("111").setUserName("xuegao").build();

    }
}