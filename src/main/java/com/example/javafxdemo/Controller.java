package com.example.javafxdemo;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextArea questionArea;
    @FXML
    RadioButton answer1, answer2, answer3, answer4;

    @FXML
    ToggleGroup answers;
    private String[] questions = {"Ваш любимый фрукт?", "Какой цвет холодный?", "Какая самая большая цифра?"};

    private String[][] variants2 = {
            {"Банан", "Киви", "Апельсин", "Мандарин"}, {"Желтый", "Синий", "Красный", "Оранжевый"}, {"0", "9", "999", "бесконечность"}
    };
    private String[] correctVariants = {
            "Апельсин", "Синий", "9"
    };

    private String correctVariant = "Апельсин";


    private int count = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        quiz(count);
    }

    public void quiz(int count){
        questionArea.setText(questions[count]);
        answer1.setText(variants2[count][0]);
        answer2.setText(variants2[count][1]);
        answer3.setText(variants2[count][2]);
        answer4.setText(variants2[count][3]);
    }



    public void tryToAnswer() {
        if(((RadioButton)answers.getSelectedToggle()).getText().equals(correctVariants[count])) {
            if(count < variants2.length-1){
                count++;
            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Правильно!");
            alert.showAndWait();
            quiz(count);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Не правильно!");
            alert.showAndWait();
        }
    }
}