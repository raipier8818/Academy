class Student:
    def __init__(self,name):
        self.name = name
        self.list = []


    def input_score(self, subject, score):
        self.subject = subject
        self.score = int(score)

        if self.score >=95:
            self.grade = "A+"
            self.g_score = 4.5

        elif self.score >= 90:
            self.grade = "A0"
            self.g_score = 4.0


        elif self.score >= 85:
            self.grade = "B+"
            self.g_score = 3.5


        elif self.score >= 80:
            self.grade = "B0"
            self.g_score = 3.0


        elif self.score >= 75:
            self.grade = "C+"
            self.g_score = 2.5


        elif self.score >= 70:
            self.grade = "C0"
            self.g_score = 2.0


        elif self.score >= 65:
            self.grade = "D+"
            self.g_score = 1.5


        elif self.score >= 60:
            self.grade = "D0"
            self.g_score = 1.0


        else:
            self.grade = "F"
            self.g_score = 0.0


    def __str__(self):
        count = 0
        string = self.name + '\n'
        for text in self.list:
            string = string + str(text) + " "
            if count == 2:
                string += '\n'
                count = 0
            else:
                count += 1
        return string

student_list = []
subject_list = ['Calculus', 'Software', 'English']

for i in range(3):
    name = input("Student name : ")
    student_list.append(Student(name))
    add_all = 0

    for k in range(3):
        score = int(input(subject_list[k]+ " score : "))
        student_list[i].input_score(subject_list[k],score)
        student_list[i].list.append(subject_list[k])
        student_list[i].list.append(score)
        student_list[i].list.append(student_list[i].grade)

        add_all += student_list[i].g_score

    average = add_all/3
    student_list[i].list.append("Average "+ str(average))

print("")
for j in range(3):
    print(student_list[j])
    print("============")