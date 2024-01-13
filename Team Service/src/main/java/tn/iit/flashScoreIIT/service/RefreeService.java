package tn.iit.flashScoreIIT.service;

import org.springframework.stereotype.Service;
import tn.iit.flashScoreIIT.exception.RefreeNotFoundException;
import tn.iit.flashScoreIIT.model.Refree;
import tn.iit.flashScoreIIT.repository.RefreeDao;

import java.util.List;

@Service
public class RefreeService {
    private RefreeDao refreeDao;

    public RefreeService(RefreeDao refreeDao) {
        this.refreeDao = refreeDao;
    }
    public List<Refree> findAll() {
        return refreeDao.findAll();
    }
    public Refree findById(Long id) {
        return refreeDao.findById(id).orElseThrow(() -> new RefreeNotFoundException(id));
    }
    public void save(Refree refreeToSave) {
        refreeDao.save(refreeToSave);
    }
    public void delete(Long id) {
        refreeDao.deleteById(id);
    }
    public void update( Refree newRefree, Long id) {
        Refree refree = findById(id);
        refree.setName(newRefree.getName());
        refree.setAge(newRefree.getAge());
        refreeDao.save(refree);
    }
}
