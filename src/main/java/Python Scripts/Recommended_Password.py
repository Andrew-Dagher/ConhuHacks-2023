import random

def Recommended_Password(words): #does the recommended password
    password=[]# store the password as a list
    for letter in words: 
        password.append(letter)
    vowels="aeiouy"
    while True:#make a random consonnant a Capital
        i=random.randint(0,(len(password)-1))
        if password[i] not in vowels and password[i] != " ": 
            password[i]=password[i].upper()
            break
    
    spaces_replacements="._-,"
    vowel_replacements="0123456789!#$%&'()*+/:;<=>?@[\]^`{|}~"
    for i in range(len(password)): #if there are spaces, replace them with a random character from the space_replacements character
        if " "==password[i]:
            password[i]= spaces_replacements[random.randint(0,(len(spaces_replacements)-1))]
            

     #change the variables to random characters
    for i in range(len(vowels)):
        for y in range(len(password)):
            if vowels[i]==password[y]:
                password[y]= vowel_replacements[random.randint(0,(len(vowel_replacements)-1))]

    
        

    spassword= ' '.join(password) #make he li a in


    print(spassword)
        




