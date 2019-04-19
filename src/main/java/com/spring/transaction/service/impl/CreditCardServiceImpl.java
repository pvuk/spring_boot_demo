package com.spring.transaction.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.service.CreditCardService;

@Service
@Transactional(rollbackFor = Throwable.class)
public class CreditCardServiceImpl implements CreditCardService {

}
