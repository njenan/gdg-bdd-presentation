Feature: Browse Bookstore
  As an avid reader
  I want to buy my books online
  In order to spend more time reading
  
  Scenario: Get Catalog List
    Given there are 3 books for sale
    When I request the book catalog
    Then I should see 3 books