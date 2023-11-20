package tn.esprit.demo4se3.Services;

import tn.esprit.demo4se3.DAO.Entities.Bloc;

import java.util.List;

public interface IBlocService {
    Bloc add(Bloc b);
    List<Bloc> addAll(List<Bloc> blocs);
    Bloc update(Bloc b);
    List<Bloc> findAll();
    Bloc findById(long id);
    void delete(Bloc b);
    void deleteById(long id);
    List<Bloc> selectByNomBloc(String nomBloc);

}
