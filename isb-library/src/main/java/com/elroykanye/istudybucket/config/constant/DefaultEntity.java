package com.elroykanye.istudybucket.config.constant;

import com.elroykanye.istudybucket.data.entity.Bucket;
import com.elroykanye.istudybucket.data.entity.Chat;
import com.elroykanye.istudybucket.data.entity.Post;
import com.elroykanye.istudybucket.data.entity.User;
import com.elroykanye.istudybucket.data.enums.Gender;
import com.elroykanye.istudybucket.data.enums.PostType;
import com.elroykanye.istudybucket.data.enums.UserRole;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class DefaultEntity {
    public final static Bucket DEFAULT_BUCKET = Bucket.builder()
            .bucketId(1L).bucketTitle("Default Bucket").description("This is the default bucket")
            .groupImage("/path/to/image").creationDate(LocalDateTime.now()).memberships(List.of())
            .build();

    public final static User DEFAULT_USER = User.builder()
            .userId(1L).username("user").password("password").email("user@mail.com")
            .firstName("First").lastName("Last").phoneNumber("1234567890")
            .dob(LocalDateTime.now()).gender(Gender.MALE).userRole(UserRole.USER).userVerified(true)
            .createdDate(LocalDateTime.now()).buckets(List.of()).messages(List.of())
            .trophies(List.of()).linkOfUsers(List.of()).linkToUsers(List.of()).buckets(List.of())
            .build();

    public final static Chat DEFAULT_CHAT = Chat.builder()
            .chatId(1L).chatTitle("Default Chat").chatType("GROUP")
            .chatDescription("This is the default chat").creationDate(LocalDateTime.now())
            .messages(List.of())
            .build();

    public final static Post DEFAULT_POST = Post.builder()
            .postId(1L).createdDate(LocalDateTime.now()).content("This is the default post")
            .postTitle("Default Post").postType(PostType.QUESTION)
            .votes(List.of())
            .comments(List.of())
            .build();
}
