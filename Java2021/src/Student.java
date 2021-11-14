import java.util.ArrayList;


public class Student {
    private String name;
    private double pointTotal;
    private double pointEarned;
    private double percentGrade;
    private ArrayList<CompletedAssignment> assignments = new ArrayList<CompletedAssignment>();
    public Student() {
        name = "Student";
        pointEarned = 0;
        pointTotal = 0;
        percentGrade = 0;
    }
    public Student (String n)
    {
        name = n;
        pointEarned = 0;
        pointTotal = 0;
        percentGrade = 0;
    }
    public void addAssignment (CompletedAssignment a)
    {
        assignments.add(a);
    }
    public void addAssignment (String d, double totalPoints, double earnedPoints)
    {
        assignments.add(new CompletedAssignment(new Assignment(d, totalPoints), earnedPoints));
    }
    public void addAssignment (Assignment a, double earnedPoints)
    {
        assignments.add(new CompletedAssignment(a, earnedPoints));
    }
    public String getName()
    {
        return name;
    }
    public void setName(String n)
    {
        name = n;
    }
    public void updateGrade() {
        double x = 0;
        double y = 0;

        for (int i = 0; i < assignments.size(); i++) {
            x += assignments.get(i).getPoints();
            y += assignments.get(i).getPointsEarned();
        }
        pointTotal = x;
        pointEarned = y;
        percentGrade = y/x;
    }
    public double getTotalPoints ()
    {
        return pointTotal;
    }
    public double getPointsEarned()
    {
        return pointEarned;
    }
    public double getPercentGrade()
    {
        return percentGrade;
    }
    public CompletedAssignment getAssignment (int index)
    {
        return assignments.get(index);
    }
    public int getNumberOfAssignments ()
    {
        return assignments.size();
    }
    public String toString()
    {
        String output = name + "; ";
        for (int i = 0; i < assignments.size(); i++)
            output = output + assignments.get(i).getDescription() + ", " + assignments.get(i).getPoints() + ", " + assignments.get(i).getPointsEarned() + "; ";
        return output;
    }

}