def EnoughWords(words): #Checks if there is more than one words
    Word_Counter=1
    for i in range(len(words)):
        if " "==words[i]:
            Word_Counter+=1
    if Word_Counter<2:
        print("Please write more words.")