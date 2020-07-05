package com.example.springapidemo.infrastructure.repository;

import com.example.springapidemo.domain.object.User;
import com.example.springapidemo.domain.repository.UserRepository;
import com.example.springapidemo.infrastructure.entity.UserEntity;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 永続化の実装クラス
 * ドメインオブジェクトをEntityに変換してJPAをラップする
 */
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    @NonNull
    private final UserJpaRepository userJpaRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<User> findById(String id) {
        return this.userJpaRepository.findById(id)
                .map(UserEntity::toDomainUser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User save(User user) {
        return this.userJpaRepository.save(UserEntity.build(user))
                .toDomainUser();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(String id) {
        this.userJpaRepository.deleteById(id);
    }
}