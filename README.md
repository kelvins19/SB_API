# README.md

Used API Documentation: https://punkapi.com/documentation/v2

## Tests List
- testGet20Beers, testGet5Beers, testGet1Beers

  Test to check the amount of data returned from this [endpoint](https://api.punkapi.com/v2/beers?page=2&per_page=). It verifies whether the data returned is in the same amount from the number of per page requests.
- testGetAllBeers

  Test to return the amount of data returned from this [endpoint](https://api.punkapi.com/v2/beers). It also verifies whether the returned data is 25 and return the list of the beer's names.
- testGetAllBeersSchema 

  Test to verify whether the data schema returned from this [endpoint](https://api.punkapi.com/v2/beers) is the same as the schema in `schema.json` file.

## Tech Stack & Dependencies
- Java 1.8.0_261

**Dependencies:**
- Rest Assured v5.0.1
- TestNG v7.4.0
- Apache HTTPClients v4.5.13
- Gson v2.8.0
- Json-Schema-Validator v1.0.71

## How to setup the project & run the test
1. Download JDK from [here](https://www.oracle.com/java/technologies/downloads/)
2. Clone the repository
3. Go into the project directory `cd SB_API`
4. Run `mvn install` to install the dependencies and build the project
5. Run `mvn test` to run the tests

<img width="963" alt="Screenshot 2023-01-04 at 14 36 17" src="https://user-images.githubusercontent.com/38350074/210497732-39a1a855-706c-44a0-9f78-79951a0b07d1.png">
