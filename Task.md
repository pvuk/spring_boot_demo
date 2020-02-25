===================================================================================================================================
##Concept																	
===================================================================================================================================
1. Work on Validation groups(@NotNull) and Group Sequences
2. Write some services using Spring projection.
3. Validate Mandatory fields at API side using Spring Validation.

===================================================================================================================================
#Feature - Task																	
===================================================================================================================================
1. Implement the feature to support multiple databases to handle CRUD operations.
2. Delete - Use Response status as 204

===================================================================================================================================
#New API / Tool / Framework - Task																	
===================================================================================================================================
1. [LIQUIBASE](https://www.liquibase.org/) - Liquibase is the leading open source tool for database schema change management.
Liquibase helps teams track, version, and deploy database schema and logic changes.

===================================================================================================================================
##Notification																	
===================================================================================================================================
1. * Notify user before 3 / 2 / 1 - month / 15 days for MileStoneAcheivementFinalDate.
2. Once payment is done Notify / BlockNotification to Family / friends available cc limit those who are using cc.
	* If BlockNotification enable don't show payment details and available limit.
3. Once Rewards are added into REWARD_POINTS_EARNED table insert expire details in REMAINDER_REWARD_POINTS_EXPIRE table
	* check whether reward points are redeemed or not. If not redeemed notify before 2 months / 1 month / 15 days / 1 week / 4 days / 2 days / 1 day.
	* If user redeemed at 15 days or in between any of above remainder notification stop notify the user.
	* Notify user auto redeem option available in Rewards Redeem Screen.
	* Implement auto redeem option if user is forgot to redeem last day.
		* User should select Merchants to auto redeem.	

===================================================================================================================================
##Spring - Task																	
===================================================================================================================================
1. Implement repo call getAllBankBranchesByBankId
2. Work on [@RestResource](https://docs.spring.io/spring-data/rest/docs/current/reference/html/#customizing-sdr.overriding-sdr-response-handlers)

	`Ex: @RepositoryRestResource(path = "people", rel = "people")
	interface PersonRepository extends CrudRepository<Person, Long> {
	
	  @Override
	  @RestResource(exported = false)
	  void delete(Long id);
	
	  @Override
	  @RestResource(exported = false)
	  void delete(Person entity);
	}`
3. Post Data and using Repo (Spring REST) save it in database using postman. URL `http://localhost:8102/springbootmongo/api/creditCard`
4. Spring JPA - Fetch data by passing two parameters as input and order by param1Desc param2Asc
	4.1 CurrencyRate findFirstByCurrencyIdAndFiscalPeriodIdOrderByFiscalPeriodIdDescCurrencyIdAsc(@Param("currencyId") Long currencyId, @Param("fiscalPeriodId") Long fiscalPeriodId);
5. Implement task on spring-boot-starter-actuator

===================================================================================================================================
##Maven - Task																	
===================================================================================================================================
1. Execute every operation using available Maven commands

===================================================================================================================================
##UI: Validation - Task																	
===================================================================================================================================
1. If CAPSLOCK is on show warning message beside Textbox(CAPSLOCK is on) to alert the user. User is trying to enter their password in CAPSLOCK mode.
1.1 If and only if before enter into the site, if the CAPSLOCK is on then warning should be display.
1.2 When the first time the textbox is empty and no alphanumeric values in password control then warn the user.
2. Provide info about control if needed. Provide icon info when user place cursor information regarding that control should be displayed. 
2.a Ref: https://personal-loan.gosahi.com/employment-details

===================================================================================================================================
##Java - Task																	
===================================================================================================================================
1. Write @annotation that reads all variable names and when insert into database columns should be created as capital letters.
2. Implement default method functionality without breaking old code in interfaces.
3. Read .html file from url / local., In this page word contains url link image., read the data then after.. until then next new word when synonym comes.
	Ex:	Save it with file name Inquisitor +(Telugu Meaning).txt.
4. When bill is calculated provide calculate button to know user before saving the record.
5. Implement GenericsMultipleTypeExample<T, U, K> type, it is useful in project
6. 5) Why char array is better than String for storing password?
This String interview question is debatable and you might not agree with interviewer but this is also a chance to show that how deep and differently you can think of. One of the reasons which people give Why you should store a password in char array over String is related to immutability since it's not possible to erase contents of String but you can erase contents of a char array. See Why char array preferred over String for a password for a complete discussion.

Read more: https://javarevisited.blogspot.com/2012/10/10-java-string-interview-question-answers-top.html#ixzz6C1UktSXi

===================================================================================================================================
##MongoDB - Task																	
===================================================================================================================================
1. Implement the feature that MongoDB support of Long primaryKey
1.1 Maintain SequenceGenerator
2. Before insert create index on collections through JSON.insert(file);
3. Insert CREDIT_CARD_ID as primary key if exist else MongoDB take care of create new _id.

===================================================================================================================================
##Threading - Task
===================================================================================================================================
1. Write a thread to execute all methods using wait, notify to insert / update CODE documents data.

===================================================================================================================================
##Cartography - Task
===================================================================================================================================
1. Implement location tag, location find(where the user stays more often), navigation, recent visited places.

===================================================================================================================================
#Statement - Task																	
===================================================================================================================================
1. If statement(s) generated on Sep 2019 month then some bills are on same month and some bills on Oct 2019 month 
	show the user current month bills total due amount from 1st date to till last date of month i.e., 28th /30th /31st.
	1.1. If Statement generated on 02-Sep-2019 and due date is 22-Sep-2019
	1.2. If Statement generated on 25-Sep-2019 and due date is 12-Oct-2019
	1.3. From 1.1. and 1.2. the statements are generated on Sep 2019 month but 1.2. statement due date on next month(Oct 2019),
			  User should display default date from 01-Sep-2019 to 12-Oct-2019 with total amount due.
	1.4. Show the user last month paid bills amount as notification. From 01-Sep-2019 to 30-Sep-2019.
	1.5. Sometimes user have to pay Oct 2019 bills on same month, at that time notify the user as alert.
		1.5.1. All the statements are generated on Sep 2019 month, payment of bills some are in same month and some are in next month,
				notify the user how much amount he need to pay in Oct month(01-10-2019 to 31-10-2019).
		1.5.2 Along with Sep bills(exclude paid bills of same month) which need to pay in next month(Oct 2019) + Oct generated bills(Need to pay in same month),
				show the user current month paid bills(Sep bills + Oct bills)
2. For example SBI bill ₹5,000.00 generated on 02-09-2019 due date 22-09-2019, ICICI bill ₹1,000.00 generated on 25-09-2019 due date 12-10-2019,
	SBI bill ₹2,000.00 generated on 02-10-2019 due date 22-10-2019, in this case follow below steps
	2.1. Total bill of Sep 2019 month: ₹5000 + ₹1000 = ₹6000.
	2.2. Total payment of Sep 2019 month: ₹5000 = ₹5000.
	2.3. Total payment of Oct 2019 month: ₹1000 + ₹2000 = ₹3000.
	2.4. Total amount need to pay Sep 2019 bills: ₹5000. (exclude Oct 2019 bills)
	2.5. Total amount need to pay Oct 2019 bills: ₹3000. (include Sep 2019 bills + Oct 2019 generated bill which need to pay in same month)
	
===================================================================================================================================
#UI - Task
===================================================================================================================================
1. Load Country dropdown with reference of following url, http://bit.ly/35xEbyM. Dropdown contains Country flag with Dialing code.

===================================================================================================================================
#REST - Task
===================================================================================================================================
1. work on Status types 200 (OK) or 204 (No Content).

===================================================================================================================================
#Pending Document Relation Task
===================================================================================================================================
1. Relate PAYMENT_ON_REWARD_POINTS with REWARD_POINTS_CATALOGUE and REWARD_POINTS_CAP when capping arises(SBI Debit card capping).
	1.1 Remove unnecessary columns.
2. Remove unnecessary / wrong naming columns in WALLET_STATEMENT_TRANSACTION

===================================================================================================================================
#Error Tracking In Project
===================================================================================================================================
1. [Java error tracking with Sentry](https://sentry.io/for/java/).<sub>Debug Java apps and prevent crashes across your entire stack.</sub>