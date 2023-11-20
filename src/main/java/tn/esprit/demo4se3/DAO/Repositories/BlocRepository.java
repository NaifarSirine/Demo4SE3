package tn.esprit.demo4se3.DAO.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.demo4se3.DAO.Entities.Bloc;

import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc,Long> {

    //select * from Bloc where nomBloc=...
    List<Bloc> findByNomBloc(String nomBloc);
    Bloc getByNomBloc(String nomBloc);
    @Query("select b from Bloc b where b.nomBloc=?1")//JPQL
    List<Bloc> selectByNom(String nomBloc);
    @Query("select b from Bloc b where b.nomBloc=:nom")//JPQL
    List<Bloc> selectByNom2(@Param("nom") String nomBloc);

    @Query(value = "select * from bloc where nom_bloc=?1",nativeQuery = true)//SQL
    List<Bloc> selectByNomSQL(String nomBloc);


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

//    @Query("select b from Bloc b JOIN Chambre c ON c.bloc.idBloc=b.idBloc where c.typeChambre=?1") //JPQL
//    List<Bloc> methode(TypeChambre typeChambre);
//
//    @Query(value = "select b from bloc b JOIN chambre c ON b.id_bloc=c.(FK dans la BD)" +
//            ") where c.type_chambre=?1", nativeQuery = true) //SQL
//    List<Bloc> methode(TypeChambre typeChambre);


    // select b from Bloc b JOIN Chambre c ON b.idBloc=c.(FK) where c.typeChambre=...
    // and capaciteBloc> ...

    // List<Bloc> getByChambresTypeChambreAndCapaciteBlocGreaterThan(TypeChambre type, int capacite);

    // Bech njib les blocs elli 3andhom des chambres el type mte3hom met3addi en paramétre
    // w 3andhom des réservations mta3 des chambres el status mte3hom met3addi en paramétre
    // (estValide)
    //List<Bloc> getByChambresTypeChambreAndChambresReservationsEstValide(TypeChambre type,boolean estValide);

    @Modifying //Insert (Sql seulement), update, delete
    @Query("delete from Bloc where capaciteBloc=?1") // JPQL
    void suppByCapacite(long capacite);

    @Modifying
    @Query(value = "delete from bloc where capacite_bloc=?1", nativeQuery = true) // SQL
    void suppByCapaciteSQL(long capacite);
}