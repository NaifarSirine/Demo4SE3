package tn.esprit.demo4se3.Services;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.demo4se3.DAO.Entities.Bloc;
import tn.esprit.demo4se3.DAO.Repositories.BlocRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class BlocService implements IBlocService{
    BlocRepository blocRepository;

    @Override
    public Bloc add(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public List<Bloc> addAll(List<Bloc> blocs) {
        return blocRepository.saveAll(blocs);
    }

    @Override
    public Bloc update(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public List<Bloc> findAll() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc findById(long id) {
        //return blocRepository.findById(id).get();
        return blocRepository.findById(id).orElse(Bloc.builder().idBloc(0)
                                                    .capaciteBloc(0).nomBloc("Bloc masset")
                                                    .build());
    }

    @Override
    public void delete(Bloc b) {
        blocRepository.delete(b);
    }

    @Override
    public void deleteById(long id) {
        blocRepository.deleteById(id);
    }
}
