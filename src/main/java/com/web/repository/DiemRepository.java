package com.web.repository;

import com.web.entity.Diem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiemRepository extends JpaRepository<Diem, Long> {
}
