# Anagram Rest API  
@Author ravi4j

      

  ### Spring Boot and Java 8
  
   ### Api Endpoint( method = GET ) 
          /anagrams/{string1}/{string2}
          
    Clone Repository
         https://github.com/ravi4j/anagrams.git
    
    Inside clone folder
        Run Test ( required Maven 3)
            mvn test  
        
      
        Run Application
            mvn clean install
            java -jar target/com.anagrams-1.0-SNAPSHOT.jar
           
           Access Application 
                http://localhost:8080/anagrams/DAS/SAD
              
        
        1. Anagram Service 
            AnagrameService - Implements the algorithm to test anagrams words
            AnagramServiceTest - Unit TestCases 
        
        2. Anagrams Rest API
             AnagramsController - Expose the AnagramService as a GET method at /anagrams/{string1}/{string2}
            AnagramsControllerTest - Unit and Integration test cases for endpoint. 
            CommonExceptionHandlerControllerAdciceTest - TestCases for handling common rest api exceptions.
                