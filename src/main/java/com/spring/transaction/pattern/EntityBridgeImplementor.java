package com.spring.transaction.pattern;

public interface EntityBridgeImplementor {

	public Object saveModel(Object save);

	public Object getModelById(Object id);

	public Object updateModel(Object update);

	public Object deleteModel(Object delete);
	
	public Object deleteModelById(Object id);
}
