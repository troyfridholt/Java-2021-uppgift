
public class Assignment {

    private String description;
    private double points;

    public Assignment ()
    {
        description = "Assignment";
        points = 0;
    }
    public Assignment (String d, double p)
    {
        description = d;
        points = p;
    }
    public String getDescription()
    {
        return description;
    }
    public double getPoints()
    {
        return points;
    }
    public void setDescription (String d)
    {
        description = d;
    }
    public void setPoints (double p)
    {
        points = p;
    }
    public String toString() {
        return description + " " + points;
    }
}