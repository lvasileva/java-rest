Feature: Collection API for the Unsplash portal

  Here is the API docs: https://unsplash.com/documentation#collections

  @collections
  Scenario: Authorized user is able to create a new collection
    Given user is authorized
    When user creates new collection
    Then new user's collection is added

  @collections
  Scenario: Authorized user is able to update the collection
    Given user is authorized
    And user's collection with name "Collection to be updated" is exist
    When user updates the collection name to "Updated name"
    Then the collection name is updated

  @collections
  Scenario: Authorized user is able to delete the collection
    Given user is authorized
    And user's collection with name "Collection to be deleted" is exist
    When user deletes the collection
    Then the collection is deleted