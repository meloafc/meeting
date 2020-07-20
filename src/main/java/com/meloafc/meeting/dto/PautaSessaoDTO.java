package com.meloafc.meeting.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PautaSessaoDTO {

    private Long id;
    private Long duracaoVotacaoMinutos;

}
