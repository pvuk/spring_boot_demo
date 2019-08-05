package com.spring.transaction.util;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author venkataudaykiranp
 *
 */
@Slf4j
public class StringUtil {
	
		/**
	    * This method is for log print. 
	    * If parsing fails will return finalQuery otherwise parsed query will return.
	    * Replace parameter with value. For ex: customerId = :customerId with customerId = 2888.
	    * <pre>
	    * {@code @Autowired private JdbcTemplate jdbcTemplate;
	    * private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	    * @PostConstruct private void postConstruct() { namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);} 
	    * 
	    * String finalQuery = "select * from customer where customerId = : customerId";
	    * MapSqlParameterSource mapSqlParameter = new MapSqlParameterSource();
	    * if (customerId != null && customerId > 0L) {
	    * 	mapSqlParameter.addValue("customerId", customerId);
	    * }
	    * 
	    * List<Map<String, Object>> result = namedParameterJdbcTemplate.queryForList(finalQuery, mapSqlParameter);
	    * }</pre>
	    * @param finalQuery
	    * @param param {@link org.springframework.jdbc.core.namedparam.MapSqlParameterSource#getValues()}
	    * @return finalQuery / query (ex: select * from customer where customerId = : customerId; / select * from customer where customerId = 2762;)
	    */
		public static String replaceParamWithValue(String finalQuery, Map<String, Object> param) {
			Boolean parseFailed = false;
			String query = finalQuery;
			for (String key : param.keySet()) {
				Object value = param.get(key);
				if (Pattern.compile("\\b"+ key +"\\b").matcher(query).find()) {
					if (value != null) {
						
						//Inner class handling for ex: java.util.Arrays$ArrayList
						if (value.getClass().isMemberClass() && Modifier.isStatic(value.getClass().getModifiers())) {
							log.info("parsing parameter: {}", value.getClass().getName());
							try {
								query = query.replace(":"+ key, value != null ? Arrays.toString(((List<String>) value).toArray()).replaceAll("\\[|\\]", "") : null);
							} catch (Exception e) {
								log.error("Query Parsing Date Parameter: {} with value: {}. Error: {}", key, value, e.getMessage());
								parseFailed = true;
								break;
							}
							continue;
						}
						
						String vl = value.toString();
						//handling date parameters
						if (key.toLowerCase().indexOf("date") > 0) {
							try {
								query = query.replace(":"+ key, "'"+ vl +"'");
							} catch (Exception e) {
								log.error("Query Parsing Date Parameter: {} with value: {}. Error: {}", key, value, e.getMessage());
								parseFailed = true;
							}
							continue;
						}
						
						//handling multiple values
						if (vl.indexOf(",") > 0) {
							try {
								query = query.replace(":"+ key, "'"+ vl +"'");
							} catch (Exception e) {
								log.error("Query Parsing Date Parameter: {} with value: {}. Error: {}", key, value, e.getMessage());
								parseFailed = true;
								break;
							}
							continue;
						}
						
						try {
							query = query.replace(":"+ key, value != null ? vl : null);
						} catch (Exception e) {
							log.error("Query Parsing Parameter: {} with value: {}. Error: {}", key, value, e.getMessage());
							parseFailed = true;
							break;
						}
						
					} else {
						query = query.replace(":"+ key, null);
					}
				}
			}
			return (parseFailed != null && parseFailed) ? finalQuery : query;
		}
}
