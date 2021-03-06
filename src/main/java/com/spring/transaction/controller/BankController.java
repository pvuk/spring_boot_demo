package com.spring.transaction.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.transaction.aspect.TrackTime;
import com.spring.transaction.model.Bank;
import com.spring.transaction.service.BankService;
import com.spring.transaction.service.CRUDOperationService;
import com.spring.transaction.service.data.BankDataService;
import com.spring.transaction.util.CodeTableConstants;

@BasePathAwareController
@RequestMapping("/bank/custom")
public class BankController {

	@Autowired
	private BankService bankService;

	/**
	 * We are injecting a CRUDOperationService bean into the crudOperationService
	 * field. The @Qualifier("bankService") specifies that it is a BankServiceImpl
	 * bean.
	 * 
	 * <a href="http://appsdeveloperblog.com/autowired-and-qualifier-in-spring/">
	 * Let’s have a look at an example which will work very well if @Qualifier
	 * annotation is used together with @Autowired and will throw an
	 * NoUniqueBeanDefinitionException if the @Qualifier annotation is not used.
	 * </a>
	 */
	@Autowired
	@Qualifier(value = CodeTableConstants.Bean.BANK_SERVICE) 							private CRUDOperationService crudOperationService;

	@Autowired
	@Qualifier(value = CodeTableConstants.Bean.PUBLIC_BANK_BANKTYPE)					private BankDataService publicBankDataService;

	@Autowired
	@Qualifier(value = CodeTableConstants.Bean.PRIVATE_BANK_BANKTYPE)					private BankDataService privateBankDataService;

	/**
	 * <p>
	 * <ol>
	 * <li>@PostMapping is specialized version of @RequestMapping annotation that
	 * acts as a shortcut for @RequestMapping(method =
	 * RequestMethod.POST). @PostMapping annotated methods handle the HTTP POST
	 * requests matched with given URI expression. e.g.</li>
	 * <li>@PostMapping annotation was introduced in Spring 4.3 version.</li>
	 * <li><a href="https://www.w3.org/Protocols/rfc2616/rfc2616-sec9.html#sec9.5">If a resource has been created</a> on the origin server, the response SHOULD
	 * be 201 (Created) and contain an entity which describes the status of the
	 * request and refers to the new resource</li>
	 * </ol>
	 * <p>
	 * 
	 * @param bank
	 * @return message
	 */
	@TrackTime
	@PostMapping(path = "/save")
	public @ResponseBody ResponseEntity<Object> save(@RequestBody(required = true) Bank bank) throws Exception {
		String message = crudOperationService.save(bank);
		return new ResponseEntity<Object>(message, HttpStatus.CREATED);
	}

	@TrackTime
	@PostMapping(path = "/saveAllBanks")
	public @ResponseBody ResponseEntity<Object> saveAll(@RequestBody(required = true) List<Object> banks)
			throws Exception {
		List<Object> list = crudOperationService.saveAll(banks);
		return new ResponseEntity<Object>(list, HttpStatus.CREATED);
	}

	/**
	 * <p>
	 * 	<ol>
	 * 		<li>@PutMapping annotation is used for mapping HTTP PUT requests onto specific handler methods. If you want to update existing data use @PutMapping annotation.</li>
	 * 	</ol>
	 * </p>
	 * 
	 * @param bankId
	 * @param bank
	 * @return
	 * @throws Exception
	 */
	@PutMapping(path = "/update/{bankId}")
	public @ResponseBody ResponseEntity<Object> update(
			@PathVariable(value = "bankId", required = true) String bankId, @RequestBody Bank bank) throws Exception {
		String message = crudOperationService.update(bankId, bank);
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

	/**
	 * <p>
	 * 	<ol>
	 * 		<li>@DeleteMapping annotation is handled HTTP DELETE request.</li>
	 * 	</ol>
	 * </p>
	 * @param bankId
	 * @return message
	 * @throws Exception
	 */
	@DeleteMapping(path = "/deleteBankById")
	public @ResponseBody ResponseEntity<Object> deleteBankById(
			@RequestParam(required = true, value = "bankId") ObjectId bankId) throws Exception {
		String message = crudOperationService.deleteById(bankId);
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

	/**
	 * <p>
	 * <ol>
	 * 	<li>@GetMapping is specialized version of @RequestMapping annotation that acts as
	 *             a shortcut for @RequestMapping(method =
	 *             RequestMethod.GET). @GetMapping annotated methods handle the HTTP
	 *             GET requests matched with given URI expression. e.g. see method</li>
	 * 	<li>@GetMapping annotation was introduced in Spring 4.3 version.</li>
	 * </ol>
	 * <p>
	 * @param bankId
	 * @return bank
	 */
	@GetMapping(path = "/getById")
	public @ResponseBody ResponseEntity<Object> getById(
			@RequestParam(required = true, value = "bankId") String bankId) {
		Bank bank = (Bank) crudOperationService.getById(new ObjectId(bankId));
		return new ResponseEntity<Object>(bank, HttpStatus.OK);
	}

	@RequestMapping(path = "/getAllBanks", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<Object> getAllBanks() {
		List<Bank> banks = bankService.getAllBanks();
		return new ResponseEntity<Object>(banks, HttpStatus.OK);
	}

	@RequestMapping(path = "/getPublicBanks", method = RequestMethod.GET)
	public ResponseEntity<List<Bank>> getPublicBanks() {
		List<Bank> list = publicBankDataService.getBanks();
		return new ResponseEntity<List<Bank>>(list, HttpStatus.OK);
	}

	@RequestMapping(path = "/getPrivateBanks", method = RequestMethod.GET)
	public ResponseEntity<Object> getPrivateBanks() {
		List<Bank> list = privateBankDataService.getBanks();
		return new ResponseEntity<Object>(list, HttpStatus.OK);
	}
}
