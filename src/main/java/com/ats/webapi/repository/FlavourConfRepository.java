package com.ats.webapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.webapi.model.FlavourConf;

@Repository
public interface FlavourConfRepository extends JpaRepository<FlavourConf, Integer>{

	FlavourConf findByDelStatusAndSpfIdAndSpId(int i, int spfId, int spId);

	List<FlavourConf> findByDelStatus(int i);

	FlavourConf findBySpIdAndSpfIdAndDelStatus(int spId, int spfId, int i);

}
