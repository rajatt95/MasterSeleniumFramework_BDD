#/**
#* @author Rajat Verma
#* https://www.linkedin.com/in/rajat-v-3b0685128/
#* https://github.com/rajatt95
#* https://rajatt95.github.io/
#*
#* Course: Cucumber BDD Masterclass with Selenium 4 & Java + Framework (https://www.udemy.com/course/cucumber-bdd-masterclass/)
#* Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)
#*/
#
#/***************************************************/
#
@regression
Feature: Place an order

	@sanity @bvt
  Scenario: using default payment option
    Given I'm a guest customer
    And my billing details are
      | firstname | lastname | country            | address_line1     | city  | state | zip   | email              |
      | demo      | user     | United States (US) | 6300 Spring Creek | Plano | Texas | 75024 | askomdch@gmail.com |
    And I have 1 "Blue Shoes" in the cart
    And I'm on the Checkout page
    When I provide billing details
    And I place an order
    Then the order should be placed successfully