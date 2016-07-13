Scenario: Retrieve next prayer time
Given the next prayer time is 18:00:00
When the prayer retrieval service is asked to retrieve the next prayer time
Then time of 18:00:00 is provided