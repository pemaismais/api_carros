package app.crud.service;

import app.crud.entity.Carro;
import app.crud.entity.Marca;
import app.crud.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// conecta com o banco
@Service
public class CarroService {

    @Autowired
    CarroRepository carroRepository;

    public Boolean save(Carro carro){
        try {
            carroRepository.save(carro);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public Carro findById(Long id){
        Optional<Carro> carro = carroRepository.findById(id);
        return carro.orElse(null);
    }
    public Boolean delete(Long id){
            if (carroRepository.findById(id).isPresent()){
                carroRepository.deleteById(id);
                return true;
            }else{
                return false;
            }
    }
    public Boolean update(Carro carro, Long id){
        if (carroRepository.findById(id).isPresent()){
            carro.setId(id);
            carroRepository.save(carro);
            return true;
        }else{
            return false;
        }
    }
    public List<Carro> findByModelo(String modelo){
        List<Carro> carros = carroRepository.findByModelo(modelo);
        if(carros.isEmpty() ){
            return null;
        }else{
            return carros;
        }
    }

    public List<Carro> findAcimaAno(int ano){
        List<Carro> carros = carroRepository.findAcimaAno(ano);
        if(carros.isEmpty()){
            return null;
        }else{
            return carros;
        }
    }

    public List<Carro> findByMarca(Long id){
        Marca marca = new Marca();
        marca.setId(id);
        List<Carro> carros = carroRepository.findByMarca(marca);
        if(carros.isEmpty()){
            return null;
        }else{
            return carros;
        }
    }
}
