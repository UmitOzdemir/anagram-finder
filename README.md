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
Due to memory constraint, I decided to process the file in chunks.
If words are anagrams they must be same length. Because of that chunks are generated based on word length.

To collect the anagrams, I decided to generate a common key for anagrams and collect them in a Map.
I used sorted chars of the words which is same for the anagrams.

Sorting the chars' a quick solution, but it's costly due to ordering.

I would create a different key with char and count of it. (e.g. aab -> aba -> a2b1) 
I could use an integer array to generate that key which ascii codes and time complexity would be O(n)

Uppercase and lowercase were were treated as two different words. "ABC" and "abc" are anagram but 2 different word.

## Big O analysis
Time complexity is O(n log(n)). Because it sorts all the words(chars). 
Space complexity is O(n). It creates new list from the file and another set to check duplications.

## Used data structures
Map is used to collect the anagram lists. Anagrams has same ordered chars and map is used to collect all of them in the same list.

Set is a collection that contains no duplicate elements and it's used remove duplicate words.

ArrayList is used to collect the anagrams in the same order as in the file. 