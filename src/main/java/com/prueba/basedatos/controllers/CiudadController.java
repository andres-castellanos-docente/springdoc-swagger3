package com.prueba.basedatos.controllers;

import com.prueba.basedatos.dtos.CiudadDto;
import com.prueba.basedatos.requests.CiudadRequests;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.prueba.basedatos.responses.CiudadResponse;
import com.prueba.basedatos.services.CiudadService;

import javax.validation.Valid;


@RestController
public class CiudadController {

    @Autowired
    private CiudadService ciudadService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "402", description = "Accessing the resource you were trying to reach is forbidden", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found", content = @Content(schema = @Schema(hidden = true)))
    }
    )
    @GetMapping("/ciudad")
    public ResponseEntity<CiudadResponse> getCiudad() {
        return ciudadService.getCiudad();
    }

    @GetMapping("/ciudadxnombre/{nombre}")
    public ResponseEntity<CiudadResponse> getCiudadXNombre(@Parameter(required = true, description = "El nombre de la ciudad") @PathVariable(value = "nombre") String nombciud) {
        return ciudadService.getCiudadFinNombre(nombciud);
    }

    @GetMapping("/ciudadxnombrenative/{nombre}")
    public ResponseEntity<CiudadResponse> getCiudadXNombreNative(@Parameter(required = true, description = "El nombre de la ciudad", content = {}) @PathVariable(value = "nombre") String nombciud) {
        return ciudadService.getCiudadFinNombreNative(nombciud);
    }

    @Operation(description = "Cambia ciudad de Estado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "cambió el estado ok", content = @Content(mediaType = "application/json", examples = {
                    @ExampleObject(
                            name = "Available",
                            value = "available",
                            summary = "Retrieves all the pets that are available")})),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "402", description = "Accessing the resource you were trying to reach is forbidden", content = @Content(schema = @Schema(hidden = true)))
    }
    )

    @PostMapping("/ciudad")
    public ResponseEntity<CiudadResponse> addCiudad(@Schema(
            description = "Book to add.",
            required = true,
            implementation = CiudadDto.class)
                                                    @RequestBody CiudadDto ciudadDto) {

        return ciudadService.createEditCiudad(ciudadDto);
    }

    //Cuerpo personalizado
    @PostMapping("/ciudadcambestado")
    public ResponseEntity<CiudadResponse> editStatusCiudad(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "prueba cambiar body", content = @Content(mediaType = "application/json", examples = {
                    @ExampleObject(
                            name = "Available",
                            value = "{\n" +
                                    "  \"activo\": true,\n" +
                                    "  \"idpais\": 0\n" +
                                    "}",
                            summary = "...")}))  // Swagger
            @RequestBody
            @Valid // Bean validation to ensure if the incoming object is valid
                    CiudadRequests ciudadRequests) {
        return ciudadService.inactivarCiudadporPais(ciudadRequests);
    }


    @PutMapping("/ciudad")
    public ResponseEntity<CiudadResponse> editCiudad(@RequestBody CiudadDto ciudadDto) {
        return ciudadService.createEditCiudad(ciudadDto);
    }

    @DeleteMapping("/ciudad/{id}")
    public ResponseEntity<CiudadResponse> delCiudad(@Parameter(required = true, description = "El id de la ciudad") @PathVariable(value = "id") Integer idCiudad) {
        return ciudadService.removeCiudad(idCiudad);
    }

    @DeleteMapping("/ciudadparam/")
    public ResponseEntity<CiudadResponse> delParamCiudad(@Parameter(required = true, description = "El id de la ciudad") @RequestParam("id") Integer idCiudad) {
        return ciudadService.removeCiudad(idCiudad);
    }
}
