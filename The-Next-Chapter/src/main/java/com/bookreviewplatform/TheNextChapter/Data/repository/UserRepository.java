package com.bookreviewplatform.TheNextChapter.Data.repository;
import com.bookreviewplatform.TheNextChapter.Data.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

}