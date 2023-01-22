import random
import sys

Mem=sys.argv[1]#store if the user wants memorable or not

LInput=sys.argv[2] #store rest of input as a list


Input=' '.join(LInput)


def Recommended_Password_Not_Mem(): #does random non-memorable passwords.
    chars="._-,0123456789!#$%&'()*+/:;<=>?@[\]^`{|}~abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    password=""
    for i in range(21):
        password+=chars[random.randint(0,(len(chars)-1))]
    print(password)




def Recommended_Password_Mem(words): #does the recommended memorable password
    Word_Counter=1
    password=[]# store the password as a list
    for letter in words: 
        password.append(letter)
    vowels="aeiouy"
    
    
    spaces_replacements="._-,"
    vowel_replacements="0123456789!#$%&'()*+/:;<=>?@[\]^`{|}~"
    for i in range(len(password)): # replace spaces with a random character from the space_replacements character
        if " "==password[i]:
            Word_Counter+=1
            password[i]= spaces_replacements[random.randint(0,(len(spaces_replacements)-1))]
            

     #change the variables to random characters, unless 4 words are used
    if Word_Counter<4:
        for i in range(len(vowels)):
            for y in range(len(password)):
                if vowels[i]==password[y]:
                    password[y]= vowel_replacements[random.randint(0,(len(vowel_replacements)-1))]

    
    if Word_Counter<4:
        dontRun = False
        for i in range(len(password)):
            if password[i] in vowels:
                dontRun = True
        while True:#make a random consonnant a Capital
            if dontRun: break;
            i=random.randint(0,(len(password)-1))
            if password[i] not in vowels and password[i] not in vowel_replacements and password[i] not in spaces_replacements:

                password[i]=password[i].upper()
                break

        

    spassword= ' '.join(password) 


    print(spassword)
try:
    if Mem== "true":
        Recommended_Password_Not_Mem()
    else:
        Recommended_Password_Mem(LInput)
except Exception as e:
    print(e)






