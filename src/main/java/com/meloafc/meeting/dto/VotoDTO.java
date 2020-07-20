package com.meloafc.meeting.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VotoDTO {

    private Long pautaId;
    private Long usuarioId;
    private Boolean aprovaPauta;

}
