package com.keyin.sdat.qap2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TournamentController {

    @Autowired
    private TournamentRepository repo;

    @GetMapping("/tournaments")
    public List<Tournament> getAllTournaments(){
        return(List<Tournament>) repo.findAll();
    }

    @GetMapping("/tournaments/{id}")
    public Tournament getTournamentById(@PathVariable long id){
        try {
            return repo.findById(id)
                    .orElseThrow(() -> new Exception("Tournament Not Found"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/new-tournament")
    public Tournament createTournament(@RequestBody Tournament tournament){

        repo.save(tournament);

        return tournament;
    }

    @PutMapping("/update-tournament/{id}")
    public Tournament updateTournament(@RequestBody Tournament newTournament, @PathVariable long id){
        return repo.findById(id)
                .map(tournament -> {
                    tournament.setCashPrizeAmount(newTournament.getCashPrizeAmount());
                    tournament.setEndDate(newTournament.getEndDate());
                    tournament.setEntryFee(newTournament.getEntryFee());
                    tournament.setLocation(newTournament.getLocation());
                    tournament.setStartDate(newTournament.getStartDate());
                    return repo.save(tournament);
                })
                .orElseGet(() -> {
                   newTournament.setTournamentId(id);
                   return repo.save(newTournament);
                });
    }

    @DeleteMapping("/delete-tournament/{id}")
    public long deleteTournament(@PathVariable long id){
        repo.deleteById(id);
        return id;
    }

}
