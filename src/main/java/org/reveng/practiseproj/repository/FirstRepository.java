package org.reveng.practiseproj.repository;

import org.reveng.practiseproj.entity.FirstEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstRepository extends JpaRepository<FirstEntity, Integer> {
}
