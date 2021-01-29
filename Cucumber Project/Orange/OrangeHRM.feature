@OrangeActivities
Feature: Creating a job vacancy

  @CreateAJobVacancy
  Scenario: To create a job vacancy for â€œDevOps Engineerâ€�
  Given Open the OrangeHRM page and login with credentials provided
  And Navigate to the â€œRecruitmentâ€� page
  And Click on the â€œVacanciesâ€� menu item to navigate to the vacancies page
  And Click on the â€œAddâ€� button to navigate to the â€œAdd Job Vacancyâ€� form
  When Fill out the necessary details
  And Click the â€œSaveâ€� button to save the vacancy
  Then Verify that the vacancy was created
  And Close the browser
  
  @AddCandidateForRecruitment
  Scenario: Add information about a candidate for recruitment
  Given Open the â€‹OrangeHRMâ€‹ page and login with credentials provided
  And Navigate to the Recruitment page and click on the Add button to add candidateinformation
  When On the next page, fill in the details of the candidate
  And Upload a resume to the form and click SAVE
  Then Navigate back to the Recruitments page to confirm candidate entry
  And Close the browser
  @AddMultipleeEmployees
  Scenario Outline: Add multiple employees using an the Examples table
  Given Open the Orange HRM page and login with credentials provided
  When Find the PIM option in the menu and click it
  And Click the Add button to add a new Employee
  Then Fill the required fieds using data from Examples and repeatand click save "<FirstName>" and "<lastNmae>" and "<EmpID>" and "<userName>" and "<password>" and "<confirmPassword>" verify result
  And Close the browser
  
  Examples:
  | FirstName | lastNmae | EmpID  | userName | password    | confirmPassword |
  | Nayana8   | gowda8   | 9876 | nayana8  | nayana12345 | nayana12345     |
  | hadaass   | sdfgfg   | 6756 | ullao  | nayana12345 | nayana12345     |
  
  @CreateMulVacancy
  Scenario Outline: To create multiple vacancy
    Given Open the OrangeHRM page and login with credentials provided
    And Navigate to the Recruitment page
    And Click on the Vacancies menu item to navigate to the vacancies page
    And Click on the Add button to navigate to the Add Job Vacancy form
    When Fill out the necessary details "<Job_Title>" and "<Vacancy_name>" and "<Hiring_Manager>" and "<Positions>"
    And Click the Save button to save the vacancy
    Then Verify that the vacancy was created "<Vacancy_name>"
    And Close the browser
    Examples: 
      | Job_Title     | Vacancy_name | Hiring_Manager | Positions |
      | Rust Engineer | 12foodsl     | Hello Tester   |         3 |
      | Rust Engineer | devloper     | Hello Tester   |         6 |
