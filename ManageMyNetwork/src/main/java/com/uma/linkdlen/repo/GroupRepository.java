package com.uma.linkdlen.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uma.linkdlen.entity.Groups;

public interface GroupRepository extends JpaRepository<Groups, Long> {

	Optional<Groups> findById(Long id);

	void deleteById(Long id );


}
