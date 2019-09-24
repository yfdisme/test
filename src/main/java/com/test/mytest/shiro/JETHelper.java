package com.test.mytest.shiro;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;
import java.util.Map;

public class JETHelper {
    private static final String SECRET = "session_secret";
    private static final String ISSURE = "cat_user";
//    public static String genToken(Map<String,String> claims){
////        Algorithm algorithm = Algorithm.HMAC256(SECRET);
////        JWTCreator.Builder builder = JWT.create().withIssuer(ISSURE).withExpiresAt(DateUtils.addDays(new Date(),1));
////        claims.forEach((k,v) ->builder.withClaim(k,v));
////    }
}