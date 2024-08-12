package app.crud.controller;

import app.crud.entity.Carro;
import app.crud.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// recebe as requisiçoes de fora
@RestController
@RequestMapping("/api/carro")
public class CarroController {

    @Autowired
    CarroService carroService;

    @PostMapping("/create")
    public ResponseEntity<Boolean> save(@RequestBody Carro carro){
        try{
            ResponseEntity<Boolean> response = new ResponseEntity<>(carroService.save(carro) , HttpStatus.OK);
            return response;
        }catch (Exception e){
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<Carro> findById(@PathVariable Long id){
        ResponseEntity<Carro> response = new ResponseEntity<>(carroService.findById(id),HttpStatus.OK);
        if(response.getBody() != null ){
            return response;
        }else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
            ResponseEntity<Boolean> response = new ResponseEntity<>(carroService.delete(id),HttpStatus.OK);
            if(Boolean.TRUE.equals(response.getBody())){
                return response;
            }else{
                return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
            }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean> update(@PathVariable Long id, @RequestBody Carro carro){
        ResponseEntity<Boolean> response = new ResponseEntity<>(carroService.update(carro,id),HttpStatus.OK);
        if(Boolean.TRUE.equals(response.getBody())){
            return response;
        }else{
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByModelo")
    public ResponseEntity<List<Carro>> findByModelo(@RequestParam String modelo){
        List<Carro> response = carroService.findByModelo(modelo);
        if(response != null){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByMarca")
    public ResponseEntity<List<Carro>> findByMarca(@RequestParam Long idMarca){
        List<Carro> response = carroService.findByMarca(idMarca);
        if(response != null){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findAcimaAno")
    public ResponseEntity<List<Carro>> findAcimaAno(@RequestParam int ano){
        List<Carro> response = carroService.findAcimaAno(ano);
        if(response != null){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
