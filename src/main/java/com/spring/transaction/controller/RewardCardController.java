package com.spring.transaction.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.transaction.aspect.TrackTime;
import com.spring.transaction.model.RewardCard;
import com.spring.transaction.service.RewardCardService;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@RestController
@RequestMapping(value="/rewardCard/custom/")
public class RewardCardController {
	
	@Autowired private RewardCardService rewardCardService;
	
	@TrackTime
	@PostMapping(path = "/save")
	public @ResponseBody ResponseEntity<Object> save(@RequestBody(required=true) RewardCard rewardCard) throws Exception {
		String message = rewardCardService.save(rewardCard);
		return new ResponseEntity<Object>(message, HttpStatus.CREATED);
	}
	
	@TrackTime
	@PostMapping(path = "/saveAll")
	public @ResponseBody ResponseEntity<Object> saveAll(@RequestBody(required=true) List<RewardCard> rewardCards) throws Exception {
		List<RewardCard> list = rewardCardService.saveAll(rewardCards);
		return new ResponseEntity<Object>(list, HttpStatus.CREATED);
	}

	@PostMapping(path = "/update")
	public @ResponseBody ResponseEntity<Object> update(@RequestBody RewardCard rewardCard) throws Exception {
		String message = rewardCardService.update(rewardCard);
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

	@PostMapping(path = "/deleteById")
	public @ResponseBody ResponseEntity<Object> deleteById(@RequestParam(required = true, value = "rewardCardId") ObjectId rewardCardId) throws Exception {
		String message = rewardCardService.deleteById(rewardCardId);
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

	@GetMapping(path = "/getRewardCardById")
	public @ResponseBody ResponseEntity<Object> getRewardCardById(@RequestParam(required = true, value = "rewardCardId") ObjectId rewardCardId) throws Exception {
		RewardCard RewardCard = rewardCardService.getRewardCardById(rewardCardId);
		return new ResponseEntity<Object>(RewardCard, HttpStatus.OK);
	}
}
