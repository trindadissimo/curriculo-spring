package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Model.Curriculo;
import com.example.Repository.CurriculoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CurriculoService {

    @Autowired
    private CurriculoRepository curriculoRepository;

    public List<Curriculo> getCurriculos() {
        return curriculoRepository.findAll();
    }

    public Optional<Curriculo> getCurriculo(Long id) {
        return curriculoRepository.findById(id);
    }

    public Curriculo createCurriculo(Curriculo curriculo) {
        return curriculoRepository.save(curriculo);
    }

    public Curriculo updateCurriculo(Long id, Curriculo curriculo) {
        if (curriculoRepository.existsById(id)) {
            curriculo.setId(id);
            return curriculoRepository.save(curriculo);
        } else {
            throw new RuntimeException("Curriculo não encontrado");
        }
    }

    public void deleteCurriculo(Long id) {
        curriculoRepository.deleteById(id);
    }
}
