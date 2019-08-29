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

===================================================================================================================================
##Notification																	
===================================================================================================================================
1*. Notify user before 3 / 2 / 1 - month / 15 days for MileStoneAcheivementFinalDate.
2. Notify friends available cc limit once payment is done those who are using cc.

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

===================================================================================================================================
##Maven - Task																	
===================================================================================================================================
1. Execute every operation using available maven commands

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

===================================================================================================================================
##MongoDB - Task																	
===================================================================================================================================
1. Implement the feature that MongoDB support of Long primaryKey
1.1 Maintain SequenceGenerator