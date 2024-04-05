package pane;

import item.Book;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import utils.GetDisplay;
import utils.Goto;

public class NewBookPane extends GridPane {
    public NewBookPane() {
        setPadding(new Insets(12));
        setVgap(8);
        TextField nameInput = input();
        TextField authorInput = input();
        TextField ratingInput = input();
        TextField imageInput = input();
        TextField descriptionInput = input();
        ColumnConstraints columnConstraints1 = new ColumnConstraints();
        columnConstraints1.setHalignment(HPos.RIGHT);
        columnConstraints1.setPercentWidth(25);
        ColumnConstraints columnConstraints2 = new ColumnConstraints();
        columnConstraints2.setPercentWidth(75);
        Button button = new Button("Add");
        button.setMaxWidth(430);
        button.setPrefHeight(32);
        button.setTextFill(Color.WHITE);
        button.setBackground(new Background(new BackgroundFill(Color.DARKCYAN,null,null)));
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handleClick(nameInput.getText(),authorInput.getText(),ratingInput.getText() ,imageInput.getText() ,descriptionInput.getText());
            }
        });
        getColumnConstraints().addAll(columnConstraints1,columnConstraints2);
        add(label("Title: "), 0, 0);
        add(label("Author"), 0, 1);
        add(label("Rating: "), 0, 2);
        add(label("Image: "), 0, 3);
        add(label("Description: "), 0, 4);
        add(nameInput, 1, 0);
        add(authorInput, 1, 1);
        add(ratingInput, 1, 2);
        add(imageInput, 1, 3);
        add(descriptionInput, 1, 4);
        add(button, 0, 5, 2, 1);


    }
    private Text label(String s){
        Text text = new Text(s);
        text.setFont(new Font(16));
        return text;
    }
    private TextField input(){
        TextField textField = new TextField();
        textField.setBackground(new Background(new BackgroundFill(Color.WHITE,new CornerRadii(16),null)));
        textField.setBorder(new Border(new BorderStroke(Color.DARKCYAN,BorderStrokeStyle.SOLID,new CornerRadii(16),null)));
        return textField;
    }
    private void handleClick(String name, String author, String rating, String image, String description){
        if(!(name.isBlank()||author.isBlank()||rating.isBlank()||image.isBlank()||description.isBlank())){
            BookListPane.getInstance().getBooks().add(new Book(name,author,rating,image,description));
            BookListPane.getInstance().setSearchedBooks(BookListPane.getInstance().getBooks());
            Goto.mainPage();
        }

    }


}
