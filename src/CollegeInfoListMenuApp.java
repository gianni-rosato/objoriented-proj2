import java.util.Objects;
import java.util.Scanner;

public class CollegeInfoListMenuApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CollegeInfo collegeInfo = null;
        System.out.println("""
                    CollegeInfo System Menu
                    R - Read in File and Create CollegeInfo
                    P - Print CollegeInfo
                    S - Print Summary
                    A - Add DeptInfo Object
                    D - Delete DeptInfo Object
                    F - Find DeptInfo Object
                    Q - Quit
                    """);

        while (true) {
            System.out.print("Enter code [R, P, S, A, D, F, or Q]: ");
            char choice = scanner.next().charAt(0);

            switch (choice) {
                case 'r':
                    System.out.print("      File name: ");
                    String fileName = scanner.next();
                    collegeInfo = new CollegeInfo().readFile(fileName);
                    // System.out.println("      File name: " + fileName);
                    System.out.println("      File read in and CollegeInfo object created\n");
                    break;
                case 'p':
                    if (collegeInfo != null) {
                        System.out.print(collegeInfo);
                    } else {
                        System.out.println("No CollegeInfo object found. Please read the input file first.");
                    }
                    break;
                case 's':
                    if (collegeInfo != null) {
                        System.out.println(collegeInfo.summary());
                    } else {
                        System.out.println("No CollegeInfo object found. Please read the input file first.");
                    }
                    break;
                case 'a':
                    System.out.print("      Dept Name: ");
                    String deptNameAdd = scanner.next();
                    deptNameAdd += " " + scanner.next();
                    System.out.print("      Abbrev: ");
                    String deptAbbreviationAdd = scanner.next();
                    System.out.print("      Location: ");
                    String deptLocationAdd = scanner.next();
                    deptLocationAdd += " " + scanner.next();
                    System.out.print("      Number of Faculty: ");
                    int facultyAdd = scanner.nextInt();
                    System.out.print("      Number of TAs: ");
                    int gradTeachingAssistantsAdd = scanner.nextInt();
                    System.out.print("      Number of UGrads: ");
                    int undergradStudentsAdd = scanner.nextInt();
                    System.out.print("      Number of Grads: ");
                    int gradStudentsAdd = scanner.nextInt();
                    System.out.print("      Research Funding: ");
                    double researchFundingAdd = scanner.nextDouble();

                    assert collegeInfo != null;
                    collegeInfo.addDeptInfo(deptNameAdd, deptAbbreviationAdd, deptLocationAdd, facultyAdd, gradTeachingAssistantsAdd, undergradStudentsAdd, gradStudentsAdd, researchFundingAdd);

                    System.out.println("DeptInfo added\n");
                    break;
                case 'd':
                    System.out.print("      Dept Abbrev: ");
                    String deptAbbreviationDel = scanner.next();

                    assert collegeInfo != null;
                    collegeInfo.deleteDeptInfo(deptAbbreviationDel);

                    System.out.printf("      \"%s\" deleted\n\n", deptAbbreviationDel);
                    break;
                case 'f':
                    System.out.print("      Dept Abbrev: ");
                    String deptAbbreviationFind = scanner.next();

                    assert collegeInfo != null;
                    String foundDeptInfo = collegeInfo.findDeptInfo(deptAbbreviationFind);

                    if (!Objects.equals(foundDeptInfo, " not found")) {
                        System.out.println(foundDeptInfo + "\n");
                    } else {
                        System.out.printf("      \"%s\" not found\n\n", deptAbbreviationFind);
                    }
                    break;
                case 'q':
                    System.out.println("Exiting the program...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice; please enter a valid character.");
            }
        }
    }
}