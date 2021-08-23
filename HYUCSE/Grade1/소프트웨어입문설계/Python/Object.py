class Score:
    def __init__(self, math,python,korean):
        self.math = math
        self.python = python
        self.korean = korean
        self.mean = 0.0

    def Calculate_mean(self):
        self.mean = (self.math + self.python + self.korean)/3

    def __str__(self):
        string = "Math :"+ str(self.math) +"\nPython :"+ str(self.python) +"\nKorean :"+ str(self.korean) +"\nMean :" + str(self.mean) + "\n"
        return string

Student = []
for i in range(3):
    math = float(input("Input the math score: "))
    python = float(input("Input the python score: "))
    korean = float(input("Input the korean score: "))

    Student.append(Score(math,python,korean))
    print("a Score object is created.\n")

for i in range(3):
    Student[i].Calculate_mean()
    print(Student[i])