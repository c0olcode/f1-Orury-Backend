package org.fastcampus.oruryadmin.domain.notice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fastcampus.oruryadmin.domain.admin.converter.dto.AdminDto;
import org.fastcampus.oruryadmin.domain.admin.db.repository.AdminRepository;
import org.fastcampus.oruryadmin.domain.notice.converter.dto.NoticeDto;
import org.fastcampus.oruryadmin.domain.notice.converter.request.NoticeCreateRequest;
import org.fastcampus.oruryadmin.domain.notice.db.model.Notice;
import org.fastcampus.oruryadmin.domain.notice.db.repository.NoticeRepository;
import org.fastcampus.oruryadmin.domain.notice.util.AdminErrorCode;
import org.fastcampus.oruryapi.domain.post.db.model.Post;
import org.fastcampus.oruryapi.domain.user.converter.dto.UserDto;
import org.fastcampus.oruryapi.global.error.BusinessException;
import org.fastcampus.oruryapi.global.error.code.UserErrorCode;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;


    @Transactional
    public void createNotice(NoticeDto noticeDto) {
        Notice notice = noticeDto.toEntity();

        noticeRepository.save(notice);
    }
}
