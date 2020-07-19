package com.meloafc.meeting.dto;

import com.meloafc.meeting.enums.PautaStatus;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PautaDTO {

    private Long id;
    private String assunto;
    private PautaStatus status;

}
