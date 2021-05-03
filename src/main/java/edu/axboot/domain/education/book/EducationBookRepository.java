package edu.axboot.domain.education.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationBookRepository extends JpaRepository<EducationBook, Long> {
}
