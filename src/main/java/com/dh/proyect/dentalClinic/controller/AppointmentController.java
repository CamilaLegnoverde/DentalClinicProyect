package com.dh.proyect.dentalClinic.controller;


import com.dh.proyect.dentalClinic.model.dto.DentistDTO;
import com.dh.proyect.dentalClinic.model.dto.PatientDTO;
import com.dh.proyect.dentalClinic.model.dto.AppointmentDTO;
import com.dh.proyect.dentalClinic.service.impl.DentistService;
import com.dh.proyect.dentalClinic.service.impl.PatientService;
import com.dh.proyect.dentalClinic.service.impl.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turn")
public class AppointmentController {

    //Hacemos esto para instanciar turnoService y que utilice TurnoList
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DentistService dentistService;

    /* ---------------------------------------------------------------------*/
    /*List all appointments*/
    @GetMapping
    public List<AppointmentDTO> appointmentList(){
        return appointmentService.appointmentList();//Acá va lo que nosotros devolvimos
    }

    /* ---------------------------------------------------------------------*/
    /*Save an appointment*/
    @PostMapping
    public ResponseEntity<AppointmentDTO> saveAppointment(@RequestBody AppointmentDTO appointmentDTO){
        ResponseEntity<AppointmentDTO> response;
        //----------------------------Controlar si los id son existentes
        //Con esto buscamos al paciente
        PatientDTO patientDTO = patientService.findPatientById(appointmentDTO.getPatient().getId());

        //Buscamos al odontologo
        DentistDTO dentistDTO = dentistService.findDentistById(appointmentDTO.getDentist().getId());

        //Controlamos
        if (patientDTO != null && dentistDTO != null){ //??????????
            //Agregamos el turno
            response = ResponseEntity.ok(appointmentService.saveAppointment(appointmentDTO));
        }
        else {
            //Si no se cumple, hacemos que la respuesta cambie
            response=ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

    /* ---------------------------------------------------------------------*/
    /*Update an appointment*/
    @PutMapping
    public ResponseEntity<AppointmentDTO> updateAppointment(@RequestBody AppointmentDTO appointmentDTO){
        ResponseEntity<AppointmentDTO> response;
        if (appointmentService.findAppointmentById(appointmentDTO.getId()) != null){
            response = ResponseEntity.ok(appointmentService.updateAppointment(appointmentDTO));
        }
        else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    /* ---------------------------------------------------------------------*/
    /*Delete an appointment*/
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long id){
        ResponseEntity<String> response;
        //----------------------------Controlar si los id son existentes
        //Controlamos
        if (appointmentService.findAppointmentById(id) != null){
            //Eliminamos el turno
            appointmentService.removeAppointment(id);
            response = ResponseEntity.ok("Deleted appointment with id: " + id);
        }
        else {
            //Si no se cumple, hacemos que la respuesta cambie
            response=ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    /* ---------------------------------------------------------------------*/
    /*Find appointment by id*/
    @GetMapping("/{id}")
    private ResponseEntity<AppointmentDTO> findAppointmentById(@PathVariable Long id){
        if (appointmentService.findAppointmentById(id) != null){
            return ResponseEntity.ok(appointmentService.findAppointmentById(id));
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    /* ---------------------------------------------------------------------*/
}
