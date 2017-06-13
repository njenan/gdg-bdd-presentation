Feature: Manage bookstore catalog
  As the owner of the bookstore
  I want to add books to the catalog
  In order to make all the money
  
  Scenario: Add book to catalog
    Given there are 2 books for sale
    When I add a new book to the catalog
    Then I should see 3 books for sale
    
  Scenario: Remove book from catalog
    Given there are 3 books for sale
    When I remove a book from the catalog
    Then I should see 2 books for sale
    
  Scenario: Can't add same book twice
    Given there is a unique book in the catalog
    When I add a book with the same title
    Then I should receive an error message
    And the book should not be created
    