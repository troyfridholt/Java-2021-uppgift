
public class CompletedAssignment extends  Assignment{
    double pointsEarned;

    public CompletedAssignment()
    {
        setDescription("Assignment");
        setPoints(0);
        pointsEarned = (0);
    }
    public CompletedAssignment(Assignment a, double p)
    {
        setDescription(a.getDescription());
        setPoints(a.getPoints());
        pointsEarned = p;
    }

    public double getPercentage()
    {
        return pointsEarned / getPoints();
    }
    public double getPointsEarned()
    {
        return pointsEarned;
    }
    public void setPointsEarned(double p)
    {
        pointsEarned = p;
    }

    public String toString() {
        return "Description:" + super.getDescription() + " Score: " + getPointsEarned() + "/" + getPoints() + " " + getPointsEarned()/getPoints()*100 + "%";
    }
}