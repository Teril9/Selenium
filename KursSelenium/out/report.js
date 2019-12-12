$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("google-text-search.feature");
formatter.feature({
  "line": 1,
  "name": "Google search",
  "description": "",
  "id": "google-search",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "user can search any keyword",
  "description": "",
  "id": "google-search;user-can-search-any-keyword",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "an open browser with google.com",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "a keyword selenium is entered in input field",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "the first one should contain selenium",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "close browserFeature",
  "keyword": "And "
});
formatter.match({
  "location": "GoogleSearch.anOpenBrowserWithGoogleCom()"
});
formatter.result({
  "duration": 7758119438,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "selenium",
      "offset": 10
    }
  ],
  "location": "GoogleSearch.aKeywordSeleniumIsEnteredInInputField(String)"
});
formatter.result({
  "duration": 3814455531,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSearch.theFirstOneShouldContainSelenium()"
});
formatter.result({
  "duration": 24249,
  "status": "passed"
});
formatter.match({
  "location": "GoogleSearch.closeBrowserFeature()"
});
formatter.result({
  "duration": 160768182,
  "status": "passed"
});
formatter.uri("profile.feature");
formatter.feature({
  "line": 1,
  "name": "Change user information after login",
  "description": "",
  "id": "change-user-information-after-login",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "Change user birthday date, gender and sign up for a newsletter",
  "description": "",
  "id": "change-user-information-after-login;change-user-birthday-date,-gender-and-sign-up-for-a-newsletter",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "User is logged in to CodersLab shop",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "He goes to UserInformationPage",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "He signs up for our newsletter",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "He saves information",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "He sees \"Information successfully updated.\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});