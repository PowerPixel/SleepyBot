package core;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageBuilder;

public class Bot {
	DiscordApi currentApi;

	public void start() {
		currentApi = new DiscordApiBuilder()
				.addMessageCreateListener(event ->{
			Message messageRead = event.getMessage();
			
			String[] contentOfMessage = messageRead.getContent().split(" ");
			
			MessageBuilder messageToSend = DefaultMessages.INVALID_COMMAND.get();
			if(contentOfMessage[0].startsWith(".")) {
				switch(contentOfMessage[0]) {
					case ".wakeat":
						messageToSend = Calc.bestSleepHours(contentOfMessage[1]);
						break;
					case ".sleepat":
						messageToSend = Calc.bestWakeUpHours(contentOfMessage[1]);
						break;
					case ".help":
						messageToSend = DefaultMessages.HELP.get();
				
				}
				messageToSend.send(event.getChannel());
			}
			
		}).setToken("NzQ0MTQxMDAwMDk1ODI2MDMx.Xze5Tw.oPZ27goCcx5btxB4Tpfx7OExDE0")
				.login()
				.join();
		System.out.println(currentApi.createBotInvite());
	}

}
