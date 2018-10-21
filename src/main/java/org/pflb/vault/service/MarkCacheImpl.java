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
        List<Mark> marks = markRepository.getMarksByStudentIdAndCourseId(mark.getStudentId(), mark.getCourseId());
        for (Mark m:marks){
            if (mark.getDate().equals(m.getDate())){
                m.setMark(mark.getMark());
                markRepository.save(m);
                return;
            }
        }
        markRepository.save(mark);
    }

    @Override
    public List<Mark> getMarkByStudentIdAndCourseId(Long studentId, Long courseId){

        return markRepository.getMarksByStudentIdAndCourseId(studentId, courseId);
    }


//    @Override
//    public Mark getMarkByName(int mark) {       //??????????????
//        return markRepository.getMarkByName(mark);
//    }

}
