package com.example.projetospring.services;

import com.example.projetospring.model.ContasAReceber;
import com.example.projetospring.model.Usuario;
import com.example.projetospring.repositories.ContasAReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContasAReceberService {

    @Autowired
    private ContasAReceberRepository repository;

    @Autowired
    private ContasAPagarService contasAPagarService;

    public List<ContasAReceber> findAll (){
        Usuario usuario = contasAPagarService.getUsuarioLogado();
        return repository.contasByUsuario(usuario.getUsuarioId());
    }

    public ContasAReceber findById(Long id){
        Optional<ContasAReceber> obj = repository.findById(id);
        return obj.get();
    }

    public ContasAReceber inserir(ContasAReceber contasareceber) {
        Usuario usuario = contasAPagarService.getUsuarioLogado();
        contasareceber.setUsuario(usuario);
        return repository.save(contasareceber);
    }

    public void deletarConta (Long Id) {
        repository.deleteById(Id);
    }

    public ContasAReceber editarConta (Long Id, ContasAReceber contasareceber) {
        ContasAReceber c1 = repository.findById(Id).get();
        updateData(c1, contasareceber);
        return repository.save(c1);
    }

    private void updateData (ContasAReceber c1, ContasAReceber contasareceber) {
        c1.setNomeConta(contasareceber.getNomeConta());
        c1.setValorConta(contasareceber.getValorConta());
        c1.setCategoria(contasareceber.getCategoria());
    }
}
