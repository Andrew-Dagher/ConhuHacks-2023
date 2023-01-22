import sys
Input=""
for i in range(len(sys.argv)): #get the input from the front end
    Input+=sys.argv[i]

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
            print(f"Very weak, {self.common_item[0]} is a common password.")
            return 0
        if self.points>=8:
            print("Very Strong")
        elif self.points>=6:
            print("Strong")
        elif self.points>=6:
            print("Medium")
        elif self.points>=4:
            print("Weak")
        else:
            print("Very Weak")

    def check_common(self, file_name):
        with open(file_name, 'r') as f:
            items = f.read().splitlines() # split the items in the file by newline characters
            for item in items:
                if item in self.password:
                    self.Common=True
                    self.common_item.append(item)




        
p = Password(Input)
file_name = "CommonPasswords.txt"
p.check_common(file_name)
p.calculate_points()
p.output_strength()
print(p.Special)
print(p.Lower)
print(p.Capital)
print(p.Numbers)



