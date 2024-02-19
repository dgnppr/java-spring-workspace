package me.dgpr.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InnerRepository extends JpaRepository<InnerEntity, Long> {

}
