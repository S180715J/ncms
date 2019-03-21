package com.newer.ncms.utils;

import java.util.Date;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.newer.ncms.pojo.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;

/**
 * 创建JWT具类
 * 
 * @author QuanLijian
 *
 */
@Component
public class JwtTokenUtil {

	private Clock clock = DefaultClock.INSTANCE;

	// 密钥,从application.properties中读取
	@Value("${jwt.secret}")
	private String secret;
	// jwt失效时间(单位为秒)
	@Value("${jwt.expiration}")
	private Long expiration = 1800L;

	@Value("${jwt.header}")
	private String tokenHeader;

	/**
	 * 创建JWT token
	 * 
	 * @param uid
	 * @param pwd
	 * @return
	 */
	public String createJwt(User user) {
		Date now = clock.now();
		// 添加JWT的包含部分，有三部分：头部（header）、载荷（payload）、签证（signature）.
		JwtBuilder jwtBuilder = Jwts.builder().setHeaderParam("typ", "JWT").setIssuedAt(now) // 设置jwt创建时间
				.setIssuer(user.getNickname()) // 设置当前用户信息
				.setExpiration(calculateExpirationDate(now)) // 设置失效时间
				.setSubject(user.getRealname())
				.claim("user", user)// 通过claim()方法可添加若干属性，也可以添加一个对象
				.signWith(SignatureAlgorithm.HS512, secret);// 设置加密算法、指定密钥
		return jwtBuilder.compact();

	}

	/**
	 * 验证JWT
	 * 
	 * @return
	 */
	public Claims parseJWT(String token) {
		// 根据密钥解析token,解析成功返回Claims;解析不成功会抛出异常
		/*
		 * String[] tokenString=token.split(" ");
		 * System.out.println("token-----"+tokenString[1]);
		 */
		Claims c = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		return c;
	}

	/**
	 * 得到失效时间
	 * 
	 * @param createdDate
	 * @return
	 */
	private Date calculateExpirationDate(Date createdDate) {
		return new Date(createdDate.getTime() + expiration * 1000);
	}

	/**
	 * 解析对象
	 * @param req
	 * @return
	 */
	public LinkedHashMap<String, Object> getObj(HttpServletRequest req) {
		// 从请求头中获取token
		String token = req.getHeader("Authorization");
		 //System.out.println("传入验证的token----" + token);
		try {
			Claims claims = parseJWT(token);
			@SuppressWarnings("unchecked")
			LinkedHashMap<String, Object> user = (LinkedHashMap<String, Object>) claims.get("user");
			//System.err.println(user);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
