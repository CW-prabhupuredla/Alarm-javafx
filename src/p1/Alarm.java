package p1;

import java.io.File;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Line;
import javafx.util.Duration;
public class Alarm implements Initializable{
	@FXML
	private Button button;
	@FXML
	private Button b2;
	@FXML
	private TextField t1;
	@FXML
	private Line hourHand;
	@FXML
	private Line minuteHand;
	@FXML
	private Line secondHand;
	@FXML
	private Button dismiss;
	@FXML
	private TextField t2;
	@FXML
	private Button enter;

	public int hour,minute,sec;
	public String k;
	public int h,m,s,sm,ss,sh;
	Media media=new Media(new File("C:/Users/Home/Documents/Java lab programs/Alarm/Music/play.mp3/").toURI().toString());
	MediaPlayer player=new MediaPlayer(media);

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 assert button != null :"fx:id=\"button\" was not injected: check your fxml file";
		 //method1();
		 assert b2 !=null :"fx:id=\"b2\" was not injected: check your fxml file";
	}
	public void read(ActionEvent event){

				int x=getvalue();
				//getvalue();

				if(x==1){
					System.out.println(h);

				}
				else {
				    t1.clear();
					t1.setPromptText("enter correct format");
				}
				}
		public int getvalue()
			{
				 String t=t1.getText();

				if(t != null && t.charAt(2)==':' && t.charAt(5)==':' ){

					 System.out.println(t);
				h=Integer.parseInt(t1.getText(0,2));
				m=Integer.parseInt(t1.getText(3,5));
				s=Integer.parseInt(t1.getText(6,8));
				return 1;
			}
				else
					return 0;


			}


	public void method(ActionEvent event){

		 Timeline timeline = new Timeline(
				new KeyFrame(Duration.seconds(0),
					        new EventHandler<ActionEvent>() {
					          @Override public void handle(ActionEvent actionEvent) {
					        	  Calendar time = Calendar.getInstance();
					     		  hour=time.get(Calendar.HOUR);

					     		  minute=time.get(Calendar.MINUTE);
					     		  sec=time.get(Calendar.SECOND);

					     		  //System.out.println(h);

					     		 clock();
					     		//System.out.println(ss+":"+sm);
					     		 if((hour==h  && minute==m && sec==s) || (hour==h+sh && minute==m+sm && sec==s+ss)){
					     			player.play();

					     		 }

					     		 //System.out.println(hour+":"+minute+":"+sec);

					          }
					        }
					      ),
					      new KeyFrame(Duration.seconds(1))
			   );
			    timeline.setCycleCount(Animation.INDEFINITE);
			    timeline.play();
			  }
public void off(ActionEvent event)
{
	player.stop();



}

public void method2(ActionEvent event){

	player.stop();
	int x=getvalue1();
	//getvalue();

	if(x==1){
		System.out.println(h);

	}
	else {
	    t2.clear();
		t2.setPromptText("enter correct format");
	}
	}
public int getvalue1()
{
	 String t=t2.getText();

	if(t != null && t.charAt(2)==':' && t.charAt(5)==':' ){

		 System.out.println(t);
	sh=Integer.parseInt(t2.getText(0,2));
	sm=Integer.parseInt(t2.getText(3,5));
	ss=Integer.parseInt(t2.getText(6,8));
	return 1;
}
	else
		return 0;


}


	public void clock(){
		hourHand.setEndX(getHourX());
		hourHand.setEndY(getHourY());
		minuteHand.setEndX(getMinuteX());
		minuteHand.setEndY(getMinuteY());
		secondHand.setEndX(getSecX());
		secondHand.setEndY(getSecY());

	}
	public int hourAngle,minuteAngle,secAngle,radius=120;
	private double hourX,hourY,minuteX,minuteY,secx,secy;

	public int setMinute() {
		minuteAngle =(minute*6-90)%360;
			return minuteAngle;
			}

	public int setHour() {
		hourAngle = (hour*30-90)%360;
			return hourAngle;
			}

	public int setSec()
	{
		secAngle=(sec*6-90)%360;
		return secAngle;

	}

	public double getHourY() {
		hourY=(radius/2)*Math.sin(Math.toRadians(setHour()));
		//read();
		return hourY;
	}

	public double getHourX() {
		hourX=(radius/2)*Math.cos(Math.toRadians(setHour()));
		return hourX;
	}

	public double getMinuteY() {
		minuteY=radius*Math.sin(Math.toRadians(setMinute()));
		return minuteY;
	}

	public double getMinuteX() {

		minuteX=radius*Math.cos(Math.toRadians(setMinute()));
		return minuteX;
	}

	public double getSecX() {
		secx=radius*Math.sin(Math.toRadians(90-setSec()));
		return secx;

	}
	public double getSecY() {
		secy=radius*Math.cos(Math.toRadians(90-setSec()));
		return secy;

	}

	}



