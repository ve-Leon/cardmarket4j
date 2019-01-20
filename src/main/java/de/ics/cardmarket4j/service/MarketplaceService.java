package de.ics.cardmarket4j.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.javatuples.Pair;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import de.ics.cardmarket4j.AbstractService;
import de.ics.cardmarket4j.CardMarket;
import de.ics.cardmarket4j.JsonHelper;
import de.ics.cardmarket4j.enums.Game;
import de.ics.cardmarket4j.enums.HTTPMethod;

public class MarketplaceService extends AbstractService {

	public MarketplaceService(CardMarket cardMarket) {
		super(cardMarket);
		
	}

	public void getExpansions(Game game) throws IOException {
		Pair<Integer, JsonElement> response = request("games/" + game.getId() + "/expansions", HTTPMethod.GET);
	}
	
	public void getProduct(String searchQuery) throws IOException {
		String query = "search=" + searchQuery;
		String encodedQuery = AuthenticationService.rawUrlEncode(query);
		Pair<Integer, JsonElement> response = request("products/find?" + encodedQuery, HTTPMethod.GET);
		//Pair<Integer, JsonElement> response = request("products/find?search=Springleaf", HTTPMethod.GET);
	}
	
	

}
