package edu.iteahome.springdatajpa.controller;

import edu.iteahome.springdatajpa.model.Masina;
import edu.iteahome.springdatajpa.model.Persoana;
import edu.iteahome.springdatajpa.repository.MasinaRepository;
import edu.iteahome.springdatajpa.repository.PersoanaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/demojpa")
@RestController
public class Controller {

    private PersoanaRepository persoanaRepository;
    private MasinaRepository masinaRepository;

    public Controller(PersoanaRepository persoanaRepository, MasinaRepository masinaRepository) {
        this.persoanaRepository = persoanaRepository;
        this.masinaRepository = masinaRepository;
    }

    @RequestMapping("persoana/save")
    public Persoana savePersoana(@RequestParam("nume") String nume) {
        return persoanaRepository.save(new Persoana(nume));
    }

    @RequestMapping("persoana/showAll")
    public List findAllPersons() {
        return persoanaRepository.findAll();
    }

    @RequestMapping("/persoana/{id}")
    public List gasestePersDupaId(@PathVariable("id") Long id){
        return persoanaRepository.findByCeva(id);
    }

    @RequestMapping("/persoana/delete/{nume}")
    public void deletePersDupaNume(@PathVariable("nume") String nume){
        persoanaRepository.deletePersoanaByNume(nume);
    }

    @RequestMapping("/persoana/masina/{marca}")
    public List findePersCareAuMasiniOAnumintaMarca(@PathVariable("marca") String marca){
        return persoanaRepository.findByMasinaMarca(marca);
    }

    @RequestMapping("masina/save")
    public Masina saveMasina(@RequestParam("marca") String marca, @RequestParam("nrInm") String nrInmatri, @RequestParam("anFab") Integer anFab, @RequestParam("idPers") Long idPers) {
        Persoana p = persoanaRepository.findById(idPers).get();
        return masinaRepository.save(new Masina(nrInmatri, marca, anFab, p));
    }


    @RequestMapping("masina/showAll")
    public List showAllCars() {
        return masinaRepository.findAll();
    }

    @RequestMapping("masina/exists/{marca}")
    public boolean findCarByMarca(@PathVariable("marca") String marca) {
        return masinaRepository.existsByMarca(marca);
    }

    @RequestMapping("masina/pagingExample")
    public Page<Masina> pagingExample(@RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("sortBy") String sortField) {
        Sort sort = Sort.by(sortField);
        Pageable paging = PageRequest.of(page, size, sort);
        return masinaRepository.findAll(paging);
    }

}
