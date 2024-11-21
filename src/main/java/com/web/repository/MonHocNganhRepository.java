package com.web.repository;

import com.web.entity.MonHocNganh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonHocNganhRepository extends JpaRepository<MonHocNganh, Long> {
}
