import sys

def returnvalue(arg) :
    if arg == "hi" :
        return "yes"
    return "no"
print("calling python function with parameters:")
print(sys.argv[1]+"x")
arg = sys.argv[1]
res = returnvalue(arg)
print(res)
# with open("C:/path/to/where/you/want/file.txt", 'w') as target:  # specify path or else it will be created where you run your java code
#     target.write(res)