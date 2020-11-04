/* ***************************************************************************
 * GUI
 ****************************************************************************
 * Front end for HorrorscopesGetter
 *_____________________________________________________
 * William "Resident DumbDonkey" Coleman, Christine "City of Angles" Angeles, Tara "Ram" Mohan, Shan "Muffin Man" Amir
 * The version date
 * CMSC 255 Section 3
 ****************************************************************************/
package Horrorscope;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.Object;
import javafx.scene.control.Alert;
import java.io.FileInputStream;
import java.sql.Time;

public class GUI extends Application {

    @Override
    public void start(Stage stage) throws FileNotFoundException {

        // Setting up and formatting the stage
        stage.setTitle("Horrorscope Generator");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Setting up and formatting the scene
        Text scenetitle = new Text("Get your Horoscope");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        // Label for the datePicker field
        Label calLabel = new Label("Date of Birth:");
        grid.add(calLabel, 0, 2, 1, 1);
        calLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));

        //Set up and format the datePicker
        DatePicker calendar = new DatePicker();
        calendar.setPromptText("Select your birthday");
        grid.add(calendar, 1, 2, 3, 1);

        // Creates the button
        Button jokeHoro = new Button("Joke Horo");
        Button srsHoro = new Button("Serious Horos");


        // Add buttons to the scene
        grid.add(jokeHoro, 0, 3);
        grid.add(srsHoro, 0, 4);

        // initializes the scene
        Scene scene = new Scene(grid, 500, 450);


        /*
         * Creating default background size
         */

        // Create a file input stream
        InputStream input = getClass().getClassLoader().getResourceAsStream("backdrop.jpg");
        // create a image object
        Image image = new Image(input);
        // Create BackgroundSize object
        BackgroundSize bgSize = new BackgroundSize(100, 100, true, true, true, true);
        // Create a background image object
        BackgroundImage defaultBackgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                bgSize);
        // Create default Background
        Background defaultBackground = new Background(defaultBackgroundImage);

        // Set default background
        grid.setBackground(defaultBackground);

        // Set the scene to the main stage
        stage.setScene(scene);
        // Display the main stage
        stage.show();

        // Display offensive content warning
        showAlert(Alert.AlertType.WARNING, grid.getScene().getWindow(), "Warning:", "This program " +
                "contains text generated via machine learning trained on input from the internet.\nMAY " +
                "CONTAIN OFFENSIVE CONTENT");

        jokeHoro.setOnAction(new EventHandler<ActionEvent>() {
                                 @Override
                                 public void handle(ActionEvent e) {
                                     if (calendar.getValue() != null) { // If the DatePicker is empty, don't crash plz
                                         HorrorscopeGetter horoGetter = new HorrorscopeGetter();
                                         String horoscope = horoGetter.getJokeHoroscope();
                                         String sign = HorrorscopeGetter.getBirthSign(calendar.getValue());
                                         showAlert(Alert.AlertType.INFORMATION, grid.getScene().getWindow(), (sign), (horoscope));
                                     }
                                 }
                             }
        );

        srsHoro.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent e) {
                                    if (calendar.getValue() != null) { // If the DatePicker is empty, don't crash plz
                                        HorrorscopeGetter horoGetter = new HorrorscopeGetter();
                                        String horoscope = horoGetter.getRealHoroscope();
                                        String sign = HorrorscopeGetter.getBirthSign(calendar.getValue());
                                        showAlert(Alert.AlertType.INFORMATION, grid.getScene().getWindow(), (sign), (horoscope));
                                    }
                                }
                            }
        );
    }

        private void showAlert (Alert.AlertType alertType, Window owner, String title, String message){
            Alert alert = new Alert(alertType);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.initOwner(owner);
            alert.show();
        }
        public static void main (String[]args){
            launch(args);
        }
    }




