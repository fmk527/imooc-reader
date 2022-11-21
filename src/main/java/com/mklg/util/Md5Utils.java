package com.mklg.util;

import org.apache.commons.codec.cli.Digest;
import org.springframework.util.DigestUtils;

public class Md5Utils {

    public static String md5Digest(String source,Integer salt) {
        char[] chars = source.toCharArray();
        //1,偏移量2,值加盐
        for(int i =0;i< chars.length;i++) {
            chars[i] = (char) (chars[i]+salt);
        }
        String target = new String(chars);
        return DigestUtils.md5DigestAsHex(target.getBytes());
    }
}
