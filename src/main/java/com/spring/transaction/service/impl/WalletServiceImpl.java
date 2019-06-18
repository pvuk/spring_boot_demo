package com.spring.transaction.service.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.model.Wallet;
import com.spring.transaction.repository.WalletRepository;
import com.spring.transaction.service.WalletService;
import com.spring.transaction.validator.MessageConstants;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class WalletServiceImpl implements WalletService {
	
	@Autowired private WalletRepository walletRepo;
	@Autowired private MongoTemplate mongoTemplate;
	
	@Override
	public String save(Wallet wallet) throws Exception {
		try {
			wallet = walletRepo.insert(wallet);
			if (wallet.getWalletId() == null) {
				String bankTypeId = mongoTemplate.find(new Query(Criteria.where("CODE").is(wallet.getCode())), Wallet.class).get(0).getWalletId();
				if (bankTypeId == null) {
					wallet = walletRepo.insert(wallet);
				} else {
					log.warn("Wallet: {} is trying to insert again", wallet.getDescription());
				}
			} else {
				log.warn("Wallet: {} is trying to update", wallet.getDescription());
			}
		} catch (Exception e) {
			log.error("save: {}", e.getMessage());
			throw new Exception(MessageConstants.Failed.SAVE +" Cause: "+ e.getMessage());
		}
		return MessageConstants.Success.SAVE;
	}

	@Override
	public List<Wallet> saveAll(List<Wallet> wallets) throws Exception {
		if (wallets != null && wallets.size() > 0) {
			for (Wallet wallet : wallets) {
				save(wallet);
			}	
		} else {
			throw new Exception(MessageConstants.Failed.SAVE +" Cause: Saving empty data.");
		}
		return wallets;
	}

	@Override
	public String update(Wallet wallet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteById(ObjectId walletId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Wallet getById(ObjectId walletId) {
		// TODO Auto-generated method stub
		return null;
	}

}
