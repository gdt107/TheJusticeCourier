import java.io.File;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;

public class Main extends Application {

	Scene title, option, control, plays, highscore;
	StackPane rootScene, StackContainer1, optionScene, StackContainer2, controlScene, StackContainer3, 
	playScene, StackContainer4, highscoreScene, StackContainer5;
	Text titleLabel;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		AudioClip hover = new AudioClip(getClass().getResource("/assets/audio/sfx/menu_cursor_8.wav").toExternalForm());
		AudioClip click = new AudioClip(getClass().getResource("/assets/audio/sfx/menu_cursor_16.wav").toExternalForm());
				
		//Title Screen
		Font font = Font.loadFont(getClass().getResourceAsStream("/assets/font/prstartk-webfont.ttf"), 20);
		
		Image mainMenu = new Image("/assets/sprite/main_menu.png");
		ImageView menuBg = new ImageView(mainMenu);
		Button play = new Button("Play");
		Button highScore = new Button("High Score");
		Button options = new Button("Option");
		Button quit = new Button("Quit to Desktop");
		
		play.setScaleX(1.5);
		play.setScaleY(1.5);
		play.setTranslateY(-75);
		play.setFont(font);
		play.setTextFill(Color.WHITE);
		play.setStyle("-fx-background-color: transparent;");
		play.setOnMouseEntered(e -> play.setStyle("-fx-border-color: #fcdc80;-fx-background-color: transparent;"));
		play.hoverProperty().addListener(e -> hover.play());
		play.setOnMouseClicked(e -> click.play());
		play.setOnMouseExited(e -> play.setStyle("-fx-background-color: transparent;"));
		play.setOnAction(e -> primaryStage.setScene(plays));
		
		highScore.setScaleX(1.5);
		highScore.setScaleY(1.5);
		highScore.setTranslateY(0);
		highScore.setFont(font);
		highScore.setTextFill(Color.WHITE);
		highScore.setStyle("-fx-background-color: transparent;");
		highScore.setOnMouseEntered(e -> highScore.setStyle("-fx-border-color: #fcdc80;-fx-background-color: transparent;"));
		highScore.hoverProperty().addListener(e -> hover.play());
		highScore.setOnMouseClicked(e -> click.play());
		highScore.setOnMouseExited(e -> highScore.setStyle("-fx-background-color: transparent;"));
		highScore.setOnAction(e -> primaryStage.setScene(highscore));
		
		options.setScaleX(1.5);
		options.setScaleY(1.5);
		options.setTranslateY(75);
		options.setFont(font);
		options.setTextFill(Color.WHITE);
		options.setStyle("-fx-background-color: transparent;");
		options.setOnMouseEntered(e -> options.setStyle("-fx-border-color: #fcdc80;-fx-background-color: transparent;"));
		options.hoverProperty().addListener(e -> hover.play());
		options.setOnMouseClicked(e -> click.play());
		options.setOnMouseExited(e -> options.setStyle("-fx-background-color: transparent;"));
		options.setOnAction(e -> primaryStage.setScene(option));
		
		quit.setScaleX(1.5);
		quit.setScaleY(1.5);
		quit.setTranslateY(150);
		quit.setFont(font);
		quit.setTextFill(Color.WHITE);
		quit.setStyle("-fx-background-color: transparent;");
		quit.setOnMouseEntered(e -> quit.setStyle("-fx-border-color: #fcdc80;-fx-background-color: transparent;"));
		quit.hoverProperty().addListener(e -> hover.play());
		quit.setOnMouseClicked(e -> click.play());
		quit.setOnMouseExited(e -> quit.setStyle("-fx-background-color: transparent;"));
		quit.setOnAction((ActionEvent event) -> {
			Platform.exit();
		});
		
		titleLabel = new Text("The Justice Courier");
		
		titleLabel.setFont(font);
		titleLabel.setScaleX(2);
		titleLabel.setScaleY(2);
		titleLabel.setFill(Color.WHITE);
		titleLabel.setTranslateY(-300);
		
		menuBg.setFitWidth(1366);
		menuBg.setFitHeight(768);
		
		Text credit1 = new Text("Created by T135");
		Text credit2 = new Text("Inspired by The Messenger");
		
		credit1.setFont(font);
		credit1.setFill(Color.GREY);
		credit1.setTranslateY(300);
		credit1.setScaleX(0.5);
		credit1.setScaleY(0.5);
		
		credit2.setFont(font);
		credit2.setFill(Color.GREY);
		credit2.setTranslateY(325);
		credit2.setScaleX(0.5);
		credit2.setScaleY(0.5);
		
		StackContainer1 = new StackPane();
		
		rootScene = new StackPane(menuBg);
		rootScene.getChildren().add(StackContainer1);
		StackContainer1.getChildren().addAll(titleLabel, play, highScore, options, quit, credit1, credit2);
		title = new Scene(rootScene);
		
		// Scene Options
		Text optionTitle = new Text("Options");
		optionTitle.setFont(font);
		optionTitle.setScaleX(1.5);
		optionTitle.setScaleY(1.5);
		optionTitle.setTranslateY(-225);
		optionTitle.setFill(Color.WHITE);
		
		Text music = new Text("Music");
		music.setFont(font);
		music.setFill(Color.WHITE);
		music.setScaleX(1.25);
		music.setScaleY(1.25);
		music.setTranslateY(-125);
		music.setTranslateX(-375);
		
		Slider musicSlider = new Slider();
		musicSlider.setMaxWidth(200);
		musicSlider.setTranslateY(-125);
		musicSlider.setTranslateX(350);
		
		Text soundFX = new Text("Sound FX");
		soundFX.setFont(font);
		soundFX.setFill(Color.WHITE);
		soundFX.setScaleX(1.25);
		soundFX.setScaleY(1.25);
		soundFX.setTranslateY(-75);
		soundFX.setTranslateX(-340);
		
		Slider FXSlider = new Slider();
		FXSlider.setMaxWidth(200);
		FXSlider.setTranslateY(-75);
		FXSlider.setTranslateX(350);
		
		Text showTimer = new Text("Show Timer");
		showTimer.setFont(font);
		showTimer.setFill(Color.WHITE);
		showTimer.setScaleX(1.25);
		showTimer.setScaleY(1.25);
		showTimer.setTranslateX(-315);
		showTimer.setTranslateY(-25);
		
		CheckBox showTime = new CheckBox();
		showTime.setScaleX(1.5);
		showTime.setScaleY(1.5);
		showTime.setTranslateX(270);
		showTime.setTranslateY(-25);
		
		Button controls = new Button(" [ Controls ]");
		controls.setFont(font);
		controls.setTextFill(Color.WHITE);
		controls.setStyle("-fx-background-color: transparent;");
		controls.setOnMouseEntered(e -> controls.setStyle("-fx-border-color: #fcdc80;-fx-background-color: transparent;"));
		controls.hoverProperty().addListener(e -> hover.play());
		controls.setOnMouseClicked(e -> click.play());
		controls.setTranslateX(-325);
		controls.setTranslateY(225);
		controls.setOnAction(e -> primaryStage.setScene(control));
		controls.setOnMouseExited(e -> controls.setStyle("-fx-background-color: transparent;"));
		
		Button back = new Button("[ Back ]");
		back.setFont(font);
		back.setTextFill(Color.WHITE);
		back.setStyle("-fx-background-color: transparent;");
		back.setOnMouseEntered(e -> back.setStyle("-fx-border-color: #fcdc80;-fx-background-color: transparent;"));
		back.hoverProperty().addListener(e -> hover.play());
		back.setOnMouseClicked(e -> click.play());
		back.setTranslateX(325);
		back.setTranslateY(225);
		back.setOnAction(e -> primaryStage.setScene(title));
		back.setOnMouseExited(e -> back.setStyle("-fx-background-color: transparent;"));
		
		Image optionBg = new Image("/assets/sprite/frame.png");
		ImageView viewOption = new ImageView(optionBg);
		ImageView viewOption1 = new ImageView(optionBg);
		ImageView viewOption2 = new ImageView(optionBg);
		
		viewOption.setFitWidth(10000);
		viewOption.setFitHeight(10000);
		viewOption.setPreserveRatio(false);
		
		viewOption1.setFitWidth(1024);
		viewOption1.setFitHeight(576);
		
		viewOption2.setFitWidth(950);
		viewOption2.setFitHeight(450);
		viewOption2.setTranslateY(50);
		
		
		StackContainer2 = new StackPane();
		
		optionScene = new StackPane(viewOption);
		optionScene.getChildren().add(StackContainer2);
		StackContainer2.getChildren().addAll(viewOption1, viewOption2, optionTitle, 
				music, soundFX, showTimer, musicSlider, FXSlider, showTime, controls, back);
		option = new Scene(optionScene, 1366, 768);
		
		//Control Scene
		Image controlBg = new Image("/assets/sprite/frame.png");
		ImageView viewControl = new ImageView(controlBg);
		ImageView viewControl1 = new ImageView(controlBg);
		ImageView viewControl2 = new ImageView(controlBg);
		
		viewControl.setFitWidth(10000);
		viewControl.setFitHeight(10000);
		viewControl.setPreserveRatio(false);
		
		viewControl1.setFitWidth(1024);
		viewControl1.setFitHeight(576);
		
		viewControl2.setFitWidth(950);
		viewControl2.setFitHeight(450);
		viewControl2.setTranslateY(50);
		
		Text controlTitle = new Text("Controls");
		controlTitle.setFont(font);
		controlTitle.setScaleX(1.5);
		controlTitle.setScaleY(1.5);
		controlTitle.setTranslateY(-225);
		controlTitle.setFill(Color.WHITE);
		
		Button Default = new Button(" [ Default ]");
		Default.setFont(font);
		Default.setTextFill(Color.WHITE);
		Default.setStyle("-fx-background-color: transparent;");
		Default.setOnMouseEntered(e -> Default.setStyle("-fx-border-color: #fcdc80;-fx-background-color: transparent;"));
		Default.hoverProperty().addListener(e -> hover.play());
		Default.setOnMouseClicked(e -> click.play());
		Default.setTranslateX(-325);
		Default.setTranslateY(225);
		Default.setOnMouseExited(e -> Default.setStyle("-fx-background-color: transparent;"));
		
		Button back2 = new Button("[ Back ]");
		back2.setFont(font);
		back2.setTextFill(Color.WHITE);
		back2.setStyle("-fx-background-color: transparent;");
		back2.setOnMouseEntered(e -> back2.setStyle("-fx-border-color: #fcdc80;-fx-background-color: transparent;"));
		back2.hoverProperty().addListener(e -> hover.play());
		back2.setOnMouseClicked(e -> click.play());
		back2.setTranslateX(325);
		back2.setTranslateY(225);
		back2.setOnAction(e -> primaryStage.setScene(option));
		back2.setOnMouseExited(e -> back2.setStyle("-fx-background-color: transparent;"));
		
		Text left = new Text("Left");
		left.setFont(font);
		left.setFill(Color.WHITE);
		left.setScaleX(1.25);
		left.setScaleY(1.25);
		left.setTranslateY(-125);
		left.setTranslateX(-375);
		
		Button A = new Button("A");
		A.setFont(font);
		A.setMaxWidth(175);
		A.setTranslateY(-125);
		A.setTranslateX(-125);
		
		Text right = new Text("Right");
		right.setFont(font);
		right.setFill(Color.WHITE);
		right.setScaleX(1.25);
		right.setScaleY(1.25);
		right.setTranslateY(-75);
		right.setTranslateX(-375);
		
		Button D = new Button("D");
		D.setFont(font);
		D.setMaxWidth(175);
		D.setTranslateY(-75);
		D.setTranslateX(-125);
		
		Text duck = new Text("Duck");
		duck.setFont(font);
		duck.setFill(Color.WHITE);
		duck.setScaleX(1.25);
		duck.setScaleY(1.25);
		duck.setTranslateY(-25);
		duck.setTranslateX(-375);
		
		Button S = new Button("S");
		S.setFont(font);
		S.setMaxWidth(175);
		S.setTranslateY(-25);
		S.setTranslateX(-125);
		
		Text jump = new Text("Jump");
		jump.setFont(font);
		jump.setFill(Color.WHITE);
		jump.setScaleX(1.25);
		jump.setScaleY(1.25);
		jump.setTranslateY(25);
		jump.setTranslateX(-375);
		
		Button Space = new Button("SPACE");
		Space.setFont(font);
		Space.setMaxWidth(175);
		Space.setTranslateY(25);
		Space.setTranslateX(-125);
		
		Text interact = new Text("Interact");
		interact.setFont(font);
		interact.setFill(Color.WHITE);
		interact.setScaleX(1.25);
		interact.setScaleY(1.25);
		interact.setTranslateY(75);
		interact.setTranslateX(-350);
		
		Button F = new Button("F");
		F.setFont(font);
		F.setMaxWidth(175);
		F.setTranslateY(75);
		F.setTranslateX(-125);
		
		Text attack = new Text("Attack");
		attack.setFont(font);
		attack.setFill(Color.WHITE);
		attack.setScaleX(1.25);
		attack.setScaleY(1.25);
		attack.setTranslateY(-125);
		attack.setTranslateX(125);
		
		Button J = new Button("J");
		J.setFont(font);
		J.setMaxWidth(175);
		J.setTranslateY(-125);
		J.setTranslateX(350);
		
		Text shuriken = new Text("Shuriken");
		shuriken.setFont(font);
		shuriken.setFill(Color.WHITE);
		shuriken.setScaleX(1.25);
		shuriken.setScaleY(1.25);
		shuriken.setTranslateY(-75);
		shuriken.setTranslateX(125);
		
		Button K = new Button("K");
		K.setFont(font);
		K.setMaxWidth(175);
		K.setTranslateY(-75);
		K.setTranslateX(350);
		
		Text teleport = new Text("Teleport");
		teleport.setFont(font);
		teleport.setFill(Color.WHITE);
		teleport.setScaleX(1.25);
		teleport.setScaleY(1.25);
		teleport.setTranslateY(-25);
		teleport.setTranslateX(125);
		
		Button L = new Button("L");
		L.setFont(font);
		L.setMaxWidth(175);
		L.setTranslateY(-25);
		L.setTranslateX(350);
		
		Text pause = new Text("Pause");
		pause.setFont(font);
		pause.setFill(Color.WHITE);
		pause.setScaleX(1.25);
		pause.setScaleY(1.25);
		pause.setTranslateY(25);
		pause.setTranslateX(125);

		Button Enter = new Button("ENTER");
		Enter.setFont(font);
		Enter.setMaxWidth(175);
		Enter.setTranslateY(25);
		Enter.setTranslateX(350);
		
		
		controlScene = new StackPane(viewControl);
		StackContainer3 = new StackPane();
		controlScene.getChildren().add(StackContainer3);
		StackContainer3.getChildren().addAll(viewControl1, viewControl2, controlTitle, 
				Default, back2, left, right, duck, jump, interact, attack, shuriken,
				teleport, pause, A, D, S, Space, F, J, K, L, Enter);
		control = new Scene(controlScene, 1366, 768);
		
		//Play Scene
		MediaPlayer player = new MediaPlayer(new Media(getClass().getResource("/assets/video/intro_cut.mp4").toExternalForm()));
		MediaView mediaView = new MediaView(player);
		
		mediaView.setFitWidth(1366);
		mediaView.setFitHeight(768);
		
		player.play();
		
		StackContainer4 = new StackPane();
		
		playScene = new StackPane(StackContainer4);
		
		StackContainer4.getChildren().add(mediaView);
		
		plays = new Scene(playScene, 1366, 768);
		
		//Highscore Scene
		Image highscoreBg = new Image("/assets/sprite/frame.png");
		ImageView viewScore = new ImageView(highscoreBg);
		ImageView viewScore1 = new ImageView(highscoreBg);
		
		viewScore.setFitWidth(10000);
		viewScore.setFitHeight(10000);
		viewScore.setPreserveRatio(false);
		
		viewScore1.setFitWidth(1024);
		viewScore1.setFitHeight(576);
		
		Text HighScores = new Text("High Scores");
		HighScores.setFont(font);
		HighScores.setScaleX(1.5);
		HighScores.setScaleY(1.5);
		HighScores.setTranslateY(-225);
		HighScores.setFill(Color.WHITE);
		
		Button Back3 = new Button("Back");
		Back3.setFont(font);
		Back3.setTextFill(Color.WHITE);
		Back3.setStyle("-fx-background-color: transparent;");
		Back3.setOnMouseEntered(e -> Back3.setStyle("-fx-border-color: #fcdc80;-fx-background-color: transparent;"));
		Back3.hoverProperty().addListener(e -> hover.play());
		Back3.setOnMouseClicked(e -> click.play());
		Back3.setTranslateY(250);
		Back3.setOnAction(e -> primaryStage.setScene(title));
		Back3.setOnMouseExited(e -> Back3.setStyle("-fx-background-color: transparent;"));
		
		Text Name1 = new Text("Jason Ananda");
		Name1.setFont(font);
		Name1.setFill(Color.WHITE);
		Name1.setScaleX(1.25);
		Name1.setScaleY(1.25);
		Name1.setTranslateY(-125);
		Name1.setTranslateX(-325);
		
		Text Time1 = new Text("00: 55.312");
		Time1.setFont(font);
		Time1.setFill(Color.WHITE);
		Time1.setScaleX(1.25);
		Time1.setScaleY(1.25);
		Time1.setTranslateY(-125);
		Time1.setTranslateX(350);
		
		Text Name2 = new Text("Tester 123");
		Name2.setFont(font);
		Name2.setFill(Color.WHITE);
		Name2.setScaleX(1.25);
		Name2.setScaleY(1.25);
		Name2.setTranslateY(-75);
		Name2.setTranslateX(-350);
		
		Text Time2 = new Text("01: 04.873");
		Time2.setFont(font);
		Time2.setFill(Color.WHITE);
		Time2.setScaleX(1.25);
		Time2.setScaleY(1.25);
		Time2.setTranslateY(-75);
		Time2.setTranslateX(350);
		
		Text Name3 = new Text("Hello World");
		Name3.setFont(font);
		Name3.setFill(Color.WHITE);
		Name3.setScaleX(1.25);
		Name3.setScaleY(1.25);
		Name3.setTranslateY(-25);
		Name3.setTranslateX(-350);
		
		Text Time3 = new Text("01: 08.017");
		Time3.setFont(font);
		Time3.setFill(Color.WHITE);
		Time3.setScaleX(1.25);
		Time3.setScaleY(1.25);
		Time3.setTranslateY(-25);
		Time3.setTranslateX(350);
		
		Text Name4 = new Text("DnJisme");
		Name4.setFont(font);
		Name4.setFill(Color.WHITE);
		Name4.setScaleX(1.25);
		Name4.setScaleY(1.25);
		Name4.setTranslateY(25);
		Name4.setTranslateX(-350);
		
		Text Time4 = new Text("01: 14.082");
		Time4.setFont(font);
		Time4.setFill(Color.WHITE);
		Time4.setScaleX(1.25);
		Time4.setScaleY(1.25);
		Time4.setTranslateY(25);
		Time4.setTranslateX(350);
		
		Text Name5 = new Text("Jason");
		Name5.setFont(font);
		Name5.setFill(Color.WHITE);
		Name5.setScaleX(1.25);
		Name5.setScaleY(1.25);
		Name5.setTranslateY(75);
		Name5.setTranslateX(-350);
		
		Text Time5 = new Text("01: 18.549");
		Time5.setFont(font);
		Time5.setFill(Color.WHITE);
		Time5.setScaleX(1.25);
		Time5.setScaleY(1.25);
		Time5.setTranslateY(75);
		Time5.setTranslateX(350);
		
		StackContainer5 = new StackPane();
		
		highscoreScene = new StackPane(StackContainer5);
		
		//Name3, Time3, Name4, Time4, Name5, Time5
		//Test
		
		StackContainer5.getChildren().addAll(viewScore, viewScore1, 
				HighScores, Back3, Name1, Time1, Name2, Time2,
				Name3, Time3, Name4, Time4, Name5, Time5);
		
		highscore = new Scene(highscoreScene, 1366, 768);
		
		//Primary Stage
		primaryStage.setTitle("TheJCourier");
		primaryStage.setScene(title);
		primaryStage.setFullScreen(true);
		primaryStage.show();
		
	}

}
