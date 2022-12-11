##      E/18/340 Subramanieam V.

## NOTE: REMOVE THE pass STATEMENTS WHEN COMPLETING THE FUNCTIONS! ##
from ast import dump
from dataclasses import dataclass, asdict
from json import dumps
from typing import List, Dict, IO, Tuple
import csv

@dataclass
class Student:
    """A student's course registration details"""
    given_name: str
    surname: str
    registered_courses: List[str]


def load_course_registrations(filename: str) -> List[Student]:
    """ Returns a list of Student objects read from filename"""
    with open(filename, 'r') as file:
        pass #TODO
        csvreader = csv.reader(file)
        #print(csvreader)
        my_list=[]
        for row in csvreader:
            #print(row)
            my_list.append(Student(row[0], row[1], row[2:]))   
        print(my_list)
        return my_list

            


def sort_by_courses_registered(students: List[Student]) -> List[Student]:
    """Sort students by the number of courses that they are registered for"""
    pass #TODO
    course_sorted_list = sorted(students, key = lambda s: len(s.registered_courses),reverse=True)  
    return course_sorted_list


def store_course_registrations(students: List[Student], filename:str):
    """Writes a list of Student to a file"""
    with open(filename, 'w') as file:
        data = map(asdict, students)     #iterate through all elements and change all element as dictionary. 
        dump(list(data), file, indent=2)     #write it into a file
        file.close()
            

def index_by_name(students: List[Student]) -> Dict[Tuple, Student]:
    """Store Students keyed by (surname, given_name) in a dictionary"""
    pass #TODO
    # data = ()
    # d = ()

    # for i in students:
    #     d.append(i.surname,i.given_name)
    #     data.append(d,i) 
    # final = dict((value, key) for key, value in data)
    # print(final)
    students_dict = {}
    for i in students:
        students_dict[(i.surname, i.given_name)] = i
    return students_dict



    

# # Might be useful to test locally
if __name__ == "__main__":
#     # Your Code to test locally.
    
    list1 = load_course_registrations("./student_registrations.csv") 
    list2=sort_by_courses_registered(list1)
    print(list2)
    dict1= index_by_name(list1)
    print(dict1)
    store_course_registrations(list1,"new.json")