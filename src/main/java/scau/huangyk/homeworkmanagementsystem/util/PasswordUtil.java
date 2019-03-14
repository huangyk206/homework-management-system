package scau.huangyk.homeworkmanagementsystem.util;

import org.springframework.util.DigestUtils;

import java.security.MessageDigest;

public class PasswordUtil {
    public static String MD5Encode(String password){
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }

    public static boolean checkMD5(String original, String md5) {
        return MD5Encode(original).equals(md5);
    }

    public static void main(String[] args){
        System.out.println(MD5Encode("123456"));
    }


}
