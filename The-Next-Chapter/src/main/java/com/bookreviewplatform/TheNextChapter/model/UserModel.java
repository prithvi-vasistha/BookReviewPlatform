package com.bookreviewplatform.TheNextChapter.model;
import com.bookreviewplatform.TheNextChapter.Data.entity.UserEntity;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    private Long userId;

    private String userName;

    private String email;

    private String password;

    private UserEntity.UserRole USER;

}
