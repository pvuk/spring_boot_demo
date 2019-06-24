package com.spring.transaction.exception;

/**
 * 
 * @author udaykiran pulipati
 *
 *<h1>Response Statuses for Errors</h1>
 *<ul>
	<li>500 - SERVER ERROR</li>
</ul>
 */
public class InternalServerError extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InternalServerError(String exception) {
		super(exception);
	}
}
