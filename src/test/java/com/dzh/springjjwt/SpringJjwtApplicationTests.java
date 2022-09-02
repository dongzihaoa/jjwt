package com.dzh.springjjwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.event.CaretListener;
import java.util.Date;

@SpringBootTest
class SpringJjwtApplicationTests {

    @Test
    void creatToken() {
        //创建JWT对象
        JwtBuilder builder = Jwts.builder()
                .setId("1001")  //设置id
                .setSubject("董子豪")  //自定义数据
                .setIssuedAt(new Date())
                .claim("role","管理员") //设置自定义键值对
                //设置过期时间
                .setExpiration(new Date(System.currentTimeMillis() + 600 * 1000))
                .signWith(SignatureAlgorithm.HS256, "dzhAdmin");

        //创建token
        String token = builder.compact();
        System.out.println(token);
    }

    @Test
    void parseToken(){
        String token =
                "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMDAxIiwic3ViIjoi6JGj5a2Q6LGqIiwiaWF0IjoxNjYyMDg1MTc2LCJyb2xlIjoi566h55CG5ZGYIiwiZXhwIjoxNjYyMDg1Nzc2fQ.zTQDgsC1sc7FWSBo81FcjKT1QLIvKVh-AWYQaPb-X4w";
        Claims claims = Jwts.parser().setSigningKey("dzhAdmin").parseClaimsJws(token).getBody();

        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(claims.getIssuedAt());
        System.out.println(claims.get("role"));

    }


}
