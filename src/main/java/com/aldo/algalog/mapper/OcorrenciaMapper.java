package com.aldo.algalog.mapper;

import com.aldo.algalog.dto.OcorrenciaDto;
import com.aldo.algalog.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OcorrenciaMapper {

    private ModelMapper modelMapper;

    public OcorrenciaDto toModel(Ocorrencia ocorrencia){
        return  modelMapper.map(ocorrencia, OcorrenciaDto.class);
    }

    public List<OcorrenciaDto> toCollectionModel(List<Ocorrencia> ocorrencias){
        return ocorrencias
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
