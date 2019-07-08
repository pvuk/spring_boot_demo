package com.spring.transaction.model.audit;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.transaction.util.DateTimeUtil;

/**
 * Provides timestamps to the {@link AuditListener}.
 * 
 * @author venkataudaykiranp
 *
 */
@Component
@BasePathAwareController
public class AuditingTimestampProvider implements DateTimeProvider {
 
	@Autowired
	private DateTimeUtil dateTimeUtil;
    
    public AuditingTimestampProvider() {
        this.dateTimeUtil = new DateTimeUtil();
    }
    
    public AuditingTimestampProvider(DateTimeUtil dateTimeUtil) {
        this.dateTimeUtil = dateTimeUtil;
    }
 
    @Override
    public Optional<TemporalAccessor> getNow() {
    	ZonedDateTime nowZdt = dateTimeUtil.getCurrentDateAndTime();
    	return Optional.of(nowZdt);
    }
    
    @RequestMapping(value = "/server-time", method = RequestMethod.GET)
   	@ResponseBody
    public Map<String,Object> getCurrentTimeStamp(){
    	Map<String,Object> returnMap = new HashMap<String, Object>();
    	returnMap.put("timeStamp", LocalDateTime.from(getNow().get()));
    	returnMap.put("timeZone", ZoneId.from(getNow().get()).getId());
    	
    	return returnMap;
    }
    
    
    public Date getCurrentTime(){
    	Date in = new Date();
    	LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), dateTimeUtil.getCurrentDateAndTime().getZone());
    	Date out = Date.from(ldt.atZone(dateTimeUtil.getCurrentDateAndTime().getZone()).toInstant());
    	in = null;
    	ldt = null;
    	return out;
    }
    
    
}