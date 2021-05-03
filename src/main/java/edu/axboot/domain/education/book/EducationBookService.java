package edu.axboot.domain.education.book;

import com.querydsl.core.BooleanBuilder;
import edu.axboot.controllers.dto.EducationListResponseDto;
import edu.axboot.controllers.dto.EducationResponseDto;
import edu.axboot.controllers.dto.EducationSaveRequestDto;
import edu.axboot.controllers.dto.EducationUpdateRequestDto;
import edu.axboot.domain.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
//public class EducationBookService extends BaseService<EducationBook, Long> {
public class EducationBookService {
    private final EducationBookRepository educationBookRepository;

    @Transactional
    public Long save(EducationSaveRequestDto requestDto) {
        return educationBookRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, EducationUpdateRequestDto requestDto) {
        EducationBook educationBook = educationBookRepository.findOne(id);

        if (educationBook == null) {
            throw new IllegalArgumentException("해당 거래처가 없습니다. id=" + id);
        }

        educationBook.update(requestDto.getTel(), requestDto.getEmail());

        return id;
    }

    public EducationResponseDto findById(Long id) {
        EducationBook entity = educationBookRepository.findOne(id);

        if (entity == null) {
            throw new IllegalArgumentException("해당 거래처가 없습니다. id=" + id);
        }

        return new EducationResponseDto(entity);
    }

/*
    @Transactional(readOnly = true)
    public List<EducationListResponseDto> findBy(String companyNm, String ceo, String bizno) {
        BooleanBuilder builder = new BooleanBuilder();

        if (isNotEmpty(companyNm)) {
            builder.and(qEducationBook.companyNm.contains(companyNm));
        }
        if (isNotEmpty(ceo)) {
            builder.and(qEducationBook.ceo.like("%" + ceo +"%"));
        }
        if (isNotEmpty(bizno)) {
            builder.and(qEducationBook.bizno.like(bizno + "%"));
        }

        List<EducationBook> entitis = select()
                .from(qEducationBook)
                .where(builder)
                .orderBy(qEducationBook.companyNm.asc())
                .fetch();


        return entitis.stream()
                .map(EducationListResponseDto::new)
                .collect(Collectors.toList());
    }
*/
}
