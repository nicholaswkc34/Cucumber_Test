$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/com/peterwkc/Feature/Login.feature");
formatter.feature({
  "name": "Login to PHP Travel",
  "description": "Description:  As a user, I want login to PHP Travel ",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Login_Valid"
    }
  ]
});
formatter.scenario({
  "name": "Valid Login",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Login_Valid"
    }
  ]
});
formatter.step({
  "name": "PHP Travel Home Page opens in browser",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I login to PHP Travel with Username and Password",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Page navigate to PHP Travel Home Page",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});