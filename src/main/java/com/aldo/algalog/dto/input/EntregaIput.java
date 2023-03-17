package com.aldo.algalog.dto.input;

import com.aldo.algalog.model.Destinatario;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class EntregaIput {

        @Valid
        @NotNull
        private ClienteIdInput cliente;

        @Valid
        @NotNull
        private DestinatarioInput destinatario;

        @NotNull
        private BigDecimal taxa;

}
