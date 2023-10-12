package app.service;

import app.dto.CarroDTO;
import app.dto.LivroDTO;
import app.entity.Carro;
import app.entity.Livro;
import app.repository.CarroRepository;
import app.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<CarroDTO> listAll(){
        List<Carro> lista = carroRepository.findAll();
        List<CarroDTO> listaDTO = new ArrayList<>();

        for(int i=0; i<lista.size(); i++)
            listaDTO.add(this.toCarroDTO(lista.get(i)));

        return listaDTO;
    }

    public CarroDTO save(CarroDTO carroDTO){
        Carro carro = this.toCarro(carroDTO);

        Carro carrosalva = carroRepository.save(carro);

        return this.toCarroDTO(carrosalva);
    }

    private CarroDTO toCarroDTO(Carro carro) {
        CarroDTO carroDTO = new CarroDTO();
        carroDTO.setId(carro.getId());
        carroDTO.setNome(carro.getNome());
        carroDTO.setMarca(carro.getMarca());
        return carroDTO;
    }

    private Carro toCarro(CarroDTO carroDTO) {
        Carro carro = new Carro();
        carro.setId(carroDTO.getId());
        carro.setNome(carroDTO.getNome());
        carro.setMarca(carroDTO.getMarca());
        return carro;
    }

}
