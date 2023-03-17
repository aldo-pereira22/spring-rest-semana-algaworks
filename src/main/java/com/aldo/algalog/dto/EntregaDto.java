package com.aldo.algalog.dto;

import com.aldo.algalog.model.Destinatario;
import com.aldo.algalog.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;


@Getter
@Setter
public class EntregaDto {
    private Long id;
    private String nomeCliente;
    private DestinatarioDto destinatario;
    private BigDecimal taxa;
    private StatusEntrega status;
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizacao;

}
