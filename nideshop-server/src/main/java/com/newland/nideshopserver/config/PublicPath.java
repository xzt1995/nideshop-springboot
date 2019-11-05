package com.newland.nideshopserver.config;


/**
 * @author xzt
 * @CREATE2019-10-25 16:47
 * 可以公开访问的路径
 */
public class PublicPath {

    //可以公开访问的controller
    private static final String[] PUBLIC_CONTROLLE = {"index","catalog","topic","auth","goods","brand","search","region","error","collect"};

    //可以公开访问的action
    private static final String[] PUBLIC_ACTION = {"/comment/list","/comment/count","/pay/notify","/pages/ucenter/index/index"};


    public static String[] getPublicController() {
        return PUBLIC_CONTROLLE;
    }

    public static String[] getPublicAction() {
        return PUBLIC_ACTION;
    }
}
