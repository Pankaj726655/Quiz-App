package com.javajunction.quizapp.service;

import com.javajunction.quizapp.model.Question;
import com.javajunction.quizapp.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo repo;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try{
            return new ResponseEntity<>(repo.findByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<Question> addQuestion(Question question) {
        try{
            return new ResponseEntity<>(repo.save(question),HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(repo.save(question),HttpStatus.BAD_REQUEST);
    }

    public void deleteQuestion(int id) {
        repo.deleteById(id);
    }

    public Question updateQuestion(Question question) {
        return repo.save(question);
    }

    public void load(){
        List<Question> questions = new ArrayList<>();
        questions.add(new Question(1, "Which keyword is used to create a class in Java?", "function", "class", "public", "void", "class", "Easy", "Java"));
        questions.add(new Question(2, "Which of the following is not a primitive data type in Java?", "int", "boolean", "float", "String", "String", "Easy", "Java"));
        questions.add(new Question(3, "What is the output of 3 + 2 * 2 in Java?", "7", "10", "9", "6", "7", "Medium", "Java"));
        questions.add(new Question(4, "Which method is used to start a thread in Java?", "run()", "start()", "begin()", "init()", "start()", "Medium", "Multithreading"));
        questions.add(new Question(5, "Which interface does java.util.List implement?", "Collection", "Set", "List", "Iterable", "Collection", "Medium", "Collections"));
        questions.add(new Question(6, "Which of the following is a mutable class in Java?", "String", "StringBuilder", "Integer", "Float", "StringBuilder", "Medium", "Java"));
        questions.add(new Question(7, "What is the size of an int in Java?", "16 bits", "32 bits", "64 bits", "8 bits", "32 bits", "Easy", "Java"));
        questions.add(new Question(8, "Which operator is used to concatenate strings in Java?", "+", "++", "&", "&&", "+", "Easy", "Java"));
        questions.add(new Question(9, "Which exception is thrown when dividing by zero in Java?", "NullPointerException", "IOException", "ArithmeticException", "ClassNotFoundException", "ArithmeticException", "Easy", "Exceptions"));
        questions.add(new Question(10, "What is the time complexity of accessing an element in an ArrayList?", "O(1)", "O(n)", "O(log n)", "O(n^2)", "O(1)", "Medium", "Data Structures"));
        questions.add(new Question(11, "Which data structure uses FIFO (First In First Out)?", "Stack", "Queue", "Array", "HashMap", "Queue", "Easy", "Data Structures"));
        questions.add(new Question(12, "Which design pattern ensures a class has only one instance?", "Observer", "Factory", "Singleton", "Adapter", "Singleton", "Hard", "Design Patterns"));
        questions.add(new Question(13, "In Java, 'this' keyword refers to?", "Current class", "Parent class", "Child class", "Object class", "Current class", "Easy", "Java"));
        questions.add(new Question(14, "Which of the following is a functional interface in Java?", "List", "Comparator", "Thread", "Object", "Comparator", "Medium", "Java 8"));
        questions.add(new Question(15, "Which class is used for creating threads by extending it?", "Thread", "Runnable", "Executor", "Future", "Thread", "Medium", "Multithreading"));
        questions.add(new Question(16, "Which method is used to terminate a Java program?", "exit()", "break()", "return()", "System.exit()", "System.exit()", "Medium", "Java"));
        questions.add(new Question(17, "Which of these methods is used to read a file in Java?", "readFile()", "Scanner()", "read()", "openFile()", "read()", "Hard", "File Handling"));
        questions.add(new Question(18, "Which of the following is a correct way to define a lambda expression in Java?", "x -> x*x", "(int x) -> x", "x => x*x", "(x) => x*x", "x -> x*x", "Medium", "Java 8"));
        questions.add(new Question(19, "Which sorting algorithm has a time complexity of O(n log n)?", "Merge Sort", "Bubble Sort", "Selection Sort", "Insertion Sort", "Merge Sort", "Hard", "Algorithms"));
        questions.add(new Question(20, "Which of the following is not a pillar of OOP?", "Encapsulation", "Polymorphism", "Abstraction", "Inheritance", "None of the above", "Easy", "OOP Concepts"));
        repo.saveAll(questions);
    }
}
