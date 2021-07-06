package com.xuegao.video_conver.ppt.enums;

/**
 * @ClassName EnumPptFrom
 * @Author Baird Li
 * @Date 2019-09-03 20:14
 **/
public enum EnumPptFrom{


    ADDRESS(""),
    URL("");


    private String pptFromDetail;

    private EnumPptFrom(String pptFromDetail){
        this.pptFromDetail = pptFromDetail;
    }


    public static EnumPptFrom gainAddress(String pptFromDetail){
        EnumPptFrom addresss = ADDRESS;
        addresss.setPptFromDetail(pptFromDetail);
        return addresss;
    }

    public static EnumPptFrom gainUrl(String pptFromDetail){
        EnumPptFrom url = URL;
        url.setPptFromDetail(pptFromDetail);
        return url;
    }

    public String getPptFromDetail() {
        return pptFromDetail;
    }

    public void setPptFromDetail(String pptFromDetail) {
        this.pptFromDetail = pptFromDetail;
    }

    }
