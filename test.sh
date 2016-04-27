#!/bin/sh

DEFAULT_HOST="127.0.0.1"
DEFAULT_PORT="8080"
LIST_URL="/ping"
GET_URL="/ping/"
POST_URL="/ping"
PUT_URL="/ping/"
DELETE_URL="/ping/"

# 1. post
echo "########################################################################################################################"
for ii in `seq 1 20`; do
    title_str="Title "${ii}${ii}${ii}
    desc_str="Description "${ii}${ii}${ii}
    curl -i -X POST ${DEFAULT_HOST}:${DEFAULT_PORT}${POST_URL} -d "{\"title\":\"$title_str\",\"description\":\"$desc_str\"}" -H "Content-type: Application/json;UTF-8"
    echo ""
done
echo "########################################################################################################################"

# 2. list
echo "########################################################################################################################"
curl -i -X GET ${DEFAULT_HOST}:${DEFAULT_PORT}${LIST_URL} -H "Content-type: Application/json;UTF-8"
echo "########################################################################################################################"

# 3. get
echo "########################################################################################################################"
for ii in `seq 1 20`; do
    curl -i -X GET ${DEFAULT_HOST}:${DEFAULT_PORT}${GET_URL}/$ii -H "Content-type: Application/json;UTF-8"
    echo ""
done
echo "########################################################################################################################"

# 4. list
echo "########################################################################################################################"
curl -i -X GET ${DEFAULT_HOST}:${DEFAULT_PORT}${LIST_URL} -H "Content-type: Application/json;UTF-8"
echo "########################################################################################################################"

# 5. put & get
echo "########################################################################################################################"
for ii in `seq 1 20`; do
    title_str="New title "${ii}${ii}${ii}
    desc_str="New description "${ii}${ii}${ii}
    curl -i -X PUT ${DEFAULT_HOST}:${DEFAULT_PORT}${PUT_URL}/$ii -d "{\"title\":\"$title_str\",\"description\":\"$desc_str\"}" -H "Content-type: Application/json;UTF-8"
    curl -i -X GET ${DEFAULT_HOST}:${DEFAULT_PORT}${GET_URL}/$ii -H "Content-type: Application/json;UTF-8"
    echo ""
done
echo "########################################################################################################################"

# 6. list
echo "########################################################################################################################"
curl -i -X GET ${DEFAULT_HOST}:${DEFAULT_PORT}${LIST_URL} -H "Content-type: Application/json;UTF-8"
echo "########################################################################################################################"

# 7. delete & get
echo "########################################################################################################################"
for ii in `seq 1 20`; do
    curl -i -X DELETE ${DEFAULT_HOST}:${DEFAULT_PORT}${DELETE_URL}/$ii -H "Content-type: Application/json;UTF-8"
    curl -i -X GET ${DEFAULT_HOST}:${DEFAULT_PORT}${GET_URL}/$ii -H "Content-type: Application/json;UTF-8"
    echo ""
done
echo "########################################################################################################################"

# 6. list
echo "########################################################################################################################"
curl -i -X GET ${DEFAULT_HOST}:${DEFAULT_PORT}${LIST_URL} -H "Content-type: Application/json;UTF-8"
echo "########################################################################################################################"
