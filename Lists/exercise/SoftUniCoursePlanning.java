package Lists.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> coursesList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("course start")){
            String [] commandArray = command.split(":");
            String input = commandArray[0];
            switch (input){
                case "Add":
                    String lessonAdd = commandArray[1];
                    if (!coursesList.contains(lessonAdd)){
                        coursesList.add(lessonAdd);
                    }
                    break;
                case "Remove":
                    String lessonRemove = commandArray[1];
                    String exerciseRemove = lessonRemove + "-Exercise";
                    if (coursesList.contains(lessonRemove)){
                        coursesList.remove(lessonRemove);
                    int indexForRemove = coursesList.indexOf(lessonRemove);
                        if (coursesList.get(indexForRemove + 1).equals(exerciseRemove)){
                            coursesList.remove(indexForRemove + 1);
                        }
                    }
                    break;
                case "Insert":
                    String lessonInsert = commandArray[1];
                    int indexInsert = Integer.parseInt(commandArray[2]);
                    if (!coursesList.contains(lessonInsert)){
                        coursesList.add(indexInsert, lessonInsert);
                    }
                    break;
                case "Swap":
                    String firstLesson = commandArray[1];
                    String secondLesson = commandArray[2];
                    if (coursesList.contains(firstLesson) && coursesList.contains(secondLesson)){
                       int index1 = coursesList.indexOf(firstLesson);
                       int index2 = coursesList.indexOf(secondLesson);
                       coursesList.set(index1, secondLesson);
                       coursesList.set(index2, firstLesson);
                    String firstEx = firstLesson + "-Exercise";
                    String secondEx = firstLesson + "-Exercise";
                       if (coursesList.get(index1 + 1).equals(firstEx)){
                           coursesList.add(index2 + 1, firstEx);
                           coursesList.remove(index1 + 1);
                       }
                       if (coursesList.get(index2 + 1).equals(secondEx)){
                           coursesList.add(index1 + 1, secondEx);
                           coursesList.remove(index2 + 1);
                       }
                    }
                    break;
                case "Exercise":
                    String lessonExercises = commandArray[1];
                    String exercise = lessonExercises + "-Exercise";
                    int indexOfLesson = coursesList.indexOf(lessonExercises);
                    if (coursesList.contains(lessonExercises)){
                        coursesList.add(indexOfLesson + 1, exercise);
                    }else {
                        coursesList.add(lessonExercises);
                        coursesList.add(exercise);
                    }
                    break;
            }


            command = scanner.nextLine();
        }

        for (int i = 0; i < coursesList.size() ; i++) {
            System.out.printf("%d.%s%n", i+1, coursesList.get(i));
        }
    }
}
