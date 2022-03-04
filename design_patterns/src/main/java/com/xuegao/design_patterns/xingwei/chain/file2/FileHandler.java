package com.xuegao.design_patterns.xingwei.chain.file2;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/2/28 23:16
 */
public abstract class FileHandler {
    private String str;
    private FileHandler next;

    protected FileHandler(String str) {
        this.str = str;
    }

    public FileHandler linkWith(FileHandler next) {
        this.next = next;
        return next;
    }

    public abstract boolean check();

    protected boolean checkNext() {
        if (next == null) {
            return true;
        }
        return next.check();
    }

}