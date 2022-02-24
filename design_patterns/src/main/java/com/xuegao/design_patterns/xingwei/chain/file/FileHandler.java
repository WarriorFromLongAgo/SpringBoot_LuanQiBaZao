package com.xuegao.design_patterns.xingwei.chain.file;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/2/23 23:59
 */
public abstract class FileHandler {
    private FileHandler next;

    public FileHandler linkWith(FileHandler next) {
        this.next = next;
        return next;
    }

    public abstract boolean check(String str, FileRequest fileRequest);

    protected boolean checkNext(String str, FileRequest fileRequest) {
        if (next == null) {
            return true;
        }
        return next.check(str, fileRequest);
    }
}