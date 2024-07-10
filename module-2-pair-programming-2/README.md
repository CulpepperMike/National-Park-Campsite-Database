# Week 2 Review: National Park Campsite (Part 2)

In this exercise, you'll continue working with the National Park Campsite Reservation database. 

You'll create DAO methods and integration tests to continue practicing writing application code that interacts with a database.

## Getting started

1. If you do not have a database named `campground`, create it now.
2. In the `database` folder, there's a `campground.sql` SQL script that drops and recreates the tables and data in the `campground` database. You can run that script to create a copy of the database to reference while you work. Be aware, however, that the tests don't use that database. The tests use a temporary database with the same structure. You'll find the SQL for that temporary database in `src/test/resources/test-data.sql`.
3. Open the DAO exercises project in IntelliJ.

## Step One: Explore starting code and database schema

Before you begin, review the provided classes in the `model` and `dao` packages.

You'll write code to complete and test the data access methods in the `JdbcCampgroundDao`, `JdbcParkDao`, `JdbcReservationDao`, and `JdbcSiteDao` classes.

You can explore the database in pgAdmin, read through the `database/campground.sql`, and view the provided ERD diagram in the `database` folder to familiarize yourself with the database and its schema.

The integration tests are in the directory `src/test/java/com/techelevator/dao`. There's a `BaseDaoTests` class that all other test classes inherit from. This base class along with the `TestingDatabaseConfig` class take care of the following:

- Creates a new temporary database and a `DataSource` connection to it.
- Loads test data.
- Rolls back any changes to the temporary database after each test has completed.
- Drops the temporary database after all tests have completed.

## Step Two: Implement the `JdbcCampgroundDao` methods

Complete the data access methods in `JdbcCampgroundDao`: `getCampgroundById()` and `getCampgroundsByParkId()`. Refer to the documentation comments in the `CampgroundDao` interface for the expected input and output of these methods.

When you have `getCampgroundById()` implemented correctly, the `getCampgroundById_Should_Return_Specific_Campground` integration test passes.

You'll need to write the integration test for `getCampgroundsByParkId()`. Find the `getCampgroundsByParkId_Should_Return_All_Campgrounds_For_Park` integration test and replace the `Assert.fail()` with an integration test that verifies your method functions properly.

Use the data in the `resources/test-data.sql` file to create your integration test.

## Step Three: Implement the `JdbcParkDao` methods

Complete the data access method in `JdbcParkDao`: `getParks()`. Refer to the documentation comments in the `ParkDao` interface for the expected input and output of this method.

You'll need to write the integration test for `getParks()`. Find the `getParks_Should_Return_All_Parks` integration test and replace the `Assert.fail()` with an integration test that verifies your method functions properly.

Use the data in the `resources/test-data.sql` file to create your integration test.

## Step Four: Implement the `JdbcReservationDao` methods

There are two methods to implement in `JdbcReservationDao`: `getReservationById()` and `createReservation()`. Refer to the documentation comments in the `ReservationDao` interface for the expected input and output of these methods.

When you have `createReservation()` implemented correctly, the `createReservation_Should_Return_Reservation_With_New_Id` integration test passes.

You'll need to write the integration test for `getReservationById()`. Find the `getReservationById_Should_Return_Specific_Reservation` integration test and replace the `Assert.fail()` with an integration test that verifies your method functions properly.

Use the data in the `resources/test-data.sql` file to create your integration test.

## Step Five: Implement the `JdbcSiteDao` methods

There are two methods to implement in `JdbcSiteDao`: `getSitesWithRVAccessByParkId()` and `getSitesWithoutReservationByParkId()`. Refer to the documentation comments in the `SiteDao` interface for the expected input and output of these methods.

When you have `getSitesWithoutReservationByParkId()` implemented correctly, the `getSitesWithoutReservationByParkId_Should_Return_Available_Parks` integration test passes.

You'll need to write the integration test for `getSitesWithRVAccessByParkId()`. Find the `getSitesWithRVAccessByParkId_Should_Return_Sites_With_Positive_RV_Length` integration test and replace the `Assert.fail()` with an integration test that verifies your method functions properly.

Use the data in the `resources/test-data.sql` file to create your integration test.
