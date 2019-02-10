package com.dump.Dump.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dump.Dump.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer>{

	
}
