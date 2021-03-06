package com.example.projetospring.repositories;

import com.example.projetospring.model.CategoriaSoma;
import com.example.projetospring.model.ContasAPagar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContasAPagarRepository extends JpaRepository<ContasAPagar, Long> {


    @Query("SELECT new com.example.projetospring.model.CategoriaSoma(obj.categoria, SUM(obj.valorConta)) " +
            " FROM ContasAPagar AS obj WHERE obj.usuario.usuarioId = :id GROUP BY obj.categoria")
    List<CategoriaSoma> amountGroupedByCategoria(Long id);

    @Query("SELECT c FROM ContasAPagar c WHERE c.usuario.usuarioId = :id")
    List<ContasAPagar> contasByUsuario(Long id);
}
