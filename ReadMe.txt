# project-automata
Group 4

Members:  

Dao Van Hau - 20141476
Tran Trung Hieu - 20141569
Hac Tien Thanh -2014

Chapter 11

I.	Introduction project:

Our project talks about transfer NGA to NBA and NBA to RE
A NGA with n states and m sets of accepting states can be translated into an NBA with mn
states

II.	Instruction for use

---- NGA to NBA ----

  The input of NGA to NBA is drawn on JFlat create a NGA1.jft file copy to
the folder in the project or the input can be outfile.txt text file as 
the example below:
2 // number of states
q // state name
r
2 // number of letters in the alphabet
a
b
1 // number of input state
q
4 // number of state transfer
q b q // state 0 encountered b switch to state 1
q a r
r a r
r b q
2// number of set destination F0,F1,...
1// number of set states F0
q
1// number of set states F1
r

   The output may be a text file called oufile1.txt placed in the folder file 
or a .xml file in folder "createdFiles" can be opened with JFlat.

---- NBA to Regular Expression ----

  The input is a text file. For example:
2 // states numbers
0 // state name
1 // state name
2 // number of letters in the alphabet
a
b
1 // number of input states
0 // state of input
4 //number of state transfer
0 b 0 //state 0 encountered b switch to state 1
0 a 1
1 a 1
1 b 0
1 //number of destination state
1 //state name destination

   The output is a string displayed on the screen

