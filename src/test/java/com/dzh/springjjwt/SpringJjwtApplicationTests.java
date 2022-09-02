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

                .signWith(SignatureAlgorithm.HS256, "dzhAdmin");

        //创建token
        String token = builder.compact();
        System.out.println(token);
    }

    @Test
    void parseToken(){
        String token =
                "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMDAxIiwic3ViIjoi6JGj5a2Q6LGqIiwiaWF0IjoxNjYyMDgzNDMwfQ.MS2AGzhsWCBQwKlFL_AF29LtMK5HkkS3hB-I_0jYpUc";
        Claims claims = Jwts.parser().setSigningKey("dzhAdmin").parseClaimsJws(token).getBody();

        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(claims.getIssuedAt());

    }


}
