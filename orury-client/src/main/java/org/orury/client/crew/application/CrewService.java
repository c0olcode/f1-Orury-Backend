package org.orury.client.crew.application;

import org.orury.domain.crew.domain.dto.CrewDto;
import org.orury.domain.crew.domain.entity.CrewMemberPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CrewService {
    CrewDto getCrewDtoById(Long crewId);

    void createCrew(CrewDto crewDto, MultipartFile image);

    Page<CrewDto> getCrewDtosByRank(Pageable pageable);

    Page<CrewDto> getCrewDtosByRecommend(Pageable pageable);

    Page<CrewDto> getCrewDtosByUserId(Long userId, Pageable pageable);

    List<String> getUserImagesByCrew(CrewDto crewDto);

    boolean existCrewMember(CrewMemberPK crewMemberPK);

    void updateCrewImage(CrewDto crewDto, MultipartFile image, Long userId);
}
