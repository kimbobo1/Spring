package pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pack.entity.BuserEntity;

public interface BuserRepository extends JpaRepository<BuserEntity, Integer>{

}
