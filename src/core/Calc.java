package core;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.javacord.api.entity.message.MessageBuilder;

public class Calc {

	@SuppressWarnings("deprecation")
	private static ArrayList<Float> sleepCycles = new ArrayList<Float>(
			Arrays.asList(new Float(9.0), new Float(7.5), new Float(6.0), new Float(4.5)));

	public static MessageBuilder bestSleepHours(String string) {
		LocalTime timeOfWakeUp = LocalTime.parse(string);

		List<LocalTime> potentialTimeOfSleep = new ArrayList<LocalTime>();

		for (Float numberOfHours : sleepCycles)
			potentialTimeOfSleep.add(timeOfWakeUp.minusMinutes((long) (numberOfHours.floatValue() * 60)));

		String messageToSend = "The best times to go to sleep are : \n";

		for (LocalTime timeInList : potentialTimeOfSleep)
			messageToSend += "- " + timeInList.toString() + "\n";

		return new MessageBuilder().append(messageToSend);
	}

	public static MessageBuilder bestWakeUpHours(String string) {
		LocalTime timeOfWakeUp = LocalTime.parse(string);

		List<LocalTime> potentialTimeOfSleep = new ArrayList<LocalTime>();

		for (Float numberOfHours : sleepCycles)
			potentialTimeOfSleep.add(timeOfWakeUp.plusMinutes((long) (numberOfHours.floatValue() * 60)));

		String messageToSend = "The best times to wake up at are : \n";

		for (LocalTime timeInList : potentialTimeOfSleep)
			messageToSend += "- " + timeInList.toString() + "\n";

		return new MessageBuilder().append(messageToSend);

	}

}
