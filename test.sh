#!/bin/sh

DEFAULT_HOST="127.0.0.1"
DEFAULT_PORT="8080"
LIST_URL="/ping"
GET_URL="/ping/"
POST_URL="/ping"
PUT_URL="/ping/"
DELETE_URL="/ping/"

# 1. post
for ii in `seq 1 5`; do
    title_str="Title "${ii}${ii}${ii}
    desc_str="Description "${ii}${ii}${ii}
    echo "########################################################################################################################"
    echo curl -X POST ${DEFAULT_HOST}:${DEFAULT_PORT}${POST_URL} -d "{\"title\":\"$title_str\",\"description\":\"$desc_str\"}" -H "Content-type: Application/json;UTF-8"
    echo "###"
    curl -X POST ${DEFAULT_HOST}:${DEFAULT_PORT}${POST_URL} -d "{\"title\":\"$title_str\",\"description\":\"$desc_str\"}" -H "Content-type: Application/json;UTF-8"
    echo ""
done

# 2. get
for ii in `seq 1 5`; do
    echo "########################################################################################################################"
    echo curl -X GET ${DEFAULT_HOST}:${DEFAULT_PORT}${GET_URL}$ii -H "Content-type: Application/json;UTF-8"
    echo "###"
    curl -X GET ${DEFAULT_HOST}:${DEFAULT_PORT}${GET_URL}$ii -H "Content-type: Application/json;UTF-8"
    echo ""
done

# 3. put & get
for ii in `seq 1 5`; do
    title_str="New title "${ii}${ii}${ii}
    desc_str="New description "${ii}${ii}${ii}
    echo "########################################################################################################################"
    echo curl -X PUT ${DEFAULT_HOST}:${DEFAULT_PORT}${PUT_URL}$ii -d "{\"title\":\"$title_str\",\"description\":\"$desc_str\"}" -H "Content-type: Application/json;UTF-8"
    echo "###"
    curl -X PUT ${DEFAULT_HOST}:${DEFAULT_PORT}${PUT_URL}$ii -d "{\"title\":\"$title_str\",\"description\":\"$desc_str\"}" -H "Content-type: Application/json;UTF-8"
    echo ""
    echo "########################################################################################################################"
    echo curl -X GET ${DEFAULT_HOST}:${DEFAULT_PORT}${GET_URL}$ii -H "Content-type: Application/json;UTF-8"
    echo "###"
    curl -X GET ${DEFAULT_HOST}:${DEFAULT_PORT}${GET_URL}$ii -H "Content-type: Application/json;UTF-8"
    echo ""
done

# 4. delete & get
for ii in `seq 1 5`; do
    echo "########################################################################################################################"
    echo curl -X DELETE ${DEFAULT_HOST}:${DEFAULT_PORT}${DELETE_URL}$ii -H "Content-type: Application/json;UTF-8"
    echo "###"
    curl -X DELETE ${DEFAULT_HOST}:${DEFAULT_PORT}${DELETE_URL}$ii -H "Content-type: Application/json;UTF-8"
    echo ""
    echo "########################################################################################################################"
    echo curl -X GET ${DEFAULT_HOST}:${DEFAULT_PORT}${GET_URL}$ii -H "Content-type: Application/json;UTF-8"
    echo "###"
    curl -X GET ${DEFAULT_HOST}:${DEFAULT_PORT}${GET_URL}$ii -H "Content-type: Application/json;UTF-8"
    echo ""
done

# 5. list
echo "########################################################################################################################"
echo curl -X GET ${DEFAULT_HOST}:${DEFAULT_PORT}${LIST_URL} -H "Content-type: Application/json;UTF-8"
echo "###"
curl -X GET ${DEFAULT_HOST}:${DEFAULT_PORT}${LIST_URL} -H "Content-type: Application/json;UTF-8"
echo ""
echo "########################################################################################################################"
