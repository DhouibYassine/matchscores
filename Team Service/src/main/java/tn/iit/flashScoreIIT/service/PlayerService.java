package tn.iit.flashScoreIIT.service;

import org.springframework.stereotype.Service;
import tn.iit.flashScoreIIT.exception.PlayerNotFoundException;
import tn.iit.flashScoreIIT.model.Player;
import tn.iit.flashScoreIIT.repository.PlayerDao;

import java.util.List;

@Service
public class PlayerService {
    private PlayerDao playerDao;

    public PlayerService(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }
    public List<Player> findAll() {
        return playerDao.findAll();
    }


    public Player findById(Long id) {
        return playerDao.findById(id).orElseThrow(() -> new PlayerNotFoundException(id));
    }
    public void save(Player playerToSave) {
        playerDao.save(playerToSave);
    }
    public void delete(Long id) {
        playerDao.deleteById(id);
    }
    public void update( Player newPlayer, Long id) {
        Player player = findById(id);
        player.setName(newPlayer.getName());
        player.setAge(newPlayer.getAge());
        player.setTeam(newPlayer.getTeam());
        player.setPosition(newPlayer.getPosition());
        player.setNationality(newPlayer.getNationality());
        playerDao.save(player);
    }
}
