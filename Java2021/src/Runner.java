import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Runner {
    public static GradeBook myGradeBook = new GradeBook();

    public static void main (String[] args)
    {
        try {
            File myObj = new File("/Users/lisapham/IdeaProjects/Java2021/src/Grade Book.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fel");
            e.printStackTrace();
        }

        boolean x = false;
        Scanner in = new Scanner(System.in);
        System.out.println("Tryck valfri knapp för meny");
        String xy = in.nextLine();
        myGradeBook = TextToGradeBook.process(xy);

        while (x == false){
            System.out.println("Meny: ");
            System.out.println("1. Lägg till en student");
            System.out.println("2. Ändra en student");
            System.out.println("3. Ta bort en elev");
            System.out.println("4. Skapa uppgift");
            System.out.println("5. Sätt betyg för uppgift");
            System.out.println("6. Visa info om student");
            System.out.println("7. Visa info om alla studenter");
            System.out.println("8. Stäng program");
            int y = Integer.parseInt(in.nextLine());
            switch (y) {
                case 1: {
                    System.out.println("Namn på ny student");
                    String stud = in.nextLine();
                    myGradeBook.addStudent(new Student(stud));
                    System.out.println(stud + " var tillagd bland studenterna");
                    break;
                }
                case 2: {
                    System.out.println("Ange nytt namn");
                    String input = in.nextLine();
                    String[] inArray = input.split(" ");
                    for (int i = 2; i < inArray.length; i++)
                        inArray[1] = inArray[1] + " " + inArray[i];
                    inArray[1].trim();
                    myGradeBook.getStudent(Integer.parseInt(inArray[0])).setName(inArray[1]);
                    System.out.println("Studenten " + inArray[0] + " Heter nu: " + myGradeBook.getStudent(Integer.parseInt(inArray[0])).getName());
                    break;
                }
                case 3: {
                    System.out.println("Vem vill du ta bort?");
                    myGradeBook.removeStudent(Integer.parseInt(in.nextLine()));
                    System.out.println("Student bortagen");
                    break;
                }
                case 4: {
                    System.out.println("Ange ny uppgift");
                    String desc = in.nextLine();
                    System.out.println("Ange högsta betyg " + desc);
                    Assignment assign = new Assignment(" " + desc, Integer.parseInt(in.nextLine()));
                    System.out.println("Uppgift " + desc + " skapad. Ange vilka studenter du vill ge uppgiften till");
                    String z = in.nextLine();
                    if (z.equals("")) {
                        for (int i = 0; i < myGradeBook.size(); i++)
                            myGradeBook.getStudent(i).addAssignment(assign, assign.getPoints());
                        System.out.println(desc + " Tillagd i Gradebook");
                    } else {
                        String[] yz = z.split(" ");
                        for (int i = 0; i < yz.length; i++)
                            myGradeBook.getStudent(Integer.parseInt(yz[i])).addAssignment(assign, assign.getPoints());
                        System.out.println(desc + " Tillagd i Gradebook");

                    }

                    break;
                }
                case 5:
                {
                    System.out.println("Ange vilka studenter, för att lägg till flera använd , ");
                    String[] students = in.nextLine().split(",");
                    for (int i = 0; i<students.length; i++)
                    {
                        students[i] = students[i].trim();
                        String[] parts = students[i].split(" ");
                        myGradeBook.getStudent(Integer.parseInt(parts[0].trim())).getAssignment(Integer.parseInt(parts[1].trim())).setPointsEarned(Integer.parseInt(parts[2].replace(',',' ').trim()));
                    }

                    break;
                }
                case 6: {
                    System.out.println("Ange namn för vilken student du vill se betyg");
                    int index = Integer.parseInt(in.nextLine());
                    System.out.println("Namn: " + myGradeBook.getStudent(index).getName());
                    System.out.println("Uppgifter:");
                    for (int i = 0; i < myGradeBook.getStudent(index).getNumberOfAssignments(); i++)
                        System.out.println(myGradeBook.getStudent(index).getAssignment(i).toString());
                    myGradeBook.getStudent(index).updateGrade();
                    System.out.println(myGradeBook.getStudent(index).getPercentGrade()*100 + "%");
                    break;
                }
                case 7:
                {
                    for (int index = 0; index < myGradeBook.size(); index++) {
                        System.out.println("Namn: " + myGradeBook.getStudent(index).getName());
                        System.out.println("Uppgifter:");
                        for (int i = 0; i < myGradeBook.getStudent(index).getNumberOfAssignments(); i++)
                            System.out.println(myGradeBook.getStudent(index).getAssignment(i).toString());
                        myGradeBook.getStudent(index).updateGrade();
                        System.out.println(myGradeBook.getStudent(index).getPercentGrade() * 100 + "%");
                        System.out.println();
                    }
                    break;
                }
                case 8: x = true;
                    break;
                default: System.out.println("Syntax Error: Please Try Again");
                    break;
            }

            System.out.println();
        }
    }
}