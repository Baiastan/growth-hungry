#!/bin/bash

Echo "Hello World"; echo "Again me"


num_of_companies=15

echo "Number of companies are ${num_of_companies}"

my_string="A very long string" # 18 characters
my_length=8

echo "${my_string:0:my_length}"

echo "${#my_string}"



array=(one two three four five)


echo "My first item in my array ${array[0]}"

echo "My array has these elements: ${array[@]}"

echo "The length is: ${#array[@]}"


for item in "${array[@]}"; do
    echo "${item}"
done


echo "All my arguments passed into this script: $@"
echo "The first argument: $1"

echo {1..10}
echo {a..z}

# echo "What is your name?"
# read name

# echo "Hello! ${name}"


# if [[ "$name" != "$USER" ]]; then
#     echo "You are a wrong user"
# else
#     echo "Welcome, ${name}"
# fi

# my_pdf_files=$(ls | grep "\.pdf")

# echo "My PDF Files: ${my_pdf_files}"


# function findPdfFiles() {
#     my_pdf_files=$(ls | grep "\.pdf")

#     echo "My PDF Files: ${my_pdf_files}"
# }

# findPdfFiles

function printNums() {
    for num in $(seq 1 $1); do
        echo "$num"
    done;
}

printNums 30