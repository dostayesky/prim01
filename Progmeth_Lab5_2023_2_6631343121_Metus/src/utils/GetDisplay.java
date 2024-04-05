package utils;

import item.Book;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class GetDisplay {
    public static Text Description(Book book, int frontSize , int wrappingWidth){
        Text text = new Text(book.getDescription());
        text.setFont(new Font(frontSize));
        text.setWrappingWidth(wrappingWidth);

        return text;
    }

    public static ImageView image(Book book, int fitHeight){
        ImageView imageView = new ImageView(book.getImage());
        imageView.setPreserveRatio(true);
        imageView.setFitHeight(fitHeight);
        return imageView;
    }
    public static Text name(Book book, int fontSize, int wrappingWidth, TextAlignment textAlignment){
        Text text = new Text(book.getName());
        text.setFont(new Font(fontSize));
        text.setWrappingWidth(wrappingWidth);
        text.setTextAlignment(textAlignment);
        return text;
    }
    public static Text author(Book book, int fontSize, int wrappingWidth, TextAlignment textAlignment){
        Text text = new Text(book.getAuthor());
        text.setFill(Color.GRAY);
        text.setFont(new Font(fontSize));
        text.setWrappingWidth(wrappingWidth);
        text.setTextAlignment(textAlignment);
        return text;
    }
    public static Text stars(Book book,int frontSize){
        String string = "★".repeat(book.getStars())+"☆".repeat(5-book.getStars());
        Text text = new Text(string);
        text.setFill(Color.DARKRED);
        text.setFont(new Font(frontSize));
        return text;
    }


}
