import math
import sys
Input=sys.argv[1]
class Password:
    def __init__(self, password):
        self.password = password
        self.points = 0
        self.Special= False
        self.Capital=False
        self.Numbers=False
        self.Lower=False
        self.Common=False
        self.common_item=[]


    def calculate_points(self):
        special_characters="._-,!#$%&'()*+/:;<=>?@[\]^`{ |}\"~\'"
        capital_letters="ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        numbers="1234567890"
        lower_case_letters="abcdefghijklmnopqrstuvwxyz"


        password_length = len(self.password) #points for length
        if password_length > 6:
            self.points += 1
        self.points += (password_length - 6)

        for i in range(password_length-1):
            if self.password[i] in special_characters:
                self.Special= True

            elif self.password[i] in capital_letters:
                self.Capital= True

            elif self.password[i] in numbers:
                self.Numbers= True

            elif self.password[i] in lower_case_letters:
                self.Lower= True

        if self.Lower==True: #points for categories
            self.points+=1
        if self.Special==True:
            self.points+=1
        if self.Capital==True:
            self.points+=1
        if self.Numbers==True:
            self.points+=1



    def output_strength(self):

        if self.Common==True:
            print("common")
            return
        if self.points>=8:
            print("very strong")
        elif self.points>=6:
            print("strong")
        elif self.points>=6:
            print("medium")
        elif self.points>=4:
            print("weak")
        else:
            print("very weak")

    def check_common(self, file_name):
        with open(file_name, 'r') as f:
            items = f.read().splitlines() # split the items in the file by newline characters
            for item in items:
                if item in self.password:
                    self.Common=True
                    self.common_item.append(item)

    def time_crack(self):
        special_characters="._-,!#$%&'()*+/:;<=>?@[\]^`{ |}\"~\'"
        capital_letters="ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        numbers="1234567890"
        lower_case_letters="abcdefghijklmnopqrstuvwxyz"

        base=0
        exponant=len(self.password)

        if self.Common==True:
            print("Instantly")
            return

        if self.Special== True:
            base+=len(special_characters)
        if self.Capital== True:
            base+=len(capital_letters)
        if self.Numbers== True:
            base+=len(numbers)
        if self.Lower== True:
            base+=len(lower_case_letters)

        time_s=((base**exponant)/(5*10**5))
        time_mi=time_s//60
        time_h=time_mi//60
        time_d=time_h//24
        time_mo=time_d//30
        time_y=time_mo//12

        if time_y==0: #disgusting
            if time_mo==0:
                if time_d==0:
                    if time_h==0:
                        if time_mi==0:
                            if time_s<1:
                                print("Instantly")
                            else:
                                print(str(math.trunc(time_s))+" seconds.")
                        else:
                            print(str(math.trunc(time_mi))+" minutes.")
                    else:
                        print(str(math.trunc(time_h))+" hours.")
                else:
                    print(str(math.trunc(time_d))+" days.")
            else:
                print(str(math.trunc(time_mo))+" months.")
        elif time_y>1000000:
            print("Over a million years.")
        else:
            print(str(math.trunc(time_y))+ " years.")




p = Password(Input)
file_name = "src/main/java/Python Scripts/CommonPasswords.txt"
p.check_common(file_name)
p.calculate_points()
p.output_strength()

print(p.time_crack())



