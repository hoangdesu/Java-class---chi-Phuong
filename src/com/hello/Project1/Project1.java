package com.hello.Project1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Project1 {
    private String coursePrefix;
    private int courseNumber;
    private String courseTitle;
    private int numOfCredits;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //create a new scanner


        String mainCommand = "";

        while (true) {
            System.out.print(">>>");
            mainCommand = sc.next();

            if (mainCommand.equals("q")) {
                break;
            }


            switch (mainCommand.trim()) {
                case "a": // add
                    add();
                    break;
                case "l": // list
                    list();
                    break;
                case "t":
                    getStudentTranscript();
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }


    // MAIN COMMAND METHODS

    public static void add() throws IOException {
        String subCommand = sc.next();

        switch (subCommand) {
            case "c":
                addCourse();
                break;
            case "g": // grade
                addGrade();
                break;
            case "m": // semester code
                addSemesterCode();
                break;
            case "s": // student
                addStudent();
                break;
            case "t": // course taken
                addCourseTaken();
                break;
            default:
                break;
        }
    }

    public static void list() throws IOException {
        String subCommand = sc.next();

        switch (subCommand) {
            case "c":
                listAllCourses();
                break;
            case "g":
                listInformation("grade");
                break;
            case "m":
                listInformation("semester");
                break;
            case "s":
                listStudents();
                break;
            case "t":
                listInformation("courseTaken");
                break;

        }
    }


    // SUB COMMAND METHODS

    public static void addCourse() throws IOException {
        String coursePrefix = sc.next();
        String courseNumber = sc.next(); // int
        String courseTitle = sc.next();
        String courseCredits = sc.next(); // int

        // create file if not exists
//        try {
//            File courseFileObj = new File("course.txt");
//            if (courseFileObj.createNewFile()) {
//                System.out.println("File created: " + courseFileObj.getName());
//            } else {
//                System.out.println("File already exists.");
//            }
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }

//        System.out.println(coursePrefix + courseNumber + courseTitle + courseCredits);
        FileWriter courseFile = new FileWriter("course.txt", true);
        BufferedWriter courseBufferedWriter = new BufferedWriter(courseFile);
        PrintWriter courseWriter = new PrintWriter(courseBufferedWriter);

        String courseData = String.format("%s %s %s %s", coursePrefix, courseNumber, courseTitle, courseCredits);

        courseWriter.println(courseData);
        courseWriter.close();
        courseBufferedWriter.close();
        courseFile.close();
    }

    private static void addGrade() throws IOException {
        String gradeLetter = sc.next();
        String gradeValue = sc.next(); // float

        try {
            File courseFileObj = new File("grade.txt");
            if (courseFileObj.createNewFile()) {
                System.out.println("File created: " + courseFileObj.getName());
            }
//            else {
//                System.out.println("File already exists.");
//            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        FileWriter courseFile = new FileWriter("grade.txt", true);
        BufferedWriter courseBufferedWriter = new BufferedWriter(courseFile);
        PrintWriter courseWriter = new PrintWriter(courseBufferedWriter);

        String courseData = String.format("%s %s", gradeLetter, gradeValue);

        courseWriter.println(courseData);
        courseWriter.close();
        courseBufferedWriter.close();
        courseFile.close();
    }

    public static void addSemesterCode() throws IOException {
        String semCode = sc.next();
        String year = sc.next(); // float
        String description = sc.next(); // float

        // break point
        if (!description.equals("Spring") && !description.equals("Summer") && !description.equals("Fall")) {
            System.out.println("Invalid description");
            return;
        }

        try {
            File courseFileObj = new File("semester.txt");
            if (courseFileObj.createNewFile()) {
                System.out.println("File created: " + courseFileObj.getName());
            }
//            else {
//                System.out.println("File already exists.");
//            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        FileWriter courseFile = new FileWriter("semester.txt", true);
        BufferedWriter courseBufferedWriter = new BufferedWriter(courseFile);
        PrintWriter courseWriter = new PrintWriter(courseBufferedWriter);

        String courseData = String.format("%s %s %s", semCode, year, description);

        courseWriter.println(courseData);
        courseWriter.close();
        courseBufferedWriter.close();
        courseFile.close();

//        print -> add cource to database successfully

    }

    public static void addCourseTaken() throws IOException {
        String lastName = sc.next();
        String firstName = sc.next(); // float
        String coursePrefix = sc.next();
        String courseNumber = sc.next(); // int
        String courseGrade = sc.next();
        String courseDescription = sc.next(); // int

        try {
            File courseFileObj = new File("courseTaken.txt");
            if (courseFileObj.createNewFile()) {
                System.out.println("File created: " + courseFileObj.getName());
            }
//            else {
//                System.out.println("File already exists.");
//            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        FileWriter courseFile = new FileWriter("courseTaken.txt", true);
        BufferedWriter courseBufferedWriter = new BufferedWriter(courseFile);
        PrintWriter courseWriter = new PrintWriter(courseBufferedWriter);

        String courseData = String.format("%s %s %s %s %s %s", lastName, firstName, coursePrefix, courseNumber, courseGrade, courseDescription);
        System.out.println(courseData);

        courseWriter.println(courseData);
        courseWriter.close();
        courseBufferedWriter.close();
        courseFile.close();
    }

    public static void addStudent() throws IOException {
        String lastName = sc.next();
        String firstName = sc.next(); // float
        String phoneNumber = sc.next(); // float

        try {
            File courseFileObj = new File("student.txt");
            if (courseFileObj.createNewFile()) {
                System.out.println("File created: " + courseFileObj.getName());
            }
//            else {
//                System.out.println("File already exists.");
//            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        FileWriter courseFile = new FileWriter("student.txt", true);
        BufferedWriter courseBufferedWriter = new BufferedWriter(courseFile);
        PrintWriter courseWriter = new PrintWriter(courseBufferedWriter);

        String courseData = String.format("%s %s %s", lastName, firstName, phoneNumber);

        courseWriter.println(courseData);
        courseWriter.close();
        courseBufferedWriter.close();
        courseFile.close();
    }

    // lc: list all courses
    public static void listAllCourses() throws IOException {
        try {
            FileInputStream courseInputStream = new FileInputStream("course.txt");
            Scanner courseScanner = new Scanner(courseInputStream);
            while (courseScanner.hasNext()) {
                System.out.println(courseScanner.nextLine());
            }
            courseInputStream.close();
        } catch (IOException e) {
            System.out.println("File error");
        }
    }

    public static void listInformation(String file) throws IOException {
        try {
            FileInputStream courseInputStream = new FileInputStream(file + ".txt");
            Scanner courseScanner = new Scanner(courseInputStream);
            while (courseScanner.hasNext()) {
                System.out.println(courseScanner.nextLine());
            }
            courseInputStream.close();
        } catch (IOException e) {
            System.out.println("No file found");
        }
    }

    public static void listStudents() throws IOException {
        try {
            FileInputStream courseInputStream = new FileInputStream("student.txt");
            Scanner courseScanner = new Scanner(courseInputStream);
            while (courseScanner.hasNext()) {
                String line = courseScanner.nextLine();
                String[] elements = line.split(" ");
                System.out.println(elements[0] + ", " + elements[1] + "  " + elements[2]);
            }
            courseInputStream.close();
        } catch (IOException e) {
            System.out.println("File error");
        }
    }

    // TRANSCRIPT COMMAND
    public static void getStudentTranscript() throws IOException {
        FileInputStream semesterFile = new FileInputStream("semester.txt");
        FileInputStream courseFile = new FileInputStream("course.txt");
        FileInputStream courseTaken = new FileInputStream("courseTaken.txt");

        Scanner courseTakenScanner = new Scanner(courseTaken);
        Scanner semesterScanner = new Scanner(semesterFile);
        Scanner courseScanner = new Scanner(courseFile);

        String firstName = sc.next();
        String lastName = sc.next();

//        String[] matchedCourseTaken = new String[20];
        ArrayList<String> courseTakenData = new ArrayList<>();
        ArrayList<String> semesterList = new ArrayList<>();

        HashMap<String, ArrayList<String>> transcriptionMap = new HashMap<>();
        HashMap<String, String> courseMap = new HashMap<>();
        HashMap<String, Integer> courseHourMap = new HashMap<>();

        // build course taken list
        while (courseTakenScanner.hasNext()) {
            String line = courseTakenScanner.nextLine();
            String[] elements = line.split(" ");
            if (elements[0].equals(firstName) && elements[1].equals(lastName)) {
//                System.out.println("Matched:" + line);
                courseTakenData.add(line);
            }
        }

        // build semester list
        while (semesterScanner.hasNext()) {
            String line = semesterScanner.nextLine();
//            String[] lineElement = line.split(" ");
            semesterList.add(line);
        }

//        System.out.println("Semester:" + semesterList);

        // build transcription map
        for (String s : courseTakenData) {
//            System.out.println("S: " + s);
            String semCode = s.split(" ")[5]; // e.g. F86
            transcriptionMap.put(semCode, new ArrayList<>());
        }

        // build courses in a semester
        for (String s : courseTakenData) {
//            System.out.println("S: " + s);
            String semCode = s.split(" ")[5]; // e.g. F86
            ArrayList<String> semList = transcriptionMap.get(semCode);
            semList.add(s);

//            for (String m : semesterData) {
//                String[] mEl = m.split(" ");
//                if (semCode.equals(mEl[0])) {
////                    System.out.println(semCode);
////                    System.out.println("Semester: " + mEl[2] + " " + mEl[1]);
//
//
//                }
//            }
        }

//        System.out.println(transcriptionMap);

//        for (String key : transcriptionMap.keySet()) {
//            String val = transcriptionMap.get(key).toString();
////            System.out.println(key + val);
//
//            for (String semList : semesterList) {
//                String[] splitSemList = semList.split(" ");
//                String semCode = splitSemList[0];
//                if (key.equals(semCode))  {
//                    System.out.printf("============ Semester: %s %s ============\n\n", splitSemList[2], splitSemList[1]);
//                }
////                System.out.println();
//            }
//        }

        // build course map vs course+hours map
        while (courseScanner.hasNext()) {
            String line = courseScanner.nextLine();
            String[] courseElements = line.split(" ");
            String courseCode = courseElements[1];
            String data = String.format("%s%s %s (%s)", courseElements[0], courseElements[1], courseElements[2], courseElements[3]);
            courseMap.put(courseCode, data);

            Integer courseHour = Integer.parseInt(courseElements[3]);
            courseHourMap.put(courseCode, courseHour);
        }

//        System.out.println("CourseMap: " + courseMap);
//        System.out.println("Course Hour Map: " + courseHourMap);

        double gpa = 0.0;
        double totalCourses = 0.0;
        Integer totalHours = 0;
        // main logic
        for (String sem : semesterList) {
            String[] semElements = sem.split(" ");
            String semCode = semElements[0];


            if (transcriptionMap.containsKey(semCode)) {
                // print semester title
                System.out.printf("\n============ Semester: %s %s ============\n", semElements[2], semElements[1]);

                ArrayList<String> courses = transcriptionMap.get(semCode);
//                System.out.println(courses);
                // print courses taken by a student
                for (String course : courses) {
//                    System.out.println(course);
                    String[] courseElement = course.split(" ");
                    String courseCode = courseElement[3];
                    String gradeLetter = courseElement[4];

                    System.out.println(courseMap.get(courseCode) + " " + gradeLetter);

                    // calculate for GPA
                    if (gradeLetter.equals("A")) {
                        gpa += 4.0;
                    } else if (gradeLetter.equals("B")) {
                        gpa += 3.0;
                    } else if (gradeLetter.equals("C")) {
                        gpa += 2.0;
                    } else if (gradeLetter.equals("D")) {
                        gpa += 1.0;
                    } else if (gradeLetter.equals("B+")) {
                        gpa += 3.5;
                    }

                    totalCourses += 1.0;
                    totalHours += courseHourMap.get(courseCode);
                }

            }

        }

        gpa = gpa / (totalCourses * 4.0) * 4.0;

        System.out.printf("\nSTUDENT HOURS COMPLETED: %d\n", totalHours);
        System.out.printf("STUDENT GPA: %.2f\n\n", gpa);

        courseFile.close();
        semesterFile.close();
        courseTaken.close();

        semesterScanner.close();
        courseScanner.close();
        courseTakenScanner.close();
    }


}
