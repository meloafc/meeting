package com.meloafc.meeting.repository;

import com.meloafc.meeting.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {

    List<Voto> findAllByPautaIdAndUsuarioId(Long pautaId, Long usuarioId);
    long countByPautaIdAndAprovaPauta(Long pautaId, boolean aprovaPauta);

}
