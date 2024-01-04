package com.controllers;

import com.dto.FiliereDTO;
import com.entities.Filiere;
import com.service.FiliereService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/filiere")
@CrossOrigin
public class FiliereController {

    @Autowired
    private FiliereService filiereService;
    @Autowired
    private ModelMapper modelMapper;
    @GetMapping(value = "getId")
    @ResponseBody
    public ResponseEntity<FiliereDTO> getById(@RequestParam int id) {
        Filiere filiere = filiereService.getById(id);
        return new ResponseEntity<>(convertToDto(filiere) , HttpStatus.OK);
    }
    @GetMapping("all")
    @ResponseBody
    public List<FiliereDTO> getAll(){
        List<Filiere> filieres = filiereService.getAll();
        return filieres.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    @PostMapping("save")
    @ResponseBody
    public ResponseEntity<FiliereDTO> save(@RequestBody FiliereDTO filiereDTO) {
        Filiere filiere = convertToEntity(filiereDTO);
        filiereService.saveOrUpdate(filiere);
        return new ResponseEntity<>(convertToDto(filiere), HttpStatus.CREATED);
    }
    @DeleteMapping("delete")
    public ResponseEntity<String> delete(@RequestParam int id){
        Filiere f = filiereService.getById(id);
        this.filiereService.delete(f);
        return new ResponseEntity<>("Filiere Deleted",HttpStatus.OK);
    }
    @PutMapping("update")
    public ResponseEntity<FiliereDTO> update(@RequestParam int id, @RequestBody FiliereDTO updatedFiliereDTO) {
        Filiere f = filiereService.getById(id);
        f = convertToEntity(updatedFiliereDTO);
        f.setId(id);
        filiereService.saveOrUpdate(f);
        return new ResponseEntity<>(convertToDto(f), HttpStatus.OK);
    }
    @GetMapping("getCode")
    @ResponseBody
    public ResponseEntity<FiliereDTO> getByCode(@RequestParam String code){
       Filiere f = this.filiereService.getByCode(code);
        return new ResponseEntity<>(convertToDto(f) , HttpStatus.OK);
    }

    private FiliereDTO convertToDto(Filiere filiere) {
        return modelMapper.map(filiere, FiliereDTO.class);
    }

    private Filiere convertToEntity(FiliereDTO filiereDTO) {
        return modelMapper.map(filiereDTO, Filiere.class);
    }
}
