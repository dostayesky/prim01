package utils;

import item.Book;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import pane.*;

public class Goto {
    private static RootPane rootPane;
    public static void setRootPane(RootPane rootPane){
        Goto.rootPane = rootPane;
    }
    public static void clear(){
        if (rootPane.getChildren().size() > 1){
//            var first = rootPane.getChildren().getFirst();
//            rootPane.getChildren().clear();
//            rootPane.getChildren().add(first);
            rootPane.getChildren().subList(1,rootPane.getChildren().size()).clear();
        }
    }
    public static void mainPage(){
        clear();
        ScrollPane scrollPane = new ScrollPane(BookListPane.getInstance());
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        rootPane.getChildren().addAll(new SearchPane(),scrollPane);
    }
    public static Button backToMainPageBotton(){
        Button button = new Button("Back");
        button.setBorder(new Border(new BorderStroke(Color.DARKCYAN, BorderStrokeStyle.SOLID,null,new BorderWidths(2))));
        button.setBackground(new Background(new BackgroundFill(Color.WHITE,null,null)));
        button.setTextFill(Color.DARKCYAN);
        button.setPrefWidth(300);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mainPage();
            }
        });
        return button;
    }
    public static void bookPage(Book book){
        clear();
        Text name = GetDisplay.name(book,28,336, TextAlignment.CENTER);
        Text author = GetDisplay.author(book,24,336,TextAlignment.CENTER);
        author.setText(String.format("By %s",book.getAuthor()));
        ImageView imageView = GetDisplay.image(book,320);
        Text stars =GetDisplay.stars(book,24);
        Text description = GetDisplay.Description(book,16,336);
        rootPane.getChildren().addAll(backToMainPageBotton(),name,author,imageView,stars,description);
    }
    public static void addNewBookPage(){
        clear();
        rootPane.getChildren().add(backToMainPageBotton());
        rootPane.getChildren().add(new NewBookPane());

    }

}
