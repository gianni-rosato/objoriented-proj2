import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/*
 * Requirements:
 * - Create a CollegeInfo class that stores the name of the college and an ArrayList of DeptInfo objects.
 * - Include methods that return:
 *   - The name of the college
 *   - Total faculty
 *   - Total undergraduate students
 *   - Total graduate students
 *   - Department with the maximum number of undergraduate students
 *   - Department with the maximum number of graduate students
 *   - Total research funding
 *   - A research funding report
 * - Include a toString method that prints the name of the college followed by each DeptInfo object in the ArrayList.
 */
public class CollegeInfo {
    private ArrayList<DeptInfo> departments = null;
    private String collegeName;

    public CollegeInfo() {
    }

    public CollegeInfo(String collegeName, ArrayList<DeptInfo> departments) {
        this.collegeName = collegeName;
        this.departments = departments;
    }

    public String getName() {
        return collegeName;
    }

    public int getDeptListSize() {
        return departments.size();
    }

    public int totalFaculty() {
        // Returns an int representing the total number of faculty in the college.
        // If there are zero DeptInfo objects in the list, zero should be returned.
        int totalFaculty = 0;
        // null check for departments list
        if (departments != null) {
            for (DeptInfo dept : departments) {
                totalFaculty += dept.getNumFaculty();
            }
        }
        return totalFaculty;
    }

    public int totalUgrads() {
        // Returns an int representing the total number of undergraduate students in the college.
        // If there are zero DeptInfo objects in the list, zero should be returned.
        int totalUgrads = 0;
        // null check for departments list
        if (departments != null) {
            for (DeptInfo dept : departments) {
                totalUgrads += dept.getNumUgrads();
            }
        }
        return totalUgrads;
    }

    public int totalGrads() {
        // Returns an int representing the total number of graduate students in the college.
        // If there are zero DeptInfo objects in the list, zero should be returned.
        int totalGrads = 0;
        // null check for departments list
        if (departments != null) {
            for (DeptInfo dept : departments) {
                totalGrads += dept.getNumGrads();
            }
        }
        return totalGrads;
    }

    public String deptWithMaxUgrads() {
        // Returns a string representing the department with the maximum number of undergraduate students.
        // If there are zero DeptInfo objects in the list, "(0)" should be returned.
        int maxUgrads = 0;
        String deptWithMaxUgrads = "(0)";
        // null check for departments list
        if (departments != null) {
            for (DeptInfo dept : departments) {
                if (dept.getNumUgrads() > maxUgrads) {
                    maxUgrads = dept.getNumUgrads();
                    deptWithMaxUgrads = dept.getName();
                }
            }
        }
        return deptWithMaxUgrads + " (" + maxUgrads + ")";
    }

    public String deptWithMaxGrads() {
        // Returns a string representing the department with the maximum number of graduate students.
        // If there are zero DeptInfo objects in the list, "(0)" should be returned.
        int maxGrads = 0;
        String deptWithMaxGrads = "(0)";
        // null check for departments list
        if (departments != null) {
            for (DeptInfo dept : departments) {
                if (dept.getNumGrads() > maxGrads) {
                    maxGrads = dept.getNumGrads();
                    deptWithMaxGrads = dept.getName();
                }
            }
        }
        return deptWithMaxGrads + " (" + maxGrads + ")";
    }

    public double totalResearchFunding() {
        // Returns a double representing the total research funding in the college.
        // If there are zero DeptInfo objects in the list, zero should be returned.
        double totalResearchFunding = 0.0;
        // null check for departments list
        if (departments != null) {
            for (DeptInfo dept : departments) {
                totalResearchFunding += dept.getResFunding();
            }
        }
        return totalResearchFunding;
    }

    public String researchFundingReport() {
        // Returns a String containing the department name and research funding for
        // each DeptInfo object followed by the total research funding for the college
        // (each on a separate line). If there are zero DeptInfo objects in the list,
        // the String “No departments found” should be returned. Note that each line
        // has three leading spaces.
        String researchFundingReport = "";
        // null check for departments list
        if (departments != null) {
            for (DeptInfo dept : departments) {
                String formattedFunding = String.format("%,d", (int) dept.getResFunding());
                researchFundingReport += "\t$" + formattedFunding + " " + dept.getName() + "\n";
            }
        } else {
            return "No departments found";
        }
        researchFundingReport += "\tTotal: $" + String.format("%,d", (int) totalResearchFunding());
        return researchFundingReport;
    }

    @Override
    public String toString() {
        String collegeInfo = "College of " + collegeName + "\n\n";
        // null check for departments list
        if (departments != null) {
            for (DeptInfo dept : departments) {
                collegeInfo += dept.toString() + "\n";
            }
        } else {
            return "No departments found";
        }
        return collegeInfo;
    }

    public CollegeInfo readFile(String fileName) {
        // Takes a String parameter representing the file name, reads in the
        // file, storing the college name and creating an ArrayList of DeptInfo
        // objects, uses college name and the ArrayList to create a CollegeInfo
        // object, and then returns the CollegeInfo object.
        ArrayList<DeptInfo> deptList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String lineFromFile;
            int i = 0;

            // Parse the college name from the first line of the file
            collegeName = br.readLine();

            String deptName = "";
            String deptAbbreviation = "";
            String deptLocation = "";
            int faculty = 0;
            int gradTeachingAssistants = 0;
            int undergradStudents = 0;
            int gradStudents = 0;
            double researchFunding;

            while ((lineFromFile = br.readLine()) != null) {
                switch (i) {
                    case 0:
                        deptName = lineFromFile;
                        break;
                    case 1:
                        deptAbbreviation = lineFromFile;
                        break;
                    case 2:
                        deptLocation = lineFromFile;
                        break;
                    case 3:
                        faculty = Integer.parseInt(lineFromFile);
                        break;
                    case 4:
                        gradTeachingAssistants = Integer.parseInt(lineFromFile);
                        break;
                    case 5:
                        undergradStudents = Integer.parseInt(lineFromFile);
                        break;
                    case 6:
                        gradStudents = Integer.parseInt(lineFromFile);
                        break;
                    case 7:
                        researchFunding = Double.parseDouble(lineFromFile);
                        deptList.add(new DeptInfo(deptName, deptAbbreviation, deptLocation, faculty, gradTeachingAssistants, undergradStudents, gradStudents, researchFunding));
                        i = -1;
                        break;
                    default:
                        break;
                }
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new CollegeInfo(collegeName, deptList);
    }

    public String summary() {
        // Takes no parameters & returns a String representing a summary of
        // the CollegeInfo that includes the:
        // - Total faculty
        // - Total undergraduate students
        // - Total graduate students
        // - Department with the maximum number of undergraduate students
        // - Department with the maximum number of graduate students
        // - Research funding report
        return "Total Faculty: " + totalFaculty() + "\n" +
                "Total Undergraduate Students: " + totalUgrads() + "\n" +
                "Total Graduate Students: " + totalGrads() + "\n" +
                "Dept with Most Undergraduate Students: " + deptWithMaxUgrads() + "\n" +
                "Dept with Most Graduate Students: " + deptWithMaxGrads() + "\n" +
                "Dept Research Funding:\n" +
                researchFundingReport();
    }

    public void addDeptInfo(String name,
                            String abbreviation,
                            String location,
                            int faculty,
                            int gradTeachingAssistants,
                            int undergradStudents,
                            int gradStudents,
                            double researchFunding) {
        // Adds a new DeptInfo object to the ArrayList of DeptInfo objects.
        if (departments == null) {
            departments = new ArrayList<>();
        }
        departments.add(new DeptInfo(name, abbreviation, location, faculty, gradTeachingAssistants, undergradStudents, gradStudents, researchFunding));
    }

    public boolean deleteDeptInfo(String abbreviation) {
        // Takes the dept abbreviation as a parameter and returns true if the
        // corresponding DeptInfo is found in the CollegeInfo object and deleted;
        // otherwise returns false. This method should ignore case during a
        // comparison for the dept abbreviation.
        if (departments != null) {
            for (DeptInfo dept : departments) {
                if (dept.getAbbreviation().equalsIgnoreCase(abbreviation)) {
                    departments.remove(dept);
                    return true;
                }
            }
        }
        return false;
    }

    public String findDeptInfo(String abbreviation) {
        // Takes the dept abbreviation as a parameter and returns a String
        // representing the toString() for the corresponding DeptInfo object if
        // found in the list; otherwise returns a String containing the dept
        // abbreviation " not found". This method should ignore case during the
        // comparisons for the dept abbreviation.
        if (departments != null) {
            for (DeptInfo dept : departments) {
                if (dept.getAbbreviation().equalsIgnoreCase(abbreviation)) {
                    return dept.toString();
                }
            }
        }
        return " not found";
    }
}