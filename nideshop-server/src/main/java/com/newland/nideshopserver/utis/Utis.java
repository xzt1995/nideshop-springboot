package com.newland.nideshopserver.utis;


import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

/**
 * @author xzt
 * @CREATE2019-10-15 16:28
 */
public class Utis {


    private static final Base64.Decoder decoder = Base64.getDecoder();

    private static final Base64.Encoder encoder = Base64.getEncoder();


    /**
     * 计算分页总数
     *
     * @param count 总数
     * @param size  分页大小
     * @return 总页数
     */
    public static int totalPages(int count, int size) {
        int totalPages = ((count % size) > 0) ? count / size + 1 : count / size;
        return totalPages;
    }

    /**
     * base64 解码
     *
     * @param text
     * @return
     */
    public static String base64Decoder(String text) throws Exception {
        byte[] decode = decoder.decode(text);
        return new String(decode,"UTF-8");
    }


    /**
     * base64 编码
     *
     * @param text
     * @return
     */
    public static String base64Encoder(String text) throws Exception {
        byte[] bytes = text.getBytes("UTF-8");
        return  encoder.encodeToString(bytes);
    }

    /**
     * 数据库时间戳转换日期
     * @param time
     * @return
     */
    public static  String timeFormat(Long time){
        String result = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(time * 1000));
        return result;
    }

}
