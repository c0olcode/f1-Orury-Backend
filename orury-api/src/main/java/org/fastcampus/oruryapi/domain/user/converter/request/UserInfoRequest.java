package org.fastcampus.oruryapi.domain.user.converter.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.fastcampus.oruryapi.domain.user.converter.dto.UserDto;
import org.fastcampus.oruryapi.domain.user.db.model.User;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record UserInfoRequest(
        Long id,
        String nickname
) {
    public static UserDto toDto(User user, UserInfoRequest userInfoRequest){
        return UserDto.of(
                userInfoRequest.id(),
                user.getEmail(),
                userInfoRequest.nickname(),
                user.getPassword(),
                user.getSignUpType(),
                user.getGender(),
                user.getBirthday(),
                user.getProfileImage(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
