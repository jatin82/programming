package com.data.DataApp.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.data.DataApp.model.Player;
import com.data.DataApp.model.PlayerAffilations;
import com.data.DataApp.model.PlayerDetails;

public interface PlayerRepository extends JpaRepository<Player, Integer>{

	
	List<Player> findByDetailsIn(List<PlayerDetails> details);
	List<Player> findByAffilationsIn(List<PlayerAffilations> affilations);
}
