package com.spring.transaction.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.spring.transaction.model.BankBranch;

public interface BankBranchService {
	
	String saveBankBranch(BankBranch bankBranch) throws Exception;

	String updateBankBranch(BankBranch bankBranch) throws Exception;

	String deleteBankBranchById(ObjectId bankBranchId);

	BankBranch findByBankBranchId(ObjectId bankBranchId);

	List<BankBranch> getAllBankBranches();
}
