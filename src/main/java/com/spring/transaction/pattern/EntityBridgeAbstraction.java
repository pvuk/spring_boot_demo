package com.spring.transaction.pattern;

public interface EntityBridgeAbstraction {
	
	public Object save(Object save);
	
	public Object getById(Object id);
	
	public Object update(Object update);
	
	public Object delete(Object delete);
}
