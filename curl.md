### curl requests (application deployed at application context `lunchplacepicker`) 
> For windows use `Git Bash`

#### User registration
`curl --location --request POST 'http://localhost:8080/lunchplacepicker/rest/register' \
--header 'Content-Type: application/json' \
--data-raw '{
        "id": "",
        "name": "alex",
        "email": "alex@gmail.com",
        "password": "12345",
        "registered": ""
    }'`

#### Check if User is logged in
`curl --location --request GET 'http://localhost:8080/lunchplacepicker/rest/ifloggedin' \`

