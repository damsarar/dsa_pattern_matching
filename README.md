# STRING MATCHING
## DSA_Pattern_matching_with_wildcards

You are required to implement a suitable string-matching algorithm to offer the user the
ability to find a pattern in a text when the pattern contains “wild-cards”. A wild-card is a
special “symbol” which is meant to match any letter. For this assignment only, the
underscore is considered as a wildcard. For concreteness, it is assumed that the text does
not contain the “_”-symbol (the underscore). For illustration, the “pattern” c_g can be found
in the following text ”cogwrgaccag” two times (at the beginning and at the end).

1. The pattern should be allowed to contain more than one wild-card (i.e., more than one
“_” and for example c_ _g, c_g_, c_ _g_).
2. Your algorithm should find all positions where the pattern is found.

### Explanation

In this Scenario, we have used the Java programming language for implementing. Here, The
string- matching algorithm we used was the naive string matching algorithm.

We selected the naive string matching algorithm because it is easy to implement and
efficient. Naive pattern searching is the simplest and powerful technique among other
string matching algorithms. In addition to that, this algorithm does not require a
preprocessing phase because the running time of the naive string matching algorithm is
equal to its matching time. As well as, the naive string matching algorithm doesn’t require
extra space.

First, the user is given the option to choose text and patterns from the following categories,

1. Matching Pattern
    ● Input files - text1.txt, pattern1.txt
    ● Output file - output1.output
2. Not Matching Pattern
    ● Input files - text2.txt, pattern2.txt
    ● Output file - output2.output
3. Empty Pattern and Empty Text
    ● Input files - text3.txt, , pattern3.txt
    ● Output file - output3.output
4. Empty Pattern and Non-Empty Text
    ● Input files - text4.txt, pattern4.txt
    ● Output file - output4.output
5. Empty Text and Non-Empty Pattern
    ● Input files - text5.txt, pattern5.txt
    ● Output file - output5.output
6. Pattern with spaces
    ● Input files - text6.txt, pattern6.txt
    ● Output file - output6.output
7. A pattern having an underscore only
    ● Input files - text7.txt, pattern7.txt
    ● Output file - output7.output

After the user selects an option, the text and pattern of the option are read. Then we
checked if the text and pattern files are empty. If not, we split the content of the text and
pattern file by ​ **“ ”,** then they are stored in a separate string array. Then we have called the
naive string matching algorithm. In the algorithm, we check whether the pattern length and
text length is equal and verify that the two patterns are matching or not.


## DSA_DNA_Pattern_matching

Write a program to search a database of DNA sequences, represented as strings of
characters, to find matches of other DNA subsequences. Thus, the program should take as
input two sets of strings: the Database strings and the Query strings. These two sets of
strings are referred to as the database and the query base respectively. Both the DNA
database and the query strings are made up of only four characters: A, C, G and T and the
query strings are of different lengths. The output must report the location of an exact
match within any given input DNA sequence for each input search query string. If the query
string matches within multiple sequences within the database, each result must be
reported; and if the query string matches multiple locations within the same database
sequence, the earliest position that matches exactly must be reported.

The input database and query files will have the same format. Each sequence will be
prefixed by a line starting with a greater than character (“>”) followed by a short description
of the origin of the sequence. The DNA sequence will then begin on the next line for some
number of lines. Each line will contain exactly  70  characters from the set A, C, G and T,
except the last line, which may hold fewer than  70  characters. Following this last line will be
the descriptor line of the next DNA sequence. The end of the file will be signified by the
descriptor (“>EOF”). For each query string contained within the second input file, the output
file should print the descriptor of the query sequence and the descriptors of any database
sequences that contain a match as well as the position within the database sequence of
that exact match. If the query sequence string is not found within any database sequences,
a message to that effect should be printed after the query descriptor.

### Explanation

We have implemented this program using the Java programming language. The advantage
of using the Java language is that Java language has the facility to keep key-value pairs using
maps.


We have used the Rabin Karp Algorithm to solve this problem. The reason for choosing this
algorithm is that in most cases, the Rabin Karp Algorithm has a linear time O(n) complexity.
Although in the worst case the time complexity can be O((n-m+1)*m) resulting in a
quadratic

First, we have read the database text file line by line, and we have checked for the
descriptor lines by “>” symbol and replaced it with an empty string and add it to the map as
a key followed by adding the string as the value. Then the same process gets repeated for
the query file and it is then added to another map. And at last the “EOF” is deleted.

Then the hash value is calculated for the query pattern and the database pattern equal to
the given length and looped through the pattern adding new hash values and subtracting
the old values. This function is called ​ **the rolling hash function.** This is a special advantage
in using the Rabin Karp algorithm because this algorithm doesn't backtrack and therefore it
is efficient. To make this more efficient the ​ **modular using a prime number** is also used
within the hash function. Another advantage is this algorithm matches the characters only
if the hash values match. Because of these reasons we have used the Rabin Karp Algorithm
to solve the above problem.

```
● Input files - DNA Database.txt, Querybase.txt
● Output file - output.output
```

### Java version details

```
● java version "1.8.0_131"
● Java(TM) SE Runtime Environment (build 1.8.0_131-b11)
● Java HotSpot(TM) 64-Bit Server VM (build 25.131-b11, mixed mode)
```
### Steps to run the program

1. Unzip the the folder.
2. Open a Command Prompt from that folder.
3. For Question 1, type
    ● javac DSA_Pattern_matching_assignment.java
    ● java DSA_Pattern_matching_assignment
    ● Then select an option from the list
4. For Question 2 ,type
    ● javac DSA_DNA_Pattern_matching.java
    ● Java DSA_DNA_Pattern_matching


