Feature: Manage bookstore catalog
  As the owner of the bookstore
  I want to add books to the catalog
  In order to make all the money
  
  Scenario: Add book to catalog
    Given there are 2 books for sale
    When I add a new book to the catalog
    Then I should see 3 books for sale
    