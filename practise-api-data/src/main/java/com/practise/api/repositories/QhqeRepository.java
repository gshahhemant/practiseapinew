package com.practise.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practise.api.jpa.entity.QhqeUserEntity;

@Repository
public interface  QhqeRepository extends CrudRepository<QhqeUserEntity,String>{
	
	@Query("SELECT qh FROM QhqeUserEntity qh WHERE qh.activerUser ='Y' and qh.qhqeId = :qhueId")
	public List<QhqeUserEntity> getQhqeDetail(@Param("qhueId") String qhueId);
	
}
