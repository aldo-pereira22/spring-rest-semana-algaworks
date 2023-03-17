package com.aldo.algalog.mapper;


import com.aldo.algalog.dto.EntregaDto;
import com.aldo.algalog.dto.input.EntregaIput;
import com.aldo.algalog.model.Entrega;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class EntregaMapper {

    private ModelMapper modelMapper;

    public EntregaDto toModel(Entrega entrega) {
        return modelMapper.map(entrega, EntregaDto.class);
    }


    public List<EntregaDto> toCollectionModel(List<Entrega> entregas){
        return entregas.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Entrega toEntity(EntregaIput entregaIput){
        return modelMapper.map(entregaIput, Entrega.class);
    }
}
