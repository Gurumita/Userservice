package com.revhire.userservice.Services;

import com.revhire.userservice.Repository.SkillsRepository;
import com.revhire.userservice.exceptions.NotFoundException;
import com.revhire.userservice.models.Skills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillsService {
    @Autowired
    SkillsRepository skillsRepository;

    public Skills createSkill(Skills skill){
        Skills existingSkill = skillsRepository.findBySkillName(skill.getSkillName());
        if (existingSkill != null) {
            return existingSkill;
        }
        return skillsRepository.save(skill);
    }

    public Skills getSkillByName(String skill){
        Skills dbSkill=skillsRepository.findBySkillName(skill);
        if(dbSkill==null){
            throw new NotFoundException("No skill with name: "+skill);
        }
        return dbSkill;
    }

    public List<Skills> getAllSkills(){
        return skillsRepository.findAll();
    }

}

