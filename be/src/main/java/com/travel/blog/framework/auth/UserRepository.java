package com.travel.blog.framework.auth;

import com.travel.blog.repository.db.model.blog.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.Optional;

@Mapper
public interface UserRepository {

    @Select("""
            SELECT id, name, email FROM users
            WHERE email = #{email}
            """)
    Optional<User> findByEmail(String email);

    @Insert("""
            INSERT INTO users(email, name)
            VALUES(#{email}, #{name})
            """)
    void save(User user);
}
