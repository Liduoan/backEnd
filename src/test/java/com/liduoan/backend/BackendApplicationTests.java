package com.liduoan.backend;

import com.liduoan.backend.pojo.entity.BackResult;
import com.liduoan.backend.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackendApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void liduoan(){
        String jwtStr = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJUaHUgT2N0IDA3IDE5OjQ0OjQzIENTVCAyMDIxIiwic3ViIjoi5p2O5biFIiwiaXNzIjoidXNlciIsImlhdCI6MTYzMzYwNzA4MywiZXhwIjoxNjMzNjEwNjgzfQ.9O-tOhBjIPWm8fNGa7XjyKVqZsyOrmG1jicK14H-pCY";
        BackResult<Claims> result = JwtUtil.validateJWT(jwtStr);
        String subject = result.getData().getSubject();
        System.out.println(result);
    }


}
