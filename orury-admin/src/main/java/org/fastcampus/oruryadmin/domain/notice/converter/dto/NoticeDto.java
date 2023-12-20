package org.fastcampus.oruryadmin.domain.notice.converter.dto;

import org.fastcampus.oruryadmin.domain.admin.converter.dto.AdminDto;
import org.fastcampus.oruryadmin.domain.admin.db.model.Admin;
import org.fastcampus.oruryadmin.domain.notice.db.model.Notice;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link org.fastcampus.oruryadmin.domain.notice.db.model.Notice}
 */
public record NoticeDto(
        Long id,
        String title,
        String content,
        String images,
        AdminDto admindto,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static NoticeDto of(
            Long id,
            String title,
            String content,
            String images,
            AdminDto admindto,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        return new NoticeDto(
                id,
                title,
                content,
                images,
                admindto,
                createdAt,
                updatedAt
        );
    }

    public static NoticeDto from(Notice entity) {
        return NoticeDto.of(
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getImages(),
                AdminDto.from(entity.getAdmin()),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public Notice toEntity() {
        return Notice.of(
                title,
                content,
                images,
                admindto.toEntity()
        );
    }
}