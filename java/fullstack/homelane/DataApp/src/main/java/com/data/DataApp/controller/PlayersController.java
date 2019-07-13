package com.data.DataApp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.data.DataApp.exception.PlatformException;
import com.data.DataApp.model.Player;
import com.data.DataApp.model.PlayerAffilations;
import com.data.DataApp.model.PlayerDetails;
import com.data.DataApp.model.ResponseData;
import com.data.DataApp.respository.PlayerAffilationsRepository;
import com.data.DataApp.respository.PlayerDetailsRepository;
import com.data.DataApp.respository.PlayerRepository;
import com.data.DataApp.utils.Constants;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayersController.
 */
@RestController
public class PlayersController {

	/** The player repository. */
	@Autowired
	private PlayerRepository playerRepository;

	/** The details repository. */
	@Autowired
	private PlayerDetailsRepository detailsRepository;

	/** The affilations repository. */
	@Autowired
	private PlayerAffilationsRepository affilationsRepository;

	/**
	 * Gets the player info by name controller.
	 *
	 * @param name the name
	 * @param club the club
	 * @return the player info by name controller
	 * @throws PlatformException the platform exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@GetMapping("/info")
	public ResponseEntity<ResponseData> getPlayerInfoByNameController(@PathParam("name") String name,
			@PathParam("club") String club) throws PlatformException, IOException {

		if (!ObjectUtils.isEmpty(name)) {
			String[] names = name.split(",");
			List<String> playerNames = new ArrayList<>(Arrays.asList(names));

			List<PlayerDetails> details = this.detailsRepository.findByNameIn(playerNames);
			List<Player> players = this.playerRepository.findByDetailsIn(details);

			return new ResponseEntity<ResponseData>(
					new ResponseData<List<Player>>(players, Constants.SUCCESS, HttpStatus.OK), HttpStatus.OK);

		} else if (!ObjectUtils.isEmpty(club)) {
			String[] clubs = club.split(",");
			List<String> clubNames = new ArrayList<>(Arrays.asList(clubs));

			List<PlayerAffilations> affilations = this.affilationsRepository.findByClubIn(clubNames);
			List<Player> players = this.playerRepository.findByAffilationsIn(affilations);

			return new ResponseEntity<ResponseData>(
					new ResponseData<List<Player>>(players, Constants.SUCCESS, HttpStatus.OK), HttpStatus.OK);

		} else {
			return new ResponseEntity<ResponseData>(
					new ResponseData<String>("No parameter found", Constants.FAILED, HttpStatus.NOT_FOUND),
					HttpStatus.NOT_FOUND);
		}

	}

}
