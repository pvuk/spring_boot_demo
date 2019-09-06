package com.spring.transaction.aspect;

import org.aspectj.lang.annotation.Pointcut;

/**
 * 
 * <p>
 * 	One AOP best practice is to define a common class to store all the pointcuts. This helps in maintaining the pointcuts in one place.
 * </p>
 * 
 * @author venkataudaykiranp
 * 
 *
 */
public class CommonCRUDJoinPointConfig {
	
	@Pointcut(value="execution(* com.spring.transaction.controller.*.get*())") public void allGetLayerExecution() {};
	
	@Pointcut(value="execution(* com.spring.transaction.controller.*.save*(..))") public void saveLayerExecution() {};
	
	@Pointcut("within(@org.springframework.stereotype.Controller *)") public void controller() {}

	@Pointcut("execution(* *.*(..))") protected void allMethod() {}
	
	@Pointcut("execution(* com.spring.transaction.controller.*.*()) && !@annotation(com.spring.transaction.aspect.NoLogging)") public void excludeMethods() {};
}
