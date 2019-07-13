package com.data.DataApp.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.data.DataApp.model.PlayerDetails;

public interface PlayerDetailsRepository extends JpaRepository<PlayerDetails, Integer>  {

	List<PlayerDetails> findByNameIn(List<String> names);
}
