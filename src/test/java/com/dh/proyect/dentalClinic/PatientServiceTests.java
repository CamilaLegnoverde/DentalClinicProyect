package com.dh.proyect.dentalClinic;


import com.dh.proyect.dentalClinic.model.dto.AddressDTO;
import com.dh.proyect.dentalClinic.model.dto.PatientDTO;
import com.dh.proyect.dentalClinic.service.impl.PatientService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class PatientServiceTests {
    @Autowired
    PatientService patientService;
    /* ---------------------------------------------------------------------*/
                        /*Testing save patient method*/
    @Test
    public void _1_savingAPatientTest(){
        AddressDTO addressTest = new AddressDTO(1234, "Street A", "La Plata", "Buenos Aires");
        PatientDTO patientTest = new PatientDTO("patientSurname", "patientName", "patient@gmail.com", "ABC123", LocalDate.of(2022,10,8), addressTest);

        patientService.savePatient(patientTest);
    }

    /* ---------------------------------------------------------------------*/
                /*Testing search a patient by id method*/
    @Test
    public void _2_searchingAPatientByIdTest(){
        PatientDTO patientTest2 = new PatientDTO();
        patientTest2.setName("patientNameT2");
        patientTest2.setSurname("patientSurnameT2");
        patientService.savePatient(patientTest2);

        PatientDTO patientTest = patientService.findPatientById(1L);
        assertNotNull(patientTest);
    }

    /* ---------------------------------------------------------------------*/
                    /*Testing list all patients method*/
    @Test
    public void _3_patientListTest(){
        PatientDTO patientTest3 = new PatientDTO();
        patientTest3.setName("patientNameT3");
        patientTest3.setSurname("patientSurnameT3");
       patientService.savePatient(patientTest3);

        List<PatientDTO> patientTest = patientService.findAllPatients();

        assertFalse(patientTest.isEmpty());
    }

    /* ---------------------------------------------------------------------*/
                    /*Testing update patients method*/
   @Test
    public void _4_updatingPatientTest(){
        PatientDTO patientTest4 = new PatientDTO();
        patientTest4.setName("patientNameT5");
        patientTest4.setSurname("patientSurnameT5");
        patientTest4 = patientService.savePatient(patientTest4);
        patientTest4.setName("patient5UpdatedName");

        patientService.updatePatient(patientTest4);
        PatientDTO expectedResult = patientService.findPatientById(patientTest4.getId());

        assertEquals(expectedResult.getName(), patientTest4.getName());
    }
    /* ---------------------------------------------------------------------*/
}
