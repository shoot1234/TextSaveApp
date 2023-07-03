package com.example.demo;

import org.springframework.data.repository.CrudRepository;

//CrudRepositoryをJpaRepositoryに変更しても使える
public interface DiaryRepository extends CrudRepository<Diary, Integer> {
}