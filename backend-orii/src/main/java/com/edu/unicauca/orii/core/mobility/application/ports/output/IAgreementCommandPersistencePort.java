package com.edu.unicauca.orii.core.mobility.application.ports.output;

import com.edu.unicauca.orii.core.mobility.domain.model.Agreement;

public interface IAgreementCommandPersistencePort {
     public Agreement createAgreement(Agreement agreement);
<<<<<<< HEAD
     public void deleteAgreement(Long id);
=======

     public Agreement updateAgreement(Long id, Agreement agreement);
>>>>>>> eff47b1ff95ccf0ff6cda60185f6bba08ba591fd
}
