package com.web.repository;

import com.web.entity.KhenThuong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhenThuongRepository extends JpaRepository<KhenThuong, Long> {
}
