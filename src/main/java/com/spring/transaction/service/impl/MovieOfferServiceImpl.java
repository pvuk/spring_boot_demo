package com.spring.transaction.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.service.MovieOfferService;

@Service
@Transactional(rollbackFor = Throwable.class)
public class MovieOfferServiceImpl implements MovieOfferService {

	
}
