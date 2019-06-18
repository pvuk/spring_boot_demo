package com.spring.transaction.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.spring.transaction.model.BankBranch;

public interface BankBranchService {
	
	BankBranch getBankBranchById(ObjectId bankBranchId) throws Exception;
	
	String save(BankBranch bankBranch) throws Exception;
	
	List<BankBranch> saveAll(List<BankBranch> bankBranchs) throws Exception;
	
	String update(BankBranch bankBranch) throws Exception;
	
	String deleteById(ObjectId bankBranchId) throws Exception;

	List<BankBranch> getAllBankBranches();
}
