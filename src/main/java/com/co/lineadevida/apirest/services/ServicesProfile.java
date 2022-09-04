package com.co.lineadevida.apirest.services;

import com.co.lineadevida.apirest.repository.EntityEmployee;
import com.co.lineadevida.apirest.repository.EntityProfile;
import com.co.lineadevida.apirest.repository.RepositoryProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service

public class ServicesProfile {

    @Autowired
    RepositoryProfile repositoryProfile;

    public Boolean createProfile(EntityProfile profile){
        try {
            repositoryProfile.save(profile);
        }catch (Exception e){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
    public Optional<EntityProfile> searchProfile(Long idProfile){
        Optional<EntityProfile> listSearch = repositoryProfile.findById(idProfile);
        return listSearch;
    }


    public EntityProfile updateProfile(EntityProfile profile){
        EntityProfile updateProfile = repositoryProfile.findById(profile.getIdProfile()).orElse(null);
        while (updateProfile.equals(updateProfile))
            updateProfile.setUpdateAtProfile(LocalDate.now());

        if (profile.getImageProfile()!=null){
                updateProfile.setImageProfile(profile.getImageProfile());
            } else if (profile.getPhoneProfile()!=null){
                updateProfile.setPhoneProfile(profile.getPhoneProfile());
            }

            repositoryProfile.save(updateProfile);
        return updateProfile;
    }
}
