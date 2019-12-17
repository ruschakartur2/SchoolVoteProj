package sample;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends Application {

    private static int votesFor4Classes = 0;

    private static int votesFor5Classes = 0;
    private static int votesFor6Classes = 0;
    private static int votesFor7Classes = 0;
    private static int votesFor8Classes = 0;
    private static int votesFor9Classes = 0;
    private static int votesFor10Classes = 0;
    private static int votesFor11Classes = 0;

    private static int firstCandidPoints = 0;
    private static int secondCandidPoints = 0;
    private static int thirdCandidPoints = 0;

    FileWriter fileWriter = null;
    @Override
    public void start(Stage primaryStage) throws Exception {
        String[] candidats = new String[3];
        BufferedReader reader;


        try{
            int i = 0;
            reader = new BufferedReader(new FileReader("src/sample/assets/textFiless/Кандидати.txt"));
            String line = reader.readLine();
            while(line != null){
                candidats[i] = line;
                i++;
                line = reader.readLine();
            }
        reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        AnchorPane root = new AnchorPane();
        AnchorPane rootButtons = new AnchorPane();
        AnchorPane rootLabel = new AnchorPane();

        AnchorPane chooseClass = new AnchorPane();
        AnchorPane chooseCandidate = new AnchorPane();
        VBox showClasses = new VBox();
        showClasses.setSpacing(40);
        HBox showCandidates = new HBox();
        showCandidates.setSpacing(150);



        Button result = new Button("Завершити голосування");
        result.setStyle("-fx-background-color: yellow;-fx-font-size:17px");
        AnchorPane.setRightAnchor(result,200.0);
        AnchorPane.setTopAnchor(result,400.0);
        result.setPrefSize(260,70);

        Button cont = new Button("Продовжити голосування");


        AnchorPane.setLeftAnchor(cont,200.0);
        AnchorPane.setTopAnchor(cont,400.0);
        cont.setPrefSize(260,70);
        cont.setStyle("-fx-background-color: yellow;-fx-font-size:17px;");

        Label mainLabel = new Label("Функції виборів");
        mainLabel.setStyle("-fx-font-size:36px;");
        AnchorPane.setTopAnchor(mainLabel,40.0);
        AnchorPane.setLeftAnchor(mainLabel,500.0);
        AnchorPane.setRightAnchor(mainLabel,200.0);

        rootLabel.getChildren().add(mainLabel);
        AnchorPane.setTopAnchor(rootLabel,0.0);
        AnchorPane.setRightAnchor(rootLabel,0.0);
        AnchorPane.setLeftAnchor(rootLabel,0.0);
        AnchorPane.setBottomAnchor(rootLabel,600.0);

        rootLabel.setStyle("-fx-background-color:white");

        rootButtons.getChildren().addAll(result,cont);
        rootButtons.setStyle("-fx-background-color:silver");

        AnchorPane.setTopAnchor(rootButtons,0.0);
        AnchorPane.setLeftAnchor(rootButtons,0.0);
        AnchorPane.setRightAnchor(rootButtons,0.0);
        AnchorPane.setBottomAnchor(rootButtons,0.0);

        root.getChildren().addAll(rootButtons,rootLabel);

        Scene scene = new Scene(root,1300,800);

        ToggleGroup toggleGroup = new ToggleGroup();

        AnchorPane labelClasses = new AnchorPane();
        AnchorPane.setTopAnchor(labelClasses,0.0);
        AnchorPane.setLeftAnchor(labelClasses,0.0);
        AnchorPane.setRightAnchor(labelClasses,0.0);
        AnchorPane.setBottomAnchor(labelClasses,800.0);

        Label classLabel = new Label("Вибери свій клас");
        classLabel.setStyle("-fx-font-size:36px;");
        AnchorPane.setTopAnchor(classLabel,40.0);
        AnchorPane.setLeftAnchor(classLabel,500.0);


        labelClasses.setStyle("-fx-background-color:white");
        labelClasses.getChildren().addAll(classLabel);

        AnchorPane bodyClasses = new AnchorPane();
        AnchorPane.setTopAnchor(bodyClasses,150.0);
        AnchorPane.setLeftAnchor(bodyClasses,0.0);
        AnchorPane.setRightAnchor(bodyClasses,0.0);
        AnchorPane.setBottomAnchor(bodyClasses,0.0);
        bodyClasses.setStyle("-fx-background-color: silver");

        for(int i = 4;i<=11;i++){
            RadioButton rbClass = new RadioButton("" + i);
            rbClass.setToggleGroup(toggleGroup);
            showClasses.getChildren().add(rbClass);
        }

        RadioButton teacher = new RadioButton("Вчитель");
        teacher.setToggleGroup(toggleGroup);
        showClasses.getChildren().add(teacher);

        AnchorPane.setLeftAnchor(showClasses,200.0);
        AnchorPane.setTopAnchor(showClasses,50.0);


        Button toVote = new Button("Продовжити");
        toVote.setPrefSize(250,50);
        toVote.setStyle("-fx-background-color: yellow");
        AnchorPane.setRightAnchor(toVote,150.0);
        AnchorPane.setBottomAnchor(toVote, 70.5);

        bodyClasses.getChildren().addAll(showClasses,toVote);
        chooseClass.getChildren().addAll(labelClasses,bodyClasses);

        AnchorPane headerCand = new AnchorPane();
        Label candLabel = new Label("Обери кандидата");
        candLabel.setStyle("-fx-font-size:36px");
        AnchorPane.setLeftAnchor(candLabel,500.0);
        AnchorPane.setTopAnchor(candLabel,70.0);

        AnchorPane.setLeftAnchor(headerCand,0.0);
        AnchorPane.setRightAnchor(headerCand,0.0);
        AnchorPane.setTopAnchor(headerCand,0.0);
        AnchorPane.setBottomAnchor(headerCand,800.0);

        headerCand.getChildren().add(candLabel);
        ToggleGroup candToggle = new ToggleGroup();
        for(int i = 0;i<candidats.length;i++){
            RadioButton cands = new RadioButton("" + candidats[i]);
            cands.setToggleGroup(candToggle);
            showCandidates.getChildren().addAll(cands);
        }
        AnchorPane bodyCand = new AnchorPane();
        bodyCand.setStyle("-fx-background-color:silver");
        AnchorPane.setLeftAnchor(bodyCand,0.0);
        AnchorPane.setRightAnchor(bodyCand,0.0);
        AnchorPane.setTopAnchor(bodyCand,200.0);
        AnchorPane.setBottomAnchor(bodyCand,0.0);

        AnchorPane.setLeftAnchor(showCandidates,250.0);
        AnchorPane.setTopAnchor(showCandidates,50.0);

        Button vote = new Button("Проголосувати");
        vote.setPrefSize(200,50);
        vote.setStyle("-fx-background-color:yellow");
        AnchorPane.setRightAnchor(vote,200.50);
        AnchorPane.setBottomAnchor(vote,100.5);
        bodyCand.getChildren().addAll(showCandidates,vote);
        chooseCandidate.getChildren().addAll(headerCand,bodyCand);
        // Functionals
        Scene sceneChooseClass = new Scene(chooseClass,1300,800);

        cont.setOnAction(e->{


            primaryStage.setTitle("");
            primaryStage.setScene(sceneChooseClass);
            primaryStage.hide();
            primaryStage.show();
        });

        Scene sceneCandidate = new Scene(chooseCandidate,1300,800);
        toVote.setOnAction(e->{
            RadioButton selected = (RadioButton) toggleGroup.getSelectedToggle();
            switch (selected.getText()){
                case "4":
                    votesFor4Classes ++;
                    break;
                case "5":
                    votesFor5Classes ++;
                    break;
                case "6":
                    votesFor6Classes ++;
                    break;
                case "7":
                    votesFor7Classes ++;
                    break;
                case "8":
                    votesFor8Classes ++;
                    break;
                case "9":
                    votesFor9Classes ++;
                    break;
                case "10":
                    votesFor10Classes ++;
                    break;
                case "11":
                    votesFor11Classes ++;
                    break;
            }

            primaryStage.setTitle("");
            primaryStage.setScene(sceneCandidate);
            primaryStage.show();

        });

        result.setOnAction(e->{
                try {
                    fileWriter = new FileWriter("src/sample/assets/textFiless/Результати.txt");
                    fileWriter.write(candidats[0] + " Points = " + firstCandidPoints + "\n");
                    fileWriter.write(candidats[1] + " Points = " + secondCandidPoints + "\n");
                    fileWriter.write(candidats[2] + " Points = " + thirdCandidPoints + "\n");
                    if(firstCandidPoints > secondCandidPoints && firstCandidPoints > thirdCandidPoints){
                        fileWriter.write("Winner  " + candidats[0] + " With points = " + firstCandidPoints );
                    }
                    if(secondCandidPoints > firstCandidPoints && secondCandidPoints > thirdCandidPoints) {
                        fileWriter.write("Winner  " + candidats[1] + " With points = " + secondCandidPoints);
                    }

                    if(thirdCandidPoints > secondCandidPoints && thirdCandidPoints > firstCandidPoints){
                        fileWriter.write("Winner  " + candidats[2] + " With points = " + thirdCandidPoints );
                    }
                    fileWriter.close();
                    ;
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                primaryStage.close();
        });

        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.show();

        vote.setOnAction(e->{

            RadioButton selected = (RadioButton) candToggle.getSelectedToggle();
            if(selected.getText().equals(candidats[0])){
                firstCandidPoints++;
            }
            if(selected.getText().equals(candidats[1])){
                secondCandidPoints++;
            }
            if(selected.getText().equals(candidats[2])){
                thirdCandidPoints++;
            }
            primaryStage.setTitle("");
            primaryStage.setScene(scene);
            primaryStage.show();

        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
