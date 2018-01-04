package EnigmaMachine;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Run_Decrypt extends Application
{
	private Pane pane = new Pane();
	private Scene scene = new Scene(pane, 800, 600);
	private TextArea ta = new TextArea();
	private TextArea ta1 = new TextArea();
	private TextField tt, tt0, tt1;
	private TextFlow tf, tf0, tf1, tf2;
	private Button button = new Button("Decrypt");
	private EnigmaMachine enigma = new EnigmaMachine();

	@Override
	public void start(Stage stage) throws Exception 
	{
		addItems();
		buttonPressed();
		
		stage.setTitle("Decrypt");
		stage.setScene(scene);
		stage.show();
	}
	
	public void addItems()
	{
		Text t = new Text("Enter Encrypted Message: ");
		tf = new TextFlow(t);
		tf.setTranslateX(10);
		tf.setTranslateY(20);
		
		ta.setTranslateX(10);
		ta.setTranslateY(70);
		ta.setMaxSize(300, 200);
		
		Text t0 = new Text("Enter Letter Value for Rooter I:");
		tf0 = new TextFlow(t0);
		tf0.setTranslateX(350);
		tf0.setTranslateY(40);
		
		tt = new TextField();
		tt.setTranslateX(580);
		tt.setTranslateY(40);
		tt.setMaxWidth(50);
		
		Text t1 = new Text("Enter Letter Value for Rooter II:");
		tf1 = new TextFlow(t1);
		tf1.setTranslateX(350);
		tf1.setTranslateY(100);
		
		tt0 = new TextField();
		tt0.setTranslateX(580);
		tt0.setTranslateY(100);
		tt0.setMaxWidth(50);
		
		Text t2 = new Text("Enter Letter Value for Rooter III:");
		tf2 = new TextFlow(t2);
		tf2.setTranslateX(350);
		tf2.setTranslateY(160);
		
		tt1 = new TextField();
		tt1.setTranslateX(580);
		tt1.setTranslateY(160);
		tt1.setMaxWidth(50);
		
		button.setTranslateX(230);
		button.setTranslateY(280);
		
		ta1.setTranslateX(10);
		ta1.setTranslateY(330);
		ta1.setMaxSize(300, 200);
		
		
		
		pane.getChildren().addAll(tf, ta, ta1, tf0, tf1, tf2, tt, tt0, tt1, button);
	}
	
	public void buttonPressed()
	{
		String key = tt.getText() + tt0.getText() + tt1.getText();
		
		button.setOnAction(e ->{
			enigma.reset();
			//enigma.set();
			enigma.moveMatrixDecrypt(key);
			String message = enigma.startDecrypting(ta.getText());
			ta1.setText(message);
			
		});
		
	}
	
	public static void main(String[] args)
	{
		Application.launch(args);
	}

}
