package main;

import org.alicebot.ab.*;
//import appGUI.*;

public class venus {

	private static String response;
	private static String request;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		appGUI window = new appGUI();
		
		// gets the path of the root folder for this project
		String path = System.getProperty("user.dir");
		//System.out.println(path); //Prints in console the path to root folder -- just for me to check
		path +="/bin";
		System.out.println(path);
		
		//Names the bot
		String botname="Venus";
		//creates a AIML bot based on the files that it finds in path
		Bot bot = new Bot(botname, path);
		
		//creates a new chat session
		Chat chatSession = new Chat(bot);
		
		//initialises the variable for the user message
		request = "";
		
		//initialises the variable for the bot response
		response = chatSession.multisentenceRespond(request);
		
		//System.out.println(response); //just to check if initialisation went ok
		String requestOld=request;
		
		//Creates a new GUI from class app
				
		while(true){
			request=window.getUserMessage();
			if (request!=requestOld){
				response = chatSession.multisentenceRespond(request);
				window.setVenusOutput(response);
				requestOld=request;	
				//appGUI.frameworksetvisible(true);
				
			}
		}
	}

}
