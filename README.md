CURLS
Get all the Tabs

curl --request GET \
--url http://localhost:8080/tabs

Create a new Tab
curl --request POST \
--url http://localhost:8080/tabs \
--header 'Content-Type: application/json' \
--data '{
"name": "Disease history",
"description": "The chronic of the disease at hand",
"dataPoints": [
{
"dataType": "selection",
"label": "ECOG_SCORE",
"description": "ECOC score at the start of IO",
"options": [
"0",
"1",
"2",
"3",
"4",
"5",
"unknown"
]
},
{
"dataType": "text",
"label": "ECOG_HB_LEVEL",
"placeholder": "g/dL",
"description": "Hemogolobin level at the start of IO (g/dL)"
}
]
}'

Update a tab

curl --request PUT \
--url http://localhost:8080/tabs/6061c3a8adf38e51b3343c9e \
--header 'Content-Type: application/json' \
--data '{
"name": "Disease ",
"description": "The chronic of the disease at hand",
"dataPoints": [
{
"dataType": "selection",
"label": "ECOG_SCORE",
"description": "ECOC score at the start of IO",
"options": [
"0",
"1",
"2",
"3",
"4",
"5",
"unknown"
]
},
{
"dataType": "text",
"label": "ECOG_HB_LEVEL",
"placeholder": "g/dL",
"description": "Hemogolobin level at the start of IO (g/dL)"
}
]
}'

Delete a tab

curl --request DELETE \
--url http://localhost:8080/tabs/6061c3a8adf38e51b3343c9e