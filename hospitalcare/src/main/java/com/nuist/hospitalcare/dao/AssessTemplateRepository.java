package com.nuist.hospitalcare.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nuist.hospitalcare.entity.AssessTemplate;

public interface AssessTemplateRepository extends JpaRepository<AssessTemplate, Integer> {
	
	/**
	 * 根据模板内容进行查询
	 */
	@Query(nativeQuery = true, value = "select * from assess_template where if(?1 !='',template_content like concat('%',?1,'%'),1=1)")
	Page<AssessTemplate> findByContentLike(String content, Pageable pageable);

	
}
