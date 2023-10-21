package com.cache.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cache.entity.Book;

import jakarta.transaction.Transactional;

@Repository
public interface BookRepo extends JpaRepository<Book,Long>{

	@Transactional
    @Modifying
    @Query("update Book u set u.name=?2 where u.id=?1")
    int updateBook(long id, String name);

}
