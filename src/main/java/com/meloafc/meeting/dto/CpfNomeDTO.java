package com.meloafc.meeting.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CpfNomeDTO {

    private Long cpf;
    private String nome;

}
