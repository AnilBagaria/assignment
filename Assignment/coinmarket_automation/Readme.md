How to run this test suit:


To execute all the API tests  $ mvn clean verify -Dcucumber.options="--tags @apiTask" 

To execute all the UI tests  $ mvn clean verify -Dcucumber.options="--tags @uiTask" 

By default, the tests will run using Chrome.

