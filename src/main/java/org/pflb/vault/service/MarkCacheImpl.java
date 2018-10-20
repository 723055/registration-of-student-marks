package org.pflb.vault.service;

import org.pflb.vault.model.Mark;
import org.pflb.vault.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("persistent_mark")

public class MarkCacheImpl implements MarkCache {

    @Autowired
    MarkRepository markRepository;

    @Override
    public void saveMark(Mark mark) {
        markRepository.save(mark);

    }

    @Override
    public List<Mark> getMarkByStudentId(Long studentId) {
        return markRepository.getMarksByStudentId(studentId);
    }


//    @Override
//    public Mark getMarkByName(int mark) {       //??????????????
//        return markRepository.getMarkByName(mark);
//    }

}
