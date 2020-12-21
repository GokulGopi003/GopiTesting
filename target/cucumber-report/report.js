$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("target/test-classes/features/web/WebRegister.feature");
formatter.feature({
  "name": "REGISTER:- As a new customer I would like to register so I can : -",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@gui"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Negative combinations for user login scenarios",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "i navigate to the website \"HOME\" page",
  "keyword": "Given "
});
formatter.step({
  "name": "i click \"SIGN_IN\" on the Home Page",
  "keyword": "When "
});
formatter.step({
  "name": "i enter loginId \"\u003cloginId\u003e\" and password \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "i click on Sign In button on the Login Page",
  "keyword": "And "
});
formatter.step({
  "name": "i can see the validation message \"\u003cvalidationMessage\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "loginId",
        "password",
        "validationMessage"
      ]
    },
    {
      "cells": [
        "invalid",
        "invalid",
        "error.incorrectDetails"
      ]
    },
    {
      "cells": [
        "",
        "",
        "error.enterLogin"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Negative combinations for user login scenarios",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@gui"
    }
  ]
});
formatter.step({
  "name": "i navigate to the website \"HOME\" page",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "i click \"SIGN_IN\" on the Home Page",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "i enter loginId \"invalid\" and password \"invalid\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "i click on Sign In button on the Login Page",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "i can see the validation message \"error.incorrectDetails\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "Negative combinations for user login scenarios",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@gui"
    }
  ]
});
formatter.step({
  "name": "i navigate to the website \"HOME\" page",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "i click \"SIGN_IN\" on the Home Page",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "i enter loginId \"\" and password \"\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "i click on Sign In button on the Login Page",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "i can see the validation message \"error.enterLogin\"",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});