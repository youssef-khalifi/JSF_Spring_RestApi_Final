package com.controllers;

import com.dto.EtudiantDTO;
import com.dto.FiliereDTO;
import com.entities.Etudiant;
import com.entities.Filiere;
import com.service.EtudiantService;
import com.service.FiliereService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/etudiant")
@CrossOrigin
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;
    @Autowired
    private FiliereService filiereService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("save")
    @ResponseBody
    public ResponseEntity<EtudiantDTO> saveEtudiant(@RequestBody EtudiantDTO etudiantDTO) {
        Etudiant etudiant = convertToEntity(etudiantDTO);
        Filiere f = this.filiereService.getByCode(etudiantDTO.getFiliere());
        etudiant.setFiliere(f);
        etudiantService.saveOrUpdate(etudiant);
        return new ResponseEntity<>(convertToDto(etudiant), HttpStatus.CREATED);
    }

    @GetMapping("all")
    @ResponseBody
    public List<EtudiantDTO> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantService.getAll();
        return etudiants.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    @GetMapping("getId")
    @ResponseBody
    public ResponseEntity<EtudiantDTO> getEtudiantById(@RequestParam int id) {
        Etudiant etudiant = etudiantService.getById(id);
        return new ResponseEntity<>(convertToDto(etudiant), HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> delete(@RequestParam int id){
        Etudiant e =  this.etudiantService.getById(id);
        this.etudiantService.delete(e);
        return new ResponseEntity<>("Etudiant Deleted" , HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<EtudiantDTO> updateEtudiant(@RequestParam int id, @RequestBody EtudiantDTO updatedEtudiantDTO) {
        Filiere f = this.filiereService.getByCode(updatedEtudiantDTO.getFiliere());
        Etudiant etudiant = etudiantService.getById(id);
        etudiant = convertToEntity(updatedEtudiantDTO);
        etudiant.setId(id);
        etudiant.setFiliere(f);
        etudiantService.saveOrUpdate(etudiant);
        return new ResponseEntity<>(convertToDto(etudiant), HttpStatus.OK);
    }




    private EtudiantDTO convertToDto(Etudiant etudiant) {
        EtudiantDTO etudiantDTO = modelMapper.map(etudiant, EtudiantDTO.class);
        etudiantDTO.setFiliere(etudiant.getFiliere().getCode());
        return etudiantDTO;
    }
    private FiliereDTO convertToDto(Filiere filiere) {
        return modelMapper.map(filiere, FiliereDTO.class);
    }
    private Etudiant convertToEntity(EtudiantDTO etudiantDTO) {
        return modelMapper.map(etudiantDTO, Etudiant.class);
    }

}
