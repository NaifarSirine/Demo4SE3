package tn.esprit.demo4se3.RestControllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo4se3.DAO.Entities.Bloc;
import tn.esprit.demo4se3.Services.IBlocService;

import java.util.List;

@RestController
@AllArgsConstructor
public class BlocRestController {
    IBlocService iBlocService;

    @PostMapping("addBloc")
    public Bloc addBloc(@RequestBody Bloc b){
        return iBlocService.add(b);
    }

    @PutMapping("updateBloc")
    public Bloc updateBloc(@RequestBody Bloc b){
        return iBlocService.update(b);
    }

    @PostMapping("addAllBloc")
    public List<Bloc> addAll(@RequestBody List<Bloc> blocs){
        return iBlocService.addAll(blocs);
    }

    //http://localhost:8081/findBlocById/1
    @GetMapping("findBlocById/{id}")
    public Bloc findBlocById(@PathVariable("id") long id){
        return iBlocService.findById(id);
    }

    //http://localhost:8081/findBlocById2?id=1
    @GetMapping("findBlocById2")
    public Bloc findBlocById2(@RequestParam("id") long id){
        return iBlocService.findById(id);
    }


}
