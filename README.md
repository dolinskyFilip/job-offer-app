# Job-offer-app
Project for Digital New Agency interview

Application uses com.dna API. It allows to create, read, update and delete User object 
and create and fetch valid job offers as well. H2 Database used for storing the data. 
When applications starts initial data is loading.

# Requirements
gitbash or similar <br />
docker <br />
postman or similar tool <br />
# How to run 
Clone repo <br />
Build the application with mvn clean package <br />
Run command docker-compose up <br />
Application should be available on http://localhost:8080 <br />

# API
**User CRUD** <br />
_/dna/user_

**Create and get valid job offers** <br />
_/dna/offers_

# USER CRUD
**Use endpoint /dna/user with GET method and set the login as pathvariable** <br />
**Job-offer-app will return your user as a JSON in response** <br />
_e.g. http://localhost:8080/dna/users/Filip_


**Use endpoint /dna/user with POST method and set RequestBody with UserDTO data** <br />
**Job-offer-app will return your user created as a JSON in response** <br />

**Use endpoint /dna/user with PUT method and set RequestBody with UserDTO data** <br />
**Job-offer-app will return your user updated as a JSON in response** <br />

**Use endpoint /dna/user with DELETE method and set the login as pathvariable** <br />
**Job-offer-app will delete record** <br />

# JOB OFFERS
**Use endpoint /dna/offers with GET method** <br />
**Job-offer-app will return your valid job offers as a JSON in response** <br />
_e.g. http://localhost:8080/dna/offers_

**Use endpoint /dna/offers with POST and set RequestBody with JobOfferDTO data** <br />
**Job-offer-app will return created Job Offer as a JSON in response** <br />
_e.g. http://localhost:8080/dna/offers_


