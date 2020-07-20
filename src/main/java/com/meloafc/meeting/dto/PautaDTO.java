package com.meloafc.meeting.dto;

import com.meloafc.meeting.enums.PautaStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PautaDTO {

    private Long id;
    private String assunto;
    private PautaStatus status;

}
