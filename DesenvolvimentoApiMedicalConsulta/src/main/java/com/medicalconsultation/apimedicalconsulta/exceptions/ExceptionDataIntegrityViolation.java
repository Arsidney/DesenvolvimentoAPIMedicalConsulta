    package com.medicalconsultation.apimedicalconsulta.exceptions;

    public class ExceptionDataIntegrityViolation extends RuntimeException{
        public ExceptionDataIntegrityViolation(String message) {
            super(message);
        }
    }
