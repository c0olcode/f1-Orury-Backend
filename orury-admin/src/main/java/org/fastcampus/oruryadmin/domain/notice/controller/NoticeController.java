package org.fastcampus.oruryadmin.domain.notice.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fastcampus.oruryadmin.domain.admin.converter.dto.AdminDto;
import org.fastcampus.oruryadmin.domain.admin.service.AdminService;
import org.fastcampus.oruryadmin.domain.notice.converter.dto.NoticeDto;
import org.fastcampus.oruryadmin.domain.notice.converter.request.NoticeCreateRequest;
import org.fastcampus.oruryadmin.domain.notice.service.NoticeService;
import org.fastcampus.oruryadmin.domain.notice.util.NoticeMessage;
import org.fastcampus.oruryapi.base.converter.ApiResponse;
import org.fastcampus.oruryapi.global.message.info.InfoMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping
@RestController
public class NoticeController {
    private final NoticeService noticeService;
    private final AdminService adminService;

    @Operation(summary = "공지사항 생성", description = "requestbody로 adminid, title, content, images를 받아 공지사항을 생성한다.")
    @PostMapping("/notice")
    public ApiResponse<Object> createNotice(@RequestBody NoticeCreateRequest request){

        AdminDto adminDto = adminService.findAdminById(request.adminId());
        NoticeDto noticeDto = request.toDto(adminDto);

        noticeService.createNotice(noticeDto);

        return  ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .message(NoticeMessage.NOTICE_CREATED.getMessage())
                .build();
    }
}
