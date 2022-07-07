package com.dh.proyect.dentalClinic.controller;


/*@RestController
@RequestMapping("/turn")
public class TurnController {

    //Hacemos esto para instanciar turnoService y que utilice TurnoList
    @Autowired
    private TurnService turnService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DentistService dentistService;


    @GetMapping
    public ResponseEntity<List<Turn>> turnList(){
        return ResponseEntity.ok(turnService.turnList());//Acá va lo que nosotros devolvimos
    }

    @PostMapping
    public ResponseEntity<Turn> saveTurn(@RequestBody Turn turn){
        ResponseEntity<Turn> response;
        //----------------------------Controlar si los id son existentes
        //Con esto buscamos al paciente
        Optional<Patient> patient = patientService.findPatientById(turn.getPatient().getId());

        //Buscamos al odontologo
        Optional<Dentist> dentist = dentistService.findDentistById(turn.getDentist().getId());

        //Controlamos
        if (patient.isPresent() && dentist.isPresent()){ //??????????
            //Agregamos el turno
            response = ResponseEntity.ok(turnService.saveTurn(turn));
        }
        else {
            //Si no se cumple, hacemos que la respuesta cambie
            response=ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<Turn> updateTurn(@RequestBody Turn turn){
        return ResponseEntity.ok(turnService.updateTurn(turn));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTurn(@PathVariable Long id){
        ResponseEntity<String> response;
        //----------------------------Controlar si los id son existentes
        //Controlamos
        if (turnService.findTurnById(id).isPresent()){
            //Eliminamos el turno
            turnService.removeTurn(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
        }
        else {
            //Si no se cumple, hacemos que la respuesta cambie
            response=ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @GetMapping("/{id}")
    private ResponseEntity<Turn> findTurnById(@PathVariable Long id){
        if (turnService.findTurnById(id).isPresent()){
            return ResponseEntity.ok(turnService.findTurnById(id).get());
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}*/
