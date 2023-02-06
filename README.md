# java-rest-cucumber demo project

This project is configured to run only with GitHub Actions. The test run is scheduled to be started at 10:00 UTC on every Monday. The badge is presented the last state of the run. [![Java CI with Maven](https://github.com/lvasileva/java-rest-cucumber/actions/workflows/maven.yml/badge.svg?branch=main)](https://github.com/lvasileva/java-rest-cucumber/actions/workflows/maven.yml)

Here is the project of cucumber features running API tests for the unsplash site at: https://unsplash.com/. The API documentation can be found here: https://unsplash.com/documentation. Unfortunately, for the demo-apps rate-limit is set to **50 requests per hour**. So please keep it in mind.

The project contains only one feature for Collections API with the following taks:
1. Create new collection and verify it appears.
2. Update user's collection name and verify it changes.
3. Delete users's collection and verify it deletes.
