package core;

import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;

public enum DefaultMessages {
	INVALID_COMMAND("This command isn't recognized. Type .help for a list of commands."),
	HELP();
	
	MessageBuilder msgToSend;
	
	DefaultMessages() {
		this.msgToSend = new MessageBuilder().setEmbed(new EmbedBuilder().setTitle("List of commands")
				.addField(".wakeup", "Return the best time to get to sleep, takes a time in HH:MM 24 hours format.")
				.addField(".sleepat", "Return the best times to get up, takes a time in HH:MM 24 hours format.")
				.setFooter("Bot created by PowerPixel"));
	}
	
	DefaultMessages(String s){
		this.msgToSend = new MessageBuilder().append("Command not recognized, type ")
				.appendCode(null, ".help")
				.append(" for help.");
	}

	MessageBuilder get() {
		return this.msgToSend;
		
	}
}
