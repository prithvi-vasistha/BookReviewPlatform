package com.bookreviewplatform.TheNextChapter.Data.adapter;

import com.bookreviewplatform.TheNextChapter.Data.entity.BookEntity;
import com.bookreviewplatform.TheNextChapter.Data.entity.UserEntity;
import com.bookreviewplatform.TheNextChapter.model.BookModel;
import com.bookreviewplatform.TheNextChapter.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEntityConverter {
    public UserEntity convertToEntity(UserModel userModel) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userModel.getEmail());
        userEntity.setUserId(userModel.getUserId());
        userEntity.setPassword(userModel.getPassword());
        userEntity.setRole(userModel.getUSER());
        return userEntity;
    }




    public UserModel convertToModel(UserEntity userEntity){
        UserModel userModel= new UserModel();
        userModel.setEmail(userEntity.getEmail());
        userModel.setUserId(userEntity.getUserId());
        userModel.setUSER(userEntity.getRole());
        userModel.setPassword(userEntity.getPassword());
        return userModel;
    }
}

