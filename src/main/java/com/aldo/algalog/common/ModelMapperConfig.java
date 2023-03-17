package com.aldo.algalog.common;

import com.aldo.algalog.dto.EntregaDto;
import com.aldo.algalog.model.Entrega;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


}
