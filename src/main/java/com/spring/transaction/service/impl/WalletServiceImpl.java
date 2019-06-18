package com.spring.transaction.service.impl;

import java.util.List;
import java.util.Optional;

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
	public String update(Wallet wallet) throws Exception {
		try {
			if (wallet.getWalletId() != null) {
				String bankTypeId = mongoTemplate.find(new Query(Criteria.where("CODE").is(wallet.getCode())), Wallet.class).get(0).getWalletId();
				if (bankTypeId != null) {
					wallet = walletRepo.save(wallet);
				} else {
					log.warn("Wallet: {} is not found", wallet.getDescription());
				}
			} else {
				log.warn("Wallet: {} is trying to insert", wallet.getDescription());
			}
		} catch (Exception e) {
			log.error("update: {}", e.getMessage());
			throw new Exception(MessageConstants.Failed.UPDATE +" Cause: "+ e.getMessage());
		}
		return MessageConstants.Success.SAVE;
	}

	@Override
	public String deleteById(ObjectId walletId) throws Exception {
		try {
			walletRepo.deleteById(walletId);
		} catch (Exception e) {
			log.error("deleteById: {}", e.getMessage());
			throw new Exception(MessageConstants.Failed.DELETE +" Cause: "+ e.getMessage());
		}
		return MessageConstants.Success.DELETE;
	}

	@Override
	public Wallet getById(ObjectId walletId) throws Exception {
		Wallet wallet = null;
		try {
			Optional<Wallet> findById = walletRepo.findById(walletId);
			wallet = findById.isPresent() ? findById.get() : null;
		} catch (Exception e) {
			log.error("deleteById: {}", e.getMessage());
			throw new Exception(MessageConstants.Failed.GET +" Cause: "+ e.getMessage());
		}
		return wallet;
	}

}
