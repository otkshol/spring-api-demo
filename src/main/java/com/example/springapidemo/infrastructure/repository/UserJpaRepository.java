package com.example.springapidemo.infrastructure.repository;

import com.example.springapidemo.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPAを利用するためのインタフェース
 */
public interface UserJpaRepository extends JpaRepository<UserEntity, String> {
}