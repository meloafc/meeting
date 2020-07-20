package com.meloafc.meeting.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PautaVotoDTO extends PautaDTO {

    private Long votosSim;
    private Long votosNao;

}
