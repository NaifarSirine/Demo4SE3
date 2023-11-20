package tn.esprit.demo4se3.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.demo4se3.DAO.Entities.Bloc;

import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc,Long> {

    //select * from Bloc where nomBloc=...
    List<Bloc> findByNomBloc(String nomBloc);

    Bloc getByNomBloc(String nomBloc);

    //select * from Bloc where nomBloc = ... and capaciteBloc=...
    List<Bloc> findByNomBlocAndCapaciteBloc(String nomBloc, int capacite);

    //select * from Bloc where nomBloc = ... or capaciteBloc=...
    List<Bloc> findByNomBlocOrCapaciteBloc(String nomBloc, int capacite);

    // select * from Bloc where capaciteBloc <...
    List<Bloc> findByCapaciteBlocLessThan(int capacite);

    // select * from Bloc where capaciteBloc >...
    List<Bloc> findByCapaciteBlocGreaterThan(int capacite);

    // select * from Bloc where capaciteBloc <... and capaciteBloc >...
    List<Bloc> findByCapaciteBlocBetween(int min, int max);

    // select * from Bloc Where nomBloc like ... (3 Façons)
    List<Bloc> findByNomBlocLike(String nomBloc);

    List<Bloc> findByNomBlocContaining(String nomBloc);

    List<Bloc> findByNomBlocContains(String nomBloc);

    // select count(*) from Bloc
    long count();

    // select count(*) from Bloc where capaciteBloc=...
    long countByCapaciteBloc(int capacite);

    // select b from Bloc b JOIN Chambre c ON b.idBloc=c.(FK) where c.typeChambre=...
    // List<Bloc> getByChambresTypeChambre(TypeChambre type);

    // select b from Bloc b JOIN Chambre c ON b.idBloc=c.(FK) where c.typeChambre=...
    // and capaciteBloc> ...

    // List<Bloc> getByChambresTypeChambreAndCapaciteBlocGreaterThan(TypeChambre type, int capacite);

    // Bech njib les blocs elli 3andhom des chambres el type mte3hom met3addi en paramétre
    // w 3andhom des réservations mta3 des chambres el status mte3hom met3addi en paramétre
    // (estValide)
    //List<Bloc> getByChambresTypeChambreAndChambresReservationsEstValide(TypeChambre type,boolean estValide);
}