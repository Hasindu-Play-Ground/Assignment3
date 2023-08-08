import java.util.Scanner;

public class Assignment3 {
    private static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        String redColor = "\033[31m";
        String blueColor = "\033[34m";
        String greenColor = "\033[32m";
        String invalidSubject = "Invalid Subject";
        String invalidMark = "Invalid Mark";
        String boldText = "\033[1m";
        String resetColor = "\033[0m";

        // Check name
        System.out.print("Enter your name: ");
        String userName = inputScanner.nextLine();

        if ((userName.strip()).length() == 0) {
            System.out.printf("%s%s%s \n", redColor, "Invalid name", resetColor);
        } else {
            // Check age
            System.out.print("Enter your Age: ");
            int userAge = inputScanner.nextInt();

            if (userAge < 10 || userAge > 18)
                System.out.printf("%s%s%s \n", redColor, "Invalid Age", resetColor);
            else {
                System.out.print("Enter your subject 1: ");
                inputScanner.nextLine();
                String subject1 = inputScanner.nextLine();

                if (!subject1.startsWith("SE-"))
                    System.out.printf("%s%s%s \n", redColor, invalidSubject, resetColor);
                else {
                    System.out.print("Enter your Mark 1: ");
                    float mark1 = inputScanner.nextFloat();

                    if (mark1 < 0 || mark1 > 100)
                        System.out.printf("%s%s%s \n", redColor, invalidMark, resetColor);
                    else {
                        inputScanner.nextLine();
                        System.out.print("Enter your subject 2: ");
                        String subject2 = inputScanner.nextLine();

                        if (subject2.equals(subject1) || !subject2.startsWith("SE-"))
                            System.out.printf("%s%s%s \n", redColor, invalidSubject, resetColor);
                        else {
                            System.out.print("Enter your Mark 2: ");
                            float mark2 = inputScanner.nextFloat();

                            if (mark2 < 0 || mark2 > 100)
                                System.out.printf("%s%s%s \n", redColor, invalidMark, resetColor);
                            else {
                                inputScanner.nextLine();
                                System.out.print("Enter your subject 3: ");
                                String subject3 = inputScanner.nextLine();

                                if (subject3.equals(subject1) || subject3.equals(subject2) || !subject3.startsWith("SE-"))
                                    System.out.printf("%s%s%s \n", redColor, invalidSubject, resetColor);
                                else {
                                    System.out.print("Enter your Mark 3: ");
                                    float mark3 = inputScanner.nextFloat();

                                    float totalMarks = mark1 + mark2 + mark3;
                                    float average = (float) (totalMarks / 3.0);

                                    String creditPass = "\033[32mCredit pass\033[0m";
                                    String passStatus = "\033[34mPass\033[0m";
                                    String failStatus = "\033[31mFail\033[0m";

                                    String subject1Status;
                                    if (mark1 >= 75) subject1Status = creditPass;
                                    else if (mark1 >= 55 && mark1 < 75) subject1Status = passStatus;
                                    else subject1Status = failStatus;

                                    String subject2Status;
                                    if (mark2 >= 75) subject2Status = creditPass;
                                    else if (mark2 >= 55 && mark2 < 75) subject2Status = passStatus;
                                    else subject2Status = failStatus;

                                    String subject3Status;
                                    if (mark3 >= 75) subject3Status = creditPass;
                                    else if (mark3 >= 55 && mark3 < 75) subject3Status = passStatus;
                                    else subject3Status = failStatus;

                                    String finalStatus;
                                    if (average >= 75) finalStatus = creditPass;
                                    else if (average >= 55 && average < 75) finalStatus = passStatus;
                                    else finalStatus = failStatus;

                                    System.out.printf("+----------------------------------+\n");
                                    System.out.printf("| Name: %s%s%-27s%s|\n", boldText, blueColor, userName.toUpperCase(), resetColor);
                                    System.out.printf("| Age: %-2s %-25s|\n", userAge, "years old");
                                    System.out.printf("| Status: %s%s%-34s|\n", greenColor, boldText, finalStatus);
                                    System.out.printf("| Total: %-8.2f      Avg: %-5.2f%s |\n", totalMarks, average, "%");
                                    System.out.println("+----------+---------+-------------+");
                                    System.out.printf("| %-9s| %-8s| %-12s|\n", "Subject", "Marks", "Status");
                                    System.out.println("+----------+---------+-------------+");
                                    System.out.printf("| SE-%03d%3s|%8.2f%s| %-21s|\n", Integer.valueOf(subject1.substring(3)), "", mark1, "%", subject1Status);
                                    System.out.println("+----------+---------+-------------+");
                                    System.out.printf("| SE-%03d%3s|%8.2f%s| %-21s|\n", Integer.valueOf(subject2.substring(3)), "", mark2, "%", subject2Status);
                                    System.out.println("+----------+---------+-------------+");
                                    System.out.printf("| SE-%03d%3s|%8.2f%s| %-21s|\n", Integer.valueOf(subject3.substring(3)), "", mark3, "%", subject3Status);
                                    System.out.println("+----------+---------+-------------+");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
