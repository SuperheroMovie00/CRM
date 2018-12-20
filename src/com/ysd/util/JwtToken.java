package com.ysd.util;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * 鍩轰簬Token鐨勮韩浠介獙璇佺殑涓绘祦绋嬪涓�
    鐢ㄦ埛閫氳繃鐢ㄦ埛鍚嶅拰瀵嗙爜鍙戦�璇锋眰锛�
    绋嬪簭楠岃瘉锛�
    绋嬪簭杩斿洖涓�釜绛惧悕鐨則oken 缁欏鎴风锛�
    瀹㈡埛绔偍瀛榯oken,骞朵笖姣忔鐢ㄤ簬姣忔鍙戦�璇锋眰銆�
 */
  
/** JSON Web Token 娉ㄦ剰:闇�JDK1.7浠ヤ笂
 * 涓��瀹氫箟涓�釜JsonWebToken鐨勫伐鍏风被锛屽叿鏈夊姞瀵嗗拰瑙ｅ瘑token鐨勫姛鑳�
 * 
 * 闇�渚濊禆鐨勪袱涓狫ar
 * java-jwt-3.2.0.jar
 * commons-codec-1.10.jar
 * 
 * 鍜屼换鎰忎竴涓猨son杞崲宸ュ叿
 * jackson-annotations-2.6.1.jar
 * jackson-core-2.6.1.jar
 * jackson-databind-2.6.1.jar
 * 
 */
public class JwtToken {
  
    //瀵嗛挜  
    private static final String SECRET = "secret";  
  
    //jackson  
    private static ObjectMapper mapper = new ObjectMapper();  
  
    /** 
     * header鏁版嵁 
     * @return 
     */  
    private static Map<String, Object> createHead() {  
        Map<String, Object> map = new HashMap<String, Object>();  
        map.put("typ", "JWT");  
        map.put("alg", "HS256");  
        return map;  
    }  
  
    /** 
     * 鐢熸垚token 
     * 
     * @param obj    瀵硅薄鏁版嵁 
     * @param maxAge 鏈夋晥鏈�
     * @param <T> 
     * @return 
     */  
    public static <T> String sign(T obj, long maxAge) throws UnsupportedEncodingException, JsonProcessingException {  
        JWTCreator.Builder builder = JWT.create();  
  
        builder.withHeader(createHead())//header  
                .withSubject(mapper.writeValueAsString(obj));  //payload  
  
        if (maxAge >= 0) {  
            long expMillis = System.currentTimeMillis() + maxAge;  
            Date exp = new Date(expMillis);  
            builder.withExpiresAt(exp);  
        }  
  
        return builder.sign(Algorithm.HMAC256(SECRET));  
    }  
  
    /** 
     * 瑙ｅ瘑 
     * @param token   token瀛楃涓�
     * @param classT  瑙ｅ瘑鍚庣殑绫诲瀷 
     * @param <T> 
     * @return 
     */  
    public static <T> T unsign(String token, Class<T> classT) throws IOException {  
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();  
        DecodedJWT jwt = verifier.verify(token);  
  
        Date exp = jwt.getExpiresAt();  
        if(exp!=null&&exp.after(new Date())){  
            String subject = jwt.getSubject();  
            return mapper.readValue(subject, classT);  
        }  
  
        return null;  
    }  
    
  
}
