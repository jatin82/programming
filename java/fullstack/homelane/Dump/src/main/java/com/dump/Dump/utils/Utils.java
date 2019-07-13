package com.dump.Dump.utils;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.ObjectUtils;

import com.dump.Dump.model.Player;
import com.dump.Dump.model.PlayerAffilations;
import com.dump.Dump.model.PlayerDetails;
import com.dump.Dump.model.PlayerStats;
import com.dump.Dump.model.PlayerTraits;
import com.dump.Dump.utils.Constants.HotelMamangementAttributes;


public class Utils {
	
	public static boolean validateAttributes(List<String> attributes) {
		
		attributes = attributes.parallelStream().filter(attr->{
			try {
				HotelMamangementAttributes.getAttributes(attr);
				return false;
			}
			catch(IllegalArgumentException ex) {
				return true;
			}
		}).collect(Collectors.toList());
		
		return ObjectUtils.isEmpty(attributes);
	}
	
	public static List<Player> readFromFile(File file) throws IOException{
		List<Player> players = new ArrayList<>();
		FileScanner scanner = new FileScanner(file);
		scanner.next();
		String row = scanner.next();
		while(row!="") {
			
			List<String> token = new ArrayList(Arrays.asList(row.split(Constants.splitByCommaRegex)));
			while(Player.property > token.size()) {
				token.add(new String());
			}
			PlayerDetails details = new PlayerDetails();
			details.setName(token.get(1));
			details.setAge(Integer.parseInt(token.get(2)));
			details.setPhoto(token.get(3));
			details.setOverall(Integer.parseInt(token.get(6)));
			details.setPotential(Integer.parseInt(token.get(7)));
			details.setValue(token.get(10));
			details.setWage(token.get(11));
			
			PlayerAffilations affilations = new PlayerAffilations();
			affilations.setClub(token.get(8));
			affilations.setClubLogo(token.get(9));
			affilations.setFlag(token.get(5));
			affilations.setNationality(token.get(4));
			
			PlayerStats stats = new PlayerStats();
			stats.setFreeKickAccuracy(token.get(23));
			stats.setHeadingAccuracy(token.get(29));
			stats.setInterceptions(token.get(30));
			stats.setJumping(token.get(31));
			stats.setLongPassing(token.get(32));
			stats.setLongShots(token.get(33));
			stats.setMarking(token.get(34));
			stats.setPenalties(token.get(35));
			stats.setShotPower(token.get(39));
			stats.setSlidingTackle(token.get(40));
			stats.setSprintSpeed(token.get(41));
			stats.setStamina(token.get(42));
			stats.setStandingTackle(token.get(43));
			stats.setStrength(token.get(44));
			stats.setVision(token.get(45));
			
			PlayerTraits traits = new PlayerTraits();
			traits.setAggression(token.get(14));
			traits.setAgility(token.get(15));
			traits.setBalance(token.get(16));
			traits.setBallControl(token.get(17));
			traits.setComposure(token.get(18));
			traits.setPreferredPositioning(token.get(63));
			
			
			Player player = new Player();
			player.setDetails(details);
			player.setAffilations(affilations);
			player.setStats(stats);
			player.setTraits(traits);
			
			players.add(player);
			row = scanner.next();
		}
		return players;
	}
	
	
	public static List<String> getAllColumns(File file) throws IOException {
		List<String> columns = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String token = reader.readLine();
		if(ObjectUtils.isEmpty(token))
		{
			reader.close();
			return columns;
		}
		
		String[] tokens = token.split(",");
		for(String tok:tokens) {
			if(!ObjectUtils.isEmpty(tok))
			columns.add(tok);
		}
		reader.close();
		return columns;
	}

}

