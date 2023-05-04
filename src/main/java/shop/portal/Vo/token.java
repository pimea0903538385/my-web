package shop.portal.Vo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import shop.portal.entity.user;

import java.util.Date;
@Component
public class token {
    private static final String SECRET = "wadsdwasxcferfhb";


    // 生成 token
    public  String generateToken(String str) {


        return Jwts.builder()
                .setSubject(str)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }
      public  String gettokenname(String str){


          Claims claims = Jwts.parser()
                  .setSigningKey(SECRET)
                  .parseClaimsJws(str)
                  .getBody();

          String subject = claims.getSubject();

          return subject;

      }

}
