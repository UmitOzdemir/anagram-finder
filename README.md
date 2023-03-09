# Anagram Finder
A simple command line utility for finding anagrams in a specified file

## Software required to run this
* Java 17

## Building and Running the tests
```
./gradlew clean build
```

## Running the program
```
./gradlew bootRun --args="example2.txt" 
```
where example2.txt is the text file that we want to search for anagrams

## Solution description
Due to memory constraint, I decided to process the file by dividing it by word length.
All anagrams will be in the same file because the anagrams must be of the same length.


To collect the anagrams, I decided to generate a common key for anagrams and collect them in a Map.
I created an AnagramWord object which generates same hashcode for anagram words.

I created a key by ordering the letters in the word and all anagrams generates the same key. (Time complexity is n log(n))

I would create a different key with char and count of it. (e.g. aab -> aba -> a2b1) 
I could use an integer array to generate that key which ascii codes and time complexity would be O(n)

Uppercase and lowercase were treated as two different words. So it's assumed that "ABC" and "abc" are not anagram.

## Big O analysis
Time complexity is O(n log(n)). Because it sorts all the words by chars. 
Space complexity is O(n). It creates new list from the file and another set to check duplications.

## Used data structures
Map is used to collect the anagram lists. Anagrams has same ordered chars and and generates same hashcode.

Set is a collection that contains no duplicate elements and it's used remove duplicate words.

ArrayList is used to collect the anagrams in the same order as in the file. 


## Alternative solution
We can stream the data instead of bulk processing in the memory. 
During the streaming the data, we can calculate the hash values and then store them into a DB or a hash table to find the anagrams later. 
And we can create different data partitions based on the hash values for parallel processing. 
And instead of printing out the anagrams, we can store them into a database to use them again. And refresh/update them when we get a new data from data stream.