# Anagram Rest API  
@Author ravi4j

  ### Spring Boot and Java 8

    ### Api Endpoint( method = GET ) 
    ####/anagrams/{string1}/{string2}
    
    ### Run Test ( required Maven 3)
        mvn test  
        
    ### Anagram Service 
        AnagrameService - Implements the algorithm to test anagrams words
        AnagramServiceTest - Unit TestCases 
        
    ###
       Anagrams Rest API
         AnagramsController - Expose the AnagramService as a GET methot at /anagrams/{string1}/{string2}
         AnagramsControllerTest - Unit and Integration test cases for endpoint. 
         CommonExceptionHandlerControllerAdciceTest - TestCases for handling common rest api exceptions.
                