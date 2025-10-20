package br.com.VMartins.consultaApiViaCep.controller;


import br.com.VMartins.consultaApiViaCep.dto.CepDto;
import br.com.VMartins.consultaApiViaCep.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@CrossOrigin(origins = "*")
public class CepController {

    @Autowired
    private CepService cepService;


    @GetMapping("/consultaCep/{cep}")
    public CepDto retornarConsultaCep(@PathVariable String cep){

        try {
            return cepService.consultaCep(cep);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
