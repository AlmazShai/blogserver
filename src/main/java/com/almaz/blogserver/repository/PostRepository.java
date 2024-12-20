package com.almaz.blogserver.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

public interface PostRepository extends CrudRepository<Post, Long> {

}
