package br.com.betting.service;

import br.com.betting.entity.Championship;
import br.com.betting.exceptions.*;
import br.com.betting.repositories.ChampionshipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ChampionshipService {
    private final ChampionshipRepository championshipRepository;

    public Championship getChampionshipById(int id){
        return championshipRepository.findById(id).orElseThrow(() -> new ChampionshipNotFoundException(id));
    }

    public Championship newChamp(Championship championship) throws ChampionshipNameEmptyException, ChampionshipSeasonEmptyException {
        if(championship.getChampionship_name() == null || championship.getChampionship_name().equalsIgnoreCase(""))
            throw new ChampionshipNameEmptyException();
        if(championship.getChampionship_season() == null || championship.getChampionship_season().equalsIgnoreCase(""))
            throw new ChampionshipSeasonEmptyException();
        return championshipRepository.save(championship);
    }

    public void deleteChamp(int id){
        championshipRepository.findById(id).orElseThrow(() -> new ChampionshipNotFoundException(id));
        championshipRepository.deleteById(id);
    }

    public Championship replaceChampionship(Championship championship,int id){
        return championshipRepository.findById(id)
                .map(championship1 -> {
                    championship1.setChampionship_name(championship.getChampionship_name());
                    championship1.setChampionship_season(championship.getChampionship_season());
                    return championshipRepository.save(championship1);
                }).orElseGet(() ->{
                    championship.setChampionship_id(id);
                    return championshipRepository.save(championship);
                });
    }

    public List<Championship> getAllChampionships() throws EmptyListChampionshipException {
        if (championshipRepository.findAll().isEmpty())
            throw new EmptyListChampionshipException();
        return championshipRepository.findAll();

    }

}
