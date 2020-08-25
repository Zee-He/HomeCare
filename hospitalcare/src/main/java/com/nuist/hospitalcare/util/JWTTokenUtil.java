package com.nuist.hospitalcare.util;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import com.nuist.hospitalcare.config.Audience;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * JWT工具类
 */
public abstract class JWTTokenUtil {
	public static final String AUTH_HEAD_KEY = "Authorization";

	public static String createJWT(String userid, String username, Audience audience) {
		// 使用SHMAC,SHA-256加密算法
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		// 获取当前时间
		long begin_millis = System.currentTimeMillis();
		// 实例化java.util.Date对象
		Date begin_date = new Date(begin_millis);
		// 生成签名密钥
		byte[] api = DatatypeConverter.parseBase64Binary(audience.getBase64Secret());
		Key key = new SecretKeySpec(api, signatureAlgorithm.getJcaName());
		// 设置JWT的header（头信息）
		Map<String, Object> header = new HashMap<String, Object>();
		header.put("alg", SignatureAlgorithm.HS256.getValue());
		header.put("type", "JWT");
		// 设置JWT的payload（有效载荷）
		JwtBuilder builder = Jwts.builder().setHeader(header)// 设置头信息
				.claim("userid", userid)// 将特定用户信息存储在claim中，敏感数据需加密
				.setSubject(username)// 设置JWT主体
				.setIssuer(audience.getClientid())// 设置签发主体
				.setIssuedAt(new Date())// 设置签发时间
				.setAudience(audience.getName())// 设置接收者
				.signWith(signatureAlgorithm, key);// 设置签名
		// 添加过期时间
		int time = audience.getExpireSecond();// 读取配置文件
		if (time > 0) {
			long exp = begin_millis + time * 1000;
			Date exp_date = new Date(exp);
			builder.setExpiration(exp_date)// 时间戳，exp_date代表过期时间
					.setNotBefore(begin_date);// 时间戳，begin_date代表开始生效时间，在此之前验证都是失败
		}
		// 生成
		return builder.compact();// 生成序列化安全url字符串
	}

	/**
	 * 解析JWT
	 * 
	 * @param token
	 * @param base64Security
	 * @return
	 */
	public static Claims parseJWT(String token, String base64Security) {
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
				.parseClaimsJws(token)// parseClaimsJwt(token)存在异常
				.getBody();
		return claims;
	}

	/**
	 * 从token中获取username
	 * 
	 * @param token
	 * @param base64Security
	 * @return
	 */
	public static String getUserName(String token, String base64Security) {
		// 对应生成JWT时的选项setSubject(username)
		return parseJWT(token, base64Security).getSubject();
	}

	/**
	 * 从token中获取userid
	 * 
	 * @param token
	 * @param base64Security
	 * @return
	 */
	public static String getUserId(String token, String base64Security) {
		// 对应生成JWT时的选项claim("userid", userid)
		return parseJWT(token, base64Security).get("userid", String.class);
	}

	public static boolean isExpiration(String token, String base64Security) {
		// 过期时间与当前时间比较
		Claims claims = parseJWT(token, base64Security);
		return claims.getExpiration().before(new Date());
	}
}
