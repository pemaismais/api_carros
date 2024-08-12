package app.crud.controller;

import app.crud.entity.Marca;
import app.crud.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {
    @Autowired
    MarcaService marcaService;

    @PostMapping("/create")
    public ResponseEntity<String> save(@RequestBody  Marca marca){
        if( marcaService.save(marca)){
            return new ResponseEntity<>("Marca cadastrada com sucesso!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Erro ao cadastrar marca", HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<Marca> save(@PathVariable  Long id){
        Marca marca = marcaService.findById(id);
        if(marca != null){
            return new ResponseEntity<>(marca, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(marca, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Marca marca){
        if(marcaService.update(id, marca)){
            return new ResponseEntity<>("Marca alterada com sucesso!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Erro ao alterar marca", HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if(marcaService.deleteById(id)){
            return new ResponseEntity<>("Marca removida com sucesso", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Erro ao remover marca", HttpStatus.BAD_REQUEST);
        }
    }

}
