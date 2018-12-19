package com.spring.transaction.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author venkataudaykiranp
 * 
 * <h1>Response Statuses for Errors</h1>
Use appropriate status code based on the error.

<ul>
<li>404 - RESOURCE NOT FOUND</li>
<li>400 - BAD REQUEST</li>
<li>401 - UNAUTHORIZED</li>
<li>415 - UNSUPPORTED TYPE - Representation not supported for the resource</li>
<li>500 - SERVER ERROR</li>
</ul>
Let’s consider a few HTTP Methods:
<ul>
	<li>GET : Should not update anything. Should be idempotent (same result in multiple calls). Possible Return Codes 200 (OK) + 404 (NOT FOUND) +400 (BAD REQUEST)</li>
	<li>POST : Should create new resource. Ideally return JSON with link to newly created resource. Same return codes as get possible. In addition - Return code 201 (CREATED) can be used.</li>
	<li>PUT : Update a known resource. ex: update client details. Possible Return Codes : 200(OK) + 404 (NOT FOUND) +400 (BAD REQUEST)</li>
	<li>DELETE : Used to delete a resource. Possible Return Codes : 200(OK).</li>
</ul>
<blockquote style="border-left: 5px solid #7a7a7a; font-style: italic; margin-left: 2rem; padding: 2rem;">
  <p>500 - SERVER ERROR is possible with all the above HTTP methods. In the case of a 500, include the contact details of the help desk in the response.</p>
</blockquote>
Ref: <a href="http://www.springboottutorial.com/spring-boot-exception-handling-for-rest-services">spring-boot-exception-handling-for-rest-services</a>
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	public NotFoundException(String exception) {
		super(exception);
	}
}
