package pane;

import item.Book;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Predicate;

public class SearchPane extends HBox {
    public SearchPane(){
        setAlignment(Pos.CENTER);
        TextField textField =new TextField();
        textField.setPrefWidth(250);
        textField.setPromptText("Find the book");
        Button button = new Button("Search");
        button.setBackground(new Background(new BackgroundFill(Color.DARKCYAN,null,null)));
        button.setTextFill(Color.WHITE);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ArrayList<Book> filter = (ArrayList<Book>) BookListPane.getInstance().getBooks().clone();
                if (textField.getText().isBlank()){
                    BookListPane.getInstance().setSearchedBooks(filter);
                }
                else {
                    filter.removeIf(book -> !(book.getName().contains(textField.getText())));
                }
                BookListPane.getInstance().setSearchedBooks(filter);
                }
            });
        getChildren().addAll(textField,button);

    }
}
