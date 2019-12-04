package de.ics.cardmarket4j;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import de.ics.cardmarket4j.entity.Account;
import de.ics.cardmarket4j.entity.Address;
import de.ics.cardmarket4j.entity.BankAccount;
import de.ics.cardmarket4j.entity.Conversation;
import de.ics.cardmarket4j.entity.Message;
import de.ics.cardmarket4j.entity.User;
import de.ics.cardmarket4j.entity.deserializer.AccountDeserializer;
import de.ics.cardmarket4j.entity.deserializer.AddressDeserializer;
import de.ics.cardmarket4j.entity.deserializer.BankAccountDeserializer;
import de.ics.cardmarket4j.entity.deserializer.ConversationDeserializer;
import de.ics.cardmarket4j.entity.deserializer.MessageDeserializer;
import de.ics.cardmarket4j.entity.deserializer.UserDeserializer;

/**
 * Class that catches NullPointerExceptions while getting responses from the
 * Json-File.
 * 
 * @author QUE
 *
 */
public class JsonIO {

	private static Gson gson;

	public static Gson getGson() {
		if (gson == null) {
			GsonBuilder gsonBuilder = new GsonBuilder();
			gsonBuilder.registerTypeAdapter(Account.class, new AccountDeserializer());
			gsonBuilder.registerTypeAdapter(Address.class, new AddressDeserializer());
			gsonBuilder.registerTypeAdapter(BankAccount.class, new BankAccountDeserializer());
			gsonBuilder.registerTypeAdapter(Conversation.class, new ConversationDeserializer());
			gsonBuilder.registerTypeAdapter(Message.class, new MessageDeserializer());
			gsonBuilder.registerTypeAdapter(User.class, new UserDeserializer());

			gson = gsonBuilder.create();
		}
		return gson;
	}

	public static BigDecimal parseBigDecimal(JsonObject jObject, String fieldName) {
		try {
			return jObject.get(fieldName).getAsBigDecimal();
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean parseBoolean(JsonObject jObject, String fieldName) {
		try {
			return jObject.get(fieldName).getAsBoolean();
		} catch (Exception e) {
			return false;
		}
	}

	public static double parseDouble(JsonObject jObject, String fieldName) {
		try {
			return jObject.get(fieldName).getAsDouble();
		} catch (Exception e) {
			return 0;
		}
	}

	public static int parseInteger(JsonObject jObject, String fieldName) {
		try {
			return jObject.get(fieldName).getAsInt();
		} catch (Exception e) {
			return 0;
		}
	}

	public static LocalDateTime parseLocalDateTime(JsonObject jObject, String fieldName, DateTimeFormatter dtf) {
		try {
			String ldt = parseString(jObject, fieldName);
			ldt = ldt.split("\\+0[0-9]")[0] + "+0" + ldt.split("\\+0")[1].charAt(0) + ":" + ldt.split("\\+0[0-9]")[1];
			return LocalDateTime.parse(ldt, dtf);
		} catch (Exception e) {
			return null;
		}
	}

	public static String parseString(JsonObject jObject, String fieldName) {
		try {
			return jObject.get(fieldName).getAsString();
		} catch (Exception e) {
			return null;
		}
	}

}
