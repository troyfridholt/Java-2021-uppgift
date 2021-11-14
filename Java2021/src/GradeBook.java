import java.util.ArrayList;


public class GradeBook {
    private ArrayList<Student> gradeBook = new ArrayList<Student>();
    public GradeBook(){

    }

    public void addStudent(Student a)
    {
        gradeBook.add(a);
    }
    public void addStudent(Student a, int index)
    {
        gradeBook.add(index,a);
    }
    public Student getStudent (int index)
    {
        return gradeBook.get(index);
    }
    public void replaceStudent (int index, Student newStud)
    {
        gradeBook.add(index, newStud);
        gradeBook.remove(index + 1);
    }

    public void removeStudent (int index)
    {
        gradeBook.remove(index);
    }

    public int size ()
    {
        return gradeBook.size();
    }
    public String toString()
    {
        String output = "";
        for (int i = 0; i<gradeBook.size(); i++)
            output = output + gradeBook.get(i).toString() + "\n";

        return output;
    }
}