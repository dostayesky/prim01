package pane;

import item.Book;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import utils.GetDisplay;
import utils.Goto;

import java.util.ArrayList;

public class BookPane extends GridPane {
    public BookPane(Book book){
        setPrefWidth(428);
        setHgap(8);
        setPadding(new Insets(4));
        add(GetDisplay.image(book,160),0,0,1,3);
        add(GetDisplay.name(book,18,250, TextAlignment.LEFT),1,0);
        add(GetDisplay.author(book,16,250,TextAlignment.LEFT),1,1);
        add(GetDisplay.stars(book,16),1,3);
        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Goto.bookPage(book);
            }
        });
    }


}
