package com.data.DataApp.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.data.DataApp.model.PlayerAffilations;

public interface PlayerAffilationsRepository extends JpaRepository<PlayerAffilations, Integer>{

	List<PlayerAffilations> findByClubIn(List<String> clubs);
}
