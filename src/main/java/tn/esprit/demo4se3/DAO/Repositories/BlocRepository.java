package tn.esprit.demo4se3.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.demo4se3.DAO.Entities.Bloc;

@Repository
public interface BlocRepository extends JpaRepository<Bloc,Long> {
}
