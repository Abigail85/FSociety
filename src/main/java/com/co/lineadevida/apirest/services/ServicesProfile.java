package com.co.lineadevida.apirest.services;

import com.co.lineadevida.apirest.repository.EntityEmployee;
import com.co.lineadevida.apirest.repository.EntityProfile;
import com.co.lineadevida.apirest.repository.RepositoryProfile;
import com.co.lineadevida.apirest.util.Enum_RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service

public class ServicesProfile {

    @Autowired
    RepositoryProfile repositoryProfile;


    public Optional<EntityProfile> searchProfile(Long idEmployee){
        Optional<EntityProfile> listSearch = repositoryProfile.findById(idEmployee);
        return listSearch;
    }
    public EntityProfile updateProfile( EntityProfile profile) {
        EntityEmployee employee = new EntityEmployee();
        EntityProfile updateProfile = repositoryProfile.findById(employee.getIdEmployee()).orElse(null);
        if (employee.getRole().equals(Enum_RoleName.ROLE_ADMIN) || employee.getRole().equals(Enum_RoleName.ROLE_OPERARIO)) {
            updateProfile.setUpdateAtProfile(LocalDate.now());

            if (profile.getImageProfile() != null) {
                updateProfile.setImageProfile(profile.getImageProfile());
            } else if (profile.getPhoneProfile() != null) {
                updateProfile.setPhoneProfile(profile.getPhoneProfile());
            }

        }
        repositoryProfile.save(updateProfile);
        return updateProfile;

    }



}
