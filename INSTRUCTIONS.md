P2: College Info Menu App
=========================

Start Assignment

*   Due Apr 10 by 11:59pm
*   Points 100
*   Submitting a file upload
*   Available Mar 27 at 8am - Apr 10 at 11:59pm

## Overview

You will write a program that is composed of three classes: the first class defines **DeptInfo** objects, the second class defines a **CollegeInfo**, and the third, **CollegeInfoMenuApp**, presents a menu to the user with seven options and implements these: read the input file and create a CollegeInfo object, print the CollegeInfo object, print a summary of the CollegeInfo object, add a DeptInfo object to the CollegeInfo object, delete a DeptInfo object from the CollegeInfo object, find a DeptInfo object in the CollegeInfo object, or quit the program.

\====================================================================================================

•    **DeptInfo.java**
**Requirements**: Create a DeptInfo class that stores the name, abbreviation, location, number of faculty, number of graduate teaching assistants, number of undergraduate students, number of graduate students, and amount of research funding.  It also includes methods to set and get each of these fields, a toString method, and methods that calculate the total number of students and the department viability index.
**Design**:  The DeptInfo class has fields, a constructor, and methods as outlined below.

(1)    Fields (instance variables and constants): name, abbreviation, and location which are of type String; number of faculty, number of graduate teaching assistants, number of undergraduate students, number of graduate students, which are of type int; and research funding which is of type double.  These instance variables should be private so that they are not directly accessible from outside of the DeptInfo class.  The last three fields should be public constants named MIN\_FACULTY, MIN\_UGRAD, and MIN\_GRAD of type int that are set to 10, 200, and 50 respectively.  These constants will be used to determine the viability index. 

(2) Constructor: Your DeptInfo class must contain a constructor that accepts eight parameters (see types of above) representing the name, abbreviation, location, number of faculty, number of graduate teaching assistants, number of undergraduate students, number of graduate students, and amount of research funding. The values for name, abbreviation, and location should be trimmed of leading and trailing spaces prior to setting the fields (hint: use trim method from the String class). Below are two examples of how the constructor could be used to create a DeptInfo object in interactions. Note that although String and numeric literals are used for the actual parameters (or arguments) in these examples, variables of the required type could have been used instead of the literals.

DeptInfo dept1 = new DeptInfo("Computer Science", "CS", "Fuller Labs", 18, 50, 550, 140,2500000.0);
DeptInfo dept2 = new DeptInfo("Information Technology", "IT", "Gordon Library", 42, 64, 1050, 240,850000.0);

(3)    Methods: Usually a class provides methods to access and modify each of its instance variables (known as get and set methods) along with any other required methods.  The methods for DeptInfo are described below.
o    getName:  Accepts no parameters and returns a String representing the name.
o    setName: Takes a String parameter and returns a boolean. If the string parameter
(name) is null, then the method returns false and the name is not set. Otherwise, the
“trimmed” String is set to the name field and the method returns true.
o    getAbbrev: Accepts no parameters and returns a String representing the abbreviation.
o    setAbbrev: Takes a String parameter and returns a boolean.  If the string parameter is null, then the method returns false and the abbreviation is not set. Otherwise, the “trimmed” String is set to the abbreviation field and the method returns true.
o    getLocation: Accepts no parameters and returns a String representing the location.
o    setLocation: Takes a String parameter and returns a boolean.  If the string parameter is null, then the method returns false and the location is not set. Otherwise, the “trimmed” String is set to the location field and the method returns true.
o    getNumFaculty: Accepts no parameters and returns the int value from number of faculty field.
o    setNumFaculty:  Accepts an int parameter, sets the number of faculty field, and returns nothing.
o    getNumGradAssts: Accepts no parameters and returns the int value from number of graduate assistants field.
o    setNumGradAssts:  Accepts an int parameter, sets the number of graduate assistants field, and returns nothing.
o    getNumUgrads: Accepts no parameters and returns the int value from number of undergraduates field.
o    setNumUgrads:  Accepts an int parameter, sets the number of undergraduates field, and returns nothing.
o    getNumGrads: Accepts no parameters and returns the int value from number of graduate students field.
o    setNumGrads:  Accepts an int parameter, sets the number of graduate students field, and returns nothing.
o    getResFunding: Accepts no parameters and returns the double value of the research funding field.
o    setResFunding:  Accepts an double parameter, sets the research funding field, and returns nothing.
o    totalStudents:  Accepts no parameters, calculates the number of students in department and returns the int value.
o    avgFundingPerFaculty:  Accepts no parameters, calculates the average funding per faculty (i.e., research funding / number of faculty) and returns the double value.
o    viabilityIndex:  Accepts no parameters, calculates viability index using the constants from the DeptInfo class with following formula and returns a double:
(# faculty / MIN\_FACULTY) + (# ugrad stu / MIN\_UGRAD) + (# grad stu / MIN\_GRAD)
o    toString:  Returns a String containing the information about the DeptInfo object formatted as shown below.  

You will need to include decimal formatting for the numerical values and newline escape sequences to achieve the proper layout.  The following methods should be used to compute appropriate values in the toString method: totalStudents(),  avgFundingPerFaculty(), and viabilityIndex().  The results of printing two examples above, dept1 and dept2, are shown below.

Computer Science Location: Fuller Labs
Faculty: 18   GTA: 50
Students: 550(UG)   140(G)   690(total)
Research Funding: $2,500,000.00   Avg/Fac: $138,888.89 Viability Index: 7.35

Information Technology (IT)
Location: Gordon Library
Faculty: 42   GTA: 64
Students: 1,050(UG)   240(G)   1,290(total)
Research Funding: $850,000.00   Avg/Fac: $20,238.10 Viability Index: 14.25

**Code and Test**: As you implement your DeptInfo class, you should compile it and then test it using interactions.  For example, as soon you have implemented and successfully compiled the constructor, you should create an instance of DeptInfo in interactions (see the examples above).  After you have implemented and compiled one or more methods, create a DeptInfo object and invoke each of your methods on the object to make sure the methods are working as intended.   

\====================================================================================================

**•    CollegeInfo.java** 

**Requirements**: Create CollegeInfo class that stores the name of the college and an ArrayList of DeptInfo objects.  It also includes methods that return the name of the college, total faculty, total undergraduate students, total graduate students, department with the maximum number of undergraduate students, department with the maximum number of graduate students, total research funding, a research funding report, and a toString method that prints the name of the collage followed by each DeptInfo object in the ArrayList.

**Design:**  The CollegeInfo class has two fields, a constructor, and methods as outlined below. 
(1)    Fields (or instance variables): (1) a String representing the name of the college and (2) an ArrayList of DeptInfo objects.  These are the only fields (or instance variables) that this class should have.  The ArrayList field should be initialized to a new ArrayList of DeptInfo objects.

.. = new ArrayList<DeptInfo>();

(2)    Constructor: Your CollegeInfo class must contain a constructor that accepts parameter of type String representing the name of the college and a parameter of type 
ArrayList<DeptInfo> representing the list of DeptInfo objects.  The parameters should be used to assign the fields described above. 
(3)    Methods: The methods for CollegeInfo are described below. 
o    getName:  Returns a String representing the name of the College. 
o    totalFaculty:  Returns an int representing the total number of faculty in the college. If there are zero DeptInfo objects in the list, zero should be returned. 
o    totalUgrads:  Returns an int representing the total number of undergraduate students in the college.  If there are zero DeptInfo objects in the list, zero should be returned. 
o    totalGrads:  Returns an int representing the total number of graduate students in the college.  If there are zero DeptInfo objects in the list, zero should be returned. 
o    deptWithMaxUgrads:  Returns a String representing the name of the department followed by number of undergraduate students in parentheses for the DeptInfo object with the maximum number of undgraduate students.   If there are zero DeptInfo objects in the list, “(0)” should be returned.   
o    deptWithMaxGrads:  Returns a String representing the name of the department followed by number of graduate students in parentheses for the DeptInfo object with the maximum number of undgraduate students.   If there are zero DeptInfo objects in the list, “(0)” should be returned.
o    totalResearchFunding: Returns a double representing the total research funding for the college.  If there are zero DeptInfo objects in the list, zero should be returned. 
o    researchFundingReport: Returns a String containing the department name and research funding for each DeptInfo object followed by the total research funding for the college (each on a separate line).  If there are zero DeptInfo objects in the list, the String “No departments found” should be returned.   Note that each line has three leading spaces. 
o    toString:  Returns a String containing the name of the college followed by the information in each of the DeptInfo objects in the list.  In the process of creating the return result, this toString() method should call the toString() method for each DeptInfo object in the list.  Be sure to include appropriate newline escape sequences. 
o    readFile:  Takes a String parameter representing the file name, reads in the file, storing the college name and creating an ArrayList of DeptInfo objects, uses college name and the ArrayList to create a CollegeInfo object, and then returns the CollegeInfo object.  See note #1 under Important Considerations for the CollegeInfoMenuApp class (last page) to see how this method should be called. 
o    summary:  Takes no parameters and returns a String representing a summary of the CollegeInfo that includes the total faculty, total undergraduate students, and total graduate students, the department with most undergraduate students, the department with the most graduate students, and research funding report. 
o    addDeptInfo:  Returns nothing but takes eight parameters (name, abbreviation, location, number of faculty, number of graduate teaching assistants, number of undergraduate students, number of graduate students, and amount of research funding) creates a new DeptInfo object and adds it to the list. 
o    deleteDeptInfo:  Takes the dept abbreviation as a parameter and returns true if the corresponding DeptInfo is found in the CollegeInfo object and deleted; otherwise returns false.  This method should ignore case during a comparison for the dept abbreviation. 
o    findDeptInfo:  Takes a dept abbreviation as the parameters and returns a String representing the toString() for the corresponding DeptInfo object if found in the list; otherwise returns a String containing the dept abbreviation “ not found”.  This method should ignore case during the comparisons for the dept abbreviation.

**Code and Test:** Remember to import java.util.ArrayList, java.util.Scanner, java.io.File, java.io.IOException.  These classes will be needed in the readFile method which will require a throws clause for IOException.  Some of the methods above require that you use a loop to go through the objects in the ArrayList.  You may want to implement the class below in parallel with this one to facilitate testing.  This is, after implement one to the methods above, you can implement the corresponding “case” in the menu described below in the CollegeInfoMenuApp class.

\===================================================================================================

*   **CollegeInfoListMenuApp.java**

**Requirements**: Create a CollegeInfoListMenuApp class with a main method that presents the user with a menu with seven options each of which is implemented: (1) read the input file and create a CollegeInfo object, (2) print the CollegeInfo object, (3) print the summary for the CollegeInfo object, (4) add a DeptInfo object to the CollegeInfo object, (5) delete a DeptInfo object from the CollegeInfo object, (6) find a DeptInfo object in the list, or (7) quit the program.

**Design**:  The main method should print a list of options with the action code and a short description followed by a line with just the action codes prompting the user to select an action. After the user enters an action code, the action is performed, including output if any.  Then the line with just the action codes prompting the user to select an action is printed again to accept the next code.  Note that the first action a user should normally perform is ‘R’ to read in the file and create a CollegeInfo object.  The other actions can then be used to process the CollegeInfo object. This continues until the user enters ‘Q’ to quit.  Note that your program should accept both uppercase and lowercase action codes.

Below is the output produced after printing the action codes and short descriptions followed by the prompt with the action codes waiting for the user to make a selection.

![image.png](/courses/57166/files/6486361/preview)

Below shows the screen after the user entered ‘r’ and then (when prompted) the file name.  Notice the output from this action was “File read in and CollegeInfo created”.  This is followed by the prompt with the action codes waiting for the user to make the next selection.  You should use the college.dat file (linked above) to test your program. 

![image.png](/courses/57166/files/6486364/preview)

The result of the user selecting ‘a’ to add a DeptInfo object is shown below. Note that after ‘a’ was entered, the user was prompted for dept name, abbreviation, location, number of faculty, number of graduate teaching assistants, number of undergraduate students, number of graduate students, and amount of research funding. Then after the DeptInfo object was added to the CollegeInfo object, the message “DeptInfo added” was printed. This is followed by the prompt for the next action.

![image.png](/courses/57166/files/6486368/preview)

Here is an example of the successful deletion of a DeptInfo object, followed by an attempt to delete a DeptInfo object that wasn’t found. 

![image.png](/courses/57166/files/6486370/preview)

Here is an example of an attempt to “find a DeptInfo object that wasn’t found, followed by a successful “find”.

![image.png](/courses/57166/files/6486376/preview)   ![image.png](/courses/57166/files/6486377/preview)

**Code and Test:**     
Important considerations:  This class should import java.util.Scanner, java.util.ArrayList, and java.io.IOException.  Carefully consider the following information as you develop this class.

1\. At the beginning of your main method, you should declare and create an ArrayList of DeptInfo objects and then declare and create a CollegeInfo object using the college name and the ArrayList as the parameters in the constructor.  This will be a CollegeInfo object that contains no DeptInfo objects.  For example:

ArrayList<DeptInfo> \_\_\_\_\_\_\_\_\_ = new ArrayList<DeptInfo>();     
CollegeInfo \_\_\_\_\_\_\_\_\_ = new CollegeInfo(\_\_\_\_\_\_,\_\_\_\_\_\_);

The ‘R’ option in the menu should invoke the readFile method on your CollegeInfo object.  This will return a new CollegeInfo object based on the data read from the file, and this new CollegeInfo object should replace (be assigned to) your original CollegeInfo object. Since the readFile method throws IOException, your main method need to do this as well. 

2\.    **Very Important:** You should declare only one Scanner on System.in for your entire program and should be in the main method.  That is, all input from the keyboard (System.in) must be done in your main method.  
3\.    For the menu, your switch statement expression should evaluate to a char and each case should be a char; alternatively, your switch statement expression should evaluate to a String with a length of 1 and each case should be a String with a length of 1.

After printing the menu of actions and descriptions, you should have a do-while loop that prints the prompt with just the action codes followed by a switch statement that performs the indicated action.  The do-while loop ends when the user enters ‘q’ to quit.  The new methods that require you to search the list should be implemented with a for-each loop as appropriate.  You should be able to test your program by exercising each of the action codes.  After you implement the “Print CollegeInfo” option, you should be able to print the list after operations such as ‘A’ and ‘D’ to see if they worked.  You may also want to run in debug mode with a breakpoint set at the switch statement so that you can step-in to your methods if something is not working.  

Although your program may not use all of the methods in your DeptInfo and CollegeInfo classes, you should ensure that all of your methods work according to the specifications. 

\=================================================================================================

**Download**: [college.dat](/courses/57166/files/6488142?wrap=1 "college-1.dat") (updated March 27 @ noon)

You can work with a partner - please form groups under People tab

**Submission instructions**: 3 java files in a zipped folder

We are working on creating test cases that you can run your code on to get instant feedback. More on that soon!
