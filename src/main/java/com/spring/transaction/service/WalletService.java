package com.spring.transaction.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.spring.transaction.model.Wallet;

public interface WalletService {

	String save(Wallet wallet) throws Exception;

	List<Wallet> saveAll(List<Wallet> wallets) throws Exception;

	String update(Wallet wallet) throws Exception;

	String deleteById(ObjectId walletId) throws Exception;

	Wallet getById(ObjectId walletId) throws Exception;

}
