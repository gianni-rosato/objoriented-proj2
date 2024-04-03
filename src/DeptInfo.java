/*  Requirements: Create a DeptInfo class that stores the name, abbreviation, location, number of faculty, number of
    graduate teaching assistants, number of undergraduate students, number of graduate students, and amount of research
    funding.  It also includes methods to set and get each of these fields, a toString method, and methods that
    calculate the total number of students and the department viability index. */

// Design: The DeptInfo class has fields, a constructor, & methods as outlined in the instructions.

public class DeptInfo {
    public final static int MIN_FACULTY = 10;
    public final static int MIN_UGRAD = 200;
    public final static int MIN_GRAD = 50;

    private String name;
    private String abbreviation;
    private String location;
    private int faculty;
    private int gradTeachingAssistants;
    private int undergradStudents;
    private int gradStudents;
    private double researchFunding;

    public DeptInfo(String name, String abbreviation, String location, int faculty, int gradTeachingAssistants,
                    int undergradStudents, int gradStudents, double researchFunding) {
        setName(name);
        // this.name = name.trim();
        setAbbreviation(abbreviation);
        // this.abbreviation = abbreviation.trim();
        setLocation(location);
        // this.location = location.trim();
        setNumFaculty(faculty);
        // this.faculty = faculty;
        setNumGradAssts(gradTeachingAssistants);
        // this.gradTeachingAssistants = gradTeachingAssistants;
        setNumUgrads(undergradStudents);
        // this.undergradStudents = undergradStudents;
        setNumGrads(gradStudents);
        // this.gradStudents = gradStudents;
        setResFunding(researchFunding);
        // this.researchFunding = researchFunding;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getLocation() {
        return location;
    }

    public int getNumFaculty() {
        return faculty;
    }

    public int getNumGradAssts() {
        return gradTeachingAssistants;
    }

    public int getNumUgrads() {
        return undergradStudents;
    }

    public int getNumGrads() {
        return gradStudents;
    }

    public double getResFunding() {
        return researchFunding;
    }

    public boolean setName(String name) {
        // if name is null or empty, return false
        if (name == null || name.trim().isEmpty()) {
            return false;
        } else {
            this.name = name.trim();
            return true;
        }
    }

    public boolean setAbbreviation(String abbreviation) {
        // if abbreviation is null or empty, return false
        if (abbreviation == null || abbreviation.trim().isEmpty()) {
            return false;
        } else {
            this.abbreviation = abbreviation.trim();
            return true;
        }
    }

    public boolean setLocation(String location) {
        // if location is null or empty, return false
        if (location == null || location.trim().isEmpty()) {
            return false;
        } else {
            this.location = location.trim();
            return true;
        }
    }

    public void setNumFaculty(int faculty) {
        this.faculty = faculty;
    }

    public void setNumGradAssts(int gradTeachingAssistants) {
        this.gradTeachingAssistants = gradTeachingAssistants;
    }

    public void setNumUgrads(int undergradStudents) {
        this.undergradStudents = undergradStudents;
    }

    public void setNumGrads(int gradStudents) {
        this.gradStudents = gradStudents;
    }

    public void setResFunding(double researchFunding) {
        this.researchFunding = researchFunding;
    }

    public int totalStudents() {
        return undergradStudents + gradStudents;
    }

    public double avgFundingPerFaculty() {
        return (faculty == 0) ? 0 : researchFunding / faculty;
    }

    public double viabilityIndex() {
        return ((double) faculty / MIN_FACULTY +
                (double) undergradStudents / MIN_UGRAD +
                (double) gradStudents / MIN_GRAD);
    }

    @Override
    public String toString() {
        return String.format("""
                        %s Location: %s
                        Faculty: %d   GTA: %d
                        Students: %d(UG)   %d(G)   %d(total)
                        Research Funding: $%,.2f   Avg/Fac: $%,.2f Viability Index: %.2f
                        """,
                getName(),
                getLocation(),
                getNumFaculty(),
                getNumGradAssts(),
                getNumUgrads(),
                getNumGrads(),
                totalStudents(),
                getResFunding(),
                avgFundingPerFaculty(),
                viabilityIndex());
    }

    public static void main(String[] args) {
        DeptInfo dept = new DeptInfo("Computer Science", "CS", "Fuller Labs", 18, 50, 550, 140, 2500000.0);
        System.out.println(dept.toString());
    }
}