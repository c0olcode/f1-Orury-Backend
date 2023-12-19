package org.fastcampus.oruryapi.domain.user.converter.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.fastcampus.oruryapi.domain.user.converter.dto.UserDto;
import org.fastcampus.oruryapi.domain.user.db.model.User;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ProfileImageRequest(
        Long id,
        String profileImage
){

    public static UserDto toDto(User user, ProfileImageRequest profileImageRequest){
        return UserDto.of(
                profileImageRequest.id(),
                user.getEmail(),
                user.getNickname(),
                user.getPassword(),
                user.getSignUpType(),
                user.getGender(),
                user.getBirthday(),
                profileImageRequest.profileImage(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
