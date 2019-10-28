package com.newland.nideshopserver.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xzt
 * @CREATE2019-10-25 16:47
 * 可以公开访问的路径
 */
public class PublicPath {

    //可以公开访问的controller
    private static final String[] publicController = {"index","catalog","topic","auth","goods","brand","search","region"};

    //可以公开访问的action
    private static final String[] publicAction = {"/comment/list","/comment/count","/cart/index","/cart/add","/cart/checked","/cart/update","/cart/delete","/cart/goodscount","/pay/notify","/pages/ucenter/index/index"};


    public static String[] getPublicController() {
        return publicController;
    }

    public static String[] getPublicAction() {
        return publicAction;
    }
}
