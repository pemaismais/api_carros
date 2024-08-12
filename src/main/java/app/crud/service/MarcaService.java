package app.crud.service;

import app.crud.entity.Marca;
import app.crud.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// conversa com o banco
@Service
public class MarcaService {
    @Autowired
    MarcaRepository marcaRepository;

    public boolean save(Marca marca) {
        try {
            marcaRepository.save(marca);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public Marca findById(Long id) {
        Optional<Marca> marca = marcaRepository.findById(id);
        return marca.orElse(null);
    }

    public boolean update(Long id, Marca marca){
        if(marcaRepository.findById(id).isPresent()){
            marca.setId(id);
            marcaRepository.save(marca);
            return true;
        }else{
            return false;
        }
    }

    public boolean deleteById(Long id){
        try{
            marcaRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}