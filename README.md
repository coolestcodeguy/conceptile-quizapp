# conceptile-quizapp
Quiz app built in springboot

## Setup and Run
1. Clone the repository
2. Run `mvn spring-boot:run`
3. Access H2 Console at `/h2-console`

# API Endpoints

## Start Quiz

URL: /quiz/start <br>
Method: GET <br>
Description: Initializes a new quiz session <br>

Note : sessionId will be 1 for first session, 2 for second and so on...

## Get Question

URL: /quiz/question<br>
Parameters: sessionId<br>
Method: GET<br>
Description: Retrieves a random question for the session<br>

## Submit Answer

URL: /quiz/submit<br>
Parameters: sessionId, selectedOptionIndex<br>
Method: POST<br>
Description: Submits an answer and updates session statistics<br>

## Get Results

URL: /quiz/results<br>
Parameters: sessionId<br>
Method: GET<br>
Description: Retrieves current quiz session statistics<br>

## Database

Uses H2 in-memory database<br>
Console available at: http://localhost:8080/h2-console<br>
JDBC URL: jdbc:h2:mem:quizdb<br>
Username: sa<br>
Password: password
