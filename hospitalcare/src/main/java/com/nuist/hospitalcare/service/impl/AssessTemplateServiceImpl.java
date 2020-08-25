package com.nuist.hospitalcare.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nuist.hospitalcare.dao.AssessTemplateRepository;
import com.nuist.hospitalcare.entity.AssessTemplate;
import com.nuist.hospitalcare.service.AssessTemplateService;

@Service
public class AssessTemplateServiceImpl implements AssessTemplateService {

	@Autowired
	private AssessTemplateRepository assessTemplateRepository;
	
	@Override
	public boolean insert(AssessTemplate assessTemplate) {
		if (assessTemplateRepository.existsById(assessTemplate.getTemplateId())) {
			return false;
		}
		try {
			assessTemplateRepository.save(assessTemplate);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(AssessTemplate assessTemplate) {
		try {
			assessTemplateRepository.save(assessTemplate);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Integer cid) {
		if (!assessTemplateRepository.existsById(cid)) {
			return false;
		}
		try {
			assessTemplateRepository.deleteById(cid);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public AssessTemplate findById(Integer id, Pageable pageable) {
		Optional<AssessTemplate> optional=assessTemplateRepository.findById(id);
		return optional.get();
	}

	@Override
	public Page<AssessTemplate> findByContentLike(String content, Pageable pageable) {
		return assessTemplateRepository.findByContentLike(content, pageable);
	}

	@Override
	public Page<AssessTemplate> findAll(Pageable pageable) {
		return assessTemplateRepository.findAll(pageable);
	}

}
