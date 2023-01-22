import sys
Input=""
for i in range(len(sys.argv)): #get the input from the front end
    Input+=sys.argv[i]

def EnoughWords(words): #Checks if there is more than one words
    Word_Counter=1
    for i in range(len(words)):
        if " "==words[i]:
            Word_Counter+=1
    if Word_Counter<2:
        print("Please write more words.")
EnoughWords(Input)