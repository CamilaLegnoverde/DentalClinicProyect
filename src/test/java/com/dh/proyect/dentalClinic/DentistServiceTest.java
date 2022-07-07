package com.dh.proyect.dentalClinic;

import com.dh.proyect.dentalClinic.model.dto.DentistDTO;
import com.dh.proyect.dentalClinic.model.dto.PatientDTO;
import com.dh.proyect.dentalClinic.service.impl.DentistService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class DentistServiceTest {
    @Autowired
    DentistService dentistService;
    /* ---------------------------------------------------------------------*/
    /*Testing save dentist method*/
    @Test
    public void _1_savingADentistTest(){
        DentistDTO dentistDTO = new DentistDTO("dentistSurname", "dentistName", "ABC123");

        assertNotNull(dentistService.saveDentist(dentistDTO));
    }
    /* ---------------------------------------------------------------------*/
    /*Testing list all dentists*/
    @Test
    public void _2_listAllDentistsTest(){
        DentistDTO dentistDTOT2 = new DentistDTO("dentistSurnameT2", "dentistNameT2", "ABC123");
        DentistDTO dentistDTOT3 = new DentistDTO("dentistSurnameT3", "dentistNameT3", "DEF456");
        DentistDTO dentistDTOT4 = new DentistDTO("dentistSurnameT3", "dentistNameT3", "GHI789");

        dentistService.saveDentist(dentistDTOT2);
        dentistService.saveDentist(dentistDTOT3);
        dentistService.saveDentist(dentistDTOT4);

        List<DentistDTO> dentistDTOList = dentistService.dentistList();

        assertFalse(dentistDTOList.isEmpty());
        assertTrue(dentistDTOList.size() > 0);
    }

    /* ---------------------------------------------------------------------*/
    /*Testing update dentists*/
    @Test
    public void _3_updateADentistTest(){
        DentistDTO dentistDTO4 = new DentistDTO("dentistSurnameT4", "dentistNameT4", "JKL123");
        DentistDTO dentistFirstResult = dentistService.saveDentist(dentistDTO4);

        dentistDTO4.setName("dentistNameUpdateTest");
        DentistDTO dentistExpectedResult = dentistService.updateDentist(dentistDTO4);

        assertEquals(dentistFirstResult, dentistExpectedResult);
    }

    /* ---------------------------------------------------------------------*/
    /*Testing find dentists by id*/
    @Test
    public void _4_findDentistByIdTest(){
        DentistDTO dentistDTO5 = new DentistDTO("dentistSurnameT5", "dentistNameT5", "MNO456");
        DentistDTO expectedDentist = dentistService.saveDentist(dentistDTO5);

        DentistDTO dentistExistingTest = dentistService.findDentistById(expectedDentist.getId());

        assertNotNull(dentistExistingTest);

    }
}
