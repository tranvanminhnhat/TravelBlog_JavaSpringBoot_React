package com.travel.shahara.repositories;

import com.travel.shahara.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    /**
     * Repository get all Blogs
     * @return Blog list
     */
    @Query(value = "SELECT * FROM blog", nativeQuery = true)
    ArrayList<Blog> getAllBlogs();
}
