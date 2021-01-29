package com.xuegao.luanqibazao_1;

import com.xuegao.luanqibazao_1.domain.UserInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1
 * <br/> @ClassName：Builder
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/01/29 21:44
 */
public class Builder<T> {

    private final Supplier<T> instantiator;

    private final List<Consumer<T>> modifiers = new ArrayList<>();

    public Builder(Supplier<T> instantiator) {
        this.instantiator = instantiator;
    }

    public static <T> Builder<T> of(Supplier<T> instantiator) {
        return new Builder<>(instantiator);
    }

    public <P1> Builder<T> with(Consumer1<T, P1> consumer, P1 p1) {
        Consumer<T> c = instance -> consumer.accept(instance, p1);
        modifiers.add(c);
        return this;
    }

    public T build() {
        T value = instantiator.get();
        modifiers.forEach(modifier -> modifier.accept(value));
        modifiers.clear();
        return value;
    }

    /**
     * 1 参数 Consumer
     */
    @FunctionalInterface
    public interface Consumer1<T, P1> {
        void accept(T t, P1 p1);
    }

    public static void main(String[] args) {
        UserInfo userInfo = Builder.of(UserInfo::new)
                .with(UserInfo::setId, "idid")
                .with(UserInfo::setName, "namename").build();
        System.out.println(userInfo);
    }
}