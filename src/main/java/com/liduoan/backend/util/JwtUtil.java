package com.liduoan.backend.util;


import com.liduoan.backend.pojo.entity.BackResult;
import com.liduoan.backend.pojo.entity.ResultCode;
import io.jsonwebtoken.*;
import sun.misc.BASE64Decoder;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.util.Date;

public class JwtUtil {

    public static final String JWT_SECERT = "dfb70cce5939b7023d0ca97b86937bf9";

    /**
     * 签发JWT
     *
     * @param id
     * @param subject   可以是JSON数据 尽可能少
     * @param ttlMillis 有效时间
     * @return String
     */
    public static String createJWT(String id, String subject, Long ttlMillis) throws IOException {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        SecretKey secretKey = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setId(id) // 是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                .setSubject(subject)   // 代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志
                .setIssuer("user")     // 颁发者是使用 HTTP 或 HTTPS 方案的 URL（区分大小写），其中包含方案、主机及（可选的）端口号和路径部分
                .setIssuedAt(now)      // jwt的签发时间
                .signWith(SignatureAlgorithm.HS256, secretKey); // 设置签名使用的签名算法和签名使用的秘钥
        if (ttlMillis > 0) {
            long expMillis = nowMillis + ttlMillis;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate); // 过期时间
        }
        return builder.compact();
    }

    /**
     * 验证JWT
     *
     * @param jwtStr
     * @return
     */
    public static BackResult validateJWT(String jwtStr) {
        BackResult<Claims> checkResult = new BackResult<>();
        try {
            Claims claims = parseJWT(jwtStr);
            checkResult.setResult(ResultCode.SUCCESS,claims);
        } catch (ExpiredJwtException e) {
            checkResult.setResult(ResultCode.JWT_ERRCODE_EXPIRE);
        } catch (Exception e) {
            checkResult.setResult(ResultCode.JWT_ERRCODE_FAIL);
        }
        return checkResult;
    }

    private static SecretKey generalKey() throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] encodedKey = decoder.decodeBuffer(JWT_SECERT);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }

    /**
     * 解析JWT字符串
     *
     * @param jwt
     * @return
     */
    public static Claims parseJWT(String jwt) throws IOException {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
