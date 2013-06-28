import java.util.List;

import javax.swing.JLabel;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.examples.user.ShowUser;


public class MyTwitterController {
	
	private final String ConsumerKey = "TRzPzIr9P3tltvhGYlcncg";
	private final String ConsumerSecret = "W2if1AzExMN5RzOtBOfWvlHz3l0apMxIRXfSTOlw";
	private final String AccessToken = "113246486-Hk89cUgxcdFqdc0p29E6sAdzy3o2kwiG7UTJq82U";
	private final String AccessTokenSecret = "zaoBfFNV4urTxAYrHG1ven63BAgMpsPajfGyqdM";
	private Twitter t;
	private JLabel muro;
	
	public MyTwitterController(){
		ConfigurationBuilder cb = new ConfigurationBuilder(); 
		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey(ConsumerKey);
		cb.setOAuthConsumerSecret(ConsumerSecret);
		cb.setOAuthAccessToken(AccessToken);
		cb.setOAuthAccessTokenSecret(AccessTokenSecret);
		TwitterFactory tf = new TwitterFactory(cb.build());
		t = tf.getInstance();
	}
	
	public Twitter getTwitterIntance(){
		return t;
	}
	
	public List<Status> getTimeLine() throws TwitterException{
		Twitter twitter = this.getTwitterIntance();
		List<Status> statuses = twitter.getHomeTimeline();
		return statuses;
	}
	
	public void postTweet(String msg) throws TwitterException{
		Twitter twitter = this.getTwitterIntance();
		Status status = twitter.updateStatus(msg);
		System.out.println("Mensaje [ " + status.getText() + " ]" );
	}
	
	public void imaUsuario() throws Exception, TwitterException{
		Twitter twitter=this.getTwitterIntance();
		User usuario=twitter.showUser(twitter.getId());
		JLabel icono=new JLabel(usuario.getURL());
	}
}
