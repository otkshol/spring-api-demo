package com.example.springapidemo.application.resource;

import com.example.springapidemo.domain.object.User;
import lombok.Data;


/**
 * リクエストボディのマッピング用クラス
 */
@Data
public class UserBody {



    private String id;


    private String value;

    /**
     * ドメインオブジェクトへ変換
     *
     * @return ドメインオブジェクト
     */
    public User toDomainUser() {
        return User.builder()
                .id(this.id)
                .value(this.value)
                .build();
    }
}
