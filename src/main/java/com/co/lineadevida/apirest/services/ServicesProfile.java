package com.co.lineadevida.apirest.services;

import com.co.lineadevida.apirest.models.EntityEmployee;
import com.co.lineadevida.apirest.models.EntityProfile;
import com.co.lineadevida.apirest.repository.RepositoryProfile;
import com.co.lineadevida.apirest.util.Enum_RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service

public class ServicesProfile {
private String mensaje;
    @Autowired
    RepositoryProfile repositoryProfile;

    public List<EntityProfile> listOfAllProfile() {
        List<EntityProfile> listProfiles = repositoryProfile.findAll();
        return listProfiles;
    }
    public EntityProfile searchProfile(Long id){
        EntityProfile searchProfile = repositoryProfile.findById(id).orElse(null);
        return searchProfile;
    }

    public EntityProfile insertProfile(EntityEmployee employee) {
         EntityProfile profile = new EntityProfile();
          profile.setCreatedAtProfile(LocalDate.now());
          profile.setIdProfile(employee.getIdEmployee());
          profile.setIdEmployee(employee);
          repositoryProfile.save(profile);
         return profile;



    }
    public EntityProfile updateProfile( EntityProfile profile) {


        EntityProfile updateProfile = repositoryProfile.findById(profile.getIdProfile()).orElse(null);


        if(updateProfile ==  null){
            updateProfile.setMensaje("Algo fallo, intentelo nuevamente");
            }else if (profile.getImageProfile()!=null) {
                updateProfile.setUpdateAtProfile(LocalDate.now());
                repositoryProfile.existsById(profile.getIdProfile());

           } else if (profile.getPhoneProfile() != null) {
                updateProfile.setPhoneProfile(profile.getPhoneProfile());
                repositoryProfile.existsById(profile.getIdProfile());


        }

        repositoryProfile.save(updateProfile);

        return updateProfile;

    }



}
